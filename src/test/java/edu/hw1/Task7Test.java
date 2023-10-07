package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task7Test {
    @Test
    void test1() {
        assertEquals(4, Task7.rotateRight(8, 1));
    }

    @Test
    void test2() {
        assertEquals(1, Task7.rotateLeft(16, 1));
    }

    @Test
    void test3() {
        assertEquals(6, Task7.rotateLeft(17, 2));
    }

}
