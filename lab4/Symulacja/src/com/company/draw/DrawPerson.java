package com.company.draw;

import com.company.Person;
import com.company.utils.Utils;

import java.awt.*;

public class DrawPerson implements Drawable {

    private final Person person;

    public DrawPerson(Person person) {
        this.person = person;
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(person.getColor());
        g2d.fillOval((int) person.getCords()[0], (int) person.getCords()[1], Utils.SCALE, Utils.SCALE);
    }
}
