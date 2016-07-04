/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aws.test;

import com.aws.connection.AwsConnection;
import com.aws.datamanager.FinancialDataManager;
import com.aws.manager.FinancialManager;
import java.sql.Connection;
import java.sql.SQLException;
import org.json.simple.parser.ParseException;

/**
 *
 * @author siddhraj.atodaria
 */
public class Test2 {

    public static void main(String[] args) throws Exception {
       Connection conn = AwsConnection.getConnection();
       //System.out.println("--private--"+FinancialDataManager.getPrivateRecord(conn, "0012800000dw2X3"));
      // System.out.println("--public--"+FinancialDataManager.getPublicRecord(conn, "0012800000dw2XIAAY"));
      // System.out.println("--private projection--"+FinancialDataManager.getPrivateProjectionRecords(conn, "0012800000dw2X3AAI"));
      // System.out.println("--rojection Date--"+FinancialDataManager.getPrivateProjectionRecordsDate(conn, "0012800000dw2X3AAI"));
      // System.out.println("--rojection Date--"+FinancialDataManager.getPrivateProjectionRecordsByDate(conn, "0012800000dw2X3AAI","02/07/2016"));
      //  System.out.println("--private Actuals--"+FinancialDataManager.getPrivateActualRecord(conn, "0012800000dw2X3AAI"));
        //FinancialDataManager.update(conn, "0012800000dw2X3_0","2018");
      // System.out.println("-- delete --"+FinancialDataManager.getDelete(conn, "0012800000dw2X3AAI"));
       
       //System.out.println("-- public projection --"+FinancialDataManager.getPublicProjectionRecord(conn, "0012800000dw2XIAAY"));
       System.out.println("-- public Actual --"+FinancialDataManager.getPublicRecord(conn, "0012800000dw2XIAAY"));
    }

}
