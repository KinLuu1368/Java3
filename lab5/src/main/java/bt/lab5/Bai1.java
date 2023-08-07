/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bt.lab5;

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
public class Bai1 {
    public static void main(String[] args) throws ClassNotFoundException {
        try {
         
            String url = "jdbc:sqlserver://localhost:1433;databaseName=QLSINHVIEN;user=sa;password=Kientung789;encrypt=true;trustServerCertificate=true;";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(url);

            String sql = "SELECT * FROM STUDENTS";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()) {
                System.out.print(rs.getString("MaSV") + " , ");
                System.out.print(rs.getString("Hoten") + ", ");
                System.out.print(rs.getString("Email") + ", ");
                System.out.print(rs.getString("SoDT") + ", ");
                System.out.println(rs.getString("Gioitinh") + " ");
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Bai1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
