package com.example.demomenu;

public class ThongTinDanhBa {
    private String hoten, sdt, diachi;

    public ThongTinDanhBa(String hoten, String sdt, String diachi) {
        this.hoten = hoten;
        this.sdt = sdt;
        this.diachi = diachi;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    @Override
    public String toString() {
        return "ThongTinDanhBa{" +
                "hoten='" + hoten + '\'' +
                ", sdt='" + sdt + '\'' +
                ", diachi='" + diachi + '\'' +
                '}';
    }
}
