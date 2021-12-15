package com.company.flyweight;

import com.company.proxy.Proxy;
import com.company.utils.Utils;

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

    public static void addChildren(String[] partsOfName, Unit parent, double x, double y) {
        if (partsOfName.length > 1) {
            parent.addChild(partsOfName[1], x, y);
        } else {
            parent.setCoordinates(x, y);
        }
    }

    public void addName(String fullName, double x, double y) {
        String[] parts = Utils.getParentAndChildren(fullName);
        Unit parent = getUnit(list, parts[0]);

        addChildren(parts, parent, x, y);
    }

    public void printFactory() {
        for (Unit u : list) {
            u.displayUnit("");
        }
    }

}
