package com.company.states;

import com.company.Person;

public class InfectedWithoutSymptoms extends State {
    InfectedWithoutSymptoms(Person person) {
        super(person);
    }

    @Override
    public boolean handle() {
        return false;
    }
}
