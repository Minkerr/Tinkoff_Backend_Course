package edu.hw7;

import org.junit.jupiter.api.Test;
import static edu.hw7.Task2.parallelFactorial;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {
    @Test
    void parallelFactorial_shouldReturnOneForOne () {
        //arrange
        int exp = 1;
        //act
        var act = parallelFactorial(0);
        //assert
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void parallelFactorial_shouldCalculateFactorialOfOne () {
        //arrange
        int exp = 1;
        //act
        var act = parallelFactorial(1);
        //assert
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void parallelFactorial_shouldCalculateFactorialOfTwo () {
        //arrange
        int exp = 2;
        //act
        var act = parallelFactorial(2);
        //assert
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void parallelFactorial_shouldCalculateFactorialOf7 () {
        //arrange
        int exp = 5040;
        //act
        var act = parallelFactorial(7);
        //assert
        assertThat(act).isEqualTo(exp);
    }
}
