package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {
    @Test
    void minutesToSeconds_shouldConvertIfTimeIsOneMinute() {
        //arrange
        int expected = 60;
        String OneMinute = "01:00";
        //act
        int act = Task1.minutesToSeconds(OneMinute);
        //assert
        assertThat(act).isEqualTo(expected);
    }

    @Test
    void minutesToSeconds_shouldReturnErrorBecauseOfSixteenSeconds() {
        //arrange
        int expected = -1;
        String SixtySeconds = "10:60";
        //act
        int act = Task1.minutesToSeconds(SixtySeconds);
        //assert
        assertThat(act).isEqualTo(expected);
    }

    @Test
    void minutesToSeconds_shouldConvertSimpleTest() {
        //arrange
        int expected = 836;
        String SimpleTest = "13:56";
        //act
        int act = Task1.minutesToSeconds(SimpleTest);
        //assert
        assertThat(act).isEqualTo(expected);
    }

    @Test
    void minutesToSeconds_shouldConvertIfThereAreALotOfMinutes() {
        //arrange
        int expected = 59999;
        String ALotOfMinutes = "999:59";
        //act
        int act = Task1.minutesToSeconds(ALotOfMinutes);
        //assert
        assertThat(act).isEqualTo(expected);
    }

    @Test
    void minutesToSeconds_shouldNotConvertEmptyString() {
        //arrange
        int expected = -1;
        String EmptyString = "";
        //act
        int act = Task1.minutesToSeconds(EmptyString);
        //assert
        assertThat(act).isEqualTo(expected);
    }

    @Test
    void minutesToSeconds_shouldNotConvertStringWithCharacter() {
        //arrange
        int expected = -1;
        String stringWithCharacter = "123a:12";
        //act
        int act = Task1.minutesToSeconds(stringWithCharacter);
        //assert
        assertThat(act).isEqualTo(expected);
    }

    @Test
    void minutesToSeconds_shouldNotConvertStringWithoutMinutes() {
        //arrange
        int expected = -1;
        String stringWithoutMinutes = "234";
        //act
        int act = Task1.minutesToSeconds(stringWithoutMinutes);
        //assert
        assertThat(act).isEqualTo(expected);
    }
}
