package edu.project2;

public class IdealGenerator extends Generator {
    private final int wallGenerationAttemptCoefficient = 100;

    @Override
    public Maze generate(int height, int width) {
        Cell[][] grid = generateEmptyMazeWithExternalWall(height, width);
        buildUpTheMazeByAddingRandomWalls(grid, height, width);
        addExtraWallsIfPossible(grid, height, width);
        return new Maze(grid);
    }

    private void buildUpTheMazeByAddingRandomWalls(Cell[][] grid, int height, int width) {
        for (int k = 0; k < height * width * wallGenerationAttemptCoefficient; k++) {
            int row = getRandomNumber(1, height - 1);
            int col = getRandomNumber(1, width - 1);
            if (checkThatWallAreOnOneSide(grid, row, col)) {
                grid[row][col] = new Cell(row, col, Cell.Type.WALL);
            }
        }
    }

    private int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
