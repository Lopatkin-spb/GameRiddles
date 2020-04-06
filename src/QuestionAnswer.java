import java.util.Scanner;

public class QuestionAnswer {
    public void questionAnswer() {

//подключаем сканер
        Scanner sc = new Scanner(System.in);

//обращаемся к классу выловленной загадки
        Main main = new Main();

//создаем переменные для счетчика попыток, колва подсказок, напоминания подсказки,
//количесво отгадываний с первой попытки
        int counterTry = 0;
        int hint = 0;
        int zzz = 0;
        int counterFirstAttempt = 0;

//создаем 2 переменных к кот присваиваем загадку и ответ
        String question = main.getRiddle();
        String trueAnswer = main.getAnswer();

//выводим на екран загадку
        System.out.println("Загадка:\n\n" + question);

//выводим на екран вопрос кот хорошо бы сделать рандомным
        System.out.println("\nКак вы думаете что это?");

//создаем цикл
        while (true) {

//создаем переменную внутри цикла для ответа пользователя и последующего сравнения
//и считываем сканером ответ пользователя
//и присваиваем новой переменной ответ
            String userAnswer = sc.nextLine();

//подключаем сравнение без учета регистра
            if (userAnswer.equalsIgnoreCase(trueAnswer)) {

//цикл восклицаний комплиментов после положительного отгадываний
                while (counterTry >= 0) {

//если пользователь угадал с первого раза то восклицание из нескольких слов
                    if (counterTry == 0) {
                        Say say = new Say();
                        say.complimentFirst();
                        counterFirstAttempt = counterFirstAttempt + 1;
                        break;
//рандомно выводит комплимент из одного слова
                    } else {
                        Say say = new Say();
                        say.complimentSecond();
                        break;
                    }
                }

                System.out.println("Вы отгадали. Это " + trueAnswer + ".");

                break;

            } else if (userAnswer.equalsIgnoreCase("сдаюсь")) {
                System.out.println("Правильный ответ: " + trueAnswer);
                break;

//            } else if (userAnswer.equalsIgnoreCase("подсказка")) {
//                System.out.println("Хорошо. Вот " + hint + " подсказка. " +
//                        "В слове " + trueAnswer.length() + " букв.");
//                hint = hint + 1;

// цикл кот выводит первую подсказку
            } else if (counterTry == 1) {
                System.out.println("Если хотите подсказку, напишите: ДА." +
                        "\nЕсли не хотите: нажмите ENTER.");
                String hintAnswer = sc.nextLine();

                if (hintAnswer.equalsIgnoreCase("ДА")) {
                    hint = hint + 1;
                    System.out.println("Хорошо. Вот " + hint + " подсказка. " +
                            "В слове " + trueAnswer.length() + " букв.");
                    zzz = zzz + 1;
                } else {
                }
            }

//цикл выводит вторую заключительную подсказку
            else if (counterTry == 3) {
                System.out.println("Могу предложить заключительную подсказку.\n" +
                        "Напишите: ДА. Или: ENTER.");
                String hintAnswer = sc.nextLine();

                if (hintAnswer.equalsIgnoreCase("ДА")) {
                    hint = hint + 1;
                    System.out.println("Держите " + hint + " подсказку.\n" +
                            "" + Main.getHint2());


                } else {
                }
            } else {
                System.out.println("Неправильный ответ. Попробуйте еще раз.\n");
                counterTry = counterTry + 1;
            }


        }

//выключаем сканер
        // sc.close();

// тут делаем восклицания варианты как пользователь быстро или
// не быстро отгадал загадку

//показываем количесво попыток пользователя
        System.out.print("\nВы сделали " + counterTry + " попыток. " +
                "\nИ использовали подсказок: " + hint + "\n");

        Say say = new Say();
        say.interestingFact();
    }
}
