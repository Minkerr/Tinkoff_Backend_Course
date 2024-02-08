package edu.hw7;

import java.util.concurrent.atomic.AtomicLong;

public class Task1 {
    public static long parallelIncrementor(long number, long add) {
        AtomicLong start = new AtomicLong(number);
        Thread leftThread = new Thread(() -> {
            for (int i = 0; i < add / 2; i++) {
                start.incrementAndGet();
            }
        });
        Thread rightThread = new Thread(() -> {
            for (int i = 0; i < (add + 1) / 2; i++) {
                start.incrementAndGet();
            }
        });
        rightThread.start();
        leftThread.start();
        try {
            rightThread.join();
            leftThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return start.get();
    }

    private Task1() {
    }
}
