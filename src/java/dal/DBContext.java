package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContext {
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=motel3"; // Cấu trúc URL cho SQL Server
    private static final String USER = "sa"; // Người dùng SQL Server
    private static final String PASSWORD = "sa"; // Mật khẩu của bạn

    static {
        try {
            // Tải driver cho SQL Server
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void main(String[] args) throws SQLException {
        Connection con = getConnection();
        System.out.println("Connection successful: " + con);
    }
}
