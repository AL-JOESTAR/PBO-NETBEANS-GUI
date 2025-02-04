package com.ubp.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Koneksi {
    
    private static Connection mysqlkonek;
    
    public static Connection koneksiDB() {
        if (mysqlkonek == null) {
            try {
                String nama_database = "project_data_karyawan"; // Nama database
                String DB = "jdbc:mysql://localhost:3306/" + nama_database + "?serverTimezone=UTC";
                String user = "root"; // User database
                String pass = ""; // Password database
                
                // Load driver baru
                Class.forName("com.mysql.cj.jdbc.Driver");
                
                // Koneksi ke database
                mysqlkonek = DriverManager.getConnection(DB, user, pass);
                System.out.println("Koneksi Berhasil!");
                
            } catch (ClassNotFoundException e) {
                JOptionPane.showMessageDialog(null, "Driver tidak ditemukan! Pastikan library MySQL Connector terpasang.");
                e.printStackTrace();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Koneksi Gagal! Pastikan MySQL berjalan.\nError: " + e.getMessage());
                e.printStackTrace();
            }
        }
        return mysqlkonek;
    }
}
