package model;

import java.sql.Date;
public class medicine {
    private String maThuoc;
    private String tenThuoc;
    private Date ngaySx;
    private Date hanSd;
    private double donGia;
    private String thuongHieu;
    private String loaiThuoc;
    private int soLuong;

    public medicine(String maThuoc, String tenThuoc, Date ngaySx, Date hanSd, double donGia, String thuongHieu, String loaiThuoc, int soLuong) {
        this.maThuoc = maThuoc;
        this.tenThuoc = tenThuoc;
        this.ngaySx = ngaySx;
        this.hanSd = hanSd;
        this.donGia = donGia;
        this.thuongHieu = thuongHieu;
        this.loaiThuoc = loaiThuoc;
        this.soLuong = soLuong;
    }

    public medicine(String maThuoc, String tenThuoc, Date ngaySx, Date hanSd, double donGia, String thuongHieu, int soLuong) {
        this.maThuoc = maThuoc;
        this.tenThuoc = tenThuoc;
        this.ngaySx = ngaySx;
        this.hanSd = hanSd;
        this.donGia = donGia;
        this.thuongHieu = thuongHieu;
        this.soLuong = soLuong;
    }

    public medicine() {

    }

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

    public Date getNgaySx() {
        return ngaySx;
    }

    public void setNgaySx(Date ngaySx) {
        this.ngaySx = ngaySx;
    }

    public Date getHanSd() {
        return hanSd;
    }

    public void setHanSd(Date hanSd) {
        this.hanSd = hanSd;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public String getThuongHieu() {
        return thuongHieu;
    }

    public void setThuongHieu(String thuongHieu) {
        this.thuongHieu = thuongHieu;
    }

    public String getLoaiThuoc() {
        return loaiThuoc;
    }

    public void setLoaiThuoc(String loaiThuoc) {
        this.loaiThuoc = loaiThuoc;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void inThongTin(){
        System.out.println("Mã thuốc: " + getMaThuoc());
        System.out.println("Tên thuốc: " + getTenThuoc());
        System.out.println("Ngày sản xuất: " + getNgaySx());
        System.out.println("Hạn sử dụng: " + getHanSd());
        System.out.println("Đơn giá: " + getDonGia() + "VNĐ");
        System.out.println("Thương hiệu: " + getThuongHieu());
        System.out.println("Loại thuốc: " + getLoaiThuoc());
        System.out.print("Số lượng: " + getSoLuong() + " ");
    }

    public double tinhTien(){
        return getSoLuong()*getDonGia();
    }
}
