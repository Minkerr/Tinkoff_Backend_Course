package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {
    @Test
    void test1() {
        int expected = 60;
        int given = Task1.minutesToSeconds("01:00");
        assertThat(given).isEqualTo(expected);
    }
    @Test
    void test2() {
        int expected = -1;
        int given = Task1.minutesToSeconds("10:60");
        assertThat(given).isEqualTo(expected);
    }
    @Test
    void test3() {
        int expected = 836;
        int given = Task1.minutesToSeconds("13:56");
        assertThat(given).isEqualTo(expected);
    }
    @Test
    void test4() {
        int expected = 59999;
        int given = Task1.minutesToSeconds("999:59");
        assertThat(given).isEqualTo(expected);
    }
}
