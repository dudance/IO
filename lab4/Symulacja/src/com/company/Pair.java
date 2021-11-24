package com.company;

import java.util.Objects;

public class Pair {

    private final Person firstPerson;
    private final Person secondPerson;

    public Pair(Person firstPerson, Person secondPerson) {
        this.firstPerson = firstPerson;
        this.secondPerson = secondPerson;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return firstPerson.equals(pair.firstPerson) &&
                secondPerson.equals(pair.secondPerson);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstPerson, secondPerson);
    }
}
