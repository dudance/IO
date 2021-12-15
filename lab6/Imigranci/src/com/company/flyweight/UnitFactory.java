package com.company.flyweight;

import com.company.proxy.Proxy;

import java.util.ArrayList;
import java.util.List;

public class UnitFactory implements Proxy {

    private List<Unit> list = new ArrayList<>();

    public List<Unit> getList() {
        return list;
    }

    public void setList(List<Unit> list) {
        this.list = list;
    }

    public static Unit getUnit(List<Unit> list, String partName) {
        for (Unit unit : list) {
            if (unit.getPartOfName().equals(partName)) {
                return unit;
            }
        }
        Unit newUnit = new Unit(partName);
        list.add(newUnit);
        return newUnit;
    }

    public static void setChildrenOrCoordinates(String[] values, Unit unit, double x, double y) {
        if (values.length > 1) {
            unit.addChildren(values[1], x, y);
        } else {
            unit.setCoordinates(x, y);
        }
    }

    public void addPerson(String value, double x, double y) {
        String[] values = value.split(" ", 2);
        Unit unit = getUnit(list, values[0]);

        setChildrenOrCoordinates(values, unit, x, y);
    }

    public void printFactory() {
        for (Unit u : list) {
            u.displayUnit("");
        }
    }


}
