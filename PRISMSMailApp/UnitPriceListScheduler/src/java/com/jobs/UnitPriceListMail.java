/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jobs;
import com.html.ErrorStatusHTML;
import com.mail.GenericSendMail;
import com.reports.RTFServices;
//import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.String;
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
 * @author Nandhini
 */
public class UnitPriceListMail implements Job  {
  //    public String send(Mail mailBody) {
    /**
     *
     * @param job
     * @throws JobExecutionException
     */  
    @Override
    public void execute(JobExecutionContext job) throws JobExecutionException {
        System.out.println("Excute in PriceList !");
        sendUnitPriceListReport();
        sendUnitPriceListReportAvailable();
    }
//
    Object mailContent = ErrorStatusHTML.getPriceListMailBdy();
    //attachment name
    String projects1 = CallDBQuery.getDetailsForUnitPriceListJob("PROJECTS-1")==null ?"":CallDBQuery.getDetailsForUnitPriceListJob("PROJECTS-1").toString();
    String projects2 = CallDBQuery.getDetailsForUnitPriceListJob("PROJECTS-2")==null ?"":CallDBQuery.getDetailsForUnitPriceListJob("PROJECTS-2").toString();
    String projects3 = CallDBQuery.getDetailsForUnitPriceListJob("PROJECTS-3")==null ?"":CallDBQuery.getDetailsForUnitPriceListJob("PROJECTS-3").toString();
    String projects4 = CallDBQuery.getDetailsForUnitPriceListJob("PROJECTS-4")==null ?"":CallDBQuery.getDetailsForUnitPriceListJob("PROJECTS-4").toString();
    String projects5 = CallDBQuery.getDetailsForUnitPriceListJob("PROJECTS-5")==null ?"":CallDBQuery.getDetailsForUnitPriceListJob("PROJECTS-5").toString();
    String projects6 = CallDBQuery.getDetailsForUnitPriceListJob("PROJECTS-6")==null ?"":CallDBQuery.getDetailsForUnitPriceListJob("PROJECTS-6").toString();
    String projects7 = CallDBQuery.getDetailsForUnitPriceListJob("PROJECTS-7")==null ?"":CallDBQuery.getDetailsForUnitPriceListJob("PROJECTS-7").toString();
    String projects8 = CallDBQuery.getDetailsForUnitPriceListJob("PROJECTS-8")==null ?"":CallDBQuery.getDetailsForUnitPriceListJob("PROJECTS-8").toString();
    String projects9 = CallDBQuery.getDetailsForUnitPriceListJob("PROJECTS-9")==null ?"":CallDBQuery.getDetailsForUnitPriceListJob("PROJECTS-9").toString();
    String projects10 = CallDBQuery.getDetailsForUnitPriceListJob("PROJECTS-10")==null ?"":CallDBQuery.getDetailsForUnitPriceListJob("PROJECTS-10").toString();
    
    String attachmentName1 = null;
    String attachmentName2 = null;
    String attachmentName3 = null;
    String attachmentName4 = null;
    String attachmentName5 = null;
    String attachmentName6 = null;
    String attachmentName7 = null;
    String attachmentName8 = null;
    String attachmentName9 = null;
    String attachmentName10 = null;
        
    String xmlData1 = null;
    String xmlData2 = null;
    String xmlData3 = null;
    String xmlData4 = null;
    String xmlData5 = null;
    String xmlData6 = null;
    String xmlData7 = null;
    String xmlData8 = null;
    String xmlData9 = null;
    String xmlData10 = null;     
        
    byte[] bytes1 = null;
    byte[] bytes2 = null;
    byte[] bytes3 = null;
    byte[] bytes4 = null;
    byte[] bytes5 = null;
    byte[] bytes6 = null;
    byte[] bytes7 = null;
    byte[] bytes8 = null;
    byte[] bytes9 = null;
    byte[] bytes10 = null;
    
    String projId1=CallDBQuery.getDetailsForUnitPriceListJob("PROJECTS-ID-1")==null?"":CallDBQuery.getDetailsForUnitPriceListJob("PROJECTS-ID-1").toString();
    String propId1=CallDBQuery.getDetailsForUnitPriceListJob("PROP-ID-1")==null?"":CallDBQuery.getDetailsForUnitPriceListJob("PROP-ID-1").toString();;
    String projId2=CallDBQuery.getDetailsForUnitPriceListJob("PROJECTS-ID-2")==null?"":CallDBQuery.getDetailsForUnitPriceListJob("PROJECTS-ID-2").toString();
    String propId2=CallDBQuery.getDetailsForUnitPriceListJob("PROP-ID-2")==null?"":CallDBQuery.getDetailsForUnitPriceListJob("PROP-ID-2").toString();
    String projId3=CallDBQuery.getDetailsForUnitPriceListJob("PROJECTS-ID-3")==null?"":CallDBQuery.getDetailsForUnitPriceListJob("PROJECTS-ID-3").toString();
    String propId3=CallDBQuery.getDetailsForUnitPriceListJob("PROP-ID-3")==null?"":CallDBQuery.getDetailsForUnitPriceListJob("PROP-ID-3").toString();
    String projId4=CallDBQuery.getDetailsForUnitPriceListJob("PROJECTS-ID-4")==null?"":CallDBQuery.getDetailsForUnitPriceListJob("PROJECTS-ID-4").toString();
    String propId4=CallDBQuery.getDetailsForUnitPriceListJob("PROP-ID-4")==null?"":CallDBQuery.getDetailsForUnitPriceListJob("PROP-ID-4").toString();
    String projId5=CallDBQuery.getDetailsForUnitPriceListJob("PROJECTS-ID-5")==null?"":CallDBQuery.getDetailsForUnitPriceListJob("PROJECTS-ID-5").toString();
    String propId5=CallDBQuery.getDetailsForUnitPriceListJob("PROP-ID-5")==null?"":CallDBQuery.getDetailsForUnitPriceListJob("PROP-ID-5").toString();
    String projId6=CallDBQuery.getDetailsForUnitPriceListJob("PROJECTS-ID-6")==null?"":CallDBQuery.getDetailsForUnitPriceListJob("PROJECTS-ID-6").toString();
    String propId6=CallDBQuery.getDetailsForUnitPriceListJob("PROP-ID-6")==null?"":CallDBQuery.getDetailsForUnitPriceListJob("PROP-ID-6").toString();
    String projId7=CallDBQuery.getDetailsForUnitPriceListJob("PROJECTS-ID-7")==null?"":CallDBQuery.getDetailsForUnitPriceListJob("PROJECTS-ID-7").toString();
    String propId7=CallDBQuery.getDetailsForUnitPriceListJob("PROP-ID-7")==null?"":CallDBQuery.getDetailsForUnitPriceListJob("PROP-ID-7").toString();
    String projId8=CallDBQuery.getDetailsForUnitPriceListJob("PROJECTS-ID-8")==null?"":CallDBQuery.getDetailsForUnitPriceListJob("PROJECTS-ID-8").toString();
    String propId8=CallDBQuery.getDetailsForUnitPriceListJob("PROP-ID-8")==null?"":CallDBQuery.getDetailsForUnitPriceListJob("PROP-ID-8").toString();
    String projId9=CallDBQuery.getDetailsForUnitPriceListJob("PROJECTS-ID-9")==null?"":CallDBQuery.getDetailsForUnitPriceListJob("PROJECTS-ID-9").toString();
    String propId9=CallDBQuery.getDetailsForUnitPriceListJob("PROP-ID-9")==null?"":CallDBQuery.getDetailsForUnitPriceListJob("PROP-ID-9").toString();
    String projId10=CallDBQuery.getDetailsForUnitPriceListJob("PROJECTS-ID-10")==null?"":CallDBQuery.getDetailsForUnitPriceListJob("PROJECTS-ID-10").toString();
    String propId10=CallDBQuery.getDetailsForUnitPriceListJob("PROP-ID-10")==null?"":CallDBQuery.getDetailsForUnitPriceListJob("PROP-ID-10").toString();
    
    //
    public String sendUnitPriceListReport() {

        final String username = "prismalerts@omniyat.com";
        final String password = "Or@cl3alert";
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.office365.com");
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");
        props.put("mail.smtp.port", "587");

        String toAddress_all = CallDBQuery.getAddressForUnitPriceListAll("TO");
        String ccAddress_all = CallDBQuery.getAddressForUnitPriceListAll("CC");
        String bccAddress_all = CallDBQuery.getAddressForUnitPriceListAll("BCC");
//        
        
//        String toAddress_all="nandhini.m@4iapps.com";
//        String ccAddress_all="prasenjit.d@4iapps.com";
//        String bccAddress_all="";

        /**
         * If there is no data in DB it will refer below mails.
//         */
        if ("".equals(toAddress_all)) {
            toAddress_all = "prasenjit.d@4iapps.com";
        }
         if ("".equals(ccAddress_all)) {
            ccAddress_all = "nandhini.m@4iapps.com";
        }
        if ("".equals(bccAddress_all)) {
            bccAddress_all = "nandhini.m@4iapps.com";
        }


        String subjectforAll = "PriceList Report for Both Available and Management-Blocked units- " + getSysdate("dd-MMM-yyyy");
        String result1 = null;
        String filePath = "/u01/data/reports/Unit_Prise_List.rtf";
    
        if(!projects1.equals("")){
         attachmentName1 = projects1+".pdf";
         xmlData1 = CallDBQuery.getUnitPriceListReport(projId1,propId1,"All");
         if("NO_DATA".equals(xmlData1)){ 
            xmlData1 = CallDBQuery.getEmptyPriceListXml();
            }
          bytes1 = RTFServices.rtfReport(xmlData1, filePath);
        }
        if(!projects2.equals("")){
         attachmentName2 = projects2+".pdf";
         xmlData2 = CallDBQuery.getUnitPriceListReport(projId2,propId2,"All");
         if("NO_DATA".equals(xmlData2)){ 
            xmlData2 = CallDBQuery.getEmptyPriceListXml();
            }
          bytes2 = RTFServices.rtfReport(xmlData2, filePath);
        }
        if(!projects3.equals("")){
         attachmentName3 = projects3+".pdf";
         xmlData3 = CallDBQuery.getUnitPriceListReport(projId3,propId3,"All");
         if("NO_DATA".equals(xmlData3)){ 
            xmlData3 = CallDBQuery.getEmptyPriceListXml();
            }
          bytes3 = RTFServices.rtfReport(xmlData3, filePath);
        }
        if(!projects4.equals("")){
         attachmentName4 = projects4+".pdf";
         xmlData4 = CallDBQuery.getUnitPriceListReport(projId4,propId4,"All");
         if("NO_DATA".equals(xmlData4)){ 
            xmlData4 = CallDBQuery.getEmptyPriceListXml();
            }
          bytes4 = RTFServices.rtfReport(xmlData4, filePath);
        }
        if(!projects5.equals("")){
         attachmentName5 = projects5+".pdf";
         xmlData5 = CallDBQuery.getUnitPriceListReport(projId5,propId5,"All");
         if("NO_DATA".equals(xmlData5)){ 
            xmlData5 = CallDBQuery.getEmptyPriceListXml();
            }
          bytes5 = RTFServices.rtfReport(xmlData5, filePath);
        }
        if(!projects6.equals("")){
         attachmentName6 = projects6+".pdf";
         xmlData6 = CallDBQuery.getUnitPriceListReport(projId6,propId6,"All");
         if("NO_DATA".equals(xmlData6)){ 
            xmlData6 = CallDBQuery.getEmptyPriceListXml();
            }
          bytes6 = RTFServices.rtfReport(xmlData6, filePath);
        }
        if(!projects7.equals("")){
         attachmentName7 = projects7+".pdf";
         xmlData7 = CallDBQuery.getUnitPriceListReport(projId7,propId7,"All");
         if("NO_DATA".equals(xmlData7)){ 
            xmlData7 = CallDBQuery.getEmptyPriceListXml();
            }
          bytes7 = RTFServices.rtfReport(xmlData7, filePath);
        }
        if(!projects8.equals("")){
         attachmentName8 = projects8+".pdf";
         xmlData8 = CallDBQuery.getUnitPriceListReport(projId8,propId8,"All");
         if("NO_DATA".equals(xmlData8)){ 
            xmlData8 = CallDBQuery.getEmptyPriceListXml();
            }
          bytes8 = RTFServices.rtfReport(xmlData8, filePath);
        }
        if(!projects9.equals("")){
         attachmentName9 = projects9+".pdf";
         xmlData9 = CallDBQuery.getUnitPriceListReport(projId9,propId9,"All");
         if("NO_DATA".equals(xmlData9)){ 
            xmlData9 = CallDBQuery.getEmptyPriceListXml();
            }
          bytes9 = RTFServices.rtfReport(xmlData9, filePath);
        }
        if(!projects10.equals("")){
         attachmentName10 = projects10+".pdf";
         xmlData10 = CallDBQuery.getUnitPriceListReport(projId10,propId10,"All");
         if("NO_DATA".equals(xmlData10)){ 
            xmlData10 = CallDBQuery.getEmptyPriceListXml();
            }
          bytes10 = RTFServices.rtfReport(xmlData10, filePath);
        }
        
        if(!projects1.equals("") && projects2.equals("")){ //1 proj
            result1 = GenericSendMail.sendWithMultipleAttachment1(username, password, props, bytes1,toAddress_all, ccAddress_all, bccAddress_all, subjectforAll, mailContent,attachmentName1);
        }
        if(!projects1.equals("") && !projects2.equals("") && projects3.equals("")){ //2 proj
            result1 = GenericSendMail.sendWithMultipleAttachment2(username, password, props, bytes1,bytes2,toAddress_all, ccAddress_all, bccAddress_all, subjectforAll, mailContent,attachmentName1,attachmentName2);
        }
        if(!projects1.equals("") && !projects2.equals("") && !projects3.equals("") && projects4.equals("")){ //3 proj
            result1 = GenericSendMail.sendWithMultipleAttachment3(username, password, props, bytes1,bytes2,bytes3,toAddress_all, ccAddress_all, bccAddress_all, subjectforAll, mailContent,attachmentName1,attachmentName2,attachmentName3);
        }
        if(!projects1.equals("") && !projects2.equals("") && !projects3.equals("") && !projects4.equals("") && projects5.equals("")){ //4 proj
            result1 = GenericSendMail.sendWithMultipleAttachment4(username, password, props, bytes1,bytes2,bytes3,bytes4,toAddress_all, ccAddress_all, bccAddress_all, subjectforAll, mailContent,attachmentName1,attachmentName2,attachmentName3,attachmentName4);
        }
        if(!projects1.equals("") && !projects2.equals("") && !projects3.equals("") && !projects4.equals("") && !projects5.equals("") && projects6.equals("")){ //5 proj
            result1 = GenericSendMail.sendWithMultipleAttachment5(username, password, props, bytes1,bytes2,bytes3,bytes4,bytes5,toAddress_all, ccAddress_all, bccAddress_all, subjectforAll, mailContent,attachmentName1,attachmentName2,attachmentName3,attachmentName4,attachmentName5);
        }
        if(!projects1.equals("") && !projects2.equals("") && !projects3.equals("") && !projects4.equals("") && !projects5.equals("") && !projects6.equals("") && projects7.equals("")){ //6 proj
            result1 = GenericSendMail.sendWithMultipleAttachment6(username, password, props, bytes1,bytes2,bytes3,bytes4,bytes5,bytes6,toAddress_all, ccAddress_all, bccAddress_all, subjectforAll, mailContent,attachmentName1,attachmentName2,attachmentName3,attachmentName4,attachmentName5,attachmentName6);
        }
        if(!projects1.equals("") && !projects2.equals("") && !projects3.equals("") && !projects4.equals("") && !projects5.equals("") && !projects6.equals("") && !projects7.equals("") && projects8.equals("")){ //7 proj
            result1 = GenericSendMail.sendWithMultipleAttachment7(username, password, props, bytes1,bytes2,bytes3,bytes4,bytes5,bytes6,bytes7,toAddress_all, ccAddress_all, bccAddress_all, subjectforAll, mailContent,attachmentName1,attachmentName2,attachmentName3,attachmentName4,attachmentName5,attachmentName6,attachmentName7);
        }
        if(!projects1.equals("") && !projects2.equals("") && !projects3.equals("") && !projects4.equals("") && !projects5.equals("") && !projects6.equals("") && !projects7.equals("") && !projects8.equals("") && projects9.equals("")){ //8 proj
            result1 = GenericSendMail.sendWithMultipleAttachment8(username, password, props, bytes1,bytes2,bytes3,bytes4,bytes5,bytes6,bytes7,bytes8,toAddress_all, ccAddress_all, bccAddress_all, subjectforAll, mailContent,attachmentName1,attachmentName2,attachmentName3,attachmentName4,attachmentName5,attachmentName6,attachmentName7,attachmentName8);
        }
        if(!projects1.equals("") && !projects2.equals("") && !projects3.equals("") && !projects4.equals("") && !projects5.equals("") && !projects6.equals("") && !projects7.equals("") && !projects8.equals("") && !projects9.equals("") && projects10.equals("")){ //9 proj
            result1 = GenericSendMail.sendWithMultipleAttachment9(username, password, props, bytes1,bytes2,bytes3,bytes4,bytes5,bytes6,bytes7,bytes8,bytes9,toAddress_all, ccAddress_all, bccAddress_all, subjectforAll, mailContent,attachmentName1,attachmentName2,attachmentName3,attachmentName4,attachmentName5,attachmentName6,attachmentName7,attachmentName8,attachmentName9);
        }
        if(!projects1.equals("") && !projects2.equals("") && !projects3.equals("") && !projects4.equals("") && !projects5.equals("") && !projects6.equals("") && !projects7.equals("") && !projects8.equals("") && !projects9.equals("") && !projects10.equals("")){ //10 proj
            result1 = GenericSendMail.sendWithMultipleAttachment10(username, password, props, bytes1,bytes2,bytes3,bytes4,bytes5,bytes6,bytes7,bytes8,bytes9,bytes10,toAddress_all, ccAddress_all, bccAddress_all, subjectforAll, mailContent,attachmentName1,attachmentName2,attachmentName3,attachmentName4,attachmentName5,attachmentName6,attachmentName7,attachmentName8,attachmentName9,attachmentName10);
        }
     
        return result1;
    }
         public String sendUnitPriceListReportAvailable() {

        final String username = "prismalerts@omniyat.com";
        final String password = "Or@cl3alert";
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.office365.com");
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");
        props.put("mail.smtp.port", "587");

        String toAddress_available = CallDBQuery.getAddressForUnitPriceListAvailable("TO");
        String ccAddress_available = CallDBQuery.getAddressForUnitPriceListAvailable("CC");
        String bccAddress_available = CallDBQuery.getAddressForUnitPriceListAvailable("BCC");
        
//        String toAddress_available="prasenjit.d@4iapps.com";
//        String ccAddress_available="nandhini.m@4iapps.com";
//        String bccAddress_available="";
        
//
//        /**
//         * If there is no data in DB it will refer below mails.
//         */
        if ("".equals(toAddress_available)) {
            toAddress_available = "prasenjit.d@4iapps.com";
        }
         if ("".equals(ccAddress_available)) {
            ccAddress_available = "nandhini.m@4iapps.com";
        }
        if ("".equals(bccAddress_available)) {
            bccAddress_available = "nandhini.m@4iapps.com";
        }


        String subjectforAvailable = "PriceList Report for Available Units- " + getSysdate("dd-MMM-yyyy");
        String result = null;
        String filePath = "/u01/data/reports/Unit_Prise_List.rtf";
        
        if(!projects1.equals("")){
         attachmentName1 = projects1+".pdf";
         xmlData1 = CallDBQuery.getUnitPriceListReport(projId1,propId1,"Available");
         if("NO_DATA".equals(xmlData1)){ 
            xmlData1 = CallDBQuery.getEmptyPriceListXml();
            }
          bytes1 = RTFServices.rtfReport(xmlData1, filePath);
        }
        if(!projects2.equals("")){
         attachmentName2 = projects2+".pdf";
         xmlData2 = CallDBQuery.getUnitPriceListReport(projId2,propId2,"Available");
         if("NO_DATA".equals(xmlData2)){ 
            xmlData2 = CallDBQuery.getEmptyPriceListXml();
            }
          bytes2 = RTFServices.rtfReport(xmlData2, filePath);
        }
        if(!projects3.equals("")){
         attachmentName3 = projects3+".pdf";
         xmlData3 = CallDBQuery.getUnitPriceListReport(projId3,propId3,"Available");
         if("NO_DATA".equals(xmlData3)){ 
            xmlData3 = CallDBQuery.getEmptyPriceListXml();
            }
          bytes3 = RTFServices.rtfReport(xmlData3, filePath);
        }
        if(!projects4.equals("")){
         attachmentName4 = projects4+".pdf";
         xmlData4 = CallDBQuery.getUnitPriceListReport(projId4,propId4,"Available");
         if("NO_DATA".equals(xmlData4)){ 
            xmlData4 = CallDBQuery.getEmptyPriceListXml();
            }
          bytes4 = RTFServices.rtfReport(xmlData4, filePath);
        }
        if(!projects5.equals("")){
         attachmentName5 = projects5+".pdf";
         xmlData5 = CallDBQuery.getUnitPriceListReport(projId5,propId5,"Available");
         if("NO_DATA".equals(xmlData5)){ 
            xmlData5 = CallDBQuery.getEmptyPriceListXml();
            }
          bytes5 = RTFServices.rtfReport(xmlData5, filePath);
        }
        if(!projects6.equals("")){
         attachmentName6 = projects6+".pdf";
         xmlData6 = CallDBQuery.getUnitPriceListReport(projId6,propId6,"Available");
         if("NO_DATA".equals(xmlData6)){ 
            xmlData6 = CallDBQuery.getEmptyPriceListXml();
            }
          bytes6 = RTFServices.rtfReport(xmlData6, filePath);
        }
        if(!projects7.equals("")){
         attachmentName7 = projects7+".pdf";
         xmlData7 = CallDBQuery.getUnitPriceListReport(projId7,propId7,"Available");
         if("NO_DATA".equals(xmlData7)){ 
            xmlData7 = CallDBQuery.getEmptyPriceListXml();
            }
          bytes7 = RTFServices.rtfReport(xmlData7, filePath);
        }
        if(!projects8.equals("")){
         attachmentName8 = projects8+".pdf";
         xmlData8 = CallDBQuery.getUnitPriceListReport(projId8,propId8,"Available");
         if("NO_DATA".equals(xmlData8)){ 
            xmlData8 = CallDBQuery.getEmptyPriceListXml();
            }
          bytes8 = RTFServices.rtfReport(xmlData8, filePath);
        }
        if(!projects9.equals("")){
         attachmentName9 = projects9+".pdf";
         xmlData9 = CallDBQuery.getUnitPriceListReport(projId9,propId9,"Available");
         if("NO_DATA".equals(xmlData9)){ 
            xmlData9 = CallDBQuery.getEmptyPriceListXml();
            }
          bytes9 = RTFServices.rtfReport(xmlData9, filePath);
        }
        if(!projects10.equals("")){
         attachmentName10 = projects10+".pdf";
         xmlData10 = CallDBQuery.getUnitPriceListReport(projId10,propId10,"Available");
         if("NO_DATA".equals(xmlData10)){ 
            xmlData10 = CallDBQuery.getEmptyPriceListXml();
            }
          bytes10 = RTFServices.rtfReport(xmlData10, filePath);
        }
        
        if(!projects1.equals("") && projects2.equals("")){ //1 proj
            result = GenericSendMail.sendWithMultipleAttachment1(username, password, props, bytes1,toAddress_available, ccAddress_available, bccAddress_available, subjectforAvailable, mailContent,attachmentName1);
        }
        if(!projects1.equals("") && !projects2.equals("") && projects3.equals("")){ //2 proj
            result = GenericSendMail.sendWithMultipleAttachment2(username, password, props, bytes1,bytes2,toAddress_available, ccAddress_available, bccAddress_available, subjectforAvailable, mailContent,attachmentName1,attachmentName2);
        }
        if(!projects1.equals("") && !projects2.equals("") && !projects3.equals("") && projects4.equals("")){ //3 proj
            result = GenericSendMail.sendWithMultipleAttachment3(username, password, props, bytes1,bytes2,bytes3,toAddress_available, ccAddress_available, bccAddress_available, subjectforAvailable, mailContent,attachmentName1,attachmentName2,attachmentName3);
        }
        if(!projects1.equals("") && !projects2.equals("") && !projects3.equals("") && !projects4.equals("") && projects5.equals("")){ //4 proj
            result = GenericSendMail.sendWithMultipleAttachment4(username, password, props, bytes1,bytes2,bytes3,bytes4,toAddress_available, ccAddress_available, bccAddress_available, subjectforAvailable, mailContent,attachmentName1,attachmentName2,attachmentName3,attachmentName4);
        }
        if(!projects1.equals("") && !projects2.equals("") && !projects3.equals("") && !projects4.equals("") && !projects5.equals("") && projects6.equals("")){ //5 proj
            result = GenericSendMail.sendWithMultipleAttachment5(username, password, props, bytes1,bytes2,bytes3,bytes4,bytes5,toAddress_available, ccAddress_available, bccAddress_available, subjectforAvailable, mailContent,attachmentName1,attachmentName2,attachmentName3,attachmentName4,attachmentName5);
        }
        if(!projects1.equals("") && !projects2.equals("") && !projects3.equals("") && !projects4.equals("") && !projects5.equals("") && !projects6.equals("") && projects7.equals("")){ //6 proj
            result = GenericSendMail.sendWithMultipleAttachment6(username, password, props, bytes1,bytes2,bytes3,bytes4,bytes5,bytes6,toAddress_available, ccAddress_available, bccAddress_available, subjectforAvailable, mailContent,attachmentName1,attachmentName2,attachmentName3,attachmentName4,attachmentName5,attachmentName6);
        }
        if(!projects1.equals("") && !projects2.equals("") && !projects3.equals("") && !projects4.equals("") && !projects5.equals("") && !projects6.equals("") && !projects7.equals("") && projects8.equals("")){ //7 proj
            result = GenericSendMail.sendWithMultipleAttachment7(username, password, props, bytes1,bytes2,bytes3,bytes4,bytes5,bytes6,bytes7,toAddress_available, ccAddress_available, bccAddress_available, subjectforAvailable, mailContent,attachmentName1,attachmentName2,attachmentName3,attachmentName4,attachmentName5,attachmentName6,attachmentName7);
        }
        if(!projects1.equals("") && !projects2.equals("") && !projects3.equals("") && !projects4.equals("") && !projects5.equals("") && !projects6.equals("") && !projects7.equals("") && !projects8.equals("") && projects9.equals("")){ //8 proj
            result = GenericSendMail.sendWithMultipleAttachment8(username, password, props, bytes1,bytes2,bytes3,bytes4,bytes5,bytes6,bytes7,bytes8,toAddress_available, ccAddress_available, bccAddress_available, subjectforAvailable, mailContent,attachmentName1,attachmentName2,attachmentName3,attachmentName4,attachmentName5,attachmentName6,attachmentName7,attachmentName8);
        }
        if(!projects1.equals("") && !projects2.equals("") && !projects3.equals("") && !projects4.equals("") && !projects5.equals("") && !projects6.equals("") && !projects7.equals("") && !projects8.equals("") && !projects9.equals("") && projects10.equals("")){ //9 proj
            result = GenericSendMail.sendWithMultipleAttachment9(username, password, props, bytes1,bytes2,bytes3,bytes4,bytes5,bytes6,bytes7,bytes8,bytes9,toAddress_available, ccAddress_available, bccAddress_available, subjectforAvailable, mailContent,attachmentName1,attachmentName2,attachmentName3,attachmentName4,attachmentName5,attachmentName6,attachmentName7,attachmentName8,attachmentName9);
        }
        if(!projects1.equals("") && !projects2.equals("") && !projects3.equals("") && !projects4.equals("") && !projects5.equals("") && !projects6.equals("") && !projects7.equals("") && !projects8.equals("") && !projects9.equals("") && !projects10.equals("")){ //10 proj
            result = GenericSendMail.sendWithMultipleAttachment10(username, password, props, bytes1,bytes2,bytes3,bytes4,bytes5,bytes6,bytes7,bytes8,bytes9,bytes10,toAddress_available, ccAddress_available, bccAddress_available, subjectforAvailable, mailContent,attachmentName1,attachmentName2,attachmentName3,attachmentName4,attachmentName5,attachmentName6,attachmentName7,attachmentName8,attachmentName9,attachmentName10);
        }
        return result;
    }
   
    public String getSysdate(String format) {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        String strDate = formatter.format(date);
        return strDate;
    }

    
}



