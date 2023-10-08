package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task7Test {
    @Test
    void rotateRight_shouldRotateEightToFourWithShiftEqualsOne() {
        int exp = 4;
        int res = Task7.rotateRight(8, 1);
        assertEquals(exp, res);
    }

    @Test
    void rotateLeft_shouldRotateSixteenToOneWithShiftEqualsOne() {
        int exp = 1;
        int res = Task7.rotateLeft(16, 1);
        assertEquals(exp, res);
    }

    @Test
    void rotateLeft_shouldRotateSeventeenToSixWithShiftEqualsTwo() {
        int exp = 6;
        int res = Task7.rotateLeft(17, 2);
        assertEquals(exp, res);
    }

    @Test
    void rotateRight_shouldRotateFifteenToItselfWithAnyShift() {
        int exp = 15;
        int res = Task7.rotateRight(15, 3);
        assertEquals(exp, res);
    }

    @Test
    void rotateRight_shouldRotateTenToTenWithShiftEqualsFullCycleLength() {
        int exp = 10;
        int res = Task7.rotateRight(10, 4);
        assertEquals(exp, res);
    }

}
