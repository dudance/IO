package com.company;

public class Vector3DInheritance extends Vector2D {

    private final double z;

    public Vector3DInheritance(double x,double y,double z) {
        super(x, y);
        this.z = z;
    }


    public double abs() {
        double[] vectorCords = getComponents();
        return Math.sqrt(Math.pow(vectorCords[0], 2) + Math.pow(vectorCords[1], 2) + Math.pow(z, 2));
    }

    public double cdot(IVector vector) {
        double[] firstVectorCords = getComponents();
        double[] secondVectorCords = vector.getComponents();
        return firstVectorCords[0] * secondVectorCords[0] + firstVectorCords[1] * secondVectorCords[1] + z * secondVectorCords[2];
    }

    public double[] getComponents() {
        double[] vectorCords = super.getComponents();
        return new double[]{vectorCords[0], vectorCords[1], z};
    }

    public Vector3DInheritance cross(IVector vector) {
        double[] firstVectorCords = getComponents();
        double[] secondVectorCords = vector.getComponents();
        double a = firstVectorCords[1] * secondVectorCords[2] - z * secondVectorCords[1];
        double b = z * secondVectorCords[0] - firstVectorCords[0] * secondVectorCords[2];
        double c = firstVectorCords[0] * secondVectorCords[1] - firstVectorCords[1] * secondVectorCords[0];
        return new Vector3DInheritance(a, b, c);
    }

    public IVector getSrcV() {
        double[] vectorCords = getComponents();
        return new Vector2D(vectorCords[0], vectorCords[1]);
    }

}
