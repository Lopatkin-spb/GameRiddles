import java.util.Scanner;

//переименовавть в выбор уровня - левел селекшион

public class LevelDificult {

//назвать метод так -что он возвращает если не войд

    //в последствии надо посмотреть вызов класса через рефлексию и\или инстанс
//или сделать возможно интерфейс, собрать все методы с разных классов и вызывать через интерфейс
    public void level() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Выберите уровень сложности загадок пожалуйста. " +
                "\n- оооочень легкие - введите (1).\n" +
                "- посложнее - " +
                "введите (2)(пока недоступно, но ученые работают над данной " +
                "проблемой).\n- " +
                "уровня Шерлока Холмса - введите (3)(таже самая проблема с учеными мужами).");
        int lvl = sc.nextInt();


        switch (lvl) {

            case 1:
                BaseRiddlesEasy baseRiddlesEasy = new BaseRiddlesEasy();
                baseRiddlesEasy.showQuantity();
                baseRiddlesEasy.baseRiddlesEasy();
                break;
            default:
                System.out.println("Вы уверены, что такой уровень тут есть?\n");
                LevelDificult levelDificult = new LevelDificult();
                levelDificult.level();
        }
        //sc.close();

    }
}
