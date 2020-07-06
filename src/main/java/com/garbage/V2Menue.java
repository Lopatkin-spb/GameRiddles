package com.garbage;

import javax.swing.*;
import java.awt.*;

public class V2Menue {
    //knopki menu kak obekti


    //klik miwkoi v rezime menu
    public static boolean click = false;


    ButtMenue button1 = new ButtMenue(10, 10, 376, 100, "image/button1.png", "Игра");
    ButtMenue button2 = new ButtMenue(10, 150, 376, 100, "image/button1.png", "Авторизация");
    ButtMenue button3 = new ButtMenue(10, 300, 376, 100, "image/button1.png", "Настройки");
    ButtMenue button4 = new ButtMenue(10, 450, 376, 100, "image/button1.png", "Правила");
    ButtMenue button5 = new ButtMenue(10, 600, 376, 100, "image/button1.png", "Выход");


    public void draw(Graphics2D g) {
        button1.draw(g);
        button2.draw(g);
        button3.draw(g);
        button4.draw(g);
        button5.draw(g);
    }


    //popadanie kursora na knopku menu
    public void moveButt(V2Menue.ButtMenue e) {
        //esli kursor popal na knopku
        if (V2Panel.mouseX > e.getX() && V2Panel.mouseX < e.getX() + e.getW() &&
                V2Panel.mouseY > e.getY() && V2Panel.mouseY < e.getY() + e.getH()) {
            e.srcImg = "image/button1.png";
            if (e.equals(button1)) {
                e.nameButt = "game";
                if (V2Menue.click) { //klik lkm
                    V2Panel.state = V2Panel.STATES.PLAY; //perehod v igru
                    V2Menue.click = false;
                }
            }
            if (e.equals(button2)) {
                e.nameButt = "login";
            }
            if (e.equals(button3)) {
                e.nameButt = "settings";
                if (V2Menue.click) { //klik lkm
                    V2Panel.settmenue = true; //perehod v igru
                    V2Panel.buttmenue = false;
                }
            }
            if (e.equals(button4)) {
                e.nameButt = "rules";
                if (V2Menue.click) { //klik lkm

                    /*Panel.levelmenue = true; //perehod v igru
                    Panel.buttmenue = false;*/
                }
            }
            if (e.equals(button5)) {
                e.nameButt = "exit";
                if (V2Menue.click) {
                    //Menue.click = true;
                    System.exit(0);
                }
            }
        } else {
            e.srcImg = "image/button1.png";
            if (e.equals(button1)) {
                e.nameButt = "Игра";
            }
            if (e.equals(button2)) {
                e.nameButt = "Авторизация";
            }
            if (e.equals(button3)) {
                e.nameButt = "Настройки";
            }
            if (e.equals(button4)) {
                e.nameButt = "Правила";
            }
            if (e.equals(button5)) {
                e.nameButt = "Выход";
            }
        }
    }


    class ButtMenue {
        //na4alnie koordinati i razmer obekta
        private double x;
        private double y;
        private double w;
        private double h;
        public Color colorNameButt;
        //nadpis na knopke
        public String nameButt;
        //stroka adresa kartinki
        public String srcImg;
        Font fontNameButt;


        public ButtMenue(int x, int y, int w, int h, String srcImg, String nameButt) {
            this.x = x;
            this.y = y;
            this.w = w;
            this.h = h;
            this.nameButt = nameButt;
            this.srcImg = srcImg;
            colorNameButt = Color.WHITE;
        }

        //getteri
        public double getX() {
            return this.x;
        }

        public double getY() {
            return this.y;
        }

        public double getW() {
            return this.w;
        }

        public double getH() {
            return this.h;
        }


        public void draw(Graphics2D g) {

            //otrisovka elementa v koordinatah
            g.drawImage(new ImageIcon(srcImg).getImage(), (int) x, (int) y, null);

            g.setColor(colorNameButt);
            fontNameButt = new Font("Arial", Font.ITALIC, 55);
            g.setFont(fontNameButt);

            //dlina nadpisi v pikseliah
            long length = (int) g.getFontMetrics().getStringBounds(nameButt, g).getWidth();
            //risuem stro4ku v centre paneli
            g.drawString(nameButt, (int) (x + w / 2) - (int) (length / 2), (int) y + (int) (h / 3) * 2);
        }
    }
}
/*
//knopki menu ne kak obekti

    private int numberButtons;
    private Color colorNameButt;
    Font fontNameButt;
    //koordinati knopok i wirina, visota
    private double x;
    private double y;
    private double w;
    private double h;
    //put k kartinke knopki
    private String img;
    String[] nameButton = new String[5];

    public Menue() {
        x = 100;
        y = 0;
        w = 376; //396
        h = 100; //100
        numberButtons = 5;
        colorNameButt = Color.GRAY;
        img = "image/button1.png"; //put k knopke "image.but1.png"
        nameButton[0] = "Игра";
        nameButton[1] = "Авторизация";
        //nameButton[1]="Достижения";
        nameButton[2] = "Настройки";
        nameButton[3] = "Правила";
        nameButton[4] = "Выход";
        //nameButton[2]="Магазин";
    }

    public void update() {

    }

    public void draw(Graphics2D g) {
        for (int i = 0; i < numberButtons; i++) {
            //otrisovka elementa v koordinatah
            g.drawImage(new ImageIcon(img).getImage(), (int) x, (int) (y + 140) * i, null);

            g.setColor(colorNameButt);
            fontNameButt = new Font("Arial", Font.ITALIC, 55);
            g.setFont(fontNameButt);

            //dlina nadpisi v pikseliah
            long length = (int) g.getFontMetrics().getStringBounds(nameButton[i], g).getWidth();
            //risuem stro4ku v centre paneli
            g.drawString(nameButton[i], (int) (x + w / 2) - (int) (length / 2), (int) ((y + 140) * i + (h / 3) * 2));
        }
    }

}*/
