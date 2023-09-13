/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest;

import com.biservices.BasicInfo;
import com.biservices.InvokeServices;
import com.biservices.PayloadServices;
import com.jobs.PdcDueMail;
import com.jobs.SendMail;
import com.reports.SyncReceiptAccount;
import dbcall.CallDBQuery;
import java.io.IOException;
import java.sql.SQLException;
import javax.naming.NamingException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Ibrahim
 */
@Path("sendMail")
public class commonRest {

    @Context
    private UriInfo context;   

    /**
     * Creates a new instance of commonRest
     */
    public commonRest() {
    }

     /**
     *
     *
     */
    @Path("/sendInterfaceError")
    @GET
    public Response getJson() throws IOException {
        SendMail sendMail = new SendMail(); 
        return Response.ok().entity(sendMail.sendInterfaceError()).build();  
      }
    
    /**
     *
     *
     */
    @Path("/sendPdcDueMail/{all:.*}")
    @GET
    public Response sendPdcDueAll(@PathParam("all") String allRecord) throws IOException {
        PdcDueMail sendMail = new PdcDueMail();      
        if("all".equals(allRecord)){
            return Response.ok().entity(sendMail.sendPdcDueMail("N")).build();  
        }else{
            return Response.ok().entity(sendMail.sendPdcDueMail("Y")).build();  
        } 
      }
    
    /**
     *
     *
     */
    @Path("/AccountReport/{reportName}")
    @GET
    public Response syncReceiptAccount(@PathParam("reportName") String reportName) throws IOException {
        SyncReceiptAccount obj = new SyncReceiptAccount(); 
        return Response.ok().entity(obj.receiptSyncServices(reportName)).build();  
      }
   }
