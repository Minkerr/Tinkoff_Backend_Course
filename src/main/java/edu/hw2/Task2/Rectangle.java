package edu.hw2.Task2;

public class Rectangle {
    private final int width;
    private final int height;

    public Rectangle() {
        width = 1;
        height = 1;
    }

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public Rectangle setWidth(int width) {
        return new Rectangle(this.width, height);
    }

    public Rectangle setHeight(int height) {
        return new Rectangle(this.width, height);
    }

    public double area() {
        return width * height;
    }
}
