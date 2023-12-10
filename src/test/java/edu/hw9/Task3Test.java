package edu.hw9;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test {
    @Test
    void dfs_shouldWork() {
        //arrange
        var exp = new int[]{1, 1, 1, 1, 1, 1};
        Graph g = new Graph(6);
        g.add(0, 1);
        g.add(2, 1);
        g.add(2, 3);
        g.add(3, 4);
        g.add(3, 5);
        g.add(3, 1);
        //act
        g.dfs(0);
        var act = g.getUsed();
        //assert
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void dfs_shouldWorkForBigGraph() {
        //arrange
        int n = 1000;
        var exp = new int[n];
        Arrays.fill(exp, 1);
        Graph g = new Graph(n);
        for (int i = 0; i < n - 8 + 1; i++) {
            for (int j = 0; j < 8; j++) {
                g.add(i, i + j);
            }
        }
        //act
        g.dfs(0);
        var act = g.getUsed();
        //assert
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void dfsMultithreading_shouldWorkForBigGraph() {
        //arrange
        int n = 1000;
        var exp = new int[n];
        Arrays.fill(exp, 1);
        Graph g = new Graph(n);
        for (int i = 0; i < n - 8 + 1; i++) {
            for (int j = 0; j < 8; j++) {
                g.add(i, i + j);
            }
        }
        //act
        g.dfsMultithreading(0);
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        var act = g.getUsed();
        //assert
        assertThat(act).isEqualTo(exp);
    }
}
