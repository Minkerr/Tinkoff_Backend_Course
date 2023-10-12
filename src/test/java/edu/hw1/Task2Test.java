package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {
    @Test
    void countDigits_shouldCountDigitsOfZero() {
        //arrange
        int expected = 1;
        int zero = 0;
        //act
        int act = Task2.countDigits(zero);
        //assert
        assertThat(act).isEqualTo(expected);
    }

    @Test
    void countDigits_shouldCountDigitsOfSix() {
        //arrange
        int expected = 1;
        int six = 6;
        //act
        int act = Task2.countDigits(6);
        //assert
        assertThat(act).isEqualTo(expected);
    }

    @Test
    void countDigits_shouldCountDigitsOfTwentyTwo() {
        //arrange
        int expected = 2;
        int twentyTwo = 22;
        //act
        int act = Task2.countDigits(twentyTwo);
        //assert
        assertThat(act).isEqualTo(expected);
    }

    @Test
    void countDigits_shouldCountDigitsOfBigNumber() {
        //arrange
        int expected = 4;
        int bigNumber = 2278;
        //act
        int act = Task2.countDigits(bigNumber);
        //assert
        assertThat(act).isEqualTo(expected);
    }
}
