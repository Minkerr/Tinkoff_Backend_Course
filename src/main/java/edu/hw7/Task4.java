package edu.hw7;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.LongAdder;

public class Task4 {
    private Task4() {
    }

    private static final int COEFFICIENT_FOR_PI_APPROXIMATING = 4;
    private static final int N_THREADS = 8;

    public static double approximatingPIMonteCarlo(int n) {
        long circ = 0;
        double x;
        double y;
        for (int i = 0; i < n; i++) {
            x = ThreadLocalRandom.current().nextDouble(-1.0, 1.0);
            y = ThreadLocalRandom.current().nextDouble(-1.0, 1.0);
            if (x * x + y * y < 1) {
                circ++;
            }
        }
        return COEFFICIENT_FOR_PI_APPROXIMATING * ((double) circ / n);
    }

    public static double approximatingPIMonteCarloMultithreading(int n) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(N_THREADS);
        CountDownLatch countDownLatch = new CountDownLatch(N_THREADS);
        LongAdder l = new LongAdder();
        Runnable task = () -> {
            double x;
            double y;
            for (int i = 0; i < n / N_THREADS; i++) {
                x = ThreadLocalRandom.current().nextDouble(-1.0, 1.0);
                y = ThreadLocalRandom.current().nextDouble(-1.0, 1.0);
                if (x * x + y * y < 1) {
                    l.increment();
                }
            }
            countDownLatch.countDown();
        };
        for (int i = 0; i < N_THREADS; i++) {
            executor.execute(task);
        }
        countDownLatch.await();
        executor.shutdown();
        return COEFFICIENT_FOR_PI_APPROXIMATING * (l.doubleValue() / n);
    }

    public static double calculateInaccuracy(double x) {
        return Math.abs(x - Math.PI);
    }
}
