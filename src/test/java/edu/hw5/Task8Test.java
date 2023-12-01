package edu.hw5;

import org.junit.jupiter.api.Test;
import static edu.hw5.Task8.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task8Test {
    @Test
    void isOddLength_shouldFilterString10010() {
        assertThat(isOddLength("10010")).isTrue();
    }

    @Test
    void isOddLength_shouldFilterString000() {
        assertThat(isOddLength("000")).isTrue();
    }

    @Test
    void isOddLength_shouldFilterString1() {
        assertThat(isOddLength("1")).isTrue();
    }

    @Test
    void isOddLength_shouldNotFilterEmptyString() {
        assertThat(isOddLength("")).isFalse();
    }

    @Test
    void isOddLength_shouldNotFilterEvenLengthString() {
        assertThat(isOddLength("1010")).isFalse();
    }

    @Test
    void isOddLengthIfBeginsWithZeroOrEvenLengthIfBeginWithOne_shouldFilterString000() {
        assertThat(isOddLengthIfBeginsWithZeroOrEvenLengthIfBeginWithOne("000")).isTrue();
    }

    @Test
    void isOddLengthIfBeginsWithZeroOrEvenLengthIfBeginWithOne_shouldFilterString0() {
        assertThat(isOddLengthIfBeginsWithZeroOrEvenLengthIfBeginWithOne("0")).isTrue();
    }

    @Test
    void isOddLengthIfBeginsWithZeroOrEvenLengthIfBeginWithOne_shouldFilterString10() {
        assertThat(isOddLengthIfBeginsWithZeroOrEvenLengthIfBeginWithOne("10")).isTrue();
    }

    @Test
    void isOddLengthIfBeginsWithZeroOrEvenLengthIfBeginWithOne_shouldNotFilterString1() {
        assertThat(isOddLengthIfBeginsWithZeroOrEvenLengthIfBeginWithOne("1")).isFalse();
    }

    @Test
    void isOddLengthIfBeginsWithZeroOrEvenLengthIfBeginWithOne_shouldNotFilterString00() {
        assertThat(isOddLengthIfBeginsWithZeroOrEvenLengthIfBeginWithOne("00")).isFalse();
    }

    @Test
    void checkZeroQuantityMultipleOfThree_shouldFilterString000() {
        assertThat(checkZeroQuantityMultipleOfThree("000")).isTrue();
    }

    @Test
    void checkZeroQuantityMultipleOfThree_shouldFilterString1001101() {
        assertThat(checkZeroQuantityMultipleOfThree("1001101")).isTrue();
    }

    @Test
    void checkZeroQuantityMultipleOfThree_shouldFilterString010101000() {
        assertThat(checkZeroQuantityMultipleOfThree("010101000")).isTrue();
    }

    @Test
    void checkZeroQuantityMultipleOfThree_shouldFilterEmptyString() {
        assertThat(checkZeroQuantityMultipleOfThree("")).isTrue();
    }

    @Test
    void checkZeroQuantityMultipleOfThree_shouldNotFilterString00() {
        assertThat(checkZeroQuantityMultipleOfThree("00")).isFalse();
    }

    @Test
    void checkZeroQuantityMultipleOfThree_shouldNotFilterString101() {
        assertThat(checkZeroQuantityMultipleOfThree("101")).isFalse();
    }

    @Test
    void isString11or111_shouldNotFilter11() {
        assertThat(isString11or111("11")).isFalse();
    }

    @Test
    void isString11or111_shouldNotFilter111() {
        assertThat(isString11or111("111")).isFalse();
    }

    @Test
    void isString11or111_shouldFilter10() {
        assertThat(isString11or111("10")).isTrue();
    }

    @Test
    void isString11or111_shouldFilter1() {
        assertThat(isString11or111("1")).isTrue();
    }

    @Test
    void isString11or111_shouldFilter011() {
        assertThat(isString11or111("011")).isTrue();
    }

    @Test
    void isString11or111_shouldFilter1111() {
        assertThat(isString11or111("1111")).isTrue();
    }

    @Test
    void isEveryOddCharacterEqualsOne_shouldFilter1111() {
        assertThat(isEveryOddCharacterEqualsOne("1111")).isTrue();
    }

    @Test
    void isEveryOddCharacterEqualsOne_shouldFilter10101() {
        assertThat(isEveryOddCharacterEqualsOne("10111")).isTrue();
    }

    @Test
    void isEveryOddCharacterEqualsOne_shouldNotFilter01() {
        assertThat(isEveryOddCharacterEqualsOne("01")).isFalse();
    }

    @Test
    void isEveryOddCharacterEqualsOne_shouldFilter1() {
        assertThat(isEveryOddCharacterEqualsOne("1")).isTrue();
    }

    @Test
    void isEveryOddCharacterEqualsOne_shouldNotFilter11110() {
        assertThat(isEveryOddCharacterEqualsOne("11110")).isFalse();
    }

    @Test
    void checkUnitsLessThanOrEqualToOneAndZerosMoreThanOrEqualToTwo_shouldFilter00() {
        assertThat(checkUnitsLessThanOrEqualToOneAndZerosMoreThanOrEqualToTwo("00")).isTrue();
    }

    @Test
    void checkUnitsLessThanOrEqualToOneAndZerosMoreThanOrEqualToTwo_shouldFilter010() {
        assertThat(checkUnitsLessThanOrEqualToOneAndZerosMoreThanOrEqualToTwo("010")).isTrue();
    }

    @Test
    void checkUnitsLessThanOrEqualToOneAndZerosMoreThanOrEqualToTwo_shouldNotFilter1100() {
        assertThat(checkUnitsLessThanOrEqualToOneAndZerosMoreThanOrEqualToTwo("1100")).isFalse();
    }

    @Test
    void checkUnitsLessThanOrEqualToOneAndZerosMoreThanOrEqualToTwo_shouldNotFilter10() {
        assertThat(checkUnitsLessThanOrEqualToOneAndZerosMoreThanOrEqualToTwo("10")).isFalse();
    }

    @Test
    void areThereNoNeighboringOne_shouldFilter10101() {
        assertThat(areThereNoNeighboringOne("10101")).isTrue();
    }

    @Test
    void areThereNoNeighboringOne_shouldFilter010010010() {
        assertThat(areThereNoNeighboringOne("010010010")).isTrue();
    }

    @Test
    void areThereNoNeighboringOne_shouldFilter0() {
        assertThat(areThereNoNeighboringOne("0")).isTrue();
    }

    @Test
    void areThereNoNeighboringOne_shouldFilter1() {
        assertThat(areThereNoNeighboringOne("1")).isTrue();
    }

    @Test
    void areThereNoNeighboringOne_shouldNotFilter11() {
        assertThat(areThereNoNeighboringOne("11")).isFalse();
    }

    @Test
    void areThereNoNeighboringOne_shouldNotFilter01001100() {
        assertThat(areThereNoNeighboringOne("01001100")).isFalse();
    }
}
