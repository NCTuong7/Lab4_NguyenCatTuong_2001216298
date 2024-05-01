package com.example.lab4_nguyencattuong_2001216298;

public class NhanVien {
    int idImg;
     String maNhanVien;
     String tenNhanVien;
     Boolean checkNhanVien;

    public NhanVien(int idImg, String maNhanVien, String tenNhanVien, Boolean checkNhanVien) {
        this.idImg = idImg;
        this.maNhanVien = maNhanVien;
        this.tenNhanVien = tenNhanVien;
        this.checkNhanVien = checkNhanVien;
    }

    public Boolean getCheckNhanVien() {
        return checkNhanVien;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public int getIdImg() {
        return idImg;
    }

    public void setIdImg(int idImg) {
        this.idImg = idImg;
    }

    public void setCheckNhanVien(Boolean checkNhanVien) {
        this.checkNhanVien = checkNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

}
