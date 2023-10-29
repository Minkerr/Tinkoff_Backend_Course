package edu.project2;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Project2Test {
    @Test
    void renderMaze() {
        IdealGenerator generator = new IdealGenerator();
        Maze maze = generator.generate(20, 40);
        ConsoleRenderer renderer = new ConsoleRenderer();
        System.out.println(renderer.render(maze));

        DFSSolver solver = new DFSSolver();
        List<Coordinate> solution = solver.solve(maze,
            new Coordinate(1,1), new Coordinate(1,maze.getWidth() - 2));

        System.out.println(renderer.render(maze, solution));
    }

    @Test
    void consoleRender_shouldWork() {
        //arrange
        String exp = "#######\n# #   #\n#   # #\n#######\n";
        //act
        Cell[] secondRow = new Cell[]{
            new Cell(1,0, Cell.Type.WALL),
            new Cell(1,1, Cell.Type.PASSAGE),
            new Cell(1,2, Cell.Type.WALL),
            new Cell(1,3, Cell.Type.PASSAGE),
            new Cell(1,4, Cell.Type.PASSAGE),
            new Cell(1,5, Cell.Type.PASSAGE),
            new Cell(1,6, Cell.Type.WALL),};
        Cell[] thirdRow = new Cell[]{
            new Cell(2,0, Cell.Type.WALL),
            new Cell(2,1, Cell.Type.PASSAGE),
            new Cell(2,2, Cell.Type.PASSAGE),
            new Cell(2,3, Cell.Type.PASSAGE),
            new Cell(2,4, Cell.Type.WALL),
            new Cell(2,5, Cell.Type.PASSAGE),
            new Cell(2,6, Cell.Type.WALL),};
        Cell[] edgeRow = new Cell[]{
            new Cell(3,0, Cell.Type.WALL),
            new Cell(3,1, Cell.Type.WALL),
            new Cell(3,2, Cell.Type.WALL),
            new Cell(3,3, Cell.Type.WALL),
            new Cell(3,4, Cell.Type.WALL),
            new Cell(3,5, Cell.Type.WALL),
            new Cell(3,6, Cell.Type.WALL),};
        Cell [][] grid = {edgeRow, secondRow, thirdRow, edgeRow};
        ConsoleRenderer renderer = new ConsoleRenderer();
        String act = renderer.render(new Maze( 4, 7, grid));
        //assert
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void consoleRender_shouldWorkWithFindingPath() {
        //arrange
        String exp = "#######\n#•#•••#\n#•••#•#\n#######\n";
        //act
        Cell[] secondRow = new Cell[]{
            new Cell(1,0, Cell.Type.WALL),
            new Cell(1,1, Cell.Type.PASSAGE),
            new Cell(1,2, Cell.Type.WALL),
            new Cell(1,3, Cell.Type.PASSAGE),
            new Cell(1,4, Cell.Type.PASSAGE),
            new Cell(1,5, Cell.Type.PASSAGE),
            new Cell(1,6, Cell.Type.WALL),};
        Cell[] thirdRow = new Cell[]{
            new Cell(2,0, Cell.Type.WALL),
            new Cell(2,1, Cell.Type.PASSAGE),
            new Cell(2,2, Cell.Type.PASSAGE),
            new Cell(2,3, Cell.Type.PASSAGE),
            new Cell(2,4, Cell.Type.WALL),
            new Cell(2,5, Cell.Type.PASSAGE),
            new Cell(2,6, Cell.Type.WALL),};
        Cell[] edgeRow = new Cell[]{
            new Cell(3,0, Cell.Type.WALL),
            new Cell(3,1, Cell.Type.WALL),
            new Cell(3,2, Cell.Type.WALL),
            new Cell(3,3, Cell.Type.WALL),
            new Cell(3,4, Cell.Type.WALL),
            new Cell(3,5, Cell.Type.WALL),
            new Cell(3,6, Cell.Type.WALL),};
        Cell [][] grid = {edgeRow, secondRow, thirdRow, edgeRow};
        ConsoleRenderer renderer = new ConsoleRenderer();
        Maze maze = new Maze( 4, 7, grid);
        DFSSolver solver = new DFSSolver();
        Coordinate start = new Coordinate(1, 1);
        Coordinate end = new Coordinate(2, 5);
        List<Coordinate> path = solver.solve(maze, start, end);
        String act = renderer.render(maze, path);
        //assert
        assertThat(act).isEqualTo(exp);
    }
}
