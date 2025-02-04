package com.ubp.model;

//inheritance
public class Kasir extends KaryawanModel {
    public Kasir(int id, String nama, String nik, String alamat) {
        super(id, nama, nik, "5.000.000", alamat, "Kasir", "Manajemen uang perusahaan"); 
    }

    //polimorfisme
    @Override
    public String getTipeKaryawan() {
        return "Kasir";
    }
}
