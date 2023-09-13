/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mail;

import com.jobs.SendMail;
import com.reports.RTFServices;
import dbcall.CallDBQuery;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

/**
 *
 * @author Ibrahim
 */
public class GenericSendMail {

    public static String sendWithAttachment(String username, String password, Properties props, byte[] bytes,
            String toAddress, String ccAddress, String bccAddress,  String subject, Object mailContent, String fileName) {

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
           
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toAddress));
            message.setRecipients(Message.RecipientType.CC, InternetAddress.parse(ccAddress));
            message.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(bccAddress));

            message.setSubject(subject);
            DataSource dataSource = new ByteArrayDataSource(bytes, "application/pdf");
            MimeBodyPart pdfBodyPart = new MimeBodyPart();
            pdfBodyPart.setDataHandler(new DataHandler(dataSource));
            pdfBodyPart.setFileName(fileName);
            BodyPart textBodyPart = new MimeBodyPart();
            textBodyPart.setContent(mailContent, "text/html");
            MimeMultipart mimeMultipart = new MimeMultipart();
            mimeMultipart.addBodyPart(textBodyPart);
            mimeMultipart.addBodyPart(pdfBodyPart);
            message.setContent(mimeMultipart);

            Transport.send(message);
            System.out.println("Mail Send");
            return "Mail Send Successfully";
 
        } catch (AddressException ex) {
            Logger.getLogger(SendMail.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error 1"+ex.toString());
            return "Error : " + ex.toString();
        } catch (MessagingException ex) {
            Logger.getLogger(SendMail.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error 2"+ex.toString());
            return "Error : " + ex.toString();
        } catch (Exception e) {
            System.out.println("Error 3"+e.toString());
            return "Error : " + e.toString();
        }
    } 
}
