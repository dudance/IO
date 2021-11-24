package com.company.states;

import com.company.Person;
import com.company.utils.Utils;

import java.awt.*;

public class Infected extends State {
    public Infected(Person person) {
        super(person);
    }

    @Override
    public boolean handle() {
        int nextState = Utils.getRandomNumber(1, 10);
        if (nextState < 2) {
            person.setState(new InfectedWithoutSymptoms(person));
            person.setColor(new Color(255, 255, 0));
            person.curePerson(person);
            return false;
        } else {
            person.setState(new InfectedWithSymptoms(person));
            person.setColor(new Color(255, 0, 0));
            person.curePerson(person);
            return false;
        }
    }
}
