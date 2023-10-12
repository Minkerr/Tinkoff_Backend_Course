package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class Task3Test {
    @Test
    void isNestable_shouldDetermineZeroSixTest() {
        //arrange
        int[] a = new int[] {1, 2, 3, 4};
        int[] b = new int[] {0, 6};
        //assert
        assertTrue(Task3.isNestable(a, b));
    }

    @Test
    void isNestable_shouldDetermineFourZeroTest() {
        //arrange
        int[] a = new int[] {3, 1};
        int[] b = new int[] {4, 0};
        //assert
        assertTrue(Task3.isNestable(a, b));
    }

    @Test
    void isNestable_shouldNotDetermineEightNineTest() {
        //arrange
        int[] a = new int[] {9, 9, 8};
        int[] b = new int[] {8, 9};
        //assert
        assertFalse(Task3.isNestable(a, b));
    }

    @Test
    void isNestable_shouldNotDetermineTwoThreeTest() {
        //arrange
        int[] a = new int[] {1, 2, 3, 4};
        int[] b = new int[] {2, 3};
        //assert
        assertFalse(Task3.isNestable(a, b));
    }

    @Test
    void isNestable_shouldReturnFalseTestWithEmptyArray() {
        //arrange
        int[] a = new int[] {};
        int[] b = new int[] {2, 3};
        //assert
        assertFalse(Task3.isNestable(a, b));
    }

    @Test
    void isNestable_shouldReturnFalseTestWithNull() {
        //arrange
        int[] a = null;
        int[] b = new int[] {2, 3};
        //assert
        assertFalse(Task3.isNestable(a, b));
    }

}
