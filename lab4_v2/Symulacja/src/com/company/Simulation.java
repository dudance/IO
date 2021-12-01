package com.company;

import com.company.draw.MyFrame;
import com.company.memento.CareTaker;
import com.company.memento.XML;

public class Simulation {
    private int startPopulationNum;
    private static Population population;
    private final static CareTaker caretaker = new CareTaker();
    private final static XML xml = new XML();

    public Simulation(int startPopulationNum) {
        this.startPopulationNum = startPopulationNum;
    }

    public Simulation(String path) {
        population = new Population();
        new XML().loadFromXML(path);
    }

    public static Population getPopulation() {
        return population;
    }

    public void startSimulation(boolean optimisticVariant) {
        if (population == null) {
            population = new Population();
            for (int i = 0; i < startPopulationNum; i++) {
                Person person = new Person(optimisticVariant);
                population.addPerson(person);
                while (person.getState().handle()) {}
            }
        }
        int currentNumberOfPeople;
        MyFrame frame = new MyFrame();
        while (true) {
            population.getSetOfPeople().forEach(person -> person.move(population));
            population.removeOutsiders();
            currentNumberOfPeople = startPopulationNum - population.getSetOfPeople().size();
            for (int j = 0; j < currentNumberOfPeople; j++) {
                Person person = new Person(optimisticVariant);
                population.addPerson(person);
                while (person.getState().handle()) {}
            }
            population.changeStates();
            frame.repaint();
            try {
                Thread.sleep( 1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void saveSimulation() {
        caretaker.addMemento(population);
        xml.saveToXML(caretaker.getMemento(caretaker.getListOfMementos().size() - 1));
    }

}
