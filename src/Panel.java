import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Panel extends JPanel implements ActionListener {

    //razmer paneli
    public static int WIDHT = Toolkit.getDefaultToolkit().getScreenSize().width;
    public static int HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
    //koordinati miwki
    public static int mouseX;
    public static int mouseY;
    //taimer s intervalom vseh sobitii -ms
    Timer mainTimer = new Timer(30, this);
    //dlia zagruzki izobrazenia
    private BufferedImage image;
    private Graphics2D g;
    //aktivnie stranici menu
    public static boolean buttmenue = true;
    public static boolean settmenue = false;
    public static boolean levelmenue = false;
    //spisok knopok
    public ArrayList<SettMenue> buttons;


    //obekti klassov back i player
    Back back = new Back();
    Player player = new Player();
    Menue menue = new Menue();


    public Panel() {
        //konstruktor roditela
        super();
        setFocusable(true); //pereda4a fokusa
        requestFocus(); //aktivacia fokusa
        mainTimer.start();

        //obekt bufera dla hranenia kartinok
        image = new BufferedImage(WIDHT, HEIGHT, BufferedImage.TYPE_INT_RGB);
        //graficeskomu obektu prisvoim element iz bufera
        g = (Graphics2D) image.getGraphics();

        //dobavliaem obrabot4iki sobitii klik miw, klaviaturi, peremewenia miwi
        addMouseListener(new Listeners());
        addKeyListener(new Listeners());
        addMouseMotionListener(new Listeners());

        buttons = new ArrayList<SettMenue>();
        buttons.add(new SettMenue(500, 210, 100, 37, "", "вкл"));
        buttons.add(new SettMenue(650, 210, 100, 37, "", "выкл"));
        buttons.add(new SettMenue(500, 365, 100, 37, "", "стандарт"));
        buttons.add(new SettMenue(650, 365, 100, 37, "", "пользоват"));
        buttons.add(new SettMenue(1250, 20, 100, 37, "", "назад"));
    }


    public static enum STATES {
        MENUE, PLAY, SETTINGS
    }

    public static STATES state = STATES.MENUE;


    //vse cobitia igri
    @Override
    public void actionPerformed(ActionEvent e) {
        if (state.equals(STATES.MENUE)) {
            //otobrazit fon
            back.draw(g);
            if (buttmenue) {
                menue.draw(g); //otobrazit menu
                menue.moveButt(menue.button1);
                menue.moveButt(menue.button2);
                menue.moveButt(menue.button3);
                menue.moveButt(menue.button4);
                menue.moveButt(menue.button5);
            }
            //stranica menu nastroek
            if (settmenue) {
                moveSettButt();
            }
            if(levelmenue){

            }

            gameDraw(); //prorisovat v paneli
        }
        if (state.equals(STATES.PLAY)) {
            gameUpdate();
            gameRender();
            gameDraw();
        }
    }


    //perenesli kod v klass menue
 /*   //popadanie kursora na knopku menu
    private void moveButt (Menue.ButtMenue e){
        if(mouseX>e.getX()&&mouseX<e.getX()+e.getW()&&
        mouseY>e.getY()&&mouseY<e.getY()+e.getH()){
            e.srcImg="image/button1.png";
            if(e.equals(menue.button1)){
                e.nameButt="Игра";
            }
            if(e.equals(menue.button2)){
                e.nameButt="Игра";
                if(Menue.click){
                    state=STATES.PLAY; //perehod v igru
                    Menue.click=false;
                }
            }
            if(e.equals(menue.button3)){
                e.nameButt="Игра";
            }
            if(e.equals(menue.button4)){
                e.nameButt="Игра";
            }
            if(e.equals(menue.button5)){
                e.nameButt="exit";
                if(Menue.click){
                    System.exit(0);
                }
            }
        }
        else{
            e.srcImg="image/button1.png";
            if(e.equals(menue.button1)){
                e.nameButt="Игра";
            }
            if(e.equals(menue.button2)){
                e.nameButt="Игра";
            }
            if(e.equals(menue.button3)){
                e.nameButt="Игра";
            }
            if(e.equals(menue.button4)){
                e.nameButt="Игра";
            }
            if(e.equals(menue.button5)){
                e.nameButt="Игра";
            }
        }

    }*/


    public void moveSettButt() {
        for (int i = 0; i < buttons.size(); i++) {
            buttons.get(i).draw(g);
            if (Panel.mouseX > buttons.get(i).getX() &&
                    Panel.mouseX < buttons.get(i).getX() + buttons.get(i).getW() &&
                    Panel.mouseY > buttons.get(i).getY() &&
                    Panel.mouseY < buttons.get(i).getY() + buttons.get(i).getH()) {
                buttons.get(i).srcImg = "image/button1.png";
            } else {
                buttons.get(i).srcImg = "image/button1.png";
            }
        }
    }


    //risuem v virtualnom okne
    public void gameRender() {
        back.draw(g);
        player.draw(g);
    }


    //obnovlenie
    public void gameUpdate() {
        player.update();
    }


    //perenos izobrazenia na panel
    private void gameDraw() {
        //pereopredelenie G2d na G
        Graphics g2 = this.getGraphics();
        //risuem
        g2.drawImage(image, 0, 0, null);
        //komanda dla uborwika musora
        g2.dispose();
    }



  /*  private boolean left;
    private boolean right;
    private boolean up;
    private boolean down;
    private boolean enter;

    private JButton buttons[] = new JButton[4];
    private Font font = new Font("SanSerif", Font.BOLD, 25);
    private JTextField question = new JTextField();


    public WindowLevel() {


        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(530, 400); // ||(screenSize)
        setLocation(0, 0);
        setResizable(false);
        setVisible(true);





        setBackground(Color.PINK);
        setLayout(null); //размещение кнопок как нам хочется

        question = new JTextField("Выберите уровень сложности загадок пожалуйста.");
        question.setBounds(10, 10, 500, 50);
        question.setEditable(false);
        question.setBackground(Color.pink);
        add(question);

        buttons[0] = new JButton("- оооочень легкие");
        buttons[0].setBounds(10, 100, 500, 30);
        buttons[0].setBackground(Color.pink);
        add(buttons[0]);

        buttons[1] = new JButton("- посложнее (пока недоступно, но ученые работают над данной проблемой)");
        buttons[1].setBounds(10, 150, 500, 30);
        add(buttons[1]);

        buttons[2] = new JButton("- уровень Шерлока Холмса (таже самая проблема с учеными мужами)");
        buttons[2].setBounds(10, 200, 500, 30);
        add(buttons[2]);

        ActionListener a1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //setBackground(Color.CYAN);
                //WindowLevel.setVisible(false);
                add(new WindowEasy());
            }
        };
        buttons[0].addActionListener(a1);

    }*/


}
