package edu.hw5;

import org.junit.jupiter.api.Test;
import static edu.hw5.Task5.isLicensePlateValid;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task5Test {
    @Test
    void isLicensePlateValid_shouldApproveO777AB666() {
        assertThat(isLicensePlateValid("O777AB777")).isTrue();
    }

    @Test
    void isLicensePlateValid_shouldApproveX123YP459() {
        assertThat(isLicensePlateValid("X123YP459")).isTrue();
    }

    @Test
    void isLicensePlateValid_shouldDeferPlateWithTwoDigits() {
        assertThat(isLicensePlateValid("X12YP459")).isFalse();
    }

    @Test
    void isLicensePlateValid_shouldDeferPlateWithFourDigits() {
        assertThat(isLicensePlateValid("X12YP459")).isFalse();
    }

    @Test
    void isLicensePlateValid_shouldDeferPlateWithRussianLetters() {
        assertThat(isLicensePlateValid("X124БP459")).isFalse();
    }

    @Test
    void isLicensePlateValid_shouldDeferPlateWithIncorrectOrder() {
        assertThat(isLicensePlateValid("X12MP3459")).isFalse();
    }
}
