package com.company.draw;

import com.company.Simulation;
import com.company.utils.Utils;

import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {

    public MyPanel() {
        setPreferredSize(new Dimension((Utils.WIDTH + 1) * Utils.SCALE, (Utils.HEIGHT + 1) * Utils.SCALE));
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Simulation.getPopulation().getSetOfPeople().forEach(person -> person.draw(g));
    }

}
