package edu.hw8;

import edu.hw8.Task2.FixedThreadPool;
import edu.hw8.Task2.ThreadPool;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {
    private long calculateFibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return calculateFibonacci(n - 1) + calculateFibonacci(n - 2);
        }
    }

    @Test
    void threadPool_shouldCountFibonacciNumber() throws Exception {
        //arrange
        List<Long> numbers = new ArrayList<>();
        //act
        try (ThreadPool threadPool = FixedThreadPool.create(8)) {
            threadPool.start();

            for (int i = 0; i < 33; ++i) {
                int n = i;
                threadPool.execute(() -> numbers.add(calculateFibonacci(n)));
            }
        }
        Collections.sort(numbers);
        //assert
        assertThat(numbers.get(31)).isEqualTo(numbers.get(30) + numbers.get(29));

    }
}
