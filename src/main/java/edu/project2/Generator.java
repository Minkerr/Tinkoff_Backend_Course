package edu.project2;

public interface Generator {
    Maze generate(int height, int width);

    default Cell[][] generateEmptyMazeWithExternalWall(int height, int width) {
        Cell[][] grid = new Cell[height][width];
        for (int i = 0; i < height; i++) {
            grid[i][0] = new Cell(i, 0, Cell.Type.WALL);
            grid[i][width - 1] = new Cell(i, 0, Cell.Type.WALL);
        }
        for (int i = 0; i < width; i++) {
            grid[0][i] = new Cell(i, 0, Cell.Type.WALL);
            grid[height - 1][i] = new Cell(i, 0, Cell.Type.WALL);
        }
        for (int i = 1; i < height - 1; i++) {
            for (int j = 1; j < width - 1; j++) {
                grid[i][j] = new Cell(i, j, Cell.Type.PASSAGE);
            }
        }
        return grid;
    }
}
