package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {
    @Test
    void test1() {
        int expected = 1;
        int given = Task2.countDigits(0);
        assertThat(given).isEqualTo(expected);
    }

    @Test
    void test2() {
        int expected = 1;
        int given = Task2.countDigits(6);
        assertThat(given).isEqualTo(expected);
    }

    @Test
    void test3() {
        int expected = 2;
        int given = Task2.countDigits(22);
        assertThat(given).isEqualTo(expected);
    }

    @Test
    void test4() {
        int expected = 4;
        int given = Task2.countDigits(2278);
        assertThat(given).isEqualTo(expected);
    }
}
