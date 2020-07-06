package com.game.UI;

import javax.swing.*;

public class Base extends JPanel {

    /*
    private String str11 = "Речка спятила с ума - \nПо домам пошла сама.";
    private String strA11 = "Водопровод";
    private String str13 = "Было даже в древние века.";

    private String str21 = "Музыкант, певец, рассказчик - \nА всего труба да ящик.";
    private String strA21 = "Граммофон";
    private String str23 = "В настоящее время это не используется.";

    private String str31 = "На раскрашенных страницах \nМного праздников хранится.";
    private String strA31 = "Календарь";
    private String str33 = "Используется реже с каждым годом.";

    private String str41 = "Маленькие домики по улице бегут, \nМальчиков и девочек домики везут.";
    private String strA41 = "Машины";
    private String str43 = "Используется все чаще и чаще.";

     */

    public String[] questionEasy = new String[9];
    public String[] answerEasy = new String[9];
    public String[] hintEasy = new String[9];


    public String[] questionNormal = new String[7];
    public String[] answerNormal = new String[7];
    public String[] hintNormal = new String[7];


    public String[] questionHard = new String[5];
    public String[] answerHard = new String[5];
    public String[] hintHard = new String[5];



    public Base() {

        questionEasy[0] = "<html><h2>Речка спятила с ума - " +
                "<br>&nbsp; &nbsp; По домам пошла сама.</h2>" +
                "<div right>С.Маршак,1930</div></html>";
        questionEasy[1] = "<html><h2>Музыкант, певец, рассказчик - " +
                "<br>&nbsp; &nbsp; А всего труба да ящик.</h2>" +
                "<div right>С.Маршак,1930</div></html>";
        questionEasy[2] = "<html><h2>Ах, не трогайте меня:" +
                "<br>&nbsp; &nbsp; Обожгу и без огня!</h2>" +
                "<div right>К.Чуковский,1959</div></html>";
        questionEasy[3] = "<html><h2>Маленькие домики по улице бегут, " +
                "<br>&nbsp; &nbsp; Мальчиков и девочек домики везут.</h2>" +
                "<div right>К.Чуковский,1970</div></html>";
        questionEasy[4] = "<html><h2>В полотняной стране по реке простыне " +
                "<br>&nbsp; &nbsp; Плывет пароход то назад то вперед, " +
                "<br>&nbsp; &nbsp; &nbsp; А за ним такая гладь - ни морщинки не видать.</h2>" +
                "<div right>С.Маршак,1930</div></html>";
        questionEasy[5] = "<html><h2>Вот иголки и булавки выползают из-под лавки," +
                "<br>&nbsp; &nbsp; &nbsp; На меня они глядят, молока они хотят.</h2>" +
                "<div right>'Еж',1929</div></html>";
        questionEasy[6] = "<html><h2>Страну чудес откроем мы и встретимся с героями" +
                "<br>&nbsp; &nbsp; &nbsp; В строчках, на листочках, где станции на точках.</h2>" +
                "<div right>А.Рождественская,1957</div></html>";
        questionEasy[7] = "<html><h2>Если день нахмурится, если дождь пойдет -" +
                "<br>&nbsp; &nbsp; &nbsp; Выйдет он на улицу, надо мной вспорхнет.</h2>" +
                "<div right>'Мурзилка',1990</div></html>";
        questionEasy[8] = "<html><h2>На пальце одном," +
                "<br>&nbsp; &nbsp; Ведерко вверх дном.</h2>" +
                "<div right>Русская народная загадка</div></html>";

        answerEasy[0] = "Водопровод";
        answerEasy[1] = "Граммофон";
        answerEasy[2] = "Крапива";
        answerEasy[3] = "Машины";
        answerEasy[4] = "Утюг";
        answerEasy[5] = "Еж";
        answerEasy[6] = "Книга";
        answerEasy[7] = "Зонт";
        answerEasy[8] = "Наперсток";

        hintEasy[0] = "это было даже в древние века.";
        hintEasy[1] = "в настоящее время это не используется.";
        hintEasy[2] = "бывает исключительно в теплое время года.";
        hintEasy[3] = "используется все чаще и чаще.";
        hintEasy[4] = "это есть практически в каждом доме.";
        hintEasy[5] = "встречается в теплое время.";
        hintEasy[6] = "это есть в каждом доме.";
        hintEasy[7] = "присутствует в каждом доме.";
        hintEasy[8] = "до сих пор используется";



        questionNormal[0] = "<html><h2>На раскрашенных страницах " +
                "<br>&nbsp; &nbsp; Много праздников хранится.</h2>" +
                "<div right>'Мурзилка',1959</div></html>";
        questionNormal[1] = "<html><h2>Кафтан на мне зеленый, а сердце - как кумач" +
                "<br>&nbsp; &nbsp; На вкус, как сахар, сладок, на вид - похож на мяч.</h2>" +
                "<div right>'Мурзилка',1928</div></html>";
        questionNormal[2] = "<html><h2>Пустые - отдыхаем," +
                "<br>&nbsp; &nbsp; А полные - шагаем.</h2>" +
                "<div right>С.Маршак,1930</div></html>";
        questionNormal[3] = "<html><h2>Нет ушей, а слышит." +
                "<br>&nbsp; &nbsp; Нету рук, а пишет.</h2>" +
                "<div right>'Мурзилка',1974</div></html>";
        questionNormal[4] = "<html><h2>Деревянный брусок," +
                "<br>&nbsp; &nbsp; А на нем растет лесок.</h2>" +
                "<div right>'Чиж',1930</div></html>";
        questionNormal[5] = "<html><h2>Орехов не ест," +
                "<br>&nbsp; &nbsp; Сахара не просит," +
                "<br>&nbsp; &nbsp; &nbsp; А щипцы с собой носит.</h2>" +
                "<div right>Н.Назарова,1959</div></html>";
        questionNormal[6] = "<html><h2>На листочке, на страничке - то ли точки, то ли птички." +
                "<br>&nbsp; &nbsp; Все сидят на лесенке, все щебечут песенки.</h2>" +
                "<div right>'Мурзилка',1975</div></html>";

   /*     questionNormal[7] = "<html><h2>На пальце одном," +
                "<br>&nbsp; &nbsp; Ведерко вверх дном.</h2>" +
                "<div right>Русская народная загадка</div></html>";

    */

        answerNormal[0] = "Календарь";
        answerNormal[1] = "Арбуз";
        answerNormal[2] = "Сапоги";
        answerNormal[3] = "Магнитофон";
        answerNormal[4] = "Щетка";
        answerNormal[5] = "Рак";
        answerNormal[6] = "Ноты";

        hintNormal[0] = "есть практически у каждого.";
        hintNormal[1] = "появляется летом.";
        hintNormal[2] = "есть практически у каждого.";
        hintNormal[3] = "в настоящее время практически вышел из обихода.";
        hintNormal[4] = "в каждой квартире есть несколько.";
        hintNormal[5] = "встречается в летний период.";
        hintNormal[6] = "используется до сих пор.";





        questionHard[0] = "<html><h2>чем больше отдаю, тем больше вырастаю," +
                "<br>&nbsp; &nbsp; величину свою отдачей измеряю.</h2>" +
                "<div right>Мурзилка,1928</div></html>";
        questionHard[1] = "<html><h2>как пошли четыре братца под корытом кувыркаться." +
                "<br>&nbsp; &nbsp; понесли меня с тобой по дороге столбовой.</h2>" +
                "<div right>С.Маршак,1928</div></html>";
        questionHard[2] = "<html><h2>На одной яме - " +
                "<br>&nbsp; &nbsp; Сто ям с ямой.</h2>" +
                "<div right>Русская народная загадка</div></html>";




        answerHard[0] = "яма";
        answerHard[1] = "телега";
        answerHard[2] = "наперсток";
    }
/*
    public String getStr11() {
        return str11;
    }

    public void setStr11(String str11) {
        this.str11 = str11;
    }

    public String getStrA11() {
        return strA11;
    }

    public void setStrA11(String strA11) {
        this.strA11 = strA11;
    }

    public String getStr13() {
        return str13;
    }

    public void setStr13(String str13) {
        this.str13 = str13;
    }

 */


// В полотняной стране по реке простыне Плывет пароход то назад то вперед, А за ним такая гладь - ни морщинки не видать.
// утюг


}