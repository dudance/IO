package com.company.utils;

import com.company.flyweight.Unit;
import com.company.proxy.UnitFactoryProxy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

public class Utils {

    public static String wordFormatting(String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
    }

    public static void saveToFile(List<Unit> unit) {
        try (Writer writer = new FileWriter("data.json")) {
            Gson gson = new GsonBuilder().create();
            gson.toJson(unit, writer);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static List<Unit> loadFromFile() {
        try (Reader reader = new FileReader("data.json")) {
            Gson gson = new GsonBuilder().create();
            Type type = new TypeToken<Collection<Unit>>() {
            }.getType();
            return gson.fromJson(reader, type);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static void addTestingData(UnitFactoryProxy proxyFactory) {
        proxyFactory.addName("AdAm JAKub MARcin koWaLski", 5.3, 2.1);
        proxyFactory.addName("AdAM JAkuB MARCIN NOWAK", 12.2, 12.11);
        proxyFactory.addName("AdAM JAkuB wOjCiECH NOWAK", 23.23, 121.1);
        proxyFactory.addName("tOMAsz kacPER AdamiAK", 12, 12);
        proxyFactory.addName("tOMAsz kacPER BRZOza", 111, 121);
        proxyFactory.addName("AdaM Rzeka", 5, 10);

    }

    public static String[] getParentAndChildren(String fullName) {
        return fullName.split(" ", 2);
    }

}
