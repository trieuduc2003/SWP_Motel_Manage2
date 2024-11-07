/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
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
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            return rs.next();  // Return true if the email exists
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }
    
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM Users where role = 'USER'";
        try (PreparedStatement ps = connection.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("User_id"));
                user.setName(rs.getString("User_Name"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("Phone_Num"));
                user.setRole(Role.valueOf(rs.getString("role").toUpperCase()));
                
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
    
    public boolean phoneExists(String phone) {
        String sql = "SELECT * FROM USERS WHERE Phone_Num = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
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
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
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
    
    public User getUserById(int id) {
        String sql = "SELECT * FROM USERS WHERE user_id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
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
        
        try (PreparedStatement ps = connection.prepareStatement(query)) {
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
        try {
            
            PreparedStatement ps = connection.prepareStatement(sql);
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
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
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
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
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
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

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


    public List<User> getAllUserWithParam(String searchParam, String status) {
        List<User> users = new ArrayList<>();
        List<Object> list = new ArrayList<>();
        UserDAO userDao = new UserDAO();
        try {
            StringBuilder query = new StringBuilder();
            query.append("SELECT * FROM USERS  WHERE 1 = 1");
            if (searchParam != null && !searchParam.trim().isEmpty()) {
                query.append(" AND  User_Name LIKE ? ");
                list.add("%" + searchParam + "%");
            }
            if (status != null) {
                query.append(" AND  status = ? ");
                list.add(status);
            }
            
            query.append("""
                ORDER BY User_id DESC
                """);
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement(query.toString());
            mapParams(preparedStatement, list);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    User user = new User();
                    user.setId(rs.getInt("User_id"));
                    user.setEmail(rs.getString("email"));
                    user.setName(rs.getString("User_Name"));
                    user.setPhone(rs.getString("Phone_Num"));
                    user.setRole(Role.valueOf(rs.getString("role").toUpperCase()));
                    user.setStatus(Status.valueOf(rs.getString("status").toUpperCase()));
                    users.add(user);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }
    
    public boolean updateUserStatus(int userId, String status) {
        String sql = "UPDATE USERS SET status = ? WHERE User_id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, status);
            ps.setInt(2, userId);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public List<User> Paging(List<User> users, int page, int pageSize) {
        int fromIndex = (page - 1) * pageSize;
        int toIndex = Math.min(fromIndex + pageSize, users.size());
        
        if (fromIndex > toIndex) {
            // Handle the case where fromIndex is greater than toIndex
            fromIndex = toIndex;
        }
        
        return users.subList(fromIndex, toIndex);
    }
    
    public void mapParams(PreparedStatement ps, List<Object> args) throws SQLException {
        int i = 1;
        for (Object arg : args) {
            if (arg instanceof Date) {
                ps.setTimestamp(i++, new Timestamp(((Date) arg).getTime()));
            } else if (arg instanceof Integer) {
                ps.setInt(i++, (Integer) arg);
            } else if (arg instanceof Long) {
                ps.setLong(i++, (Long) arg);
            } else if (arg instanceof Double) {
                ps.setDouble(i++, (Double) arg);
            } else if (arg instanceof Float) {
                ps.setFloat(i++, (Float) arg);
            } else {
                ps.setString(i++, (String) arg);
            }
        }
    }
   
    public static void main(String[] args) {
        UserDAO udao = new UserDAO();
        List<User> list = udao.getAllUsers();
        list.forEach(System.out::println);
    }
}
