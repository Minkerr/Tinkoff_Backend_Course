package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task6Test {
    @Test
    void countK_shouldReturnThreeForNumber3524() {
        //arrange
        int exp = 3;
        int number3524 = 3524;
        //act
        int act = Task6.countK(number3524, 0); // 3524 -> 3087 -> 8352 -> 6174
        //assert
        assertEquals(exp, act);
    }

    @Test
    void countK_shouldReturnFiveForNumber6621() {
        //arrange
        int exp = 5;
        int number6621 = 6621;
        //act
        int act = Task6.countK(number6621, 0); // 6621 -> 5355 -> 1998 -> 8082 -> 8532 -> 6174
        //assert
        assertEquals(exp, act);
    }

    @Test
    void countK_shouldReturnFourForNumber6554() {
        //arrange
        int exp = 4;
        int number36554 = 6554;
        //act
        int act = Task6.countK(number36554, 0); // 6554 -> 1998 -> 8082 -> 8532 -> 6174
        //assert
        assertEquals(exp, act);
    }

    @Test
    void countK_shouldReturnThreeForNumber1234() {
        //arrange
        int exp = 3;
        int number1234 = 1234;
        //act
        int act = Task6.countK(number1234, 0); // 1234 -> 3087 -> 8352 -> 6174
        //assert
        assertEquals(exp, act);
    }

    @Test
    void countK_shouldReturnZeroForKaprekarsConstant() {
        //arrange
        int exp = 0;
        int kaprekarsConstant = 6174;
        //act
        int act = Task6.countK(kaprekarsConstant, 0);
        //assert
        assertEquals(exp, act);
    }

    @Test
    void countK_shouldReturnErrorForOneThousand() {
        //arrange
        int exp = -1;
        int oneThousand = 1000;
        //act
        int act = Task6.countK(oneThousand, 0);
        //assert
        assertEquals(exp, act);
    }

    @Test
    void countK_shouldReturnErrorForNumberWithTheSameDigits() {
        //arrange
        int exp = -1;
        int numberWithTheSameDigits = 6666;
        //act
        int act = Task6.countK(numberWithTheSameDigits, 0);
        //assert
        assertEquals(exp, act);
    }

}
