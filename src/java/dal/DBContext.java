package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContext {
    protected static Connection connection;
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=motel2"; // Cấu trúc URL cho SQL Server
    private static final String USER = "sa"; // Người dùng SQL Server
    private static final String PASSWORD = "123"; // Mật khẩu của bạn

    static {
        try {
            // Tải driver cho SQL Server
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        connection = DriverManager.getConnection(URL, USER, PASSWORD);
        return connection;
        
    }

    public static void main(String[] args) throws SQLException {
        Connection con = getConnection();
        System.out.println("Connection successful: " + con);
    }
}



//public class DBContext {
//
//    protected Connection connection;
//
//    public DBContext() {
//        try {
//            // Edit URL , username, password to authenticate with your MS SQL Server
//            String url = "jdbc:sqlserver://localhost:1433;databaseName=motel2";
//            String username = "sa";
//            String password = "123";
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            connection = DriverManager.getConnection(url, username, password);
//        } catch (ClassNotFoundException | SQLException ex) {
//            System.out.println(ex);
//        }
//    }
//}
