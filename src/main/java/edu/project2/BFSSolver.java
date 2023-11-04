package edu.project2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSSolver implements Solver {
    @Override
    public List<Coordinate> solve(Maze maze, Coordinate start, Coordinate end) {
        Cell[][] grid = maze.getGrid();
        int height = maze.getHeight();
        int width = maze.getWidth();
        // initialise used and prev arrays
        boolean[][] used = new boolean[height][width];
        initUsedWithWalls(used, grid, height, width);
        Coordinate[][] prev = new Coordinate[height][width];
        // find a solution
        bfs(start, grid, used, prev);
        List<Coordinate> solution = rebuildSolution(prev, start, end);
        return solution;
    }

    private void bfs(Coordinate v, Cell[][] grid, boolean[][] used, Coordinate[][] prev) {
        final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; //directions
        Queue<Coordinate> queue = new LinkedList<>();
        int row = v.row();
        int col = v.col();
        used[row][col] = true;
        queue.add(new Coordinate(row, col));
        while (!queue.isEmpty()) {
            row = queue.peek().row();
            col = queue.peek().col();
            for (int[] dir : directions) {
                if (!used[row + dir[0]][col + dir[1]]) {
                    queue.add(new Coordinate(row + dir[0], col + dir[1]));
                    prev[row + dir[0]][col + dir[1]] = new Coordinate(row, col);
                    used[row + dir[0]][col + dir[1]] = true;
                }
            }
            queue.poll();
        }
    }

    private List<Coordinate> rebuildSolution(Coordinate[][] prev, Coordinate start, Coordinate end) {
        List<Coordinate> solution = new ArrayList<>();
        int x = end.row();
        int y = end.col();
        while (!((x == start.row()) && (y == start.col()))) {
            solution.add(new Coordinate(x, y));
            int newX = prev[x][y].row();
            int newY = prev[x][y].col();
            x = newX;
            y = newY;
        }
        solution.add(new Coordinate(1, 1));
        Collections.reverse(solution);
        return solution; //reconstruct solution with prev array help
    }

    private void initUsedWithWalls(boolean[][] used, Cell[][] grid, int height, int width) {
        for (int i = 0; i < height; i++) { // Mark WALLS as used, because we go only through passages
            for (int j = 0; j < width; j++) {
                if (grid[i][j].type() == Cell.Type.WALL) {
                    used[i][j] = true;
                }
            }
        }
    }
}
