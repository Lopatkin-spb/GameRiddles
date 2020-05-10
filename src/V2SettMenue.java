import javax.swing.*;
import java.awt.*;

public class V2SettMenue {


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
    Font fontNameButt1;
    Font fontNameButt2;


    public V2SettMenue(int x, int y, int w, int h, String srcImg, String nameButt) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.nameButt = nameButt;
        this.srcImg = srcImg;
        colorNameButt = Color.BLACK;
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
        g.setColor(Color.red);
        fontNameButt1 = new Font("Arial", Font.ITALIC, 55);
        g.setFont(fontNameButt1);

        g.drawString("Звук", 40,250);
        g.drawString("Управление", 40,400);

        //otrisovka elementa v koordinatah
        g.drawImage(new ImageIcon(srcImg).getImage(), (int) x, (int) y, null);

        g.setColor(colorNameButt);
        fontNameButt2 = new Font("Arial", Font.ITALIC, 20);
        g.setFont(fontNameButt2);

        //dlina nadpisi v pikseliah
        long length = (int) g.getFontMetrics().getStringBounds(nameButt, g).getWidth();
        //risuem stro4ku v centre paneli
        g.drawString(nameButt, (int) (x + w / 2) - (int) (length / 2), (int) y + (int) (h / 3) * 2);
    }

}
