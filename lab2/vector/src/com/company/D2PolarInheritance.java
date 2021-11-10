package com.company;

public class D2PolarInheritance extends Vector2D {

    public D2PolarInheritance(double x, double y) {
        super(x, y);
    }

    public double getAngle() {
        double[] vectorCords = getComponents();
        return Math.atan2(vectorCords[1], vectorCords[0]) * 180 / Math.PI;
    }
}
