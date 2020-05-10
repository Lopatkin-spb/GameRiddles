import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.Arrays;

public class TestMenu extends JFrame {

    GridLayout grid;
    CardLayout cards;
    JPanel cardPanel;
    public JPanel selectEasyRiddles;
    public JPanel riddlePanel;

    public JPanel testPanel;
    public JPanel testButtonPanel;

    public JLabel question;
    public String answer = new String();
    public JLabel hint;

    //testovie
    public JLabel question1;
    public String answer1;
    public JLabel hint1;
    public JLabel question2;
    public JLabel hint2;

    public JButton easyRiddles[] = new JButton[7];

    public int sumNegativeCounterTry = 0;
    public int sumWins = 0;
    public int flawlessWin = 0;
    public int sumHints = 0;
    public int counterTryRiddle = 0;
    public int counterTryRddlHints = 0;


    /*   /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                TestMenu frame = new TestMenu();
                frame.setVisible(true);
            }
        });
    }


    /**
     * Create the frame.
     */
    public TestMenu() {
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setBounds(100, 100, 600, 400);
        //setTitle("Menue GUI");
        Font fontRiddle = new Font("Verdana", Font.ITALIC, 10);

        Base base = new Base();
        Message messageBasa = new Message();

        grid = new GridLayout(6, 0, 50, 30);
        Dimension labelSize = new Dimension(400, 300);
        //Border solidBorder = BorderFactory.createLineBorder(Color.yellow, 1);

// Button Game
        JPanel mainPanel = new JPanel();
        JButton btnGame = new JButton("Игра");
        JButton btnAuto = new JButton("Авторизация");
        JButton btnSettings = new JButton("Настройки");
        JButton btnRules = new JButton("Правила");
        JButton btnStatistics = new JButton("Статистика");
        JButton btnExit = new JButton("Выход");
        btnGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cards.show(cardPanel, "Panel 2");
            }
        });
        btnAuto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cards.show(cardPanel, "Panel 3");
            }
        });
        btnSettings.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cards.show(cardPanel, "Panel 4");
            }
        });
        btnRules.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cards.show(cardPanel, "Panel 5");
            }
        });
        btnStatistics.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cards.show(cardPanel, "Panel 9(statistics)");
            }
        });
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //было одно диспоус - при перенесении в другой фрейм мейна пришлось добавить ссылку на фрейм
                //WindowForGame wg = new WindowForGame();
                dispose();
                //System.exit(0);
            }
        });
        mainPanel.setLayout(grid);
        mainPanel.add(btnGame);
        mainPanel.add(btnAuto);
        mainPanel.add(btnSettings);
        mainPanel.add(btnRules);
        mainPanel.add(btnStatistics);
        mainPanel.add(btnExit);


        cards = new CardLayout();
        cardPanel = new JPanel();
        cardPanel.setLayout(cards);


        // Panel 1
        JPanel panel1 = new JPanel();
        JLabel label3 = new JLabel("Добро пожаловать!");
        panel1.setLayout(null);
        label3.setBounds(160, 100, 180, 30);
        panel1.add(label3);


// Panel 2
        JPanel panel2 = new JPanel();
        panel2.setBorder(BorderFactory.createTitledBorder("Игра"));
        JLabel label = new JLabel("Выберите уровень сложности");
        JButton btn2 = new JButton("легкий");
        JButton btn3 = new JButton("средний");
        JButton btn4 = new JButton("сложный");
        panel2.setLayout(null);
        label.setBounds(150, 50, 200, 30);
        btn2.setBounds(160, 100, 180, 30);
        btn3.setBounds(150, 150, 200, 30);
        btn4.setBounds(140, 200, 220, 30);
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cards.show(cardPanel, "Panel 6(selectEasyRiddles)");
            }
        });
        panel2.add(label);
        panel2.add(btn2);
        panel2.add(btn3);
        panel2.add(btn4);


// Panel 3
        JPanel panel3 = new JPanel();
        panel3.setBorder(BorderFactory.createTitledBorder("Авторизация"));
        JLabel label2 = new JLabel("Авторизация игрока");
        panel3.setLayout(null);
        label2.setBounds(160, 100, 180, 30);
        panel3.add(label2);


// Panel 4 settings
        JPanel settings = new JPanel();
        settings.setBorder(BorderFactory.createTitledBorder("Настройки"));
        JLabel sound0 = new JLabel("Звук");
        JButton sound1 = new JButton("вкл");
        JButton sound2 = new JButton("выкл");
        JLabel skin = new JLabel("Скины");
        settings.setLayout(null);
        sound0.setBounds(210, 50, 200, 30);
        sound1.setBounds(100, 100, 100, 30);
        sound2.setBounds(250, 100, 100, 30);
        skin.setBounds(210, 200, 200, 30);
        settings.add(sound0);
        settings.add(sound1);
        settings.add(sound2);
        settings.add(skin);


// Panel 5 rules
        JPanel rules = new JPanel();
        JLabel rules0 = new JLabel("Выбирайте уровень сложности и отгадывайте загадки. Все просто.");
        rules.setBorder(BorderFactory.createTitledBorder("Правила"));
        rules0.setPreferredSize(labelSize);
        rules.add(rules0);


// Panel 6(selectEasyRiddles)
        selectEasyRiddles = new JPanel();
        selectEasyRiddles.setBorder(BorderFactory.createTitledBorder("Легкие загадки"));
        easyRiddles[0] = new JButton("1");
        selectEasyRiddles.add(easyRiddles[0]);
        easyRiddles[1] = new JButton("2");
        selectEasyRiddles.add(easyRiddles[1]);
        easyRiddles[2] = new JButton("3");
        selectEasyRiddles.add(easyRiddles[2]);
        easyRiddles[3] = new JButton("4");
        selectEasyRiddles.add(easyRiddles[3]);
        easyRiddles[4] = new JButton("5");
        selectEasyRiddles.add(easyRiddles[4]);
        //test
        easyRiddles[5] = new JButton("test");
        easyRiddles[5].setFont(new Font("Dialog", Font.PLAIN, 20));
        selectEasyRiddles.add(easyRiddles[5]);

        easyRiddles[6] = new JButton("testButton");
        selectEasyRiddles.add(easyRiddles[6]);
        //primer ustanovki action command
        //easyRiddles[4].setActionCommand(String.valueOf(5));
        //easyRiddles[4].setActionCommand("5");
        easyRiddles[0].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                question.setText(base.questionBase[0]);
                answer = base.answer[0];
                cards.show(cardPanel, "Panel 7(riddlePanel)");
                riddlePanel.setBorder(BorderFactory.createTitledBorder("Загадка № 1"));
            }
        });
        easyRiddles[1].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                question.setText(base.questionBase[1]);
                answer = base.answer[1];
                cards.show(cardPanel, "Panel 7(riddlePanel)");
                riddlePanel.setBorder(BorderFactory.createTitledBorder("Загадка № 2"));
            }
        });
        easyRiddles[2].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                question.setText(base.questionBase[2]);
                answer = base.answer[2];
                cards.show(cardPanel, "Panel 7(riddlePanel)");
                riddlePanel.setBorder(BorderFactory.createTitledBorder("Загадка № 3"));
            }
        });
        easyRiddles[3].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                question.setText(base.questionBase[3]);
                answer = base.answer[3];
                cards.show(cardPanel, "Panel 7(riddlePanel)");
                riddlePanel.setBorder(BorderFactory.createTitledBorder("Загадка № 4"));
            }
        });
        easyRiddles[4].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                question.setText(base.questionBase[4]);
                answer = base.answer[4];
                cards.show(cardPanel, "Panel 7(riddlePanel)");
                riddlePanel.setBorder(BorderFactory.createTitledBorder("Загадка № 5"));
            }
        });
//testovaia panel
        easyRiddles[5].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                question1.setText(base.questionBase[1]);
                answer = base.answer[1];
                hint1.setText(base.hint[1]);
                cards.show(cardPanel, "Panel 8(testPanel)");
                testPanel.setBorder(BorderFactory.createTitledBorder("тест"));
            }
        });
        //testovaia panel
  /*      easyRiddles[6].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                question2.setText(messageBasa.wrongAnswer());
                cards.show(cardPanel, "Panel 15(testPanel)");
                testButtonPanel.setBorder(BorderFactory.createTitledBorder("тест knopki"));

                //      (messageBasa.wrongAnswer() + "<html>Если хотите подсказку, <br>введите: (да) или (д) или (подсказка). " +
                //              "<br>Если хотите проверить себя и подумать <br>еще, то введите: (нет) или (н).<html>");


            }
        });

   */


// Panel 7(riddlePanel)
        riddlePanel = new JPanel();
        question = new JLabel();
        JTextField textEnter = new JTextField();
        JButton check = new JButton("Ввод");
        JLabel message = new JLabel("Как вы думаете что это?");
        JButton previousRiddle = new JButton("Предыдущая");
        JButton chooseRiddle = new JButton("Выбор загадки");
        JButton nextRiddle = new JButton("Следующая");
        question.setBounds(60, 20, 400, 180);
        question.setForeground(Color.blue);
        question.setFont(fontRiddle);
        textEnter.setBounds(100, 210, 110, 30);
        check.setBounds(250, 210, 110, 30);
        message.setBounds(150, 250, 250, 30);
        previousRiddle.setBounds(10, 320, 150, 30);
        chooseRiddle.setBounds(160, 320, 150, 30);
        nextRiddle.setBounds(310, 320, 150, 30);
        //proverka otveta
        //answer = new String();
        check.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (textEnter.getText().equalsIgnoreCase(answer)) {
                    message.setText("Ответ верный!");
                } else {
                    message.setText("Ответ неверный. Попробуйте еще раз.");
                }
            }
        });
        chooseRiddle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                message.setText("Как вы думаете что это?");
                textEnter.setText(null);
                cards.show(cardPanel, "Panel 6(selectEasyRiddles)");
            }
        });
        riddlePanel.setLayout(null);
        riddlePanel.add(question);
        riddlePanel.add(textEnter);
        riddlePanel.add(check);
        riddlePanel.add(message);
        riddlePanel.add(previousRiddle);
        riddlePanel.add(chooseRiddle);
        riddlePanel.add(nextRiddle);


// Panel 9(Statistics)
        JPanel statistics = new JPanel();
        statistics.setBorder(BorderFactory.createTitledBorder("Статистика"));

        JLabel info = new JLabel();
        String text1 = new String("<html>статистика игроков: <br>сколько попыток было в сумме, " +
                "<br>сколько загадок отгадано, <br>сколько подсказок использовано, <br>сколько чистых отгадываний было - " +
                "с первого раза<html>");
        //panel1.setLayout(null);
        info.setText(text1);
        info.setBounds(160, 100, 400, 300);
        statistics.add(info);


// Panel 8(testPanel)
        testPanel = new JPanel();
        question1 = new JLabel();
        hint1 = new JLabel();

        JTextField textEnter1 = new JTextField();
        JButton check1 = new JButton("Ввод");
        JLabel message1 = new JLabel("Как вы думаете что это?");
        JButton previousRiddle1 = new JButton("Предыдущая");
        JButton chooseRiddle1 = new JButton("Выбор загадки");
        JButton nextRiddle1 = new JButton("Следующая");
        question1.setBounds(60, 20, 400, 180);
        question1.setForeground(Color.blue);
        question1.setFont(fontRiddle);
        textEnter1.setBounds(100, 210, 110, 30);
        check1.setBounds(250, 210, 110, 30);
        message1.setBounds(130, 240, 300, 80);
        previousRiddle1.setBounds(10, 320, 150, 30);
        chooseRiddle1.setBounds(160, 320, 150, 30);
        nextRiddle1.setBounds(310, 320, 150, 30);
        //proverka otveta
        //answer = new String();
        check1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (textEnter1.getText().equalsIgnoreCase(answer)) {
                    while (counterTryRiddle >= 0) {
                        if (counterTryRiddle == 0) {
                            message1.setText(messageBasa.complimentFirst());
                            flawlessWin = flawlessWin + 1;
                            sumWins = sumWins + 1;
                            break;
                        } else {
                            message1.setText(messageBasa.complimentSecond());
                            sumWins = sumWins + 1;
                            break;
                        }
                    }
                    message1.setText("Вы отгадали. Это " + answer + ".");
                    //break;

                } else if (textEnter1.getText().equalsIgnoreCase("сдаюсь")) {
                    message1.setText("Правильный ответ: " + answer + ".");
                    //break;
                } else {
                    if (counterTryRiddle == 0) {
                        message1.setText(messageBasa.wrongAnswer());
                        counterTryRiddle = counterTryRiddle + 1;
                        sumNegativeCounterTry = sumNegativeCounterTry + 1;
                    } else if (counterTryRiddle == 1 || counterTryRiddle == 3) {
                        counterTryRiddle = counterTryRiddle + 1;
                        sumNegativeCounterTry = sumNegativeCounterTry + 1;
                        message1.setText("<html>" + messageBasa.wrongAnswer() + "<br>Если хотите подсказку, введите: (да) или (д) <br>или (подсказка). " +
                                "Либо просто продолжайте отгадывать.</html>");

                        // message1.setText("<html>"+messageBasa.wrongAnswer()+" <br>Если хотите подсказку, введите: (да) или (д) <br>или (подсказка). " +
                        //         "Если хотите проверить <br>себя и подумать еще, то введите: (нет) или (н).</html>");


                        if (counterTryRiddle == 1 && ((textEnter1.getText().equalsIgnoreCase("да")) ||
                                (textEnter1.getText().equalsIgnoreCase("д")) ||
                                (textEnter1.getText().equalsIgnoreCase("подсказка")))) {
                            counterTryRddlHints = counterTryRddlHints + 1;
                            message1.setText("Хорошо. Вот " + counterTryRddlHints + " подсказка. " +
                                    "В слове " + answer.length() + " букв.");
                            sumHints = sumHints + 1;

                        } else if (counterTryRiddle == 3 && ((textEnter1.getText().equalsIgnoreCase("да")) ||
                                (textEnter1.getText().equalsIgnoreCase("д")) ||
                                (textEnter1.getText().equalsIgnoreCase("подсказка")))) {
                            counterTryRddlHints = counterTryRddlHints + 1;
                            message1.setText("Держите " + counterTryRddlHints + " подсказку. " + hint);
                            sumHints = sumHints + 1;

                        }
                        //else if ((textEnter1.getText().equalsIgnoreCase("нет")) ||
                        //        (textEnter1.getText().equalsIgnoreCase("н"))) {
                        //    message1.setText("Чудесно! Тогда продолжим.");
                        //}
                        /*    else {
                            message1.setText("Скорректируйте ответ пожалуйста.");
                        } */
                    } else {
                        message1.setText(messageBasa.wrongAnswer());
                        counterTryRiddle = counterTryRiddle + 1;
                        sumNegativeCounterTry = sumNegativeCounterTry + 1;
                    }
                }
            }
        });
        chooseRiddle1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                message1.setText("Как вы думаете что это?");
                textEnter1.setText(null);
                counterTryRiddle = 0;
                counterTryRddlHints = 0;
                cards.show(cardPanel, "Panel 6(selectEasyRiddles)");
            }
        });
        testPanel.setLayout(null);
        testPanel.add(question1);
        testPanel.add(textEnter1);
        testPanel.add(check1);
        testPanel.add(message1);
        testPanel.add(previousRiddle1);
        testPanel.add(chooseRiddle1);
        testPanel.add(nextRiddle1);


//testovaia dla knopki
        testButtonPanel = new JPanel();
 /*       question2 = new JLabel();
        hint2 = new JLabel();

        JTextField textEnter2 = new JTextField();
        JButton check2 = new JButton("Ввод");
        JLabel message2 = new JLabel("Как вы думаете что это?");
        JButton previousRiddle2 = new JButton("Предыдущая");
        JButton chooseRiddle2 = new JButton("Выбор загадки");
        JButton nextRiddle2 = new JButton("Следующая");
        question2.setBounds(60, 20, 400, 180);
        question2.setForeground(Color.blue);
        question2.setFont(fontRiddle);
        textEnter2.setBounds(100, 210, 110, 30);
        check2.setBounds(250, 210, 110, 30);
        message2.setBounds(130, 240, 300, 80);
        previousRiddle2.setBounds(10, 320, 150, 30);
        chooseRiddle2.setBounds(160, 320, 150, 30);
        nextRiddle2.setBounds(310, 320, 150, 30);
        //proverka otveta
        //answer = new String();
        check2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (textEnter2.getText().equalsIgnoreCase(answer)) {
                    message2.setText(messageBasa.wrongAnswer());
                } else {
                    message2.setText("<html>" + messageBasa.wrongAnswer() + "<br>Если хотите подсказку, введите: (да) или (д) <br>или (подсказка). " +
                            "Если хотите проверить <br>себя и подумать еще, то введите: (нет) или (н).</html>");

                }
            }
        });
        testButtonPanel.setLayout(null);
        testButtonPanel.add(question2);
        testButtonPanel.add(textEnter2);
        testButtonPanel.add(check2);
        testButtonPanel.add(message2);
        testButtonPanel.add(previousRiddle2);
        testButtonPanel.add(chooseRiddle2);
        testButtonPanel.add(nextRiddle2);


  */

        cardPanel.add(selectEasyRiddles, "Panel 6(selectEasyRiddles)");
        cardPanel.add(panel1, "Panel 1");
        cardPanel.add(panel2, "Panel 2");
        cardPanel.add(panel3, "Panel 3");
        cardPanel.add(settings, "Panel 4");
        cardPanel.add(rules, "Panel 5");
        //cardPanel.add(selectEasyRiddles, "Panel 6");
        cardPanel.add(riddlePanel, "Panel 7(riddlePanel)");
        cardPanel.add(statistics, "Panel 9(statistics)");
        cardPanel.add(testPanel, "Panel 8(testPanel)");
        cardPanel.add(testButtonPanel, "Panel 15(testPanel)");


        //WindowForGame wg = new WindowForGame();
        getContentPane().add(mainPanel, BorderLayout.WEST);
        getContentPane().add(cardPanel, BorderLayout.CENTER);
    }
}