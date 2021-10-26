package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        for (;;) {
            try {
                CurrencyRepository currencyRepository = CurrencyRepository.getInstance();
                Map<String, Currency> currencyMap = currencyRepository.getCurrencyMap();
                currencyRepository.printCurrencies();
                String[] userInput = UserInputManager.getUserInput();
                ExchangeCalculator calc = new ExchangeCalculator(
                        currencyMap.get(userInput[0]),
                        currencyMap.get(userInput[2]),
                        ExchangeCalculator.roundValue(Double.parseDouble(userInput[1])));
                calc.calculateTargetValue();
                calc.printResults();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("User sent wrong argument");
            } catch (Exception e) {
                System.out.println("Cannot download values");
                break;
            }
        }
    }
}
