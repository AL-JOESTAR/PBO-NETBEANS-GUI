package com.ubp.model;

public class Pelayan extends KaryawanModel {
    public Pelayan(int id, String nama, String nik, String alamat) {
        super(id, nama, nik, "2.000.000", alamat, "Pelayan", "Melayani Pembeli"); // Gaji tetap 10.000.000
    }

    @Override
    public String getTipeKaryawan() {
        return "Pelayan";
    }
}
