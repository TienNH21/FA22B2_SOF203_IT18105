package model;

public class Sach {
    private int id;
    private String ten;
    private int soLuong;
    private double donGia;
    private int tacGiaId;

    public Sach(int id, String ten, int soLuong, double donGia, int tacGiaId) {
        this.id = id;
        this.ten = ten;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.tacGiaId = tacGiaId;
    }

    public Sach() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public int getTacGiaId() {
        return tacGiaId;
    }

    public void setTacGiaId(int tacGiaId) {
        this.tacGiaId = tacGiaId;
    }
    
    
}
