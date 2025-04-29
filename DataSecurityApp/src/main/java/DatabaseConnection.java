import java.sql.*;

public class DatabaseConnection {
    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/secure_storage", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}