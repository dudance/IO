package com.company;

public class Currency {
    private final String name;
    private final int converter;
    private final String currencyCode;
    private final double exchangeRate;

    public Currency(String name, int converter, String currencyCode, double exchangeRate) {
        this.name = name;
        this.converter = converter;
        this.currencyCode = currencyCode;
        this.exchangeRate = exchangeRate;
    }

    @Override
    public String toString() {
        return currencyCode + " - " + name;
    }


    public String getName() {
        return name;
    }


    public int getConverter() {
        return converter;
    }

    public double getExchangeRate() {
        return exchangeRate;
    }

}
