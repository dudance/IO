package com.company;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class DataProvider {


    private NodeList downloadCurrencies() throws Exception {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new URL("https://www.nbp.pl/kursy/xml/lasta.xml").openStream());
            return document.getElementsByTagName("pozycja");
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


    public Map<String, Currency> mapCurriencies() throws Exception {
        Map<String, Currency> currencyMap = new HashMap<String, Currency>();
        try {
            NodeList list = downloadCurrencies();
            for (int temp = 0; temp < list.getLength(); temp++) {

                Node node = list.item(temp);

                if (node.getNodeType() == Node.ELEMENT_NODE) {

                    Element element = (Element) node;

                    String name = element.getElementsByTagName("nazwa_waluty").item(0).getTextContent();
                    int converter = Integer.parseInt(element.getElementsByTagName("przelicznik").item(0).getTextContent());
                    String currencyCode = element.getElementsByTagName("kod_waluty").item(0).getTextContent();
                    double exchangeRate = Double.parseDouble(element.getElementsByTagName("kurs_sredni").item(0).getTextContent().replaceAll(",", "."));

                    Currency currencyObject = new Currency(name, converter, currencyCode, exchangeRate);
                    currencyMap.putIfAbsent(currencyCode, currencyObject);

                }
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return currencyMap;
    }

}
