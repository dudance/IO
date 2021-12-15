package com.company.flyweight;

import com.company.utils.Utils;

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

    public void addChild(String partsOfName, double x, double y) {

        String[] parts = Utils.getParentAndChildren(partsOfName);
        Unit parent = UnitFactory.getUnit(this.children, parts[0]);
        UnitFactory.addChildren(parts, parent, x, y);
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
