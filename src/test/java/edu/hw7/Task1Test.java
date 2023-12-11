package edu.hw7;

import org.junit.jupiter.api.Test;
import static edu.hw7.Task1.parallelIncrementor;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {
    @Test
    void parallelIncrementor_shouldAddBigNumbers() {
        //arrange
        long exp = 1000001;
        //act
        var act = parallelIncrementor(1, 1000000);
        //assert
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void parallelIncrementor_shouldAddVeryBigAndOddNumbers() {
        //arrange
        long exp = 1_000_000_000;
        //act
        var act = parallelIncrementor(1, 999_999_999);
        //assert
        assertThat(act).isEqualTo(exp);
    }
}
