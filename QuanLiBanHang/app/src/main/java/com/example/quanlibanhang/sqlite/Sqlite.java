package com.example.quanlibanhang.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.quanlibanhang.R;
import com.example.quanlibanhang.model.KhachHang;
import com.example.quanlibanhang.model.MatHang;

import java.util.ArrayList;
import java.util.List;

public class Sqlite extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "qlBanHang.db";
    private static final int DATABSE_VERSION = 3;
    private  static final String sqlMH = "CREATE TABLE mathangTable(" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "img INTEGER," +
            "tenMatHang TEXT," +
            "maMatHang TEXT," +
            "maqrcode TEXT," +
            "soLuong INTERGER," +
            "giaBan FLOAT," +
            "giaNhap FLOAT," +
            "ghiChu TEXT)";
    private  static final String sqlKH = "CREATE TABLE khachhangTable(" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "img INTEGER," +
            "tenKhachHang TEXT," +
            "soDienThoai TEXT," +
            "email TEXT," +
            "diaChi TEXT," +
            "ghiChu TEXT)";
    private static final  String TABLE_MH = "mathangTable";
    private static final  String TABLE_KH = "khachhangTable";
    public Sqlite(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABSE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlMH);
        db.execSQL(sqlKH);
    }

    public long addMatHang(MatHang mh) {
        ContentValues v = new ContentValues();
        v.put("img", mh.getImg());
        v.put("tenMatHang", mh.getTenMatHang());
        v.put("maMatHang", mh.getMaMatHang());
        v.put("maqrcode", mh.getMaqrcode());
        v.put("soLuong", mh.getSoLuong());
        v.put("giaBan", mh.getGiaBan());
        v.put("giaNhap", mh.getGiaNhap());
        v.put("ghiChu", mh.getGhiChu());
        SQLiteDatabase st = getWritableDatabase();
        return st.insert(TABLE_MH, null, v);
    }

    public List<MatHang> getAll() {
        List<MatHang> list = new ArrayList<>();
        SQLiteDatabase statement = getReadableDatabase();
        Cursor rs = statement.query(TABLE_MH, null,
                null, null,
                null, null, null);
        while ((rs != null) && rs.moveToNext()) {
            int id = rs.getInt(0);
            int img  = rs.getInt(1);
            String tenMatHang  = rs.getString(2);
            String maMatHang  = rs.getString(3);
            String maqrcode = rs.getString(4);
            int soLuong = rs.getInt(5);
            float giaBan = rs.getFloat(6);
            float giaNhap  = rs.getFloat(7) ;
            String ghiChu = rs.getString(8);
            list.add(new MatHang(id,img,tenMatHang,maMatHang,maqrcode,soLuong,giaBan,giaNhap,ghiChu));
        }
        return list;
    }

    public MatHang getMatHangTheoTen(String tenMatHang) {
        String whereClause = "tenMatHang=?";
        String[] whereArgs = {tenMatHang};
        SQLiteDatabase st = getReadableDatabase();
        Cursor rs = st.query(TABLE_MH, null, whereClause,
                whereArgs, null, null, null);
        if (rs.moveToNext()) {
            int id  = rs.getInt(0);
            int img  = rs.getInt(1);
            String maMatHang  = rs.getString(3);
            String maqrcode = rs.getString(4);
            int soLuong = rs.getInt(5);
            float giaBan = rs.getFloat(6);
            float giaNhap  = rs.getFloat(7) ;
            String ghiChu = rs.getString(8);
            new MatHang(id,img,tenMatHang,maMatHang,maqrcode,soLuong,giaBan,giaNhap,ghiChu);
        }
        return null;
    }

    public int update(MatHang mh) {
        ContentValues v = new ContentValues();
        v.put("img", mh.getImg());
        v.put("tenMatHang", mh.getTenMatHang());
        v.put("maMatHang", mh.getMaMatHang());
        v.put("maqrcode", mh.getMaqrcode());
        v.put("soLuong", mh.getSoLuong());
        v.put("giaBan", mh.getGiaBan());
        v.put("giaNhap", mh.getGiaNhap());
        v.put("ghiChu", mh.getGhiChu());
        SQLiteDatabase st = getWritableDatabase();
        String whereClause = "id=?";
        String[] whereArgs = {String.valueOf(mh.getId())};
        return st.update(TABLE_MH, v, whereClause, whereArgs);
    }

    public int delete(int id) {
        String whereClause = "id=?";
        String[] whereArgs = {String.valueOf(id)};
        SQLiteDatabase st = getWritableDatabase();
        return st.delete(TABLE_MH, whereClause, whereArgs);
    }

    public long addKhachHang(KhachHang kh) {
        ContentValues v = new ContentValues();
        v.put("img", kh.getImg());
        v.put("tenKhachHang", kh.getTenKhachHang());
        v.put("soDienThoai", kh.getSoDienThoai());
        v.put("email", kh.getEmail());
        v.put("dicChi", kh.getDiaChi());
        v.put("ghiChu", kh.getGhiChu());
        SQLiteDatabase st = getWritableDatabase();
        return st.insert(TABLE_KH, null, v);
    }
    public List<KhachHang> getAllKH() {
        List<KhachHang> list = new ArrayList<>();
        SQLiteDatabase statement = getReadableDatabase();
        Cursor rs = statement.query(TABLE_KH, null,
                null, null,
                null, null, null);
        while ((rs != null) && rs.moveToNext()) {
            int id = rs.getInt(0);
            int img = rs.getInt(1);
            String tenMatHang = rs.getString(2);
            String sdt = rs.getString(3);
            String email = rs.getString(4);
            String diaChi = rs.getString(5);
            String ghiChu = rs.getString(6);
            list.add(new KhachHang(id, img, tenMatHang, sdt, email, diaChi, ghiChu));
        }
        return list;
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_KH);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MH);
        onCreate(db);
    }
}
