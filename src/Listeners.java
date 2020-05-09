import java.awt.event.*;

public class Listeners implements MouseListener, KeyListener, MouseMotionListener {


    @Override
    public void keyTyped(KeyEvent e) {

    }


    //proverka nazatoi klaviwi
    @Override
    public void keyPressed(KeyEvent e) {
        //polucit kod nazatoi klaviwi
        int key = e.getKeyCode();
        //proverka klaviwi
        if (key == KeyEvent.VK_UP) {
            Player.up = true;
        }
        if (key == KeyEvent.VK_DOWN) {
            Player.down = true;
        }
        if (key == KeyEvent.VK_LEFT) {
            Player.left = true;
        }
        if (key == KeyEvent.VK_RIGHT) {
            Player.right = true;
        }
        if (key == KeyEvent.VK_ESCAPE) {
            if (Panel.state == Panel.STATES.PLAY) {
                Panel.state = Panel.STATES.MENUE;
            }

        }

    }

    //proverka otzatoi klaviwi
    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_UP) {
            Player.up = false;
        }
        if (key == KeyEvent.VK_DOWN) {
            Player.down = false;
        }
        if (key == KeyEvent.VK_LEFT) {
            Player.left = false;
        }
        if (key == KeyEvent.VK_RIGHT) {
            Player.right = false;
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            if (Panel.state == Panel.STATES.MENUE) {
                Menue.click = true;
            }
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            if (Panel.state == Panel.STATES.MENUE) {
                Menue.click = false;
            }
        }

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    //metod perenosa miwkoi
    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        //polu4it koordinatu x i y pri peremewenii miwi
        Panel.mouseX = e.getX();
        Panel.mouseY = e.getY();
    }
}
