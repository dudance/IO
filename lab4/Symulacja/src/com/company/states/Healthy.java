package com.company.states;

import com.company.Person;

public class Healthy extends State {
    public Healthy(Person person) {
        super(person);
    }

    @Override
    public boolean handle() {
        return false;
    }
}
