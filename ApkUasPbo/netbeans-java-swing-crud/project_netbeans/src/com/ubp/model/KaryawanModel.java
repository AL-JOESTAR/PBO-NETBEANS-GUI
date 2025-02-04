package com.ubp.model;

public abstract class KaryawanModel {
    
    private int id;
    private String nama;
    private String nik;
    private String gaji;
    private String alamat;
    private String profesi;
    private String job;
    
    public KaryawanModel(int id, String nama, String nik, String gaji, String alamat, String profesi,String job) {
        this.id = id;
        this.nama = nama;
        this.nik = nik;
        this.gaji = gaji;
        this.alamat = alamat;
        this.profesi = profesi;
        this.job = job;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getGaji() {
        return gaji;
    }

    public void setGaji(String gaji) {
        this.gaji = gaji;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    
    public String getProfesi() {
        return profesi;
    }

    public void setProfesi(String profesi) {
        this.profesi = profesi;
    }
    
    public String getJob() {
        return job;
    }

    public void setJob(String profesi) {
        this.job = job;
    }

    // Metode abstrak yang harus diimplementasikan oleh subclass
    public abstract String getTipeKaryawan();
}
