package com.company.memento;

import com.company.Person;
import com.company.states.Healthy;
import com.company.states.IInfected;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class XML {
    private int counter = 0;

    public void saveToXML(Memento memento) {
        try {
            File f = new File("./save_" + counter + ".xml");
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();
            Element population = doc.createElement("population");
            doc.appendChild(population);

            for (Person person : memento.getPopulation()) {
                Element personElement = doc.createElement("person");
                population.appendChild(personElement);
                Element x = doc.createElement("x");
                x.appendChild(doc.createTextNode(String.valueOf(person.getCords()[0])));
                personElement.appendChild(x);
                Element y = doc.createElement("y");
                y.appendChild(doc.createTextNode(String.valueOf(person.getCords()[1])));
                personElement.appendChild(y);
                Element state = doc.createElement("state");
                state.appendChild(doc.createTextNode(person.getState().getClass().getName()));
                personElement.appendChild(state);
                if (person.getState() instanceof IInfected || person.getState() instanceof Healthy) {
                    Element counter = doc.createElement("counter");
                    int counterValue;
                    if (person.getState() instanceof IInfected) {
                        counterValue = ((IInfected) person.getState()).getCounter();
                    } else {
                        counterValue = ((Healthy) person.getState()).getCounter();
                    }
                    counter.appendChild(doc.createTextNode(String.valueOf(counterValue)));
                    state.appendChild(counter);
                }
            }

            StreamResult result = new StreamResult(f);
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            transformer.transform(source, result);
        } catch (ParserConfigurationException | TransformerException pce) {
            pce.printStackTrace();
        }
        counter++;
    }

    public void loadFromXML(String path) {
        path = "./" + path;
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(path);
            doc.getDocumentElement().normalize();
            new XMLParser(doc).createPopulation();
        } catch (ParserConfigurationException | SAXException | IOException e) {
            System.out.println("Couldn't find file");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

