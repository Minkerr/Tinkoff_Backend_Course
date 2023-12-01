package edu.project2;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConsoleRenderer implements Renderer {

    @Override
    public String render(Maze maze) {
        StringBuilder renderedMaze = new StringBuilder();
        Cell[][] grid = maze.getGrid();
        for (int i = 0; i < maze.getHeight(); i++) {
            for (int j = 0; j < maze.getWidth(); j++) {
                if (grid[i][j].type() == Cell.Type.WALL) {
                    renderedMaze.append("#");
                } else {
                    renderedMaze.append(" ");
                }
            }
            renderedMaze.append("\n");
        }

        return renderedMaze.toString();
    }

    @Override
    public String render(Maze maze, List<Coordinate> path) {
        StringBuilder renderedMazeWithPath = new StringBuilder();
        Set<Coordinate> pathCellsSet = new HashSet<>(path);
        Cell[][] grid = maze.getGrid();
        for (int i = 0; i < maze.getHeight(); i++) {
            for (int j = 0; j < maze.getWidth(); j++) {
                if (pathCellsSet.contains(new Coordinate(i, j))) {
                    renderedMazeWithPath.append("•");
                } else if (grid[i][j].type() == Cell.Type.WALL) {
                    renderedMazeWithPath.append("#");
                } else {
                    renderedMazeWithPath.append(" ");
                }
            }
            renderedMazeWithPath.append("\n");
        }

        return renderedMazeWithPath.toString();
    }
}
