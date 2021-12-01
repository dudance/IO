package com.company;

import com.company.draw.DrawPerson;
import com.company.states.*;
import com.company.utils.Utils;
import com.company.vector.Vector2D;

import java.awt.*;
import java.util.*;

public class Person {
    private State state;
    private double[] cords;
    private double velocity;
    private Vector2D direction;
    private Set<Person> neighbors = new HashSet<>();
    private final DrawPerson drawPerson;
    private Color color;

    public Person(boolean containsResistance) {
        if (containsResistance) {
            state = new FirstStateWithResistance(this);
        } else {
            state = new FirstStateWithoutResistance(this);
        }
        direction = Utils.generateVector();
        velocity = Utils.generateVelocity();
        cords = Utils.generateStartCords(Utils.WIDTH * Utils.SCALE, Utils.HEIGHT * Utils.SCALE);
        drawPerson = new DrawPerson(this);
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public double[] getCords() {
        return cords;
    }

    public void setCords(double[] cords) {
        this.cords = cords;
    }

    public Set<Person> getNeighbors() {
        return neighbors;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void move(Population population) {

        if (this.getState() instanceof InfectedWithSymptoms || this.getState() instanceof InfectedWithoutSymptoms) {
            this.getState().handle();
            if (this.getState().handle()) {
                this.state = new Resistant(this);
                this.state.handle();
            }
        }
        velocity = Utils.generateVelocity();
        direction = Utils.generateVector();
        double x = cords[0];
        double y = cords[1];
        x = x + direction.getComponents()[0] * velocity;
        y = y + direction.getComponents()[1] * velocity;

        if (Utils.isOutOfBounds(x, Utils.WIDTH * Utils.SCALE) || Utils.isOutOfBounds(y, Utils.HEIGHT * Utils.SCALE)) {
            if (Utils.isLeaving()) {
                population.getListOfOutsiders().add(this);
            } else {
                double[] vector = direction.getComponents();
                if (Utils.isOutOfBounds(x, Utils.WIDTH * Utils.SCALE)) {
                    direction = new Vector2D(-vector[0], vector[1]);
                    cords[0] = Utils.WIDTH * Utils.SCALE - (x - Utils.WIDTH * Utils.SCALE);
                } else {
                    direction = new Vector2D(vector[0], -vector[1]);
                    cords[1] = Utils.HEIGHT * Utils.SCALE - (y - Utils.HEIGHT * Utils.SCALE);
                }
            }
        } else {
            cords = new double[]{x, y};
        }
        checkNeighbours(population);
    }

    public void checkNeighbours(Population population) {
        Set<Person> set = new HashSet<>();
        for (Person person : population.getSetOfPeople()) {
            if (Utils.getDistance(this.cords, person.cords) < 3 * Utils.SCALE) {
                set.add(person);
            }
        }
        set.remove(this);
        neighbors = set;
    }

    public void draw(Graphics g) {
        drawPerson.draw(g);
    }

    public void updateColor() {
        if (this.getState() instanceof InfectedWithSymptoms) {
            this.setColor(new Color(255, 0, 0));
        } else if (this.getState() instanceof InfectedWithoutSymptoms) {
            this.setColor(new Color(255, 255, 0));
        } else if (this.getState() instanceof Healthy) {
            this.setColor(new Color(0, 0, 0));
        } else if (this.getState() instanceof Resistant) {
            this.setColor(new Color(0, 255, 0));
        } else {
            this.setColor(new Color(12, 120, 255));
        }
    }

}
