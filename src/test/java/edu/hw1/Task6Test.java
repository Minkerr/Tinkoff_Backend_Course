package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task6Test {
    @Test
    void test1() {
        assertEquals(3, Task6.countK(3524, 0));
    }

    @Test
    void test2() {
        assertEquals(5, Task6.countK(6621, 0));
    }

    @Test
    void test3() {
        assertEquals(4, Task6.countK(6554, 0));
    }

    @Test
    void test4() {
        assertEquals(3, Task6.countK(1234, 0));
    }

    @Test
    void test5() {
        assertEquals(0, Task6.countK(6174, 0));
    }

}
