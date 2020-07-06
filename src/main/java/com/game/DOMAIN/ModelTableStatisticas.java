
package com.game.DOMAIN;

import com.game.DAO.StatisticsDAO;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class ModelTableStatisticas extends AbstractTableModel {

    private List<Statisticas> statisticsList = new ArrayList();
    private StatisticsDAO dao = new StatisticsDAO();

    //столбцов сделал на один меньше (6) - чтобы последний столбец не высвечивался
    private int columnCount = 6;

    public ModelTableStatisticas() {
        //при подключении модели в УИ автоматически
        // всключается конструктор с действием показать БД
        statisticsList = dao.getAllStatistics();
    }

    @Override
    public int getRowCount() {
        return statisticsList.size();
    }

    @Override
    public int getColumnCount() {
        return columnCount;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Statisticas statistica = statisticsList.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return statistica.getStatisticasId();
            case 1:
                return statistica.getLogin();
            case 2:
                return statistica.getSumTry();
            case 3:
                return statistica.getWin();
            case 4:
                return statistica.getHint();
            case 5:
                return statistica.getFlawlessWin();
            case 6:
                return statistica.getUserId();
            default:
                return "";
        }
    }

    //задаем колонки названия
    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "statisticasId";
            case 1:
                return "Имя";
            case 2:
                return "Попытки";
            case 3:
                return "Победы";
            case 4:
                return "Подсказки";
            case 5:
                return "Отл победы";
            case 6:
                return "userId";
            default:
                return "";
        }
    }

    //у сакурая тут связь с маус лисенером и с таблицей
   // public Statisticas getStatisticas() {
   //     return statisticsList.get();
   // }

    public void insertTableBd(Statisticas s) {
        s = dao.insertBd(s);
        //пока обновление через гетоллстат. потому что через адд непонятно айди как норм ставить...
        //statisticsList.add(s);
       statisticsList = dao.getAllStatistics();
        //fireTableChanged(s);
        fireTableRowsInserted(statisticsList.size(), statisticsList.size());
    }

    public void updateTableBd(Statisticas userStatistics) {
        dao.updateBd(userStatistics);
        statisticsList = dao.getAllStatistics();
        //fireTableDataChanged(statisticsList());
    }

    //СКОРЕЕ ВСЕГО ПЕРЕПУТАН метод файр, доработать надо!!
    //public void udalit(Statisticas statistica) {
    public void udalit() {
        dao.deleteOneRow();
        statisticsList = dao.getAllStatistics();
        //statisticsList.remove(statistica);
        //fireTableRowsInserted(statisticsList.size() - 1, statisticsList.size() - 1);
    }


/*    //получаем запись определенной ячейки в табл. прописать gdeto(.getValueAt(1,2));
    public Object getValueAt(int rowIndex, int columnIndex) {
        String[] rows = dataArrayList.get(rowIndex);
        return rows[columnIndex];
    }

 */

    //метод записи одной строки в таблицу и  рповерки на колво столбцов
 /*   public void addDate(String[] row) {
        //convertToString();
        String[] rowTable = new String[getColumnCount()];
        rowTable = row;
        dataArrayList.add(rowTable);
        //System.out.println(" table model data "+ rowTable);
    }

  */


}

/*
    Object[] columnsName = new Object[6];
    columnsName[0]="id";
            columnsName[1]="login";
            columnsName[2]="sumTry";
            columnsName[3]="win";
            columnsName[4]="hint";
            columnsName[5]="flawlessWin";
            defaultTableModel.setColumnIdentifiers(columnsName);


private int columnCount=6;
private ArrayList<String[]>dataArrayList;

//создание таблицы
public TableModel(){
        dataArrayList=new ArrayList<String[]>();
        for(int i=0;i<dataArrayList.size();i++){
        dataArrayList.add(new String[getColumnCount()]);
        }
        //System.out.println(dataArrayList);

        String[]row=new String[6];
        row[0]="2";
        row[1]="ffgg";
        row[2]="jj";
        row[3]="7";
        row[4]="999";
        row[5]=";";
        addDate(row);


        }


@Override
public int getRowCount(){
        return dataArrayList.size();
        }

@Override
public int getColumnCount(){
        return columnCount;
        }

//задаем колонки названия
@Override
public String getColumnName(int columnIndex){
        switch(columnIndex){
        case 0:
        return"id";
        case 1:
        return"login";
        case 2:
        return"sumTry";
        case 3:
        return"win";
        case 4:
        return"hint";
        case 5:
        return"flawlessWin";
        }
        return"";
        }


//получаем запись определенной ячейки в табл. прописать gdeto(.getValueAt(1,2));
public Object getValueAt(int rowIndex,int columnIndex){
        String[]rows=dataArrayList.get(rowIndex);
        return rows[columnIndex];
        }


//метод записи одной строки в таблицу и  рповерки на колво столбцов
public void addDate(String[]row){
        //convertToString();
        String[]rowTable=new String[getColumnCount()];
        rowTable=row;
        dataArrayList.add(rowTable);
        //System.out.println(rowTable);
        }


    public String[] convertToString() {
        Statistica statistica = new Statistica();
        String strId = String.valueOf(statistica.getId());
        String strLogin = statistica.getLogin();
        String strSumTry = String.valueOf(statistica.getSumTry());
        String strWin = String.valueOf(statistica.getWin());
        String strHint = String.valueOf(statistica.getHint());
        String strFlawlessWin = String.valueOf(statistica.getFlawlessWin());

        String[] row = {strId, strLogin, strSumTry, strWin, strHint, strFlawlessWin};
        return row;
    }


 */






