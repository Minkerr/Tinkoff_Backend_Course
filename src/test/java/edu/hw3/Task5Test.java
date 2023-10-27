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
        List<Person> exp = new ArrayList<>(List.of(
            new Person("Thomas Aquinas"),
            new Person("Rene Descartes"),
            new Person("David Hume"),
            new Person("John Locke")
        ));
        // act
        List<Person> act =
            parseContacts(List.of("John Locke", "Rene Descartes", "Thomas Aquinas", "David Hume"), "ACS");
        // assert
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void parseContacts_shouldSortTreeFullNameInDescentOrder() {
        // arrange
        List<Person> exp = new ArrayList<>(List.of(
            new Person("Carl Gauss"),
            new Person("Leonhard Euler"),
            new Person("Paul Erdos")
        ));
        // act
        List<Person> act =
            parseContacts(List.of("Paul Erdos", "Leonhard Euler", "Carl Gauss"), "DESC");
        // assert
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void parseContacts_shouldReturnEmptyListForNull() {
        // arrange
        List<Person> exp = new ArrayList<>();
        // act
        List<Person> act =
            parseContacts(null, "DESC");
        // assert
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void parseContacts_shouldSortEmptyList() {
        // arrange
        List<Person> exp = new ArrayList<>();
        // act
        List<Person> act = parseContacts(new ArrayList<>(), "DESC");
        // assert
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void parseContacts_shouldPutContactWithoutLastNameAtTheBeginningOfTheList() {
        // arrange
        List<Person> exp = new ArrayList<>(List.of(
            new Person("Euler"),
            new Person("Paul Erdos"),
            new Person("Carl Gauss")
        ));
        // act
        List<Person> act =
            parseContacts(List.of("Euler", "Paul Erdos", "Carl Gauss"), "ASC");
        // assert
        assertThat(act).isEqualTo(exp);
    }
}
