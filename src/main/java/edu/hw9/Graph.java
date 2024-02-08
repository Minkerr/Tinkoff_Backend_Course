package edu.hw9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class Graph {
    private List<List<Integer>> list;
    private volatile int[] used;

    public Graph(int n) {
        this.list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        used = new int[n];
        Arrays.fill(used, 0);
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
        DFSTask dfsTask = new DFSTask(start);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.invoke(dfsTask);
    }

    private class DFSTask extends RecursiveTask<Void> {
        private int start;

        private DFSTask(int start) {
            this.start = start;
        }

        @Override
        protected Void compute() {
            used[start] = 1;
            for (var i : list.get(start)) {
                if (used[i] == 0) {
                    DFSTask dfsTask = new DFSTask(i);
                    dfsTask.fork();
                    dfsTask.join();
                }
            }
            return null;
        }
    }
}
