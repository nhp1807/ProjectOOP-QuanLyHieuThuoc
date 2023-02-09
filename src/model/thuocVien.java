package model;

import java.sql.Date;
public class thuocVien extends medicine{
    public thuocVien(){
    }

    public thuocVien(String maThuoc, String tenThuoc, Date ngaySx, Date hanSd, double donGia, String thuongHieu, String loaiThuoc, int soLuong) {
        super(maThuoc, tenThuoc, ngaySx, hanSd, donGia, thuongHieu, loaiThuoc, soLuong);
    }

    public thuocVien(String maThuoc, String tenThuoc, Date ngaySx, Date hanSd, double donGia, String thuongHieu, int soLuong){
        super(maThuoc, tenThuoc, ngaySx, hanSd, donGia, thuongHieu, soLuong);
        super.setLoaiThuoc("Viên");
    }

    public void inThongTin(){
        super.inThongTin();
        System.out.println("viên");
    }
}
