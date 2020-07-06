package com.game.DAO;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class ConnectionConfiguration {

    // Блок объявления констант
    private static String DB_Driver = "org.h2.Driver";
    private static String DB_URL =
            "jdbc:h2:/C:/Users/Denis/IdeaProjects/GameRiddles/src/main/resources/databaseStatistics";

    public Connection getConnection() {
        Connection connection = null;
        try {
            //inicializacia bd - ee drivera
            Class.forName(DB_Driver);
            //ystanovka soedinenia
            connection = DriverManager.getConnection(DB_URL);
            System.out.println("connection");
            //owibki драйвера и соединения
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return connection;
    }
}
