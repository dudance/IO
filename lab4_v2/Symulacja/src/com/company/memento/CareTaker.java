package com.company.memento;

import com.company.Population;

import java.util.ArrayList;
import java.util.List;

public class CareTaker {
    private final List<Memento> listOfMementos = new ArrayList<>();

    public List<Memento> getListOfMementos() {
        return listOfMementos;
    }

    public void addMemento(Population population){
        listOfMementos.add(new Memento(population));
    }

    public Memento getMemento(int index){
        return listOfMementos.get(index);
    }
}
