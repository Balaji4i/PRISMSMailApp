/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mail;

import com.jobs.SendMail;
import com.jobs.UnitPriceListMail;
import com.reports.RTFServices;
import dbcall.CallDBQuery;
import java.io.File;
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
//            pdfBodyPart.attachFile(new File(dataSource));
            pdfBodyPart.setFileName(fileName);
            MimeBodyPart textBodyPart = new MimeBodyPart();
            textBodyPart.setContent(mailContent, "text/html; charset=UTF-8");
            MimeMultipart mimeMultipart = new MimeMultipart();
            mimeMultipart.addBodyPart(textBodyPart);
            mimeMultipart.addBodyPart(pdfBodyPart);
            message.setContent(mimeMultipart);

            Transport.send(message);
            return "Mail Send Successfully";
 
        } catch (AddressException ex) {
            Logger.getLogger(SendMail.class.getName()).log(Level.SEVERE, null, ex);
            return "Error : " + ex.toString();
        } catch (MessagingException ex) {
            Logger.getLogger(SendMail.class.getName()).log(Level.SEVERE, null, ex);
            return "Error : " + ex.toString();
        } catch (Exception e) {
            return "Error : " + e.toString();
        }
    } 
    
    public static String sendWithMultipleAttachment(String username, String password, Properties props, byte[] bytes,byte[] bytes1,byte[] bytes2,byte[] bytes3,byte[] bytes4,byte[] bytes5,byte[] bytes6,
            String toAddress, String ccAddress, String bccAddress,  String subject, Object mailContent, String fileName,String fileName1,String fileName2,String fileName3,String fileName4,String fileName5,String fileName6) {

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
           
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toAddress));
            message.setRecipients(Message.RecipientType.CC, InternetAddress.parse(ccAddress));
            message.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(bccAddress));

            message.setSubject(subject);
            DataSource dataSource = new ByteArrayDataSource(bytes, "application/pdf");
            DataSource dataSource1 = new ByteArrayDataSource(bytes1, "application/pdf");
            DataSource dataSource2 = new ByteArrayDataSource(bytes2, "application/pdf");
            DataSource dataSource3 = new ByteArrayDataSource(bytes3, "application/pdf");
            DataSource dataSource4 = new ByteArrayDataSource(bytes4, "application/pdf");
            DataSource dataSource5 = new ByteArrayDataSource(bytes5, "application/pdf");
            DataSource dataSource6 = new ByteArrayDataSource(bytes6, "application/pdf");
            MimeBodyPart pdfBodyPart = new MimeBodyPart();
            MimeBodyPart pdfBodyPart1 = new MimeBodyPart();
            MimeBodyPart pdfBodyPart2 = new MimeBodyPart();
            MimeBodyPart pdfBodyPart3 = new MimeBodyPart();
            MimeBodyPart pdfBodyPart4 = new MimeBodyPart();
            MimeBodyPart pdfBodyPart5 = new MimeBodyPart();
            MimeBodyPart pdfBodyPart6 = new MimeBodyPart();
            pdfBodyPart.setDataHandler(new DataHandler(dataSource));
            pdfBodyPart1.setDataHandler(new DataHandler(dataSource1));
            pdfBodyPart2.setDataHandler(new DataHandler(dataSource2));
            pdfBodyPart3.setDataHandler(new DataHandler(dataSource3));
            pdfBodyPart4.setDataHandler(new DataHandler(dataSource4));
            pdfBodyPart5.setDataHandler(new DataHandler(dataSource5));
            pdfBodyPart6.setDataHandler(new DataHandler(dataSource6));
            pdfBodyPart.setFileName(fileName);
            pdfBodyPart1.setFileName(fileName1);
            pdfBodyPart2.setFileName(fileName2);
            pdfBodyPart3.setFileName(fileName3);
             pdfBodyPart4.setFileName(fileName4);
            pdfBodyPart5.setFileName(fileName5);
            pdfBodyPart6.setFileName(fileName6);
            BodyPart textBodyPart = new MimeBodyPart();
            textBodyPart.setContent(mailContent, "text/html; charset=UTF-8");
            MimeMultipart mimeMultipart = new MimeMultipart();
            mimeMultipart.addBodyPart(textBodyPart);
            mimeMultipart.addBodyPart(pdfBodyPart);
            mimeMultipart.addBodyPart(pdfBodyPart1);
            mimeMultipart.addBodyPart(pdfBodyPart2);
            mimeMultipart.addBodyPart(pdfBodyPart3);
            mimeMultipart.addBodyPart(pdfBodyPart4);
            mimeMultipart.addBodyPart(pdfBodyPart5);
            mimeMultipart.addBodyPart(pdfBodyPart6);
            message.setContent(mimeMultipart);

            Transport.send(message);
            return "Mail Send Successfully";
 
        } catch (AddressException ex) {
            Logger.getLogger(UnitPriceListMail.class.getName()).log(Level.SEVERE, null, ex);
            return "AddressExceptionError : " + ex.toString();
        } catch (MessagingException ex) {
            Logger.getLogger(UnitPriceListMail.class.getName()).log(Level.SEVERE, null, ex);
            return "MessagingExceptionError : " + ex.toString();
        } catch (Exception e) {
            return "Error : " + e.toString();
        }
    } 
    
    public static String sendWithMultipleAttachment1(String username, String password, Properties props, byte[] bytes1,
            String toAddress, String ccAddress, String bccAddress,  String subject, Object mailContent, String fileName1) {

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
           
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toAddress));
            message.setRecipients(Message.RecipientType.CC, InternetAddress.parse(ccAddress));
            message.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(bccAddress));

            message.setSubject(subject);
            DataSource dataSource1 = new ByteArrayDataSource(bytes1, "application/pdf");
            MimeBodyPart pdfBodyPart1 = new MimeBodyPart();
            pdfBodyPart1.setDataHandler(new DataHandler(dataSource1));
            pdfBodyPart1.setFileName(fileName1);
            BodyPart textBodyPart = new MimeBodyPart();
            textBodyPart.setContent(mailContent, "text/html; charset=UTF-8");
            MimeMultipart mimeMultipart = new MimeMultipart();
            mimeMultipart.addBodyPart(textBodyPart);
            mimeMultipart.addBodyPart(pdfBodyPart1);
            message.setContent(mimeMultipart);

            Transport.send(message);
            return "Mail Send Successfully";
 
        } catch (AddressException ex) {
            Logger.getLogger(UnitPriceListMail.class.getName()).log(Level.SEVERE, null, ex);
            return "AddressExceptionError : " + ex.toString();
        } catch (MessagingException ex) {
            Logger.getLogger(UnitPriceListMail.class.getName()).log(Level.SEVERE, null, ex);
            return "MessagingExceptionError : " + ex.toString();
        } catch (Exception e) {
            return "Error : " + e.toString();
        }
    }
    public static String sendWithMultipleAttachment2(String username, String password, Properties props, byte[] bytes1,byte[] bytes2,
            String toAddress, String ccAddress, String bccAddress,  String subject, Object mailContent, String fileName1,String fileName2) {

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
           
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toAddress));
            message.setRecipients(Message.RecipientType.CC, InternetAddress.parse(ccAddress));
            message.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(bccAddress));

            message.setSubject(subject);
            DataSource dataSource1 = new ByteArrayDataSource(bytes1, "application/pdf");
            DataSource dataSource2 = new ByteArrayDataSource(bytes2, "application/pdf");
            MimeBodyPart pdfBodyPart1 = new MimeBodyPart();
            MimeBodyPart pdfBodyPart2 = new MimeBodyPart();
            pdfBodyPart1.setDataHandler(new DataHandler(dataSource1));
            pdfBodyPart2.setDataHandler(new DataHandler(dataSource2));
            pdfBodyPart1.setFileName(fileName1);
            pdfBodyPart2.setFileName(fileName2);
            BodyPart textBodyPart = new MimeBodyPart();
            textBodyPart.setContent(mailContent, "text/html; charset=UTF-8");
            MimeMultipart mimeMultipart = new MimeMultipart();
            mimeMultipart.addBodyPart(textBodyPart);
            mimeMultipart.addBodyPart(pdfBodyPart1);
            mimeMultipart.addBodyPart(pdfBodyPart2);
            message.setContent(mimeMultipart);

            Transport.send(message);
            return "Mail Send Successfully";
 
        } catch (AddressException ex) {
            Logger.getLogger(UnitPriceListMail.class.getName()).log(Level.SEVERE, null, ex);
            return "AddressExceptionError : " + ex.toString();
        } catch (MessagingException ex) {
            Logger.getLogger(UnitPriceListMail.class.getName()).log(Level.SEVERE, null, ex);
            return "MessagingExceptionError : " + ex.toString();
        } catch (Exception e) {
            return "Error : " + e.toString();
        }
    }
    public static String sendWithMultipleAttachment3(String username, String password, Properties props, byte[] bytes1,byte[] bytes2,byte[] bytes3,
            String toAddress, String ccAddress, String bccAddress,  String subject, Object mailContent, String fileName1,String fileName2,String fileName3) {

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
           
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toAddress));
            message.setRecipients(Message.RecipientType.CC, InternetAddress.parse(ccAddress));
            message.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(bccAddress));

            message.setSubject(subject);
            DataSource dataSource1 = new ByteArrayDataSource(bytes1, "application/pdf");
            DataSource dataSource2 = new ByteArrayDataSource(bytes2, "application/pdf");
            DataSource dataSource3 = new ByteArrayDataSource(bytes3, "application/pdf");
            MimeBodyPart pdfBodyPart1 = new MimeBodyPart();
            MimeBodyPart pdfBodyPart2 = new MimeBodyPart();
            MimeBodyPart pdfBodyPart3 = new MimeBodyPart();
            pdfBodyPart1.setDataHandler(new DataHandler(dataSource1));
            pdfBodyPart2.setDataHandler(new DataHandler(dataSource2));
            pdfBodyPart3.setDataHandler(new DataHandler(dataSource3));
            pdfBodyPart1.setFileName(fileName1);
            pdfBodyPart2.setFileName(fileName2);
            pdfBodyPart3.setFileName(fileName3);
            BodyPart textBodyPart = new MimeBodyPart();
            textBodyPart.setContent(mailContent, "text/html; charset=UTF-8");
            MimeMultipart mimeMultipart = new MimeMultipart();
            mimeMultipart.addBodyPart(textBodyPart);
            mimeMultipart.addBodyPart(pdfBodyPart1);
            mimeMultipart.addBodyPart(pdfBodyPart2);
            mimeMultipart.addBodyPart(pdfBodyPart3);
            message.setContent(mimeMultipart);

            Transport.send(message);
            return "Mail Send Successfully";
 
        } catch (AddressException ex) {
            Logger.getLogger(UnitPriceListMail.class.getName()).log(Level.SEVERE, null, ex);
            return "AddressExceptionError : " + ex.toString();
        } catch (MessagingException ex) {
            Logger.getLogger(UnitPriceListMail.class.getName()).log(Level.SEVERE, null, ex);
            return "MessagingExceptionError : " + ex.toString();
        } catch (Exception e) {
            return "Error : " + e.toString();
        }
    }
    public static String sendWithMultipleAttachment4(String username, String password, Properties props, byte[] bytes1,byte[] bytes2,byte[] bytes3,byte[] bytes4,
            String toAddress, String ccAddress, String bccAddress,  String subject, Object mailContent, String fileName1,String fileName2,String fileName3,String fileName4) {

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
           
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toAddress));
            message.setRecipients(Message.RecipientType.CC, InternetAddress.parse(ccAddress));
            message.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(bccAddress));

            message.setSubject(subject);
            DataSource dataSource1 = new ByteArrayDataSource(bytes1, "application/pdf");
            DataSource dataSource2 = new ByteArrayDataSource(bytes2, "application/pdf");
            DataSource dataSource3 = new ByteArrayDataSource(bytes3, "application/pdf");
            DataSource dataSource4 = new ByteArrayDataSource(bytes4, "application/pdf");
            MimeBodyPart pdfBodyPart1 = new MimeBodyPart();
            MimeBodyPart pdfBodyPart2 = new MimeBodyPart();
            MimeBodyPart pdfBodyPart3 = new MimeBodyPart();
            MimeBodyPart pdfBodyPart4 = new MimeBodyPart();
            pdfBodyPart1.setDataHandler(new DataHandler(dataSource1));
            pdfBodyPart2.setDataHandler(new DataHandler(dataSource2));
            pdfBodyPart3.setDataHandler(new DataHandler(dataSource3));
            pdfBodyPart4.setDataHandler(new DataHandler(dataSource4));
            pdfBodyPart1.setFileName(fileName1);
            pdfBodyPart2.setFileName(fileName2);
            pdfBodyPart3.setFileName(fileName3);
            pdfBodyPart4.setFileName(fileName4);
            BodyPart textBodyPart = new MimeBodyPart();
            textBodyPart.setContent(mailContent, "text/html; charset=UTF-8");
            MimeMultipart mimeMultipart = new MimeMultipart();
            mimeMultipart.addBodyPart(textBodyPart);
            mimeMultipart.addBodyPart(pdfBodyPart1);
            mimeMultipart.addBodyPart(pdfBodyPart2);
            mimeMultipart.addBodyPart(pdfBodyPart3);
            mimeMultipart.addBodyPart(pdfBodyPart4);
            message.setContent(mimeMultipart);

            Transport.send(message);
            return "Mail Send Successfully";
 
        } catch (AddressException ex) {
            Logger.getLogger(UnitPriceListMail.class.getName()).log(Level.SEVERE, null, ex);
            return "AddressExceptionError : " + ex.toString();
        } catch (MessagingException ex) {
            Logger.getLogger(UnitPriceListMail.class.getName()).log(Level.SEVERE, null, ex);
            return "MessagingExceptionError : " + ex.toString();
        } catch (Exception e) {
            return "Error : " + e.toString();
        }
    }
    public static String sendWithMultipleAttachment5(String username, String password, Properties props, byte[] bytes1,byte[] bytes2,byte[] bytes3,byte[] bytes4,byte[] bytes5,
            String toAddress, String ccAddress, String bccAddress,  String subject, Object mailContent, String fileName1,String fileName2,String fileName3,String fileName4,String fileName5) {

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
           
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toAddress));
            message.setRecipients(Message.RecipientType.CC, InternetAddress.parse(ccAddress));
            message.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(bccAddress));

            message.setSubject(subject);
            DataSource dataSource1 = new ByteArrayDataSource(bytes1, "application/pdf");
            DataSource dataSource2 = new ByteArrayDataSource(bytes2, "application/pdf");
            DataSource dataSource3 = new ByteArrayDataSource(bytes3, "application/pdf");
            DataSource dataSource4 = new ByteArrayDataSource(bytes4, "application/pdf");
            DataSource dataSource5 = new ByteArrayDataSource(bytes5, "application/pdf");
            MimeBodyPart pdfBodyPart1 = new MimeBodyPart();
            MimeBodyPart pdfBodyPart2 = new MimeBodyPart();
            MimeBodyPart pdfBodyPart3 = new MimeBodyPart();
            MimeBodyPart pdfBodyPart4 = new MimeBodyPart();
            MimeBodyPart pdfBodyPart5 = new MimeBodyPart();
            pdfBodyPart1.setDataHandler(new DataHandler(dataSource1));
            pdfBodyPart2.setDataHandler(new DataHandler(dataSource2));
            pdfBodyPart3.setDataHandler(new DataHandler(dataSource3));
            pdfBodyPart4.setDataHandler(new DataHandler(dataSource4));
            pdfBodyPart5.setDataHandler(new DataHandler(dataSource5));
            pdfBodyPart1.setFileName(fileName1);
            pdfBodyPart2.setFileName(fileName2);
            pdfBodyPart3.setFileName(fileName3);
            pdfBodyPart4.setFileName(fileName4);
            pdfBodyPart5.setFileName(fileName5);
            BodyPart textBodyPart = new MimeBodyPart();
            textBodyPart.setContent(mailContent, "text/html; charset=UTF-8");
            MimeMultipart mimeMultipart = new MimeMultipart();
            mimeMultipart.addBodyPart(textBodyPart);
            mimeMultipart.addBodyPart(pdfBodyPart1);
            mimeMultipart.addBodyPart(pdfBodyPart2);
            mimeMultipart.addBodyPart(pdfBodyPart3);
            mimeMultipart.addBodyPart(pdfBodyPart4);
            mimeMultipart.addBodyPart(pdfBodyPart5);
            message.setContent(mimeMultipart);

            Transport.send(message);
            return "Mail Send Successfully";
 
        } catch (AddressException ex) {
            Logger.getLogger(UnitPriceListMail.class.getName()).log(Level.SEVERE, null, ex);
            return "AddressExceptionError : " + ex.toString();
        } catch (MessagingException ex) {
            Logger.getLogger(UnitPriceListMail.class.getName()).log(Level.SEVERE, null, ex);
            return "MessagingExceptionError : " + ex.toString();
        } catch (Exception e) {
            return "Error : " + e.toString();
        }
    }
    public static String sendWithMultipleAttachment6(String username, String password, Properties props, byte[] bytes1,byte[] bytes2,byte[] bytes3,byte[] bytes4,byte[] bytes5,byte[] bytes6,
            String toAddress, String ccAddress, String bccAddress,  String subject, Object mailContent, String fileName1,String fileName2,String fileName3,String fileName4,String fileName5,String fileName6) {

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
           
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toAddress));
            message.setRecipients(Message.RecipientType.CC, InternetAddress.parse(ccAddress));
            message.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(bccAddress));

            message.setSubject(subject);
            DataSource dataSource1 = new ByteArrayDataSource(bytes1, "application/pdf");
            DataSource dataSource2 = new ByteArrayDataSource(bytes2, "application/pdf");
            DataSource dataSource3 = new ByteArrayDataSource(bytes3, "application/pdf");
            DataSource dataSource4 = new ByteArrayDataSource(bytes4, "application/pdf");
            DataSource dataSource5 = new ByteArrayDataSource(bytes5, "application/pdf");
            DataSource dataSource6 = new ByteArrayDataSource(bytes6, "application/pdf");
            MimeBodyPart pdfBodyPart1 = new MimeBodyPart();
            MimeBodyPart pdfBodyPart2 = new MimeBodyPart();
            MimeBodyPart pdfBodyPart3 = new MimeBodyPart();
            MimeBodyPart pdfBodyPart4 = new MimeBodyPart();
            MimeBodyPart pdfBodyPart5 = new MimeBodyPart();
            MimeBodyPart pdfBodyPart6 = new MimeBodyPart();
            pdfBodyPart1.setDataHandler(new DataHandler(dataSource1));
            pdfBodyPart2.setDataHandler(new DataHandler(dataSource2));
            pdfBodyPart3.setDataHandler(new DataHandler(dataSource3));
            pdfBodyPart4.setDataHandler(new DataHandler(dataSource4));
            pdfBodyPart5.setDataHandler(new DataHandler(dataSource5));
            pdfBodyPart6.setDataHandler(new DataHandler(dataSource6));
            pdfBodyPart1.setFileName(fileName1);
            pdfBodyPart2.setFileName(fileName2);
            pdfBodyPart3.setFileName(fileName3);
            pdfBodyPart4.setFileName(fileName4);
            pdfBodyPart5.setFileName(fileName5);
            pdfBodyPart6.setFileName(fileName6);
            BodyPart textBodyPart = new MimeBodyPart();
            textBodyPart.setContent(mailContent, "text/html; charset=UTF-8");
            MimeMultipart mimeMultipart = new MimeMultipart();
            mimeMultipart.addBodyPart(textBodyPart);
            mimeMultipart.addBodyPart(pdfBodyPart1);
            mimeMultipart.addBodyPart(pdfBodyPart2);
            mimeMultipart.addBodyPart(pdfBodyPart3);
            mimeMultipart.addBodyPart(pdfBodyPart4);
            mimeMultipart.addBodyPart(pdfBodyPart5);
            mimeMultipart.addBodyPart(pdfBodyPart6);
            message.setContent(mimeMultipart);

            Transport.send(message);
            return "Mail Send Successfully";
 
        } catch (AddressException ex) {
            Logger.getLogger(UnitPriceListMail.class.getName()).log(Level.SEVERE, null, ex);
            return "AddressExceptionError : " + ex.toString();
        } catch (MessagingException ex) {
            Logger.getLogger(UnitPriceListMail.class.getName()).log(Level.SEVERE, null, ex);
            return "MessagingExceptionError : " + ex.toString();
        } catch (Exception e) {
            return "Error : " + e.toString();
        }
    }
    public static String sendWithMultipleAttachment7(String username, String password, Properties props, byte[] bytes1,byte[] bytes2,byte[] bytes3,byte[] bytes4,byte[] bytes5,byte[] bytes6,byte[] bytes7,
            String toAddress, String ccAddress, String bccAddress,  String subject, Object mailContent, String fileName1,String fileName2,String fileName3,String fileName4,String fileName5,String fileName6,String fileName7) {

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
           
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toAddress));
            message.setRecipients(Message.RecipientType.CC, InternetAddress.parse(ccAddress));
            message.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(bccAddress));

            message.setSubject(subject);
            DataSource dataSource1 = new ByteArrayDataSource(bytes1, "application/pdf");
            DataSource dataSource2 = new ByteArrayDataSource(bytes2, "application/pdf");
            DataSource dataSource3 = new ByteArrayDataSource(bytes3, "application/pdf");
            DataSource dataSource4 = new ByteArrayDataSource(bytes4, "application/pdf");
            DataSource dataSource5 = new ByteArrayDataSource(bytes5, "application/pdf");
            DataSource dataSource6 = new ByteArrayDataSource(bytes6, "application/pdf");
            DataSource dataSource7 = new ByteArrayDataSource(bytes7, "application/pdf");
            MimeBodyPart pdfBodyPart1 = new MimeBodyPart();
            MimeBodyPart pdfBodyPart2 = new MimeBodyPart();
            MimeBodyPart pdfBodyPart3 = new MimeBodyPart();
            MimeBodyPart pdfBodyPart4 = new MimeBodyPart();
            MimeBodyPart pdfBodyPart5 = new MimeBodyPart();
            MimeBodyPart pdfBodyPart6 = new MimeBodyPart();
            MimeBodyPart pdfBodyPart7 = new MimeBodyPart();
            pdfBodyPart1.setDataHandler(new DataHandler(dataSource1));
            pdfBodyPart2.setDataHandler(new DataHandler(dataSource2));
            pdfBodyPart3.setDataHandler(new DataHandler(dataSource3));
            pdfBodyPart4.setDataHandler(new DataHandler(dataSource4));
            pdfBodyPart5.setDataHandler(new DataHandler(dataSource5));
            pdfBodyPart6.setDataHandler(new DataHandler(dataSource6));
            pdfBodyPart7.setDataHandler(new DataHandler(dataSource7));
            pdfBodyPart1.setFileName(fileName1);
            pdfBodyPart2.setFileName(fileName2);
            pdfBodyPart3.setFileName(fileName3);
            pdfBodyPart4.setFileName(fileName4);
            pdfBodyPart5.setFileName(fileName5);
            pdfBodyPart6.setFileName(fileName6);
            pdfBodyPart7.setFileName(fileName7);
            BodyPart textBodyPart = new MimeBodyPart();
            textBodyPart.setContent(mailContent, "text/html; charset=UTF-8");
            MimeMultipart mimeMultipart = new MimeMultipart();
            mimeMultipart.addBodyPart(textBodyPart);
            mimeMultipart.addBodyPart(pdfBodyPart1);
            mimeMultipart.addBodyPart(pdfBodyPart2);
            mimeMultipart.addBodyPart(pdfBodyPart3);
            mimeMultipart.addBodyPart(pdfBodyPart4);
            mimeMultipart.addBodyPart(pdfBodyPart5);
            mimeMultipart.addBodyPart(pdfBodyPart6);
            mimeMultipart.addBodyPart(pdfBodyPart7);
            message.setContent(mimeMultipart);

            Transport.send(message);
            return "Mail Send Successfully";
 
        } catch (AddressException ex) {
            Logger.getLogger(UnitPriceListMail.class.getName()).log(Level.SEVERE, null, ex);
            return "AddressExceptionError : " + ex.toString();
        } catch (MessagingException ex) {
            Logger.getLogger(UnitPriceListMail.class.getName()).log(Level.SEVERE, null, ex);
            return "MessagingExceptionError : " + ex.toString();
        } catch (Exception e) {
            return "Error : " + e.toString();
        }
    }
    public static String sendWithMultipleAttachment8(String username, String password, Properties props, byte[] bytes1,byte[] bytes2,byte[] bytes3,byte[] bytes4,byte[] bytes5,byte[] bytes6,byte[] bytes7,byte[] bytes8,
            String toAddress, String ccAddress, String bccAddress,  String subject, Object mailContent, String fileName1,String fileName2,String fileName3,String fileName4,String fileName5,String fileName6,String fileName7,String fileName8) {

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
           
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toAddress));
            message.setRecipients(Message.RecipientType.CC, InternetAddress.parse(ccAddress));
            message.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(bccAddress));

            message.setSubject(subject);
            DataSource dataSource1 = new ByteArrayDataSource(bytes1, "application/pdf");
            DataSource dataSource2 = new ByteArrayDataSource(bytes2, "application/pdf");
            DataSource dataSource3 = new ByteArrayDataSource(bytes3, "application/pdf");
            DataSource dataSource4 = new ByteArrayDataSource(bytes4, "application/pdf");
            DataSource dataSource5 = new ByteArrayDataSource(bytes5, "application/pdf");
            DataSource dataSource6 = new ByteArrayDataSource(bytes6, "application/pdf");
            DataSource dataSource7 = new ByteArrayDataSource(bytes7, "application/pdf");
            DataSource dataSource8 = new ByteArrayDataSource(bytes8, "application/pdf");
            MimeBodyPart pdfBodyPart1 = new MimeBodyPart();
            MimeBodyPart pdfBodyPart2 = new MimeBodyPart();
            MimeBodyPart pdfBodyPart3 = new MimeBodyPart();
            MimeBodyPart pdfBodyPart4 = new MimeBodyPart();
            MimeBodyPart pdfBodyPart5 = new MimeBodyPart();
            MimeBodyPart pdfBodyPart6 = new MimeBodyPart();
            MimeBodyPart pdfBodyPart7 = new MimeBodyPart();
            MimeBodyPart pdfBodyPart8 = new MimeBodyPart();
            pdfBodyPart1.setDataHandler(new DataHandler(dataSource1));
            pdfBodyPart2.setDataHandler(new DataHandler(dataSource2));
            pdfBodyPart3.setDataHandler(new DataHandler(dataSource3));
            pdfBodyPart4.setDataHandler(new DataHandler(dataSource4));
            pdfBodyPart5.setDataHandler(new DataHandler(dataSource5));
            pdfBodyPart6.setDataHandler(new DataHandler(dataSource6));
            pdfBodyPart7.setDataHandler(new DataHandler(dataSource7));
            pdfBodyPart8.setDataHandler(new DataHandler(dataSource8));
            pdfBodyPart1.setFileName(fileName1);
            pdfBodyPart2.setFileName(fileName2);
            pdfBodyPart3.setFileName(fileName3);
            pdfBodyPart4.setFileName(fileName4);
            pdfBodyPart5.setFileName(fileName5);
            pdfBodyPart6.setFileName(fileName6);
            pdfBodyPart7.setFileName(fileName7);
            pdfBodyPart8.setFileName(fileName8);
            BodyPart textBodyPart = new MimeBodyPart();
            textBodyPart.setContent(mailContent, "text/html; charset=UTF-8");
            MimeMultipart mimeMultipart = new MimeMultipart();
            mimeMultipart.addBodyPart(textBodyPart);
            mimeMultipart.addBodyPart(pdfBodyPart1);
            mimeMultipart.addBodyPart(pdfBodyPart2);
            mimeMultipart.addBodyPart(pdfBodyPart3);
            mimeMultipart.addBodyPart(pdfBodyPart4);
            mimeMultipart.addBodyPart(pdfBodyPart5);
            mimeMultipart.addBodyPart(pdfBodyPart6);
            mimeMultipart.addBodyPart(pdfBodyPart7);
            mimeMultipart.addBodyPart(pdfBodyPart8);
            message.setContent(mimeMultipart);

            Transport.send(message);
            return "Mail Send Successfully";
 
        } catch (AddressException ex) {
            Logger.getLogger(UnitPriceListMail.class.getName()).log(Level.SEVERE, null, ex);
            return "AddressExceptionError : " + ex.toString();
        } catch (MessagingException ex) {
            Logger.getLogger(UnitPriceListMail.class.getName()).log(Level.SEVERE, null, ex);
            return "MessagingExceptionError : " + ex.toString();
        } catch (Exception e) {
            return "Error : " + e.toString();
        }
    }
    public static String sendWithMultipleAttachment9(String username, String password, Properties props, byte[] bytes1,byte[] bytes2,byte[] bytes3,byte[] bytes4,byte[] bytes5,byte[] bytes6,byte[] bytes7,byte[] bytes8,byte[] bytes9,
            String toAddress, String ccAddress, String bccAddress,  String subject, Object mailContent, String fileName1,String fileName2,String fileName3,String fileName4,String fileName5,String fileName6,String fileName7,String fileName8,String fileName9) {

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
           
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toAddress));
            message.setRecipients(Message.RecipientType.CC, InternetAddress.parse(ccAddress));
            message.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(bccAddress));

            message.setSubject(subject);
            DataSource dataSource1 = new ByteArrayDataSource(bytes1, "application/pdf");
            DataSource dataSource2 = new ByteArrayDataSource(bytes2, "application/pdf");
            DataSource dataSource3 = new ByteArrayDataSource(bytes3, "application/pdf");
            DataSource dataSource4 = new ByteArrayDataSource(bytes4, "application/pdf");
            DataSource dataSource5 = new ByteArrayDataSource(bytes5, "application/pdf");
            DataSource dataSource6 = new ByteArrayDataSource(bytes6, "application/pdf");
            DataSource dataSource7 = new ByteArrayDataSource(bytes7, "application/pdf");
            DataSource dataSource8 = new ByteArrayDataSource(bytes8, "application/pdf");
            DataSource dataSource9 = new ByteArrayDataSource(bytes9, "application/pdf");
            MimeBodyPart pdfBodyPart1 = new MimeBodyPart();
            MimeBodyPart pdfBodyPart2 = new MimeBodyPart();
            MimeBodyPart pdfBodyPart3 = new MimeBodyPart();
            MimeBodyPart pdfBodyPart4 = new MimeBodyPart();
            MimeBodyPart pdfBodyPart5 = new MimeBodyPart();
            MimeBodyPart pdfBodyPart6 = new MimeBodyPart();
            MimeBodyPart pdfBodyPart7 = new MimeBodyPart();
            MimeBodyPart pdfBodyPart8 = new MimeBodyPart();
            MimeBodyPart pdfBodyPart9 = new MimeBodyPart();
            pdfBodyPart1.setDataHandler(new DataHandler(dataSource1));
            pdfBodyPart2.setDataHandler(new DataHandler(dataSource2));
            pdfBodyPart3.setDataHandler(new DataHandler(dataSource3));
            pdfBodyPart4.setDataHandler(new DataHandler(dataSource4));
            pdfBodyPart5.setDataHandler(new DataHandler(dataSource5));
            pdfBodyPart6.setDataHandler(new DataHandler(dataSource6));
            pdfBodyPart7.setDataHandler(new DataHandler(dataSource7));
            pdfBodyPart8.setDataHandler(new DataHandler(dataSource8));
            pdfBodyPart9.setDataHandler(new DataHandler(dataSource9));
            pdfBodyPart1.setFileName(fileName1);
            pdfBodyPart2.setFileName(fileName2);
            pdfBodyPart3.setFileName(fileName3);
            pdfBodyPart4.setFileName(fileName4);
            pdfBodyPart5.setFileName(fileName5);
            pdfBodyPart6.setFileName(fileName6);
            pdfBodyPart7.setFileName(fileName7);
            pdfBodyPart8.setFileName(fileName8);
            pdfBodyPart9.setFileName(fileName9);
            BodyPart textBodyPart = new MimeBodyPart();
            textBodyPart.setContent(mailContent, "text/html; charset=UTF-8");
            MimeMultipart mimeMultipart = new MimeMultipart();
            mimeMultipart.addBodyPart(textBodyPart);
            mimeMultipart.addBodyPart(pdfBodyPart1);
            mimeMultipart.addBodyPart(pdfBodyPart2);
            mimeMultipart.addBodyPart(pdfBodyPart3);
            mimeMultipart.addBodyPart(pdfBodyPart4);
            mimeMultipart.addBodyPart(pdfBodyPart5);
            mimeMultipart.addBodyPart(pdfBodyPart6);
            mimeMultipart.addBodyPart(pdfBodyPart7);
            mimeMultipart.addBodyPart(pdfBodyPart8);
            mimeMultipart.addBodyPart(pdfBodyPart9);
            message.setContent(mimeMultipart);

            Transport.send(message);
            return "Mail Send Successfully";
 
        } catch (AddressException ex) {
            Logger.getLogger(UnitPriceListMail.class.getName()).log(Level.SEVERE, null, ex);
            return "AddressExceptionError : " + ex.toString();
        } catch (MessagingException ex) {
            Logger.getLogger(UnitPriceListMail.class.getName()).log(Level.SEVERE, null, ex);
            return "MessagingExceptionError : " + ex.toString();
        } catch (Exception e) {
            return "Error : " + e.toString();
        }
    }
    public static String sendWithMultipleAttachment10(String username, String password, Properties props, byte[] bytes1,byte[] bytes2,byte[] bytes3,byte[] bytes4,byte[] bytes5,byte[] bytes6,byte[] bytes7,byte[] bytes8,byte[] bytes9,byte[] bytes10,
            String toAddress, String ccAddress, String bccAddress,  String subject, Object mailContent, String fileName1,String fileName2,String fileName3,String fileName4,String fileName5,String fileName6,String fileName7,String fileName8,String fileName9,String fileName10) {

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
           
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toAddress));
            message.setRecipients(Message.RecipientType.CC, InternetAddress.parse(ccAddress));
            message.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(bccAddress));

            message.setSubject(subject);
            DataSource dataSource1 = new ByteArrayDataSource(bytes1, "application/pdf");
            DataSource dataSource2 = new ByteArrayDataSource(bytes2, "application/pdf");
            DataSource dataSource3 = new ByteArrayDataSource(bytes3, "application/pdf");
            DataSource dataSource4 = new ByteArrayDataSource(bytes4, "application/pdf");
            DataSource dataSource5 = new ByteArrayDataSource(bytes5, "application/pdf");
            DataSource dataSource6 = new ByteArrayDataSource(bytes6, "application/pdf");
            DataSource dataSource7 = new ByteArrayDataSource(bytes7, "application/pdf");
            DataSource dataSource8 = new ByteArrayDataSource(bytes8, "application/pdf");
            DataSource dataSource9 = new ByteArrayDataSource(bytes9, "application/pdf");
            DataSource dataSource10 = new ByteArrayDataSource(bytes10, "application/pdf");
            MimeBodyPart pdfBodyPart1 = new MimeBodyPart();
            MimeBodyPart pdfBodyPart2 = new MimeBodyPart();
            MimeBodyPart pdfBodyPart3 = new MimeBodyPart();
            MimeBodyPart pdfBodyPart4 = new MimeBodyPart();
            MimeBodyPart pdfBodyPart5 = new MimeBodyPart();
            MimeBodyPart pdfBodyPart6 = new MimeBodyPart();
            MimeBodyPart pdfBodyPart7 = new MimeBodyPart();
            MimeBodyPart pdfBodyPart8 = new MimeBodyPart();
            MimeBodyPart pdfBodyPart9 = new MimeBodyPart();
            MimeBodyPart pdfBodyPart10 = new MimeBodyPart();
            pdfBodyPart1.setDataHandler(new DataHandler(dataSource1));
            pdfBodyPart2.setDataHandler(new DataHandler(dataSource2));
            pdfBodyPart3.setDataHandler(new DataHandler(dataSource3));
            pdfBodyPart4.setDataHandler(new DataHandler(dataSource4));
            pdfBodyPart5.setDataHandler(new DataHandler(dataSource5));
            pdfBodyPart6.setDataHandler(new DataHandler(dataSource6));
            pdfBodyPart7.setDataHandler(new DataHandler(dataSource7));
            pdfBodyPart8.setDataHandler(new DataHandler(dataSource8));
            pdfBodyPart9.setDataHandler(new DataHandler(dataSource9));
            pdfBodyPart10.setDataHandler(new DataHandler(dataSource10));
            pdfBodyPart1.setFileName(fileName1);
            pdfBodyPart2.setFileName(fileName2);
            pdfBodyPart3.setFileName(fileName3);
            pdfBodyPart4.setFileName(fileName4);
            pdfBodyPart5.setFileName(fileName5);
            pdfBodyPart6.setFileName(fileName6);
            pdfBodyPart7.setFileName(fileName7);
            pdfBodyPart8.setFileName(fileName8);
            pdfBodyPart9.setFileName(fileName9);
            pdfBodyPart10.setFileName(fileName10);
            BodyPart textBodyPart = new MimeBodyPart();
            textBodyPart.setContent(mailContent, "text/html; charset=UTF-8");
            MimeMultipart mimeMultipart = new MimeMultipart();
            mimeMultipart.addBodyPart(textBodyPart);
            mimeMultipart.addBodyPart(pdfBodyPart1);
            mimeMultipart.addBodyPart(pdfBodyPart2);
            mimeMultipart.addBodyPart(pdfBodyPart3);
            mimeMultipart.addBodyPart(pdfBodyPart4);
            mimeMultipart.addBodyPart(pdfBodyPart5);
            mimeMultipart.addBodyPart(pdfBodyPart6);
            mimeMultipart.addBodyPart(pdfBodyPart7);
            mimeMultipart.addBodyPart(pdfBodyPart8);
            mimeMultipart.addBodyPart(pdfBodyPart9);
            mimeMultipart.addBodyPart(pdfBodyPart10);
            message.setContent(mimeMultipart);

            Transport.send(message);
            return "Mail Send Successfully";
 
        } catch (AddressException ex) {
            Logger.getLogger(UnitPriceListMail.class.getName()).log(Level.SEVERE, null, ex);
            return "AddressExceptionError : " + ex.toString();
        } catch (MessagingException ex) {
            Logger.getLogger(UnitPriceListMail.class.getName()).log(Level.SEVERE, null, ex);
            return "MessagingExceptionError : " + ex.toString();
        } catch (Exception e) {
            return "Error : " + e.toString();
        }
    }
}
