import javax.swing.*;
import java.awt.*;

public class Player {


    //nacalnie koordinati i razmer obekta
    //koordinati x i y geroa
    private double x;
    private double y;
    //wirina i visota obekta
    private double w;
    private double h;
    //skorost
    private int speed;
    //klaviwi peremewenia
    public static boolean up;
    public static boolean down;
    public static boolean left;
    public static boolean right;
    //zagruzka izobrazenia geroa
    Image img = new ImageIcon("image/player.png").getImage();


    //x i y - koordinati na4alnogo raspolozenia geroa, w i h - granici peremewenia (?)
    public Player() {
        x = 400;
        y = 400;
        w = -820;
        h = 90;
        speed = 5;
        //nacalnie znacenia klaviw
        up = false;
        down = false;
        left = false;
        right = false;
    }



    //getteri
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getW() {
        return w;
    }

    public double getH() {
        return h;
    }



    //obnovlenia
    public void update() {
        //smewenia geroa po igrovomu polu
        if (up && y > 20) {
            y -= speed;
        }
        if (down && y < Panel.HEIGHT - h) {
            y += speed;
        }
        if (left && x > 0) {
            x -= speed;
        }
        if (right && x < Panel.WIDTH - w) {
            x += speed;
        }
    }



    //otrisovka geroa
    public void draw(Graphics2D g) {
        //otrisovka kartinki
        g.drawImage(img, (int) x, (int) y, null);
    }
}
