package com.company.states;

import com.company.Person;
import com.company.utils.Utils;

public class InfectedWithoutSymptoms extends State implements IInfected {

    private int counter = 0;

    public InfectedWithoutSymptoms(Person person) {
        super(person);
    }

    @Override
    public boolean handle() {
        counter++;
        return counter >= Utils.getRandomNumber(2800, 4000);
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}
