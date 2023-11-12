package edu.hw5;

import org.junit.jupiter.api.Test;
import static edu.hw5.Task7.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task7Test {
    @Test
    void isBitStringHasThirdSymbolZero_shouldReturnTrueFor100() {
        assertThat(isBitStringHasThirdSymbolZero("100")).isTrue();
    }

    @Test
    void isBitStringHasThirdSymbolZero_shouldReturnTrueFor11010() {
        assertThat(isBitStringHasThirdSymbolZero("11010")).isTrue();
    }

    @Test
    void isBitStringHasThirdSymbolZero_shouldReturnFalseFor111() {
        assertThat(isBitStringHasThirdSymbolZero("111")).isFalse();
    }

    @Test
    void isBitStringHasThirdSymbolZero_shouldReturnFalseForShortString() {
        assertThat(isBitStringHasThirdSymbolZero("11")).isFalse();
    }

    @Test
    void isBitStringHasThirdSymbolZero_shouldReturnFalseForNonBitString() {
        assertThat(isBitStringHasThirdSymbolZero("110102")).isFalse();
    }

    @Test
    void isBitStringHasEqualFirstAndLastSymbol_shouldReturnTrueFor111() {
        assertThat(isBitStringHasEqualFirstAndLastSymbol("111")).isTrue();
    }

    @Test
    void isBitStringHasEqualFirstAndLastSymbol_shouldReturnTrueFor01110010() {
        assertThat(isBitStringHasEqualFirstAndLastSymbol("01110010")).isTrue();
    }

    @Test
    void isBitStringHasEqualFirstAndLastSymbol_shouldReturnTrueForZero() {
        assertThat(isBitStringHasEqualFirstAndLastSymbol("0")).isTrue();
    }

    @Test
    void isBitStringHasEqualFirstAndLastSymbol_shouldReturnFalseFor011() {
        assertThat(isBitStringHasEqualFirstAndLastSymbol("011")).isFalse();
    }

    @Test
    void isBitStringHasEqualFirstAndLastSymbol_shouldReturnFalseFor10() {
        assertThat(isBitStringHasEqualFirstAndLastSymbol("10")).isFalse();
    }

    @Test
    void isBitStringLengthGreaterThanOneAndLessThanThree_shouldReturnTrueForOne() {
        assertThat(isBitStringLengthGreaterThanOneAndLessThanThree("1")).isTrue();
    }

    @Test
    void isBitStringLengthGreaterThanOneAndLessThanThree_shouldReturnTrueFor101() {
        assertThat(isBitStringLengthGreaterThanOneAndLessThanThree("101")).isTrue();
    }

    @Test
    void isBitStringLengthGreaterThanOneAndLessThanThree_shouldReturnTrueFor01() {
        assertThat(isBitStringLengthGreaterThanOneAndLessThanThree("01")).isTrue();
    }

    @Test
    void isBitStringLengthGreaterThanOneAndLessThanThree_shouldReturnFalseForNonBitString() {
        assertThat(isBitStringLengthGreaterThanOneAndLessThanThree("201")).isFalse();
    }

    @Test
    void isBitStringLengthGreaterThanOneAndLessThanThree_shouldReturnFalseForLongString() {
        assertThat(isBitStringLengthGreaterThanOneAndLessThanThree("10101")).isFalse();
    }

}
