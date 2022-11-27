package repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Sach;
//import java.sql.Connection;
//import java.sql.Connection;

public class SachRepository {
    private Connection conn;
    
    public SachRepository()
    {
        try {
            this.conn = DBContext.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<Sach> getAll()
    {
        ArrayList<Sach> ds = new ArrayList<>();
        
        String sql = "SELECT * FROM sach";
        
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.execute();
            
            ResultSet rs = ps.getResultSet();

            while(rs.next()) {
                int id = rs.getInt("id");
                String ten = rs.getString("ten");
                int soLg = rs.getInt("so_luong");
                double donGia = rs.getInt("don_gia");
                int tacGiaId = rs.getInt("tac_gia_id");
                
                Sach s = new Sach(id, ten, soLg, donGia, tacGiaId);
                ds.add(s);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        
        return ds;
    }
    
    public boolean update(Sach s)
    {
        String sql = "UPDATE sach SET "
                + " ten = ?,"
                + " so_luong = ?,"
                + " don_gia = ?,"
                + " tac_gia_id = ?"
                + " WHERE id = ?";
        
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, s.getTen());
            ps.setInt(2, s.getSoLuong());
            ps.setDouble(3, s.getDonGia());
            ps.setInt(4, s.getTacGiaId());
            ps.setInt(5, s.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(int id)
    {
        String sql = "DELETE FROM sach WHERE id = ?";
        
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
