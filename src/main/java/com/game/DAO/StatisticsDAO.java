package com.game.DAO;

//import com.game.DOMAIN.TableModel;

import com.game.DOMAIN.Statisticas;
//import com.game.DOMAIN.TableModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class StatisticsDAO {



    //вставка по сакураю
    public Statisticas insertBd(Statisticas s) {

        String sqlId = "SELECT statistics_seq.nextval AS id FROM DUAL";
        String sqlInsertStatistics = "INSERT INTO statistics " +
                "(statisticasId, login, sumTry, win, hint, flawlessWin, userId) " +
                "VALUES (DEFAULT, ? ,? ,? ,? ,?, ?)";
        ConnectionConfiguration connectConfiguration = new ConnectionConfiguration();
        Connection connection = null;
        PreparedStatement pStatement = null;
        try {
            connection = connectConfiguration.getConnection();
            // int id = 0;
            //PreparedStatement pStatId = connection.prepareStatement(sqlId);
            //ResultSet resultSetId = pStatId.executeQuery();
            // if (resultSetId.next()) {
            //     id = resultSetId.getInt("id");
            // }

            //sozdanie zaiavlania na sozdanie table
            pStatement = connection.prepareStatement(sqlInsertStatistics);
            //pStatement.setInt(1);
            pStatement.setString(1, s.getLogin());
            pStatement.setInt(2, s.getSumTry());
            pStatement.setInt(3, s.getWin());
            pStatement.setInt(4, s.getHint());
            pStatement.setInt(5, s.getFlawlessWin());
            pStatement.setInt(6, s.getUserId());
            //String sql = "INSERT INTO USERS VALUES (userNameTable, 0,0,0,0)";
            pStatement.execute();
            System.out.println("insert statistics прошла удачно"); //test
            System.out.println(toString()); //test
            //s.setId(id);
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
        return s;
    }









    //способ сакурая
    public List<Statisticas> getAllStatistics() {
        String sqlReadAllRow = "SELECT * FROM statistics";
        //на будущее можно сделать еще и сортировку авто
        String sqlReadAllRowOrderBy = "SELECT * FROM statistics ORDER BY login";

        ConnectionConfiguration connectConfiguration = new ConnectionConfiguration();
        Connection connection = null;
        PreparedStatement pStatement = null;
        ResultSet result = null;

        List<Statisticas> statList = new ArrayList();
        try {
            //sozdanie zaiavlania
            connection = connectConfiguration.getConnection();
            pStatement = connection.prepareStatement(sqlReadAllRow);
            result = pStatement.executeQuery();
            while (result.next()) {
                Statisticas s = new Statisticas(
                        result.getInt("statisticasId"),
                        result.getString("login"),
                        result.getInt("sumTry"),
                        result.getInt("win"),
                        result.getInt("hint"),
                        result.getInt("flawlessWin"),
                        result.getInt("userId")
                );
                statList.add(s);
                System.out.println("SELECT * FROM statistics");
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
        return statList;
    }


    public Statisticas getSelectOneRow2(Statisticas s) {
        //String sqlTest = "SELECT login FROM statistics";
        String sqlSelectRow = "SELECT * FROM statistics WHERE login = ?";
        String sqlSelectRowTest =
                "SELECT statisticasId, login, sumTry, win, hint, " +
                        "flawlessWin, userId FROM statistics WHERE userId = ?";
        //String sqlSelectRowTest = "SELECT id, login, sumTry, win, hint, flawlessWin FROM statistics WHERE login = ?";
        ConnectionConfiguration connectConfiguration = new ConnectionConfiguration();
        Connection connection = null;
        PreparedStatement pStatement = null;
        ResultSet result = null;
        try {
            connection = connectConfiguration.getConnection();
            pStatement = connection.prepareStatement(sqlSelectRowTest);
            pStatement.setInt(1, s.getUserId());
            result = pStatement.executeQuery();
            while (result.next()) {
                s.setStatisticasId(result.getInt("statisticasId"));
                s.setLogin(result.getString("login"));
                s.setSumTry(result.getInt("sumTry"));
                s.setWin(result.getInt("win"));
                s.setHint(result.getInt("hint"));
                s.setFlawlessWin(result.getInt("flawlessWin"));
                s.setUserId(result.getInt("userId"));
                System.out.println("getSelectOneRow2 -> " + s); //test
                //pStatement.executeUpdate();
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
                    System.out.println("disconnection");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return s;
    }





    public Statisticas getSelectOneRow(String login) {
        //String sqlTest = "SELECT login FROM statistics";
        String sqlSelectRow = "SELECT * FROM statistics WHERE login = ?";
        String sqlSelectRowTest = "SELECT statisticas_id, login, hint, flawlessWin FROM statistics WHERE login = ?";
        //String sqlSelectRowTest = "SELECT id, login, sumTry, win, hint, flawlessWin FROM statistics WHERE login = ?";
        ConnectionConfiguration connectConfiguration = new ConnectionConfiguration();
        Connection connection = null;
        PreparedStatement pStatement = null;
        ResultSet result = null;
        Statisticas s = new Statisticas();
        //String s = null;
        try {
            connection = connectConfiguration.getConnection();
            pStatement = connection.prepareStatement(sqlSelectRowTest);
            //result = pStatement.executeQuery();
            //while (result.next()) {
            //String login = result.getString("login");
            pStatement.setString(1, login);
            //pStatement.execute();
            result = pStatement.executeQuery();


            while (result.next()) {
                s.setStatisticasId(result.getInt("statisticas_id"));
                s.setLogin(result.getString("login"));
                s.setSumTry(result.getInt("sumTry"));
                //s.setWin(result.getInt("win"));
                //s.setHint(result.getInt("hint"));
                s.setFlawlessWin(result.getInt("flawlessWin"));
                System.out.println(s);
                //TestMenu testMenu = new TestMenu();
                //pStatement.executeUpdate();
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
                    System.out.println("disconnection");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //return s;
        return s;
    }





    public void updateBd(Statisticas userStatistics) {
        String sqlUpdate = "UPDATE statistics SET sumTry = ?, win = ?, hint = ?, flawlessWin = ? WHERE userId = ?";
        ConnectionConfiguration connectConfiguration = new ConnectionConfiguration();
        Connection connection = null;
        PreparedStatement pStatement = null;
        try {
            connection = connectConfiguration.getConnection();
            //sozdanie zaiavlania
            pStatement = connection.prepareStatement(sqlUpdate);
            //pStatement.setInt(1);
            pStatement.setInt(1, userStatistics.getSumTry());
            pStatement.setInt(2, userStatistics.getWin());
            pStatement.setInt(3, userStatistics.getHint());
            pStatement.setInt(4, userStatistics.getFlawlessWin());
            pStatement.setInt(5, userStatistics.getUserId());
            pStatement.executeUpdate();
            System.out.println("update прошла удачно");
            System.out.println("UPDATE statistics SET sumTry = " + userStatistics.getSumTry() + " , win = " + userStatistics.getWin() +
                    ", hint = " + userStatistics.getHint() + ", flawlessWin = " + userStatistics.getFlawlessWin() +
                    " WHERE userId = " + userStatistics.getUserId()); //test
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

    public void insert(String login) {
        String sqlInsert = "INSERT INTO statistics (login, sumTry, win, hint, flawlessWin) " +
                "VALUES (? ,? ,? ,? ,?)";
        ConnectionConfiguration connectConfiguration = new ConnectionConfiguration();
        Connection connection = null;
        PreparedStatement pStatement = null;
        try {
            //ystanovka soedinenia
            connection = connectConfiguration.getConnection();
            //sozdanie zaiavlania na sozdanie table
            pStatement = connection.prepareStatement(sqlInsert);
            pStatement.setString(1, login);
            pStatement.setString(2, "0");
            pStatement.setString(3, "0");
            pStatement.setString(4, "0");
            pStatement.setString(5, "0");
            //String sql = "INSERT INTO USERS VALUES (userNameTable, 0,0,0,0)";
            pStatement.executeUpdate();
            System.out.println("запись прошла удачно пользователь " + login);
//owibki v jdbc
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
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
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

 */


  /*  public void readAllRow() {
        String sqlReadAllRow = "SELECT * FROM statistics";
        ConnectionConfiguration connectionConfiguration = new ConnectionConfiguration();
        Connection connection = null;
        Statement statement = null;
        ResultSet result = null;
        try {
            //inicializacia bd i ee drivera
            //ystanovka soedinenia
            connection = connectionConfiguration.getConnection();
            //sozdanie zaiavlania na sozdanie table
            statement = connection.createStatement();
            result = statement.executeQuery(sqlReadAllRow);
            while (result.next()) {
                String[] row = {
                        String.valueOf(result.getInt("id")),
                        result.getString("login"),
                        String.valueOf(result.getInt("sumTry")),
                        String.valueOf(result.getInt("win")),
                        String.valueOf(result.getInt("hint")),
                        String.valueOf(result.getInt("flawlessWin"))
                };
                //TableModel tableModel = new TableModel();
                //tableModel.addDate(row);

                //             st = new Statistica(
                //                      result.getInt("id"),
                //                      result.getString("login"),
                //                      result.getInt("sumTry"),
                //                      result.getInt("win"),
                //                      result.getInt("hint"),
                //                      result.getInt("flawlessWin"));
                //              statistica.add(st);
                //System.out.println(row);
            }
            //owibki v jdbc
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
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

 /*
//рабочий второй способ
    public ArrayList<Statistica> getAllStatistics() {
        String sqlReadAllRow = "SELECT * FROM statistics";

        Connection connection = null;
        Statement statement = null;
        ResultSet result = null;
        ArrayList<Statistica> statistica = new ArrayList<Statistica>();
        Statistica st;
        try {

            //inicializacia bd i ee drivera
            Class.forName(DB_Driver);
            //ystanovka soedinenia
            connection = DriverManager.getConnection(DB_URL);
            //sozdanie zaiavlania na sozdanie table
            statement = connection.createStatement();
            result = statement.executeQuery(sqlReadAllRow);
            while (result.next()) {
                st = new Statistica(
                        result.getInt("id"),
                        result.getString("login"),
                        result.getInt("sumTry"),
                        result.getInt("win"),
                        result.getInt("hint"),
                        result.getInt("flawlessWin"));
                statistica.add(st);

                //System.out.println(statistica);


            }


//owibki v jdbc
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
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
        return statistica;

        //statistica.
    }

  */


    public void deleteOneRow() {

        String sqlDeleteOneRow = "DELETE FROM statistics";
        //String sqlDeleteOneRow = "DELETE FROM statistics WHERE id > 0";
        ConnectionConfiguration connectionConfiguration = new ConnectionConfiguration();
        Connection connection = null;
        Statement statement = null;
        try {
            //inicializacia bd i ee drivera

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

    //возможно етот метод пойдет в дао таблицы с паролями
    public String selectName(String loginViewUi) {

        //String sqlTest = "SELECT login FROM statistics";
        String sqlSelectName = "SELECT * FROM statistics WHERE login = ?";
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
                System.out.println(s);
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
                    System.out.println("disconnection");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return s;
    }



    //Н2 надо создать один раз для появления файла бд
    public void createTable() {

        String sqlSeq =
                "CREATE SEQUENCE statistics_seq INCREMENT BY 1 START WITH 1 NOCACHE NOCYCLE";
        String sqlTableStatistics = "CREATE TABLE statistics " +
                "(statisticasId BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                "login VARCHAR(255) NOT NULL, " +
                "sumTry INTEGER NOT NULL, " +
                "win  INTEGER NOT NULL, " +
                "hint INTEGER NOT NULL, " +
                "flawlessWin INTEGER NOT NULL," +
                "userId BIGINT," +
                "FOREIGN KEY (userId) REFERENCES users (userId)" +
                ")";
        ConnectionConfiguration connectConfiguration = new ConnectionConfiguration();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = connectConfiguration.getConnection();
            //sozdanie zaiavlania na sozdanie table
            statement = connection.createStatement();
            statement.executeUpdate(sqlTableStatistics);
            System.out.println("таблица statistics создана"); //test
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




    public void deleteTableStatistics() {

        String sqlDeleteTableUsers = " DROP TABLE statistics";
        //ПОСМОТреть - можно удалить каскадно все связанное с таблицей
        ConnectionConfiguration connectConfiguration = new ConnectionConfiguration();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = connectConfiguration.getConnection();
            //sozdanie zaiavlania na sozdanie table
            statement = connection.createStatement();
            statement.executeUpdate(sqlDeleteTableUsers);
            System.out.println("таблица statistics удалена");  //test
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



    //Н2 надо создать один раз для появления файла секвенса
    public void createSequence() {
        String sqlSeq =
                "CREATE SEQUENCE statistics_seq INCREMENT BY 1 START WITH 1 NOCACHE NOCYCLE";
        ConnectionConfiguration connectConfiguration = new ConnectionConfiguration();
        Connection connection = null;
        PreparedStatement pStatement = null;
        try {
            connection = connectConfiguration.getConnection();
            //sozdanie zaiavlania na sozdanie table
            pStatement = connection.prepareStatement(sqlSeq);
            System.out.println("секвенса создана");
//owibki v jdbc
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
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
    }



}



