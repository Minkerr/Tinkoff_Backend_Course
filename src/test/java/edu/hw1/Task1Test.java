package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {
    @Test
    void minutesToSeconds_shouldConvertIfTimeIsOneMinute() {
        int expected = 60;
        int given = Task1.minutesToSeconds("01:00");
        assertThat(given).isEqualTo(expected);
    }

    @Test
    void minutesToSeconds_shouldReturnErrorBecauseOfSixteenSeconds() {
        int expected = -1;
        int given = Task1.minutesToSeconds("10:60");
        assertThat(given).isEqualTo(expected);
    }

    @Test
    void minutesToSeconds_shouldConvertSimpleTest() {
        int expected = 836;
        int given = Task1.minutesToSeconds("13:56");
        assertThat(given).isEqualTo(expected);
    }

    @Test
    void minutesToSeconds_shouldConvertIfThereAreALotOfMinutes() {
        int expected = 59999;
        int given = Task1.minutesToSeconds("999:59");
        assertThat(given).isEqualTo(expected);
    }

    @Test
    void minutesToSeconds_shouldNotConvertEmptyString() {
        int expected = -1;
        int given = Task1.minutesToSeconds("");
        assertThat(given).isEqualTo(expected);
    }

    @Test
    void minutesToSeconds_shouldNotConvertStringWithCharacter() {
        int expected = -1;
        int given = Task1.minutesToSeconds("123a:12");
        assertThat(given).isEqualTo(expected);
    }

    @Test
    void minutesToSeconds_shouldNotConvertStringWithoutMinutes() {
        int expected = -1;
        int given = Task1.minutesToSeconds("234");
        assertThat(given).isEqualTo(expected);
    }
}
