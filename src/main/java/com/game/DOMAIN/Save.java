package com.game.DOMAIN;

public class Save {

    private int userId;  //ссылается на ИД в другую таблицу
    private String login;        // Имя
    private String easyRiddles;
    private String normalRiddles;
    private String hardRiddles;


    public Save(int userId, String login,
                String easyRiddles, String normalRiddles, String hardRiddles) {
        this.userId = userId;
        this.login = login;
        this.easyRiddles = easyRiddles;
        this.normalRiddles = normalRiddles;
        this.hardRiddles = hardRiddles;
    }


    public Save(int userId) {
        this.userId = userId;
    }

    public Save() {
    }

    @Override
    public String toString() {
        return "Save{" +
                "userId=" + userId +
                ", login='" + login + '\'' +
                ", easyRiddles=" + easyRiddles +
                ", normalRiddles=" + normalRiddles +
                ", hardRiddles=" + hardRiddles +
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

    public String getEasyRiddles() {
        return easyRiddles;
    }

    public void setEasyRiddles(String easyRiddles) {
        this.easyRiddles = easyRiddles;
    }

    public String getNormalRiddles() {
        return normalRiddles;
    }

    public void setNormalRiddles(String normalRiddles) {
        this.normalRiddles = normalRiddles;
    }

    public String getHardRiddles() {
        return hardRiddles;
    }

    public void setHardRiddles(String hardRiddles) {
        this.hardRiddles = hardRiddles;
    }
}
