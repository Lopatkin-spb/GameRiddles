
/*

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreateBD {

    // Блок объявления констант
    public static final String DB_URL = "jdbc:h2:/C:\\Users\\Denis\\IdeaProjects\\GameRiddles\\dbdatabaseUsers";
    public static final String DB_Driver = "org.h2.Driver";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
            //inicializacia bd i ee drivera
            Class.forName(DB_Driver);
            //ystanovka soedinenia
            System.out.println("connekting to db...");
            connection = DriverManager.getConnection(DB_URL);
            //sozdanie zaiavlania na sozdanie table
            System.out.println("creating table is given db...");
            statement = connection.createStatement();
            String sql = String.format("CREATE TABLE USERS (id integer AUTO_INCREMENT PRIMARY KEY NOT NULL, user varchar(255) NOT NULL, sumTry integer NOT NULL, win  integer NOT NULL, hint integer NOT NULL, flawlessWin integer NOT NULL)");
            statement.executeUpdate(sql);
            System.out.println("create table is db...");
//owibki v jdbc
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        System.out.println("goodbye!");
    }
}

 */