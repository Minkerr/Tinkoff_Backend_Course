package edu.hw2.Task2;

public final class Square extends Rectangle {
    public Square() {
    }

    @Override
    public Rectangle setWidth(int width) {
        return new Rectangle(width, width);
    }

    @Override
    public Rectangle setHeight(int height) {
        return new Rectangle(height, height);
    }

}
