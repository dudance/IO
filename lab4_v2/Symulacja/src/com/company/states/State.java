package com.company.states;

import com.company.Person;

public abstract class State {

    public Person person;

    public State(Person person) {
        this.person = person;
    }

    public abstract boolean handle();
}
