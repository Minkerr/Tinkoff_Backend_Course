package edu.hw3;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static edu.hw3.Task5.parseContacts;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task5Test {
    @Test
    void parseContacts_shouldSortFourFullName() {
        // arrange
        List<Task5.Person> exp = new ArrayList<>(List.of(
            new Task5.Person("Thomas Aquinas"),
            new Task5.Person("Rene Descartes"),
            new Task5.Person("David Hume"),
            new Task5.Person("John Locke")
        ));
        // act
        List<Task5.Person> act =
            parseContacts(List.of("John Locke", "Rene Descartes", "Thomas Aquinas", "David Hume"), "ACS");
        // assert
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void parseContacts_shouldSortTreeFullNameInDescentOrder() {
        // arrange
        List<Task5.Person> exp = new ArrayList<>(List.of(
            new Task5.Person("Carl Gauss"),
            new Task5.Person("Leonhard Euler"),
            new Task5.Person("Paul Erdos")
        ));
        // act
        List<Task5.Person> act =
            parseContacts(List.of("Paul Erdos", "Leonhard Euler", "Carl Gauss"), "DESC");
        // assert
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void parseContacts_shouldReturnEmptyListForNull() {
        // arrange
        List<Task5.Person> exp = new ArrayList<>();
        // act
        List<Task5.Person> act =
            parseContacts(null, "DESC");
        // assert
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void parseContacts_shouldSortEmptyList() {
        // arrange
        List<Task5.Person> exp = new ArrayList<>();
        // act
        List<Task5.Person> act = parseContacts(new ArrayList<>(), "DESC");
        // assert
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void parseContacts_shouldPutContactWithoutLastNameByName() {
        // arrange
        List<Task5.Person> exp = new ArrayList<>(List.of(
            new Task5.Person("Paul Erdos"),
            new Task5.Person("Euler"),
            new Task5.Person("Carl Gauss")
        ));
        // act
        List<Task5.Person> act =
            parseContacts(List.of("Euler", "Paul Erdos", "Carl Gauss"), "ASC");
        // assert
        assertThat(act).isEqualTo(exp);
    }
}
