import javax.swing.*;
import java.awt.*;

public class Back {


    //zadnii fon igrovoi paneli
    Image img = new ImageIcon("image/fon1.jpg").getImage();


    //prorisovka v G2d
    public void draw(Graphics2D g) {
        //obekt cveta
        Color backColor = new Color(186, 238, 255);
        //peredaem cvet obektu
        g.setColor(backColor);

        //risuem priamougolnuu oblast
        if (Panel.state.equals(Panel.STATES.MENUE))
            g.fillRect(0, 0, Panel.WIDHT, Panel.HEIGHT);

        if (Panel.state.equals(Panel.STATES.PLAY))
            //otrisovka elementa v koordinatah
            g.drawImage(img, (int) 0, (int) 0, null);
    }
}
