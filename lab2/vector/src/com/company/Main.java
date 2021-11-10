package com.company;


import java.util.Arrays;

public class Main {


    public static void main(String[] args) {

        D2PolarInheritance vector2D = new D2PolarInheritance(5, 5);
        Vector3DDecorator vector3D = new Vector3DDecorator(5, 10, 15);
        Vector3DInheritance vector3DInheritance = new Vector3DInheritance(5, 3, 2);

        System.out.println("pierwsze wspolrzedne kartezjanskie: " + Arrays.toString(vector2D.getComponents()));
        System.out.println("pierwsze wspolrzedne biegunowe: modul: " + vector2D.abs() + " , kat: " + vector2D.getAngle());
        System.out.println("drugie wspolrzedne kartezjanskie: " + Arrays.toString(vector3D.getComponents()));
        D2PolarInheritance temp = new D2PolarInheritance(vector3D.getComponents()[0], vector3D.getComponents()[1]);
        System.out.println("drugie wspolrzedne biegunowe: modul: " + vector3D.abs() + " , kat: " + temp.getAngle());
        System.out.println("trzecie wspolrzedne kartezjanskie: " + Arrays.toString(vector3DInheritance.getComponents()));
        D2PolarInheritance temp2 = new D2PolarInheritance(vector3DInheritance.getComponents()[0], vector3DInheritance.getComponents()[1]);
        System.out.println("trzecie wspolrzedne biegunowe: modul: " + vector3DInheritance.abs() + " , kat: " + temp2.getAngle());

        System.out.println("iloczyn skalarny wektora 1 i 2: " + vector2D.cdot(vector3D));
        System.out.println("iloczyn skalarny wektora 2 i 3: " + vector3D.cdot(vector3DInheritance));
        System.out.println("iloczyn skalarny wektora 1 i 3: " + vector2D.cdot(vector3DInheritance));

        System.out.println("iloczyn wektorowy wektora 1 i 2: " + Arrays.toString(vector3D.cross(vector2D).getComponents()));
        System.out.println("iloczyn wektorowy wektora 2 i 3: " + Arrays.toString(vector3D.cross(vector3DInheritance).getComponents()));
        System.out.println("iloczyn wektorowy wektora 1 i 3: " + Arrays.toString(vector3DInheritance.cross(vector2D).getComponents()));

    }
}
