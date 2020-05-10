import java.awt.event.*;

public class V2Listeners implements MouseListener, KeyListener, MouseMotionListener {


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
            V2Player.up = true;
        }
        if (key == KeyEvent.VK_DOWN) {
            V2Player.down = true;
        }
        if (key == KeyEvent.VK_LEFT) {
            V2Player.left = true;
        }
        if (key == KeyEvent.VK_RIGHT) {
            V2Player.right = true;
        }
        if (key == KeyEvent.VK_ESCAPE) {
            if (V2Panel.state == V2Panel.STATES.PLAY) {
                V2Panel.state = V2Panel.STATES.MENUE;
            }

        }

    }

    //proverka otzatoi klaviwi
    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_UP) {
            V2Player.up = false;
        }
        if (key == KeyEvent.VK_DOWN) {
            V2Player.down = false;
        }
        if (key == KeyEvent.VK_LEFT) {
            V2Player.left = false;
        }
        if (key == KeyEvent.VK_RIGHT) {
            V2Player.right = false;
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            if (V2Panel.state == V2Panel.STATES.MENUE) {
                V2Menue.click = true;
            }
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            if (V2Panel.state == V2Panel.STATES.MENUE) {
                V2Menue.click = false;
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
        V2Panel.mouseX = e.getX();
        V2Panel.mouseY = e.getY();
    }
}
