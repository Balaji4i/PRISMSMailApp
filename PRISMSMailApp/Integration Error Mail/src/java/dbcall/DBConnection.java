/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbcall;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.naming.Context;
import javax.naming.InitialContext;

/**
 *
 * @author Ibrahim
 */
public class DBConnection {

    public static Connection getConnectionDS(String datasource) throws SQLException,
            NamingException {
        Connection con = null;
        DataSource data = null;
        Context initialContext = new InitialContext();
        data = (DataSource) initialContext.lookup(datasource);
        if (data != null) {
            con = data.getConnection();
        } else {
            System.out.println("Failed to Find JDBC DataSource.");
        }
        return con;
    }

    public static Connection getDBConnection() throws SQLException, ClassNotFoundException {
        Connection con = null;
        try { 
            Class.forName("oracle.jdbc.driver.OracleDriver"); 
              con = DriverManager.getConnection("jdbc:oracle:thin:@144.21.67.79:1533/omnipdb1.606532292.oraclecloud.internal", "XXREF_WK4", "Re_Fr5h_t5t4");
//            con = DriverManager.getConnection("jdbc:oracle:thin:@144.21.67.79:1533/omnipdb1.606532292.oraclecloud.internal", "XXPM_TEST", "omniyat123");
//            con = DriverManager.getConnection("jdbc:oracle:thin:@//130.61.109.253:1521/omnipdb1.sub08081309100.omnivcn1.oraclevcn.com", "XXPRISM", "Xx_pR1sm_05");
         } catch (SQLException ex) {
            ex.printStackTrace();
        } 
        return con;
    }
}
