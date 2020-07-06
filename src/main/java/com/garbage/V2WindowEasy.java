package com.garbage;

import javax.swing.*;
import java.awt.*;

public class V2WindowEasy extends JPanel {


    private JButton butto[] = new JButton[4];
    private Font font = new Font("SanSerif", Font.BOLD, 25);
    private JTextField questi = new JTextField();


    public V2WindowEasy() {

        setBackground(Color.PINK);
        setLayout(null); //размещение кнопок как нам хочется

        questi = new JTextField("Выберите ");
        questi.setBounds(10, 10, 500, 50);
        questi.setEditable(false);
        questi.setBackground(Color.pink);
        add(questi);

        butto[0] = new JButton("- ооо");
        butto[0].setBounds(10, 100, 500, 30);
        butto[0].setBackground(Color.pink);
        add(butto[0]);

        butto[1] = new JButton("- пос");
        butto[1].setBounds(10, 150, 500, 30);
        add(butto[1]);

        butto[2] = new JButton("- уро");
        butto[2].setBounds(10, 200, 500, 30);
        add(butto[2]);
    }
}
