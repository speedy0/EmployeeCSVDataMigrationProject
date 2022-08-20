package com.sparta.coldplay.sql;
import com.sparta.coldplay.logger.LoggerSystem;
import com.sparta.coldplay.utils.PropertiesLoader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static Connection postgresCon;
    public static Connection connectionToDB(){
        String url = PropertiesLoader.getProperty("url");
        String userName = PropertiesLoader.getProperty("userName");
        String password = PropertiesLoader.getProperty("password");
        try {
            postgresCon = DriverManager.getConnection(url, userName, password);
            LoggerSystem.getMessage(1, "Connected to the database.");
            //postgresCon.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
            LoggerSystem.getMessage(3, e.getMessage());
        }
        return postgresCon;
    }

    public static void closeConnection(){
        try {
            postgresCon.close();
            LoggerSystem.getMessage(1, "Database closed.");
        } catch (SQLException e) {
            e.printStackTrace();
            LoggerSystem.getMessage(3, e.getMessage());
        }
    }
}



