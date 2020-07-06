package com.game.DOMAIN;

import com.game.DAO.SavesDAO;
import com.game.DAO.StatisticsDAO;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class ModelTableSave extends AbstractTableModel {


    private List<Save> savesList = new ArrayList();
    private SavesDAO dao = new SavesDAO();

    private int columnCount = 5;

    public ModelTableSave() {
        //при подключении модели в УИ автоматически
        // всключается конструктор с действием показать БД
        savesList = dao.getAllSaves();
    }



    @Override
    public int getRowCount() {
        return savesList.size();
    }

    @Override
    public int getColumnCount() {
        return columnCount;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Save save = savesList.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return save.getUserId();
            case 1:
                return save.getLogin();
            case 2:
                return save.getEasyRiddles();
            case 3:
                return save.getNormalRiddles();
            case 4:
                return save.getHardRiddles();
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
                return "Имя";
            case 2:
                return "легкие згдки";
            case 3:
                return "средние згдки";
            case 4:
                return "сложные згдки";
            default:
                return "";
        }
    }


    public void insertTableBd(Save sv) {
        sv = dao.insertDataSave(sv);
        //пока обновление через гетоллстат. потому что через адд непонятно айди как норм ставить...
        //statisticsList.add(s);
        savesList = dao.getAllSaves();
        //fireTableChanged(s);
        fireTableRowsInserted(savesList.size(), savesList.size());
    }

    public void updateTableBd(Save userProgress) {
        dao.updateBd(userProgress);
        savesList = dao.getAllSaves();
        //fireTableDataChanged(statisticsList());
    }


    //СКОРЕЕ ВСЕГО ПЕРЕПУТАН метод файр, доработать надо!!
    //public void udalit(Statisticas statistica) {
    public void udalit() {
       // dao.deleteOneRow();
        savesList = dao.getAllSaves();
        //statisticsList.remove(statistica);
        //fireTableRowsInserted(statisticsList.size() - 1, statisticsList.size() - 1);
    }


}
