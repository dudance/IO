package com.company.states;

import com.company.Person;

public class InfectedWithSymptoms extends State {
    InfectedWithSymptoms(Person person) {
        super(person);
    }

    @Override
    public boolean handle() {
        return true;
    }
}
