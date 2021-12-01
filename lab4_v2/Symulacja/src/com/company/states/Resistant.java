package com.company.states;

import com.company.Person;

import java.awt.*;

public class Resistant extends State {

    public Resistant(Person person) {
        super(person);
    }

    @Override
    public boolean handle() {
        person.setColor(new Color(0, 255, 0));
        return false;
    }
}
