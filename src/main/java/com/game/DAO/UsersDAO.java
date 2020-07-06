package com.game.DAO;


import com.game.DOMAIN.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UsersDAO {


    //вставка по сакураю
    public void insertDataUser(User u) {

        String sqlId = "SELECT statistics_seq.nextval AS id FROM DUAL";
        String sqlInsertDataUser = "INSERT INTO users " +
                "(userId, login, password) " +
                "VALUES (DEFAULT, ? ,?)";
        ConnectionConfiguration connectConfiguration = new ConnectionConfiguration();
        Connection connection = null;
        PreparedStatement pStatement = null;
        try {
            connection = connectConfiguration.getConnection();
            //sozdanie zaiavlania na sozdanie table
            pStatement = connection.prepareStatement(sqlInsertDataUser);
            //pStatement.setInt(1);
            pStatement.setString(1, u.getLogin());
            pStatement.setString(2, u.getPassword());
            pStatement.execute();
            System.out.println("insert users прошла удачно"); //test
            System.out.println(toString()); //test
//owibki v jdbc
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pStatement != null) {
                    pStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (connection != null) {
                    connection.close();
                    System.out.println("disconnection"); //test
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //return u;
        //return u;
    }


    public List<User> getAllUsers() {

        String sqlReadAllRow = "SELECT * FROM users";
        //на будущее можно сделать еще и сортировку авто
        String sqlReadAllRowOrderBy = "SELECT * FROM statistics ORDER BY login";
        ConnectionConfiguration connectConfiguration = new ConnectionConfiguration();
        Connection connection = null;
        PreparedStatement pStatement = null;
        ResultSet result = null;
        List<User> userList = new ArrayList();
        try {
            //sozdanie zaiavlania
            connection = connectConfiguration.getConnection();
            pStatement = connection.prepareStatement(sqlReadAllRow);
            result = pStatement.executeQuery();
            while (result.next()) {
                User u = new User(
                        result.getInt("userId"),
                        result.getString("login"),
                        result.getString("password"));
                userList.add(u);
                System.out.println("SELECT * FROM users"); //test
            }
            //ошибки стайтмента
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (result != null) {
                    result.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (pStatement != null) {
                    pStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (connection != null) {
                    connection.close();
                    System.out.println("disconnection");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return userList;
    }


    //доделать внимательно!!!
    public User getSelectOneRow(User u) {

        //String sqlTest = "SELECT login FROM statistics";
        String sqlSelectRow = "SELECT * FROM users WHERE login = ?";
        String sqlSelectOneRow = "SELECT userId, login, password FROM users WHERE login = ? AND password = ?";
        ConnectionConfiguration connectConfiguration = new ConnectionConfiguration();
        Connection connection = null;
        PreparedStatement pStatement = null;
        ResultSet result = null;
        //User uIdLogPass = new User();
        try {
            connection = connectConfiguration.getConnection();
            pStatement = connection.prepareStatement(sqlSelectOneRow);
            pStatement.setString(1, u.getLogin());
            pStatement.setString(2, u.getPassword());
            result = pStatement.executeQuery();
            while (result.next()) {
                u.setUserId(result.getInt("userId"));
                u.setLogin(result.getString("login"));
                u.setPassword(result.getString("password"));

                // u.setStatisticas_id(result.getInt("statisticas_id"));
                System.out.println("getSelectOneRow выбрали строку с логин и пассвордом = " +
                        " id-" + result.getInt("userId") +
                        " login-" + result.getString("login") +
                        " pass-" + result.getString("password")
                );  //test
            }
            //owibki v jdbc
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (result != null) {
                    result.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (pStatement != null) {
                    pStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (connection != null) {
                    connection.close();
                    System.out.println("disconnection getSelectOneRow");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //return uIdLogPass;
        return u;
    }


    //доделать!!! внимательно
    public void deleteRowUsers() {

        String sqlDeleteOneRow = "DELETE FROM users";
        String sqlDeleteAllRow = "DELETE FROM users WHERE id > 0";
        ConnectionConfiguration connectionConfiguration = new ConnectionConfiguration();
        Connection connection = null;
        Statement statement = null;
        try {
            //ystanovka soedinenia
            connection = connectionConfiguration.getConnection();
            //sozdanie zaiavlania na sozdanie table
            statement = connection.createStatement();
            statement.executeUpdate(sqlDeleteOneRow);
            System.out.println("удаление прошла удачно пользователь");
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
    }


    //поиск в БД на наличие имени; результат или нулл
    public String searchLogin(String loginViewUi) {

        //String sqlTest = "SELECT login FROM statistics";
        String sqlSelectName = "SELECT * FROM users WHERE login = ?";
        ConnectionConfiguration connectConfiguration = new ConnectionConfiguration();
        Connection connection = null;
        PreparedStatement pStatement = null;
        ResultSet result = null;
        String s = null;
        try {
            connection = connectConfiguration.getConnection();
            pStatement = connection.prepareStatement(sqlSelectName);
            //result = pStatement.executeQuery();
            //while (result.next()) {
            //String login = result.getString("login");
            pStatement.setString(1, loginViewUi);
            //pStatement.execute();
            result = pStatement.executeQuery();
            while (result.next()) {
                s = result.getString("login");
                System.out.println("dao users/ login = " + s); //test

            }
//owibki v jdbc
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (result != null) {
                    result.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (pStatement != null) {
                    pStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (connection != null) {
                    connection.close();
                    System.out.println("disconnection searchLogin");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return s;
    }


    //Н2 надо создать один раз для появления файла бд
    public void createTableUsers() {

        //секвенс - продвинутый первичный ключ. пока без него
        String sqlSeq =
                "CREATE SEQUENCE statistics_seq INCREMENT BY 1 START WITH 1 NOCACHE NOCYCLE";
        String sqlCreateTableUsers = "CREATE TABLE users " +
                "(userId BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                "login VARCHAR(255) NOT NULL, " +
                "password VARCHAR(255) NOT NULL" +
                ")";
        //метод jtest.ru
        String sqlCreateTableUsers2 = "CREATE TABLE users " +
                "(user_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                "login VARCHAR(255) NOT NULL, " +
                "password VARCHAR(255) NOT NULL," +
                "statistics_id BIGINT," +
                "FOREIGN KEY (statistics_id) REFERENCES statistics (statistics_id)" +
                ")";
        //users FOREIGN KEY (id) REFERENCES statistics (id)
        ConnectionConfiguration connectConfiguration = new ConnectionConfiguration();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = connectConfiguration.getConnection();
            //sozdanie zaiavlania na sozdanie table
            statement = connection.createStatement();
            statement.executeUpdate(sqlCreateTableUsers);
            System.out.println("таблица USERS создана");  //test
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
                    System.out.println("disconnection"); //test
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public void deleteTableUsers() {

        String sqlDeleteTableUsers = " DROP TABLE users";
        //ПОСМОТреть - можно удалить каскадно все связанное с таблицей
        ConnectionConfiguration connectConfiguration = new ConnectionConfiguration();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = connectConfiguration.getConnection();
            //sozdanie zaiavlania na sozdanie table
            statement = connection.createStatement();
            statement.executeUpdate(sqlDeleteTableUsers);
            System.out.println("таблица USERS удалена");  //test
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
                    System.out.println("disconnection"); //test
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}
