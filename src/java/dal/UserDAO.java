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
import java.util.ArrayList;
import java.util.List;
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
    String sql = "SELECT * FROM USERS WHERE email = ? AND password = ?";
    User user = null;
    
    try (Connection con = DBContext.getConnection(); 
         PreparedStatement ps = con.prepareStatement(sql)) {
        
        ps.setString(1, email);
        ps.setString(2, password);
        ResultSet rs = ps.executeQuery();
        
        if (rs.next()) {
            user = new User();
            user.setId(rs.getInt("User_id"));
            user.setEmail(rs.getString("email"));
            user.setName(rs.getString("User_Name"));
            user.setPhone(rs.getString("Phone_Num"));
            user.setPassword(rs.getString("Password"));
            user.setStatus(Status.ACTIVE);
            
            // Kiểm tra và gán giá trị role
            try {
                user.setRole(Role.valueOf(rs.getString("role").toUpperCase()));
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid role: " + rs.getString("role"));
                user.setRole(Role.USER); // Gán giá trị mặc định nếu không hợp lệ
            }
            
            // Kiểm tra và gán giá trị status
            try {
                user.setStatus(Status.valueOf(rs.getString("status").toUpperCase()));
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid status: " + rs.getString("status"));
                user.setStatus(Status.ACTIVE); // Gán giá trị mặc định nếu không hợp lệ
            }
        }
    } catch (SQLException e) {
        System.out.println("Error fetching user: " + e.getMessage());
    }
    
    return user;  // Trả về đối tượng user hoặc null nếu không tìm thấy
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

    public User getUser(int userId) {
        String query = "SELECT * FROM Users WHERE User_id = ?";
        User user = null;
        try (Connection con = DBContext.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("User_id"));
                user.setEmail(rs.getString("email"));
                user.setName(rs.getString("User_Name"));
                user.setPhone(rs.getString("Phone_Num"));
                user.setRole(Role.valueOf(rs.getString("role").toUpperCase()));
                user.setStatus(Status.valueOf(rs.getString("status").toUpperCase()));
            }
        } catch (SQLException ex) {
            System.out.println("Error fetching user: " + ex.getMessage());
        }
        return user;  // Return the user object or null if not found
    }

    // Method to get all Users
    public List<User> getAllUsers() {
        String query = "SELECT * FROM Users";
        List<User> userList = new ArrayList<>();

        try (Connection con = DBContext.getConnection(); PreparedStatement ps = con.prepareStatement(query); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("User_id"));
                user.setName(rs.getString("User_Name"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("Phone_Num"));
                user.setRole(Role.valueOf(rs.getString("role").toUpperCase()));
                user.setStatus(Status.valueOf(rs.getString("status").toUpperCase()));
                userList.add(user); // Add the user to the list
            }
        } catch (SQLException ex) {
            System.out.println("Error fetching all users: " + ex.getMessage());
        }

        return userList;  // Return the list of users
    }

    // Method to update a User
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

    public static void main(String[] args) {
        UserDAO udao = new UserDAO();
        System.out.println(udao.getUserByEmailAndPassword("admin@example.com", "admin123"));
        User user = new User();
        user.setEmail("user001@example.com");
        user.setPhone("0333333333");
        user.setName("user11");
        user.setRole(Role.USER);
        user.setId(3);
        System.out.println(udao.updateUser(user));
    }
}
