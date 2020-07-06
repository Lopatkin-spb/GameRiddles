package com.game.DOMAIN;

public class Statisticas {


    private int statisticasId;           //уникальное число номер (не повторяется)
    private String login;        // Имя
    private int sumTry;     //  всего попыток
    private int win;     // отгадано
    private int hint;     // подсказок использовано
    private int flawlessWin;    // отгадано чисто
    private int userId;  //ссылается на ИД в другую таблицу


    //конструктор работает ТОЛЬКО с логин
    public Statisticas(String login) {
        this.login = login;
    }


    //конструктор работает с телом.кнопкой.инсерт (добавление имени)
    public Statisticas(int statisticasId, String login, int sumTry,
                       int win, int hint, int flawlessWin, int userId) {
        this.statisticasId = statisticasId;
        this.login = login;
        this.sumTry = sumTry;
        this.win = win;
        this.hint = hint;
        this.flawlessWin = flawlessWin;
        this.userId = userId;
    }


    //констр работает с ДАО слоем инсерт
    public Statisticas(String login, int sumTry, int win, int hint,
                       int flawlessWin, int userId) {
        this.login = login;
        this.sumTry = sumTry;
        this.win = win;
        this.hint = hint;
        this.flawlessWin = flawlessWin;
        this.userId = userId;
    }

    public Statisticas() {
    }

    public Statisticas(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Statisticas{" +
                "statisticasId=" + statisticasId +
                ", login='" + login + '\'' +
                ", sumTry=" + sumTry +
                ", win=" + win +
                ", hint=" + hint +
                ", flawlessWin=" + flawlessWin +
                ", userId=" + userId +
                '}';
    }

    public int getStatisticasId() {

        return statisticasId;
    }

    public void setStatisticasId(int statisticasId) {

        this.statisticasId = statisticasId;
    }

    public String getLogin() {

        return login;
    }

    public void setLogin(String login) {

        this.login = login;
    }

    public int getSumTry() {
        return sumTry;
    }

    public void setSumTry(int sumTry) {
        this.sumTry = sumTry;
    }

    public int getWin() {
        return win;
    }

    public void setWin(int win) {
        this.win = win;
    }

    public int getHint() {
        return hint;
    }

    public void setHint(int hint) {
        this.hint = hint;
    }

    public int getFlawlessWin() {
        return flawlessWin;
    }

    public void setFlawlessWin(int flawlessWin) {
        this.flawlessWin = flawlessWin;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
