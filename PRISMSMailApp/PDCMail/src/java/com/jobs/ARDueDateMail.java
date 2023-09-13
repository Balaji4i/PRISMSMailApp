/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jobs;
import com.html.ErrorStatusHTML;
import com.mail.GenericSendMail;
import com.reports.RTFServices;
import dbcall.CallDBQuery;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.BodyPart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import javax.mail.util.ByteArrayDataSource;

/**
 *
 * @author DineshkumarP
 */
public class ARDueDateMail implements Job {

//    public String send(Mail mailBody) {
    /**
     *
     * @param job
     * @throws JobExecutionException
     */
    @Override
    public void execute(JobExecutionContext job) throws JobExecutionException {
        System.out.println("Excute in Interface Error !");
        sendARDuedateReport();
    }

    public String sendARDuedateReport() {

        final String username = "prismalerts@omniyat.com";
        final String password = "Or@cl3alert";
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.office365.com");
        props.put("mail.smtp.port", "587");

        String toAddress = CallDBQuery.getAddressForWeeklyDue("TO");
        String ccAddress = CallDBQuery.getAddressForWeeklyDue("CC");
        String bccAdress = CallDBQuery.getAddressForWeeklyDue("BCC");

        /**
         * If there is no data in DB it will refer below mails.
         */
        if ("".equals(toAddress)) {
            toAddress = "dineshkumar.p@4iapps.com,ibrahim.hb@4iapps.com";
        }
         if ("".equals(ccAddress)) {
            ccAddress = "dineshkumar.p@4iapps.com,ibrahim.hb@4iapps.com";
        }
        if ("".equals(bccAdress)) {
            bccAdress = "dineshkumar.p@4iapps.com,ibrahim.hb@4iapps.com";
        }

// For local testing..

/*      
        if ("".equals(toAddress)) {
            toAddress = "ibrahim.hb@4iapps.com";
        }
         if ("".equals(ccAddress)) {
            ccAddress = "dineshkumar.p@4iapps.com";
        }
        if ("".equals(toAddress)) {
            bccAdress = "";
        }
*/
        String subject = "Weekly AR Due Date Report - " + getSysdate("dd-MMM-yyyy");
        Object mailContent = ErrorStatusHTML.getWeeklyDueMailBdy();
        String attachmentName = "Weekly AR Due Date Report.xlsx";
        String filePath = "/u01/data/reports/AR-Detail.rtf";
//          String filePath = "C://Users//DineshkumarP//Downloads/AR-Detail.rtf";
        String xmlData = CallDBQuery.getWeeklyDueDate(getSysdate("dd-MMM-yyyy"));
        
//        if("NO_DATA".equals(xmlData)){ 
//            xmlData = CallDBQuery.getEmptyPdcXml();
//        } 
       
        byte[] bytes = RTFServices.rtfReport(xmlData, filePath);  

        String result = GenericSendMail.sendWithAttachment(username, password, props, bytes, toAddress, ccAddress, bccAdress, subject, mailContent, attachmentName);        

        return result; 
    }

    public String getSysdate(String format) {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        String strDate = formatter.format(date);
        return strDate;
    }

}

