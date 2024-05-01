package com.example.lab4_nguyencattuong_2001216298;

public class Nuocs {
    int idImg;
    String nameImg;
    String dienTich;
    String moTa;

    public int getIdImg() {
        return idImg;
    }

    public void setIdImg(int idImg) {
        this.idImg = idImg;
    }

    public String getNameImg() {
        return nameImg;
    }

    public void setNameImg(String nameImg) {
        this.nameImg = nameImg;
    }

    public String getDienTich() {
        return dienTich;
    }

    public void setDienTich(String dienTich) {
        this.dienTich = dienTich;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Nuocs(int idImg, String nameImg, String dienTich, String moTa) {
        this.idImg = idImg;
        this.nameImg = nameImg;
        this.dienTich = dienTich;
        this.moTa = moTa;
    }

    public Nuocs() {
    }
}
