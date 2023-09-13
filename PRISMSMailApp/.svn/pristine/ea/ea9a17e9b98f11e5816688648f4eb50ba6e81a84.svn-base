
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jobs;

import com.html.ErrorStatusHTML;
import com.html.PdcDueHTML;
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
 * @author Ibrahim
 */
public class PdcDueMail implements Job {

//    public String send(Mail mailBody) {
    /**
     *
     * @param job
     * @throws JobExecutionException
     */
    @Override
    public void execute(JobExecutionContext job) throws JobExecutionException {
        System.out.println("Excute in PDC Due !");
        sendPdcDueMail("Y");
    }

    public String sendPdcDueMail(String allDue) {

        final String username = "prismalerts@omniyat.com";
        final String password = "Or@cl3alert";
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.office365.com");
        props.put("mail.smtp.port", "587");

        String toAddress = CallDBQuery.getAddressForPdcDue("TO");
        String ccAddress = CallDBQuery.getAddressForPdcDue("CC");
        String bccAdress = CallDBQuery.getAddressForPdcDue("BCC");

        /**
         * If there is no data in DB it will refer below mails.
         */
        if ("".equals(toAddress)) {
            toAddress = "ibrahim.hb@4iapps.com";
        }
         if ("".equals(ccAddress)) {
            ccAddress = "ibrahim.hb@4iapps.com";
        }
        if ("".equals(bccAdress)) {
            bccAdress = "ibrahim.hb@4iapps.com";
        }

  
        String subject = "PDC Due Alert - " + getSysdate("dd-MMM-yyyy");
        Object mailContent = PdcDueHTML.getMailBdy();
        String attachmentName = "PdcDueReport.xlsx";
        String filePath = "/u01/data/reports/PDC_Due_Alert.rtf"; 
//        String filePath = "E:/rtf/PDC_Due_Alert.rtf";    //// local path ibrahim system

        String xmlData = CallDBQuery.getPdcDueXml(allDue);  
        
        if("NO_DATA".equals(xmlData)){ 
            xmlData = CallDBQuery.getEmptyPdcXml();
        } 
        byte[] bytes = RTFServices.rtfReport(xmlData, filePath);  
        
        String result = GenericSendMail.sendWithAttachment(username, password, props, bytes, toAddress, ccAddress, bccAdress, subject, mailContent, attachmentName);        
//        String result = "00";
        return result;
    }

    public String getSysdate(String format) {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        String strDate = formatter.format(date);
        return strDate;
    }

}
