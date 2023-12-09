package edu.hw9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Task3 {
    public static class Graph {
        private List<List<Integer>> list;
        private volatile int[] used;
        private ExecutorService executor;

        public Graph(int n) {
            this.list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(new ArrayList<>());
            }
            used = new int[n];
            Arrays.fill(used, 0);
            executor = Executors.newWorkStealingPool(8);
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
            executor.submit(new dfsTask(start));
        }

        private class dfsTask implements Runnable {
            private int start;

            public dfsTask(int start) {
                this.start = start;
            }

            @Override
            public void run() {
                dfs(start);
            }

            private void dfs(int start) {
                used[start] = 1;
                //System.out.println("eee");
                for (var i : list.get(start)) {
                    if (used[i] == 0) {
                        executor.execute(new dfsTask(i));
                    }
                }
            }
        }
    }
}
