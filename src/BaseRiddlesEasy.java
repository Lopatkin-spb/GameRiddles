import java.util.Scanner;

//переименовать в выбор легкой загадки - изи риддл чейс
//загадки с сайта арзамас академи
public class BaseRiddlesEasy {

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


// В полотняной стране по реке простыне Плывет пароход то назад то вперед, А за ним такая гладь - ни морщинки не видать.
// утюг

//  Вдруг из черной темноты в небе выросли кусты. А на них то голубые, пунцовые, золотые распускаются цветы небывалой красоты. И все улицы под ними тоже стали голубыми, пунцовыми, золотыми, разноцветными.
//  салют

//вот иголки и булавки выползают из-под лавки, на меня они глядят, молока они хотят.
//еж

//страну чудес откроем мы и встретимся с героями в строчках, на листочках, где станции на точках
//книга

//ежик странный у егорки на окне сидит в ведерке. день и ночь он дремлет, спрятав ножки в землю.
//кактус

//если день нахмурится, если дождь пойдет - выйдет он на улицу, надо мной вспорхнет.
//зонт

//мудрец в нем видел мудреца, глупец - глупца, баран - барана, овцу в нем видела овца, и обезьяну - обезьяна, но вот подвели к нему федю баратова, и федя неряху увидел лохматого.
//зеркало








    //  private String str51 = "В синем небе светляки - \nНе дотянешь к ним руки. \nА один большой светляк \nИзогнулся как червяк.";
    //   private String str52 = "Звезды и месяц";

    //геттеры для заприваченных переменных

    public String getStr11() {
        return str11;
    }

    public String getStrA11() {
        return strA11;
    }

    public String getStr13() {
        return str13;
    }

    public String getStr21() {
        return str21;
    }

    public String getStrA21() {
        return strA21;
    }

    public String getStr23() {
        return str23;
    }

    public String getStr31() {
        return str31;
    }

    public String getStrA31() {
        return strA31;
    }

    public String getStr33() {
        return str33;
    }

    public String getStr41() {
        return str41;
    }

    public String getStrA41() {
        return strA41;
    }

    public String getStr43() {
        return str43;
    }

    //метод дает выбрать загадки поочереди по выбору
    //
    // подумать как назвать метод - что он возвращает

    public void showQuantity() {

//тестовые строки
//        System.out.print('\f');
//        System.out.print("\r");
//        System.out.print("\r");

        System.out.println("\nВам доступно 4 загадки на данный момент.");
    }

    public void baseRiddlesEasy() {

        System.out.println("\nВыберите загадку, \nнажав цифру от (1) до (4) и разгадайте ее скорее!");

//
        Scanner sc = new Scanner(System.in);
        int numberRiddles = sc.nextInt();


        switch (numberRiddles) {
            case 1:
                BaseRiddlesEasy baseRiddlesEasy1 = new BaseRiddlesEasy();
                Main main1 = new Main();

                String outRiddle1 = baseRiddlesEasy1.getStr11();
                main1.setRiddle(outRiddle1);

                String outAnswer1 = baseRiddlesEasy1.getStrA11();
                main1.setAnswer(outAnswer1);

                Main.setHint2(getStr13());
                break;

            case 2:
                BaseRiddlesEasy baseRiddlesEasy2 = new BaseRiddlesEasy();
                Main main2 = new Main();

                String outRiddle2 = baseRiddlesEasy2.getStr21();
                main2.setRiddle(outRiddle2);

                String outAnswer2 = baseRiddlesEasy2.getStrA21();
                main2.setAnswer(outAnswer2);

                Main.setHint2(getStr23());
                break;
            case 3:
                BaseRiddlesEasy baseRiddlesEasy3 = new BaseRiddlesEasy();
                Main main3 = new Main();

                String outRiddle3 = baseRiddlesEasy3.getStr31();
                main3.setRiddle(outRiddle3);

                String outAnswer3 = baseRiddlesEasy3.getStrA31();
                main3.setAnswer(outAnswer3);

                Main.setHint2(getStr33());
                break;
            case 4:
                BaseRiddlesEasy baseRiddlesEasy = new BaseRiddlesEasy();
                Main main = new Main();

                String outRiddle = baseRiddlesEasy.getStr41();
                main.setRiddle(outRiddle);

                String outAnswer = baseRiddlesEasy.getStrA41();
                main.setAnswer(outAnswer);

                Main.setHint2(getStr43());
                break;

            default:
                System.out.println("Вы уверены, что такой уровень тут есть?");
                BaseRiddlesEasy baseRiddlesEasy6 = new BaseRiddlesEasy();
                baseRiddlesEasy6.baseRiddlesEasy();

        }
        //sc.close();
    }
}