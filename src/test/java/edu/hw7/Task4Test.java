package edu.hw7;

import org.junit.jupiter.api.Test;
import java.util.concurrent.ExecutionException;
import static edu.hw7.Task4.approximatingPIMonteCarlo;
import static edu.hw7.Task4.approximatingPIMonteCarloMultithreading;
import static edu.hw7.Task4.calculateInaccuracy;

public class Task4Test {
    @Test
    void approximatingPISingleThreadFor10m(){
        double res = approximatingPIMonteCarlo(10_000_000);
        System.out.println("Inaccuracy for 10m tests:  " + calculateInaccuracy(res));
    }

    @Test
    void approximatingPISingleThreadFor100m(){
        double res = approximatingPIMonteCarlo(100_000_000);
        System.out.println("Inaccuracy for 100m tests: " + calculateInaccuracy(res));
    }

    @Test
    void approximatingPISingleThreadFor1b(){
        double res = approximatingPIMonteCarlo(1_000_000_000);
        System.out.println("Inaccuracy for 1b tests:   " + calculateInaccuracy(res));
    }

    @Test
    void approximatingPIMultiThreadFor10m() throws ExecutionException, InterruptedException {
        double res = approximatingPIMonteCarloMultithreading(10_000_000);
        System.out.println("Inaccuracy for 10m tests:  " + calculateInaccuracy(res));
    }

    @Test
    void approximatingPIMultiThreadFor100m() throws ExecutionException, InterruptedException {
        double res = approximatingPIMonteCarloMultithreading(100_000_000);
        System.out.println("Inaccuracy for 100m tests: " + calculateInaccuracy(res));
    }

    @Test
    void approximatingPIMultiThreadFor1b() throws ExecutionException, InterruptedException {
        double res = approximatingPIMonteCarloMultithreading(1_000_000_000);
        System.out.println("Inaccuracy for 1b tests:   " + calculateInaccuracy(res));
    }
}
