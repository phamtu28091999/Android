package com.example.quanlibanhang.model;

import java.io.Serializable;

public class KhachHang implements Serializable {
    private  int id;
    private  int img;
    private String tenKhachHang;
    private  String soDienThoai;
    private String email;
    private  String diaChi;
    private String ghiChu;

    public KhachHang() {
    }

    public KhachHang(int id, int img, String tenKhachHang, String soDienThoai, String email, String diaChi, String ghiChu) {
        this.id = id;
        this.img = img;
        this.tenKhachHang = tenKhachHang;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.diaChi = diaChi;
        this.ghiChu = ghiChu;
    }

    public KhachHang(int img, String tenKhachHang, String soDienThoai, String email, String diaChi, String ghiChu) {
        this.img = img;
        this.tenKhachHang = tenKhachHang;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.diaChi = diaChi;
        this.ghiChu = ghiChu;
    }


    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
}
