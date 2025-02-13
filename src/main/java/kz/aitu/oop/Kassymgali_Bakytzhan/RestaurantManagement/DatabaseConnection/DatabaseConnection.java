package kz.aitu.oop.Kassymgali_Bakytzhan.RestaurantManagement.DatabaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/restaurant_db";
    private static final String USER = "postgres";
    private static final String PASSWORD = "MasterKeyForSql";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.err.println("⛔ Ошибка подключения к БД: " + e.getMessage());
            return null;
        }
    }
}
