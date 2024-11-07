package dal;

import model.Room;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Motel;
import model.RoomType;

public class RoomDAO extends DBContext {

    final MotelDAO motelDAO = new MotelDAO();

    // Retrieve all rooms for a specific motel
    public List<Room> getRoomsByMotelId(int motelId) {
        List<Room> rooms = new ArrayList<>();
        RoomTypeDAO typeDAO = new RoomTypeDAO();
        String sql = "SELECT * FROM Room WHERE Motel_Id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, motelId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Room room = new Room();
                    room.setId(rs.getInt("Room_id"));
                    Motel motel = motelDAO.getAllMotelById(rs.getInt("Motel_Id"));
                    room.setMotel(motel);
                    RoomType roomType = typeDAO.getRoomTypeByID(rs.getInt("Type_id"));
                    room.setRoomType(roomType);
                    rooms.add(room);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rooms;
    }

    public List<Room> getAllRooms() {
        List<Room> rooms = new ArrayList<>();
        RoomTypeDAO typeDAO = new RoomTypeDAO();
        String sql = "SELECT * FROM Room";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Room room = new Room();
                    room.setId(rs.getInt("Room_id"));
                    Motel motel = motelDAO.getAllMotelById(rs.getInt("Motel_Id"));
                    room.setMotel(motel);
                    RoomType roomType = typeDAO.getRoomTypeByID(rs.getInt("Type_id"));
                    room.setRoomType(roomType);
                    rooms.add(room);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rooms;
    }

    public Room getRoomsById(int motelId) {
        RoomTypeDAO typeDAO = new RoomTypeDAO();
        String sql = "SELECT * FROM Room WHERE Room_Id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, motelId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Room room = new Room();
                    room.setId(rs.getInt("Room_id"));
                    Motel motel = motelDAO.getAllMotelById(rs.getInt("Motel_Id"));
                    room.setMotel(motel);
                    RoomType roomType = typeDAO.getRoomTypeByID(rs.getInt("Type_id"));
                    room.setRoomType(roomType);
                    return room;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        RoomDAO roomDao = new RoomDAO();
        List<Room> list = roomDao.getAllRooms();
        for (Room r : list) {
            System.out.println(r);
        }
    }
}
