package com.company;

import java.util.Scanner;

public class UserInputManager {

    public static String[] getUserInput() throws Exception {

        Scanner scanner = new Scanner(System.in);
        String[] userInput = new String[3];
        System.out.println("Wybierz walute zrodlowa: ");
        userInput[0] = scanner.nextLine();

        System.out.println("podaj ilosc waluty zrodlowej");

        userInput[1] = scanner.nextLine();

        System.out.println("Wybierz walute docelowa: ");
        userInput[2] = scanner.nextLine();

        try {
            validateUserData(userInput);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Wrong parameters");
        }


        return userInput;
    }

    public static void validateUserData(String[] userData) throws Exception {
        CurrencyRepository currencyRepository = CurrencyRepository.getInstance();
        if (currencyRepository.isCurrencyCodeValid(userData[0]) || currencyRepository.isCurrencyCodeValid(userData[2])) {
            throw new IllegalArgumentException("Wrong parameters");
        }
        try {
            Double.parseDouble(userData[1]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Wrong parameters");
        }
    }

}
