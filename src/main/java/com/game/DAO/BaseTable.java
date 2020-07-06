package com.game.DAO;

//import com.game.UI.DataBase;

/*
// Сервисный родительский класс, куда вынесена реализация общих действий для всех таблиц
public class BaseTable implements Closeable {
    Connection connection;  // JDBC-соединение для работы с таблицей
    String tableName;       // Имя таблицы
    //DataBase dataBase = new DataBase();

    BaseTable(String tableName) throws SQLException { // Для реальной таблицы передадим
        // в конструктор её имя
        this.tableName = tableName;
        this.connection = DataBase.getConnection(); // Установим соединение с СУБД
        // для дальнейшей работы
    }

    // Закрытие
    public void close() {
        try {
            if (connection != null && !connection.isClosed())
                connection.close();
        } catch (SQLException e) {
            System.out.println("Ошибка закрытия SQL соединения!");
        }
    }

    void executeSqlStatement(String sql) throws SQLException {
        executeSqlStatement(sql, null);
    };


    // Выполнить SQL команду без параметров в СУБД, по завершению выдать сообщение в консоль
    void executeSqlStatement(String sql, String description) throws SQLException {
        reopenConnection(); // переоткрываем (если оно неактивно) соединение с СУБД
        Statement statement = connection.createStatement();  // Создаем statement для
        // выполнения sql-команд
        statement.execute(sql); // Выполняем statement - sql команду
        statement.close();      // Закрываем statement для фиксации изменений в СУБД
        if (description != null)
            System.out.println(description);
    };


    // Активизация соединения с СУБД, если оно не активно.
    void reopenConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DataBase.getConnection();
        }
    }

    void sqlStatement(){
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            //inicializacia bd i ee drivera
            Class.forName(DB_Driver);
            //ystanovka soedinenia
            connection = DriverManager.getConnection(DB_URL);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if (connection != null) {
                resultSet.close();
                statement.close();
                connection.close();
            }
            catch (SQLException e) {

            }
        }
    }

//}


 */