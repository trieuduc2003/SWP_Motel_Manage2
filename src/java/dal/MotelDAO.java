package dal;

import model.Motel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MotelDAO extends DBContext {

//    public boolean insertMotel(Motel motel) {
//        String sql = "INSERT INTO Motels (Motel_name, description, address, city, NumberOfRoom) VALUES (?, ?, ?, ?, ?)";
//        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
//            ps.setString(1, motel.getMotelName());
//            ps.setString(2, motel.getDescription());
//            ps.setString(3, motel.getAddress());
//            ps.setString(4, motel.getCity());
//            ps.setInt(5, motel.getNumberOfRoom());
//            return ps.executeUpdate() > 0;
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
    
public boolean insertMotel(Motel motel) {
    String insertSql = "INSERT INTO Motels (Motel_name, description, address, city, NumberOfRoom) VALUES (?, ?, ?, ?, ?)";
    
    try (Connection con = getConnection(); 
         PreparedStatement psInsert = con.prepareStatement(insertSql)) {

        // Set the values for insert statement
        psInsert.setString(1, motel.getMotelName());
        psInsert.setString(2, motel.getDescription());
        psInsert.setString(3, motel.getAddress());
        psInsert.setString(4, motel.getCity());
        psInsert.setInt(5, motel.getNumberOfRoom());

        // Execute insert
        return psInsert.executeUpdate() > 0;
        
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}



    public boolean updateMotel(Motel motel) {
        String sql = "UPDATE Motels SET Motel_name = ?, description = ?, address = ?, city = ?, NumberOfRoom = ? WHERE Motel_id = ?";
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, motel.getMotelName());
            ps.setString(2, motel.getDescription());
            ps.setString(3, motel.getAddress());
            ps.setString(4, motel.getCity());
            ps.setInt(5, motel.getNumberOfRoom());
            ps.setInt(6, motel.getMotelId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteMotel(int motelId) {
        String sql = "DELETE FROM Motels WHERE Motel_id = ?";
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, motelId);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Motel getMotelById(int motelId) {
        String sql = "SELECT * FROM Motels WHERE Motel_id = ?";
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, motelId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Motel motel = new Motel();
                motel.setMotelId(rs.getInt("Motel_id"));
                motel.setMotelName(rs.getString("Motel_name"));
                motel.setDescription(rs.getString("description"));
                motel.setAddress(rs.getString("address"));
                motel.setCity(rs.getString("city"));
                motel.setNumberOfRoom(rs.getInt("NumberOfRoom"));
                return motel;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

public List<Motel> getAllMotels(String searchTerm) {
    List<Motel> motels = new ArrayList<>();
    String sql;
    
    if (searchTerm == null || searchTerm.isEmpty()) {
        // Query to get all motels
        sql = "SELECT * FROM Motels";
    } else {
        // Query to search by motel name
        sql = "SELECT * FROM Motels WHERE Motel_name LIKE ?";
    }
    
    try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
        if (searchTerm != null && !searchTerm.isEmpty()) {
            ps.setString(1, "%" + searchTerm + "%"); // Use wildcard for partial matches
        }
        
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Motel motel = new Motel();
                motel.setMotelId(rs.getInt("Motel_id"));
                motel.setMotelName(rs.getString("Motel_name"));
                motel.setDescription(rs.getString("description"));
                motel.setAddress(rs.getString("address"));
                motel.setCity(rs.getString("city"));
                motel.setNumberOfRoom(rs.getInt("NumberOfRoom"));
                motels.add(motel);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    
    return motels;
}

public List<Motel> getAllMotelHaveDiscount(boolean isDiscount, String searchKeyword) {
    List<Motel> motels = new ArrayList<>();
    String sql;

    if (isDiscount) {
        sql = "SELECT m.Motel_id, m.Motel_name, m.description, m.address, m.city, m.NumberOfRoom " +
              "FROM Motels m " +
              "JOIN Room r ON m.Motel_id = r.Motel_id " +
              "JOIN Room_Type rt ON r.Type_id = rt.Type_id " +
              "WHERE rt.Discount > 0"; // Lấy các motel có phòng với discount
    } else {
        sql = "SELECT m.* FROM Motels m"; // Lấy tất cả các motel
    }

    // Thêm điều kiện tìm kiếm
    if (searchKeyword != null && !searchKeyword.trim().isEmpty()) {
        if (isDiscount) {
            sql += " AND m.Motel_name LIKE ?"; // Tìm kiếm theo tên motel
        } else {
            sql += " WHERE m.Motel_name LIKE ?"; // Tìm kiếm theo tên motel
        }
    }

    try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
        // Nếu có tìm kiếm, thiết lập tham số cho PreparedStatement
        if (searchKeyword != null && !searchKeyword.trim().isEmpty()) {
            ps.setString(1, "%" + searchKeyword + "%");
        }

        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Motel motel = new Motel();
                motel.setMotelId(rs.getInt("Motel_id"));
                motel.setMotelName(rs.getString("Motel_name"));
                motel.setDescription(rs.getString("description"));
                motel.setAddress(rs.getString("address"));
                motel.setCity(rs.getString("city"));
                motel.setNumberOfRoom(rs.getInt("NumberOfRoom"));
                motels.add(motel);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return motels;
}




    public static void main(String[] args) {
        MotelDAO dao = new MotelDAO();
        for (Motel arg : dao.getAllMotelHaveDiscount(false, "a")) {
            System.out.println(arg);
        }
    }

}
