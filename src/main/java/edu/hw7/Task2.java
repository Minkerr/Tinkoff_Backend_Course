package edu.hw7;

import java.util.stream.IntStream;

public class Task2 {
    public static int parallelFactorial(int n) {
        if (n == 0) {
            return 1;
        }
        return IntStream.range(1, n + 1)
            .parallel()
            .reduce((int x, int y) -> x * y)
            .getAsInt();
    }

    private Task2() {
    }
}
