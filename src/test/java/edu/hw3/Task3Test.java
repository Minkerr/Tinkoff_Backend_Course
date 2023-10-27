package edu.hw3;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static edu.hw3.Task3.freqDict;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test {
    @Test
    void freqDict_shouldCountBBandAEntrance() {
        // arrange
        Map<Object, Integer> exp = new HashMap<>();
        exp.put("bb", 2);
        exp.put("a", 2);
        // act
        Map<Object, Integer> act = freqDict(List.of("a", "bb", "a", "bb"));
        // assert
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void freqDict_shouldCountEntranceOfThisAndThat() {
        // arrange
        Map<Object, Integer> exp = new HashMap<>();
        exp.put("that", 1);
        exp.put("and", 2);
        exp.put("this", 1);
        // act
        Map<Object, Integer> act = freqDict(List.of("this", "and", "that", "and"));
        // assert
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void freqDict_shouldCountEntranceOfRussianWords() {
        // arrange
        Map<Object, Integer> exp = new HashMap<>();
        exp.put("bug", 1);
        exp.put("код", 3);
        // act
        Map<Object, Integer> act = freqDict(List.of("код", "код", "код", "bug"));
        // assert
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void freqDict_shouldCountIntegerEntrance() {
        // arrange
        Map<Object, Integer> exp = new HashMap<>();
        exp.put(1, 2);
        exp.put(2, 2);
        // act
        Map<Object, Integer> act = freqDict(List.of(1, 2, 2, 1));
        // assert
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void freqDict_shouldCountDoubleEntrance() {
        // arrange
        Map<Object, Integer> exp = new HashMap<>();
        exp.put(2.2, 1);
        exp.put(1.1, 3);
        // act
        Map<Object, Integer> act = freqDict(List.of(1.1, 2.2, 1.1, 1.1));
        // assert
        assertThat(act).isEqualTo(exp);
    }
    @Test
    void freqDict_shouldWorkForEmptyList() {
        // arrange
        Map<Object, Integer> exp = new HashMap<>();
        // act
        Map<Object, Integer> act = freqDict(new ArrayList<>());
        // assert
        assertThat(act).isEqualTo(exp);
    }
}
