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
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DineshkumarP
 */
public class DueDateMail implements Job {

//    public String send(Mail mailBody) {
    /**
     *
     * @param job
     * @throws JobExecutionException
     */
    @Override
    public void execute(JobExecutionContext job) throws JobExecutionException {
        System.out.println("Excute in Interface Error !");
        sendDuedateReport();
    }

    public String sendDuedateReport() {

        final String username = "prismalerts@omniyat.com";
        final String password = "Or@cl3alert";
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.office365.com");
        props.put("mail.smtp.port", "587");

        String toAddress = CallDBQuery.getAddressFordueMail("TO");
        String ccAddress = CallDBQuery.getAddressFordueMail("CC");
        String bccAdress = CallDBQuery.getAddressFordueMail("BCC");

        System.out.println("TO"+toAddress);
        System.out.println("CC"+ccAddress);
        System.out.println("BC"+bccAdress);
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
        String subject = "Daily Due Date Report - " + getSysdate("dd-MMM-yyyy");
        Object mailContent = ErrorStatusHTML.getDueMailBdy();
        String attachmentName = "Daily Due Date Report.xlsx";
        //path need to change
         String filePath = "/u01/data/reports/Daily_Due_Notification.rtf";
//        String filePath = "D://Dinesh//doc/daily_due_temp.rtf";
        //pkg need to change
        String xmlData = CallDBQuery.getDueDate(getSysdate("dd-MMM-yyyy"));
        
        if("NO_DATA".equals(xmlData)){ 
            xmlData = CallDBQuery.getEmptyDialyDueDateXml();
        }
        System.out.println("RTF");
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

