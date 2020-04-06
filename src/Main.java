import java.util.Scanner;

public class Main {

    private static String riddle;
    private static String answer;
    private static String Hint2;


    public void setRiddle(String riddle) {
        this.riddle = riddle;
    }

    public String getRiddle() {
        return riddle;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public static String getHint2() {
        return Hint2;
    }

    public static void setHint2(String hint2) {
        Hint2 = hint2;
    }



    public static void main(String[] args) {
//        System.out.println("rrrr");
//        System.out.print("ddddd");
//       System.out.print("\r\r");





        LevelDificult levelDificult = new LevelDificult();
        levelDificult.level();

  //      System.out.println(getHint2());

        QuestionAnswer questionAnswer = new QuestionAnswer();
        questionAnswer.questionAnswer();

        Main main = new Main();
        main.nextLevel();

    }


    public void nextLevel() {
        for (int count = 0; count < 6; count = count + 1) {

            System.out.println("Нажмите:\n - (1) загадать следующую\n " +
                    "- (2) чтобы перейти на другой уровень сложности (напомним что он еще в разработке)");

            Scanner sc = new Scanner(System.in);
            int x = sc.nextInt();

            switch (x) {

                case 1:
                    BaseRiddlesEasy baseRiddlesEasy = new BaseRiddlesEasy();
                    baseRiddlesEasy.baseRiddlesEasy();
                    QuestionAnswer questionAnswer = new QuestionAnswer();
                    questionAnswer.questionAnswer();
                    break;
                case 2:

                case 3:
                    System.out.println("мужики так быстро еще не успели запилить этот уровень ))");
                    break;

                default:
                    System.out.println("Вы уверены, что такой уровень тут есть?");
                    Main main = new Main();
                    main.nextLevel();

            }
            //sc.close();

        }
        //      System.out.println(riddle);


    }

//sc.close();
}
