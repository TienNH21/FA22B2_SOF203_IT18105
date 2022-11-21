package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DanhMuc;

public class DanhMucRepository {
    public boolean insert(DanhMuc danhMuc)
    {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "INSERT INTO danh_muc(ten, mo_ta, trang_thai) "
                + " VALUES (?, ?, ?);";

            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, danhMuc.getTen());
            ps.setString(2, danhMuc.getMoTa());
            ps.setInt(3, danhMuc.getTrangThai());
            
            ps.execute();
            System.out.println("Truy vấn thành công");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean update(DanhMuc danhMuc)
    {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "UPDATE danh_muc SET ten = ?, mo_ta = ?, trang_thai = ? "
                + " WHERE id = ?;";

            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, danhMuc.getTen());
            ps.setString(2, danhMuc.getMoTa());
            ps.setInt(3, danhMuc.getTrangThai());
            ps.setInt(4, danhMuc.getId());
            
            ps.execute();
            System.out.println("Truy vấn thành công");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean delete(DanhMuc danhMuc)
    {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "DELETE FROM danh_muc WHERE id = ?;";

            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setInt(1, danhMuc.getId());
            
            ps.execute();
            System.out.println("Truy vấn thành công");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public ArrayList<DanhMuc> all()
    {
        ArrayList<DanhMuc> ds = new ArrayList<>();
        try {
            Connection conn = DBContext.getConnection();
            String sql = "SELECT * FROM danh_muc";

            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.execute();
            ResultSet rs = ps.getResultSet();
            
            while(rs.next()) {
                int id = rs.getInt("id");
                String ten = rs.getString("ten");
                String moTa = rs.getString("mo_ta");
                int trangThai = rs.getInt("trang_thai");
                
                DanhMuc danhMuc = new DanhMuc(id, ten, moTa, trangThai);
                ds.add(danhMuc);
            }
            
            System.out.println("Truy vấn thành công");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return ds;
    }
}
