import javax.swing.*;

public class Base extends JPanel {

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

    public String[] questionBase = new String[6];
    public String[] answer = new String[5];
    public String[] hint = new String[5];

    public Base() {


        questionBase[0] = "<html><h2>Речка спятила с ума - <br>&nbsp; &nbsp; По домам пошла сама.</h2><div right>@цитата</div></html>";
        questionBase[1] = "<html><h2>Музыкант, певец, рассказчик - <br>&nbsp; &nbsp; А всего труба да ящик.</h2><div right>@цитата</div></html>";
        questionBase[2] = "<html><h2>На раскрашенных страницах <br>&nbsp; &nbsp; Много праздников хранится.</h2><div right>@цитата</div></html>";
        questionBase[3] = "<html><h2>Маленькие домики по улице бегут, <br>&nbsp; &nbsp; Мальчиков и девочек домики везут.</h2><div right>@цитата</div></html>";
        questionBase[4] = "<html><h2>В полотняной стране по реке простыне <br>&nbsp; &nbsp; Плывет пароход то назад то вперед, <br>&nbsp; &nbsp; &nbsp; А за ним такая гладь - ни морщинки не видать.</h2><div right>@цитата</div></html>";
        questionBase[5] = "<html><h2>Речка спятила с ума - <br>&nbsp; &nbsp; &nbsp;По домам пошла сама.</h2><div right>@цитата</div></html>";

        answer[0] = "Водопровод";
        answer[1] = "Граммофон";
        answer[2] = "Календарь";
        answer[3] = "Машины";
        answer[4] = "Утюг";

        hint[0] = "Это было даже в древние века.";
        hint[1] = "В настоящее время это не используется.";
        hint[2] = "Используется реже с каждым годом.";
        hint[3] = "Используется все чаще и чаще.";
        hint[4] = "Это есть практически в каждом доме";

    }

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


// В полотняной стране по реке простыне Плывет пароход то назад то вперед, А за ним такая гладь - ни морщинки не видать.
// утюг


}