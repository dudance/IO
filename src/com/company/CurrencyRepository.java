package com.company;

import java.util.HashMap;
import java.util.Map;

public class CurrencyRepository {
    private final Map<String, Currency> currencyMap = new HashMap<>();
    private static CurrencyRepository currencyRepository;

    private CurrencyRepository() throws Exception {
        DataProvider dataProvider = new DataProvider();
        currencyMap.putAll(dataProvider.mapCurriencies());
       currencyMap.putIfAbsent("PLN", new Currency("Zloty polski", 1, "PLN", 1));
    }

    public static CurrencyRepository getInstance() throws Exception {
        if (currencyRepository == null) {
            currencyRepository = new CurrencyRepository();
        }
        return currencyRepository;
    }


    public Map<String, Currency> getCurrencyMap() {
        return currencyMap;
    }

    public void printCurrencies() {
        for (Currency value : currencyMap.values()) {
            System.out.println(value.toString());
        }
    }

    public boolean isCurrencyCodeValid(String code) {
        return !currencyMap.containsKey(code);
    }


}
