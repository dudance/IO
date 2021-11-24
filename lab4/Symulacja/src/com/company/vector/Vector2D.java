package com.company.vector;

public class Vector2D implements IVector {

    private final double x;
    private final double y;

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public double[] getComponents() {
        return new double[] {x,y,0};
    }
}