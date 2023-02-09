package model;

import java.sql.Date;
public class donhang extends donhang_info {
    private int idKhach;
//    private int idDonThuoc;
    private String maThuoc;
    private String tenThuoc;
    private double donGia;
    private int soLuong;
    private String cachDung;
    private Date ngayThanhToan;

    public int getIdKhach() {
        return idKhach;
    }

    public void setIdKhach(int idKhach) {
        this.idKhach = idKhach;
    }

    public Date getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(Date ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public donhang(int idDonThuoc, String maThuoc, String tenThuoc, double donGia, int soLuong, String cachDung) {
//        this.idDonThuoc = idDonThuoc;
        this.maThuoc = maThuoc;
        this.tenThuoc = tenThuoc;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.cachDung = cachDung;
    }

    public donhang(int idKhach, String maThuoc, String tenThuoc, double donGia, int soLuong, Date ngayThanhToan) {
        this.idKhach = idKhach;
        this.maThuoc = maThuoc;
        this.tenThuoc = tenThuoc;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.ngayThanhToan = ngayThanhToan;
    }


    public donhang() {
    }

//    public int getIdDonThuoc() {
//        return idDonThuoc;
//    }
//
//    public void setIdDonThuoc(int idDonThuoc) {
//        this.idDonThuoc = idDonThuoc;
//    }

    public String getMaThuoc() {
        return maThuoc;
    }

    public void setMaThuoc(String maThuoc) {
        this.maThuoc = maThuoc;
    }

    public String getTenThuoc() {
        return tenThuoc;
    }

    public void setTenThuoc(String tenThuoc) {
        this.tenThuoc = tenThuoc;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getCachDung() {
        return cachDung;
    }

    public void setCachDung(String cachDung) {
        this.cachDung = cachDung;
    }
}
