package edu.project2;

abstract class Generator {
    abstract Maze generate(int height, int width);

    protected Cell[][] generateEmptyMazeWithExternalWall(int height, int width) {
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

    @SuppressWarnings("CyclomaticComplexity")
    protected boolean checkThatWallAreOnOneSide(Cell[][] grid, int row, int col) {
        boolean right = grid[row][col + 1].type() == Cell.Type.PASSAGE;
        boolean bottomRight = grid[row + 1][col + 1].type() == Cell.Type.PASSAGE;
        boolean bottom = grid[row + 1][col].type() == Cell.Type.PASSAGE;
        boolean bottomLeft = grid[row + 1][col - 1].type() == Cell.Type.PASSAGE;
        boolean left = grid[row][col - 1].type() == Cell.Type.PASSAGE;
        boolean topLeft = grid[row - 1][col - 1].type() == Cell.Type.PASSAGE;
        boolean top = grid[row - 1][col].type() == Cell.Type.PASSAGE;
        boolean topRight = grid[row - 1][col + 1].type() == Cell.Type.PASSAGE;
        boolean result = false;

        if (grid[row + 1][col].type() == Cell.Type.WALL) {
            result = left && topLeft && top && topRight && right;
        }
        if (grid[row - 1][col].type() == Cell.Type.WALL) {
            result = left && bottomLeft && bottom && bottomRight && right;
        }
        if (grid[row][col - 1].type() == Cell.Type.WALL) {
            result = top && topRight && right && bottomRight && bottom;
        }
        if (grid[row][col + 1].type() == Cell.Type.WALL) {
            result = top && topLeft && left && bottomLeft && bottom;
        }
        return result;
    }

    protected void addExtraWallsIfPossible(Cell[][] grid, int height, int width) {
        for (int i = 1; i < height - 1; i++) {
            for (int j = 1; j < width - 1; j++) {
                if (checkThatWallAreOnOneSide(grid, i, j)) {
                    grid[i][j] = new Cell(i, j, Cell.Type.WALL);
                }
            }
        }
    }
}
