package com.company;

import com.company.draw.DrawPerson;
import com.company.states.FirstStateWithoutResistance;
import com.company.utils.Utils;
import com.company.vector.Vector2D;
import com.company.states.FirstStateWithResistance;
import com.company.states.Resistant;
import com.company.states.State;

import java.awt.*;
import java.util.*;

public class Person {
    private State state;
    private double[] cords;
    private double velocity;
    private Vector2D direction;
    private Set<Person> neighbors = new HashSet<>();
    private DrawPerson drawPerson;
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
        Population.set.add(this);
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

    public double getVelocity() {
        return velocity;
    }

    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }

    public Vector2D getDirection() {
        return direction;
    }

    public void setDirection(Vector2D direction) {
        this.direction = direction;
    }

    public Set<Person> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(Set<Person> neighbors) {
        this.neighbors = neighbors;
    }

    public DrawPerson getDrawPerson() {
        return drawPerson;
    }

    public void setDrawPerson(DrawPerson drawPerson) {
        this.drawPerson = drawPerson;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void move() {
        velocity = Utils.generateVelocity();
        direction = Utils.generateVector();
        double x = cords[0];
        double y = cords[1];
        x = x + direction.getComponents()[0] * velocity;
        y = y + direction.getComponents()[1] * velocity;

        if (Utils.isOutOfBounds(x, Utils.WIDTH * Utils.SCALE) || Utils.isOutOfBounds(y, Utils.HEIGHT * Utils.SCALE)) {
            if (Utils.isLeaving()) {
                Population.removeList.add(this);
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
        checkNeighbours();
    }

    public void checkNeighbours() {
        Set<Person> set = new HashSet<>();
        for (Person person : Population.set) {
            if (Utils.getDistance(this.cords, person.cords) < 3 * Utils.SCALE) {
                Pair pair = new Pair(this, person);
                set.add(person);
                if (Population.mapOfPairs.containsKey(pair)) {
                    Population.mapOfPairs.put(pair, Population.mapOfPairs.get(pair) + 1);
                } else {
                    Population.mapOfPairs.put(pair, 0);
                }
            }
        }

        set.remove(this);
        neighbors = set;
    }

    public void draw(Graphics g) {
        drawPerson.draw(g);
    }


    public void curePerson(Person person) {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                person.state = new Resistant(person);
                person.state.handle();

            }
        }, 20000);
    }

}
