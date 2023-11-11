package edu.hw3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

public class Task5 {
    private Task5() {

    }

    public static List<Person> parseContacts(List<String> contactsString, String order) {
        List<Person> contacts = new ArrayList<>();
        if (contactsString == null) {
            return contacts;
        }

        for (String s : contactsString) {
            contacts.add(new Person(s));
        }

        if (order.equals("DESC")) {
            contacts.sort(Collections.reverseOrder());
        } else {
            Collections.sort(contacts);
        }

        return contacts;
    }

    static class Person implements Comparable<Person> {
        private String name;
        private String lastName;

        Person(String fullName) {
            String[] splitNames = fullName.split(" ");
            this.name = splitNames[0];
            if (splitNames.length > 1) {
                this.lastName = splitNames[1];
            } else {
                this.lastName = ""; // it means there is no last name
            }
        }

        @Override
        public int compareTo(@NotNull Person o) {
            if (lastNameIsMissing(this) && lastNameIsMissing(o)) {
                return this.name.compareTo(o.name);
            } else if (lastNameIsMissing(this)) {
                return this.name.compareTo(o.lastName);
            } else if (lastNameIsMissing(o)) {
                return this.lastName.compareTo(o.name);
            } else {
                return this.lastName.compareTo(o.lastName);
            }
        }

        private boolean lastNameIsMissing(Person person) {
            return person.lastName.isEmpty();
        }

        @Override public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Person person = (Person) o;
            return Objects.equals(name, person.name) && Objects.equals(lastName, person.lastName);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, lastName);
        }
    }
}
