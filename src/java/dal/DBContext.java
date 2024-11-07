package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContext {
<<<<<<< HEAD
=======
    protected static Connection connection;
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=motel2"; // Cấu trúc URL cho SQL Server
    private static final String USER = "sa"; // Người dùng SQL Server
    private static final String PASSWORD = "123"; // Mật khẩu của bạn
<<<<<<< HEAD
>>>>>>> origin/Hung
=======
>>>>>>> origin/QuangAnh267

    protected static Connection connection;

    public DBContext() {
        try {
            // Edit URL , username, password to authenticate with your MS SQL Server
            String url = "jdbc:sqlserver://DESKTOP-I6VFEV7\\LOCALHOST:1433;databaseName=motel4";
            String username = "sa";
            String password = "sa";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
    }
<<<<<<< HEAD
    
    public static Connection getConnection() {
         try {
            // Edit URL , username, password to authenticate with your MS SQL Server
            String url = "jdbc:sqlserver://localhost:1433;databaseName=motel";
            String username = "sa";
            String password = "sa";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
         return connection;
=======

    public static Connection getConnection() throws SQLException {
        connection = DriverManager.getConnection(URL, USER, PASSWORD);
        return connection;
        
    }

    public static void main(String[] args) throws SQLException {
        Connection con = getConnection();
        System.out.println("Connection successful: " + con);
>>>>>>> origin/Hung
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
