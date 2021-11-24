package com.company;

import com.company.states.Healthy;
import com.company.states.Infected;
import com.company.states.InfectedWithSymptoms;
import com.company.states.InfectedWithoutSymptoms;
import com.company.utils.Utils;


import java.util.*;
import java.util.List;

public class Population {

    public static Set<Person> set = Collections.synchronizedSet(new HashSet<>());
    public static List<Person> removeList = new LinkedList<>();
    public static Map<Pair, Integer> mapOfPairs = new HashMap<>();



    public static void removeOutsiders() {
        set.removeAll(removeList);
    }


    public static void changeStates() {
        for (Person person : set) {
            if (person.getState() instanceof InfectedWithoutSymptoms || person.getState() instanceof InfectedWithSymptoms) {
                for (Person neighbour : person.getNeighbors()) {
                    if (neighbour.getState() instanceof Healthy) {
                        if (person.getState().handle()) {
                            if (Population.mapOfPairs.getOrDefault(new Pair(neighbour, person), 0) >= 350) {
                                neighbour.setState(new Infected(neighbour));
                                neighbour.getState().handle();
                            }
                            neighbour.curePerson(neighbour);
                        } else {
                            if (Population.mapOfPairs.getOrDefault(new Pair(neighbour, person), 0) >= 350) {
                                int random = Utils.getRandomNumber(1, 10);
                                if (random < 6) {
                                    neighbour.setState(new Infected(neighbour));
                                    neighbour.getState().handle();
                                    neighbour.curePerson(neighbour);
                                }
                            }

                        }
                    }
                }
            }
        }
    }

}
