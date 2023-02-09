package model;

import java.sql.Date;
public class donhang_info {
    private int idDonThuoc;
    private int idKhach;
    private double tongTien;
    private Date ngayThanhToan;

    public donhang_info(int idDonThuoc, int idKhach, double tongTien, Date ngayThanhToan) {
        this.idDonThuoc = idDonThuoc;
        this.idKhach = idKhach;
        this.tongTien = tongTien;
        this.ngayThanhToan = ngayThanhToan;
    }

    public donhang_info() {
    }

    public int getIdDonThuoc() {
        return idDonThuoc;
    }

    public void setIdDonThuoc(int idDonThuoc) {
        this.idDonThuoc = idDonThuoc;
    }

    public int getIdKhach() {
        return idKhach;
    }

    public void setIdKhach(int idKhach) {
        this.idKhach = idKhach;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public Date getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(Date ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public void inDonThuoc(){
        System.out.println("Mã đơn: " + getIdDonThuoc());
        System.out.println("Mã khách: " + getIdKhach());
        System.out.println("Tỏng Tiền: " + getTongTien());
        System.out.println("Ngày mua: " + getNgayThanhToan());
    }
}
