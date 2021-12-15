package com.company;


import com.company.flyweight.UnitFactory;
import com.company.proxy.Proxy;
import com.company.proxy.UnitFactoryProxy;
import com.company.utils.Utils;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Proxy factory = new UnitFactory();
        Proxy proxyFactory = new UnitFactoryProxy(factory);
        Scanner scanner = new Scanner(System.in);

        int option;
        String name;
        double x;
        double y;

        //Utils.addTestingData(proxyFactory);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1) Dodaj osobę");
            System.out.println("2) Wczytaj dane");
            System.out.println("3) Zapisz dane");
            System.out.println("4) Wyświetl dane");
            System.out.println("5) Wyjdź");
            option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1:
                    System.out.println("Nazwa osoby:");
                    name = scanner.nextLine();
                    System.out.println("Wspolrzedna x");
                    x = Double.parseDouble(scanner.nextLine());
                    System.out.println("Wspolrzedna y");
                    y = Double.parseDouble(scanner.nextLine());
                    proxyFactory.addPerson(name, x, y);
                    break;
                case 2:
                    ((UnitFactory) factory).setList(Utils.loadFromFile());
                    break;
                case 3:
                    Utils.saveToFile(((UnitFactory) factory).getList());
                    break;
                case 4:
                    ((UnitFactory) factory).printFactory();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Nie ma takiej opcji");
            }
        }
    }
}
