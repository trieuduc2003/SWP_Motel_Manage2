package dal;

import model.Motel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MotelDAO extends DBContext {

    // Retrieve all motels
    public List<Motel> getAllMotels() {
        List<Motel> motels = new ArrayList<>();
        String sql = "SELECT * FROM Motels";
        try (PreparedStatement ps = connection.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Motel motel = new Motel();
                motel.setId(rs.getInt("Motel_Id"));
                motel.setName(rs.getString("Motel_name"));
                motel.setDescription(rs.getString("description"));
                motel.setAddress(rs.getString("address"));
                motel.setCity(rs.getString("city"));
                motel.setNumberOfRooms(rs.getInt("NumberOfRoom"));

                motels.add(motel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return motels;
    }

    public Motel getAllMotelById(int id) {
        String sql = "SELECT * FROM Motels where motel_id = ? ";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Motel motel = new Motel();
                    motel.setId(rs.getInt("Motel_Id"));
                    motel.setName(rs.getString("Motel_name"));
                    motel.setDescription(rs.getString("description"));
                    motel.setAddress(rs.getString("address"));
                    motel.setCity(rs.getString("city"));
                    motel.setNumberOfRooms(rs.getInt("NumberOfRoom"));

                    return motel;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        MotelDAO mdao = new MotelDAO();
        System.out.println(mdao.getAllMotelById(1));
    }
}
