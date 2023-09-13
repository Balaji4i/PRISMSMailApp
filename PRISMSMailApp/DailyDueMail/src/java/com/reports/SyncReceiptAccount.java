/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reports;

import com.biservices.BasicInfo;
import com.biservices.InvokeServices;
import com.biservices.PayloadServices;
import dbcall.CallDBQuery;
import java.util.ArrayList;
import javax.ws.rs.core.Response;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 *
 * @author Ibrahim
 */
public class SyncReceiptAccount implements Job {

    InvokeServices invokeBI = new InvokeServices();
    static ArrayList<String> credentials = new ArrayList<String>(); 
//    String SERVICE_URL = BasicInfo.BI_SERVICE_URL;

    /**
     *
     * @param job
     * @throws JobExecutionException
     */
    @Override
    public void execute(JobExecutionContext job) throws JobExecutionException {
        System.out.println("Now in execute");
        receiptSyncServices("RECEIPT_HDR_ACCOUNTS");
        receiptSyncServices("RECEIPT_APP_ACCOUNTS");
        receiptSyncServices("INVOICE_HDR_ACCOUNTS");
    }

    public String receiptSyncServices(String reportName) {
        try {   
            credentials = BasicInfo.getCredentials();
            String SERVICE_URL = credentials.get(0);
            String SyncResult = "Default";
            String xmlData = PayloadServices.getPayload(reportName);   
            if (xmlData.startsWith("Error")) {
                System.out.println("xmlData_________________>>>"+xmlData);
                System.out.println("Error in " + reportName);
                SyncResult = "Error in " + reportName;
            } else { 
                String reportResponse = invokeBI.invokeReport(xmlData, SERVICE_URL); 
                System.out.println("reportResponse_________________>>>"+reportResponse);
                if (reportResponse.contains("<G_1>")) {
                    String packageName = reportName; 
                    SyncResult = CallDBQuery.receiptSyncData(packageName, reportResponse);

                } else {
                    SyncResult = "No data found in report";
                }
            }  
            return SyncResult;
        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }
    }

}
