/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbcall;

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

    
    
    public static String getAddressFordueMail(String addressType) {
        String toAddress = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        PreparedStatement ps =null;
        try {
            connection = dbInitialization(connection); 
            String sql = null;
            if ("TO".equals(addressType)) {
                sql = "SELECT LOOKUP_VALUE_NAME_DISP AS TO_ADDRESS FROM XXFND_LOOKUP_V WHERE LOOKUP_TYPE_NAME = 'AUTO_MAIL_ADDRESS' and LOOKUP_VALUE_NAME = 'DUE_MAIL_TO'";
            } else if ("CC".equals(addressType)) {
                sql = "SELECT LOOKUP_VALUE_NAME_DISP AS TO_ADDRESS FROM XXFND_LOOKUP_V WHERE LOOKUP_TYPE_NAME = 'AUTO_MAIL_ADDRESS' and LOOKUP_VALUE_NAME = 'DUE_MAIL_CC'";
            } else {
                sql = "SELECT LOOKUP_VALUE_NAME_DISP AS TO_ADDRESS FROM XXFND_LOOKUP_V WHERE LOOKUP_TYPE_NAME = 'AUTO_MAIL_ADDRESS' and LOOKUP_VALUE_NAME = 'DUE_MAIL_BCC'";
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
}
