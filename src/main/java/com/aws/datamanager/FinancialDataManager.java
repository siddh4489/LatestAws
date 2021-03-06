/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aws.datamanager;

import com.aws.model.FinancialModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Siddharaj Atodaria
 */
public class FinancialDataManager {

    public static String insertPrivateFinancialDataManager(Connection conn, FinancialModel fmodel) throws ClassNotFoundException, SQLException {
        String type = "";
        StringBuilder sqlQuery = new StringBuilder();
        try {
            Statement stmt = null;
            conn.setAutoCommit(false);
            // stmt = conn.createStatement();

            for (int j = 0; j < fmodel.getPrivatelst().size(); j++) {
                stmt = conn.createStatement();
                type = fmodel.getPrivatelst().get(j).tabtype;
                sqlQuery = new StringBuilder();
                sqlQuery.append("insert into reports (");
                sqlQuery.append("\"Year\",\"Quarter\",\"Total Revenue Value\",\"Cost of Revenue Value\",\"Gross Profit Value\",\"Gross Margin Value\",");
                sqlQuery.append("\"R&D Value\",\"S&M Value\",\"G&A Value\",\"Others Value\",");
                sqlQuery.append("\"Total Operating Expenses Value\",\"EBITDA\",\"EBITDA Margin Value\",\"Other Income Expenses Net Value\",");
                sqlQuery.append("\"Income Tax Expense Value\",\"Net Income Value\",\"Cash & Equivalents Value\",\"Restricted Cash\",");
                sqlQuery.append("\"Short Term Investments Value\",\"Inventory Value\",\"Net Receivables Value\",\"Prepaid Expenses\",");
                sqlQuery.append("\"Other Current Assets Value\",\"Total Current Assets Value\",\"PP&E Value\",\"Accumulated Amortization Value\",");
                sqlQuery.append("\"Intangible Assets Value\",\"Other Assets Value\",\"Total Assets Value\",\"Short/Current Long Term Debt Value\",");
                sqlQuery.append("\"Accounts Payable Value\",\"Deferred Revenue\",\"Accrued Liabilities\",\"Other Current Liabilities Value\",");
                sqlQuery.append("\"Total Current Liabilities Value\",\"Long Term Debt Value\",\"Other Liabilities Value\",\"Total Liabilities Value\",");
                sqlQuery.append("\"Capital Stock\",\"Retained Earnings Value\",\"Total Equity Value\",\"Total Liabilities & Equity\",");
                sqlQuery.append("\"LTV/CAC Value\",\"Company Type\",\"currencytype\",\"denomination\",\"type\",sfid,sfdcunique) ");
                sqlQuery.append("VALUES (");
                sqlQuery.append(fmodel.getPrivatelst().get(j).year + ",");
                sqlQuery.append("'" + fmodel.getPrivatelst().get(j).qtr + "',");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).rev) && fmodel.getPrivatelst().get(j).rev != null) ? fmodel.getPrivatelst().get(j).rev : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).cor) && fmodel.getPrivatelst().get(j).cor != null) ? fmodel.getPrivatelst().get(j).cor : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).gp) && fmodel.getPrivatelst().get(j).gp != null) ? fmodel.getPrivatelst().get(j).gp : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).gm) && fmodel.getPrivatelst().get(j).gm != null) ? fmodel.getPrivatelst().get(j).gm : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).rd) && fmodel.getPrivatelst().get(j).rd != null) ? fmodel.getPrivatelst().get(j).rd : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).sm) && fmodel.getPrivatelst().get(j).sm != null) ? fmodel.getPrivatelst().get(j).sm : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).ga) && fmodel.getPrivatelst().get(j).ga != null) ? fmodel.getPrivatelst().get(j).ga : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).oe) && fmodel.getPrivatelst().get(j).oe != null) ? fmodel.getPrivatelst().get(j).oe : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).toe) && fmodel.getPrivatelst().get(j).toe != null) ? fmodel.getPrivatelst().get(j).toe : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).ebitba) && fmodel.getPrivatelst().get(j).ebitba != null) ? fmodel.getPrivatelst().get(j).ebitba : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).ebitbam) && fmodel.getPrivatelst().get(j).ebitbam != null) ? fmodel.getPrivatelst().get(j).ebitbam : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).oien) && fmodel.getPrivatelst().get(j).oien != null) ? fmodel.getPrivatelst().get(j).oien : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).it) && fmodel.getPrivatelst().get(j).it != null) ? fmodel.getPrivatelst().get(j).it : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).nl) && fmodel.getPrivatelst().get(j).nl != null) ? fmodel.getPrivatelst().get(j).nl : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).cae) && fmodel.getPrivatelst().get(j).cae != null) ? fmodel.getPrivatelst().get(j).cae : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).rc) && fmodel.getPrivatelst().get(j).rc != null) ? fmodel.getPrivatelst().get(j).rc : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).sti) && fmodel.getPrivatelst().get(j).sti != null) ? fmodel.getPrivatelst().get(j).sti : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).invtry) && fmodel.getPrivatelst().get(j).invtry != null) ? fmodel.getPrivatelst().get(j).invtry : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).ar) && fmodel.getPrivatelst().get(j).ar != null) ? fmodel.getPrivatelst().get(j).ar : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).pe) && fmodel.getPrivatelst().get(j).pe != null) ? fmodel.getPrivatelst().get(j).pe : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).oca) && fmodel.getPrivatelst().get(j).oca != null) ? fmodel.getPrivatelst().get(j).oca : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).tca) && fmodel.getPrivatelst().get(j).tca != null) ? fmodel.getPrivatelst().get(j).tca : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).ppe) && fmodel.getPrivatelst().get(j).ppe != null) ? fmodel.getPrivatelst().get(j).ppe : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).ada) && fmodel.getPrivatelst().get(j).ada != null) ? fmodel.getPrivatelst().get(j).ada : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).intg) && fmodel.getPrivatelst().get(j).intg != null) ? fmodel.getPrivatelst().get(j).intg : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).onca) && fmodel.getPrivatelst().get(j).onca != null) ? fmodel.getPrivatelst().get(j).onca : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).totass) && fmodel.getPrivatelst().get(j).totass != null) ? fmodel.getPrivatelst().get(j).totass : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).std) && fmodel.getPrivatelst().get(j).std != null) ? fmodel.getPrivatelst().get(j).std : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).ap) && fmodel.getPrivatelst().get(j).ap != null) ? fmodel.getPrivatelst().get(j).ap : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).dr) && fmodel.getPrivatelst().get(j).dr != null) ? fmodel.getPrivatelst().get(j).dr : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).al) && fmodel.getPrivatelst().get(j).al != null) ? fmodel.getPrivatelst().get(j).al : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).ocl) && fmodel.getPrivatelst().get(j).ocl != null) ? fmodel.getPrivatelst().get(j).ocl : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).tcl) && fmodel.getPrivatelst().get(j).tcl != null) ? fmodel.getPrivatelst().get(j).tcl : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).ltd) && fmodel.getPrivatelst().get(j).ltd != null) ? fmodel.getPrivatelst().get(j).ltd : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).oncl) && fmodel.getPrivatelst().get(j).oncl != null) ? fmodel.getPrivatelst().get(j).oncl : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).totlia) && fmodel.getPrivatelst().get(j).totlia != null) ? fmodel.getPrivatelst().get(j).totlia : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).cs) && fmodel.getPrivatelst().get(j).cs != null) ? fmodel.getPrivatelst().get(j).cs : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).re) && fmodel.getPrivatelst().get(j).re != null) ? fmodel.getPrivatelst().get(j).re : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).toteq) && fmodel.getPrivatelst().get(j).toteq != null) ? fmodel.getPrivatelst().get(j).toteq : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).tle) && fmodel.getPrivatelst().get(j).tle != null) ? fmodel.getPrivatelst().get(j).tle : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).ltvac) && fmodel.getPrivatelst().get(j).ltvac != null) ? fmodel.getPrivatelst().get(j).ltvac : 0) + ",");
                sqlQuery.append("'" + fmodel.getPrivatelst().get(j).cmptype + "',");
                sqlQuery.append("'" + fmodel.getPrivatelst().get(j).currency + "',");
                sqlQuery.append("'" + fmodel.getPrivatelst().get(j).denomination + "',");
                sqlQuery.append("'" + fmodel.getPrivatelst().get(j).tabtype + "',");
                sqlQuery.append("'" + fmodel.getPrivatelst().get(j).sfid + "',");
                sqlQuery.append("'" + fmodel.getPrivatelst().get(j).sfdcunique + "');");
                System.out.println("---sqlQuery----" + sqlQuery);
                stmt.executeUpdate(sqlQuery.toString());
                stmt.close();
            }

            conn.commit();
            conn.close();

        } catch (SQLException sqlex) {
            System.out.println("---sqlex----" + sqlex);
            Logger.getLogger(CompanyDataManager.class.getName()).log(Level.SEVERE, null, sqlex);
            return sqlex.toString();
        }
        return "Private " + type + " Financial Data created successfully ";

    }

    public static String insertPrivateProjectionFinancialDataManager(Connection conn, FinancialModel fmodel) throws ClassNotFoundException, SQLException {
        String type = "";
        StringBuilder sqlQuery = new StringBuilder();
        try {
            Statement stmt = null;
            conn.setAutoCommit(false);
            // stmt = conn.createStatement();

            for (int j = 0; j < fmodel.getPrivatelst().size(); j++) {
                stmt = conn.createStatement();
                type = fmodel.getPrivatelst().get(j).tabtype;
                sqlQuery = new StringBuilder();
                sqlQuery.append("insert into reports (");
                sqlQuery.append("\"Year\",\"Quarter\",\"Total Revenue Value\",\"Cost of Revenue Value\",\"Gross Profit Value\",\"Gross Margin Value\",");
                sqlQuery.append("\"R&D Value\",\"S&M Value\",\"G&A Value\",\"Others Value\",");
                sqlQuery.append("\"Total Operating Expenses Value\",\"EBITDA\",\"EBITDA Margin Value\",\"Other Income Expenses Net Value\",");
                sqlQuery.append("\"Income Tax Expense Value\",\"Net Income Value\",\"Cash & Equivalents Value\",\"Restricted Cash\",");
                sqlQuery.append("\"Short Term Investments Value\",\"Inventory Value\",\"Net Receivables Value\",\"Prepaid Expenses\",");
                sqlQuery.append("\"Other Current Assets Value\",\"Total Current Assets Value\",\"PP&E Value\",\"Accumulated Amortization Value\",");
                sqlQuery.append("\"Intangible Assets Value\",\"Other Assets Value\",\"Total Assets Value\",\"Short/Current Long Term Debt Value\",");
                sqlQuery.append("\"Accounts Payable Value\",\"Deferred Revenue\",\"Accrued Liabilities\",\"Other Current Liabilities Value\",");
                sqlQuery.append("\"Total Current Liabilities Value\",\"Long Term Debt Value\",\"Other Liabilities Value\",\"Total Liabilities Value\",");
                sqlQuery.append("\"Capital Stock\",\"Retained Earnings Value\",\"Total Equity Value\",\"Total Liabilities & Equity\",");
                sqlQuery.append("\"LTV/CAC Value\",\"Company Type\",\"currencytype\",\"denomination\",\"type\",sfid,projectiondate,sfdcunique) ");
                sqlQuery.append("VALUES (");
                sqlQuery.append(fmodel.getPrivatelst().get(j).year + ",");
                sqlQuery.append("'" + fmodel.getPrivatelst().get(j).qtr + "',");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).rev) && fmodel.getPrivatelst().get(j).rev != null) ? fmodel.getPrivatelst().get(j).rev : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).cor) && fmodel.getPrivatelst().get(j).cor != null) ? fmodel.getPrivatelst().get(j).cor : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).gp) && fmodel.getPrivatelst().get(j).gp != null) ? fmodel.getPrivatelst().get(j).gp : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).gm) && fmodel.getPrivatelst().get(j).gm != null) ? fmodel.getPrivatelst().get(j).gm : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).rd) && fmodel.getPrivatelst().get(j).rd != null) ? fmodel.getPrivatelst().get(j).rd : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).sm) && fmodel.getPrivatelst().get(j).sm != null) ? fmodel.getPrivatelst().get(j).sm : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).ga) && fmodel.getPrivatelst().get(j).ga != null) ? fmodel.getPrivatelst().get(j).ga : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).oe) && fmodel.getPrivatelst().get(j).oe != null) ? fmodel.getPrivatelst().get(j).oe : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).toe) && fmodel.getPrivatelst().get(j).toe != null) ? fmodel.getPrivatelst().get(j).toe : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).ebitba) && fmodel.getPrivatelst().get(j).ebitba != null) ? fmodel.getPrivatelst().get(j).ebitba : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).ebitbam) && fmodel.getPrivatelst().get(j).ebitbam != null) ? fmodel.getPrivatelst().get(j).ebitbam : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).oien) && fmodel.getPrivatelst().get(j).oien != null) ? fmodel.getPrivatelst().get(j).oien : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).it) && fmodel.getPrivatelst().get(j).it != null) ? fmodel.getPrivatelst().get(j).it : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).nl) && fmodel.getPrivatelst().get(j).nl != null) ? fmodel.getPrivatelst().get(j).nl : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).cae) && fmodel.getPrivatelst().get(j).cae != null) ? fmodel.getPrivatelst().get(j).cae : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).rc) && fmodel.getPrivatelst().get(j).rc != null) ? fmodel.getPrivatelst().get(j).rc : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).sti) && fmodel.getPrivatelst().get(j).sti != null) ? fmodel.getPrivatelst().get(j).sti : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).invtry) && fmodel.getPrivatelst().get(j).invtry != null) ? fmodel.getPrivatelst().get(j).invtry : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).ar) && fmodel.getPrivatelst().get(j).ar != null) ? fmodel.getPrivatelst().get(j).ar : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).pe) && fmodel.getPrivatelst().get(j).pe != null) ? fmodel.getPrivatelst().get(j).pe : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).oca) && fmodel.getPrivatelst().get(j).oca != null) ? fmodel.getPrivatelst().get(j).oca : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).tca) && fmodel.getPrivatelst().get(j).tca != null) ? fmodel.getPrivatelst().get(j).tca : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).ppe) && fmodel.getPrivatelst().get(j).ppe != null) ? fmodel.getPrivatelst().get(j).ppe : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).ada) && fmodel.getPrivatelst().get(j).ada != null) ? fmodel.getPrivatelst().get(j).ada : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).intg) && fmodel.getPrivatelst().get(j).intg != null) ? fmodel.getPrivatelst().get(j).intg : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).onca) && fmodel.getPrivatelst().get(j).onca != null) ? fmodel.getPrivatelst().get(j).onca : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).totass) && fmodel.getPrivatelst().get(j).totass != null) ? fmodel.getPrivatelst().get(j).totass : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).std) && fmodel.getPrivatelst().get(j).std != null) ? fmodel.getPrivatelst().get(j).std : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).ap) && fmodel.getPrivatelst().get(j).ap != null) ? fmodel.getPrivatelst().get(j).ap : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).dr) && fmodel.getPrivatelst().get(j).dr != null) ? fmodel.getPrivatelst().get(j).dr : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).al) && fmodel.getPrivatelst().get(j).al != null) ? fmodel.getPrivatelst().get(j).al : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).ocl) && fmodel.getPrivatelst().get(j).ocl != null) ? fmodel.getPrivatelst().get(j).ocl : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).tcl) && fmodel.getPrivatelst().get(j).tcl != null) ? fmodel.getPrivatelst().get(j).tcl : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).ltd) && fmodel.getPrivatelst().get(j).ltd != null) ? fmodel.getPrivatelst().get(j).ltd : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).oncl) && fmodel.getPrivatelst().get(j).oncl != null) ? fmodel.getPrivatelst().get(j).oncl : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).totlia) && fmodel.getPrivatelst().get(j).totlia != null) ? fmodel.getPrivatelst().get(j).totlia : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).cs) && fmodel.getPrivatelst().get(j).cs != null) ? fmodel.getPrivatelst().get(j).cs : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).re) && fmodel.getPrivatelst().get(j).re != null) ? fmodel.getPrivatelst().get(j).re : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).toteq) && fmodel.getPrivatelst().get(j).toteq != null) ? fmodel.getPrivatelst().get(j).toteq : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).tle) && fmodel.getPrivatelst().get(j).tle != null) ? fmodel.getPrivatelst().get(j).tle : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).ltvac) && fmodel.getPrivatelst().get(j).ltvac != null) ? fmodel.getPrivatelst().get(j).ltvac : 0) + ",");
                sqlQuery.append("'" + fmodel.getPrivatelst().get(j).cmptype + "',");
                sqlQuery.append("'" + fmodel.getPrivatelst().get(j).currency + "',");
                sqlQuery.append("'" + fmodel.getPrivatelst().get(j).denomination + "',");
                sqlQuery.append("'" + fmodel.getPrivatelst().get(j).tabtype + "',");
                sqlQuery.append("'" + fmodel.getPrivatelst().get(j).sfid + "',");
                sqlQuery.append("'" + fmodel.getPrivatelst().get(j).datevalue + "',");
                sqlQuery.append("'" + fmodel.getPrivatelst().get(j).sfdcunique + "');");
                System.out.println("---sqlQuery----" + sqlQuery);
                stmt.executeUpdate(sqlQuery.toString());
                stmt.close();
            }

            conn.commit();
            conn.close();

        } catch (SQLException sqlex) {
            System.out.println("---sqlex----" + sqlex);
            Logger.getLogger(CompanyDataManager.class.getName()).log(Level.SEVERE, null, sqlex);
            return sqlex.toString();
        }
        return "Private " + type + " Financial Data created successfully ";

    }

    public static String insertPublicFinancialDataManager(Connection conn, FinancialModel fmodel) throws ClassNotFoundException, SQLException {
        String type = "";
        StringBuilder sqlQuery = new StringBuilder();
        try {
            Statement stmt = null;
            conn.setAutoCommit(false);
            stmt = conn.createStatement();

            for (int j = 0; j < fmodel.getPubliclst().size(); j++) {
                stmt = conn.createStatement();
                type = fmodel.getPubliclst().get(j).tabtype;
                sqlQuery = new StringBuilder();
                sqlQuery.append("insert into reports (");
                sqlQuery.append("\"Year\",\"Quarter\",\"Total Revenue Value\",\"Cost of Revenue Value\",");
                sqlQuery.append("\"Gross Profit Value\",\"Gross Margin\",\"R&D Value\",\"SG&A Value\",");
                sqlQuery.append("\"Non Recurring Value\",\"Others Value\",\"Total Operating Expenses Value\",\"EBITDA\",");
                sqlQuery.append("\"Total Other Income Expenses Net Value\",\"EBIT Value\",\"Interest Expense Value\",\"Income Before Tax Value\",");
                sqlQuery.append("\"Income Tax Expense Value\",\"Minority Interest Value\",\"Discontinued Ops Value\",\"Extraordinary Items Value\",");
                sqlQuery.append("\"Effect of Accounting Changes Value\",\"Other Items Value\",\"Net Income Value\",\"Cash & Equivalents Value\",");
                sqlQuery.append("\"Short Term Investments Value\",\"Net Receivables Value\",\"Inventory Value\",\"Other Current Assets Value\",");
                sqlQuery.append("\"Total Current Assets Value\",\"Long Term Investments Value\",\"PP&E Value\",\"Goodwill Value\",");
                sqlQuery.append("\"Intangible Assets Value\",\"Accumulated Amortization Value\",\"Other Assets Value\",\"Deferred Long Term Asset Charges Value\",");
                sqlQuery.append("\"Total Assets Value\",\"Short/Current Long Term Debt Value\",\"Accounts Payable Value\",\"Other Current Liabilities Value\",");
                sqlQuery.append("\"Total Current Liabilities Value\",\"Long Term Debt Value\",\"Other Liabilities Value\",\"Deferred Long Term Liability Charges Value\",");
                sqlQuery.append("\"Minority Interest (BS)\",\"Negative Goodwill Value\",\"Total Liabilities Value\",\"Misc Stocks Options Warrants Value\",");
                sqlQuery.append("\"Redeemable Preferred Stock Value\",\"Preferred Stock Value\",\"Common Stock Value\",\"Retained Earnings Value\",");
                sqlQuery.append("\"Treasury Stock Value\",\"Capital Surplus Value\",\"Other Stockholder Equity Value\",\"Total Equity Value\",");
                sqlQuery.append("\"Total Liabilites & Equity\",\"LTV/CAC Value\",\"Company Type\",\"currencytype\",\"denomination\",\"type\",sfid,sfdcunique) ");
                sqlQuery.append("VALUES (");
                sqlQuery.append(fmodel.getPubliclst().get(j).puyear + ",");
                sqlQuery.append("'" + fmodel.getPubliclst().get(j).puqtr + "',");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).purev) && fmodel.getPubliclst().get(j).purev != null) ? fmodel.getPubliclst().get(j).purev : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).pucor) && fmodel.getPubliclst().get(j).pucor != null) ? fmodel.getPubliclst().get(j).pucor : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).pugp) && fmodel.getPubliclst().get(j).pugp != null) ? fmodel.getPubliclst().get(j).pugp : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).pugm) && fmodel.getPubliclst().get(j).pugm != null) ? fmodel.getPubliclst().get(j).pugm : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).purd) && fmodel.getPubliclst().get(j).purd != null) ? fmodel.getPubliclst().get(j).purd : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).pusga) && fmodel.getPubliclst().get(j).pusga != null) ? fmodel.getPubliclst().get(j).pusga : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).punr) && fmodel.getPubliclst().get(j).punr != null) ? fmodel.getPubliclst().get(j).punr : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).puoe) && fmodel.getPubliclst().get(j).puoe != null) ? fmodel.getPubliclst().get(j).puoe : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).putoe) && fmodel.getPubliclst().get(j).putoe != null) ? fmodel.getPubliclst().get(j).putoe : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).puebitba) && fmodel.getPubliclst().get(j).puebitba != null) ? fmodel.getPubliclst().get(j).puebitba : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).putoien) && fmodel.getPubliclst().get(j).putoien != null) ? fmodel.getPubliclst().get(j).putoien : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).puebit) && fmodel.getPubliclst().get(j).puebit != null) ? fmodel.getPubliclst().get(j).puebit : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).puit) && fmodel.getPubliclst().get(j).puit != null) ? fmodel.getPubliclst().get(j).puit : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).puibt) && fmodel.getPubliclst().get(j).puibt != null) ? fmodel.getPubliclst().get(j).puibt : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).puite) && fmodel.getPubliclst().get(j).puite != null) ? fmodel.getPubliclst().get(j).puite : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).pumi) && fmodel.getPubliclst().get(j).pumi != null) ? fmodel.getPubliclst().get(j).pumi : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).pudo) && fmodel.getPubliclst().get(j).pudo != null) ? fmodel.getPubliclst().get(j).pudo : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).puei) && fmodel.getPubliclst().get(j).puei != null) ? fmodel.getPubliclst().get(j).puei : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).pueoac) && fmodel.getPubliclst().get(j).pueoac != null) ? fmodel.getPubliclst().get(j).pueoac : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).puoi) && fmodel.getPubliclst().get(j).puoi != null) ? fmodel.getPubliclst().get(j).puoi : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).punil) && fmodel.getPubliclst().get(j).punil != null) ? fmodel.getPubliclst().get(j).punil : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).pucae) && fmodel.getPubliclst().get(j).pucae != null) ? fmodel.getPubliclst().get(j).pucae : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).pusti) && fmodel.getPubliclst().get(j).pusti != null) ? fmodel.getPubliclst().get(j).pusti : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).punre) && fmodel.getPubliclst().get(j).punre != null) ? fmodel.getPubliclst().get(j).punre : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).puinvtry) && fmodel.getPubliclst().get(j).puinvtry != null) ? fmodel.getPubliclst().get(j).puinvtry : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).puoca) && fmodel.getPubliclst().get(j).puoca != null) ? fmodel.getPubliclst().get(j).puoca : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).putcass) && fmodel.getPubliclst().get(j).putcass != null) ? fmodel.getPubliclst().get(j).putcass : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).pulti) && fmodel.getPubliclst().get(j).pulti != null) ? fmodel.getPubliclst().get(j).pulti : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).puppe) && fmodel.getPubliclst().get(j).puppe != null) ? fmodel.getPubliclst().get(j).puppe : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).pugw) && fmodel.getPubliclst().get(j).pugw != null) ? fmodel.getPubliclst().get(j).pugw : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).puia) && fmodel.getPubliclst().get(j).puia != null) ? fmodel.getPubliclst().get(j).puia : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).puaa) && fmodel.getPubliclst().get(j).puaa != null) ? fmodel.getPubliclst().get(j).puaa : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).puoa) && fmodel.getPubliclst().get(j).puoa != null) ? fmodel.getPubliclst().get(j).puoa : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).pudltac) && fmodel.getPubliclst().get(j).pudltac != null) ? fmodel.getPubliclst().get(j).pudltac : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).puta) && fmodel.getPubliclst().get(j).puta != null) ? fmodel.getPubliclst().get(j).puta : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).puscltd) && fmodel.getPubliclst().get(j).puscltd != null) ? fmodel.getPubliclst().get(j).puscltd : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).puap) && fmodel.getPubliclst().get(j).puap != null) ? fmodel.getPubliclst().get(j).puap : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).puocl) && fmodel.getPubliclst().get(j).puocl != null) ? fmodel.getPubliclst().get(j).puocl : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).putcl) && fmodel.getPubliclst().get(j).putcl != null) ? fmodel.getPubliclst().get(j).putcl : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).pultd) && fmodel.getPubliclst().get(j).pultd != null) ? fmodel.getPubliclst().get(j).pultd : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).puolia) && fmodel.getPubliclst().get(j).puolia != null) ? fmodel.getPubliclst().get(j).puolia : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).pudltlc) && fmodel.getPubliclst().get(j).pudltlc != null) ? fmodel.getPubliclst().get(j).pudltlc : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).pumi) && fmodel.getPubliclst().get(j).pumi != null) ? fmodel.getPubliclst().get(j).pumi : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).pungw) && fmodel.getPubliclst().get(j).pungw != null) ? fmodel.getPubliclst().get(j).pungw : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).putotlia) && fmodel.getPubliclst().get(j).putotlia != null) ? fmodel.getPubliclst().get(j).putotlia : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).pumsow) && fmodel.getPubliclst().get(j).pumsow != null) ? fmodel.getPubliclst().get(j).pumsow : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).purps) && fmodel.getPubliclst().get(j).purps != null) ? fmodel.getPubliclst().get(j).purps : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).pups) && fmodel.getPubliclst().get(j).pups != null) ? fmodel.getPubliclst().get(j).pups : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).pucs) && fmodel.getPubliclst().get(j).pucs != null) ? fmodel.getPubliclst().get(j).pucs : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).pure) && fmodel.getPubliclst().get(j).pure != null) ? fmodel.getPubliclst().get(j).pure : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).puts) && fmodel.getPubliclst().get(j).puts != null) ? fmodel.getPubliclst().get(j).puts : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).pucs) && fmodel.getPubliclst().get(j).pucs != null) ? fmodel.getPubliclst().get(j).pucs : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).puose) && fmodel.getPubliclst().get(j).puose != null) ? fmodel.getPubliclst().get(j).puose : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).putote) && fmodel.getPubliclst().get(j).putote != null) ? fmodel.getPubliclst().get(j).putote : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).putle) && fmodel.getPubliclst().get(j).putle != null) ? fmodel.getPubliclst().get(j).putle : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).pultvac) && fmodel.getPubliclst().get(j).pultvac != null) ? fmodel.getPubliclst().get(j).pultvac : 0) + ",");
                sqlQuery.append("'" + fmodel.getPubliclst().get(j).cmptype + "',");
                sqlQuery.append("'" + fmodel.getPubliclst().get(j).currency + "',");
                sqlQuery.append("'" + fmodel.getPubliclst().get(j).denomination + "',");
                sqlQuery.append("'" + fmodel.getPubliclst().get(j).tabtype + "',");
                sqlQuery.append("'" + fmodel.getPubliclst().get(j).sfid + "',");
                sqlQuery.append("'" + fmodel.getPubliclst().get(j).sfdcunique + "');");
                System.out.println("---sqlQuery----" + sqlQuery);
                stmt.executeUpdate(sqlQuery.toString());
                stmt.close();
            }

            conn.commit();
            conn.close();

        } catch (SQLException sqlex) {
            System.out.println("---sqlex----" + sqlex);
            Logger.getLogger(CompanyDataManager.class.getName()).log(Level.SEVERE, null, sqlex);
            return sqlex.toString();
        }
        return "Public " + type + " Financial Data created successfully";

    }
    
    public static String insertPublicProjectionFinancialDataManager(Connection conn, FinancialModel fmodel) throws ClassNotFoundException, SQLException {
        String type = "";
        StringBuilder sqlQuery = new StringBuilder();
        try {
            Statement stmt = null;
            conn.setAutoCommit(false);
            stmt = conn.createStatement();

            for (int j = 0; j < fmodel.getPubliclst().size(); j++) {
                stmt = conn.createStatement();
                type = fmodel.getPubliclst().get(j).tabtype;
                sqlQuery = new StringBuilder();
                sqlQuery.append("insert into reports (");
                sqlQuery.append("\"Year\",\"Quarter\",\"Total Revenue Value\",\"Cost of Revenue Value\",");
                sqlQuery.append("\"Gross Profit Value\",\"Gross Margin\",\"R&D Value\",\"SG&A Value\",");
                sqlQuery.append("\"Non Recurring Value\",\"Others Value\",\"Total Operating Expenses Value\",\"EBITDA\",");
                sqlQuery.append("\"Total Other Income Expenses Net Value\",\"EBIT Value\",\"Interest Expense Value\",\"Income Before Tax Value\",");
                sqlQuery.append("\"Income Tax Expense Value\",\"Minority Interest Value\",\"Discontinued Ops Value\",\"Extraordinary Items Value\",");
                sqlQuery.append("\"Effect of Accounting Changes Value\",\"Other Items Value\",\"Net Income Value\",\"Cash & Equivalents Value\",");
                sqlQuery.append("\"Short Term Investments Value\",\"Net Receivables Value\",\"Inventory Value\",\"Other Current Assets Value\",");
                sqlQuery.append("\"Total Current Assets Value\",\"Long Term Investments Value\",\"PP&E Value\",\"Goodwill Value\",");
                sqlQuery.append("\"Intangible Assets Value\",\"Accumulated Amortization Value\",\"Other Assets Value\",\"Deferred Long Term Asset Charges Value\",");
                sqlQuery.append("\"Total Assets Value\",\"Short/Current Long Term Debt Value\",\"Accounts Payable Value\",\"Other Current Liabilities Value\",");
                sqlQuery.append("\"Total Current Liabilities Value\",\"Long Term Debt Value\",\"Other Liabilities Value\",\"Deferred Long Term Liability Charges Value\",");
                sqlQuery.append("\"Minority Interest (BS)\",\"Negative Goodwill Value\",\"Total Liabilities Value\",\"Misc Stocks Options Warrants Value\",");
                sqlQuery.append("\"Redeemable Preferred Stock Value\",\"Preferred Stock Value\",\"Common Stock Value\",\"Retained Earnings Value\",");
                sqlQuery.append("\"Treasury Stock Value\",\"Capital Surplus Value\",\"Other Stockholder Equity Value\",\"Total Equity Value\",");
                sqlQuery.append("\"Total Liabilites & Equity\",\"LTV/CAC Value\",\"Company Type\",\"currencytype\",\"denomination\",\"type\",sfid,projectiondate,sfdcunique) ");
                sqlQuery.append("VALUES (");
                sqlQuery.append(fmodel.getPubliclst().get(j).puyear + ",");
                sqlQuery.append("'" + fmodel.getPubliclst().get(j).puqtr + "',");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).purev) && fmodel.getPubliclst().get(j).purev != null) ? fmodel.getPubliclst().get(j).purev : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).pucor) && fmodel.getPubliclst().get(j).pucor != null) ? fmodel.getPubliclst().get(j).pucor : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).pugp) && fmodel.getPubliclst().get(j).pugp != null) ? fmodel.getPubliclst().get(j).pugp : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).pugm) && fmodel.getPubliclst().get(j).pugm != null) ? fmodel.getPubliclst().get(j).pugm : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).purd) && fmodel.getPubliclst().get(j).purd != null) ? fmodel.getPubliclst().get(j).purd : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).pusga) && fmodel.getPubliclst().get(j).pusga != null) ? fmodel.getPubliclst().get(j).pusga : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).punr) && fmodel.getPubliclst().get(j).punr != null) ? fmodel.getPubliclst().get(j).punr : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).puoe) && fmodel.getPubliclst().get(j).puoe != null) ? fmodel.getPubliclst().get(j).puoe : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).putoe) && fmodel.getPubliclst().get(j).putoe != null) ? fmodel.getPubliclst().get(j).putoe : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).puebitba) && fmodel.getPubliclst().get(j).puebitba != null) ? fmodel.getPubliclst().get(j).puebitba : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).putoien) && fmodel.getPubliclst().get(j).putoien != null) ? fmodel.getPubliclst().get(j).putoien : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).puebit) && fmodel.getPubliclst().get(j).puebit != null) ? fmodel.getPubliclst().get(j).puebit : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).puit) && fmodel.getPubliclst().get(j).puit != null) ? fmodel.getPubliclst().get(j).puit : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).puibt) && fmodel.getPubliclst().get(j).puibt != null) ? fmodel.getPubliclst().get(j).puibt : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).puite) && fmodel.getPubliclst().get(j).puite != null) ? fmodel.getPubliclst().get(j).puite : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).pumi) && fmodel.getPubliclst().get(j).pumi != null) ? fmodel.getPubliclst().get(j).pumi : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).pudo) && fmodel.getPubliclst().get(j).pudo != null) ? fmodel.getPubliclst().get(j).pudo : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).puei) && fmodel.getPubliclst().get(j).puei != null) ? fmodel.getPubliclst().get(j).puei : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).pueoac) && fmodel.getPubliclst().get(j).pueoac != null) ? fmodel.getPubliclst().get(j).pueoac : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).puoi) && fmodel.getPubliclst().get(j).puoi != null) ? fmodel.getPubliclst().get(j).puoi : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).punil) && fmodel.getPubliclst().get(j).punil != null) ? fmodel.getPubliclst().get(j).punil : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).pucae) && fmodel.getPubliclst().get(j).pucae != null) ? fmodel.getPubliclst().get(j).pucae : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).pusti) && fmodel.getPubliclst().get(j).pusti != null) ? fmodel.getPubliclst().get(j).pusti : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).punre) && fmodel.getPubliclst().get(j).punre != null) ? fmodel.getPubliclst().get(j).punre : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).puinvtry) && fmodel.getPubliclst().get(j).puinvtry != null) ? fmodel.getPubliclst().get(j).puinvtry : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).puoca) && fmodel.getPubliclst().get(j).puoca != null) ? fmodel.getPubliclst().get(j).puoca : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).putcass) && fmodel.getPubliclst().get(j).putcass != null) ? fmodel.getPubliclst().get(j).putcass : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).pulti) && fmodel.getPubliclst().get(j).pulti != null) ? fmodel.getPubliclst().get(j).pulti : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).puppe) && fmodel.getPubliclst().get(j).puppe != null) ? fmodel.getPubliclst().get(j).puppe : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).pugw) && fmodel.getPubliclst().get(j).pugw != null) ? fmodel.getPubliclst().get(j).pugw : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).puia) && fmodel.getPubliclst().get(j).puia != null) ? fmodel.getPubliclst().get(j).puia : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).puaa) && fmodel.getPubliclst().get(j).puaa != null) ? fmodel.getPubliclst().get(j).puaa : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).puoa) && fmodel.getPubliclst().get(j).puoa != null) ? fmodel.getPubliclst().get(j).puoa : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).pudltac) && fmodel.getPubliclst().get(j).pudltac != null) ? fmodel.getPubliclst().get(j).pudltac : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).puta) && fmodel.getPubliclst().get(j).puta != null) ? fmodel.getPubliclst().get(j).puta : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).puscltd) && fmodel.getPubliclst().get(j).puscltd != null) ? fmodel.getPubliclst().get(j).puscltd : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).puap) && fmodel.getPubliclst().get(j).puap != null) ? fmodel.getPubliclst().get(j).puap : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).puocl) && fmodel.getPubliclst().get(j).puocl != null) ? fmodel.getPubliclst().get(j).puocl : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).putcl) && fmodel.getPubliclst().get(j).putcl != null) ? fmodel.getPubliclst().get(j).putcl : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).pultd) && fmodel.getPubliclst().get(j).pultd != null) ? fmodel.getPubliclst().get(j).pultd : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).puolia) && fmodel.getPubliclst().get(j).puolia != null) ? fmodel.getPubliclst().get(j).puolia : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).pudltlc) && fmodel.getPubliclst().get(j).pudltlc != null) ? fmodel.getPubliclst().get(j).pudltlc : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).pumi) && fmodel.getPubliclst().get(j).pumi != null) ? fmodel.getPubliclst().get(j).pumi : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).pungw) && fmodel.getPubliclst().get(j).pungw != null) ? fmodel.getPubliclst().get(j).pungw : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).putotlia) && fmodel.getPubliclst().get(j).putotlia != null) ? fmodel.getPubliclst().get(j).putotlia : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).pumsow) && fmodel.getPubliclst().get(j).pumsow != null) ? fmodel.getPubliclst().get(j).pumsow : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).purps) && fmodel.getPubliclst().get(j).purps != null) ? fmodel.getPubliclst().get(j).purps : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).pups) && fmodel.getPubliclst().get(j).pups != null) ? fmodel.getPubliclst().get(j).pups : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).pucs) && fmodel.getPubliclst().get(j).pucs != null) ? fmodel.getPubliclst().get(j).pucs : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).pure) && fmodel.getPubliclst().get(j).pure != null) ? fmodel.getPubliclst().get(j).pure : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).puts) && fmodel.getPubliclst().get(j).puts != null) ? fmodel.getPubliclst().get(j).puts : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).pucs) && fmodel.getPubliclst().get(j).pucs != null) ? fmodel.getPubliclst().get(j).pucs : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).puose) && fmodel.getPubliclst().get(j).puose != null) ? fmodel.getPubliclst().get(j).puose : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).putote) && fmodel.getPubliclst().get(j).putote != null) ? fmodel.getPubliclst().get(j).putote : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).putle) && fmodel.getPubliclst().get(j).putle != null) ? fmodel.getPubliclst().get(j).putle : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).pultvac) && fmodel.getPubliclst().get(j).pultvac != null) ? fmodel.getPubliclst().get(j).pultvac : 0) + ",");
                sqlQuery.append("'" + fmodel.getPubliclst().get(j).cmptype + "',");
                sqlQuery.append("'" + fmodel.getPubliclst().get(j).currency + "',");
                sqlQuery.append("'" + fmodel.getPubliclst().get(j).denomination + "',");
                sqlQuery.append("'" + fmodel.getPubliclst().get(j).tabtype + "',");
                sqlQuery.append("'" + fmodel.getPubliclst().get(j).sfid + "',");
                sqlQuery.append("'" + fmodel.getPubliclst().get(j).datevalue + "',");
                sqlQuery.append("'" + fmodel.getPubliclst().get(j).sfdcunique + "');");
                System.out.println("---sqlQuery----" + sqlQuery);
                stmt.executeUpdate(sqlQuery.toString());
                stmt.close();
            }

            conn.commit();
            conn.close();

        } catch (SQLException sqlex) {
            System.out.println("---sqlex----" + sqlex);
            Logger.getLogger(CompanyDataManager.class.getName()).log(Level.SEVERE, null, sqlex);
            return sqlex.toString();
        }
        return "Public " + type + " Financial Data created successfully";

    }

    public static String getPrivateActualRecord(Connection conn, String sfdcId) throws SQLException {
        PreparedStatement pst = null;
        ResultSet rs = null;

        StringBuilder sqlQuery = new StringBuilder();
        sqlQuery.append("SELECT ");
        sqlQuery.append("\"Year\",\"Quarter\",\"Total Revenue Value\",\"Cost of Revenue Value\",\"Gross Profit Value\",\"Gross Margin Value\",");
        sqlQuery.append("\"R&D Value\",\"S&M Value\",\"G&A Value\",\"Others Value\",");
        sqlQuery.append("\"Total Operating Expenses Value\",\"EBITDA\",\"EBITDA Margin Value\",\"Other Income Expenses Net Value\",");
        sqlQuery.append("\"Income Tax Expense Value\",\"Net Income Value\",\"Cash & Equivalents Value\",\"Restricted Cash\",");
        sqlQuery.append("\"Short Term Investments Value\",\"Inventory Value\",\"Net Receivables Value\",\"Prepaid Expenses\",");
        sqlQuery.append("\"Other Current Assets Value\",\"Total Current Assets Value\",\"PP&E Value\",\"Accumulated Amortization Value\",");
        sqlQuery.append("\"Intangible Assets Value\",\"Other Assets Value\",\"Total Assets Value\",\"Short/Current Long Term Debt Value\",");
        sqlQuery.append("\"Accounts Payable Value\",\"Deferred Revenue\",\"Accrued Liabilities\",\"Other Current Liabilities Value\",");
        sqlQuery.append("\"Total Current Liabilities Value\",\"Long Term Debt Value\",\"Other Liabilities Value\",\"Total Liabilities Value\",");
        sqlQuery.append("\"Capital Stock\",\"Retained Earnings Value\",\"Total Equity Value\",\"Total Liabilities & Equity\",");
        sqlQuery.append("\"LTV/CAC Value\",\"Company Type\",\"currencytype\",\"denomination\",\"type\",sfid,sfdcunique ");

        sqlQuery.append(" From reports ");
        sqlQuery.append(" WHERE sfid ='" + sfdcId + "'");
        sqlQuery.append(" AND \"type\" ='Actuals'");
        sqlQuery.append(" ORDER BY sfdcunique ");

        System.out.println("---sqlQuery---" + sqlQuery);
        pst = conn.prepareStatement(sqlQuery.toString());
        rs = pst.executeQuery();
        int i = 0;
        String jsonstr = "";

        jsonstr = "{";

        while (rs.next()) {
            System.out.println(i + "--sfdcunique---" + rs.getString("sfdcunique"));
            System.out.println(i + "--Year---" + rs.getString("type"));
            System.out.println(i + "--Total Revenue Value---" + rs.getString("Total Revenue Value"));
            jsonstr += "\"year_" + i + "\":\"" + rs.getString("Year") + "\",";
            jsonstr += "\"qtr_" + i + "\":\"" + rs.getString("Quarter") + "\",";
            jsonstr += "\"rev_" + i + "\":\"" + rs.getString("Total Revenue Value") + "\",";
            jsonstr += "\"cor_" + i + "\":\"" + rs.getString("Cost of Revenue Value") + "\",";
            jsonstr += "\"gp_" + i + "\":\"" + rs.getString("Gross Profit Value") + "\",";
            jsonstr += "\"gm_" + i + "\":\"" + rs.getString("Gross Margin Value").substring(0, rs.getString("Gross Margin Value").indexOf(".")) + "\",";
            jsonstr += "\"rd_" + i + "\":\"" + rs.getString("R&D Value") + "\",";
            jsonstr += "\"sm_" + i + "\":\"" + rs.getString("S&M Value") + "\",";
            jsonstr += "\"ga_" + i + "\":\"" + rs.getString("G&A Value") + "\",";
            jsonstr += "\"oe_" + i + "\":\"" + rs.getString("Others Value") + "\",";
            jsonstr += "\"toe_" + i + "\":\"" + rs.getString("Total Operating Expenses Value") + "\",";
            jsonstr += "\"ebitba_" + i + "\":\"" + rs.getString("EBITDA") + "\",";
            jsonstr += "\"ebitbam_" + i + "\":\"" + rs.getString("EBITDA Margin Value").substring(0, rs.getString("EBITDA Margin Value").indexOf(".")) + "\",";
            jsonstr += "\"oien_" + i + "\":\"" + rs.getString("Other Income Expenses Net Value") + "\",";
            jsonstr += "\"it_" + i + "\":\"" + rs.getString("Income Tax Expense Value") + "\",";
            jsonstr += "\"nl_" + i + "\":\"" + rs.getString("Net Income Value") + "\",";
            jsonstr += "\"cae_" + i + "\":\"" + rs.getString("Cash & Equivalents Value") + "\",";
            jsonstr += "\"rc_" + i + "\":\"" + rs.getString("Restricted Cash") + "\",";
            jsonstr += "\"sti_" + i + "\":\"" + rs.getString("Short Term Investments Value") + "\",";
            jsonstr += "\"invtry_" + i + "\":\"" + rs.getString("Inventory Value") + "\",";
            jsonstr += "\"ar_" + i + "\":\"" + rs.getString("Net Receivables Value") + "\",";
            jsonstr += "\"pe_" + i + "\":\"" + rs.getString("Prepaid Expenses") + "\",";
            jsonstr += "\"oca_" + i + "\":\"" + rs.getString("Other Current Assets Value") + "\",";
            jsonstr += "\"tca_" + i + "\":\"" + rs.getString("Total Current Assets Value") + "\",";
            jsonstr += "\"ppe_" + i + "\":\"" + rs.getString("PP&E Value") + "\",";
            jsonstr += "\"ada_" + i + "\":\"" + rs.getString("Accumulated Amortization Value") + "\",";
            jsonstr += "\"intg_" + i + "\":\"" + rs.getString("Intangible Assets Value") + "\",";
            jsonstr += "\"onca_" + i + "\":\"" + rs.getString("Other Assets Value") + "\",";
            jsonstr += "\"totass_" + i + "\":\"" + rs.getString("Total Assets Value") + "\",";
            jsonstr += "\"std_" + i + "\":\"" + rs.getString("Short/Current Long Term Debt Value") + "\",";
            jsonstr += "\"ap_" + i + "\":\"" + rs.getString("Accounts Payable Value") + "\",";
            jsonstr += "\"dr_" + i + "\":\"" + rs.getString("Deferred Revenue") + "\",";
            jsonstr += "\"al_" + i + "\":\"" + rs.getString("Accrued Liabilities") + "\",";
            jsonstr += "\"ocl_" + i + "\":\"" + rs.getString("Other Current Liabilities Value") + "\",";
            jsonstr += "\"tcl_" + i + "\":\"" + rs.getString("Total Current Liabilities Value") + "\",";
            jsonstr += "\"ltd_" + i + "\":\"" + rs.getString("Long Term Debt Value") + "\",";
            jsonstr += "\"oncl_" + i + "\":\"" + rs.getString("Other Liabilities Value") + "\",";
            jsonstr += "\"totlia_" + i + "\":\"" + rs.getString("Total Liabilities Value") + "\",";
            jsonstr += "\"cs_" + i + "\":\"" + rs.getString("Capital Stock") + "\",";
            jsonstr += "\"re_" + i + "\":\"" + rs.getString("Retained Earnings Value") + "\",";
            jsonstr += "\"toteq_" + i + "\":\"" + rs.getString("Total Equity Value") + "\",";
            jsonstr += "\"tle_" + i + "\":\"" + rs.getString("Total Liabilities & Equity") + "\",";
            jsonstr += "\"ltvac_" + i + "\":\"" + rs.getString("LTV/CAC Value").substring(0, rs.getString("LTV/CAC Value").indexOf(".")) + "\",";
            jsonstr += "\"cmptype_" + i + "\":\"" + rs.getString("Company Type") + "\",";
            jsonstr += "\"currency_" + i + "\":\"" + rs.getString("currencytype") + "\",";
            jsonstr += "\"denomination_" + i + "\":\"" + rs.getString("denomination") + "\",";
            i++;
        }
        jsonstr = jsonstr.substring(0, jsonstr.length() - 1);;
        jsonstr += "}";

        return jsonstr;
    }

    public static String getPrivateProjectionRecords(Connection conn, String sfdcId) throws SQLException {
        PreparedStatement pst = null;
        ResultSet rs = null;

        StringBuilder sqlQuery = new StringBuilder();
        sqlQuery.append("SELECT ");
        sqlQuery.append("\"Year\",\"Quarter\",\"Total Revenue Value\",\"Cost of Revenue Value\",\"Gross Profit Value\",\"Gross Margin Value\",");
        sqlQuery.append("\"R&D Value\",\"S&M Value\",\"G&A Value\",\"Others Value\",");
        sqlQuery.append("\"Total Operating Expenses Value\",\"EBITDA\",\"EBITDA Margin Value\",\"Other Income Expenses Net Value\",");
        sqlQuery.append("\"Income Tax Expense Value\",\"Net Income Value\",\"Cash & Equivalents Value\",\"Restricted Cash\",");
        sqlQuery.append("\"Short Term Investments Value\",\"Inventory Value\",\"Net Receivables Value\",\"Prepaid Expenses\",");
        sqlQuery.append("\"Other Current Assets Value\",\"Total Current Assets Value\",\"PP&E Value\",\"Accumulated Amortization Value\",");
        sqlQuery.append("\"Intangible Assets Value\",\"Other Assets Value\",\"Total Assets Value\",\"Short/Current Long Term Debt Value\",");
        sqlQuery.append("\"Accounts Payable Value\",\"Deferred Revenue\",\"Accrued Liabilities\",\"Other Current Liabilities Value\",");
        sqlQuery.append("\"Total Current Liabilities Value\",\"Long Term Debt Value\",\"Other Liabilities Value\",\"Total Liabilities Value\",");
        sqlQuery.append("\"Capital Stock\",\"Retained Earnings Value\",\"Total Equity Value\",\"Total Liabilities & Equity\",");
        sqlQuery.append("\"LTV/CAC Value\",\"Company Type\",\"currencytype\",\"denomination\",\"type\",sfid,sfdcunique,projectiondate ");

        sqlQuery.append(" From reports ");
        sqlQuery.append(" WHERE sfid ='" + sfdcId + "'");
        sqlQuery.append(" AND \"type\" ='Projection'");
        sqlQuery.append(" ORDER BY projectiondate Desc Limit 8");

        System.out.println("---sqlQuery---" + sqlQuery);
        pst = conn.prepareStatement(sqlQuery.toString());
        rs = pst.executeQuery();
        int i = 0;
        String jsonstr = "";

        jsonstr = "{";

        while (rs.next()) {
            System.out.println(i + "--sfdcunique---" + rs.getString("sfdcunique"));
            System.out.println(i + "--projectiondate---" + rs.getString("projectiondate"));
            System.out.println(i + "--type---" + rs.getString("type"));
            jsonstr += "\"proyear_" + i + "\":\"" + rs.getString("Year") + "\",";
            jsonstr += "\"proqtr_" + i + "\":\"" + rs.getString("Quarter") + "\",";
            jsonstr += "\"prorev_" + i + "\":\"" + rs.getString("Total Revenue Value") + "\",";
            jsonstr += "\"procor_" + i + "\":\"" + rs.getString("Cost of Revenue Value") + "\",";
            jsonstr += "\"progp_" + i + "\":\"" + rs.getString("Gross Profit Value") + "\",";
            jsonstr += "\"progm_" + i + "\":\"" + rs.getString("Gross Margin Value").substring(0, rs.getString("Gross Margin Value").indexOf(".")) + "\",";
            jsonstr += "\"prord_" + i + "\":\"" + rs.getString("R&D Value") + "\",";
            jsonstr += "\"prosm_" + i + "\":\"" + rs.getString("S&M Value") + "\",";
            jsonstr += "\"proga_" + i + "\":\"" + rs.getString("G&A Value") + "\",";
            jsonstr += "\"prooe_" + i + "\":\"" + rs.getString("Others Value") + "\",";
            jsonstr += "\"protoe_" + i + "\":\"" + rs.getString("Total Operating Expenses Value") + "\",";
            jsonstr += "\"proebitba_" + i + "\":\"" + rs.getString("EBITDA") + "\",";
            jsonstr += "\"proebitbam_" + i + "\":\"" + rs.getString("EBITDA Margin Value").substring(0, rs.getString("EBITDA Margin Value").indexOf(".")) + "\",";
            jsonstr += "\"prooien_" + i + "\":\"" + rs.getString("Other Income Expenses Net Value") + "\",";
            jsonstr += "\"proit_" + i + "\":\"" + rs.getString("Income Tax Expense Value") + "\",";
            jsonstr += "\"pronl_" + i + "\":\"" + rs.getString("Net Income Value") + "\",";
            jsonstr += "\"procae_" + i + "\":\"" + rs.getString("Cash & Equivalents Value") + "\",";
            jsonstr += "\"prorc_" + i + "\":\"" + rs.getString("Restricted Cash") + "\",";
            jsonstr += "\"prosti_" + i + "\":\"" + rs.getString("Short Term Investments Value") + "\",";
            jsonstr += "\"proinvtry_" + i + "\":\"" + rs.getString("Inventory Value") + "\",";
            jsonstr += "\"proar_" + i + "\":\"" + rs.getString("Net Receivables Value") + "\",";
            jsonstr += "\"prope_" + i + "\":\"" + rs.getString("Prepaid Expenses") + "\",";
            jsonstr += "\"prooca_" + i + "\":\"" + rs.getString("Other Current Assets Value") + "\",";
            jsonstr += "\"protca_" + i + "\":\"" + rs.getString("Total Current Assets Value") + "\",";
            jsonstr += "\"proppe_" + i + "\":\"" + rs.getString("PP&E Value") + "\",";
            jsonstr += "\"proada_" + i + "\":\"" + rs.getString("Accumulated Amortization Value") + "\",";
            jsonstr += "\"prointg_" + i + "\":\"" + rs.getString("Intangible Assets Value") + "\",";
            jsonstr += "\"proonca_" + i + "\":\"" + rs.getString("Other Assets Value") + "\",";
            jsonstr += "\"prototass_" + i + "\":\"" + rs.getString("Total Assets Value") + "\",";
            jsonstr += "\"prostd_" + i + "\":\"" + rs.getString("Short/Current Long Term Debt Value") + "\",";
            jsonstr += "\"proap_" + i + "\":\"" + rs.getString("Accounts Payable Value") + "\",";
            jsonstr += "\"prodr_" + i + "\":\"" + rs.getString("Deferred Revenue") + "\",";
            jsonstr += "\"proal_" + i + "\":\"" + rs.getString("Accrued Liabilities") + "\",";
            jsonstr += "\"proocl_" + i + "\":\"" + rs.getString("Other Current Liabilities Value") + "\",";
            jsonstr += "\"protcl_" + i + "\":\"" + rs.getString("Total Current Liabilities Value") + "\",";
            jsonstr += "\"proltd_" + i + "\":\"" + rs.getString("Long Term Debt Value") + "\",";
            jsonstr += "\"prooncl_" + i + "\":\"" + rs.getString("Other Liabilities Value") + "\",";
            jsonstr += "\"prototlia_" + i + "\":\"" + rs.getString("Total Liabilities Value") + "\",";
            jsonstr += "\"procs_" + i + "\":\"" + rs.getString("Capital Stock") + "\",";
            jsonstr += "\"prore_" + i + "\":\"" + rs.getString("Retained Earnings Value") + "\",";
            jsonstr += "\"prototeq_" + i + "\":\"" + rs.getString("Total Equity Value") + "\",";
            jsonstr += "\"protle_" + i + "\":\"" + rs.getString("Total Liabilities & Equity") + "\",";
            jsonstr += "\"proltvac_" + i + "\":\"" + rs.getString("LTV/CAC Value").substring(0, rs.getString("LTV/CAC Value").indexOf(".")) + "\",";
            jsonstr += "\"cmptype_" + i + "\":\"" + rs.getString("Company Type") + "\",";
            jsonstr += "\"currency_" + i + "\":\"" + rs.getString("currencytype") + "\",";
            jsonstr += "\"denomination_" + i + "\":\"" + rs.getString("denomination") + "\",";
            i++;
        }
        jsonstr = jsonstr.substring(0, jsonstr.length() - 1);;
        jsonstr += "}";

        return jsonstr;
    }
    
    public static String getPublicProjectionRecord(Connection conn, String sfdcId) throws SQLException {
        PreparedStatement pst = null;
        ResultSet rs = null;

        StringBuilder sqlQuery = new StringBuilder();
        sqlQuery.append("SELECT ");
        sqlQuery.append("\"Year\",\"Quarter\",\"Total Revenue Value\",\"Cost of Revenue Value\",");
        sqlQuery.append("\"Gross Profit Value\",\"Gross Margin\",\"R&D Value\",\"SG&A Value\",");
        sqlQuery.append("\"Non Recurring Value\",\"Others Value\",\"Total Operating Expenses Value\",\"EBITDA\",");
        sqlQuery.append("\"Total Other Income Expenses Net Value\",\"EBIT Value\",\"Interest Expense Value\",\"Income Before Tax Value\",");
        sqlQuery.append("\"Income Tax Expense Value\",\"Minority Interest Value\",\"Discontinued Ops Value\",\"Extraordinary Items Value\",");
        sqlQuery.append("\"Effect of Accounting Changes Value\",\"Other Items Value\",\"Net Income Value\",\"Cash & Equivalents Value\",");
        sqlQuery.append("\"Short Term Investments Value\",\"Net Receivables Value\",\"Inventory Value\",\"Other Current Assets Value\",");
        sqlQuery.append("\"Total Current Assets Value\",\"Long Term Investments Value\",\"PP&E Value\",\"Goodwill Value\",");
        sqlQuery.append("\"Intangible Assets Value\",\"Accumulated Amortization Value\",\"Other Assets Value\",\"Deferred Long Term Asset Charges Value\",");
        sqlQuery.append("\"Total Assets Value\",\"Short/Current Long Term Debt Value\",\"Accounts Payable Value\",\"Other Current Liabilities Value\",");
        sqlQuery.append("\"Total Current Liabilities Value\",\"Long Term Debt Value\",\"Other Liabilities Value\",\"Deferred Long Term Liability Charges Value\",");
        sqlQuery.append("\"Minority Interest (BS)\",\"Negative Goodwill Value\",\"Total Liabilities Value\",\"Misc Stocks Options Warrants Value\",");
        sqlQuery.append("\"Redeemable Preferred Stock Value\",\"Preferred Stock Value\",\"Common Stock Value\",\"Retained Earnings Value\",");
        sqlQuery.append("\"Treasury Stock Value\",\"Capital Surplus Value\",\"Other Stockholder Equity Value\",\"Total Equity Value\",");
        sqlQuery.append("\"Total Liabilites & Equity\",\"LTV/CAC Value\",\"Company Type\",\"currencytype\",\"denomination\",\"type\",sfid,projectiondate,sfdcunique");
        sqlQuery.append(" From reports ");
        sqlQuery.append(" WHERE sfid ='" + sfdcId + "'");
        sqlQuery.append(" AND \"type\" ='Projection'");
        sqlQuery.append(" ORDER BY projectiondate Desc Limit 8");

        System.out.println("---sqlQuery---" + sqlQuery);
        pst = conn.prepareStatement(sqlQuery.toString());
        rs = pst.executeQuery();
        int i = 0;
        String jsonstr = "";

        jsonstr = "{";

        while (rs.next()) {
            System.out.println(i + " Total Revenue Value--sfdcunique---" + rs.getString("Total Revenue Value"));
            System.out.println(i + " getPublicRecord--sfdcunique---" + rs.getString("sfdcunique"));
            System.out.println(i + " getPublicRecord--projectiondate---" + rs.getString("projectiondate"));
            jsonstr += "\"propuyear_" + i + "\":\"" + rs.getString("Year") + "\",";
            jsonstr += "\"propuqtr_" + i + "\":\"" + rs.getString("Quarter") + "\",";
            jsonstr += "\"propurev_" + i + "\":\"" + rs.getString("Total Revenue Value") + "\",";
            jsonstr += "\"propucor_" + i + "\":\"" + rs.getString("Cost of Revenue Value") + "\",";
            jsonstr += "\"propugp_" + i + "\":\"" + rs.getString("Gross Profit Value") + "\",";
            jsonstr += "\"propugm_" + i + "\":\"" + rs.getString("Gross Margin") + "\",";
            jsonstr += "\"propurd_" + i + "\":\"" + rs.getString("R&D Value") + "\",";
            jsonstr += "\"propusga_" + i + "\":\"" + rs.getString("SG&A Value") + "\",";
            jsonstr += "\"propunr_" + i + "\":\"" + rs.getString("Non Recurring Value") + "\",";
            jsonstr += "\"propuoe_" + i + "\":\"" + rs.getString("Others Value") + "\",";
            jsonstr += "\"proputoe_" + i + "\":\"" + rs.getString("Total Operating Expenses Value") + "\",";
            jsonstr += "\"propuebitba_" + i + "\":\"" + rs.getString("EBITDA") + "\",";
            jsonstr += "\"proputoien_" + i + "\":\"" + rs.getString("Total Other Income Expenses Net Value") + "\",";
            jsonstr += "\"propuebit_" + i + "\":\"" + rs.getString("EBIT Value") + "\",";
            jsonstr += "\"propuit_" + i + "\":\"" + rs.getString("Interest Expense Value") + "\",";
            jsonstr += "\"propuibt_" + i + "\":\"" + rs.getString("Income Before Tax Value") + "\",";
            jsonstr += "\"propuite_" + i + "\":\"" + rs.getString("Income Tax Expense Value") + "\",";
            jsonstr += "\"propumino_" + i + "\":\"" + rs.getString("Minority Interest Value") + "\",";
            jsonstr += "\"propudo_" + i + "\":\"" + rs.getString("Discontinued Ops Value") + "\",";
            jsonstr += "\"propuei_" + i + "\":\"" + rs.getString("Extraordinary Items Value") + "\",";
            jsonstr += "\"propueoac_" + i + "\":\"" + rs.getString("Effect of Accounting Changes Value") + "\",";
            jsonstr += "\"propuoi_" + i + "\":\"" + rs.getString("Other Items Value") + "\",";
            jsonstr += "\"propunil_" + i + "\":\"" + rs.getString("Net Income Value") + "\",";
            jsonstr += "\"propucae_" + i + "\":\"" + rs.getString("Cash & Equivalents Value") + "\",";
            jsonstr += "\"propusti_" + i + "\":\"" + rs.getString("Short Term Investments Value") + "\",";
            jsonstr += "\"propunre_" + i + "\":\"" + rs.getString("Net Receivables Value") + "\",";
            jsonstr += "\"propuinvtry_" + i + "\":\"" + rs.getString("Inventory Value") + "\",";
            jsonstr += "\"propuoca_" + i + "\":\"" + rs.getString("Other Current Assets Value") + "\",";
            jsonstr += "\"proputcass_" + i + "\":\"" + rs.getString("Total Current Assets Value") + "\",";
            jsonstr += "\"propulti_" + i + "\":\"" + rs.getString("Long Term Investments Value") + "\",";
            jsonstr += "\"propuppe_" + i + "\":\"" + rs.getString("PP&E Value") + "\",";
            jsonstr += "\"propugw_" + i + "\":\"" + rs.getString("Goodwill Value") + "\",";
            jsonstr += "\"propuia_" + i + "\":\"" + rs.getString("Intangible Assets Value") + "\",";
            jsonstr += "\"propuaa_" + i + "\":\"" + rs.getString("Accumulated Amortization Value") + "\",";
            jsonstr += "\"propuoa_" + i + "\":\"" + rs.getString("Other Assets Value") + "\",";
            jsonstr += "\"propudltac_" + i + "\":\"" + rs.getString("Deferred Long Term Asset Charges Value") + "\",";
            jsonstr += "\"proputa_" + i + "\":\"" + rs.getString("Total Assets Value") + "\",";
            jsonstr += "\"propuscltd_" + i + "\":\"" + rs.getString("Short/Current Long Term Debt Value") + "\",";
            jsonstr += "\"propuap_" + i + "\":\"" + rs.getString("Accounts Payable Value") + "\",";
            jsonstr += "\"propuocl_" + i + "\":\"" + rs.getString("Other Current Liabilities Value") + "\",";
            jsonstr += "\"proputcl_" + i + "\":\"" + rs.getString("Total Current Liabilities Value") + "\",";
            jsonstr += "\"propultd_" + i + "\":\"" + rs.getString("Long Term Debt Value") + "\",";
            jsonstr += "\"propuolia_" + i + "\":\"" + rs.getString("Other Liabilities Value") + "\",";
            jsonstr += "\"propudltlc_" + i + "\":\"" + rs.getString("Deferred Long Term Liability Charges Value") + "\",";
            jsonstr += "\"propumi_" + i + "\":\"" + rs.getString("Minority Interest (BS)") + "\",";
            jsonstr += "\"propungw_" + i + "\":\"" + rs.getString("Negative Goodwill Value") + "\",";
            jsonstr += "\"proputotlia_" + i + "\":\"" + rs.getString("Total Liabilities Value") + "\",";
            jsonstr += "\"propumsow_" + i + "\":\"" + rs.getString("Misc Stocks Options Warrants Value") + "\",";
            jsonstr += "\"propurps_" + i + "\":\"" + rs.getString("Redeemable Preferred Stock Value") + "\",";
            jsonstr += "\"propups_" + i + "\":\"" + rs.getString("Preferred Stock Value") + "\",";
            jsonstr += "\"propucs_" + i + "\":\"" + rs.getString("Common Stock Value") + "\",";
            jsonstr += "\"propure_" + i + "\":\"" + rs.getString("Retained Earnings Value") + "\",";
            jsonstr += "\"proputs_" + i + "\":\"" + rs.getString("Treasury Stock Value") + "\",";
            jsonstr += "\"propucas_" + i + "\":\"" + rs.getString("Capital Surplus Value") + "\",";
            jsonstr += "\"propuose_" + i + "\":\"" + rs.getString("Other Stockholder Equity Value") + "\",";
            jsonstr += "\"proputote_" + i + "\":\"" + rs.getString("Total Equity Value") + "\",";
            jsonstr += "\"proputle_" + i + "\":\"" + rs.getString("Total Liabilites & Equity") + "\",";
            jsonstr += "\"propultvac_" + i + "\":\"" + rs.getString("LTV/CAC Value").substring(0, rs.getString("LTV/CAC Value").indexOf(".")) + "\",";
            jsonstr += "\"cmptype_" + i + "\":\"" + rs.getString("Company Type") + "\",";
            jsonstr += "\"currency_" + i + "\":\"" + rs.getString("currencytype") + "\",";
            jsonstr += "\"denomination_" + i + "\":\"" + rs.getString("denomination") + "\",";
            i++;
        }
        jsonstr = jsonstr.substring(0, jsonstr.length() - 1);;
        jsonstr += "}";

        return jsonstr;
    }

    public static String getPrivateProjectionRecordsByDate(Connection conn, String sfdcId, String datestr) throws SQLException {
        PreparedStatement pst = null;
        ResultSet rs = null;

        StringBuilder sqlQuery = new StringBuilder();
        sqlQuery.append("SELECT ");
        sqlQuery.append("\"Year\",\"Quarter\",\"Total Revenue Value\",\"Cost of Revenue Value\",\"Gross Profit Value\",\"Gross Margin Value\",");
        sqlQuery.append("\"R&D Value\",\"S&M Value\",\"G&A Value\",\"Others Value\",");
        sqlQuery.append("\"Total Operating Expenses Value\",\"EBITDA\",\"EBITDA Margin Value\",\"Other Income Expenses Net Value\",");
        sqlQuery.append("\"Income Tax Expense Value\",\"Net Income Value\",\"Cash & Equivalents Value\",\"Restricted Cash\",");
        sqlQuery.append("\"Short Term Investments Value\",\"Inventory Value\",\"Net Receivables Value\",\"Prepaid Expenses\",");
        sqlQuery.append("\"Other Current Assets Value\",\"Total Current Assets Value\",\"PP&E Value\",\"Accumulated Amortization Value\",");
        sqlQuery.append("\"Intangible Assets Value\",\"Other Assets Value\",\"Total Assets Value\",\"Short/Current Long Term Debt Value\",");
        sqlQuery.append("\"Accounts Payable Value\",\"Deferred Revenue\",\"Accrued Liabilities\",\"Other Current Liabilities Value\",");
        sqlQuery.append("\"Total Current Liabilities Value\",\"Long Term Debt Value\",\"Other Liabilities Value\",\"Total Liabilities Value\",");
        sqlQuery.append("\"Capital Stock\",\"Retained Earnings Value\",\"Total Equity Value\",\"Total Liabilities & Equity\",");
        sqlQuery.append("\"LTV/CAC Value\",\"Company Type\",\"currencytype\",\"denomination\",\"type\",sfid,sfdcunique,projectiondate ");

        sqlQuery.append(" From reports ");
        sqlQuery.append(" WHERE sfid ='" + sfdcId + "'");
        sqlQuery.append(" AND projectiondate ='" + datestr + "'");

        System.out.println("---sqlQuery---" + sqlQuery);
        pst = conn.prepareStatement(sqlQuery.toString());
        rs = pst.executeQuery();
        int i = 0;
        String jsonstr = "";

        jsonstr = "{";

        while (rs.next()) {
            System.out.println(i + "--sfdcunique---" + rs.getString("sfdcunique"));
            System.out.println(i + "--projectiondate---" + rs.getString("projectiondate"));
            System.out.println(i + "--type---" + rs.getString("type"));
            jsonstr += "\"proyear_" + i + "\":\"" + rs.getString("Year") + "\",";
            jsonstr += "\"proqtr_" + i + "\":\"" + rs.getString("Quarter") + "\",";
            jsonstr += "\"prorev_" + i + "\":\"" + rs.getString("Total Revenue Value") + "\",";
            jsonstr += "\"procor_" + i + "\":\"" + rs.getString("Cost of Revenue Value") + "\",";
            jsonstr += "\"progp_" + i + "\":\"" + rs.getString("Gross Profit Value") + "\",";
            jsonstr += "\"progm_" + i + "\":\"" + rs.getString("Gross Margin Value").substring(0, rs.getString("Gross Margin Value").indexOf(".")) + "\",";
            jsonstr += "\"prord_" + i + "\":\"" + rs.getString("R&D Value") + "\",";
            jsonstr += "\"prosm_" + i + "\":\"" + rs.getString("S&M Value") + "\",";
            jsonstr += "\"proga_" + i + "\":\"" + rs.getString("G&A Value") + "\",";
            jsonstr += "\"prooe_" + i + "\":\"" + rs.getString("Others Value") + "\",";
            jsonstr += "\"protoe_" + i + "\":\"" + rs.getString("Total Operating Expenses Value") + "\",";
            jsonstr += "\"proebitba_" + i + "\":\"" + rs.getString("EBITDA") + "\",";
            jsonstr += "\"proebitbam_" + i + "\":\"" + rs.getString("EBITDA Margin Value").substring(0, rs.getString("EBITDA Margin Value").indexOf(".")) + "\",";
            jsonstr += "\"prooien_" + i + "\":\"" + rs.getString("Other Income Expenses Net Value") + "\",";
            jsonstr += "\"proit_" + i + "\":\"" + rs.getString("Income Tax Expense Value") + "\",";
            jsonstr += "\"pronl_" + i + "\":\"" + rs.getString("Net Income Value") + "\",";
            jsonstr += "\"procae_" + i + "\":\"" + rs.getString("Cash & Equivalents Value") + "\",";
            jsonstr += "\"prorc_" + i + "\":\"" + rs.getString("Restricted Cash") + "\",";
            jsonstr += "\"prosti_" + i + "\":\"" + rs.getString("Short Term Investments Value") + "\",";
            jsonstr += "\"proinvtry_" + i + "\":\"" + rs.getString("Inventory Value") + "\",";
            jsonstr += "\"proar_" + i + "\":\"" + rs.getString("Net Receivables Value") + "\",";
            jsonstr += "\"prope_" + i + "\":\"" + rs.getString("Prepaid Expenses") + "\",";
            jsonstr += "\"prooca_" + i + "\":\"" + rs.getString("Other Current Assets Value") + "\",";
            jsonstr += "\"protca_" + i + "\":\"" + rs.getString("Total Current Assets Value") + "\",";
            jsonstr += "\"proppe_" + i + "\":\"" + rs.getString("PP&E Value") + "\",";
            jsonstr += "\"proada_" + i + "\":\"" + rs.getString("Accumulated Amortization Value") + "\",";
            jsonstr += "\"prointg_" + i + "\":\"" + rs.getString("Intangible Assets Value") + "\",";
            jsonstr += "\"proonca_" + i + "\":\"" + rs.getString("Other Assets Value") + "\",";
            jsonstr += "\"prototass_" + i + "\":\"" + rs.getString("Total Assets Value") + "\",";
            jsonstr += "\"prostd_" + i + "\":\"" + rs.getString("Short/Current Long Term Debt Value") + "\",";
            jsonstr += "\"proap_" + i + "\":\"" + rs.getString("Accounts Payable Value") + "\",";
            jsonstr += "\"prodr_" + i + "\":\"" + rs.getString("Deferred Revenue") + "\",";
            jsonstr += "\"proal_" + i + "\":\"" + rs.getString("Accrued Liabilities") + "\",";
            jsonstr += "\"proocl_" + i + "\":\"" + rs.getString("Other Current Liabilities Value") + "\",";
            jsonstr += "\"protcl_" + i + "\":\"" + rs.getString("Total Current Liabilities Value") + "\",";
            jsonstr += "\"proltd_" + i + "\":\"" + rs.getString("Long Term Debt Value") + "\",";
            jsonstr += "\"prooncl_" + i + "\":\"" + rs.getString("Other Liabilities Value") + "\",";
            jsonstr += "\"prototlia_" + i + "\":\"" + rs.getString("Total Liabilities Value") + "\",";
            jsonstr += "\"procs_" + i + "\":\"" + rs.getString("Capital Stock") + "\",";
            jsonstr += "\"prore_" + i + "\":\"" + rs.getString("Retained Earnings Value") + "\",";
            jsonstr += "\"prototeq_" + i + "\":\"" + rs.getString("Total Equity Value") + "\",";
            jsonstr += "\"protle_" + i + "\":\"" + rs.getString("Total Liabilities & Equity") + "\",";
            jsonstr += "\"proltvac_" + i + "\":\"" + rs.getString("LTV/CAC Value").substring(0, rs.getString("LTV/CAC Value").indexOf(".")) + "\",";
            jsonstr += "\"cmptype_" + i + "\":\"" + rs.getString("Company Type") + "\",";
            jsonstr += "\"currency_" + i + "\":\"" + rs.getString("currencytype") + "\",";
            jsonstr += "\"denomination_" + i + "\":\"" + rs.getString("denomination") + "\",";
            i++;
        }
        jsonstr = jsonstr.substring(0, jsonstr.length() - 1);;
        jsonstr += "}";

        return jsonstr;
    }
    
    public static String getPublicProjectionRecordByDate(Connection conn, String sfdcId, String datestr) throws SQLException {
        PreparedStatement pst = null;
        ResultSet rs = null;

        StringBuilder sqlQuery = new StringBuilder();
        sqlQuery.append("SELECT ");
        sqlQuery.append("\"Year\",\"Quarter\",\"Total Revenue Value\",\"Cost of Revenue Value\",");
        sqlQuery.append("\"Gross Profit Value\",\"Gross Margin\",\"R&D Value\",\"SG&A Value\",");
        sqlQuery.append("\"Non Recurring Value\",\"Others Value\",\"Total Operating Expenses Value\",\"EBITDA\",");
        sqlQuery.append("\"Total Other Income Expenses Net Value\",\"EBIT Value\",\"Interest Expense Value\",\"Income Before Tax Value\",");
        sqlQuery.append("\"Income Tax Expense Value\",\"Minority Interest Value\",\"Discontinued Ops Value\",\"Extraordinary Items Value\",");
        sqlQuery.append("\"Effect of Accounting Changes Value\",\"Other Items Value\",\"Net Income Value\",\"Cash & Equivalents Value\",");
        sqlQuery.append("\"Short Term Investments Value\",\"Net Receivables Value\",\"Inventory Value\",\"Other Current Assets Value\",");
        sqlQuery.append("\"Total Current Assets Value\",\"Long Term Investments Value\",\"PP&E Value\",\"Goodwill Value\",");
        sqlQuery.append("\"Intangible Assets Value\",\"Accumulated Amortization Value\",\"Other Assets Value\",\"Deferred Long Term Asset Charges Value\",");
        sqlQuery.append("\"Total Assets Value\",\"Short/Current Long Term Debt Value\",\"Accounts Payable Value\",\"Other Current Liabilities Value\",");
        sqlQuery.append("\"Total Current Liabilities Value\",\"Long Term Debt Value\",\"Other Liabilities Value\",\"Deferred Long Term Liability Charges Value\",");
        sqlQuery.append("\"Minority Interest (BS)\",\"Negative Goodwill Value\",\"Total Liabilities Value\",\"Misc Stocks Options Warrants Value\",");
        sqlQuery.append("\"Redeemable Preferred Stock Value\",\"Preferred Stock Value\",\"Common Stock Value\",\"Retained Earnings Value\",");
        sqlQuery.append("\"Treasury Stock Value\",\"Capital Surplus Value\",\"Other Stockholder Equity Value\",\"Total Equity Value\",");
        sqlQuery.append("\"Total Liabilites & Equity\",\"LTV/CAC Value\",\"Company Type\",\"currencytype\",\"denomination\",\"type\",sfid,projectiondate,sfdcunique");
        sqlQuery.append(" From reports ");
        sqlQuery.append(" WHERE sfid ='" + sfdcId + "'");
        sqlQuery.append(" AND projectiondate ='" + datestr + "'");
        System.out.println("---sqlQuery---" + sqlQuery);
        pst = conn.prepareStatement(sqlQuery.toString());
        rs = pst.executeQuery();
        int i = 0;
        String jsonstr = "";

        jsonstr = "{";

        while (rs.next()) {
            System.out.println(i + " Total Revenue Value--sfdcunique---" + rs.getString("Total Revenue Value"));
            System.out.println(i + " getPublicRecord--sfdcunique---" + rs.getString("sfdcunique"));
            System.out.println(i + " getPublicRecord--projectiondate---" + rs.getString("projectiondate"));
            jsonstr += "\"propuyear_" + i + "\":\"" + rs.getString("Year") + "\",";
            jsonstr += "\"propuqtr_" + i + "\":\"" + rs.getString("Quarter") + "\",";
            jsonstr += "\"propurev_" + i + "\":\"" + rs.getString("Total Revenue Value") + "\",";
            jsonstr += "\"propucor_" + i + "\":\"" + rs.getString("Cost of Revenue Value") + "\",";
            jsonstr += "\"propugp_" + i + "\":\"" + rs.getString("Gross Profit Value") + "\",";
            jsonstr += "\"propugm_" + i + "\":\"" + rs.getString("Gross Margin") + "\",";
            jsonstr += "\"propurd_" + i + "\":\"" + rs.getString("R&D Value") + "\",";
            jsonstr += "\"propusga_" + i + "\":\"" + rs.getString("SG&A Value") + "\",";
            jsonstr += "\"propunr_" + i + "\":\"" + rs.getString("Non Recurring Value") + "\",";
            jsonstr += "\"propuoe_" + i + "\":\"" + rs.getString("Others Value") + "\",";
            jsonstr += "\"proputoe_" + i + "\":\"" + rs.getString("Total Operating Expenses Value") + "\",";
            jsonstr += "\"propuebitba_" + i + "\":\"" + rs.getString("EBITDA") + "\",";
            jsonstr += "\"proputoien_" + i + "\":\"" + rs.getString("Total Other Income Expenses Net Value") + "\",";
            jsonstr += "\"propuebit_" + i + "\":\"" + rs.getString("EBIT Value") + "\",";
            jsonstr += "\"propuit_" + i + "\":\"" + rs.getString("Interest Expense Value") + "\",";
            jsonstr += "\"propuibt_" + i + "\":\"" + rs.getString("Income Before Tax Value") + "\",";
            jsonstr += "\"propuite_" + i + "\":\"" + rs.getString("Income Tax Expense Value") + "\",";
            jsonstr += "\"propumino_" + i + "\":\"" + rs.getString("Minority Interest Value") + "\",";
            jsonstr += "\"propudo_" + i + "\":\"" + rs.getString("Discontinued Ops Value") + "\",";
            jsonstr += "\"propuei_" + i + "\":\"" + rs.getString("Extraordinary Items Value") + "\",";
            jsonstr += "\"propueoac_" + i + "\":\"" + rs.getString("Effect of Accounting Changes Value") + "\",";
            jsonstr += "\"propuoi_" + i + "\":\"" + rs.getString("Other Items Value") + "\",";
            jsonstr += "\"propunil_" + i + "\":\"" + rs.getString("Net Income Value") + "\",";
            jsonstr += "\"propucae_" + i + "\":\"" + rs.getString("Cash & Equivalents Value") + "\",";
            jsonstr += "\"propusti_" + i + "\":\"" + rs.getString("Short Term Investments Value") + "\",";
            jsonstr += "\"propunre_" + i + "\":\"" + rs.getString("Net Receivables Value") + "\",";
            jsonstr += "\"propuinvtry_" + i + "\":\"" + rs.getString("Inventory Value") + "\",";
            jsonstr += "\"propuoca_" + i + "\":\"" + rs.getString("Other Current Assets Value") + "\",";
            jsonstr += "\"proputcass_" + i + "\":\"" + rs.getString("Total Current Assets Value") + "\",";
            jsonstr += "\"propulti_" + i + "\":\"" + rs.getString("Long Term Investments Value") + "\",";
            jsonstr += "\"propuppe_" + i + "\":\"" + rs.getString("PP&E Value") + "\",";
            jsonstr += "\"propugw_" + i + "\":\"" + rs.getString("Goodwill Value") + "\",";
            jsonstr += "\"propuia_" + i + "\":\"" + rs.getString("Intangible Assets Value") + "\",";
            jsonstr += "\"propuaa_" + i + "\":\"" + rs.getString("Accumulated Amortization Value") + "\",";
            jsonstr += "\"propuoa_" + i + "\":\"" + rs.getString("Other Assets Value") + "\",";
            jsonstr += "\"propudltac_" + i + "\":\"" + rs.getString("Deferred Long Term Asset Charges Value") + "\",";
            jsonstr += "\"proputa_" + i + "\":\"" + rs.getString("Total Assets Value") + "\",";
            jsonstr += "\"propuscltd_" + i + "\":\"" + rs.getString("Short/Current Long Term Debt Value") + "\",";
            jsonstr += "\"propuap_" + i + "\":\"" + rs.getString("Accounts Payable Value") + "\",";
            jsonstr += "\"propuocl_" + i + "\":\"" + rs.getString("Other Current Liabilities Value") + "\",";
            jsonstr += "\"proputcl_" + i + "\":\"" + rs.getString("Total Current Liabilities Value") + "\",";
            jsonstr += "\"propultd_" + i + "\":\"" + rs.getString("Long Term Debt Value") + "\",";
            jsonstr += "\"propuolia_" + i + "\":\"" + rs.getString("Other Liabilities Value") + "\",";
            jsonstr += "\"propudltlc_" + i + "\":\"" + rs.getString("Deferred Long Term Liability Charges Value") + "\",";
            jsonstr += "\"propumi_" + i + "\":\"" + rs.getString("Minority Interest (BS)") + "\",";
            jsonstr += "\"propungw_" + i + "\":\"" + rs.getString("Negative Goodwill Value") + "\",";
            jsonstr += "\"proputotlia_" + i + "\":\"" + rs.getString("Total Liabilities Value") + "\",";
            jsonstr += "\"propumsow_" + i + "\":\"" + rs.getString("Misc Stocks Options Warrants Value") + "\",";
            jsonstr += "\"propurps_" + i + "\":\"" + rs.getString("Redeemable Preferred Stock Value") + "\",";
            jsonstr += "\"propups_" + i + "\":\"" + rs.getString("Preferred Stock Value") + "\",";
            jsonstr += "\"propucs_" + i + "\":\"" + rs.getString("Common Stock Value") + "\",";
            jsonstr += "\"propure_" + i + "\":\"" + rs.getString("Retained Earnings Value") + "\",";
            jsonstr += "\"proputs_" + i + "\":\"" + rs.getString("Treasury Stock Value") + "\",";
            jsonstr += "\"propucas_" + i + "\":\"" + rs.getString("Capital Surplus Value") + "\",";
            jsonstr += "\"propuose_" + i + "\":\"" + rs.getString("Other Stockholder Equity Value") + "\",";
            jsonstr += "\"proputote_" + i + "\":\"" + rs.getString("Total Equity Value") + "\",";
            jsonstr += "\"proputle_" + i + "\":\"" + rs.getString("Total Liabilites & Equity") + "\",";
            jsonstr += "\"propultvac_" + i + "\":\"" + rs.getString("LTV/CAC Value").substring(0, rs.getString("LTV/CAC Value").indexOf(".")) + "\",";
            jsonstr += "\"cmptype_" + i + "\":\"" + rs.getString("Company Type") + "\",";
            jsonstr += "\"currency_" + i + "\":\"" + rs.getString("currencytype") + "\",";
            jsonstr += "\"denomination_" + i + "\":\"" + rs.getString("denomination") + "\",";
            i++;
        }
        jsonstr = jsonstr.substring(0, jsonstr.length() - 1);;
        jsonstr += "}";

        return jsonstr;
    }

    public static String getPrivateProjectionRecordsDate(Connection conn, String sfdcId) throws SQLException {
        PreparedStatement pst = null;
        ResultSet rs = null;

        StringBuilder sqlQuery = new StringBuilder();
        sqlQuery.append("SELECT DISTINCT ");
        sqlQuery.append("  projectiondate ");
        sqlQuery.append(" From reports ");
        sqlQuery.append(" WHERE sfid ='" + sfdcId + "'");
        sqlQuery.append(" AND \"type\" ='Projection'");
        sqlQuery.append(" ORDER BY projectiondate Desc");

        System.out.println("---sqlQuery---" + sqlQuery);
        pst = conn.prepareStatement(sqlQuery.toString());
        rs = pst.executeQuery();
        int i = 0;
        String jsonstr = "";

        jsonstr = "[";

        while (rs.next()) {
            System.out.println(i + "--sfdcunique---" + rs.getString("projectiondate"));
            jsonstr += "{\"id\":\"" + rs.getString("projectiondate") + "\",\"value\":\"" + rs.getString("projectiondate") + "\"},";
        }
        jsonstr = jsonstr.substring(0, jsonstr.length() - 1);;
        jsonstr += "]";

        return jsonstr;
    }

    public static String getPublicRecord(Connection conn, String sfdcId) throws SQLException {
        PreparedStatement pst = null;
        ResultSet rs = null;

        StringBuilder sqlQuery = new StringBuilder();
        sqlQuery.append("SELECT ");
        sqlQuery.append("\"Year\",\"Quarter\",\"Total Revenue Value\",\"Cost of Revenue Value\",");
        sqlQuery.append("\"Gross Profit Value\",\"Gross Margin\",\"R&D Value\",\"SG&A Value\",");
        sqlQuery.append("\"Non Recurring Value\",\"Others Value\",\"Total Operating Expenses Value\",\"EBITDA\",");
        sqlQuery.append("\"Total Other Income Expenses Net Value\",\"EBIT Value\",\"Interest Expense Value\",\"Income Before Tax Value\",");
        sqlQuery.append("\"Income Tax Expense Value\",\"Minority Interest Value\",\"Discontinued Ops Value\",\"Extraordinary Items Value\",");
        sqlQuery.append("\"Effect of Accounting Changes Value\",\"Other Items Value\",\"Net Income Value\",\"Cash & Equivalents Value\",");
        sqlQuery.append("\"Short Term Investments Value\",\"Net Receivables Value\",\"Inventory Value\",\"Other Current Assets Value\",");
        sqlQuery.append("\"Total Current Assets Value\",\"Long Term Investments Value\",\"PP&E Value\",\"Goodwill Value\",");
        sqlQuery.append("\"Intangible Assets Value\",\"Accumulated Amortization Value\",\"Other Assets Value\",\"Deferred Long Term Asset Charges Value\",");
        sqlQuery.append("\"Total Assets Value\",\"Short/Current Long Term Debt Value\",\"Accounts Payable Value\",\"Other Current Liabilities Value\",");
        sqlQuery.append("\"Total Current Liabilities Value\",\"Long Term Debt Value\",\"Other Liabilities Value\",\"Deferred Long Term Liability Charges Value\",");
        sqlQuery.append("\"Minority Interest (BS)\",\"Negative Goodwill Value\",\"Total Liabilities Value\",\"Misc Stocks Options Warrants Value\",");
        sqlQuery.append("\"Redeemable Preferred Stock Value\",\"Preferred Stock Value\",\"Common Stock Value\",\"Retained Earnings Value\",");
        sqlQuery.append("\"Treasury Stock Value\",\"Capital Surplus Value\",\"Other Stockholder Equity Value\",\"Total Equity Value\",");
        sqlQuery.append("\"Total Liabilites & Equity\",\"LTV/CAC Value\",\"Company Type\",\"currencytype\",\"denomination\",\"type\",sfid,sfdcunique");
        sqlQuery.append(" From reports ");
        sqlQuery.append(" WHERE sfid ='" + sfdcId + "'");
        sqlQuery.append(" AND \"type\" ='Actuals'");
        sqlQuery.append(" ORDER BY sfdcunique ");

        System.out.println("---sqlQuery---" + sqlQuery);
        pst = conn.prepareStatement(sqlQuery.toString());
        rs = pst.executeQuery();
        int i = 0;
        String jsonstr = "";

        jsonstr = "{";

        while (rs.next()) {
            System.out.println(i + " getPublicRecord--sfdcunique---" + rs.getString("sfdcunique"));
            jsonstr += "\"puyear_" + i + "\":\"" + rs.getString("Year") + "\",";
            jsonstr += "\"puqtr_" + i + "\":\"" + rs.getString("Quarter") + "\",";
            jsonstr += "\"purev_" + i + "\":\"" + rs.getString("Total Revenue Value") + "\",";
            jsonstr += "\"pucor_" + i + "\":\"" + rs.getString("Cost of Revenue Value") + "\",";
            jsonstr += "\"pugp_" + i + "\":\"" + rs.getString("Gross Profit Value") + "\",";
            jsonstr += "\"pugm_" + i + "\":\"" + rs.getString("Gross Margin") + "\",";
            jsonstr += "\"purd_" + i + "\":\"" + rs.getString("R&D Value") + "\",";
            jsonstr += "\"pusga_" + i + "\":\"" + rs.getString("SG&A Value") + "\",";
            jsonstr += "\"punr_" + i + "\":\"" + rs.getString("Non Recurring Value") + "\",";
            jsonstr += "\"puoe_" + i + "\":\"" + rs.getString("Others Value") + "\",";
            jsonstr += "\"putoe_" + i + "\":\"" + rs.getString("Total Operating Expenses Value") + "\",";
            jsonstr += "\"puebitba_" + i + "\":\"" + rs.getString("EBITDA") + "\",";
            jsonstr += "\"putoien_" + i + "\":\"" + rs.getString("Total Other Income Expenses Net Value") + "\",";
            jsonstr += "\"puebit_" + i + "\":\"" + rs.getString("EBIT Value") + "\",";
            jsonstr += "\"puit_" + i + "\":\"" + rs.getString("Interest Expense Value") + "\",";
            jsonstr += "\"puibt_" + i + "\":\"" + rs.getString("Income Before Tax Value") + "\",";
            jsonstr += "\"puite_" + i + "\":\"" + rs.getString("Income Tax Expense Value") + "\",";
            jsonstr += "\"pumino_" + i + "\":\"" + rs.getString("Minority Interest Value") + "\",";
            jsonstr += "\"pudo_" + i + "\":\"" + rs.getString("Discontinued Ops Value") + "\",";
            jsonstr += "\"puei_" + i + "\":\"" + rs.getString("Extraordinary Items Value") + "\",";
            jsonstr += "\"pueoac_" + i + "\":\"" + rs.getString("Effect of Accounting Changes Value") + "\",";
            jsonstr += "\"puoi_" + i + "\":\"" + rs.getString("Other Items Value") + "\",";
            jsonstr += "\"punil_" + i + "\":\"" + rs.getString("Net Income Value") + "\",";
            jsonstr += "\"pucae_" + i + "\":\"" + rs.getString("Cash & Equivalents Value") + "\",";
            jsonstr += "\"pusti_" + i + "\":\"" + rs.getString("Short Term Investments Value") + "\",";
            jsonstr += "\"punre_" + i + "\":\"" + rs.getString("Net Receivables Value") + "\",";
            jsonstr += "\"puinvtry_" + i + "\":\"" + rs.getString("Inventory Value") + "\",";
            jsonstr += "\"puoca_" + i + "\":\"" + rs.getString("Other Current Assets Value") + "\",";
            jsonstr += "\"putcass_" + i + "\":\"" + rs.getString("Total Current Assets Value") + "\",";
            jsonstr += "\"pulti_" + i + "\":\"" + rs.getString("Long Term Investments Value") + "\",";
            jsonstr += "\"puppe_" + i + "\":\"" + rs.getString("PP&E Value") + "\",";
            jsonstr += "\"pugw_" + i + "\":\"" + rs.getString("Goodwill Value") + "\",";
            jsonstr += "\"puia_" + i + "\":\"" + rs.getString("Intangible Assets Value") + "\",";
            jsonstr += "\"puaa_" + i + "\":\"" + rs.getString("Accumulated Amortization Value") + "\",";
            jsonstr += "\"puoa_" + i + "\":\"" + rs.getString("Other Assets Value") + "\",";
            jsonstr += "\"pudltac_" + i + "\":\"" + rs.getString("Deferred Long Term Asset Charges Value") + "\",";
            jsonstr += "\"puta_" + i + "\":\"" + rs.getString("Total Assets Value") + "\",";
            jsonstr += "\"puscltd_" + i + "\":\"" + rs.getString("Short/Current Long Term Debt Value") + "\",";
            jsonstr += "\"puap_" + i + "\":\"" + rs.getString("Accounts Payable Value") + "\",";
            jsonstr += "\"puocl_" + i + "\":\"" + rs.getString("Other Current Liabilities Value") + "\",";
            jsonstr += "\"putcl_" + i + "\":\"" + rs.getString("Total Current Liabilities Value") + "\",";
            jsonstr += "\"pultd_" + i + "\":\"" + rs.getString("Long Term Debt Value") + "\",";
            jsonstr += "\"puolia_" + i + "\":\"" + rs.getString("Other Liabilities Value") + "\",";
            jsonstr += "\"pudltlc_" + i + "\":\"" + rs.getString("Deferred Long Term Liability Charges Value") + "\",";
            jsonstr += "\"pumi_" + i + "\":\"" + rs.getString("Minority Interest (BS)") + "\",";
            jsonstr += "\"pungw_" + i + "\":\"" + rs.getString("Negative Goodwill Value") + "\",";
            jsonstr += "\"putotlia_" + i + "\":\"" + rs.getString("Total Liabilities Value") + "\",";
            jsonstr += "\"pumsow_" + i + "\":\"" + rs.getString("Misc Stocks Options Warrants Value") + "\",";
            jsonstr += "\"purps_" + i + "\":\"" + rs.getString("Redeemable Preferred Stock Value") + "\",";
            jsonstr += "\"pups_" + i + "\":\"" + rs.getString("Preferred Stock Value") + "\",";
            jsonstr += "\"pucs_" + i + "\":\"" + rs.getString("Common Stock Value") + "\",";
            jsonstr += "\"pure_" + i + "\":\"" + rs.getString("Retained Earnings Value") + "\",";
            jsonstr += "\"puts_" + i + "\":\"" + rs.getString("Treasury Stock Value") + "\",";
            jsonstr += "\"pucas_" + i + "\":\"" + rs.getString("Capital Surplus Value") + "\",";
            jsonstr += "\"puose_" + i + "\":\"" + rs.getString("Other Stockholder Equity Value") + "\",";
            jsonstr += "\"putote_" + i + "\":\"" + rs.getString("Total Equity Value") + "\",";
            jsonstr += "\"putle_" + i + "\":\"" + rs.getString("Total Liabilites & Equity") + "\",";
            jsonstr += "\"pultvac_" + i + "\":\"" + rs.getString("LTV/CAC Value").substring(0, rs.getString("LTV/CAC Value").indexOf(".")) + "\",";
            jsonstr += "\"cmptype_" + i + "\":\"" + rs.getString("Company Type") + "\",";
            jsonstr += "\"currency_" + i + "\":\"" + rs.getString("currencytype") + "\",";
            jsonstr += "\"denomination_" + i + "\":\"" + rs.getString("denomination") + "\",";
            i++;
        }
        jsonstr = jsonstr.substring(0, jsonstr.length() - 1);;
        jsonstr += "}";

        return jsonstr;
    }
    
    

    public static String updatePrivateFinancialDataManager(Connection conn, FinancialModel fmodel) throws ClassNotFoundException, SQLException {
        String type = "";
        StringBuilder sqlQuery = new StringBuilder();
        try {

            PreparedStatement pst = null;
            for (int j = 0; j < fmodel.getPrivatelst().size(); j++) {
                type = fmodel.privatelst.get(j).tabtype;
                sqlQuery = new StringBuilder();
                sqlQuery.append("UPDATE reports set ");
                sqlQuery.append("\"Year\"=" + fmodel.privatelst.get(j).year);
                sqlQuery.append(",\"Quarter\"='" + fmodel.privatelst.get(j).qtr + "'");
                sqlQuery.append(",\"Total Revenue Value\"=" + fmodel.privatelst.get(j).rev);
                sqlQuery.append(",\"Cost of Revenue Value\"=" + fmodel.privatelst.get(j).cor);
                sqlQuery.append(",\"Gross Profit Value\"=" + fmodel.privatelst.get(j).gp);
                sqlQuery.append(",\"Gross Margin Value\"=" + fmodel.privatelst.get(j).gm);
                sqlQuery.append(",\"R&D Value\"=" + fmodel.privatelst.get(j).rd);
                sqlQuery.append(",\"S&M Value\"=" + fmodel.privatelst.get(j).sm);
                sqlQuery.append(",\"G&A Value\"=" + fmodel.privatelst.get(j).ga);
                sqlQuery.append(",\"Others Value\"=" + fmodel.privatelst.get(j).oe);
                sqlQuery.append(",\"Total Operating Expenses Value\"=" + fmodel.privatelst.get(j).toe);
                sqlQuery.append(",\"EBITDA\"=" + fmodel.privatelst.get(j).ebitba);
                sqlQuery.append(",\"EBITDA Margin Value\"=" + fmodel.privatelst.get(j).ebitbam);
                sqlQuery.append(",\"Other Income Expenses Net Value\"=" + fmodel.privatelst.get(j).oien);
                sqlQuery.append(",\"Income Tax Expense Value\"=" + fmodel.privatelst.get(j).it);
                sqlQuery.append(",\"Net Income Value\"=" + fmodel.privatelst.get(j).nl);
                sqlQuery.append(",\"Cash & Equivalents Value\"=" + fmodel.privatelst.get(j).cae);
                sqlQuery.append(",\"Restricted Cash\"=" + fmodel.privatelst.get(j).rc);
                sqlQuery.append(",\"Short Term Investments Value\"=" + fmodel.privatelst.get(j).sti);
                sqlQuery.append(",\"Inventory Value\"=" + fmodel.privatelst.get(j).invtry);
                sqlQuery.append(",\"Net Receivables Value\"=" + fmodel.privatelst.get(j).ar);
                sqlQuery.append(",\"Prepaid Expenses\"=" + fmodel.privatelst.get(j).pe);
                sqlQuery.append(",\"Other Current Assets Value\"=" + fmodel.privatelst.get(j).oca);
                sqlQuery.append(",\"Total Current Assets Value\"=" + fmodel.privatelst.get(j).tca);
                sqlQuery.append(",\"PP&E Value\"=" + fmodel.privatelst.get(j).ppe);
                sqlQuery.append(",\"Accumulated Amortization Value\"=" + fmodel.privatelst.get(j).ada);
                sqlQuery.append(",\"Intangible Assets Value\"=" + fmodel.privatelst.get(j).intg);
                sqlQuery.append(",\"Other Assets Value\"=" + fmodel.privatelst.get(j).onca);
                sqlQuery.append(",\"Total Assets Value\"=" + fmodel.privatelst.get(j).totass);
                sqlQuery.append(",\"Short/Current Long Term Debt Value\"=" + fmodel.privatelst.get(j).std);
                sqlQuery.append(",\"Accounts Payable Value\"=" + fmodel.privatelst.get(j).ap);
                sqlQuery.append(",\"Deferred Revenue\"=" + fmodel.privatelst.get(j).dr);
                sqlQuery.append(",\"Accrued Liabilities\"=" + fmodel.privatelst.get(j).al);
                sqlQuery.append(",\"Other Current Liabilities Value\"=" + fmodel.privatelst.get(j).ocl);
                sqlQuery.append(",\"Total Current Liabilities Value\"=" + fmodel.privatelst.get(j).tcl);
                sqlQuery.append(",\"Long Term Debt Value\"=" + fmodel.privatelst.get(j).ltd);
                sqlQuery.append(",\"Other Liabilities Value\"=" + fmodel.privatelst.get(j).oncl);
                sqlQuery.append(",\"Total Liabilities Value\"=" + fmodel.privatelst.get(j).totlia);
                sqlQuery.append(",\"Capital Stock\"=" + fmodel.privatelst.get(j).cs);
                sqlQuery.append(",\"Retained Earnings Value\"=" + fmodel.privatelst.get(j).re);
                sqlQuery.append(",\"Total Equity Value\"=" + fmodel.privatelst.get(j).toteq);
                sqlQuery.append(",\"Total Liabilities & Equity\"=" + fmodel.privatelst.get(j).tle);
                sqlQuery.append(",\"LTV/CAC Value\"=" + fmodel.privatelst.get(j).ltvac);
                sqlQuery.append(",\"currencytype\"='" + fmodel.privatelst.get(j).currency + "'");
                sqlQuery.append(",\"denomination\"='" + fmodel.privatelst.get(j).denomination + "'");
                sqlQuery.append(" WHERE sfdcunique ='" + fmodel.privatelst.get(j).sfdcunique + "'");

                System.out.println("update---sqlQuery---" + sqlQuery);
                pst = conn.prepareStatement(sqlQuery.toString());
                pst.executeUpdate();

            }

        } catch (SQLException sqlex) {
            System.out.println("---sqlex----" + sqlex);
            Logger.getLogger(CompanyDataManager.class.getName()).log(Level.SEVERE, null, sqlex);
            return sqlex.toString();
        }
        return "Private " + type + " Financial Data updated successfully ";

    }

    public static String updatePrivateProjectionFinancialDataManager(Connection conn, FinancialModel fmodel) throws ClassNotFoundException, SQLException {
        String type = "";
        StringBuilder sqlQuery = new StringBuilder();
        try {

            PreparedStatement pst = null;
            for (int j = 0; j < fmodel.getPrivatelst().size(); j++) {
                type = fmodel.privatelst.get(j).tabtype;
                sqlQuery = new StringBuilder();
                sqlQuery.append("UPDATE reports set ");
                sqlQuery.append("\"Year\"=" + fmodel.privatelst.get(j).year);
                sqlQuery.append(",\"Quarter\"='" + fmodel.privatelst.get(j).qtr + "'");
                sqlQuery.append(",\"Total Revenue Value\"=" + fmodel.privatelst.get(j).rev);
                sqlQuery.append(",\"Cost of Revenue Value\"=" + fmodel.privatelst.get(j).cor);
                sqlQuery.append(",\"Gross Profit Value\"=" + fmodel.privatelst.get(j).gp);
                sqlQuery.append(",\"Gross Margin Value\"=" + fmodel.privatelst.get(j).gm);
                sqlQuery.append(",\"R&D Value\"=" + fmodel.privatelst.get(j).rd);
                sqlQuery.append(",\"S&M Value\"=" + fmodel.privatelst.get(j).sm);
                sqlQuery.append(",\"G&A Value\"=" + fmodel.privatelst.get(j).ga);
                sqlQuery.append(",\"Others Value\"=" + fmodel.privatelst.get(j).oe);
                sqlQuery.append(",\"Total Operating Expenses Value\"=" + fmodel.privatelst.get(j).toe);
                sqlQuery.append(",\"EBITDA\"=" + fmodel.privatelst.get(j).ebitba);
                sqlQuery.append(",\"EBITDA Margin Value\"=" + fmodel.privatelst.get(j).ebitbam);
                sqlQuery.append(",\"Other Income Expenses Net Value\"=" + fmodel.privatelst.get(j).oien);
                sqlQuery.append(",\"Income Tax Expense Value\"=" + fmodel.privatelst.get(j).it);
                sqlQuery.append(",\"Net Income Value\"=" + fmodel.privatelst.get(j).nl);
                sqlQuery.append(",\"Cash & Equivalents Value\"=" + fmodel.privatelst.get(j).cae);
                sqlQuery.append(",\"Restricted Cash\"=" + fmodel.privatelst.get(j).rc);
                sqlQuery.append(",\"Short Term Investments Value\"=" + fmodel.privatelst.get(j).sti);
                sqlQuery.append(",\"Inventory Value\"=" + fmodel.privatelst.get(j).invtry);
                sqlQuery.append(",\"Net Receivables Value\"=" + fmodel.privatelst.get(j).ar);
                sqlQuery.append(",\"Prepaid Expenses\"=" + fmodel.privatelst.get(j).pe);
                sqlQuery.append(",\"Other Current Assets Value\"=" + fmodel.privatelst.get(j).oca);
                sqlQuery.append(",\"Total Current Assets Value\"=" + fmodel.privatelst.get(j).tca);
                sqlQuery.append(",\"PP&E Value\"=" + fmodel.privatelst.get(j).ppe);
                sqlQuery.append(",\"Accumulated Amortization Value\"=" + fmodel.privatelst.get(j).ada);
                sqlQuery.append(",\"Intangible Assets Value\"=" + fmodel.privatelst.get(j).intg);
                sqlQuery.append(",\"Other Assets Value\"=" + fmodel.privatelst.get(j).onca);
                sqlQuery.append(",\"Total Assets Value\"=" + fmodel.privatelst.get(j).totass);
                sqlQuery.append(",\"Short/Current Long Term Debt Value\"=" + fmodel.privatelst.get(j).std);
                sqlQuery.append(",\"Accounts Payable Value\"=" + fmodel.privatelst.get(j).ap);
                sqlQuery.append(",\"Deferred Revenue\"=" + fmodel.privatelst.get(j).dr);
                sqlQuery.append(",\"Accrued Liabilities\"=" + fmodel.privatelst.get(j).al);
                sqlQuery.append(",\"Other Current Liabilities Value\"=" + fmodel.privatelst.get(j).ocl);
                sqlQuery.append(",\"Total Current Liabilities Value\"=" + fmodel.privatelst.get(j).tcl);
                sqlQuery.append(",\"Long Term Debt Value\"=" + fmodel.privatelst.get(j).ltd);
                sqlQuery.append(",\"Other Liabilities Value\"=" + fmodel.privatelst.get(j).oncl);
                sqlQuery.append(",\"Total Liabilities Value\"=" + fmodel.privatelst.get(j).totlia);
                sqlQuery.append(",\"Capital Stock\"=" + fmodel.privatelst.get(j).cs);
                sqlQuery.append(",\"Retained Earnings Value\"=" + fmodel.privatelst.get(j).re);
                sqlQuery.append(",\"Total Equity Value\"=" + fmodel.privatelst.get(j).toteq);
                sqlQuery.append(",\"Total Liabilities & Equity\"=" + fmodel.privatelst.get(j).tle);
                sqlQuery.append(",\"LTV/CAC Value\"=" + fmodel.privatelst.get(j).ltvac);
                sqlQuery.append(",\"currencytype\"='" + fmodel.privatelst.get(j).currency + "'");
                sqlQuery.append(",\"denomination\"='" + fmodel.privatelst.get(j).denomination + "'");
                sqlQuery.append(" WHERE sfdcunique ='" + fmodel.privatelst.get(j).sfdcunique + "'");

                System.out.println("update---sqlQuery---" + sqlQuery);
                pst = conn.prepareStatement(sqlQuery.toString());
                pst.executeUpdate();

            }

        } catch (SQLException sqlex) {
            System.out.println("---sqlex----" + sqlex);
            Logger.getLogger(CompanyDataManager.class.getName()).log(Level.SEVERE, null, sqlex);
            return sqlex.toString();
        }
        return "Private " + type + " Financial Data updated successfully ";

    }

    public static String updatePublicFinancialDataManager(Connection conn, FinancialModel fmodel) throws ClassNotFoundException, SQLException {
        String type = "";
        StringBuilder sqlQuery = new StringBuilder();
        try {

            PreparedStatement pst = null;
            for (int j = 0; j < fmodel.getPubliclst().size(); j++) {
                type = fmodel.publiclst.get(j).tabtype;
                sqlQuery = new StringBuilder();
                sqlQuery.append("UPDATE reports set ");
                sqlQuery.append("\"Year\"=" + fmodel.publiclst.get(j).puyear);
                sqlQuery.append(",\"Quarter\"='" + fmodel.publiclst.get(j).puqtr + "'");
                sqlQuery.append(",\"Total Revenue Value\"=" + fmodel.publiclst.get(j).purev);
                sqlQuery.append(",\"Cost of Revenue Value\"=" + fmodel.publiclst.get(j).pucor);
                sqlQuery.append(",\"Gross Profit Value\"=" + fmodel.publiclst.get(j).pugp);
                sqlQuery.append(",\"Gross Margin Value\"=" + fmodel.publiclst.get(j).pugm);
                sqlQuery.append(",\"R&D Value\"=" + fmodel.publiclst.get(j).purd);
                sqlQuery.append(",\"SG&A Value\"=" + fmodel.publiclst.get(j).pusga);
                sqlQuery.append(",\"Non Recurring Value\"=" + fmodel.publiclst.get(j).punr);
                sqlQuery.append(",\"Others Value\"=" + fmodel.publiclst.get(j).puoe);
                sqlQuery.append(",\"Total Operating Expenses Value\"=" + fmodel.publiclst.get(j).putoe);
                sqlQuery.append(",\"EBITDA\"=" + fmodel.publiclst.get(j).puebitba);
                sqlQuery.append(",\"Total Other Income Expenses Net Value\"=" + fmodel.publiclst.get(j).putoien);
                sqlQuery.append(",\"EBIT Value\"=" + fmodel.publiclst.get(j).puebit);
                sqlQuery.append(",\"Interest Expense Value\"=" + fmodel.publiclst.get(j).puit);
                sqlQuery.append(",\"Income Before Tax Value\"=" + fmodel.publiclst.get(j).puibt);
                sqlQuery.append(",\"Income Tax Expense Value\"=" + fmodel.publiclst.get(j).puite);
                sqlQuery.append(",\"Minority Interest Value\"=" + fmodel.publiclst.get(j).pumino);
                sqlQuery.append(",\"Discontinued Ops Value\"=" + fmodel.publiclst.get(j).pudo);
                sqlQuery.append(",\"Extraordinary Items Value\"=" + fmodel.publiclst.get(j).puoi);
                sqlQuery.append(",\"Effect of Accounting Changes Value\"=" + fmodel.publiclst.get(j).pueoac);
                sqlQuery.append(",\"Other Items Value\"=" + fmodel.publiclst.get(j).puoi);
                sqlQuery.append(",\"Net Income Value\"=" + fmodel.publiclst.get(j).punil);
                sqlQuery.append(",\"Cash & Equivalents Value\"=" + fmodel.publiclst.get(j).pucae);
                sqlQuery.append(",\"Short Term Investments Value\"=" + fmodel.publiclst.get(j).pusti);
                sqlQuery.append(",\"Net Receivables Value\"=" + fmodel.publiclst.get(j).punre);
                sqlQuery.append(",\"Inventory Value\"=" + fmodel.publiclst.get(j).puinvtry);
                sqlQuery.append(",\"Other Current Assets Value\"=" + fmodel.publiclst.get(j).puoca);
                sqlQuery.append(",\"Total Current Assets Value\"=" + fmodel.publiclst.get(j).putcass);
                sqlQuery.append(",\"Long Term Investments Value\"=" + fmodel.publiclst.get(j).pulti);
                sqlQuery.append(",\"PP&E Value\"=" + fmodel.publiclst.get(j).puppe);
                sqlQuery.append(",\"Goodwill Value\"=" + fmodel.publiclst.get(j).pugw);
                sqlQuery.append(",\"Intangible Assets Value\"=" + fmodel.publiclst.get(j).puia);
                sqlQuery.append(",\"Accumulated Amortization Value\"=" + fmodel.publiclst.get(j).puaa);
                sqlQuery.append(",\"Other Assets Value\"=" + fmodel.publiclst.get(j).puoa);
                sqlQuery.append(",\"Deferred Long Term Asset Charges Value\"=" + fmodel.publiclst.get(j).pudltac);
                sqlQuery.append(",\"Total Assets Value\"=" + fmodel.publiclst.get(j).puta);
                sqlQuery.append(",\"Short/Current Long Term Debt Value\"=" + fmodel.publiclst.get(j).puscltd);
                sqlQuery.append(",\"Accounts Payable Value\"=" + fmodel.publiclst.get(j).puap);
                sqlQuery.append(",\"Other Current Liabilities Value\"=" + fmodel.publiclst.get(j).puocl);
                sqlQuery.append(",\"Total Current Liabilities Value\"=" + fmodel.publiclst.get(j).putcl);
                sqlQuery.append(",\"Long Term Debt Value\"=" + fmodel.publiclst.get(j).pultd);
                sqlQuery.append(",\"Other Liabilities Value\"=" + fmodel.publiclst.get(j).puolia);
                sqlQuery.append(",\"Deferred Long Term Liability Charges Value\"=" + fmodel.publiclst.get(j).pudltlc);
                sqlQuery.append(",\"Minority Interest (BS)\"=" + fmodel.publiclst.get(j).pumi);
                sqlQuery.append(",\"Negative Goodwill Value\"=" + fmodel.publiclst.get(j).pungw);
                sqlQuery.append(",\"Total Liabilities Value\"=" + fmodel.publiclst.get(j).putotlia);
                sqlQuery.append(",\"Misc Stocks Options Warrants Value\"=" + fmodel.publiclst.get(j).pumsow);
                sqlQuery.append(",\"Redeemable Preferred Stock Value\"=" + fmodel.publiclst.get(j).purps);
                sqlQuery.append(",\"Preferred Stock Value\"=" + fmodel.publiclst.get(j).pups);
                sqlQuery.append(",\"Common Stock Value\"=" + fmodel.publiclst.get(j).pucs);
                sqlQuery.append(",\"Retained Earnings Value\"=" + fmodel.publiclst.get(j).pure);
                sqlQuery.append(",\"Treasury Stock Value\"=" + fmodel.publiclst.get(j).puts);
                sqlQuery.append(",\"Capital Surplus Value\"=" + fmodel.publiclst.get(j).pucas);
                sqlQuery.append(",\"Other Stockholder Equity Value\"=" + fmodel.publiclst.get(j).puose);
                sqlQuery.append(",\"Total Equity Value\"=" + fmodel.publiclst.get(j).putote);
                sqlQuery.append(",\"Total Liabilites & Equity\"=" + fmodel.publiclst.get(j).putle);
                sqlQuery.append(",\"LTV/CAC Value\"=" + fmodel.publiclst.get(j).pultvac);
                sqlQuery.append(",\"currencytype\"='" + fmodel.publiclst.get(j).currency + "'");
                sqlQuery.append(",\"denomination\"='" + fmodel.publiclst.get(j).denomination + "'");
                sqlQuery.append(" WHERE sfdcunique ='" + fmodel.publiclst.get(j).sfdcunique + "'");

                System.out.println("update---sqlQuery---" + sqlQuery);
                pst = conn.prepareStatement(sqlQuery.toString());
                pst.executeUpdate();

            }

        } catch (SQLException sqlex) {
            System.out.println("---sqlex----" + sqlex);
            Logger.getLogger(CompanyDataManager.class.getName()).log(Level.SEVERE, null, sqlex);
            return sqlex.toString();
        }
        return "Public " + type + " Financial Data updated successfully ";

    }
    public static String updatePublicFinancialFinancialDataManager(Connection conn, FinancialModel fmodel) throws ClassNotFoundException, SQLException {
        String type = "";
        StringBuilder sqlQuery = new StringBuilder();
        try {

            PreparedStatement pst = null;
            for (int j = 0; j < fmodel.getPubliclst().size(); j++) {
                type = fmodel.publiclst.get(j).tabtype;
                sqlQuery = new StringBuilder();
                sqlQuery.append("UPDATE reports set ");
                sqlQuery.append("\"Year\"=" + fmodel.publiclst.get(j).puyear);
                sqlQuery.append(",\"Quarter\"='" + fmodel.publiclst.get(j).puqtr + "'");
                sqlQuery.append(",\"Total Revenue Value\"=" + fmodel.publiclst.get(j).purev);
                sqlQuery.append(",\"Cost of Revenue Value\"=" + fmodel.publiclst.get(j).pucor);
                sqlQuery.append(",\"Gross Profit Value\"=" + fmodel.publiclst.get(j).pugp);
                sqlQuery.append(",\"Gross Margin Value\"=" + fmodel.publiclst.get(j).pugm);
                sqlQuery.append(",\"R&D Value\"=" + fmodel.publiclst.get(j).purd);
                sqlQuery.append(",\"SG&A Value\"=" + fmodel.publiclst.get(j).pusga);
                sqlQuery.append(",\"Non Recurring Value\"=" + fmodel.publiclst.get(j).punr);
                sqlQuery.append(",\"Others Value\"=" + fmodel.publiclst.get(j).puoe);
                sqlQuery.append(",\"Total Operating Expenses Value\"=" + fmodel.publiclst.get(j).putoe);
                sqlQuery.append(",\"EBITDA\"=" + fmodel.publiclst.get(j).puebitba);
                sqlQuery.append(",\"Total Other Income Expenses Net Value\"=" + fmodel.publiclst.get(j).putoien);
                sqlQuery.append(",\"EBIT Value\"=" + fmodel.publiclst.get(j).puebit);
                sqlQuery.append(",\"Interest Expense Value\"=" + fmodel.publiclst.get(j).puit);
                sqlQuery.append(",\"Income Before Tax Value\"=" + fmodel.publiclst.get(j).puibt);
                sqlQuery.append(",\"Income Tax Expense Value\"=" + fmodel.publiclst.get(j).puite);
                sqlQuery.append(",\"Minority Interest Value\"=" + fmodel.publiclst.get(j).pumino);
                sqlQuery.append(",\"Discontinued Ops Value\"=" + fmodel.publiclst.get(j).pudo);
                sqlQuery.append(",\"Extraordinary Items Value\"=" + fmodel.publiclst.get(j).puoi);
                sqlQuery.append(",\"Effect of Accounting Changes Value\"=" + fmodel.publiclst.get(j).pueoac);
                sqlQuery.append(",\"Other Items Value\"=" + fmodel.publiclst.get(j).puoi);
                sqlQuery.append(",\"Net Income Value\"=" + fmodel.publiclst.get(j).punil);
                sqlQuery.append(",\"Cash & Equivalents Value\"=" + fmodel.publiclst.get(j).pucae);
                sqlQuery.append(",\"Short Term Investments Value\"=" + fmodel.publiclst.get(j).pusti);
                sqlQuery.append(",\"Net Receivables Value\"=" + fmodel.publiclst.get(j).punre);
                sqlQuery.append(",\"Inventory Value\"=" + fmodel.publiclst.get(j).puinvtry);
                sqlQuery.append(",\"Other Current Assets Value\"=" + fmodel.publiclst.get(j).puoca);
                sqlQuery.append(",\"Total Current Assets Value\"=" + fmodel.publiclst.get(j).putcass);
                sqlQuery.append(",\"Long Term Investments Value\"=" + fmodel.publiclst.get(j).pulti);
                sqlQuery.append(",\"PP&E Value\"=" + fmodel.publiclst.get(j).puppe);
                sqlQuery.append(",\"Goodwill Value\"=" + fmodel.publiclst.get(j).pugw);
                sqlQuery.append(",\"Intangible Assets Value\"=" + fmodel.publiclst.get(j).puia);
                sqlQuery.append(",\"Accumulated Amortization Value\"=" + fmodel.publiclst.get(j).puaa);
                sqlQuery.append(",\"Other Assets Value\"=" + fmodel.publiclst.get(j).puoa);
                sqlQuery.append(",\"Deferred Long Term Asset Charges Value\"=" + fmodel.publiclst.get(j).pudltac);
                sqlQuery.append(",\"Total Assets Value\"=" + fmodel.publiclst.get(j).puta);
                sqlQuery.append(",\"Short/Current Long Term Debt Value\"=" + fmodel.publiclst.get(j).puscltd);
                sqlQuery.append(",\"Accounts Payable Value\"=" + fmodel.publiclst.get(j).puap);
                sqlQuery.append(",\"Other Current Liabilities Value\"=" + fmodel.publiclst.get(j).puocl);
                sqlQuery.append(",\"Total Current Liabilities Value\"=" + fmodel.publiclst.get(j).putcl);
                sqlQuery.append(",\"Long Term Debt Value\"=" + fmodel.publiclst.get(j).pultd);
                sqlQuery.append(",\"Other Liabilities Value\"=" + fmodel.publiclst.get(j).puolia);
                sqlQuery.append(",\"Deferred Long Term Liability Charges Value\"=" + fmodel.publiclst.get(j).pudltlc);
                sqlQuery.append(",\"Minority Interest (BS)\"=" + fmodel.publiclst.get(j).pumi);
                sqlQuery.append(",\"Negative Goodwill Value\"=" + fmodel.publiclst.get(j).pungw);
                sqlQuery.append(",\"Total Liabilities Value\"=" + fmodel.publiclst.get(j).putotlia);
                sqlQuery.append(",\"Misc Stocks Options Warrants Value\"=" + fmodel.publiclst.get(j).pumsow);
                sqlQuery.append(",\"Redeemable Preferred Stock Value\"=" + fmodel.publiclst.get(j).purps);
                sqlQuery.append(",\"Preferred Stock Value\"=" + fmodel.publiclst.get(j).pups);
                sqlQuery.append(",\"Common Stock Value\"=" + fmodel.publiclst.get(j).pucs);
                sqlQuery.append(",\"Retained Earnings Value\"=" + fmodel.publiclst.get(j).pure);
                sqlQuery.append(",\"Treasury Stock Value\"=" + fmodel.publiclst.get(j).puts);
                sqlQuery.append(",\"Capital Surplus Value\"=" + fmodel.publiclst.get(j).pucas);
                sqlQuery.append(",\"Other Stockholder Equity Value\"=" + fmodel.publiclst.get(j).puose);
                sqlQuery.append(",\"Total Equity Value\"=" + fmodel.publiclst.get(j).putote);
                sqlQuery.append(",\"Total Liabilites & Equity\"=" + fmodel.publiclst.get(j).putle);
                sqlQuery.append(",\"LTV/CAC Value\"=" + fmodel.publiclst.get(j).pultvac);
                sqlQuery.append(",\"currencytype\"='" + fmodel.publiclst.get(j).currency + "'");
                sqlQuery.append(",\"denomination\"='" + fmodel.publiclst.get(j).denomination + "'");
                sqlQuery.append(" WHERE sfdcunique ='" + fmodel.publiclst.get(j).sfdcunique + "'");

                System.out.println("update---sqlQuery---" + sqlQuery);
                pst = conn.prepareStatement(sqlQuery.toString());
                pst.executeUpdate();

            }

        } catch (SQLException sqlex) {
            System.out.println("---sqlex----" + sqlex);
            Logger.getLogger(CompanyDataManager.class.getName()).log(Level.SEVERE, null, sqlex);
            return sqlex.toString();
        }
        return "Public " + type + " Financial Data updated successfully sid";

    }

    public static boolean checkFinancialRecord(Connection conn, String sfdcId) throws SQLException {
        PreparedStatement pst = null;
        ResultSet rs = null;
        boolean flag = false;
        pst = conn.prepareStatement("SELECT * FROM reports WHERE sfid='" + sfdcId + "' AND \"type\" ='Actuals'");
        rs = pst.executeQuery();
        if (rs.next()) {
            flag = true;
        }
        return flag;
    }

    public static String bypassFinancialRecord(Connection conn, FinancialModel finObj, String cmpType, String tabtype) throws SQLException, ClassNotFoundException {
        String result = "";
        if (cmpType.equalsIgnoreCase("private")) {
            if (tabtype.equalsIgnoreCase("Projection")) {
                if (finObj.getPrivatelst().get(0).operation.equalsIgnoreCase("save")) {
                    result = insertPrivateProjectionFinancialDataManager(conn, finObj);
                } else {
                    result = updatePrivateFinancialDataManager(conn, finObj);
                }

            } else {
                if (checkFinancialRecord(conn, finObj.getPrivatelst().get(0).sfid)) {
                    result = updatePrivateFinancialDataManager(conn, finObj);
                } else {
                    result = insertPrivateFinancialDataManager(conn, finObj);
                }
            }

        } else {
            System.out.println("----else---");
            if (tabtype.equalsIgnoreCase("Projection")) {
                if (finObj.getPubliclst().get(0).operation.equalsIgnoreCase("save")) {
                   result = insertPublicProjectionFinancialDataManager(conn, finObj);
                } else {
                    result = updatePublicFinancialFinancialDataManager(conn, finObj);
                }
                   
            } else {

                if (checkFinancialRecord(conn, finObj.getPubliclst().get(0).sfid)) {
                    System.out.println("----update---");
                    result = updatePublicFinancialDataManager(conn, finObj);
                    //result = update(conn, finObj);
                } else {
                    System.out.println("----insert---");
                    result = insertPublicFinancialDataManager(conn, finObj);
                }
            }

        }

        return result;
    }

    public static boolean getDelete(Connection conn, String sfdcId) throws SQLException {
        PreparedStatement pst = null;
        ResultSet rs = null;
        boolean flag = false;
        StringBuilder sqlQuery = new StringBuilder();
        sqlQuery.append("DELETE ");
        sqlQuery.append(" From reports ");
        sqlQuery.append(" WHERE sfid ='" + sfdcId + "'");

        System.out.println("---sqlQuery---" + sqlQuery);
        pst = conn.prepareStatement(sqlQuery.toString());
        pst.executeUpdate();

        return flag;
    }

    public static boolean getDeletePrivateProjectionRecord(Connection conn, String sfdcId, String datestr) throws SQLException {
        PreparedStatement pst = null;
        ResultSet rs = null;
        boolean flag = false;
        StringBuilder sqlQuery = new StringBuilder();
        sqlQuery.append("DELETE ");
        sqlQuery.append(" From reports ");
        sqlQuery.append(" WHERE sfid ='" + sfdcId + "'");
        sqlQuery.append(" AND projectiondate ='" + datestr + "'");
        System.out.println("---sqlQuery---" + sqlQuery);
        pst = conn.prepareStatement(sqlQuery.toString());
        pst.executeUpdate();

        return flag;
    }

    public static String update(Connection conn, FinancialModel fmodel) throws SQLException {
        PreparedStatement pst = null;
        StringBuilder sqlQuery = new StringBuilder();
        for (int j = 0; j < fmodel.getPrivatelst().size(); j++) {
            sqlQuery = new StringBuilder();
            sqlQuery.append("UPDATE reports set ");
            sqlQuery.append("\"Year\"=" + fmodel.privatelst.get(j).year);
            sqlQuery.append(",\"Quarter\"='" + fmodel.privatelst.get(j).qtr + "'");
            sqlQuery.append(",\"Total Revenue Value\"=" + fmodel.privatelst.get(j).rev);
            sqlQuery.append(",\"Cost of Revenue Value\"=" + fmodel.privatelst.get(j).cor);
            sqlQuery.append(",\"Gross Profit Value\"=" + fmodel.privatelst.get(j).gp);
            sqlQuery.append(",\"Gross Margin Value\"=" + fmodel.privatelst.get(j).gm);
            sqlQuery.append(",\"R&D Value\"=" + fmodel.privatelst.get(j).rd);
            sqlQuery.append(",\"S&M Value\"=" + fmodel.privatelst.get(j).sm);
            sqlQuery.append(",\"G&A Value\"=" + fmodel.privatelst.get(j).ga);
            sqlQuery.append(",\"Others Value\"=" + fmodel.privatelst.get(j).oe);
            sqlQuery.append(",\"Total Operating Expenses Value\"=" + fmodel.privatelst.get(j).toe);
            sqlQuery.append(",\"EBITDA\"=" + fmodel.privatelst.get(j).ebitba);
            sqlQuery.append(",\"EBITDA Margin Value\"=" + fmodel.privatelst.get(j).ebitbam);
            sqlQuery.append(",\"Other Income Expenses Net Value\"=" + fmodel.privatelst.get(j).oien);
            sqlQuery.append(",\"Income Tax Expense Value\"=" + fmodel.privatelst.get(j).it);
            sqlQuery.append(",\"Net Income Value\"=" + fmodel.privatelst.get(j).nl);
            sqlQuery.append(",\"Cash & Equivalents Value\"=" + fmodel.privatelst.get(j).cae);
            sqlQuery.append(",\"Restricted Cash\"=" + fmodel.privatelst.get(j).rc);
            sqlQuery.append(",\"Short Term Investments Value\"=" + fmodel.privatelst.get(j).sti);
            sqlQuery.append(",\"Inventory Value\"=" + fmodel.privatelst.get(j).invtry);
            sqlQuery.append(",\"Net Receivables Value\"=" + fmodel.privatelst.get(j).ar);
            sqlQuery.append(",\"Prepaid Expenses\"=" + fmodel.privatelst.get(j).pe);
            sqlQuery.append(",\"Other Current Assets Value\"=" + fmodel.privatelst.get(j).oca);
            sqlQuery.append(",\"Total Current Assets Value\"=" + fmodel.privatelst.get(j).tca);
            sqlQuery.append(",\"PP&E Value\"=" + fmodel.privatelst.get(j).ppe);
            sqlQuery.append(",\"Accumulated Amortization Value\"=" + fmodel.privatelst.get(j).ada);
            sqlQuery.append(",\"Intangible Assets Value\"=" + fmodel.privatelst.get(j).intg);
            sqlQuery.append(",\"Other Assets Value\"=" + fmodel.privatelst.get(j).onca);
            sqlQuery.append(",\"Total Assets Value\"=" + fmodel.privatelst.get(j).totass);
            sqlQuery.append(",\"Short/Current Long Term Debt Value\"=" + fmodel.privatelst.get(j).std);
            sqlQuery.append(",\"Accounts Payable Value\"=" + fmodel.privatelst.get(j).ap);
            sqlQuery.append(",\"Deferred Revenue\"=" + fmodel.privatelst.get(j).dr);
            sqlQuery.append(",\"Accrued Liabilities\"=" + fmodel.privatelst.get(j).al);
            sqlQuery.append(",\"Other Current Liabilities Value\"=" + fmodel.privatelst.get(j).ocl);
            sqlQuery.append(",\"Total Current Liabilities Value\"=" + fmodel.privatelst.get(j).tcl);
            sqlQuery.append(",\"Long Term Debt Value\"=" + fmodel.privatelst.get(j).ltd);
            sqlQuery.append(",\"Other Liabilities Value\"=" + fmodel.privatelst.get(j).oncl);
            sqlQuery.append(",\"Total Liabilities Value\"=" + fmodel.privatelst.get(j).totlia);
            sqlQuery.append(",\"Capital Stock\"=" + fmodel.privatelst.get(j).cs);
            sqlQuery.append(",\"Retained Earnings Value\"=" + fmodel.privatelst.get(j).re);
            sqlQuery.append(",\"Total Equity Value\"=" + fmodel.privatelst.get(j).toteq);
            sqlQuery.append(",\"Total Liabilities & Equity\"=" + fmodel.privatelst.get(j).tle);
            sqlQuery.append(",\"LTV/CAC Value\"=" + fmodel.privatelst.get(j).ltvac);
            sqlQuery.append(",\"currencytype\"='" + fmodel.privatelst.get(j).currency + "'");
            sqlQuery.append(",\"denomination\"='" + fmodel.privatelst.get(j).denomination + "'");
            sqlQuery.append(" WHERE sfdcunique ='" + fmodel.privatelst.get(j).sfdcunique + "'");

            System.out.println("update---sqlQuery---" + sqlQuery);
            pst = conn.prepareStatement(sqlQuery.toString());
            pst.executeUpdate();

        }
        return "updated successfully";

    }

}
