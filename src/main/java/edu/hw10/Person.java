package edu.hw10;

import org.jetbrains.annotations.NotNull;

public class Person {
    private String name;
    private int age;
    private double doubleField;

    public Person(String name, int age, double doubleField) {
        this.name = name;
        this.age = age;
        this.doubleField = doubleField;
    }

    public Person create(String name, @Min(18) int age, @Max(10) double doubleField) {
        return new Person(name, age, doubleField);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getDoubleField() {
        return doubleField;
    }
}
