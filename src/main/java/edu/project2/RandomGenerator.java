package edu.project2;

public class RandomGenerator implements Generator{
    private final int wallGenerationAttemptCoefficient = 100;
    @Override
    public Maze generate(int height, int width) {
        Cell[][] grid = generateEmptyMazeWithExternalWall(height, width);
        buildUpTheMazeByAddingRandomWalls(grid, height, width);
        addExtraWallsIfPossible(grid, height, width);
        return new Maze(height, width, grid);
    }

    private void buildUpTheMazeByAddingRandomWalls(Cell[][] grid, int height, int width) {
        for (int k = 0; k < height * width * wallGenerationAttemptCoefficient; k++) {
            int row = getRandomNumber(1, height - 1);
            int col = getRandomNumber(1, width - 1);
            if (checkThatWallAreOnOneSide(grid, row, col) || checkThatThisCellIsSurroundedByPassages(grid, row, col)) {
                grid[row][col] = new Cell(row, col, Cell.Type.WALL);
            }
        }
    }

    private void addExtraWallsIfPossible(Cell[][] grid, int height, int width) {
        for (int i = 1; i < height - 1; i++) {
            for (int j = 1; j < width - 1; j++) {
                if (checkThatWallAreOnOneSide(grid, i, j)) {
                    grid[i][j] = new Cell(i, j, Cell.Type.WALL);
                }
            }
        }
    }

    private boolean checkThatThisCellIsSurroundedByPassages(Cell[][] grid, int row, int col) {
        boolean right = grid[row][col + 1].type() == Cell.Type.PASSAGE;
        boolean bottomRight = grid[row + 1][col + 1].type() == Cell.Type.PASSAGE;
        boolean bottom = grid[row + 1][col].type() == Cell.Type.PASSAGE;
        boolean bottomLeft = grid[row + 1][col - 1].type() == Cell.Type.PASSAGE;
        boolean left = grid[row][col - 1].type() == Cell.Type.PASSAGE;
        boolean topLeft = grid[row - 1][col - 1].type() == Cell.Type.PASSAGE;
        boolean top = grid[row - 1][col].type() == Cell.Type.PASSAGE;
        boolean topRight = grid[row - 1][col + 1].type() == Cell.Type.PASSAGE;
        return right && bottomRight && bottom && bottomLeft && left && topLeft && top && topRight;
    }

        @SuppressWarnings("CyclomaticComplexity")
    private boolean checkThatWallAreOnOneSide(Cell[][] grid, int row, int col) {
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
}
