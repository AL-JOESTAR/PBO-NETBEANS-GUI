package com.ubp.manager;

import com.ubp.config.Koneksi;
import com.ubp.model.KaryawanModel;
import com.ubp.model.Kasir;
import com.ubp.model.Manajer;
import com.ubp.model.Pelayan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KaryawanManager {
    
    private final Connection koneksiDatabase;
    
    public KaryawanManager() {
        this.koneksiDatabase = Koneksi.koneksiDB();
    }
    
    public List<KaryawanModel> tampilSemua(){
        String query = "SELECT * FROM karyawan";
        List<KaryawanModel> list = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = koneksiDatabase.prepareStatement(query);
            ResultSet hasilQuery = preparedStatement.executeQuery();
            
            while(hasilQuery.next()){
                KaryawanModel model = buatKaryawanDariResultSet(hasilQuery);
                list.add(model);
            }            
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(KaryawanManager.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public KaryawanModel byId(int id){
        String query = "SELECT * FROM karyawan WHERE id = ?";
        try {
            PreparedStatement preparedStatement = koneksiDatabase.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet hasilQuery = preparedStatement.executeQuery();
            
            if(hasilQuery.next()){
                return buatKaryawanDariResultSet(hasilQuery);
            }            
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(KaryawanManager.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }    

    private KaryawanModel buatKaryawanDariResultSet(ResultSet hasilQuery) throws SQLException {
        int id = hasilQuery.getInt("id");
        String nama = hasilQuery.getString("nama");
        String nik = hasilQuery.getString("nik");
        String alamat = hasilQuery.getString("alamat");
        String profesi = hasilQuery.getString("profesi");
        


        if (profesi.equalsIgnoreCase("Kasir")) {
            return new Kasir(id, nama, nik, alamat);
        } 
        
        if (profesi.equalsIgnoreCase("Pelayan")) {
            return new Pelayan(id, nama, nik, alamat);
        } 
        
        else {
            return new Manajer(id, nama, nik, alamat);
        }
    }
    
    public boolean insert(String nama, String nik, String alamat, String profesi) {
        String query = "INSERT INTO karyawan (nama, nik, alamat, profesi) VALUES (?, ?, ?, ?)";
        
        try {
            PreparedStatement preparedStatement = koneksiDatabase.prepareStatement(query);
            preparedStatement.setString(1, nama);
            preparedStatement.setString(2, nik);
            preparedStatement.setString(3, alamat);
            preparedStatement.setString(4, profesi);
            preparedStatement.executeUpdate();   
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(KaryawanManager.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean update(String nama, String nik, String alamat, String profesi, int id) {
        String query = "UPDATE karyawan SET nama = ?, nik = ?, alamat = ?, profesi = ? WHERE id = ?";
        
        try {
            PreparedStatement preparedStatement = koneksiDatabase.prepareStatement(query);
            preparedStatement.setString(1, nama);
            preparedStatement.setString(2, nik);
            preparedStatement.setString(3, alamat);
            preparedStatement.setString(4, profesi);
            preparedStatement.setInt(5, id);
            preparedStatement.executeUpdate();   
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(KaryawanManager.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean delete(int id) {
        String query = "DELETE FROM karyawan WHERE id = ?";
        
        try {
            PreparedStatement preparedStatement = koneksiDatabase.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();   
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(KaryawanManager.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
