package com.game.DOMAIN;

import com.game.DAO.UsersDAO;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class ModelTableUser extends AbstractTableModel {

    private List<User> userList = new ArrayList();
    private UsersDAO dao = new UsersDAO();

    private int columnCount = 3;


    public ModelTableUser() {
        //при подключении модели в УИ автоматически
        // всключается конструктор с действием показать БД
       userList = dao.getAllUsers();
    }

    @Override
    public int getRowCount() {
        return userList.size();
    }

    @Override
    public int getColumnCount() {
        return columnCount;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        User u = userList.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return u.getUserId();
            case 1:
                return u.getLogin();
            case 2:
                return u.getPassword();
                default:
                return "";
        }
    }


    //задаем колонки названия
    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "userId";
            case 1:
                return "Никнейм";
            case 2:
                return "Пароль";

            default:
                return "";
        }
    }


    public void insertTableBd(User u) {
        //u = dao.insertDataUser(u);
        dao.insertDataUser(u);
        //пока обновление через гетоллстат. потому что через адд непонятно айди как норм ставить...
        //statisticsList.add(s);
        userList = dao.getAllUsers();
        //fireTableChanged(s);
        fireTableRowsInserted(userList.size(), userList.size());
    }



}
