package com.company.states;

import com.company.Person;
import com.company.utils.Utils;

import java.awt.*;

public class FirstStateWithoutResistance extends State {

    public FirstStateWithoutResistance(Person person) {
        super(person);
    }

    @Override
    public boolean handle() {

            person.setState(new Sensitive(person));
            return true;

    }
}
