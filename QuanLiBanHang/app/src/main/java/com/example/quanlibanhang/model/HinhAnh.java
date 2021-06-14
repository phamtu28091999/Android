package com.example.quanlibanhang.model;

public class HinhAnh {
    private int duongDan;
    private String tenHinhAnh;

    public HinhAnh() {
    }

    public HinhAnh(int duongDan, String tenHinhAnh) {
        this.duongDan = duongDan;
        this.tenHinhAnh = tenHinhAnh;
    }

    public int getDuongDan() {
        return duongDan;
    }

    public void setDuongDan(int duongDan) {
        this.duongDan = duongDan;
    }

    public String getTenHinhAnh() {
        return tenHinhAnh;
    }

    public void setTenHinhAnh(String tenHinhAnh) {
        this.tenHinhAnh = tenHinhAnh;
    }
}

