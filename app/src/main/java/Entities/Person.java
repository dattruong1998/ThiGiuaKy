package Entities;

import java.io.Serializable;

public class Person implements Serializable {
    private String ma;
    private String gioitinh;
    private String hoten;
    private double luong;

    public Person() {
    }

    public Person(String ma, String gioitinh, String hoten, double luong) {
        this.ma = ma;
        this.gioitinh = gioitinh;
        this.hoten = hoten;
        this.luong = luong;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public double getLuong() {
        return luong;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }

    @Override
    public String toString() {
        return "Person{" +
                "ma='" + ma + '\'' +
                ", gioitinh='" + gioitinh + '\'' +
                ", hoten='" + hoten + '\'' +
                ", luong=" + luong +
                '}';
    }
}