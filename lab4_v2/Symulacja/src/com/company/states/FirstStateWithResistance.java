package com.company.states;

import com.company.Person;
import com.company.utils.Utils;

import java.awt.*;

public class FirstStateWithResistance extends State {

    public FirstStateWithResistance(Person person) {
        super(person);
    }

    @Override
    public boolean handle() {
        int nextState = Utils.getRandomNumber(1, 10);

        if (nextState < 5) {
            person.setState(new Resistant(person));
            person.setColor(new Color(0, 255, 0));
            return false;
        } else {
            person.setState(new Sensitive(person));
            return true;
        }
    }
}
