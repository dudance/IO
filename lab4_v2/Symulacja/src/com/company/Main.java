package com.company;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("1) New Simulation");
        System.out.println("2) Load Simulation");
        int option = Integer.parseInt(scanner.nextLine());
        switch(option) {
            case 1:
                System.out.println("Number of people: ");
                int numberOfPeople = Integer.parseInt(scanner.nextLine());
                System.out.println("1) Optimistic simulation");
                System.out.println("2) Pessimistic simulation");
                int secondOption = Integer.parseInt(scanner.nextLine());
                Simulation simulation = new Simulation(numberOfPeople);
                switch (secondOption) {
                    case 1 -> simulation.startSimulation(true);
                    case 2 -> simulation.startSimulation(false);
                    default -> System.out.println("Incorrect option");
                }
            case 2:
                File root = new File("./");
                String[] contents = root.list();
                System.out.println("Choose file to load");
                if(contents == null) {
                    System.out.println("Files not found");
                    break;
                }
                Arrays.stream(contents).forEach(elem -> {
                    Pattern pattern = Pattern.compile("save");
                    Matcher matcher = pattern.matcher(elem);
                    boolean matchFound = matcher.find();
                    if (matchFound) {
                        System.out.println(elem);
                    }
                });
                System.out.println("Type name of file");
                String fileName = scanner.nextLine();
                new Simulation(fileName).startSimulation(true);
                break;
            default:
                System.out.println("Incorrect option");
        }
    }
}
