/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import static dal.DBContext.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.User;
import model.enums.Role;
import model.enums.Status;

/**
 *
 * @author ADMIN
 */
public class UserDAO extends DBContext {

    public boolean emailExists(String email) {
        String sql = "SELECT * FROM USERS WHERE email = ?";
        try (Connection con = DBContext.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            return rs.next();  // Return true if the email exists
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean phoneExists(String phone) {
        String sql = "SELECT * FROM USERS WHERE Phone_Num = ?";
        try (Connection con = DBContext.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, phone);
            ResultSet rs = ps.executeQuery();
            return rs.next();  // Return true if the email exists
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }

    public User getUserIdByEmail(String email) {
        String sql = "SELECT * FROM USERS WHERE email = ?";
        try (Connection con = DBContext.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("User_id"));
                user.setEmail(rs.getString("email"));
                user.setName(rs.getString("User_Name"));
                user.setPhone(rs.getString("Phone_Num"));
                user.setRole(Role.valueOf(rs.getString("role").toUpperCase()));
                user.setStatus(Status.valueOf(rs.getString("status").toUpperCase()));
                return user;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;  // Return false if not found
    }

    public boolean updatePassword(String email, String newPassword) {
        String query = "UPDATE USERS SET password = ? WHERE email = ?";

        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, newPassword);
            ps.setString(2, email);

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public User getUserByEmailAndPassword(String email, String password) {
        String sql = """
                    SELECT * FROM USERS WHERE  email = ? AND password = ?
                     """;
        Connection con;
        try {
            con = DBContext.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("User_id"));
                user.setEmail(rs.getString("email"));
                user.setName(rs.getString("User_Name"));
                user.setPhone(rs.getString("Phone_Num"));
                user.setRole(Role.valueOf(rs.getString("role").toUpperCase()));
                user.setStatus(Status.valueOf(rs.getString("status").toUpperCase()));
                return user;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public boolean insertUser(User user) {
        String sql = "INSERT INTO USERS (User_Name, email, password, Phone_Num, role, status) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = DBContext.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getPhone());
            ps.setString(5, user.getRole().name().toUpperCase());
            ps.setString(6, user.getStatus().name().toUpperCase());

            int rowsInserted = ps.executeUpdate();
            return rowsInserted > 0;  // Return true if the insertion is successful
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean activateUserByEmail(String email) {
        String sql = "UPDATE USERS SET status = ?  WHERE email = ?";
        try (Connection con = DBContext.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, Status.ACTIVE.name());
            ps.setString(2, email);
            int rowsUpdated = ps.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean updateUser(User user) {
        String query = "UPDATE users SET User_Name = ?,  Role = ?, Email = ?, Phone_Num = ? WHERE User_id = ?";
        try (Connection connection = DBContext.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            // Thiết lập các giá trị tham số cho câu truy vấn
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getRole().toString()); // Giả sử Role là một enum
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPhone());
//            preparedStatement.setString(5, user.getStatus().toString()); // Giả sử Status là một enum
            preparedStatement.setInt(5, user.getId());

            // Thực thi câu truy vấn
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0; // Trả về true nếu có ít nhất một dòng bị ảnh hưởng
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public static void main(String[] args) {
        UserDAO udao = new UserDAO();
        System.out.println(udao.getUserByEmailAndPassword("staff1@motel.com", "staff123"));
    }
}
