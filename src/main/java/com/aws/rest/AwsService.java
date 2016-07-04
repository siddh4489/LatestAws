/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aws.rest;

import com.aws.connection.AwsConnection;
import com.aws.datamanager.CompanyDataManager;
import com.aws.datamanager.FinancialDataManager;
import com.aws.manager.CompanyManager;
import com.aws.manager.FinancialManager;
import java.sql.Connection;
import java.sql.SQLException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Siddharaj Atodaria
 */
@Path("/aws")
public class AwsService {

    @POST
    @Path("/company")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createCompany(@HeaderParam("cmpstr") String cmpstr) throws ParseException, SQLException, ClassNotFoundException {
        return Response.status(201).entity(CompanyManager.insertCompanyManager(cmpstr)).build();
    }

//    @POST
//    @Path("/financial")
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response createFinancialData(@HeaderParam("finstr") String finstr,@HeaderParam("sfid") String sfid,@HeaderParam("cmptype") String cmptype) throws ParseException, SQLException, ClassNotFoundException {
//        return Response.status(201).entity(FinancialManager.insertFinancialRecManager(finstr,sfid,cmptype)).build();
//    }
    @POST
    @Path("/financial")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createFinancialData(String finstr, @HeaderParam("sfid") String sfid, @HeaderParam("cmptype") String cmptype) throws ParseException, SQLException, ClassNotFoundException {
        return Response.status(201).entity(FinancialManager.insertFinancialRecManager(finstr, sfid, cmptype)).build();
    }

    @POST
    @Path("/getprivaterecord")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getprivateRecord(@HeaderParam("sfid") String sfid) throws ParseException, SQLException, ClassNotFoundException {
        Connection conn = AwsConnection.getConnection();
        return Response.status(201).entity(FinancialDataManager.getPrivateActualRecord(conn, sfid)).build();
    }
    @POST
    @Path("/getprivateprojectionrecord")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getprivateProjectionRecord(@HeaderParam("sfid") String sfid) throws ParseException, SQLException, ClassNotFoundException {
        Connection conn = AwsConnection.getConnection();
        return Response.status(201).entity(FinancialDataManager.getPrivateProjectionRecords(conn, sfid)).build();
    }
    @POST
    @Path("/getpublicprojectionrecord")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getpublicProjectionRecord(@HeaderParam("sfid") String sfid) throws ParseException, SQLException, ClassNotFoundException {
        Connection conn = AwsConnection.getConnection();
        return Response.status(201).entity(FinancialDataManager.getPublicProjectionRecord(conn, sfid)).build();
    }
    @POST
    @Path("/getprivateprojectionrecordbydate")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getprivateprojectionrecordbydate(@HeaderParam("sfid") String sfid,@HeaderParam("datestr") String datestr) throws ParseException, SQLException, ClassNotFoundException {
        Connection conn = AwsConnection.getConnection();
        return Response.status(201).entity(FinancialDataManager.getPrivateProjectionRecordsByDate(conn, sfid,datestr)).build();
    }
    @POST
    @Path("/getpublicprojectionrecordbydate")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getpublicprojectionrecordbydate(@HeaderParam("sfid") String sfid,@HeaderParam("datestr") String datestr) throws ParseException, SQLException, ClassNotFoundException {
        Connection conn = AwsConnection.getConnection();
        return Response.status(201).entity(FinancialDataManager.getPublicProjectionRecordByDate(conn, sfid,datestr)).build();
    }
    
    @POST
    @Path("/getdeleteprivateprojectionrecord")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getdeleteprivateprojectionrecord(@HeaderParam("sfid") String sfid,@HeaderParam("datestr") String datestr) throws ParseException, SQLException, ClassNotFoundException {
        Connection conn = AwsConnection.getConnection();
        FinancialDataManager.getDeletePrivateProjectionRecord(conn, sfid,datestr);
        return Response.status(201).entity(FinancialDataManager.getPrivateProjectionRecords(conn, sfid)).build();
    }
    
    @POST
    @Path("/getdeletepublicprojectionrecord")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getdeletepublicprojectionrecord(@HeaderParam("sfid") String sfid,@HeaderParam("datestr") String datestr) throws ParseException, SQLException, ClassNotFoundException {
        Connection conn = AwsConnection.getConnection();
        FinancialDataManager.getDeletePrivateProjectionRecord(conn, sfid,datestr);
        return Response.status(201).entity(FinancialDataManager.getPublicProjectionRecord(conn, sfid)).build();
    }
    
    @POST
    @Path("/getprivateprojectionrecordsdate")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getPrivateProjectionRecordsDate(@HeaderParam("sfid") String sfid) throws ParseException, SQLException, ClassNotFoundException {
        Connection conn = AwsConnection.getConnection();
        return Response.status(201).entity(FinancialDataManager.getPrivateProjectionRecordsDate(conn, sfid)).build();
    }
    @POST
    @Path("/getpublicprojectionrecordsdate")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getPublicProjectionRecordsDate(@HeaderParam("sfid") String sfid) throws ParseException, SQLException, ClassNotFoundException {
        Connection conn = AwsConnection.getConnection();
        return Response.status(201).entity(FinancialDataManager.getPrivateProjectionRecordsDate(conn, sfid)).build();
    }
    
    @GET
    @Path("/checkcompanydata")
    @Produces(MediaType.APPLICATION_JSON)
    public Response test2(@HeaderParam("cid") String cid) throws ParseException, SQLException, ClassNotFoundException {
        return Response.status(201).entity(CompanyDataManager.checkRecord(cid)).build();
    }

    
    @POST
    @Path("/getpublicrecord")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getPublicRecord(@HeaderParam("sfid") String sfid) throws ParseException, SQLException, ClassNotFoundException {
        Connection conn = AwsConnection.getConnection();
        return Response.status(201).entity(FinancialDataManager.getPublicRecord(conn, sfid)).build();
    }

    @POST
    @Path("/testbody")
    public Response someMethod(String x, @HeaderParam("data") String data) {

        System.out.println("x");
        return Response.status(201).entity("Welcome " + x + "====" + data).build();        // process string x, for example parse using JAXB and so on ...

    }



}
