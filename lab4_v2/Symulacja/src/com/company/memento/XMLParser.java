package com.company.memento;

import com.company.Person;
import com.company.Population;
import com.company.Simulation;
import com.company.states.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLParser {
    private final Document data;

    public XMLParser(Document data) {
        this.data = data;
    }

    public void createPopulation() throws Exception {
        if (data == null) {
            throw new Exception("Data is null");
        }

        NodeList entries = data.getElementsByTagName("person");
        if (entries.getLength() == 0) {
            throw new Exception("No tag <person>");
        }

        Population population = Simulation.getPopulation();
        for (int i = 0; i < entries.getLength(); i++) {
            Node entry = entries.item(i);
            Element element = (Element) entry;
            try {
                double x = Double.parseDouble(element.getElementsByTagName("x").item(0).getTextContent());
                double y = Double.parseDouble(element.getElementsByTagName("y").item(0).getTextContent());
                Person person = new Person(true);
                person.setCords(new double[]{x, y});
                String state = element.getElementsByTagName("state").item(0).getTextContent();
                State statePerson = new Resistant(person);
                if (state.contains("InfectedWithoutSymptoms")) {
                    statePerson = new InfectedWithoutSymptoms(person);
                    int counter = Integer.parseInt(element.getElementsByTagName("counter").item(0).getTextContent());
                    ((InfectedWithoutSymptoms) statePerson).setCounter(counter);
                } else if (state.contains("InfectedWithSymptoms")) {
                    statePerson = new InfectedWithSymptoms(person);
                    int counter = Integer.parseInt(element.getElementsByTagName("counter").item(0).getTextContent());
                    ((InfectedWithSymptoms) statePerson).setCounter(counter);
                } else if (state.contains("Healthy")) {
                    statePerson = new Healthy(person);
                    int counter = Integer.parseInt(element.getElementsByTagName("counter").item(0).getTextContent());
                    ((Healthy) statePerson).setCounter(counter);
                }
                person.setState(statePerson);
                person.updateColor();
                population.addPerson(person);
            } catch (NullPointerException e) {
                System.out.println("Couldn't add a person");
            }
        }
    }
}
