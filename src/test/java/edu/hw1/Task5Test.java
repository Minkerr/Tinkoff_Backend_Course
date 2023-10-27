package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task5Test {
    @Test
    void isPalindromeDescendant_shouldReturnTrueForNum11211230(){
        //arrange
        int num = 11211230; //11211230 -> 2333 -> 56 -> 11
        //act
        boolean res = Task5.isPalindromeDescendant(num);
        //assert
        assertTrue(res);
    }

    @Test
    void isPalindromeDescendant_shouldReturnTrueForNum13001120(){
        //arrange
        int num = 13001120; //13001120 -> 4022 -> 44
        //act
        boolean res = Task5.isPalindromeDescendant(num);
        //assert
        assertTrue(res);
    }

    @Test
    void isPalindromeDescendant_shouldReturnTrueForNum23336014(){
        //arrange
        int num = 23336014; //23336014 -> 5665
        //act
        boolean res = Task5.isPalindromeDescendant(num);
        //assert
        assertTrue(res);
    }

    @Test
    void isPalindromeDescendant_shouldReturnTrueForEleven(){
        //arrange
        int num = 11;
        //act
        boolean res = Task5.isPalindromeDescendant(num);
        //assert
        assertTrue(res);
    }

    @Test
    void isPalindromeDescendant_shouldReturnFalseForOddLengthNumber(){
        //arrange
        int num = 145;  //odd number of digits
        //act
        boolean res = Task5.isPalindromeDescendant(num);
        //assert
        assertFalse(res);
    }

    @Test
    void isPalindromeDescendant_shouldReturnFalseForDigit(){
        //arrange
        int num = 1;  //odd number of digits
        //act
        boolean res = Task5.isPalindromeDescendant(num);
        //assert
        assertFalse(res);
    }
}
