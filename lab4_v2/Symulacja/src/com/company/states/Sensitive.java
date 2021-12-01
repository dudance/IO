package com.company.states;

import com.company.Person;
import com.company.utils.Utils;

import java.awt.*;

public class Sensitive extends State{

    Sensitive(Person person) {
        super(person);
    }

    @Override
    public boolean handle() {
        int nextState = Utils.getRandomNumber(1, 10);
        if (nextState <= 2) {
            person.setState(new Infected(person));
            return true;
        } else {
            person.setState(new Healthy(person));
            person.setColor(new Color(0, 0, 0));
            return false;
        }
    }
}
