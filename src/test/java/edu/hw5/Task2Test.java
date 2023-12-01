package edu.hw5;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static edu.hw5.Task2.findAllThirteenFridaysInTheYear;
import static edu.hw5.Task2.findNextThirteenFriday;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {
    @Test
    void findAllThirteenFridaysInTheYear_shouldFindAllThirteenFridaysIn1925() {
        //arrange
        List<LocalDate> exp = new ArrayList<>();
        exp.add(LocalDate.of(1925, 2, 13));
        exp.add(LocalDate.of(1925, 3, 13));
        exp.add(LocalDate.of(1925, 11, 13));
        //act
        var act = findAllThirteenFridaysInTheYear(1925);
        //assert
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void findAllThirteenFridaysInTheYear_shouldFindAllThirteenFridaysIn2024() {
        //arrange
        List<LocalDate> exp = new ArrayList<>();
        exp.add(LocalDate.of(2024, 9, 13));
        exp.add(LocalDate.of(2024, 12, 13));
        //act
        var act = findAllThirteenFridaysInTheYear(2024);
        //assert
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void findNextThirteenFriday_shouldFindNextThirteenFridayFor2024() {
        //arrange
        LocalDate exp = LocalDate.of(2024, 9, 13);
        //act
        var act = findNextThirteenFriday(LocalDate.of(2024, 3, 12));
        //assert
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void findNextThirteenFriday_shouldFindNextThirteenFridayInNextYear() {
        //arrange
        LocalDate exp = LocalDate.of(1925, 2, 13);
        //act
        var act = findNextThirteenFriday(LocalDate.of(1924, 12, 14));
        //assert
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void findNextThirteenFriday_shouldFindNextThirteenFridayForThirteenFriday() {
        //arrange
        LocalDate exp = LocalDate.of(1925, 3, 13);
        //act
        var act = findNextThirteenFriday(LocalDate.of(1925, 2, 13));
        //assert
        assertThat(act).isEqualTo(exp);
    }


}
