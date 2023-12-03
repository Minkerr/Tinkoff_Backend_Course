package edu.hw8.Task2;

import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingDeque;

public class FixedThreadPool implements ThreadPool {
    private final LinkedBlockingDeque<Runnable> taskQueue;

    private final Thread[] threads;

    private final int nThread;

    private FixedThreadPool(int nThread){
        this.threads = new Thread[nThread];
        this.nThread = nThread;
        this.taskQueue = new LinkedBlockingDeque<>();
    }
    public static FixedThreadPool create(int nThread) {
        return new FixedThreadPool(nThread);
    }

    @Override
    public void start() {
        for (int i = 0; i < nThread; i++) {
            threads[i] = new Thread(() -> {
                while (true){
                    try {
                        taskQueue.take().run();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        break;
                    }
                }
            });
            threads[i].start();
        }
    }

    @Override
    public void execute(Runnable runnable) {
        taskQueue.add(runnable);
    }

    @Override
    public void close() throws Exception {
        for (var thread : threads) {
            thread.interrupt();
            thread.join();
        }
    }
}
