package database;

import java.sql.*;
public class database {
    public static String DB_URL = "jdbc:mysql://localhost:3306/database_pharmacy";
    public static String USER_NAME = "root";
    public static String PASSWORD = "";
    public static Connection conn;

    public static Connection getConnection(String dbUrl, String userName, String password) {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(dbUrl, userName, password);
            System.out.println("connect successfully");
        } catch (Exception ex) {
            System.out.println("connect failure");
            ex.printStackTrace();
        }
        return conn;
    }


}
