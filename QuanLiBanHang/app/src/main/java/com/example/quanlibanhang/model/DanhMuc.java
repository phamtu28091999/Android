package com.example.quanlibanhang.model;

public class DanhMuc {
    private  int img;
    private  String tenDanhMuc;

    public DanhMuc(int img, String tenDanhMuc) {
        this.img = img;
        this.tenDanhMuc = tenDanhMuc;
    }

    public DanhMuc() {
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTenDanhMuc() {
        return tenDanhMuc;
    }

    public void setTenDanhMuc(String tenDanhMuc) {
        this.tenDanhMuc = tenDanhMuc;
    }
}
