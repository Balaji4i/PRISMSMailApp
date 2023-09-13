/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biservices;

import java.util.ArrayList;

/**
 *
 * @author DineshkumarP
 */
public class PayloadServices {
    
    static ArrayList<String> credentials = new ArrayList<String>(); 

    public static String getPayload(String reportName) { 
        String payload = "Default payload !";
        credentials = BasicInfo.getCredentials();
//        String SERVICE_URL = credentials.get(0);
        String BI_USER_NAME = credentials.get(1);
        String BI_PASS = credentials.get(2);
//        String BI_USER_NAME = BasicInfo.BI_USER_NAME;
//        String BI_PASS = BasicInfo.BI_PASSWORD;
        String BI_FROM_DATE = BasicInfo.getOneDayBeforeUTC();
        String BI_PATH = BasicInfo.getBIReportPath(reportName);
        if (BI_PATH.contains("null")) {
            payload = "Error in path !";
        } else {

            payload = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:pub=\"http://xmlns.oracle.com/oxp/service/PublicReportService\">\n"
                    + "   <soapenv:Header/>\n"
                    + "   <soapenv:Body>\n"
                    + "      <pub:runReport>\n"
                    + "         <pub:reportRequest>\n"
                    + "            <pub:parameterNameValues>\n"
                    + "               <pub:item>\n"
                    + "                  <pub:name>p_last_update_date</pub:name>\n"
                    + "                  <pub:values>\n"
                    + "                     <pub:item>" + BI_FROM_DATE + "</pub:item>\n"
                    + "                  </pub:values>\n"
                    + "               </pub:item>\n"
                    + "            </pub:parameterNameValues>\n"
                    + "            <pub:reportAbsolutePath>" + BI_PATH + ".xdo</pub:reportAbsolutePath>\n"
                    + "         </pub:reportRequest>\n"
                    + "         <pub:userID>" + BI_USER_NAME + "</pub:userID>\n"
                    + "         <pub:password>" + BI_PASS + "</pub:password>\n"
                    + "      </pub:runReport>\n"
                    + "   </soapenv:Body>\n"
                    + "</soapenv:Envelope>";
        }  
        return payload;
    }
}
