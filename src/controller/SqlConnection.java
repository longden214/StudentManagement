/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class SqlConnection {
    public static Connection getConnect(){
        Connection conn= null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Manage_Student;user=sa;password=ahihi214");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SqlConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SqlConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    
    }
    
    public static ResultSet executeQuery(String sql,Object... params){
        Connection conn = SqlConnection.getConnect();
        try {
            CallableStatement cs = conn.prepareCall(sql);
            if (params.length > 0 && params != null) {
                for (int i = 0; i < params.length; i++) {
                    cs.setObject(i+1, params[i]);
                }
            }
            return cs.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(SqlConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public static int executeUpdate(String sql,Object... params){
        Connection conn = SqlConnection.getConnect();
        try {
            CallableStatement cs = conn.prepareCall(sql);
            if (params.length > 0 && params != null) {
                for (int i = 0; i < params.length; i++) {
                    cs.setObject(i+1, params[i]);
                }
            }
            return cs.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SqlConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return 0;
    }
}
