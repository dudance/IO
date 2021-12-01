package com.company;

import com.company.states.*;
import com.company.utils.Utils;


import java.util.*;
import java.util.List;

public class Population {

    private final Set<Person> setOfPeople = Collections.synchronizedSet(new HashSet<>());
    private final List<Person> listOfOutsiders = new LinkedList<>();

    public void removeOutsiders() {
        listOfOutsiders.forEach(setOfPeople::remove);
    }

    public Set<Person> getSetOfPeople() {
        return setOfPeople;
    }

    public List<Person> getListOfOutsiders() {
        return listOfOutsiders;
    }

    public void changeStates() {
        for (Person person : setOfPeople) {
            if (person.getState() instanceof IInfected) {
                for (Person neighbour : person.getNeighbors()) {
                    if (neighbour.getState() instanceof Healthy) {
                        if (person.getState() instanceof InfectedWithSymptoms) {
                            if (neighbour.getState().handle()) {
                                neighbour.setState(new Infected(neighbour));
                                neighbour.getState().handle();
                            }
                        } else {
                            int random = Utils.getRandomNumber(1, 10);
                            if (random < 6) {
                                if (neighbour.getState().handle()) {
                                    neighbour.setState(new Infected(neighbour));
                                    neighbour.getState().handle();
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void addPerson(Person person) {
        setOfPeople.add(person);
    }
}
