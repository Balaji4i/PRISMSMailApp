/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biservices;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.concurrent.TimeUnit;
import javax.xml.bind.DatatypeConverter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 *
 * @author DineshkumarP
 */
public class InvokeServices {

    public synchronized String invokeReport(String xmlInput, String ServiceURL) {

        OkHttpClient client = new OkHttpClient();
        OkHttpClient.Builder builder1 = new OkHttpClient.Builder();
        builder1.connectTimeout(30, TimeUnit.SECONDS);
        builder1.readTimeout(30, TimeUnit.SECONDS);
        builder1.writeTimeout(30, TimeUnit.SECONDS);
        client = builder1.build();
        MediaType mediaType = MediaType.parse("text/xml");
        String reportResponse = null;
        RequestBody body = RequestBody.create(mediaType, xmlInput);
        String error = null;

        /*    Request request
         = new Request.Builder().url(ServiceURL + "/xmlpserver/services/v2/ReportService").post(body).addHeader("content-type",
         "text/xml").addHeader("cache-control",
         "no-cache").addHeader("SOAPAction",
         "").build();*/
        Request request
                = new Request.Builder().url(ServiceURL + "/xmlpserver/services/PublicReportService").post(body).addHeader("content-type",
                        "text/xml").addHeader("cache-control",
                        "no-cache").addHeader("SOAPAction",
                        "").build();
        try {

            Response response = client.newCall(request).execute();
            InputStream isr = response.body().byteStream();
            BufferedReader reader
                    = new BufferedReader(new InputStreamReader(isr));
            StringBuilder out = new StringBuilder();
            String resultsXml;
            while ((resultsXml = reader.readLine()) != null) {
                out.append(resultsXml);
            }

            int responseCode = response.code();

            System.err.println("responseCode-->" + responseCode);

            // Checking code
            if (responseCode > 200) {
                String fault = null;

                if (out.toString().contains(";TEXT&gt;")) {
                    fault = getFaultString(out.toString());
                } else {
                    DocumentBuilder builder
                            = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                    InputSource src = new InputSource();
                    src.setCharacterStream(new StringReader(out.toString()));
                    Document doc = builder.parse(src); 
                    fault = doc.getElementsByTagName("faultstring").item(0).getTextContent();
                }

            } else {
                // get Report Data 
                reportResponse = getResponseAsString(out.toString());
                DocumentBuilder db;
                db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                InputSource is = new InputSource();
                is.setCharacterStream(new StringReader(reportResponse));
                Document doc = db.parse(is);
                NodeList nodes = doc.getElementsByTagName("G_1");
            }
            reader.close();
        } catch (Exception e) {
            error = e.toString();

            e.printStackTrace();
        }
        return reportResponse;
    }

    public synchronized static String getResponseAsString(String resp) throws ParserConfigurationException,
            SAXException,
            IOException {
        String response = resp;
        DocumentBuilder builder
                = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        InputSource src = new InputSource();
        src.setCharacterStream(new StringReader(response));
        Document doc = builder.parse(src);
        response
                = doc.getElementsByTagName("reportBytes").item(0).getTextContent();

        /**
         * *****DECODE BYTES TO STRING***********
         */
        byte[] val = DatatypeConverter.parseBase64Binary(response);
        response = new String(val);
        return response;
    }

    public synchronized static String getFaultString(String xml) {

        String faultString = "";
        int firstFault = xml.indexOf(";TEXT&gt;");
        int firstFault_last = xml.indexOf("&lt;/TEXT&");
        faultString = xml.substring(firstFault + 9, firstFault_last);
        System.err.println("FAULT STRING : " + faultString);
        return faultString;
    }
}
