package dal;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Room;
import model.RoomType;

public class RoomDAO extends DBContext {

    // Add a new room
public boolean addRoom(Room room) {
    String sql = "INSERT INTO Room (Motel_id, Type_id) VALUES (?, ?)";
    try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setInt(1, room.getMotelId());
        ps.setInt(2, room.getTypeId());
        return ps.executeUpdate() > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}



    // Get all rooms by motel ID
    public List<Room> getAllRoomsByMotelId(int motelId) {
        List<Room> rooms = new ArrayList<>();
        String sql = "SELECT * FROM Room WHERE Motel_id = ?";
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, motelId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Room room = new Room();
                    room.setRoomId(rs.getInt("Room_id"));
                    room.setMotelId(rs.getInt("Motel_id"));
                    room.setTypeId(rs.getInt("Type_id"));
                    rooms.add(room);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rooms;
    }

    // Get a room by ID
    public Room getRoomById(int roomId) {
        Room room = null;
        String sql = "SELECT * FROM Room WHERE Room_id = ?";
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, roomId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    room = new Room();
                    room.setRoomId(rs.getInt("Room_id"));
                    room.setMotelId(rs.getInt("Motel_id"));
                    room.setTypeId(rs.getInt("Type_id"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return room;
    }

    // Update room details
    public boolean updateRoom(Room room) {
        String sql = "UPDATE Room SET Type_id = ? WHERE Room_id = ?";
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, room.getTypeId());
            ps.setInt(2, room.getRoomId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Delete a room and update the number of rooms
    public boolean deleteRoom(int roomId) {
        String sql = "DELETE FROM Room WHERE Room_id = ?";
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, roomId);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Get all room types
    public List<RoomType> getAllRoomTypes() {
        List<RoomType> roomTypes = new ArrayList<>();
        String sql = "SELECT * FROM Room_Type";
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                RoomType roomType = new RoomType();
                roomType.setTypeId(rs.getInt("Type_id"));
                roomType.setName(rs.getString("Name"));
                roomType.setDescription(rs.getString("Description"));
                roomType.setMaxGuest(rs.getInt("Max_Guest"));
                roomType.setPrice(rs.getDouble("Price"));
                roomType.setDiscount(rs.getDouble("Discount"));
                roomTypes.add(roomType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roomTypes;
    }
    
    // Get room type by ID
    public RoomType getRoomTypeById(int typeId) {
        RoomType roomType = null;
        String sql = "SELECT * FROM Room_Type WHERE Type_id = ?";
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, typeId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    roomType = new RoomType();
                    roomType.setTypeId(rs.getInt("Type_id"));
                    roomType.setName(rs.getString("Name"));
                    roomType.setDescription(rs.getString("Description"));
                    roomType.setMaxGuest(rs.getInt("Max_Guest"));
                    roomType.setPrice(rs.getDouble("Price"));
                    roomType.setDiscount(rs.getDouble("Discount"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roomType;
    }

    // Add a new RoomType
    public boolean addRoomType(RoomType roomType) {
        String sql = "INSERT INTO Room_Type (Name, Description, Max_Guest, Price, Discount) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, roomType.getName());
            ps.setString(2, roomType.getDescription());
            ps.setInt(3, roomType.getMaxGuest());
            ps.setDouble(4, roomType.getPrice());
            ps.setDouble(5, roomType.getDiscount());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Update room type details
    public boolean updateRoomType(RoomType roomType) {
        String sql = "UPDATE Room_Type SET Name = ?, Description = ?, Max_Guest = ?, Price = ?, Discount = ? WHERE Type_id = ?";
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, roomType.getName());
            ps.setString(2, roomType.getDescription());
            ps.setInt(3, roomType.getMaxGuest());
            ps.setDouble(4, roomType.getPrice());
            ps.setDouble(5, roomType.getDiscount());
            ps.setInt(6, roomType.getTypeId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Update room count in the motel
    public boolean updateRoomCount(int motelId, int delta) {
        String sql = "UPDATE Motels SET NumberOfRoom = NumberOfRoom + ? WHERE Motel_id = ?";
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, delta);
            ps.setInt(2, motelId);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        RoomDAO dao = new RoomDAO();
//        List<Room> rooms = dao.getAllRoomsByMotelId(1);
//        for (Room room : rooms) {
//            System.out.println(room);
//        }

        // Test getRoomById
        Room room = dao.getRoomById(1); // Replace with a valid room ID
        if (room != null) {
            System.out.println("Room found: " + room.getRoomId() + " - Type ID: " + room.getTypeId());
        } else {
            System.out.println("Room not found.");
        }

    }
}
