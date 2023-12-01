package edu.hw5;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.Optional;
import static edu.hw5.Task3.parseDate;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test {
    @Test
    void parseDate_shouldParseDateWithPattern1() {
        //arrange
        LocalDate date = LocalDate.of(2023, 2, 2);
        Optional<LocalDate> exp = Optional.of(date);
        //act
        var act = parseDate("2023-02-02");
        //assert
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void parseDate_shouldParseDateWithPattern2() {
        //arrange
        LocalDate date = LocalDate.of(2023, 2, 2);
        Optional<LocalDate> exp = Optional.of(date);
        //act
        var act = parseDate("2023-2-02");
        //assert
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void parseDate_shouldParseDateWithPattern3() {
        //arrange
        LocalDate date = LocalDate.of(2023, 2, 2);
        Optional<LocalDate> exp = Optional.of(date);
        //act
        var act = parseDate("2023-02-2");
        //assert
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void parseDate_shouldParseDateWithPattern4() {
        //arrange
        LocalDate date = LocalDate.of(2023, 2, 2);
        Optional<LocalDate> exp = Optional.of(date);
        //act
        var act = parseDate("2023-2-2");
        //assert
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void parseDate_shouldParseDateWithPattern5() {
        //arrange
        LocalDate date = LocalDate.of(2020, 2, 2);
        Optional<LocalDate> exp = Optional.of(date);
        //act
        var act = parseDate("02/02/20");
        //assert
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void parseDate_shouldParseDateWithPattern6() {
        //arrange
        LocalDate date = LocalDate.of(2020, 2, 2);
        Optional<LocalDate> exp = Optional.of(date);
        //act
        var act = parseDate("02/2/20");
        //assert
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void parseDate_shouldParseDateWithPattern7() {
        //arrange
        LocalDate date = LocalDate.of(2020, 2, 2);
        Optional<LocalDate> exp = Optional.of(date);
        //act
        var act = parseDate("2/02/20");
        //assert
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void parseDate_shouldParseDateWithPattern8() {
        //arrange
        LocalDate date = LocalDate.of(2020, 2, 2);
        Optional<LocalDate> exp = Optional.of(date);
        //act
        var act = parseDate("2/2/20");
        //assert
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void parseDate_shouldParseDateWithPattern9() {
        //arrange
        LocalDate date = LocalDate.of(2020, 2, 2);
        Optional<LocalDate> exp = Optional.of(date);
        //act
        var act = parseDate("02/02/2020");
        //assert
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void parseDate_shouldParseDateWithPattern10() {
        //arrange
        LocalDate date = LocalDate.of(2020, 2, 2);
        Optional<LocalDate> exp = Optional.of(date);
        //act
        var act = parseDate("02/2/2020");
        //assert
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void parseDate_shouldParseDateWithPattern11() {
        //arrange
        LocalDate date = LocalDate.of(2020, 2, 2);
        Optional<LocalDate> exp = Optional.of(date);
        //act
        var act = parseDate("2/02/2020");
        //assert
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void parseDate_shouldParseDateWithPattern12() {
        //arrange
        LocalDate date = LocalDate.of(2020, 2, 2);
        Optional<LocalDate> exp = Optional.of(date);
        //act
        var act = parseDate("2/2/2020");
        //assert
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void parseDate_shouldParseDateWithAgoPattern() {
        //arrange
        LocalDate day = LocalDate.now().minusDays(5);
        Optional<LocalDate> exp = Optional.of(day);
        //act
        var act = parseDate("5 days ago");
        //assert
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void parseDate_shouldParseDateWithPattern5withoutS() {
        //arrange
        LocalDate day = LocalDate.now().minusDays(21);
        Optional<LocalDate> exp = Optional.of(day);
        //act
        var act = parseDate("21 day ago");
        //assert
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void parseDate_shouldParseDateForYesterday() {
        //arrange
        LocalDate day = LocalDate.now().minusDays(1);
        Optional<LocalDate> exp = Optional.of(day);
        //act
        var act = parseDate("yesterday");
        //assert
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void parseDate_shouldParseDateForTomorrow() {
        //arrange
        LocalDate day = LocalDate.now().plusDays(1);
        Optional<LocalDate> exp = Optional.of(day);
        //act
        var act = parseDate("tomorrow");
        //assert
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void parseDate_shouldParseDateForToday() {
        //arrange
        LocalDate day = LocalDate.now();
        Optional<LocalDate> exp = Optional.of(day);
        //act
        var act = parseDate("today");
        //assert
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void parseDate_shouldReturnEmptyForIncorrectPattern() {
        //arrange
        Optional<Object> exp = Optional.empty();
        //act
        var act = parseDate("2023-12-222");
        //assert
        assertThat(act).isEqualTo(exp);
    }
}
