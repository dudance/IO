package com.company.proxy;

import com.company.utils.Utils;

public class UnitFactoryProxy implements Proxy {

    private final Proxy unitFactory;

    public UnitFactoryProxy(Proxy realFactory) {
        this.unitFactory = realFactory;
    }

    public void addName(String fullName, double x, double y) {
        String[] parts = fullName.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String part : parts) {
            sb.append(Utils.wordFormatting(part)).append(" ");
        }
        unitFactory.addName(sb.toString().trim(), x, y);
    }
}
