package edu.project4;

public record Rectangle(double x, double y, double width, double height) {
    boolean contains(Point p) {
        return p.x() > x &&  p.x() < x + height && p.y() > y && p.y() < y + height;
    }
}
