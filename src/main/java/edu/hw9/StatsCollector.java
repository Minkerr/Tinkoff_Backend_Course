package edu.hw9;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class StatsCollector {
    private final List<Double> data;
    private final List<Double> stats; //list with min, max and sum values

    public StatsCollector() {
        data = new CopyOnWriteArrayList<>();
        stats = new ArrayList<>();
        stats.add(Double.POSITIVE_INFINITY);
        stats.add(Double.NEGATIVE_INFINITY);
        stats.add(0.0);
    }

    public void push(double[] newData) {
        for (double i : newData) {
            synchronized (stats) {
                data.add(i);
                stats.set(0, Math.min(i, stats.get(0)));
                stats.set(1, Math.max(i, stats.get(1)));
                stats.set(2, stats.get(2) + i);
            }
        }
    }

    public double getMin() {
        synchronized (stats) {
            return stats.get(0);
        }
    }

    public double getMax() {
        synchronized (stats) {
            return stats.get(1);
        }
    }

    public double getSum() {
        synchronized (stats) {
            return stats.get(2);
        }
    }

    public double getAvg() {
        synchronized (stats) {
            return stats.get(2) / data.size();
        }
    }
}
