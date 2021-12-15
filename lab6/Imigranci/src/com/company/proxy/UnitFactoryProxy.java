package com.company.proxy;

import com.company.utils.Utils;

public class UnitFactoryProxy implements Proxy {

    private final Proxy realFactory;

    public UnitFactoryProxy(Proxy realFactory) {
        this.realFactory = realFactory;
    }

    public void addPerson(String value, double x, double y) {
        String[] values = value.split(" ");
        StringBuilder stringBuilder = new StringBuilder();

        for (String v : values) {
            stringBuilder.append(Utils.wordFormatting(v)).append(" ");
        }
        realFactory.addPerson(stringBuilder.toString().trim(), x, y);
    }
}
