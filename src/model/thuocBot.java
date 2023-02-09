package model;

import java.sql.Date;
public class thuocBot extends medicine{
    public thuocBot(){
    }

    public thuocBot(String maThuoc, String tenThuoc, Date ngaySx, Date hanSd, double donGia, String thuongHieu, String loaiThuoc, int soLuong) {
        super(maThuoc, tenThuoc, ngaySx, hanSd, donGia, thuongHieu, loaiThuoc, soLuong);
    }

    public thuocBot(String maThuoc, String tenThuoc, Date ngaySx, Date hanSd, double donGia, String thuongHieu, int soLuong){
        super(maThuoc, tenThuoc, ngaySx, hanSd, donGia, thuongHieu, soLuong);
        super.setLoaiThuoc("Bột");
    }

    public void inThongTin(){
        super.inThongTin();
        System.out.println("mg");
    }
}
