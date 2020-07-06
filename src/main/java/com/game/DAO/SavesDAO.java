package com.game.DAO;

import com.game.DOMAIN.Save;
import com.game.DOMAIN.Statisticas;
import com.game.DOMAIN.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SavesDAO {



        //вставка по сакураю
        public Save insertDataSave(Save sv) {

            String sqlId = "SELECT statistics_seq.nextval AS id FROM DUAL";
            String sqlInsertDataSave = "INSERT INTO saves " +
                    "(userId, login, easyRiddles, normalRiddles, hardRiddles) " +
                    "VALUES (?, ?, ?, ?, ?)";
            ConnectionConfiguration connectConfiguration = new ConnectionConfiguration();
            Connection connection = null;
            PreparedStatement pStatement = null;
            try {
                connection = connectConfiguration.getConnection();
                //sozdanie zaiavlania na sozdanie table
                pStatement = connection.prepareStatement(sqlInsertDataSave);
                //pStatement.setInt(1);
                pStatement.setInt(1, sv.getUserId());
                pStatement.setString(2, sv.getLogin());
                pStatement.setString(3, sv.getEasyRiddles());
                pStatement.setString(4, sv.getNormalRiddles());
                pStatement.setString(5, sv.getHardRiddles());
                pStatement.execute();
                System.out.println("insert saves прошла удачно"); //test
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
            return sv;
            //return u;
        }


        public List<Save> getAllSaves() {

            String sqlReadAllRow = "SELECT * FROM saves";
            //на будущее можно сделать еще и сортировку авто
            String sqlReadAllRowOrderBy = "SELECT * FROM statistics ORDER BY login";
            ConnectionConfiguration connectConfiguration = new ConnectionConfiguration();
            Connection connection = null;
            PreparedStatement pStatement = null;
            ResultSet result = null;
            List<Save> saveList = new ArrayList();
            try {
                //sozdanie zaiavlania
                connection = connectConfiguration.getConnection();
                pStatement = connection.prepareStatement(sqlReadAllRow);
                result = pStatement.executeQuery();
                while (result.next()) {
                    Save s = new Save(
                            result.getInt("userId"),
                            result.getString("login"),
                            result.getString("easyRiddles"),
                            result.getString("normalRiddles"),
                            result.getString("hardRiddles")
                    );
                    saveList.add(s);
                    System.out.println("SELECT * FROM saves"); //test
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
            return saveList;
        }


        //доделать внимательно!!!
        public Save getSelectOneRow(Save s) {

            //String sqlTest = "SELECT login FROM statistics";
            String sqlSelectRow = "SELECT * FROM users WHERE login = ?";
            String sqlSelectOneRow =
                    "SELECT userId, login, easyRiddles, normalRiddles, hardRiddles " +
                            "FROM saves WHERE userId = ?";
            ConnectionConfiguration connectConfiguration = new ConnectionConfiguration();
            Connection connection = null;
            PreparedStatement pStatement = null;
            ResultSet result = null;
            //User uIdLogPass = new User();
            try {
                connection = connectConfiguration.getConnection();
                pStatement = connection.prepareStatement(sqlSelectOneRow);
                pStatement.setInt(1, s.getUserId());
                result = pStatement.executeQuery();
                while (result.next()) {
                    s.setUserId(result.getInt("userId"));
                    s.setLogin(result.getString("login"));
                    s.setEasyRiddles(result.getString("easyRiddles"));
                    s.setNormalRiddles(result.getString("normalRiddles"));
                    s.setHardRiddles(result.getString("hardRiddles"));

                    // u.setStatisticas_id(result.getInt("statisticas_id"));
                    System.out.println("getSelectOneRow выбрали строку с сейвами = " +
                            " userId-" + result.getInt("userId") +
                            " login-" + result.getString("login") +
                            " easyRiddles-" + result.getString("easyRiddles") +
                            " normalRiddles-" + result.getString("normalRiddles") +
                            " hardRiddles-" + result.getString("hardRiddles")
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
            return s;
        }


    public void updateBd(Save userProgress) {
        String sqlUpdate = "UPDATE saves SET easyRiddles = ?, normalRiddles = ?, hardRiddles = ? WHERE userId = ?";
        ConnectionConfiguration connectConfiguration = new ConnectionConfiguration();
        Connection connection = null;
        PreparedStatement pStatement = null;
        try {
            connection = connectConfiguration.getConnection();
            //sozdanie zaiavlania
            pStatement = connection.prepareStatement(sqlUpdate);
            //pStatement.setInt(1);
            pStatement.setString(1, userProgress.getEasyRiddles());
            pStatement.setString(2, userProgress.getNormalRiddles());
            pStatement.setString(3, userProgress.getHardRiddles());
            pStatement.setInt(4, userProgress.getUserId());
            pStatement.executeUpdate();
            System.out.println("update прошла удачно");
            System.out.println("UPDATE saves SET easyRiddles = " + userProgress.getEasyRiddles() +
                    " , normalRiddles = " + userProgress.getNormalRiddles() +
                    ", hardRiddles = " + userProgress.getHardRiddles() +
                    " WHERE userId = " + userProgress.getUserId()); //test
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
                    System.out.println("disconnection");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //return s;
    }



/*
        //доделать!!! внимательно
        public void deleteRowSaves() {

            String sqlDeleteOneRow = "DELETE FROM saves";
            //String sqlDeleteAllRow = "DELETE FROM users WHERE id > 0";
            ConnectionConfiguration connectionConfiguration = new ConnectionConfiguration();
            Connection connection = null;
            Statement statement = null;
            try {
                //ystanovka soedinenia
                connection = connectionConfiguration.getConnection();
                //sozdanie zaiavlania na sozdanie table
                statement = connection.createStatement();
                statement.executeUpdate(sqlDeleteOneRow);
                System.out.println("удаление троки SAVES прошло удачно. пользователь ");
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

 */




        //Н2 надо создать один раз для появления файла бд
        public void createTableSaves() {

            //секвенс - продвинутый первичный ключ. пока без него
            String sqlSeq =
                    "CREATE SEQUENCE statistics_seq INCREMENT BY 1 START WITH 1 NOCACHE NOCYCLE";
            String sqlCreateTableSaves = "CREATE TABLE saves " +
                    "(userId BIGINT NOT NULL, " +
                    "login VARCHAR(255) NOT NULL, " +
                    "easyRiddles VARCHAR(255) NOT NULL, " +
                    "normalRiddles VARCHAR(255) NOT NULL, " +
                    "hardRiddles VARCHAR(255) NOT NULL, " +
                    "FOREIGN KEY (userId) REFERENCES users (userId)" +
                    ")";
            //метод jtest.ru
            ConnectionConfiguration connectConfiguration = new ConnectionConfiguration();
            Connection connection = null;
            Statement statement = null;
            try {
                connection = connectConfiguration.getConnection();
                //sozdanie zaiavlania na sozdanie table
                statement = connection.createStatement();
                statement.executeUpdate(sqlCreateTableSaves);
                System.out.println("таблица SAVES создана");  //test
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


        public void deleteTableSaves() {

            String sqlDeleteTableSaves = " DROP TABLE saves";
            //ПОСМОТреть - можно удалить каскадно все связанное с таблицей
            ConnectionConfiguration connectConfiguration = new ConnectionConfiguration();
            Connection connection = null;
            Statement statement = null;
            try {
                connection = connectConfiguration.getConnection();
                //sozdanie zaiavlania na sozdanie table
                statement = connection.createStatement();
                statement.executeUpdate(sqlDeleteTableSaves);
                System.out.println("таблица SAVES удалена");  //test
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





