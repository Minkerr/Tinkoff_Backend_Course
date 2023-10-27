package edu.hw3;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static edu.hw3.Task2.clusterize;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {
    @Test
    void clusterize_shouldDivideThreeBrackets() {
        // arrange
        List<String> exp = new ArrayList<>(List.of("()", "()", "()"));
        // act
        List<String> act = clusterize("()()()");
        // assert
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void clusterize_shouldNotDivideBigBracketStack() {
        // arrange
        List<String> exp = new ArrayList<>(List.of("((()))"));
        // act
        List<String> act = clusterize("((()))");
        // assert
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void clusterize_shouldDivideBigBracketString() {
        // arrange
        List<String> exp = new ArrayList<>(List.of("((()))", "(())", "()", "()", "(()())"));
        // act
        List<String> act = clusterize("((()))(())()()(()())");
        // assert
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void clusterize_shouldDivideAnotherBigBracketString() {
        // arrange
        List<String> exp = new ArrayList<>(List.of("((())())", "(()(()()))"));
        // act
        List<String> act = clusterize("((())())(()(()()))");
        // assert
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void clusterize_shouldReturnEmptyListForEmptyString() {
        // arrange
        List<String> exp = new ArrayList<>();
        // act
        List<String> act = clusterize("");
        // assert
        assertThat(act).isEqualTo(exp);
    }
}
