package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task5Test {
    @Test
    void isPalindromeDescendant_shouldReturnTrueForNum11211230(){
        int num = 11211230; //11211230 -> 2333 -> 56 -> 11
        boolean res = Task5.isPalindromeDescendant(num);
        assertTrue(res);
    }

    @Test
    void isPalindromeDescendant_shouldReturnTrueForNum13001120(){
        int num = 13001120; //13001120 -> 4022 -> 44
        boolean res = Task5.isPalindromeDescendant(num);
        assertTrue(res);
    }

    @Test
    void isPalindromeDescendant_shouldReturnTrueForNum23336014(){
        int num = 23336014; //23336014 -> 5665
        boolean res = Task5.isPalindromeDescendant(num);
        assertTrue(res);
    }

    @Test
    void isPalindromeDescendant_shouldReturnTrueForEleven(){
        int num = 11;
        boolean res = Task5.isPalindromeDescendant(num);
        assertTrue(res);
    }

    @Test
    void isPalindromeDescendant_shouldReturnFalseForOddLengthNumber(){
        int num = 145;  //odd number of digits
        boolean res = Task5.isPalindromeDescendant(num);
        assertFalse(res);
    }

    @Test
    void isPalindromeDescendant_shouldReturnFalseForDigit(){
        int num = 1;  //odd number of digits
        boolean res = Task5.isPalindromeDescendant(num);
        assertFalse(res);
    }
}
