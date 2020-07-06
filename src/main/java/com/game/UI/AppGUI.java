package com.game.UI;

import com.game.DAO.SavesDAO;
import com.game.DAO.StatisticsDAO;
import com.game.DAO.UsersDAO;
import com.game.DOMAIN.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;
//import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.Font.*;
import static javax.swing.BoxLayout.Y_AXIS;

public class AppGUI extends JFrame {


    //перечисление переменных ГУИ
    private JPanel cardPanel; //// главная панель(контейнер) в которую добавляются страницы-панели
    private CardLayout cardLayout;
    private JPanel pnlLogin;  ////
    private JButton btnClearFieldL;
    private JLabel infoLoginL, infoPasswordL;
    private JTextField textLoginInputLogin, textPassInputLogin;
    private JButton btnEnterLogin, btnPreviousMenuLog, btnPnlAuthoriz;
    private JLabel messageLogin;
    private JPanel pnlAuthorization; ////
    private JButton btnClearField;
    private JLabel infoLogin, infoPassword;
    private JTextField textLoginInput, textPassInput;
    private JButton enterData, btnPnlLogin;
    private JLabel messageSystem;
    private JPanel pnlWelcome;  ////
    private JLabel infoWelcomeUp, infoUserName, infoWelcomeDown;
    private JButton btnWelcomeNext;
    private JPanel pnlMain;  ////
    private JButton btnGameMain, btnAutoMain, btnSettMain, btnRulesMain, btnStatMain, btnExitMain;
    private JPanel pnlGameLevel;   ////
    private JLabel messageGame;
    private JButton btnEasy, btnMedium, btnHard, btnPreviousMenuLevel;
    private JPanel pnlSettings;  /////
    private JLabel infoSound;
    private JButton btnSoundOn;
    private JButton btnSoundOff;
    private JLabel infoColor;
    private JButton btnPrevMenuSett;
    private JButton btnTestPanel;
    private JPanel menuGridTestBtn;
    private JPanel pnlRules;   ////
    private JLabel messageRules;
    private JButton btnPreviousMenuRules;
    public JPanel pnlStatistics;  ////
    private JButton btnPreviousMenuStat;
    private JPanel pnlEasyRiddles;  ////
    private int sumEasyRddl = 9;
    private JButton btnEasyRiddles[] = new JButton[sumEasyRddl];
    private JButton btnPreviousMenuEasy;
    private JPanel pnlNormalRiddles; ////
    private int sumNormRddl = 7;
    private JButton btnNormalRiddles[] = new JButton[sumNormRddl];
    private JButton btnPreviousMenuNormal;
    private JPanel pnlRiddle; /////
    public JLabel infoQuestion;
    public String answer = new String();
    public String hint = new String();
    private JTextField textInputUser;
    private JButton btnEnter, chooseRiddle;
    private JLabel messageRddlUp, messageRddlDown;

    //обьекты классов

    private UsersDAO daoUSERS = new UsersDAO();
    private StatisticsDAO daoSTATISTICS = new StatisticsDAO();
    private SavesDAO daoSAVES = new SavesDAO();
    private ModelTableUser modelTableUser = new ModelTableUser();
    private ModelTableStatisticas modelTableStatisticas = new ModelTableStatisticas();
    private ModelTableSave modelTableSave = new ModelTableSave();
    private Base base = new Base();
    private Message messageBasa = new Message();

    //общие счетчики статистики из БД
    public JLabel testCounters;
    public Statisticas userStatistics = new Statisticas();
    public Save userProgress = new Save();
    public String progress = new String();
    public String easyProgress = new String();
    public String normalProgress = new String();
    public String hardProgress = new String();
    public int idTemporary = 0;
    public String loginTemporary = new String();
    public int sumNegativeCounterTryTemporary = 0;
    public int winsTemporary = 0;
    public int hintsTemporary = 0;
    public int flawlessWinsTemporary = 0;
    public int idTemporaryUser = 0;
    public int counterTryRiddle;
    public int counterTryRddlHints;

    //маркер для распознавания уровня загадок и номера загадки(для иконок)
    public int markerLevel;
    public int markerNumberRiddle;
    public Icon iconQuestion;
    public Icon iconInformation;

    //переменные шрифта и цвета
    private Font titleFont;
    private Font numberRiddlesFont;
    private Color colorLine;
    private Color titleColor;
    private Color colorBlue;
    private Color colorPink;
    private Color colorBlack;
    private Color colorLineDefault;

    //testovie
    private GridLayout grid;

    public JPanel testPanel;

    private JPanel testButtonPanel;
    /*private JLabel infoSound1;
    private JButton btnSoundOn1;
    private JButton btnSoundOff1;
    private JLabel infoColor1;
    private JButton btnPrevMenuSett1;
    private JButton btnTestPanel1;

     */

    public JLabel question1;
    public String answer1;
    public String hint1 = new String();


    /**
     * Create the frame.
     */
    public AppGUI() {
        //создание фрейма
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 490, 410);
        //setBounds(100, 100, 600, 410);
        setTitle("GUI Загадки");
        //? разобраться с етим фонтом
        Font fontRiddle = new Font("Verdana", ITALIC, 10);

        titleFont = new Font(null, Font.BOLD, 12);
        numberRiddlesFont = new Font(null, Font.BOLD, 30);
        colorLine = new Color(133, 183, 255, 124);
        titleColor = new Color(0, 0, 0, 164);
        colorBlue = new Color(33, 114, 255);
        colorPink = new Color(255, 176, 194);
        colorBlack = new Color(0, 0, 0, 164);
        colorLineDefault = new Color(133, 183, 255, 124);
        iconQuestion = UIManager.getIcon("OptionPane.questionIcon");
        iconInformation = UIManager.getIcon("OptionPane.informationIcon");

        int width = getWidth();
        int height = getHeight() / 13;
        Dimension size = new Dimension(width, height);


//////////////////////////////////  основная контейнер панель  /////////////////////////////////////
        cardPanel = new JPanel();

        //вид чертежа, похожий на картотеку
        cardLayout = new CardLayout();
        cardPanel.setLayout(cardLayout);
//добавление панелей страниц в основной контейнер в конце конструктора


//////////////////////////////////  Panel 1(pnlLogin)  /////////////////////////////////////
        pnlLogin = new JPanel();

        pnlLogin.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(colorLine),
                "Вход", TitledBorder.DEFAULT_POSITION,
                0, titleFont, titleColor));

        messageLogin = new JLabel("<html>Введите Имя и Пароль, под " +
                "<br>которыми Вы были зарегистрированы.</html>");
        infoLoginL = new JLabel("Введите Имя");
        infoPasswordL = new JLabel("Ведите Пароль");
        textLoginInputLogin = new JTextField();
        textPassInputLogin = new JTextField();
        btnClearFieldL = new JButton("Очистить");
        btnEnterLogin = new JButton("Ввод");
        btnPreviousMenuLog = new JButton("Главное меню");
        btnPnlAuthoriz = new JButton("Зарегистрироваться");
        pnlLogin.setLayout(null);
        messageLogin.setBounds(110, 30, 300, 90);
        infoLoginL.setBounds(90, 140, 100, 30);
        infoPasswordL.setBounds(90, 200, 100, 30);
        textLoginInputLogin.setBounds(220, 140, 100, 30);
        textPassInputLogin.setBounds(220, 200, 100, 30);
        btnClearFieldL.setBounds(10, 300, 150, 30);
        btnEnterLogin.setBounds(160, 300, 150, 30);
        btnPreviousMenuLog.setBounds(10, 330, 150, 30);
        btnPnlAuthoriz.setBounds(310, 330, 150, 30);
        btnEnterLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loginSystem();
            }
        });
        btnClearFieldL.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setCleanFields();
            }
        });
        btnPreviousMenuLog.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Panel 4(pnlMain)");
            }
        });
        btnPnlAuthoriz.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Panel 2(pnlAuthorization)");
            }
        });
        pnlLogin.add(messageLogin);
        pnlLogin.add(infoLoginL);
        pnlLogin.add(infoPasswordL);
        pnlLogin.add(textLoginInputLogin);
        pnlLogin.add(textPassInputLogin);
        pnlLogin.add(btnClearFieldL);
        pnlLogin.add(btnEnterLogin);
        pnlLogin.add(btnPnlAuthoriz);


//////////////////////////////////  Panel 2(pnlAuthorization)  /////////////////////////////////////
        pnlAuthorization = new JPanel();

        pnlAuthorization.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(colorLine),
                "Регистрация", TitledBorder.DEFAULT_POSITION,
                0, titleFont, titleColor));

        messageSystem = new JLabel("Введите пожалуйста свой никнейм и пароль.");
        infoLogin = new JLabel("Введите Имя");
        infoPassword = new JLabel("Введите Пароль");
        textLoginInput = new JTextField();
        textPassInput = new JTextField();
        btnClearField = new JButton("Очистить");
        enterData = new JButton("Ввод");
        btnPnlLogin = new JButton("Назад");
        JButton testLogin = new JButton("testLogin");
        JButton testDelete = new JButton("удаление");
        messageSystem.setBounds(110, 30, 300, 90);
        infoLogin.setBounds(90, 140, 100, 30);
        infoPassword.setBounds(90, 200, 100, 30);
        textLoginInput.setBounds(220, 140, 100, 30);
        textPassInput.setBounds(220, 200, 100, 30);
        btnClearField.setBounds(10, 300, 150, 30);
        enterData.setBounds(160, 300, 150, 30);
        btnPnlLogin.setBounds(10, 330, 150, 30);
        //testLogin.setBounds(250, 110, 110, 30);
        //testDelete.setBounds(250, 260, 110, 30);
        btnClearField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setCleanFields();
            }
        });
        enterData.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                insertIntoBdTables();
            }
        });
        btnPnlLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Panel 1(pnlLogin)");
            }
        });
        testDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                modelTableStatisticas.udalit();
                messageSystem.setText("удачное стирание");
            }
        });
        testLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //
            }
        });
        pnlAuthorization.add(messageSystem);
        pnlAuthorization.setLayout(null);
        pnlAuthorization.add(infoLogin);
        pnlAuthorization.add(infoPassword);
        pnlAuthorization.add(textLoginInput);
        pnlAuthorization.add(textPassInput);
        pnlAuthorization.add(btnClearField);
        pnlAuthorization.add(enterData);
        pnlAuthorization.add(btnPnlLogin);
        //pnlAuthorization.add(testDelete);
        //pnlAuthorization.add(testLogin);


///////////////////////////////////////  Panel 3(pnlWelcome)  ////////////////////////////////////////////
        pnlWelcome = new JPanel();

        pnlWelcome.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(colorLine),
                "Инфо", TitledBorder.DEFAULT_POSITION,
                0, titleFont, titleColor));

        infoWelcomeUp = new JLabel("Добро пожаловать!");
        infoUserName = new JLabel();
        infoWelcomeDown = new JLabel("<html>Желаю приятно <br>провести время.</html>");
        //чтобы было отображение каждый раз разных имен надо ставить таймер обновления
        //loginView = new String();
        //вставить в приветственный текст логин игрока
        //messageWelcome = new JLabel("<html>Добро пожаловать! <br>" +
        //   infoUserName +
        //   "<br>Желаю приятно <br>провести время.</html>");
        btnWelcomeNext = new JButton("Дальше");
        //посмотреть по запросу более полезный метод:
        //как изменить размер шрифта JLabel чтоб взять макс размер
        //messageWelcom.setPreferredSize(new Dimension(400,400));
        //messageWelcome.setFont(new Font("Serif", Font.PLAIN, 40));
        infoWelcomeUp.setFont(new Font("Serif", PLAIN, 40));
        infoUserName.setFont(new Font("Serif", PLAIN, 40));
        infoWelcomeDown.setFont(new Font("Serif", PLAIN, 40));
        infoWelcomeUp.setBounds(60, 0, 400, 200);
        infoUserName.setBounds(100, 50, 300, 200);
        infoWelcomeDown.setBounds(60, 70, 400, 300);
        btnWelcomeNext.setBounds(310, 330, 150, 30);
        btnWelcomeNext.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Panel 4(pnlMain)");
            }
        });
        pnlWelcome.setLayout(null);
        pnlWelcome.add(infoWelcomeUp);
        pnlWelcome.add(infoUserName);
        pnlWelcome.add(infoWelcomeDown);
        pnlWelcome.add(btnWelcomeNext);


//////////////////////////////////////// Panel 4(pnlMain) ///////////////////////////////////////////////
        pnlMain = new JPanel();
        pnlMain.setBorder(BorderFactory.createTitledBorder("Главное меню"));

        JPanel mainMenu = new JPanel();
        mainMenu.setLayout(null);
        btnGameMain = new JButton("Игра");
        btnAutoMain = new JButton("Авторизация");
        btnSettMain = new JButton("Настройки");
        btnRulesMain = new JButton("Правила");
        btnStatMain = new JButton("Статистика");
        btnGameMain.setBounds(160, 20, 150, 30);
        btnAutoMain.setBounds(160, 60, 150, 30);
        btnSettMain.setBounds(160, 100, 150, 30);
        btnRulesMain.setBounds(160, 140, 150, 30);
        btnStatMain.setBounds(160, 180, 150, 30);
        btnGameMain.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Panel 5(pnlGameLevel)");
            }
        });
        btnAutoMain.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pnlLogin.add(btnPreviousMenuLog);
                cardLayout.show(cardPanel, "Panel 1(pnlLogin)");
            }
        });
        btnSettMain.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Panel 6(pnlSettings)");
            }
        });
        btnRulesMain.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Panel 7(pnlRules)");
            }
        });
        btnStatMain.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Panel 8(pnlStatistics)");
            }
        });
        mainMenu.add(btnGameMain);
        mainMenu.add(btnAutoMain);
        mainMenu.add(btnSettMain);
        mainMenu.add(btnRulesMain);
        mainMenu.add(btnStatMain);

        JPanel gridMain = new JPanel(new GridLayout(1, 3, 0, 0));
        btnExitMain = new JButton("Выход");
        btnExitMain.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //было одно диспоус - при перенесении в другой фрейм мейна пришлось добавить ссылку на фрейм
                //WindowForGame wg = new WindowForGame();
                dispose();
                //System.exit(0);
            }
        });
        gridMain.setPreferredSize(size);
        gridMain.add(new JLabel(""));
        gridMain.add(btnExitMain);
        gridMain.add(new JLabel(""));

        pnlMain.setLayout(new BorderLayout());
        pnlMain.add(mainMenu, BorderLayout.CENTER);
        pnlMain.add(gridMain, BorderLayout.SOUTH);


/////////////////////////////////////////// Panel 5(pnlGameLevel) ///////////////////////////////////////
        pnlGameLevel = new JPanel();
        pnlGameLevel.setBorder(BorderFactory.createTitledBorder("Игра"));

        JPanel gameLvlMenu = new JPanel();
        messageGame = new JLabel("Выберите уровень сложности");
        btnEasy = new JButton("легкий");
        btnMedium = new JButton("средний");
        btnHard = new JButton("сложный");
        gameLvlMenu.setLayout(null);
        messageGame.setBounds(150, 50, 200, 30);
        btnEasy.setBounds(160, 100, 180, 30);
        btnMedium.setBounds(150, 150, 200, 30);
        btnHard.setBounds(140, 200, 220, 30);
        btnEasy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Panel 9(pnlEasyRiddles)");
            }
        });
        btnMedium.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Panel 11(pnlNormalRiddles)");
            }
        });
        gameLvlMenu.add(messageGame);
        gameLvlMenu.add(btnEasy);
        gameLvlMenu.add(btnMedium);
        gameLvlMenu.add(btnHard);


        JPanel gameLvlBack = new JPanel(new GridLayout(1, 3, 0, 0));
        btnPreviousMenuLevel = new JButton("Главное меню");
        btnPreviousMenuLevel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Panel 4(pnlMain)");
            }
        });
        gameLvlBack.setPreferredSize(size);
        gameLvlBack.add(btnPreviousMenuLevel);
        gameLvlBack.add(new JLabel(""));
        gameLvlBack.add(new JLabel(""));

        pnlGameLevel.setLayout(new BorderLayout());
        pnlGameLevel.add(gameLvlMenu, BorderLayout.CENTER);
        pnlGameLevel.add(gameLvlBack, BorderLayout.SOUTH);


//////////////////////////////////// Panel 6(pnlSettings) /////////////////////////////////
        pnlSettings = new JPanel(new GridLayout(3, 1, 0, 0));

        pnlSettings.setBorder(BorderFactory.createTitledBorder("Настройки"));
        JPanel soundPnl = new JPanel(new GridLayout(4, 1, 0, 0));
        JPanel colorPnl = new JPanel(new GridLayout(4, 1, 0, 0));
        JPanel menuPnl = new JPanel(new GridLayout(4, 1, 0, 0));

        JPanel soundGrid = new JPanel(new GridLayout(1, 5, 10, 0));
        soundGrid.add(new Label(""));
        soundGrid.add(new Label(""));
        soundGrid.add(new Label(""));
        btnSoundOn = new JButton("вкл");
        soundGrid.add(btnSoundOn);
        btnSoundOff = new JButton("выкл");
        soundGrid.add(btnSoundOff);
        soundPnl.add(new Label(""));
        infoSound = new JLabel("Звук");
        soundPnl.add(infoSound);
        soundPnl.add(soundGrid);
        soundPnl.add(new Label(""));

        JPanel colorGrid = new JPanel(new GridLayout(1, 5, 10, 0));
        colorGrid.add(new Label(""));
        colorGrid.add(new Label(""));
        JRadioButton radioBtnBlack = new JRadioButton("по умолчанию");
        radioBtnBlack.setForeground(colorBlack);
        JRadioButton radioBtnBlue = new JRadioButton("синий");
        radioBtnBlue.setForeground(colorBlue);
        JRadioButton radioBtnPink = new JRadioButton("розовый");
        radioBtnPink.setForeground(colorPink);
        ButtonGroup groupColor = new ButtonGroup();
        groupColor.add(radioBtnBlue);
        groupColor.add(radioBtnPink);
        groupColor.add(radioBtnBlack);
        radioBtnBlack.setSelected(true);
        colorGrid.add(radioBtnBlack);
        colorGrid.add(radioBtnBlue);
        colorGrid.add(radioBtnPink);
        colorPnl.add(new Label(""));
        infoColor = new JLabel("Цвет шрифта");
        colorPnl.add(infoColor);
        colorPnl.add(colorGrid);
        colorPnl.add(new Label(""));

        JPanel menuGrid = new JPanel(new GridLayout(1, 3, 0, 0));
        btnPrevMenuSett = new JButton("Главное меню");
        btnTestPanel = new JButton("тестовая панель");
        btnPrevMenuSett.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Panel 4(pnlMain)");
            }
        });
        btnTestPanel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Panel 20(testPnlEnter)");
            }
        });
        radioBtnBlue.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setColorBlue();
            }
        });
        radioBtnPink.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setColorPink();
            }
        });
        radioBtnBlack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setColorDefault();
            }
        });
        menuGridTestBtn = new JPanel();
        menuGrid.add(btnPrevMenuSett);
        menuGrid.add(new Label(""));
        //menuGrid.add(btnTestPanel);
        menuGrid.add(menuGridTestBtn);

        menuPnl.add(new Label(""));
        menuPnl.add(new Label(""));
        menuPnl.add(new Label(""));
        menuPnl.add(menuGrid);
        pnlSettings.add(soundPnl);
        pnlSettings.add(colorPnl);
        pnlSettings.add(menuPnl);


///////////////////////////////////// Panel 7(pnlRules) ///////////////////////////////////////////
        pnlRules = new JPanel();
        pnlRules.setBorder(BorderFactory.createTitledBorder("Правила"));

        JPanel rulesPnl = new JPanel();
        messageRules = new JLabel("Выбирайте уровень сложности и отгадывайте загадки. Все просто.");
        rulesPnl.setLayout(null);
        messageRules.setBounds(50, 130, 450, 100);
        rulesPnl.add(messageRules);


        JPanel rulesBtn = new JPanel(new GridLayout(1, 3, 0, 0));
        rulesBtn.setPreferredSize(size);
        btnPreviousMenuRules = new JButton("Главное меню");
        btnPreviousMenuRules.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Panel 4(pnlMain)");
            }
        });
        rulesBtn.add(btnPreviousMenuRules);
        rulesBtn.add(new JLabel(""));
        rulesBtn.add(new JLabel(""));

        pnlRules.setLayout(new BorderLayout());
        pnlRules.add(rulesPnl, BorderLayout.CENTER);
        pnlRules.add(rulesBtn, BorderLayout.SOUTH);


///////////////////////////////// Panel 8(pnlStatistics) ///////////////////////////////////////
        pnlStatistics = new JPanel();
        pnlStatistics.setBorder(BorderFactory.createTitledBorder("Статистика"));

        JPanel tablePnl = new JPanel();
        //JLabel info = new JLabel();
        //String text1 = new String("<html>статистика " +
        //        "игроков: <br>сколько попыток было в сумме, " +
        //        "<br>сколько загадок отгадано, <br>сколько " +
        //        "подсказок использовано, <br>сколько чистых отгадываний было - " +
        //        "с первого раза</html>");
        //info.setText(text1);
        //pnlStatistics.add(info);
        //pnlStatistics.add(info, BorderLayout.SOUTH);
        JTable tableStatistics = new JTable();
        tableStatistics.setModel(modelTableStatisticas);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(tableStatistics);
        tablePnl.add(scrollPane);

        JPanel tableBtn = new JPanel(new GridLayout(1, 3, 0, 0));
        btnPreviousMenuStat = new JButton("Главное меню");
        btnPreviousMenuStat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Panel 4(pnlMain)");
            }
        });
        tableBtn.setPreferredSize(size);
        tableBtn.add(btnPreviousMenuStat);
        tableBtn.add(new JLabel(""));
        tableBtn.add(new JLabel(""));

        pnlStatistics.setLayout(new BorderLayout());
        pnlStatistics.add(tablePnl, BorderLayout.CENTER);
        pnlStatistics.add(tableBtn, BorderLayout.SOUTH);

////////////////////////////// Panel 9(pnlEasyRiddles)///////////////////////////////////////
        pnlEasyRiddles = new JPanel();
        pnlEasyRiddles.setBorder(BorderFactory.createTitledBorder("Легкие загадки"));

        JPanel easyRiddles = new JPanel();
        //циклом мы проинициализировали кнопки, добавили к каждой лисенер
// и добавили их к панели , добавили бордер и
// маркер для кнопки выбора загадки(код сократился в несколько раз)
        for (int i = 0; i < sumEasyRddl; i++) {
            btnEasyRiddles[i] = new JButton(i + 1 + "");
            btnEasyRiddles[i].setIcon(iconQuestion);
            btnEasyRiddles[i].setVerticalTextPosition(JButton.TOP);
            btnEasyRiddles[i].setHorizontalTextPosition(JButton.CENTER);
            btnEasyRiddles[i].setFont(numberRiddlesFont);
            easyRiddles.add(btnEasyRiddles[i]);
            final int number = i;
            final int finalBorder = 1 + i;
            btnEasyRiddles[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    infoQuestion.setText(base.questionEasy[number]);
                    answer = base.answerEasy[number];
                    hint = base.hintEasy[number];
                    pnlRiddle.setBorder(BorderFactory.createTitledBorder(
                            BorderFactory.createLineBorder(colorLine),
                            "Легкая загадка № " + finalBorder, TitledBorder.DEFAULT_POSITION,
                            0, titleFont, titleColor));
                    //маркеры уровня и номера загадки
                    markerLevel = 1;
                    markerNumberRiddle = number;
                    cardLayout.show(cardPanel, "Panel 10(pnlRiddle)");
                }
            });
        }
        JPanel gridEasyRiddles = new JPanel(new GridLayout(1, 3, 0, 0));
        btnPreviousMenuEasy = new JButton("Выбор сложности");
        btnPreviousMenuEasy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Panel 5(pnlGameLevel)");
            }
        });
        gridEasyRiddles.setPreferredSize(size);
        gridEasyRiddles.add(btnPreviousMenuEasy);
        gridEasyRiddles.add(new JLabel(""));
        gridEasyRiddles.add(new JLabel(""));

        pnlEasyRiddles.setLayout(new BorderLayout());
        pnlEasyRiddles.add(easyRiddles, BorderLayout.CENTER);
        pnlEasyRiddles.add(gridEasyRiddles, BorderLayout.SOUTH);


////////////////////////////// Panel 11(pnlNormalRiddles)///////////////////////////////////////
        pnlNormalRiddles = new JPanel();
        pnlNormalRiddles.setBorder(BorderFactory.createTitledBorder("Средние загадки"));

        JPanel normalRiddles = new JPanel();
        btnPreviousMenuNormal = new JButton("Выбор сложности");
        //циклом мы проинициализировали кнопки, добавили к каждой лисенер
// и добавили их к панели , добавили бордер и
// маркер для кнопки выбора загадки(код сократился в несколько раз)
        for (int i = 0; i < sumNormRddl; i++) {
            btnNormalRiddles[i] = new JButton(i + 1 + "");
            btnNormalRiddles[i].setIcon(iconQuestion);
            btnNormalRiddles[i].setVerticalTextPosition(JButton.TOP);
            btnNormalRiddles[i].setHorizontalTextPosition(JButton.CENTER);
            btnNormalRiddles[i].setFont(numberRiddlesFont);
            normalRiddles.add(btnNormalRiddles[i]);
            final int number = i;
            final int finalBorder = 1 + i;
            btnNormalRiddles[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    infoQuestion.setText(base.questionNormal[number]);
                    answer = base.answerNormal[number];
                    hint = base.hintNormal[number];
                    pnlRiddle.setBorder(BorderFactory.createTitledBorder(
                            BorderFactory.createLineBorder(colorLine),
                            "Средняя загадка № " + finalBorder, TitledBorder.DEFAULT_POSITION,
                            0, titleFont, titleColor));
                    markerLevel = 2;
                    markerNumberRiddle = number;
                    cardLayout.show(cardPanel, "Panel 10(pnlRiddle)");
                }
            });
        }

        JPanel gridNormalRiddles = new JPanel(new GridLayout(1, 3, 0, 0));
        btnPreviousMenuNormal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Panel 5(pnlGameLevel)");
            }
        });
        gridNormalRiddles.setPreferredSize(size);
        gridNormalRiddles.add(btnPreviousMenuNormal);
        gridNormalRiddles.add(new JLabel(""));
        gridNormalRiddles.add(new JLabel(""));

        pnlNormalRiddles.setLayout(new BorderLayout());
        pnlNormalRiddles.add(normalRiddles, BorderLayout.CENTER);
        pnlNormalRiddles.add(gridNormalRiddles, BorderLayout.SOUTH);


////////////////////////////// Panel 10(pnlRiddle)////////////////////////////////////
        pnlRiddle = new JPanel();

        infoQuestion = new JLabel();
        textInputUser = new JTextField();
        btnEnter = new JButton("Ввод");
        messageRddlUp = new JLabel();
        messageRddlDown = new JLabel("Как вы думаете что это?");
        JButton previousRiddle = new JButton("Предыдущая");
        chooseRiddle = new JButton("Выбор загадки");
        JButton nextRiddle = new JButton("Следующая");
        markerLevel = 0;

        infoQuestion.setBounds(60, 20, 400, 180);
        infoQuestion.setForeground(Color.blue);
        infoQuestion.setFont(fontRiddle);

        textInputUser.setBounds(100, 210, 110, 30);
        btnEnter.setBounds(250, 210, 110, 30);
        messageRddlUp.setBounds(130, 243, 300, 20);
        messageRddlDown.setBounds(130, 250, 300, 90);
        previousRiddle.setBounds(10, 330, 150, 30);
        chooseRiddle.setBounds(160, 330, 150, 30);
        nextRiddle.setBounds(310, 330, 150, 30);

        btnEnter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                systemQuestionAnswerAnswer();
            }
        });
        chooseRiddle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //запись в статистику происходит только если была попытка отгадывания
                if (counterTryRiddle > 0) {
                    updateUserBD();
                }
                //при уходе с панели обнуляются некоторые елементы
                textInputUser.setText(null);
                messageRddlUp.setText(null);
                messageRddlDown.setText("Как вы думаете что это?");
                counterTryRiddle = 0;
                counterTryRddlHints = 0;
                if (markerLevel == 2) {
                    cardLayout.show(cardPanel, "Panel 11(pnlNormalRiddles)");
                } else {
                    cardLayout.show(cardPanel, "Panel 9(pnlEasyRiddles)");
                }
            }
        });
        pnlRiddle.setLayout(null);
        pnlRiddle.add(infoQuestion);
        pnlRiddle.add(textInputUser);
        pnlRiddle.add(btnEnter);
        pnlRiddle.add(messageRddlUp);
        pnlRiddle.add(messageRddlDown);
        //riddlePanel.add(previousRiddle);
        pnlRiddle.add(chooseRiddle);
        //riddlePanel.add(nextRiddle);


////////////////////////////////// Panel 20(testPnlEnter) ////////////////////////////////////////
        JPanel testPnlEnter = new JPanel(new GridLayout(7, 1, 0, 0));
        JButton btnTestRiddles1 = new JButton("test riddles");
        JButton btnTestTableLoginsPass = new JButton("таблица ЛогПасс");
        JButton btnTestTableSaves = new JButton("таблица Сохранения");
        JButton btnTestKnopki = new JButton("test knopki");
        JButton btnTestMainMenu = new JButton("главное меню");
        JButton btnCRUDtable = new JButton("CRUD table");
        btnTestRiddles1.setFont(new Font("Dialog", PLAIN, 20));
        btnTestRiddles1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                question1.setText(base.questionEasy[1]);
                answer1 = base.answerEasy[1];
                hint1 = base.hintEasy[1];
                cardLayout.show(cardPanel, "Panel 8(testPanel)");
                testPanel.setBorder(BorderFactory.createTitledBorder("тест"));
            }
        });

        btnTestTableLoginsPass.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Panel 21(testPnlLoginPass)");
            }
        });
        btnTestTableSaves.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Panel 22(testPnlSaves)");
            }
        });
        btnTestMainMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Panel 4(pnlMain)");
            }
        });

        btnCRUDtable.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Panel 23(testCRUDtables)");
            }
        });
        btnTestKnopki.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Panel 24(testButtonPanel)");
                testButtonPanel.setBorder(BorderFactory.createTitledBorder("тест knopki"));

            }
        });
        testPnlEnter.add(btnTestRiddles1);
        testPnlEnter.add(btnTestKnopki);
        testPnlEnter.add(btnTestTableLoginsPass);
        testPnlEnter.add(btnTestTableSaves);
        testPnlEnter.add(btnCRUDtable);
        testPnlEnter.add(new JLabel(""));
        testPnlEnter.add(btnTestMainMenu);


        ///////////////////////////////// Panel 21(testPnlLoginPass) ///////////////////////////////////////
        JPanel testPnlLoginPass = new JPanel();

        JButton btnTestMenu = new JButton("test меню");
        //pnlStatistics.setLayout(null);
        btnTestMenu.setBounds(10, 330, 150, 30);
        btnTestMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Panel 20(testPnlEnter)");
            }
        });
        testPnlLoginPass.add(btnTestMenu);
        testPnlLoginPass.setBorder(BorderFactory.createTitledBorder("логины пароли"));
        //JLabel info = new JLabel();
        //String text1 = new String("<html>статистика " +
        //        "игроков: <br>сколько попыток было в сумме, " +
        //        "<br>сколько загадок отгадано, <br>сколько " +
        //        "подсказок использовано, <br>сколько чистых отгадываний было - " +
        //        "с первого раза</html>");
        //info.setText(text1);
        //pnlStatistics.add(info);

        //pnlStatistics.add(info, BorderLayout.SOUTH);
        JTable tableLoginPasswords = new JTable();
        tableLoginPasswords.setModel(modelTableUser);
        JScrollPane scrollPaneTest = new JScrollPane();
        scrollPaneTest.setViewportView(tableLoginPasswords);
        testPnlLoginPass.add(scrollPaneTest);


        ///////////////////////////////// Panel 22(testPnlSaves) ///////////////////////////////////////
        JPanel testPnlSaves = new JPanel();

        JButton btnTestMenuSave = new JButton("test меню");
        //pnlStatistics.setLayout(null);
        btnTestMenuSave.setBounds(10, 330, 150, 30);
        btnTestMenuSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Panel 20(testPnlEnter)");
            }
        });
        testPnlSaves.add(btnTestMenuSave);
        testPnlSaves.setBorder(BorderFactory.createTitledBorder("сохранения"));

        JTable tableSaves = new JTable();
        tableSaves.setModel(modelTableSave);
        JScrollPane scrollPaneTestSave = new JScrollPane();
        scrollPaneTestSave.setViewportView(tableSaves);
        testPnlSaves.add(scrollPaneTestSave);


////////////////////////////////// Panel 23(testCRUDtables) ////////////////////////////////////////
        JPanel testCRUDtables = new JPanel(new GridLayout(4, 2, 0, 0));
        JButton btnDeleteTableUSERS = new JButton("Delete Table USERS");
        JButton btnDeleteTableSTATISTICS = new JButton("Delete Table STATISTICS");
        JButton btnDeleteTableSAVES = new JButton("Delete Table SAVES");
        JButton btnCreateTableUSERS = new JButton("Create Table USERS");
        JButton btnCreateTableSTATISTICS = new JButton("Create Table STATISTICS");
        JButton btnCreateTableSAVES = new JButton("Create Table SAVES");

        JButton btnPreviousTestMenu = new JButton("предыдущее меню");
        btnCreateTableUSERS.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                daoUSERS.createTableUsers();
            }
        });
        btnDeleteTableUSERS.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                daoUSERS.deleteTableUsers();
            }
        });
        btnCreateTableSAVES.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                daoSAVES.createTableSaves();
            }
        });
        btnDeleteTableSAVES.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                daoSAVES.deleteTableSaves();
            }
        });
        btnCreateTableSTATISTICS.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                daoSTATISTICS.createTable();
            }
        });
        btnDeleteTableSTATISTICS.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                daoSTATISTICS.deleteTableStatistics();
            }
        });
        btnPreviousTestMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Panel 20(testPnlEnter)");
            }
        });

        testCRUDtables.add(btnCreateTableUSERS);
        testCRUDtables.add(btnDeleteTableUSERS);
        testCRUDtables.add(btnCreateTableSTATISTICS);
        testCRUDtables.add(btnDeleteTableSTATISTICS);
        testCRUDtables.add(btnCreateTableSAVES);
        testCRUDtables.add(btnDeleteTableSAVES);
        testCRUDtables.add(btnPreviousTestMenu);


////////////////////////////////// Panel 8(testPanel) ////////////////////////////////////////
        testPanel = new JPanel();

        //id1 = 0;
        counterTryRiddle = 0;
        counterTryRddlHints = 0;
        //оздаем текстовое поле со счетчиками с мониторингом
        //JTextArea testScore = new JTextArea(5 ,10);
        //testScore.setText(idTemporary + loginTemporary +
        //        sumNegativeCounterTryTemporary + winsTemporary + hintsTemporary + flawlessWinsTemporary);
        //testScore.setLineWrap(true);
        //testScore.setWrapStyleWord(true);
        //testScore.setBounds(5, 5, 100, 100);
        //testPanel.add(new JScrollPane(testScore));

        question1 = new JLabel();
        final JTextField textEnter1 = new JTextField();
        JButton check1 = new JButton("Ввод");
        final JLabel copyTextEnter1 = new JLabel();
        final JLabel message1 = new JLabel("Как вы думаете что это?");

        JButton previousRiddle1 = new JButton("Предыдущая");
        JButton chooseRiddle1 = new JButton("Выбор загадки");
        JButton nextRiddle1 = new JButton("Следующая");

        question1.setBounds(60, 20, 400, 180);
        question1.setForeground(Color.blue);
        question1.setFont(fontRiddle);
//кнопка для проверки счетчиков
        testCounters = new JLabel("id=" + idTemporary + " login=" + loginTemporary +
                " snct=" + sumNegativeCounterTryTemporary + " wins=" + winsTemporary +
                " hints=" + hintsTemporary + " fWins=" + flawlessWinsTemporary +
                " cntrTryRiddle=" + counterTryRiddle +
                " cntrTryRddlHints=" + counterTryRddlHints);
        testCounters.setBounds(1, 1, 500, 50);
        testPanel.add(testCounters);

        textEnter1.setBounds(100, 210, 110, 30);
        check1.setBounds(250, 210, 110, 30);
        copyTextEnter1.setBounds(130, 243, 300, 20);
        message1.setBounds(130, 250, 300, 90);
        previousRiddle1.setBounds(10, 330, 150, 30);
        chooseRiddle1.setBounds(160, 330, 150, 30);
        nextRiddle1.setBounds(310, 330, 150, 30);
        check1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

//блок отгаданного слова
                if (textEnter1.getText().equalsIgnoreCase(answer1)) {
                    if (counterTryRiddle == 0) {
                        message1.setText("<html>" + messageBasa.complimentFirst() +
                                ".<br>Вы отгадали. Это " + answer1 + ".</html>");
                        flawlessWinsTemporary = flawlessWinsTemporary + 1;
                    } else {
                        message1.setText("<html>" + messageBasa.complimentSecond() +
                                ".<br>Вы отгадали. Это " + answer1 + ".</html>");
                    }
                    winsTemporary = winsTemporary + 1;
                    sumNegativeCounterTryTemporary = sumNegativeCounterTryTemporary + 1;
                    counterTryRiddle = counterTryRiddle + 1;

                    //добавить вывод колва попыток.
                    // вполне сделать чтобы блок из 3 кнопок исчезал и появлялась картинка ответа
                    //или большая надпись "отгадано\ответ или сейчас сделать чтоб текстентер и чек исчезают
//блок сдаюсь
                } else if (textEnter1.getText().equalsIgnoreCase("сдаюсь")) {
                    message1.setText("Правильный ответ: " + answer1 + ".");

//блок включения подсказок

                } else if (counterTryRiddle == 1 || counterTryRiddle == 3 ||
                        counterTryRiddle == 6 || counterTryRiddle == 10) {
                    counterTryRiddle = counterTryRiddle + 1;
                    sumNegativeCounterTryTemporary = sumNegativeCounterTryTemporary + 1;
                    message1.setText("<html>" + messageBasa.wrongAnswer() +
                            "<br>Если хотите подсказку, " +
                            "введите: (да) или (д) <br>или (подсказка). " +
                            "Либо просто продолжайте отгадывать.</html>");

                    // <br>Если хотите подсказку, введите: (да) или (д) <br>или (подсказка). "Если хотите
                    // проверить <br>себя и подумать еще, то введите: (нет) или (н).</html>")

                } else if ((textEnter1.getText().equalsIgnoreCase("да")) ||
                        (textEnter1.getText().equalsIgnoreCase("д")) ||
                        (textEnter1.getText().equalsIgnoreCase("подсказка"))) {
                    if (counterTryRddlHints == 0) {
                        counterTryRddlHints = counterTryRddlHints + 1;
                        message1.setText("<html>Хорошо. Вот " + counterTryRddlHints + " подсказка. " +
                                "<br>В слове " + answer1.length() + " букв.</html>");
                        hintsTemporary = hintsTemporary + 1;
                    } else if (counterTryRddlHints == 1) {
                        counterTryRddlHints = counterTryRddlHints + 1;
                        message1.setText("<html>Держите " + counterTryRddlHints + " подсказку: <br>" + hint1 + "</html>");
                        hintsTemporary = hintsTemporary + 1;
                    } else if (counterTryRddlHints > 1) {
                        message1.setText("К сожалению у вас кончились все подсказки.");
                    }

//блок неотгаданного слова
                } else {
                    message1.setText(messageBasa.wrongAnswer());
                    counterTryRiddle = counterTryRiddle + 1;
                    sumNegativeCounterTryTemporary = sumNegativeCounterTryTemporary + 1;
                }

//блок некорректного ввода символов: повтор слова, нерусские буквы, цифры
                //if (textEnter1.getText().matches("[а-яА-Я]")) ||
                //        (textEnter1.getText().equalsIgnoreCase("н"))) {
                //    message1.setText("Чудесно! Тогда продолжим.");
                //}
                        /*    else {
                            message1.setText("Скорректируйте ответ пожалуйста.");
                        } */

//дублирование ответа после нажатия чек, обнуление поля textEnter
                testCounters.setText("id=" + idTemporary + " login=" + loginTemporary +
                        " snct=" + sumNegativeCounterTryTemporary + " wins=" + winsTemporary +
                        " hints=" + hintsTemporary + " fWins=" + flawlessWinsTemporary +
                        " cntrTryRiddle=" + counterTryRiddle +
                        " cntrTryRddlHints=" + counterTryRddlHints);  // test
                copyTextEnter1.setText("Ваш ответ: " + textEnter1.getText());
                textEnter1.setText(null);
            }
        });

        chooseRiddle1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //запись в статистику происходит только если была попытка отгадывания
                if (counterTryRiddle > 0) {
                    updateUserBD();
                }
                //при уходе с панели загадки обнуляются некоторые елементы
                textEnter1.setText(null);
                copyTextEnter1.setText(null);
                message1.setText("Как вы думаете что это?");
                counterTryRiddle = 0;
                counterTryRddlHints = 0;
                //cardLayout.show(cardPanel, "Panel 6(selectEasyRiddles)");
                cardLayout.show(cardPanel, "Panel 20(testPnlEnter)");
            }
        });
        testPanel.setLayout(null);
        testPanel.add(question1);
        testPanel.add(textEnter1);
        testPanel.add(check1);
        testPanel.add(copyTextEnter1);
        testPanel.add(message1);
        testPanel.add(previousRiddle1);
        testPanel.add(chooseRiddle1);
        testPanel.add(nextRiddle1);


//////////////////////////////////////testovaia panel/////////////////////////////////////
        //тест настроек
        testButtonPanel = new JPanel();

        testButtonPanel.setBorder(BorderFactory.createTitledBorder("Игра"));


        JPanel panelOther = new JPanel();
        BoxLayout boxLayout = new BoxLayout(panelOther, Y_AXIS);
        JLabel testmessageGame = new JLabel("Выберите уровень сложности");
        JButton testbtnEasy = new JButton("легкий");
        JButton testbtnMedium = new JButton("средний");
        JButton testbtnHard = new JButton("сложный");
        testmessageGame.setAlignmentX(Component.RIGHT_ALIGNMENT);
        testbtnEasy.setAlignmentX(Component.CENTER_ALIGNMENT);
        testbtnMedium.setAlignmentX(Component.TOP_ALIGNMENT);
        testbtnHard.setAlignmentX(Component.CENTER_ALIGNMENT);
        Icon icon = UIManager.getIcon("OptionPane.questionIcon");
        testbtnHard.setIcon(icon);

        panelOther.setLayout(boxLayout);
        panelOther.add(testmessageGame);
        panelOther.add(testbtnEasy);
        panelOther.add(testbtnMedium);
        panelOther.add(testbtnHard);



  /*      testbtnEasy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Panel 9(pnlEasyRiddles)");
            }
        });
        testbtnMedium.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Panel 11(pnlNormalRiddles)");
            }
        });

   */


        JPanel panelButton = new JPanel(new GridLayout(1, 3, 0, 0));
        JButton testbtnPreviousMenuLevel = new JButton("Главное меню");
        panelButton.setPreferredSize(size);
        testbtnPreviousMenuLevel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //cardLayout.show(cardPanel, "Panel 4(pnlMain)");
                cardLayout.show(cardPanel, "Panel 6(pnlSettings)"); //test
            }
        });
        panelButton.add(testbtnPreviousMenuLevel);
        panelButton.add(new JLabel(""));
        panelButton.add(new JLabel(""));

        testButtonPanel.setLayout(new BorderLayout());
        testButtonPanel.add(panelOther, BorderLayout.CENTER);
        testButtonPanel.add(panelButton, BorderLayout.SOUTH);


///////////////////////////////////////testovaia меню/////////////////////////////////////
        JPanel testMainPanel = new JPanel();

        grid = new GridLayout(6, 0, 50, 30);
        JButton btnGame = new JButton("Игра");
        JButton btnAuto = new JButton("Авторизация");
        JButton btnSettings = new JButton("Настройки");
        JButton btnRules = new JButton("Правила");
        JButton btnStatistics = new JButton("Статистика");
        JButton btnExit = new JButton("Выход");
        btnGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Panel 4(pnlMain)");
            }
        });
        btnAuto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Panel 1(pnlAuthorization)");
            }
        });
        btnSettings.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Panel 4");
            }
        });
        btnRules.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Panel 5");
            }
        });
        btnStatistics.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Panel 9(statistics)");
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
        testMainPanel.setLayout(grid);
        testMainPanel.add(btnGame);
        testMainPanel.add(btnAuto);
        testMainPanel.add(btnSettings);
        testMainPanel.add(btnRules);
        testMainPanel.add(btnStatistics);
        testMainPanel.add(btnExit);


        //добавление страниц-панелей в главную панель
        cardPanel.add(pnlLogin, "Panel 1(pnlLogin)");
        cardPanel.add(pnlAuthorization, "Panel 2(pnlAuthorization)");
        cardPanel.add(pnlWelcome, "Panel 3(pnlWelcome)");
        cardPanel.add(pnlMain, "Panel 4(pnlMain)");
        cardPanel.add(pnlGameLevel, "Panel 5(pnlGameLevel)");
        cardPanel.add(pnlSettings, "Panel 6(pnlSettings)");
        cardPanel.add(pnlRules, "Panel 7(pnlRules)");
        cardPanel.add(pnlStatistics, "Panel 8(pnlStatistics)");
        cardPanel.add(pnlEasyRiddles, "Panel 9(pnlEasyRiddles)");
        cardPanel.add(pnlRiddle, "Panel 10(pnlRiddle)");
        cardPanel.add(pnlNormalRiddles, "Panel 11(pnlNormalRiddles)");

        cardPanel.add(testPnlEnter, "Panel 20(testPnlEnter)");
        cardPanel.add(testPnlLoginPass, "Panel 21(testPnlLoginPass)");
        cardPanel.add(testPnlSaves, "Panel 22(testPnlSaves)");
        cardPanel.add(testCRUDtables, "Panel 23(testCRUDtables)");
        cardPanel.add(testPanel, "Panel 8(testPanel)");
        cardPanel.add(testButtonPanel, "Panel 24(testButtonPanel)");

        //слева панель тестовая главная, по центру панель кард в которой другие панели
        //getContentPane().add(testMainPanel, BorderLayout.WEST);
        getContentPane().add(cardPanel, BorderLayout.CENTER);
    }


    //система входа уже зарегистрированных пользователей
    private void loginSystem() {
        String loginViewUi = textLoginInputLogin.getText();
        String passViewUi = textPassInputLogin.getText();
        User userMain = new User();
        //временно пароль для программиста
        if (loginViewUi.equalsIgnoreCase("p") &&
                passViewUi.equalsIgnoreCase("p")) {
            menuGridTestBtn.add(btnTestPanel);
            cardLayout.show(cardPanel, "Panel 20(testPnlEnter)");
        }
        //System.out.println("testMenu loginViewUi = " + loginViewUi);   //тест
        //отправка запроса в бд есть ли такой ник.
        String loginViewBD = daoUSERS.searchLogin(loginViewUi);
        //System.out.println("UI = " + loginViewBD);   //тест
        //и если возвращаемая переменная не нулл - то вход.
        // если нулл - повторная процедура
        if (loginViewBD != null) {
            User u = new User(
                    textLoginInputLogin.getText(),
                    textPassInputLogin.getText()
            );
            userMain = daoUSERS.getSelectOneRow(u);
            System.out.println(userMain);
            //данные возвращаются либо из таблицы либо вставленные
            //их надо както разделить
            //System.out.println("testMenu перед екуалс: " +
            //         "id = " +u.getUserId() +
            //        "login = " + u.getLogin() +
            //        "pass = " + u.getPassword());   //тест
            //первая проверка на наличие отсутствия результата в бд
            // (обычно если результата нет то данные остаются старые и ИД = 0)
            if (u.getUserId() == 0) {
                messageLogin.setText("<html>Пароль неверный. " +
                        "<br>Проверьте и попробуйте снова.</html>");
                //вторая проверка если таблица нашла результат и тогда проверяется уже лог и пасс
            } else if (loginViewUi.equalsIgnoreCase(u.getLogin()) && passViewUi.equalsIgnoreCase(u.getPassword())) {
                System.out.println(loginViewUi + "==" + u.getLogin() + "&&" + passViewUi + "==" + u.getPassword()); //test
                //вызов метода прочтения строки -> забрать строку со статистикой - передать
                //забор статистики юзера через запрос по ИД
                Statisticas s = new Statisticas(u.getUserId());
                //Statisticas s = new Statisticas(u.getUserId());
                System.out.println("test menu после проверки на пароль и логин = " + s);   //тест
                userStatistics = daoSTATISTICS.getSelectOneRow2(s);
                Save sv = new Save(u.getUserId());
                userProgress = daoSAVES.getSelectOneRow(sv);
                //System.out.println("oneRowStatistics = " + userStatistics);   //тест
                setUserStaticticsForGAME();
                setWelcomeLogin();
                cardLayout.show(cardPanel, "Panel 3(pnlWelcome)");
            } else {
                messageLogin.setText("<html>Пароль неверный. " +
                        "<br>Проверьте и попробуйте снова.</html>");
            }
        } else {
            messageLogin.setText("<html>Пользователя с таким " +
                    "именем не существует. <br>Попробуйте другое " +
                    "имя или зарегистрируйтесь.</html>");
        }
        setCleanFields();
    }


    //вставка данных в бд и таблицу
    private void insertIntoBdTables() {
        String loginViewUi = textLoginInput.getText();
        //проверка на пустую строку
        if (loginViewUi.equalsIgnoreCase("")) {
            messageSystem.setText("Заполните пожалуйста поле.");
        } else {
            //отправка запроса в бд есть ли такой ник.
            String loginViewBD = daoUSERS.searchLogin(loginViewUi);
            //System.out.println("UI = " + loginViewBD);   //тест
            //и если возвращаемая переменная нулл - регистрация.
            // если не нулл - повторная процедура
            if (loginViewBD == null) {
                //заполнение полей главной таблицы БД ЮЗЕР
                User u = new User(
                        textLoginInput.getText(),
                        textPassInput.getText()
                );
                modelTableUser.insertTableBd(u);
                //надо выдернуть из дао юзер ид и передать ид в дао стат во второстепенный ключ
                daoUSERS.getSelectOneRow(u);
                //System.out.println("в тестменю ЛОГИН и ИД из ДАО -" + u.getLogin() + " " + u.getUserId()); //test
                //заполнение полей БД таблицы СТАТИСТИКА
                Statisticas s = new Statisticas(
                        u.getLogin(),
                        0,
                        0,
                        0,
                        0,
                        u.getUserId()
                );
                //System.out.println("в тестменю отправка статистики для заполнения bd STATISTICS -" +
                //        s.getLogin() + s.getSumTry() + s.getWin() + s.getHint() + s.getFlawlessWin() + s.getUserId()); //test
                modelTableStatisticas.insertTableBd(s);
//заполение полей БД таблицы СОХРАНЕНИЯ
                String easyR = new String("ooooooooooooooo");
                String normalR = new String("ooooooooooooooo");
                String hardR = new String("ooooooooooooooo");
                Save sv = new Save(
                        u.getUserId(),
                        u.getLogin(),
                        easyR,
                       normalR,
                        hardR
                );
                modelTableSave.insertTableBd(sv);
                userProgress = sv;
                System.out.println(normalProgress); //test

                userStatistics = s;
                setUserStaticticsForGAME();
                messageSystem.setText("Вы зарегистрированы.");
                setWelcomeLogin();
                cardLayout.show(cardPanel, "Panel 3(pnlWelcome)");
            } else {
                messageSystem.setText("Пользователь с таким " +
                        "именем уже зарегистрирован. Попробуйте другое имя.");
            }
        }
        setCleanFields();
    }


    //система взаимодействия ответов игры и пользователя
    private void systemQuestionAnswerAnswer() {
        //блок отгаданного слова
        if (textInputUser.getText().equalsIgnoreCase(answer)) {
            if (counterTryRiddle == 0) {
                messageRddlDown.setText("<html>" + messageBasa.complimentFirst() +
                        ".<br>Вы отгадали. Это " + answer + ".</html>");
                flawlessWinsTemporary = flawlessWinsTemporary + 1;
            } else {
                messageRddlDown.setText("<html>" + messageBasa.complimentSecond() +
                        ".<br>Вы отгадали. Это " + answer + ".</html>");
            }
            winsTemporary = winsTemporary + 1;
            sumNegativeCounterTryTemporary = sumNegativeCounterTryTemporary + 1;
            counterTryRiddle = counterTryRiddle + 1;
            setAnswerIcon();
            //добавить вывод колва попыток.
            // вполне сделать чтобы блок из 3 кнопок исчезал и появлялась картинка ответа
            //или большая надпись "отгадано\ответ или сейчас сделать чтоб текстентер и чек исчезают

            //блок сдаюсь
        } else if (textInputUser.getText().equalsIgnoreCase("сдаюсь")) {
            messageRddlDown.setText("Правильный ответ: " + answer + ".");

//блок включения подсказок
        } else if (counterTryRiddle == 1 || counterTryRiddle == 3 ||
                counterTryRiddle == 6 || counterTryRiddle == 10) {
            counterTryRiddle = counterTryRiddle + 1;
            sumNegativeCounterTryTemporary = sumNegativeCounterTryTemporary + 1;
            messageRddlDown.setText("<html>" + messageBasa.wrongAnswer() +
                    "<br>Если хотите подсказку, " +
                    "введите: (да) или (д) <br>или (подсказка). " +
                    "Либо просто продолжайте отгадывать.</html>");
        } else if ((textInputUser.getText().equalsIgnoreCase("да")) ||
                (textInputUser.getText().equalsIgnoreCase("д")) ||
                (textInputUser.getText().equalsIgnoreCase("подсказка"))) {
            if (counterTryRddlHints == 0) {
                counterTryRddlHints = counterTryRddlHints + 1;
                messageRddlDown.setText("<html>Хорошо. Вот " + counterTryRddlHints + " подсказка. " +
                        "<br>В слове " + answer.length() + " букв.</html>");
                hintsTemporary = hintsTemporary + 1;
            } else if (counterTryRddlHints == 1) {
                counterTryRddlHints = counterTryRddlHints + 1;
                messageRddlDown.setText("<html>Держите " + counterTryRddlHints + " подсказку: <br>" + hint + "</html>");
                hintsTemporary = hintsTemporary + 1;
            } else if (counterTryRddlHints > 1) {
                messageRddlDown.setText("К сожалению у вас кончились все подсказки.");
            }

            //блок неотгаданного слова
        } else {
            messageRddlDown.setText(messageBasa.wrongAnswer());
            counterTryRiddle = counterTryRiddle + 1;
            sumNegativeCounterTryTemporary = sumNegativeCounterTryTemporary + 1;
        }
        //дублирование ответа после нажатия чек, обнуление поля textEnter
        testCounters.setText("id=" + idTemporary + " login=" + loginTemporary +
                " snct=" + sumNegativeCounterTryTemporary + " wins=" + winsTemporary +
                " hints=" + hintsTemporary + " fWins=" + flawlessWinsTemporary +
                " cntrTryRiddle=" + counterTryRiddle +
                " cntrTryRddlHints=" + counterTryRddlHints);  // test
        messageRddlUp.setText("Ваш ответ: " + textInputUser.getText());
        textInputUser.setText(null);
    }


    //установка счетчиков игрока на нужную статистику
    public void setUserStaticticsForGAME() {
        System.out.println("id=" + idTemporary + " login=" + loginTemporary +
                " snct=" + sumNegativeCounterTryTemporary + " wins=" + winsTemporary +
                " hints=" + hintsTemporary + " fWins=" + flawlessWinsTemporary +
                " cntrTryRiddle=" + counterTryRiddle +
                " cntrTryRddlHints=" + counterTryRddlHints + " idTemporaryUser=" + idTemporaryUser); //тест
        idTemporary = userStatistics.getStatisticasId();
        loginTemporary = userStatistics.getLogin();
        sumNegativeCounterTryTemporary = userStatistics.getSumTry();
        winsTemporary = userStatistics.getWin();
        hintsTemporary = userStatistics.getHint();
        flawlessWinsTemporary = userStatistics.getFlawlessWin();
        idTemporaryUser = userStatistics.getUserId();

        easyProgress = userProgress.getEasyRiddles();
        normalProgress = userProgress.getNormalRiddles();
        hardProgress = userProgress.getHardRiddles();

        setUserProgress();
        System.out.println("id=" + idTemporary + " login=" + loginTemporary +
                " snct=" + sumNegativeCounterTryTemporary + " wins=" + winsTemporary +
                " hints=" + hintsTemporary + " fWins=" + flawlessWinsTemporary +
                " cntrTryRiddle=" + counterTryRiddle +
                " cntrTryRddlHints=" + counterTryRddlHints + " idTemporaryUser=" + idTemporaryUser); //тест
    }

    //присваивание и отправка данных в таблицу и бд
    public void updateUserBD() {
        userStatistics = new Statisticas(
                loginTemporary,
                sumNegativeCounterTryTemporary,
                winsTemporary,
                hintsTemporary,
                flawlessWinsTemporary,
                idTemporaryUser);
        modelTableStatisticas.updateTableBd(userStatistics);

        userProgress = new Save(
                idTemporaryUser,
                loginTemporary,
                easyProgress,
                normalProgress,
                hardProgress
        );
        modelTableSave.updateTableBd(userProgress);
    }


    //чистильщик полей
    private void setCleanFields() {
        textLoginInputLogin.setText("");
        textPassInputLogin.setText("");
        textLoginInput.setText("");
        textPassInput.setText("");
    }


    private void setWelcomeLogin() {
        infoUserName.setText(userStatistics.getLogin());
    }


    private void setColorBlue() {
        colorLine = colorBlue;
        titleColor = colorBlue;
        testButtonPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(colorBlue),
                "тест knopki", TitledBorder.DEFAULT_POSITION,
                0, titleFont, colorBlue));
        pnlLogin.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(colorBlue),
                "Вход", TitledBorder.DEFAULT_POSITION,
                0, titleFont, colorBlue));
        pnlAuthorization.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(colorBlue),
                "Регистрация", TitledBorder.DEFAULT_POSITION,
                0, titleFont, colorBlue));
        pnlWelcome.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(colorBlue),
                "Инфо", TitledBorder.DEFAULT_POSITION,
                0, titleFont, colorBlue));
        pnlMain.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(colorBlue),
                "Главное меню", TitledBorder.DEFAULT_POSITION,
                0, titleFont, colorBlue));
        pnlGameLevel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(colorBlue),
                "Игра", TitledBorder.DEFAULT_POSITION,
                0, titleFont, colorBlue));
        pnlSettings.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(colorBlue),
                "Настройки", TitledBorder.DEFAULT_POSITION,
                0, titleFont, colorBlue));
        pnlRules.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(colorBlue),
                "Правила", TitledBorder.DEFAULT_POSITION,
                0, titleFont, colorBlue));
        pnlStatistics.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(colorBlue),
                "Статистика", TitledBorder.DEFAULT_POSITION,
                0, titleFont, colorBlue));
        pnlEasyRiddles.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(colorBlue),
                "Легкие загадки", TitledBorder.DEFAULT_POSITION,
                0, titleFont, colorBlue));
        pnlNormalRiddles.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(colorBlue),
                "Средние загадки", TitledBorder.DEFAULT_POSITION,
                0, titleFont, colorBlue));
        //infoColor.setForeground(colorBlue);
        btnClearFieldL.setForeground(colorBlue);
        infoLoginL.setForeground(colorBlue);
        infoPasswordL.setForeground(colorBlue);
        infoLogin.setForeground(colorBlue);
        infoPassword.setForeground(colorBlue);
        textLoginInputLogin.setForeground(colorBlue);
        textPassInputLogin.setForeground(colorBlue);
        btnEnterLogin.setForeground(colorBlue);
        btnPreviousMenuLog.setForeground(colorBlue);
        btnClearField.setForeground(colorBlue);
        btnPnlAuthoriz.setForeground(colorBlue);
        messageLogin.setForeground(colorBlue);
        textLoginInput.setForeground(colorBlue);
        textPassInput.setForeground(colorBlue);
        enterData.setForeground(colorBlue);
        btnPnlLogin.setForeground(colorBlue);
        messageSystem.setForeground(colorBlue);
        infoWelcomeUp.setForeground(colorBlue);
        infoUserName.setForeground(colorBlue);
        infoWelcomeDown.setForeground(colorBlue);
        btnWelcomeNext.setForeground(colorBlue);
        btnGameMain.setForeground(colorBlue);
        btnAutoMain.setForeground(colorBlue);
        btnSettMain.setForeground(colorBlue);
        btnRulesMain.setForeground(colorBlue);
        btnStatMain.setForeground(colorBlue);
        btnExitMain.setForeground(colorBlue);
        messageGame.setForeground(colorBlue);
        btnEasy.setForeground(colorBlue);
        btnMedium.setForeground(colorBlue);
        btnHard.setForeground(colorBlue);
        btnPreviousMenuLevel.setForeground(colorBlue);

        infoSound.setForeground(colorBlue);


        btnSoundOn.setForeground(colorBlue);
        btnSoundOff.setForeground(colorBlue);
        infoColor.setForeground(colorBlue);
        btnPrevMenuSett.setForeground(colorBlue);
        btnTestPanel.setForeground(colorBlue);


        //infoSkin.setForeground(colorBlue);
        //btnTestPanelTime.setForeground(colorBlue);
        //btnPreviousMenuSett.setForeground(colorBlue);
        messageRules.setForeground(colorBlue);
        btnPreviousMenuRules.setForeground(colorBlue);
        btnPreviousMenuStat.setForeground(colorBlue);
        for (int i = 0; i < sumEasyRddl; i++) {
            btnEasyRiddles[i].setForeground(colorBlue);
        }
        btnPreviousMenuEasy.setForeground(colorBlue);
        for (int i = 0; i < sumNormRddl; i++) {
            btnNormalRiddles[i].setForeground(colorBlue);
        }
        btnPreviousMenuNormal.setForeground(colorBlue);
        infoQuestion.setForeground(colorBlue);
        textInputUser.setForeground(colorBlue);
        btnEnter.setForeground(colorBlue);
        chooseRiddle.setForeground(colorBlue);
        messageRddlUp.setForeground(colorBlue);
        messageRddlDown.setForeground(colorBlue);
    }


    private void setColorPink() {
        colorLine = colorPink;
        titleColor = colorPink;
        testButtonPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(colorPink),
                "тест knopki", TitledBorder.DEFAULT_POSITION,
                0, titleFont, colorPink));
        pnlLogin.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(colorPink),
                "Вход", TitledBorder.DEFAULT_POSITION,
                0, titleFont, colorPink));
        pnlAuthorization.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(colorPink),
                "Регистрация", TitledBorder.DEFAULT_POSITION,
                0, titleFont, colorPink));
        pnlWelcome.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(colorPink),
                "Инфо", TitledBorder.DEFAULT_POSITION,
                0, titleFont, colorPink));
        pnlMain.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(colorPink),
                "Главное меню", TitledBorder.DEFAULT_POSITION,
                0, titleFont, colorPink));
        pnlGameLevel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(colorPink),
                "Игра", TitledBorder.DEFAULT_POSITION,
                0, titleFont, colorPink));
        pnlSettings.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(colorPink),
                "Настройки", TitledBorder.DEFAULT_POSITION,
                0, titleFont, colorPink));
        pnlRules.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(colorPink),
                "Правила", TitledBorder.DEFAULT_POSITION,
                0, titleFont, colorPink));
        pnlStatistics.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(colorPink),
                "Статистика", TitledBorder.DEFAULT_POSITION,
                0, titleFont, colorPink));
        pnlEasyRiddles.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(colorPink),
                "Легкие загадки", TitledBorder.DEFAULT_POSITION,
                0, titleFont, colorPink));
        pnlNormalRiddles.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(colorPink),
                "Средние загадки", TitledBorder.DEFAULT_POSITION,
                0, titleFont, colorPink));
        //infoColor.setForeground(colorPink);
        btnClearFieldL.setForeground(colorPink);
        btnClearField.setForeground(colorPink);
        infoLoginL.setForeground(colorPink);
        infoPasswordL.setForeground(colorPink);
        infoLogin.setForeground(colorPink);
        infoPassword.setForeground(colorPink);
        textLoginInputLogin.setForeground(colorPink);
        textPassInputLogin.setForeground(colorPink);
        btnEnterLogin.setForeground(colorPink);
        btnPreviousMenuLog.setForeground(colorPink);
        btnPnlAuthoriz.setForeground(colorPink);
        messageLogin.setForeground(colorPink);
        textLoginInput.setForeground(colorPink);
        textPassInput.setForeground(colorPink);
        enterData.setForeground(colorPink);
        btnPnlLogin.setForeground(colorPink);
        messageSystem.setForeground(colorPink);
        infoWelcomeUp.setForeground(colorPink);
        infoUserName.setForeground(colorPink);
        infoWelcomeDown.setForeground(colorPink);
        btnWelcomeNext.setForeground(colorPink);
        btnGameMain.setForeground(colorPink);
        btnAutoMain.setForeground(colorPink);
        btnSettMain.setForeground(colorPink);
        btnRulesMain.setForeground(colorPink);
        btnStatMain.setForeground(colorPink);
        btnExitMain.setForeground(colorPink);
        messageGame.setForeground(colorPink);
        btnEasy.setForeground(colorPink);
        btnMedium.setForeground(colorPink);
        btnHard.setForeground(colorPink);
        btnPreviousMenuLevel.setForeground(colorPink);
        infoSound.setForeground(colorPink);


        btnSoundOn.setForeground(colorPink);
        btnSoundOff.setForeground(colorPink);
        infoColor.setForeground(colorPink);
        btnPrevMenuSett.setForeground(colorPink);
        btnTestPanel.setForeground(colorPink);
        //btnTestPanelTime.setForeground(colorPink);
        //btnPreviousMenuSett.setForeground(colorPink);
        messageRules.setForeground(colorPink);
        btnPreviousMenuRules.setForeground(colorPink);
        btnPreviousMenuStat.setForeground(colorPink);
        for (int i = 0; i < sumEasyRddl; i++) {
            btnEasyRiddles[i].setForeground(colorPink);
        }
        btnPreviousMenuEasy.setForeground(colorPink);
        for (int i = 0; i < sumNormRddl; i++) {
            btnNormalRiddles[i].setForeground(colorPink);
        }
        btnPreviousMenuNormal.setForeground(colorPink);
        infoQuestion.setForeground(colorPink);
        textInputUser.setForeground(colorPink);
        btnEnter.setForeground(colorPink);
        chooseRiddle.setForeground(colorPink);
        messageRddlUp.setForeground(colorPink);
        messageRddlDown.setForeground(colorPink);
    }


    private void setColorDefault() {
        colorLine = colorLineDefault;
        titleColor = colorBlack;
        testButtonPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(colorLineDefault),
                "тест knopki", TitledBorder.DEFAULT_POSITION,
                0, titleFont, colorBlack));
        pnlLogin.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(colorLineDefault),
                "Вход", TitledBorder.DEFAULT_POSITION,
                0, titleFont, colorBlack));
        pnlAuthorization.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(colorLineDefault),
                "Регистрация", TitledBorder.DEFAULT_POSITION,
                0, titleFont, colorBlack));
        pnlWelcome.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(colorLineDefault),
                "Инфо", TitledBorder.DEFAULT_POSITION,
                0, titleFont, colorBlack));
        pnlMain.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(colorLineDefault),
                "Главное меню", TitledBorder.DEFAULT_POSITION,
                0, titleFont, colorBlack));
        pnlGameLevel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(colorLineDefault),
                "Игра", TitledBorder.DEFAULT_POSITION,
                0, titleFont, colorBlack));
        pnlSettings.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(colorLineDefault),
                "Настройки", TitledBorder.DEFAULT_POSITION,
                0, titleFont, colorBlack));
        pnlRules.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(colorLineDefault),
                "Правила", TitledBorder.DEFAULT_POSITION,
                0, titleFont, colorBlack));
        pnlStatistics.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(colorLineDefault),
                "Статистика", TitledBorder.DEFAULT_POSITION,
                0, titleFont, colorBlack));
        pnlEasyRiddles.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(colorLineDefault),
                "Легкие загадки", TitledBorder.DEFAULT_POSITION,
                0, titleFont, colorBlack));
        pnlNormalRiddles.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(colorLineDefault),
                "Средние загадки", TitledBorder.DEFAULT_POSITION,
                0, titleFont, colorBlack));
        //infoColor.setForeground(colorBlack);
        btnClearFieldL.setForeground(colorBlack);
        btnClearField.setForeground(colorBlack);
        infoLoginL.setForeground(colorBlack);
        infoPasswordL.setForeground(colorBlack);
        infoLogin.setForeground(colorBlack);
        infoPassword.setForeground(colorBlack);
        textLoginInputLogin.setForeground(colorBlack);
        textPassInputLogin.setForeground(colorBlack);
        btnEnterLogin.setForeground(colorBlack);
        btnPreviousMenuLog.setForeground(colorBlack);
        btnPnlAuthoriz.setForeground(colorBlack);
        messageLogin.setForeground(colorBlack);
        textLoginInput.setForeground(colorBlack);
        textPassInput.setForeground(colorBlack);
        enterData.setForeground(colorBlack);
        btnPnlLogin.setForeground(colorBlack);
        messageSystem.setForeground(colorBlack);
        infoWelcomeUp.setForeground(colorBlack);
        infoUserName.setForeground(colorBlack);
        infoWelcomeDown.setForeground(colorBlack);
        btnWelcomeNext.setForeground(colorBlack);
        btnGameMain.setForeground(colorBlack);
        btnAutoMain.setForeground(colorBlack);
        btnSettMain.setForeground(colorBlack);
        btnRulesMain.setForeground(colorBlack);
        btnStatMain.setForeground(colorBlack);
        btnExitMain.setForeground(colorBlack);
        messageGame.setForeground(colorBlack);
        btnEasy.setForeground(colorBlack);
        btnMedium.setForeground(colorBlack);
        btnHard.setForeground(colorBlack);
        btnPreviousMenuLevel.setForeground(colorBlack);
        infoSound.setForeground(colorBlack);


        btnSoundOn.setForeground(colorBlack);
        btnSoundOff.setForeground(colorBlack);
        infoColor.setForeground(colorBlack);
        btnPrevMenuSett.setForeground(colorBlack);
        btnTestPanel.setForeground(colorBlack);
        messageRules.setForeground(colorBlack);
        btnPreviousMenuRules.setForeground(colorBlack);
        btnPreviousMenuStat.setForeground(colorBlack);
        for (int i = 0; i < sumEasyRddl; i++) {
            btnEasyRiddles[i].setForeground(colorBlack);
        }
        btnPreviousMenuEasy.setForeground(colorBlack);
        for (int i = 0; i < sumNormRddl; i++) {
            btnNormalRiddles[i].setForeground(colorBlack);
        }
        btnPreviousMenuNormal.setForeground(colorBlack);
        infoQuestion.setForeground(colorBlack);
        textInputUser.setForeground(colorBlack);
        btnEnter.setForeground(colorBlack);
        chooseRiddle.setForeground(colorBlack);
        messageRddlUp.setForeground(colorBlack);
        messageRddlDown.setForeground(colorBlack);
    }


    //установка визуального маркера отгаданной загадки и установка прогресса в переменную.
    // кот мы впоследствии записываем под никнеймом в БД
    private void setAnswerIcon() {
        if (markerLevel == 1) {
            System.out.println("easyProgress до замены - " + easyProgress); //test
            btnEasyRiddles[markerNumberRiddle].setIcon(iconInformation);
            progress = easyProgress;
            easyProgress = changeCharInPosition(markerNumberRiddle, 'I', progress);
            System.out.println("easyProgress после замены - " + easyProgress); //test
        } else {
            btnNormalRiddles[markerNumberRiddle].setIcon(iconInformation);
            progress = normalProgress;
            normalProgress = changeCharInPosition(markerNumberRiddle, 'I', progress);
        }
    }

    public String changeCharInPosition(int markerNumberRiddle, char ch, String progress) {
        char[] charArray = progress.toCharArray();
        charArray[markerNumberRiddle] = ch;
        return new String(charArray);
    }



    private void setUserProgress() {
        String proofRiddle = new String();
        String s = new String();
        for (int i = 0; i < 15; i++) {
            s = easyProgress;
            proofRiddle = readCharInPosition(i, s);
            if (proofRiddle.equalsIgnoreCase("I")) {
                btnEasyRiddles[i].setIcon(iconInformation);
            }
        }

        for (int i = 0; i < 15; i++) {
            s = normalProgress;
            proofRiddle = readCharInPosition(i, s);
            if (proofRiddle.equalsIgnoreCase("I")) {
                btnNormalRiddles[i].setIcon(iconInformation);
            }
        }
    }

    public String readCharInPosition(int i, String s) {
        char[] charArray = s.toCharArray();
        String readSymbol = new String(String.valueOf(charArray[i]));
        return readSymbol;
    }





    /*   /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                AppGUI frame = new AppGUI();
                frame.setVisible(true);
            }
        });
    }


}