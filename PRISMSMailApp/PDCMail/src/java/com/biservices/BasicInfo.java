/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biservices;

import dbcall.CallDBQuery;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 *
 * @author DineshkumarP
 */
public class BasicInfo {

////    TEST    
//    public static String BI_USER_NAME = "finance";
//    public static String BI_PASSWORD = "Welcome123";
//    public static String BI_SERVICE_URL = "https://ejds-test.fa.em2.oraclecloud.com"; 

//  PROD    
//    public static String BI_USER_NAME="finance";
//    public static String BI_PASSWORD="Omniyat@20";
//    public static String BI_SERVICE_URL="https://ejds.fa.em2.oraclecloud.com";
    
    
    public static String getCurrentDate() {

        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy  hh:mm:ss");
        String strDate = dateFormat.format(date); 
        return strDate;
      //return "12-10-2019";

    }

    public static String getOneDayBeforeUTC() {
      DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy  hh:mm:ss");
      dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
      Calendar cal = Calendar.getInstance(); 
      cal = Calendar.getInstance();
      cal.add(Calendar.DATE, -365); 
//      cal.add(Calendar.DATE, -1859); 
      String fromDate = dateFormat.format(cal.getTime());       
      return fromDate;
    } 
    
    public static String getBIReportPath(String reportName) {
        String reportPath = "null";

        if (reportName.equalsIgnoreCase("RECEIPT_HDR_ACCOUNTS")) {

            reportPath = "/Custom/Property Lease/Reports/AR Receipt Header Accounting Report";

        } else if (reportName.equalsIgnoreCase("RECEIPT_APP_ACCOUNTS")) {

            reportPath = "/Custom/Property Lease/Reports/AR Receipt Application Accounting Report";

        }else if (reportName.equalsIgnoreCase("INVOICE_HDR_ACCOUNTS")) {

            reportPath = "/Custom/Property Lease/Reports/Trx_Sync_AR_Report";

        }else {
            reportPath = "null";
        }
        return reportPath;
    }
     public static ArrayList getCredentials(){
        ArrayList<String> credentials = new ArrayList<String>();
        credentials = CallDBQuery.getLoginInfo();
        return credentials;
    }
}
