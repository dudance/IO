package com.company.flyweight;

import java.util.ArrayList;
import java.util.List;

public class Unit {
    private double x;
    private double y;
    private final String partOfName;
    private final List<Unit> children = new ArrayList<>();

    public Unit(String value) {
        this.partOfName = value;
    }

    public String getPartOfName() {
        return partOfName;
    }

    public void addChildren(String partOfName, double x, double y) {
        String[] values = partOfName.split(" ", 2);

        Unit unit = UnitFactory.getUnit(this.children, values[0]);
        UnitFactory.setChildrenOrCoordinates(values, unit, x, y);
    }

    public void displayUnit(String prefix) {
        System.out.println(prefix + "-" + partOfName + "(" + x + ", " + y + ")");
        for (Unit u : children) {
            u.displayUnit(prefix + "     ");
        }
    }

    public void setCoordinates(double x, double y) {
        this.x = x;
        this.y = y;
    }

}
