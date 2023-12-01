package edu.project2;

public final class Maze {
    private final Cell[][] grid;

    public Maze(Cell[][] grid) {
        this.grid = grid;
    }

    public int getHeight() {
        return grid.length;
    }

    public int getWidth() {
        return grid[0].length;
    }

    public Cell[][] getGrid() {
        return grid;
    }
}
