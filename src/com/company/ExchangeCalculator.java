package com.company;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ExchangeCalculator {
    private final Currency baseCurrency;
    private final Currency targetCurrency;
    private final double baseValueOfCurrency;
    private double targetValueOfCurrency;

    public ExchangeCalculator(Currency baseCurrency, Currency targetCurrency, double valueOfCurrency) {
        this.baseCurrency = baseCurrency;
        this.targetCurrency = targetCurrency;
        this.baseValueOfCurrency = valueOfCurrency;
    }

    public void calculateTargetValue() {
        targetValueOfCurrency = (double) targetCurrency.getConverter() / (double) baseCurrency.getConverter() * baseValueOfCurrency * baseCurrency.getExchangeRate() / targetCurrency.getExchangeRate();
        targetValueOfCurrency = roundValue(targetValueOfCurrency);
    }

    public void printResults() {
        System.out.println("za " +
                baseValueOfCurrency + " " +
                baseCurrency.getName() + " otrzymasz " +
                targetValueOfCurrency + " " +
                targetCurrency.getName());
    }

    public static double roundValue(double value) {
        BigDecimal bigDecimal = new BigDecimal(Double.toString(value));
        bigDecimal = bigDecimal.setScale(2, RoundingMode.HALF_UP);
        return bigDecimal.doubleValue();
    }

}
