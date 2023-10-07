package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class Task3Test {
    @Test
    void test1() {
        int[] a = new int[] {1, 2, 3, 4};
        int[] b = new int[] {0, 6};
        assertTrue(Task3.isNestable(a, b));
    }

    @Test
    void test2() {
        int[] a = new int[] {3, 1};
        int[] b = new int[] {4, 0};
        assertTrue(Task3.isNestable(a, b));
    }

    @Test
    void test3() {
        int[] a = new int[] {9, 9, 8};
        int[] b = new int[] {8, 9};
        assertFalse(Task3.isNestable(a, b));
    }

    @Test
    void test4() {
        int[] a = new int[] {1, 2, 3, 4};
        int[] b = new int[] {2, 3};
        assertFalse(Task3.isNestable(a, b));
    }
}
