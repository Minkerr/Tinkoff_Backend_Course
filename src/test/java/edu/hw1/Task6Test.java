package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task6Test {
    @Test
    void countK_shouldReturnThreeForNumber3524() {
        int exp = 3;
        int res = Task6.countK(3524, 0); // 3524 -> 3087 -> 8352 -> 6174
        assertEquals(exp, res);
    }

    @Test
    void countK_shouldReturnFiveForNumber6621() {
        int exp = 5;
        int res = Task6.countK(6621, 0); // 6621 -> 5355 -> 1998 -> 8082 -> 8532 -> 6174
        assertEquals(exp, res);
    }

    @Test
    void countK_shouldReturnFourForNumber6554() {
        int exp = 4;
        int res = Task6.countK(6554, 0); // 6554 -> 1998 -> 8082 -> 8532 -> 6174
        assertEquals(exp, res);
    }

    @Test
    void countK_shouldReturnThreeForNumber1234() {
        int exp = 3;
        int res = Task6.countK(1234, 0); // 1234 -> 3087 -> 8352 -> 6174
        assertEquals(exp, res);
    }

    @Test
    void countK_shouldReturnZeroForKaprekarsConstant() {
        int exp = 0;
        int res = Task6.countK(6174, 0);
        assertEquals(exp, res);
    }

    @Test
    void countK_shouldReturnErrorForOneThousand() {
        int exp = -1;
        int res = Task6.countK(1000, 0);
        assertEquals(exp, res);
    }

    @Test
    void countK_shouldReturnErrorForNumberWithTheSameDigits() {
        int exp = -1;
        int res = Task6.countK(6666, 0);
        assertEquals(exp, res);
    }

}
