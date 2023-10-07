package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task5Test {
    @Test
    void test1(){
        assertTrue(Task5.isPalindromeDescendant(11211230));
    }

    @Test
    void test2(){
        assertTrue(Task5.isPalindromeDescendant(13001120));
    }

    @Test
    void test3(){
        assertTrue(Task5.isPalindromeDescendant(23336014));
    }

    @Test
    void test4(){
        assertTrue(Task5.isPalindromeDescendant(11));
    }

    @Test
    void test5(){
        assertFalse(Task5.isPalindromeDescendant(145));
    }
}
