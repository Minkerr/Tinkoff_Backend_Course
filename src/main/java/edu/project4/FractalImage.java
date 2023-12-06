package edu.project4;

public record FractalImage(Pixel[][] data, int width, int height) {
    public static FractalImage create(int width, int height) {
        return new FractalImage(new Pixel[width][height], width, height);
    }

    boolean contains(int x, int y) {
        return this.data[x][y] != null;
    }

    Pixel pixel(int x, int y) {
        return data[x][y];
    }
}
