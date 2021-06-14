package com.example.quanlibanhang.model;

import java.io.Serializable;

public class MatHang  implements Serializable {
    int id;
    int img;
    String tenMatHang;
    String maMatHang;
    String maqrcode;
    int soLuong;
    float giaBan,giaNhap;
    String ghiChu;

    public MatHang() {
    }

    public MatHang(int img, String tenMatHang, int soLuong, int giaBan) {
        this.img = img;
        this.tenMatHang = tenMatHang;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
    }

    public MatHang(int id, int img, String tenMatHang,
                   String maMatHang, String maqrcode, int soLuong, float giaBan, float giaNhap, String ghiChu) {
        this.id = id;
        this.img = img;
        this.tenMatHang = tenMatHang;
        this.maMatHang = maMatHang;
        this.maqrcode = maqrcode;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
        this.giaNhap = giaNhap;
        this.ghiChu = ghiChu;
    }

    public MatHang(int img, String tenMatHang,
                   String maMatHang, String maqrcode, int soLuong, float giaBan, float giaNhap, String ghiChu) {
        this.id = id;
        this.img = img;
        this.tenMatHang = tenMatHang;
        this.maMatHang = maMatHang;
        this.maqrcode = maqrcode;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
        this.giaNhap = giaNhap;
        this.ghiChu = ghiChu;
    }

    public MatHang(String tenMatHang,
                   String maMatHang, String maqrcode, int soLuong, float giaBan, float giaNhap, String ghiChu) {
        this.tenMatHang = tenMatHang;
        this.maMatHang = maMatHang;
        this.maqrcode = maqrcode;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
        this.giaNhap = giaNhap;
        this.ghiChu = ghiChu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTenMatHang() {
        return tenMatHang;
    }

    public void setTenMatHang(String tenMatHang) {
        this.tenMatHang = tenMatHang;
    }

    public String getMaMatHang() {
        return maMatHang;
    }

    public void setMaMatHang(String maMatHang) {
        this.maMatHang = maMatHang;
    }

    public String getMaqrcode() {
        return maqrcode;
    }

    public void setMaqrcode(String maqrcode) {
        this.maqrcode = maqrcode;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public float getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(float giaBan) {
        this.giaBan = giaBan;
    }

    public float getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(float giaNhap) {
        this.giaNhap = giaNhap;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
}

