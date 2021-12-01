package com.company.memento;

import com.company.Person;
import com.company.Population;

import java.util.ArrayList;
import java.util.List;

public class Memento {
    private final List<Person> population;

    public Memento(Population population) {
        this.population = new ArrayList<>(population.getSetOfPeople());
    }

    public List<Person> getPopulation() {
        return population;
    }
}
