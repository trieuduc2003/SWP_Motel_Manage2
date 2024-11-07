package dal;

import model.RentContact;
<<<<<<< HEAD
=======
import java.sql.Connection;
>>>>>>> origin/QuangAnh267
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
<<<<<<< HEAD
import model.Room;
import model.enums.Status;

public class RentContactDAO extends DBContext {

    public List<RentContact> getRenContacts(String search, String status) throws SQLException {
        List<RentContact> rentContacts = new ArrayList<>();
        StringBuilder query = new StringBuilder(
                "SELECT rc.*, r.Room_id, r.Motel_id  FROM Rent_Contact rc JOIN room r on r.Room_id = rc.Room_id WHERE 1=1 "
        );

        if (search != null && !search.isEmpty()) {
            query.append(" AND ((rc.guest_name LIKE ?) OR (rc.Email like ?)) ");
        }
        if (status != null && !status.isEmpty()) {
            query.append(" AND rc.status = ? ");
        }

        PreparedStatement ps = connection.prepareStatement(query.toString());

        int index = 1;

        if (search != null && !search.isEmpty()) {
            ps.setString(index++, "%" + search + "%");
            ps.setString(index++, "%" + search + "%");
        }
        if (status != null && !status.isEmpty()) {
            ps.setString(index++, status);
        }

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            RentContact rentContact = new RentContact();
            rentContact.setRencontactID(rs.getInt("RentContract_ID"));
            rentContact.setGuestName(rs.getString("Guest_name"));
            RoomDAO roomDAO = new RoomDAO();
            Room r = roomDAO.getRoomsById(rs.getInt("room_ID"));
            rentContact.setRoom(r);
            rentContact.setStartDate(rs.getDate("Start_date").toLocalDate());
            rentContact.setEndDate(rs.getDate("End_date").toLocalDate());
            rentContact.setPhoneNumber(rs.getString("Phone_number"));
            rentContact.setEmail(rs.getString("Email"));
            rentContact.setAddress(rs.getString("Address"));
            rentContact.setStatus(Status.valueOf(rs.getString("status")));
            rentContacts.add(rentContact);
        }

        return rentContacts;
    }

    public List<RentContact> Paging(List<RentContact> contracts, int page, int pageSize) {
        int fromIndex = (page - 1) * pageSize;
        int toIndex = Math.min(fromIndex + pageSize, contracts.size());

        if (fromIndex > toIndex) {
            // Handle the case where fromIndex is greater than toIndex
            fromIndex = toIndex;
        }

        return contracts.subList(fromIndex, toIndex);
    }

    public void updateStatus(int rencontactID, Status status) throws SQLException {
        String sql = "UPDATE Rent_Contact SET status = ? WHERE RentContract_ID = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, status.name());
            ps.setInt(2, rencontactID);
            ps.executeUpdate();
        }
    }
public RentContact getRentContactById(int rencontactID) throws SQLException {
    String sql = "SELECT rc.*, r.Room_id, r.Motel_id " +
                 "FROM Rent_Contact rc " +
                 "JOIN Room r ON rc.Room_id = r.Room_id " +
                 "WHERE rc.RentContract_ID = ?";
    RentContact rentContact = null;

    try (PreparedStatement ps = connection.prepareStatement(sql)) {
        ps.setInt(1, rencontactID);
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                rentContact = new RentContact();
                rentContact.setRencontactID(rs.getInt("RentContract_ID"));
                rentContact.setGuestName(rs.getString("Guest_name"));
                rentContact.setRoomId(rs.getInt("Room_id"));
                
                RoomDAO roomDAO = new RoomDAO();
                Room room = roomDAO.getRoomsById(rs.getInt("Room_id"));
                rentContact.setRoom(room);
                
                rentContact.setStartDate(rs.getDate("Start_date").toLocalDate());
                rentContact.setEndDate(rs.getDate("End_date").toLocalDate());
                rentContact.setPhoneNumber(rs.getString("Phone_number"));
                rentContact.setEmail(rs.getString("Email"));
                rentContact.setAddress(rs.getString("Address"));
                rentContact.setStatus(Status.valueOf(rs.getString("status").toUpperCase()));
            }
        }
    }
    return rentContact;
}

    public static void main(String[] args) {
        RentContactDAO rcdao = new RentContactDAO();

    }

}
=======
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.math.BigDecimal;

public class RentContactDAO extends DBContext {

    public List<RentContact> getAllRentContacts() throws SQLException {
        List<RentContact> rentContacts = new ArrayList<>();
        String sql = "SELECT * FROM Rent_Contact";
        try (Connection conn = getConnection();
             PreparedStatement statement = conn.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {
            while (rs.next()) {
                RentContact rentContact = new RentContact();
                rentContact.setRentContractId(rs.getInt("RentContract_id"));
                rentContact.setGuestName(rs.getString("Guest_name"));
                rentContact.setRoomId(rs.getInt("Room_id"));
                rentContact.setStartDate(rs.getDate("Start_date"));
                rentContact.setEndDate(rs.getDate("End_date"));
                rentContact.setPhoneNumber(rs.getString("Phone_number"));
                rentContact.setEmail(rs.getString("Email"));
                rentContact.setAddress(rs.getString("Address"));
                rentContact.setStatus(rs.getString("Status"));
                rentContacts.add(rentContact);
            }
        } catch (SQLException e) {
            throw new SQLException("Error fetching rent contacts", e);
        }
        return rentContacts;
    }

    private java.util.Date convertToDate(LocalDate localDate) {
        return java.util.Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public void addRentContact(RentContact rentContact) throws SQLException {
        String sql = "INSERT INTO Rent_Contact (Guest_name, Room_id, Start_date, End_date, Phone_number, Email, Address, Status, Total_Price) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, rentContact.getGuestName());
            statement.setInt(2, rentContact.getRoomId());
            statement.setDate(3, new java.sql.Date(rentContact.getStartDate().getTime()));
            statement.setDate(4, new java.sql.Date(rentContact.getEndDate().getTime()));
            statement.setString(5, rentContact.getPhoneNumber());
            statement.setString(6, rentContact.getEmail());
            statement.setString(7, rentContact.getAddress());
            statement.setString(8, rentContact.getStatus());
            statement.setBigDecimal(9, rentContact.getTotalPrice());

            statement.executeUpdate();
        }
    }
}
>>>>>>> origin/QuangAnh267
