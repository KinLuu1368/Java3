/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kien Luu
 */
public class DemoConect {
    public static void main(String[] args) throws SQLException {
        Connection conn = null;
        var user = "";
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("\"jdbc:sqlserver://localhost:1433\\\\SQLEXPRESS;databaseName=QLSINHVIEN;user=sa;password=Kientung789;\"");
        } catch (ClassNotFoundException e) {
            var exception = e.getException();
        } catch (SQLException ex) {
            Logger.getLogger(DemoConect.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Statement statement = conn.createStatement();
        String sql = "SELECT PHG FROM NHANVIEN";
        ResultSet rs = statement.executeQuery(sql);
        while(rs.next()) {
            int PHG = rs.getInt("PHG");
            
            
            System.out.println(PHG);
        }
        
    }

    public static Connection getConnection() {
        Connection conn = null;
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLSINHVIEN;user=sa;password=Kientung789;encrypt=true;trustServerCertificate=true;");
        } catch (ClassNotFoundException e) {
            var exception = e.getException();
        } catch (SQLException ex) {
            Logger.getLogger(DemoConect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
}
