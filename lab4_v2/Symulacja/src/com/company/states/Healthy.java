package com.company.states;

import com.company.Person;

public class Healthy extends State {

    private int counter = 0;
    public Healthy(Person person) {
        super(person);
    }

    @Override
    public boolean handle() {
        counter++;
        return counter >= 100;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}
