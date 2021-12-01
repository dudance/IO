package com.company.draw;

import com.company.Simulation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyFrame extends JFrame {

    public MyFrame() {
        super("drawFrame");
        MyPanel myPanel = new MyPanel();
        JButton button = new JButton("Save");

        button.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                Simulation.saveSimulation();
                System.out.println("saved");
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        });
        add(button);
        add(myPanel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
