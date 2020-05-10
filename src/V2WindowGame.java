import javax.swing.*;
import java.awt.*;

public class V2WindowGame {

  /*  private Font font;
    private JTextField question;

    public WindowGame() {

        font = new Font("SanSerif", Font.BOLD, 25);
        question = new JTextField();

        setTitle("Угадайка!");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(530, 400); // ||(screenSize)
        setLocation(0, 0);
        setResizable(false);
        setVisible(true);

        question = new JTextField("Выберите уровень сложности загадок пожалуйста.");
        question.setBounds(10, 10, 500, 50);
        question.setEditable(false);
        question.setBackground(Color.pink);
        add(question);

        //add(new WindowLevel());


    }*/

    public static void main(String[] args) {

        JFrame startFrame = new JFrame("Угадайка");
        startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        startFrame.setLocation(0, 0);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        startFrame.setSize(screenSize);
        startFrame.add(new V2Panel());

        startFrame.setVisible(true);


    }


}
