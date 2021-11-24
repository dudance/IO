package com.company.draw;

import javax.swing.*;

public class MyFrame extends JFrame {

    public MyFrame() {
        super("drawFrame");
        MyPanel myPanel = new MyPanel();

        add(myPanel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

}
