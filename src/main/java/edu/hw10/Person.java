package edu.hw10;

public class Person {
    private String name;
    private int age;
    private String job;

    public Person(String name, int age, String job) {
        this.name = name;
        this.age = age;
        this.job = job;
    }

    @Override public String toString() {
        return "Person{"
            + "name='" + name + '\''
            + ", age=" + age
            + ", job='" + job + '\'' + '}';
    }
}
