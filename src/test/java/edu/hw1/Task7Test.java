package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task7Test {
    @Test
    void rotateRight_shouldRotateEightToFourWithShiftEqualsOne() {
        //arrange
        int exp = 4;
        int eight = 8;
        //act
        int act = Task7.rotateRight(eight, 1);
        //assert
        assertEquals(exp, act);
    }

    @Test
    void rotateLeft_shouldRotateSixteenToOneWithShiftEqualsOne() {
        //arrange
        int exp = 1;
        int sixteen = 16;
        //act
        int act = Task7.rotateLeft(sixteen, 1);
        //assert
        assertEquals(exp, act);
    }

    @Test
    void rotateLeft_shouldRotateSeventeenToSixWithShiftEqualsTwo() {
        //arrange
        int exp = 6;
        int seventeen = 17;
        //act
        int act = Task7.rotateLeft(seventeen, 2);
        //assert
        assertEquals(exp, act);
    }

    @Test
    void rotateRight_shouldRotateFifteenToItselfWithAnyShift() {
        //arrange
        int exp = 15;
        int fifteen = 15;
        //act
        int act = Task7.rotateRight(fifteen, 3);
        //assert
        assertEquals(exp, act);
    }

    @Test
    void rotateRight_shouldRotateTenToTenWithShiftEqualsFullCycleLength() {
        //arrange
        int exp = 10;
        int ten = 10;
        //act
        int act = Task7.rotateRight(ten, 4);
        //assert
        assertEquals(exp, act);
    }

}
