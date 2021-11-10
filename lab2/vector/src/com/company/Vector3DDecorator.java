package com.company;

public class Vector3DDecorator implements IVector {

    private final IVector srcVector;
    private final double z;

    public Vector3DDecorator(double x, double y, double z) {
        srcVector = new Vector2D(x, y);
        this.z = z;
    }

    @Override
    public double abs() {
        double[] vectorCords = srcVector.getComponents();
        return Math.sqrt(Math.pow(vectorCords[0], 2) + Math.pow(vectorCords[1], 2) + Math.pow(z, 2));
    }

    @Override
    public double cdot(IVector vector) {
        double[] firstVectorCords = srcVector.getComponents();
        double[] secondVectorCords = vector.getComponents();
        return firstVectorCords[0] * secondVectorCords[0] + firstVectorCords[1] * secondVectorCords[1] + z * secondVectorCords[2];
    }

    @Override
    public double[] getComponents() {
        double[] vectorCords = srcVector.getComponents();
        return new double[] {vectorCords[0], vectorCords[1], z};
    }

    public Vector3DDecorator cross(IVector vector) {
        double[] firstVectorCords = getComponents();
        double[] secondVectorCords = vector.getComponents();

        double a = firstVectorCords[1] * secondVectorCords[2] - z * secondVectorCords[1];
        double b = z * secondVectorCords[0] - firstVectorCords[0] * secondVectorCords[2];
        double c = firstVectorCords[0] * secondVectorCords[1] - firstVectorCords[1] * secondVectorCords[0];

        return new Vector3DDecorator(a, b, c);

    }

    public IVector grtSrcV() {
        return srcVector;
    }



}
