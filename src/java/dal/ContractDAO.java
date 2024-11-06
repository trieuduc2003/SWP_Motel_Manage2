package dal;

import model.Contract;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class ContractDAO extends DBContext {

    // Thêm hợp đồng mới
    public boolean addContract(Contract contract) {
        String sql = "INSERT INTO Contract (User_ID, Room_id, CreateAt, Motel_id, Total_Price, Payment_method, Payment_Status, Payment_Date, TypeOfContract) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, contract.getUserId());
            ps.setInt(2, contract.getRoomId());
            ps.setDate(3, Date.valueOf(contract.getCreateAt())); // Chuyển đổi LocalDate sang java.sql.Date
            ps.setInt(4, contract.getMotelId());
            ps.setDouble(5, contract.getTotalPrice());
            ps.setString(6, contract.getPaymentMethod());
            ps.setString(7, contract.getPaymentStatus());
            ps.setDate(8, Date.valueOf(contract.getPaymentDate())); // Chuyển đổi LocalDate sang java.sql.Date
            ps.setString(9, contract.getTypeOfContract());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Cập nhật hợp đồng
    public boolean updateContract(Contract contract) {
        String sql = "UPDATE Contract SET Room_id = ?, CreateAt = ?, Motel_id = ?, Total_Price = ?, Payment_method = ?, Payment_Status = ?, Payment_Date = ?, TypeOfContract = ? WHERE Contract_id = ?";
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, contract.getRoomId());
            ps.setDate(2, Date.valueOf(contract.getCreateAt())); // Chuyển đổi LocalDate sang java.sql.Date
            ps.setInt(3, contract.getMotelId());
            ps.setDouble(4, contract.getTotalPrice());
            ps.setString(5, contract.getPaymentMethod());
            ps.setString(6, contract.getPaymentStatus());
            ps.setDate(7, Date.valueOf(contract.getPaymentDate())); // Chuyển đổi LocalDate sang java.sql.Date
            ps.setString(8, contract.getTypeOfContract());
            ps.setInt(9, contract.getContractId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Xóa hợp đồng
    public boolean deleteContract(int contractId) {
        String sql = "DELETE FROM Contract WHERE Contract_id = ?";
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, contractId);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Lấy tất cả hợp đồng
    public List<Contract> getAllContracts() {
        List<Contract> contracts = new ArrayList<>();
        String sql = "SELECT * FROM Contract";
        try (Connection con = getConnection(); Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Contract contract = new Contract();
                contract.setContractId(rs.getInt("Contract_id"));
                contract.setUserId(rs.getInt("User_id"));
                contract.setRoomId(rs.getInt("Room_id"));
                contract.setCreateAt(rs.getDate("CreateAt").toLocalDate().toString()); // Chuyển đổi java.sql.Date sang LocalDate
                contract.setMotelId(rs.getInt("Motel_id"));
                contract.setTotalPrice(rs.getDouble("Total_Price"));
                contract.setPaymentMethod(rs.getString("Payment_method"));
                contract.setPaymentStatus(rs.getString("Payment_Status"));
                contract.setPaymentDate(rs.getDate("Payment_Date").toLocalDate().toString()); // Chuyển đổi java.sql.Date sang LocalDate
                contract.setTypeOfContract(rs.getString("TypeOfContract"));
                contracts.add(contract);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contracts;
    }

    // Lấy hợp đồng theo ID
    public Contract getContractById(int contractId) {
        String sql = "SELECT * FROM Contract WHERE Contract_id = ?";
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, contractId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Contract contract = new Contract();
                    contract.setContractId(rs.getInt("Contract_id"));
                    contract.setUserId(rs.getInt("User_id"));
                    contract.setRoomId(rs.getInt("Room_id"));
                    contract.setCreateAt(rs.getDate("CreateAt").toLocalDate().toString()); // Chuyển đổi java.sql.Date sang LocalDate
                    contract.setMotelId(rs.getInt("Motel_id"));
                    contract.setTotalPrice(rs.getDouble("Total_Price"));
                    contract.setPaymentMethod(rs.getString("Payment_method"));
                    contract.setPaymentStatus(rs.getString("Payment_Status"));
                    contract.setPaymentDate(rs.getDate("Payment_Date").toLocalDate().toString()); // Chuyển đổi java.sql.Date sang LocalDate
                    contract.setTypeOfContract(rs.getString("TypeOfContract"));
                    return contract;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Lấy hợp đồng theo User ID
    public List<Contract> getContractsByUserId(int userId) {
        List<Contract> contracts = new ArrayList<>();
        String sql = "SELECT * FROM Contract WHERE User_id = ?";
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, userId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Contract contract = new Contract();
                    contract.setContractId(rs.getInt("Contract_id"));
                    contract.setUserId(rs.getInt("User_id"));
                    contract.setRoomId(rs.getInt("Room_id"));
                    contract.setCreateAt(rs.getDate("CreateAt").toLocalDate().toString()); // Chuyển đổi java.sql.Date sang LocalDate
                    contract.setMotelId(rs.getInt("Motel_id"));
                    contract.setTotalPrice(rs.getDouble("Total_Price"));
                    contract.setPaymentMethod(rs.getString("Payment_method"));
                    contract.setPaymentStatus(rs.getString("Payment_Status"));
                    contract.setPaymentDate(rs.getDate("Payment_Date").toLocalDate().toString()); // Chuyển đổi java.sql.Date sang LocalDate
                    contract.setTypeOfContract(rs.getString("TypeOfContract"));
                    contracts.add(contract);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contracts;
    }
}
