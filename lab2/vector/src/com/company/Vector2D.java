package com.company;

public class Vector2D implements IVector {

    private final double x;
    private final double y;

    public Vector2D(double x,double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public double abs() {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

    @Override
    public double cdot(IVector vector) {
        double[] vectorCords = vector.getComponents();
        return x * vectorCords[0] + y * vectorCords[1];
    }

    @Override
    public double[] getComponents() {
        return new double[]{x, y, 0};
    }
}
