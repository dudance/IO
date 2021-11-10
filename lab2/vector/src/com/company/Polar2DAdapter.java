package com.company;

public class Polar2DAdapter implements IPolar2D, IVector {


    public Polar2DAdapter(double x, double y) {
        this.srcVector = new Vector2D(x, y);
    }

    private final Vector2D srcVector;

    @Override
    public double abs() {
        return srcVector.abs();
    }

    @Override
    public double getAngle() {
        double[] vectorCords = srcVector.getComponents();
        return Math.atan2(vectorCords[1], vectorCords[0]) * 180 / Math.PI;
    }

    public double cdot(IVector vector) {
        return srcVector.cdot(vector);
    }

    public double[] getComponents() {
        return srcVector.getComponents();
    }
}
