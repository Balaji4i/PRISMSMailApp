/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbcall;

//import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type;
import dbcall.DBConnection;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;

/**
 *
 * @author Ibrahim
 */
public class CallDBQuery { 
    
    /**
     * Method to initialize DB connection
     * @throws SQLException
     * @throws NamingException
     * @throws ClassNotFoundException 
     */
    public static Connection dbInitialization(Connection connection) throws SQLException, NamingException, ClassNotFoundException {
        connection = DBConnection.getConnectionDS("jdbc/prism");    //CLOUD
//        connection = DBConnection.getDBConnection();                //LOCAL

        return connection;
    }
    
    /**
     * Method to get Unit Price List XML data
     * @return XML data as String
     */
    public static String getUnitPriceListReport(String P_PROJ_ID,String P_PROP_ID,String P_UNIT_STATUS) {
        String xmlString = null;
        Connection connection = null; 
        Statement statement = null;
        ResultSet resultSet = null;
        PreparedStatement ps =null;
        try {
            connection = dbInitialization(connection); 
            String sql = "select XXPRISM_report_pkg.XXPRISM_PRICELIST_REPORT("+ P_PROJ_ID +","+ P_PROP_ID +",'"+ P_UNIT_STATUS +"') xml from dual";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                xmlString = resultSet.getString("xml");
            } 
             
        } catch (SQLException ex) {
            Logger.getLogger(CallDBQuery.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                dbDestroy(connection,statement,resultSet,ps);
            } catch (SQLException ex) {
                Logger.getLogger(CallDBQuery.class.getName()).log(Level.SEVERE, null, ex);
            }
             if(xmlString==null){
                return  "NO_DATA";
            }else{
                return xmlString;
            }
        }
    }


    /**
     * Method to get Error status XML data
     * @return XML data as String
     */
    public static String getErrorStatus() {
        String xmlString = null;
        Connection connection = null; 
        Statement statement = null;
        ResultSet resultSet = null;
        PreparedStatement ps =null;
        try {
            connection = dbInitialization(connection); 
            String sql = "select XXPRISM_REPORT_PKG.XXPRISM_ERROR_STATUS() xml from dual";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                xmlString = resultSet.getString("xml");
            } 
             
        } catch (SQLException ex) {
            Logger.getLogger(CallDBQuery.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                dbDestroy(connection,statement,resultSet,ps);
            } catch (SQLException ex) {
                Logger.getLogger(CallDBQuery.class.getName()).log(Level.SEVERE, null, ex);
            }
             if(xmlString==null){
                return  "NO_DATA";
            }else{
                return xmlString;
            }
        }
    }
    
    /**
     * Method to get PDC due XML data
     * @return XML data as String
     */
    public static String getDueDate(String allDue) {
        String xmlString = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        PreparedStatement ps =null;
//        allDue="31-JAN-2020";
        
        
        try {
            connection = dbInitialization(connection); 
            String sql = "SELECT XXPRISM_REPORT_PKG.XXPRISM_DAILY_DUE_REPORT('"+allDue+"') XML FROM DUAL";
            System.out.println("sql--"+sql);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                xmlString = resultSet.getString("xml");
            } 

        } catch (SQLException ex) {
            Logger.getLogger(CallDBQuery.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                dbDestroy(connection,statement,resultSet,ps);
            } catch (SQLException ex) {
                Logger.getLogger(CallDBQuery.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(xmlString==null){
                return  "NO_DATA";
            }else{
                return xmlString;
            }
        }
    } 
    
    
             /**
     * Method to get PDC due XML data
     * @return XML data as String
     */
    public static String getWeeklyDueDate(String allDue) {
        String xmlString = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        PreparedStatement ps =null;
        try {
            connection = dbInitialization(connection); 
            String sql = "SELECT XXPRISM_REPORT_PKG.XXPRISM_AR_WEEKLY_SCHEDULE('"+allDue+"') XML FROM DUAL";
            System.out.println("sql--"+sql);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                xmlString = resultSet.getString("XML");
            } 

        } catch (SQLException ex) {
            Logger.getLogger(CallDBQuery.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                dbDestroy(connection,statement,resultSet,ps);
            } catch (SQLException ex) {
                Logger.getLogger(CallDBQuery.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(xmlString==null){
                return  "NO_DATA";
            }else{
                return xmlString;
            }
        }
    } 
    
     /**
     * Method to get PDC due XML data
     * @return XML data as String
     */
    public static String getPdcDueXml(String allDue) {
        String xmlString = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        PreparedStatement ps =null;
        try {
            connection = dbInitialization(connection); 
            String sql = "SELECT XXPRISM_REPORT_PKG.XXPRISM_PDC_DUE_REPORT('"+allDue+"') XML FROM DUAL";
            System.out.println("sql--"+sql);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                xmlString = resultSet.getString("xml");
            } 

        } catch (SQLException ex) {
            Logger.getLogger(CallDBQuery.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                dbDestroy(connection,statement,resultSet,ps);
            } catch (SQLException ex) {
                Logger.getLogger(CallDBQuery.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(xmlString==null){
                return  "NO_DATA";
            }else{
                return xmlString;
            }
        }
    } 
    
    /**
     * Method to get PDC due XML data
     * @return XML data as String
     */
    public static String getEmptyPdcXml() {
        String xmlString = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        PreparedStatement ps =null;
        try {
            connection = dbInitialization(connection); 
            String sql = "SELECT GET_EMPTY_PDC_DUE() XML FROM DUAL"; 
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                xmlString = resultSet.getString("xml");
            }
            if(xmlString==null){
                xmlString= "NO_DATA";
            }

        } catch (SQLException ex) {
            Logger.getLogger(CallDBQuery.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                dbDestroy(connection,statement,resultSet,ps);
            } catch (SQLException ex) {
                Logger.getLogger(CallDBQuery.class.getName()).log(Level.SEVERE, null, ex);
            }
            return xmlString;
        }
    } 
    
     public static String getEmptyPriceListXml() {
        String xmlString = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        PreparedStatement ps =null;
        try {
            connection = dbInitialization(connection); 
            String sql = "SELECT GET_EMPTY_PRICE_LIST() XML FROM DUAL"; 
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                xmlString = resultSet.getString("xml");
            }
            if(xmlString==null){
                xmlString= "NO_DATA";
            }

        } catch (SQLException ex) {
            Logger.getLogger(CallDBQuery.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                dbDestroy(connection,statement,resultSet,ps);
            } catch (SQLException ex) {
                Logger.getLogger(CallDBQuery.class.getName()).log(Level.SEVERE, null, ex);
            }
            return xmlString;
        }
    } 
    
       public static String getEmptyDialyDueDateXml() {
        String xmlString = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        PreparedStatement ps =null;
        try {
            connection = dbInitialization(connection); 
            String sql = "SELECT XXPRISM_REPORT_PKG.GET_EMPTY_DUE XML FROM DUAL"; 
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                xmlString = resultSet.getString("xml");
            }
            if(xmlString==null){
                xmlString= "NO_DATA";
            }

        } catch (SQLException ex) {
            Logger.getLogger(CallDBQuery.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                dbDestroy(connection,statement,resultSet,ps);
            } catch (SQLException ex) {
                Logger.getLogger(CallDBQuery.class.getName()).log(Level.SEVERE, null, ex);
            }
            return xmlString;
        }
    } 
    
    
    
    
    
    /**
     * Method to get PDC due XML data
     * @return XML data as String
     */
    public static String getEmptyIntErrorXml() {
        String xmlString = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        PreparedStatement ps =null;
        try {
            connection = dbInitialization(connection); 
            String sql = "SELECT GET_EMPTY_INTERFACE_ERROR() XML FROM DUAL";   
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                xmlString = resultSet.getString("xml");
            }
            if(xmlString==null){
                xmlString= "NO_DATA";
            }

        } catch (SQLException ex) {
            Logger.getLogger(CallDBQuery.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                dbDestroy(connection,statement,resultSet,ps);
            } catch (SQLException ex) {
                Logger.getLogger(CallDBQuery.class.getName()).log(Level.SEVERE, null, ex);
            }
            return xmlString;
        }
    } 
        /**
     * Method to get mail address TO,CC,BCC from lookup
     * @param addressType 
     * @return mail address
     */
    public static String getAddressForInterfaceError(String addressType) {
        String toAddress = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        PreparedStatement ps =null;
        try {
            connection = dbInitialization(connection); 
            String sql = null;
            if ("TO".equals(addressType)) {
                sql = "SELECT LOOKUP_VALUE_NAME_DISP AS TO_ADDRESS FROM XXFND_LOOKUP_V WHERE LOOKUP_TYPE_NAME = 'AUTO_MAIL_ADDRESS' and LOOKUP_VALUE_NAME = 'ERROR_STATUS_MAIL_TO'";
            } else if ("CC".equals(addressType)) {
                sql = "SELECT LOOKUP_VALUE_NAME_DISP AS TO_ADDRESS FROM XXFND_LOOKUP_V WHERE LOOKUP_TYPE_NAME = 'AUTO_MAIL_ADDRESS' and LOOKUP_VALUE_NAME = 'ERROR_STATUS_MAIL_CC'";
            } else {
                sql = "SELECT LOOKUP_VALUE_NAME_DISP AS TO_ADDRESS FROM XXFND_LOOKUP_V WHERE LOOKUP_TYPE_NAME = 'AUTO_MAIL_ADDRESS' and LOOKUP_VALUE_NAME = 'ERROR_STATUS_MAIL_BCC'";
            }
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            if (resultSet != null) {
                while (resultSet.next()) {
                    toAddress = resultSet.getString("TO_ADDRESS") == null ? "" : resultSet.getString("TO_ADDRESS");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CallDBQuery.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                dbDestroy(connection,statement,resultSet,ps);
            } catch (SQLException ex) {
                Logger.getLogger(CallDBQuery.class.getName()).log(Level.SEVERE, null, ex);
            }
            return toAddress;
        }
    }

        public static String getAddressForUnitPriceListAll(String addressType) {
        String toAddress = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        PreparedStatement ps =null;
        try {
            connection = dbInitialization(connection); 
            String sql = null;
            if ("TO".equals(addressType)) {
                sql = "SELECT LOOKUP_VALUE_NAME_DISP AS TO_ADDRESS FROM XXFND_LOOKUP_V WHERE LOOKUP_TYPE_NAME = 'AUTO_MAIL_ADDRESS' and LOOKUP_VALUE_NAME = 'UNIT_PRICE_LIST_ALL_TO'";
            } else if ("CC".equals(addressType)) {
                sql = "SELECT LOOKUP_VALUE_NAME_DISP AS TO_ADDRESS FROM XXFND_LOOKUP_V WHERE LOOKUP_TYPE_NAME = 'AUTO_MAIL_ADDRESS' and LOOKUP_VALUE_NAME = 'UNIT_PRICE_LIST_ALL_CC'";
            } else {
                sql = "SELECT LOOKUP_VALUE_NAME_DISP AS TO_ADDRESS FROM XXFND_LOOKUP_V WHERE LOOKUP_TYPE_NAME = 'AUTO_MAIL_ADDRESS' and LOOKUP_VALUE_NAME = 'UNIT_PRICE_LIST_ALL_BCC'";
            }
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            if (resultSet != null) {
                while (resultSet.next()) {
                    toAddress = resultSet.getString("TO_ADDRESS") == null ? "" : resultSet.getString("TO_ADDRESS");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CallDBQuery.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                dbDestroy(connection,statement,resultSet,ps);
            } catch (SQLException ex) {
                Logger.getLogger(CallDBQuery.class.getName()).log(Level.SEVERE, null, ex);
            }
            return toAddress;
        }
    }
   
        public static String getAddressForUnitPriceListAvailable(String addressType) {
        String toAddress = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        PreparedStatement ps =null;
        try {
            connection = dbInitialization(connection); 
            String sql = null;
            if ("TO".equals(addressType)) {
                sql = "SELECT LOOKUP_VALUE_NAME_DISP AS TO_ADDRESS FROM XXFND_LOOKUP_V WHERE LOOKUP_TYPE_NAME = 'AUTO_MAIL_ADDRESS' and LOOKUP_VALUE_NAME = 'UNIT_PRICE_LIST_AVAL_TO'";
            } else if ("CC".equals(addressType)) {
                sql = "SELECT LOOKUP_VALUE_NAME_DISP AS TO_ADDRESS FROM XXFND_LOOKUP_V WHERE LOOKUP_TYPE_NAME = 'AUTO_MAIL_ADDRESS' and LOOKUP_VALUE_NAME = 'UNIT_PRICE_LIST_AVAL_CC'";
            } else {
                sql = "SELECT LOOKUP_VALUE_NAME_DISP AS TO_ADDRESS FROM XXFND_LOOKUP_V WHERE LOOKUP_TYPE_NAME = 'AUTO_MAIL_ADDRESS' and LOOKUP_VALUE_NAME = 'UNIT_PRICE_LIST_AVAL_BCC'";
            }
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            if (resultSet != null) {
                while (resultSet.next()) {
                    toAddress = resultSet.getString("TO_ADDRESS") == null ? "" : resultSet.getString("TO_ADDRESS");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CallDBQuery.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                dbDestroy(connection,statement,resultSet,ps);
            } catch (SQLException ex) {
                Logger.getLogger(CallDBQuery.class.getName()).log(Level.SEVERE, null, ex);
            }
            return toAddress;
        }
    }

    /**
     * Method to get mail address TO,CC,BCC from lookup
     * @param addressType 
     * @return mail address
     */
    
        public static String getAddressForWeeklyDue(String addressType) {
        String toAddress = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        PreparedStatement ps =null;
        try {
            connection = dbInitialization(connection); 
            String sql = null;
            if ("TO".equals(addressType)) {
                sql = "SELECT LOOKUP_VALUE_NAME_DISP AS TO_ADDRESS FROM XXFND_LOOKUP_V WHERE LOOKUP_TYPE_NAME = 'AUTO_MAIL_ADDRESS' and LOOKUP_VALUE_NAME = 'WEEKLY_AR_MAIL_TO'";
            } else if ("CC".equals(addressType)) {
                sql = "SELECT LOOKUP_VALUE_NAME_DISP AS TO_ADDRESS FROM XXFND_LOOKUP_V WHERE LOOKUP_TYPE_NAME = 'AUTO_MAIL_ADDRESS' and LOOKUP_VALUE_NAME = 'WEEKLY_AR_MAIL_CC'";
            } else {
                sql = "SELECT LOOKUP_VALUE_NAME_DISP AS TO_ADDRESS FROM XXFND_LOOKUP_V WHERE LOOKUP_TYPE_NAME = 'AUTO_MAIL_ADDRESS' and LOOKUP_VALUE_NAME = 'WEEKLY_AR_MAIL_BCC'";
            }
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            if (resultSet != null) {
                while (resultSet.next()) {
                    toAddress = resultSet.getString("TO_ADDRESS") == null ? "" : resultSet.getString("TO_ADDRESS");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CallDBQuery.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                dbDestroy(connection,statement,resultSet,ps);
            } catch (SQLException ex) {
                Logger.getLogger(CallDBQuery.class.getName()).log(Level.SEVERE, null, ex);
            }
            return toAddress;
        }
    }

    
    
    
    /**
     * Method to get mail address TO,CC,BCC from lookup
     * @param addressType 
     * @return mail address
     */
    public static String getAddressForPdcDue(String addressType) {
        String toAddress = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        PreparedStatement ps =null;
        try {
            connection = dbInitialization(connection); 
            String sql = null;
            if ("TO".equals(addressType)) {
                sql = "SELECT LOOKUP_VALUE_NAME_DISP AS TO_ADDRESS FROM XXFND_LOOKUP_V WHERE LOOKUP_TYPE_NAME = 'AUTO_MAIL_ADDRESS' and LOOKUP_VALUE_NAME = 'PDC_DUE_MAIL_TO'";
            } else if ("CC".equals(addressType)) {
                sql = "SELECT LOOKUP_VALUE_NAME_DISP AS TO_ADDRESS FROM XXFND_LOOKUP_V WHERE LOOKUP_TYPE_NAME = 'AUTO_MAIL_ADDRESS' and LOOKUP_VALUE_NAME = 'PDC_DUE_MAIL_CC'";
            } else {
                sql = "SELECT LOOKUP_VALUE_NAME_DISP AS TO_ADDRESS FROM XXFND_LOOKUP_V WHERE LOOKUP_TYPE_NAME = 'AUTO_MAIL_ADDRESS' and LOOKUP_VALUE_NAME = 'PDC_DUE_MAIL_BCC'";
            }
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            if (resultSet != null) {
                while (resultSet.next()) {
                    toAddress = resultSet.getString("TO_ADDRESS") == null ? "" : resultSet.getString("TO_ADDRESS");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CallDBQuery.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                dbDestroy(connection,statement,resultSet,ps);
            } catch (SQLException ex) {
                Logger.getLogger(CallDBQuery.class.getName()).log(Level.SEVERE, null, ex);
            }
            return toAddress;
        }
    }
    

    /**
     * Method to destroy DB connection
     * @throws SQLException 
     */
    public static void dbDestroy(Connection connection ,Statement statement, ResultSet resultSet,PreparedStatement ps) throws SQLException { 
        if (resultSet != null) {
            resultSet.close();
        }
        if (statement != null) {
            statement.close();
        }
        if (ps != null) {
            ps.close();
        }
        if (connection != null) {
            connection.close();
        }
    }

    public static String receiptSyncData(String packageName, String xmlData) throws SQLException, NamingException, ClassNotFoundException {
        Connection connection = null; 
        connection = dbInitialization(connection); 
        CallableStatement  statement;
        statement = connection.prepareCall("CALL XXPM_RECEIPT_ACCOUNT_SYNC."+ packageName+"(?,?)");
        statement.setString(1, xmlData);
        statement.registerOutParameter(2, Types.VARCHAR);
        statement.execute();
        String output =statement.getString(2);
        System.out.print("output==>"+output);
        dbDestroy(connection,null,null,null);
        return output;
    }
 public static ArrayList getLoginInfo() {
        ArrayList<String> credentials = new ArrayList<String>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        PreparedStatement ps =null;
        try {
            connection = dbInitialization(connection);
            String sql = null;
            
            sql = "SELECT FUSION_DOMAIN, FUSION_USERNAME, FUSION_PASSWORD FROM XXPM_SETUP_DETAIL";
            
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            if (resultSet != null) {
                while (resultSet.next()) {
                    credentials.add(resultSet.getString("FUSION_DOMAIN") == null ? "" : resultSet.getString("FUSION_DOMAIN"));
                    credentials.add(resultSet.getString("FUSION_USERNAME") == null ? "" : resultSet.getString("FUSION_USERNAME"));
                    credentials.add(resultSet.getString("FUSION_PASSWORD") == null ? "" : resultSet.getString("FUSION_PASSWORD"));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CallDBQuery.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                dbDestroy(connection,statement,resultSet,ps);
            } catch (SQLException ex) {
                Logger.getLogger(CallDBQuery.class.getName()).log(Level.SEVERE, null, ex);
            }
            return credentials;
        }

    }
 
 public static String getDetailsForUnitPriceListJob(String requestType) {
        String resultOut = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        PreparedStatement ps =null;
        try {
            connection = dbInitialization(connection); 
            String sql = null;
            if ("TIME".equalsIgnoreCase(requestType)) {
                sql = "SELECT LOOKUP_VALUE_NAME_DISP AS RESULT_DATA FROM XXPM_PL_SCHD_JOB_V WHERE LOOKUP_TYPE_NAME = 'PRICELIST_SCHD_JOB' and LOOKUP_VALUE_NAME = 'TIME'";
            } 
            else if ("TemplateCode".equalsIgnoreCase(requestType)) {
                sql = "SELECT TEMPLATE_CODE AS RESULT_DATA FROM XXPM_PL_SCHD_JOB_V WHERE LOOKUP_TYPE_NAME = 'PRICELIST_SCHD_JOB' and LOOKUP_VALUE_NAME_DISP_TL = 'Project Attachment' and LOOKUP_ADDL_VALUE='1'";
            } 
            //attachment name
            else if ("PROJECTS-1".equalsIgnoreCase(requestType)) {
                sql = "SELECT LOOKUP_VALUE_NAME_DISP AS RESULT_DATA FROM XXPM_PL_SCHD_JOB_V WHERE LOOKUP_TYPE_NAME = 'PRICELIST_SCHD_JOB' and LOOKUP_VALUE_NAME_DISP_TL = 'Project Attachment' and LOOKUP_ADDL_VALUE='1'";
            }
            else if ("PROJECTS-2".equalsIgnoreCase(requestType)) {
                sql = "SELECT LOOKUP_VALUE_NAME_DISP AS RESULT_DATA FROM XXPM_PL_SCHD_JOB_V WHERE LOOKUP_TYPE_NAME = 'PRICELIST_SCHD_JOB' and LOOKUP_VALUE_NAME_DISP_TL = 'Project Attachment' and LOOKUP_ADDL_VALUE='2'";
            }
            else if ("PROJECTS-3".equalsIgnoreCase(requestType)) {
                sql = "SELECT LOOKUP_VALUE_NAME_DISP AS RESULT_DATA FROM XXPM_PL_SCHD_JOB_V WHERE LOOKUP_TYPE_NAME = 'PRICELIST_SCHD_JOB' and LOOKUP_VALUE_NAME_DISP_TL = 'Project Attachment' and LOOKUP_ADDL_VALUE='3'";
            }
            else if ("PROJECTS-4".equalsIgnoreCase(requestType)) {
                sql = "SELECT LOOKUP_VALUE_NAME_DISP AS RESULT_DATA FROM XXPM_PL_SCHD_JOB_V WHERE LOOKUP_TYPE_NAME = 'PRICELIST_SCHD_JOB' and LOOKUP_VALUE_NAME_DISP_TL = 'Project Attachment' and LOOKUP_ADDL_VALUE='4'";
            }
            else if ("PROJECTS-5".equalsIgnoreCase(requestType)) {
                sql = "SELECT LOOKUP_VALUE_NAME_DISP AS RESULT_DATA FROM XXPM_PL_SCHD_JOB_V WHERE LOOKUP_TYPE_NAME = 'PRICELIST_SCHD_JOB' and LOOKUP_VALUE_NAME_DISP_TL = 'Project Attachment' and LOOKUP_ADDL_VALUE='5'";
            }
            else if ("PROJECTS-6".equalsIgnoreCase(requestType)) {
                sql = "SELECT LOOKUP_VALUE_NAME_DISP AS RESULT_DATA FROM XXPM_PL_SCHD_JOB_V WHERE LOOKUP_TYPE_NAME = 'PRICELIST_SCHD_JOB' and LOOKUP_VALUE_NAME_DISP_TL = 'Project Attachment' and LOOKUP_ADDL_VALUE='6'";
            }
            else if ("PROJECTS-7".equalsIgnoreCase(requestType)) {
                sql = "SELECT LOOKUP_VALUE_NAME_DISP AS RESULT_DATA FROM XXPM_PL_SCHD_JOB_V WHERE LOOKUP_TYPE_NAME = 'PRICELIST_SCHD_JOB' and LOOKUP_VALUE_NAME_DISP_TL = 'Project Attachment' and LOOKUP_ADDL_VALUE='7'";
            }
            else if ("PROJECTS-8".equalsIgnoreCase(requestType)) {
                sql = "SELECT LOOKUP_VALUE_NAME_DISP AS RESULT_DATA FROM XXPM_PL_SCHD_JOB_V WHERE LOOKUP_TYPE_NAME = 'PRICELIST_SCHD_JOB' and LOOKUP_VALUE_NAME_DISP_TL = 'Project Attachment' and LOOKUP_ADDL_VALUE='8'";
            }
            else if ("PROJECTS-9".equalsIgnoreCase(requestType)) {
                sql = "SELECT LOOKUP_VALUE_NAME_DISP AS RESULT_DATA FROM XXPM_PL_SCHD_JOB_V WHERE LOOKUP_TYPE_NAME = 'PRICELIST_SCHD_JOB' and LOOKUP_VALUE_NAME_DISP_TL = 'Project Attachment' and LOOKUP_ADDL_VALUE='9'";
            }
            else if ("PROJECTS-10".equalsIgnoreCase(requestType)) {
                sql = "SELECT LOOKUP_VALUE_NAME_DISP AS RESULT_DATA FROM XXPM_PL_SCHD_JOB_V WHERE LOOKUP_TYPE_NAME = 'PRICELIST_SCHD_JOB' and LOOKUP_VALUE_NAME_DISP_TL = 'Project Attachment' and LOOKUP_ADDL_VALUE='10'";
            }
            //project id
            else if ("PROJECTS-ID-1".equalsIgnoreCase(requestType)) {
                sql = "SELECT PROJ_ID AS RESULT_DATA FROM XXPM_PL_SCHD_JOB_V WHERE LOOKUP_TYPE_NAME = 'PRICELIST_SCHD_JOB' and LOOKUP_VALUE_NAME_DISP_TL = 'Project Attachment' and LOOKUP_ADDL_VALUE='1'";
            }
            else if ("PROJECTS-ID-2".equalsIgnoreCase(requestType)) {
                sql = "SELECT PROJ_ID AS RESULT_DATA FROM XXPM_PL_SCHD_JOB_V WHERE LOOKUP_TYPE_NAME = 'PRICELIST_SCHD_JOB' and LOOKUP_VALUE_NAME_DISP_TL = 'Project Attachment' and LOOKUP_ADDL_VALUE='2'";
            }
            else if ("PROJECTS-ID-3".equalsIgnoreCase(requestType)) {
                sql = "SELECT PROJ_ID AS RESULT_DATA FROM XXPM_PL_SCHD_JOB_V WHERE LOOKUP_TYPE_NAME = 'PRICELIST_SCHD_JOB' and LOOKUP_VALUE_NAME_DISP_TL = 'Project Attachment' and LOOKUP_ADDL_VALUE='3'";
            }
            else if ("PROJECTS-ID-4".equalsIgnoreCase(requestType)) {
                sql = "SELECT PROJ_ID AS RESULT_DATA FROM XXPM_PL_SCHD_JOB_V WHERE LOOKUP_TYPE_NAME = 'PRICELIST_SCHD_JOB' and LOOKUP_VALUE_NAME_DISP_TL = 'Project Attachment' and LOOKUP_ADDL_VALUE='4'";
            }
            else if ("PROJECTS-ID-5".equalsIgnoreCase(requestType)) {
                sql = "SELECT PROJ_ID AS RESULT_DATA FROM XXPM_PL_SCHD_JOB_V WHERE LOOKUP_TYPE_NAME = 'PRICELIST_SCHD_JOB' and LOOKUP_VALUE_NAME_DISP_TL = 'Project Attachment' and LOOKUP_ADDL_VALUE='5'";
            }
            else if ("PROJECTS-ID-6".equalsIgnoreCase(requestType)) {
                sql = "SELECT PROJ_ID AS RESULT_DATA FROM XXPM_PL_SCHD_JOB_V WHERE LOOKUP_TYPE_NAME = 'PRICELIST_SCHD_JOB' and LOOKUP_VALUE_NAME_DISP_TL = 'Project Attachment' and LOOKUP_ADDL_VALUE='6'";
            }
            else if ("PROJECTS-ID-7".equalsIgnoreCase(requestType)) {
                sql = "SELECT PROJ_ID AS RESULT_DATA FROM XXPM_PL_SCHD_JOB_V WHERE LOOKUP_TYPE_NAME = 'PRICELIST_SCHD_JOB' and LOOKUP_VALUE_NAME_DISP_TL = 'Project Attachment' and LOOKUP_ADDL_VALUE='7'";
            }
            else if ("PROJECTS-ID-8".equalsIgnoreCase(requestType)) {
                sql = "SELECT PROJ_ID AS RESULT_DATA FROM XXPM_PL_SCHD_JOB_V WHERE LOOKUP_TYPE_NAME = 'PRICELIST_SCHD_JOB' and LOOKUP_VALUE_NAME_DISP_TL = 'Project Attachment' and LOOKUP_ADDL_VALUE='8'";
            }
            else if ("PROJECTS-ID-9".equalsIgnoreCase(requestType)) {
                sql = "SELECT PROJ_ID AS RESULT_DATA FROM XXPM_PL_SCHD_JOB_V WHERE LOOKUP_TYPE_NAME = 'PRICELIST_SCHD_JOB' and LOOKUP_VALUE_NAME_DISP_TL = 'Project Attachment' and LOOKUP_ADDL_VALUE='9'";
            }
            else if ("PROJECTS-ID-10".equalsIgnoreCase(requestType)) {
                sql = "SELECT PROJ_ID AS RESULT_DATA FROM XXPM_PL_SCHD_JOB_V WHERE LOOKUP_TYPE_NAME = 'PRICELIST_SCHD_JOB' and LOOKUP_VALUE_NAME_DISP_TL = 'Project Attachment' and LOOKUP_ADDL_VALUE='10'";
            }
            //prop id
            else if ("PROP-ID-1".equalsIgnoreCase(requestType)) {
                sql = "SELECT PROPERTY_ID AS RESULT_DATA FROM XXPM_PL_SCHD_JOB_V WHERE LOOKUP_TYPE_NAME = 'PRICELIST_SCHD_JOB' and LOOKUP_VALUE_NAME_DISP_TL = 'Project Attachment' and LOOKUP_ADDL_VALUE='1'";
            }
            else if ("PROP-ID-2".equalsIgnoreCase(requestType)) {
                sql = "SELECT PROPERTY_ID AS RESULT_DATA FROM XXPM_PL_SCHD_JOB_V WHERE LOOKUP_TYPE_NAME = 'PRICELIST_SCHD_JOB' and LOOKUP_VALUE_NAME_DISP_TL = 'Project Attachment' and LOOKUP_ADDL_VALUE='2'";
            }
            else if ("PROP-ID-3".equalsIgnoreCase(requestType)) {
                sql = "SELECT PROPERTY_ID AS RESULT_DATA FROM XXPM_PL_SCHD_JOB_V WHERE LOOKUP_TYPE_NAME = 'PRICELIST_SCHD_JOB' and LOOKUP_VALUE_NAME_DISP_TL = 'Project Attachment' and LOOKUP_ADDL_VALUE='3'";
            }
            else if ("PROP-ID-4".equalsIgnoreCase(requestType)) {
                sql = "SELECT PROPERTY_ID AS RESULT_DATA FROM XXPM_PL_SCHD_JOB_V WHERE LOOKUP_TYPE_NAME = 'PRICELIST_SCHD_JOB' and LOOKUP_VALUE_NAME_DISP_TL = 'Project Attachment' and LOOKUP_ADDL_VALUE='4'";
            }
            else if ("PROP-ID-5".equalsIgnoreCase(requestType)) {
                sql = "SELECT PROPERTY_ID AS RESULT_DATA FROM XXPM_PL_SCHD_JOB_V WHERE LOOKUP_TYPE_NAME = 'PRICELIST_SCHD_JOB' and LOOKUP_VALUE_NAME_DISP_TL = 'Project Attachment' and LOOKUP_ADDL_VALUE='5'";
            }
            else if ("PROP-ID-6".equalsIgnoreCase(requestType)) {
                sql = "SELECT PROPERTY_ID AS RESULT_DATA FROM XXPM_PL_SCHD_JOB_V WHERE LOOKUP_TYPE_NAME = 'PRICELIST_SCHD_JOB' and LOOKUP_VALUE_NAME_DISP_TL = 'Project Attachment' and LOOKUP_ADDL_VALUE='6'";
            }
            else if ("PROP-ID-7".equalsIgnoreCase(requestType)) {
                sql = "SELECT PROPERTY_ID AS RESULT_DATA FROM XXPM_PL_SCHD_JOB_V WHERE LOOKUP_TYPE_NAME = 'PRICELIST_SCHD_JOB' and LOOKUP_VALUE_NAME_DISP_TL = 'Project Attachment' and LOOKUP_ADDL_VALUE='7'";
            }
            else if ("PROP-ID-8".equalsIgnoreCase(requestType)) {
                sql = "SELECT PROPERTY_ID AS RESULT_DATA FROM XXPM_PL_SCHD_JOB_V WHERE LOOKUP_TYPE_NAME = 'PRICELIST_SCHD_JOB' and LOOKUP_VALUE_NAME_DISP_TL = 'Project Attachment' and LOOKUP_ADDL_VALUE='8'";
            }
            else if ("PROP-ID-9".equalsIgnoreCase(requestType)) {
                sql = "SELECT PROPERTY_ID AS RESULT_DATA FROM XXPM_PL_SCHD_JOB_V WHERE LOOKUP_TYPE_NAME = 'PRICELIST_SCHD_JOB' and LOOKUP_VALUE_NAME_DISP_TL = 'Project Attachment' and LOOKUP_ADDL_VALUE='9'";
            }
            else if ("PROP-ID-10".equalsIgnoreCase(requestType)) {
                sql = "SELECT PROPERTY_ID AS RESULT_DATA FROM XXPM_PL_SCHD_JOB_V WHERE LOOKUP_TYPE_NAME = 'PRICELIST_SCHD_JOB' and LOOKUP_VALUE_NAME_DISP_TL = 'Project Attachment' and LOOKUP_ADDL_VALUE='10'";
            }
            
            else {
                sql = "SELECT LOOKUP_VALUE_NAME_DISP AS RESULT_DATA FROM XXFND_LOOKUP_V WHERE LOOKUP_TYPE_NAME = 'AUTO_MAIL_ADDRESS' and LOOKUP_VALUE_NAME = 'UNIT_PRICE_LIST_AVAL_BCC'";
            }
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            if (resultSet != null) {
                while (resultSet.next()) {
                    resultOut = resultSet.getString("RESULT_DATA") == null ? "" : resultSet.getString("RESULT_DATA").toString();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CallDBQuery.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                dbDestroy(connection,statement,resultSet,ps);
            } catch (SQLException ex) {
                Logger.getLogger(CallDBQuery.class.getName()).log(Level.SEVERE, null, ex);
            }
            return resultOut;
        }
    }
}


