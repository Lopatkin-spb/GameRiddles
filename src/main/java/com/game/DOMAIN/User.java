package com.game.DOMAIN;

public class User {


    private int userId;           //уникальное число номер (не повторяется)
    private String login;        // Имя
    private String password;     //  всего попыток
    //private int statisticas_id;  //ссылается на ИД в другую таблицу


    public User(int userId, String login, String password) {
        this.userId = userId;
        this.login = login;
        this.password = password;
        //this.statisticas_id = statisticas_id;
    }


    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }


    public User(){
    }


    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", login='" + login + '\'' +
                ", password='" + password +
                //", statistics_id=" + statisticas_id +
                '}';
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

  //  public int getStatisticas_id() {
  //      return statisticas_id;
  //  }

  //  public void setStatisticas_id(int statisticas_id) {
  //      this.statisticas_id = statisticas_id;
  //  }
}
