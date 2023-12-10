package edu.hw9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Graph {
    private List<List<Integer>> list;
    private volatile int[] used;
    private ExecutorService executor;
    private final int nThreads = 8;

    public Graph(int n) {
        this.list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        used = new int[n];
        Arrays.fill(used, 0);
        executor = Executors.newWorkStealingPool(nThreads);
    }

    public int[] getUsed() {
        return used;
    }

    public void add(int from, int to) {
        list.get(from).add(to);
        list.get(to).add(from);
    }

    public void dfs(int start) {
        used[start] = 1;
        for (var i : list.get(start)) {
            if (used[i] == 0) {
                dfs(i);
            }
        }
    }

    public void dfsMultithreading(int start) {
        executor.submit(new DFSTask(start));
    }

    private class DFSTask implements Runnable {
        private int start;

        private DFSTask(int start) {
            this.start = start;
        }

        @Override
        public void run() {
            dfs(start);
        }

        private void dfs(int start) {
            used[start] = 1;
            for (var i : list.get(start)) {
                if (used[i] == 0) {
                    executor.execute(new DFSTask(i));
                }
            }
        }
    }
}
