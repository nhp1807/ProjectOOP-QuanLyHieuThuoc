package model;

import java.sql.Date;
public class thuocNuoc extends medicine{
    public thuocNuoc(){
    }

    public thuocNuoc(String maThuoc, String tenThuoc, Date ngaySx, Date hanSd, double donGia, String thuongHieu, String loaiThuoc, int soLuong) {
        super(maThuoc, tenThuoc, ngaySx, hanSd, donGia, thuongHieu, loaiThuoc, soLuong);
    }

    public thuocNuoc(String maThuoc, String tenThuoc, Date ngaySx, Date hanSd, double donGia, String thuongHieu, int soLuong){
        super(maThuoc, tenThuoc, ngaySx, hanSd, donGia, thuongHieu, soLuong);
        super.setLoaiThuoc("Nước");
    }

    public void inThongTin(){
        super.inThongTin();
        System.out.println("ml");
    }
}
