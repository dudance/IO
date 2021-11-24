package com.company;

import com.company.draw.MyFrame;

public class Main {

    public static void main(String[] args) {

        int numberOfPeople = 70;
        int currentNumberOfPeople;
        boolean containsResistance = true;


        for (int i = 0; i < numberOfPeople; i++) {
            Person person = new Person(containsResistance);
            while(person.getState().handle()) { }
        }
        MyFrame frame = new MyFrame();
        while (true) {
            Population.set.forEach(Person::move);
            Population.removeOutsiders();
            currentNumberOfPeople = numberOfPeople - Population.set.size();
            for (int j = 0; j < currentNumberOfPeople; j++) {
                Person person = new Person(containsResistance);
                while(person.getState().handle()) {}
            }
            Population.changeStates();
            frame.repaint();
        }




    }
}
