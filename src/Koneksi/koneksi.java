/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author HYPE
 */
public class koneksi {
    public static Connection connectionmysql;
    
    public static Connection ConnectionDB(){
        if (connectionmysql == null){
            try {
                String url = "jdbc:mysql://localhost:3306/db_toko_handphone";
                String user = "root";
                String pass = "";
                
                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                // Hapus cast (Connection) yang berlebihan
                connectionmysql = DriverManager.getConnection(url, user, pass);
                
                JOptionPane.showMessageDialog(null, "Connection Success");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Koneksi Gagal: " + e.getMessage());
            }
        }
        return connectionmysql;
    }

    // Method main SEKARANG berada di DALAM class koneksi
    public static void main(String[] args) {
        Connection conn = koneksi.ConnectionDB();
        
        if (conn != null) {
            System.out.println("Koneksi berhasil disambungkan dari file koneksi.java!");
        }
    }
}