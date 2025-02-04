package com.ubp.model;

public class Manajer extends KaryawanModel {
    public Manajer(int id, String nama, String nik, String alamat) {
        super(id, nama, nik, "10.000.000", alamat, "Manajer", "Mengatur Pegawai");
    }

    @Override
    public String getTipeKaryawan() {
        return "Manajer";
    }
}
