package edu.hw4;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Pattern;

public class ValidationError {
    enum IncorrectField {
        NAME,
        AGE,
        HEIGHT,
        WEIGHT
    }

    private IncorrectField incorrectField;

    public ValidationError(IncorrectField incorrectField) {
        this.incorrectField = incorrectField;
    }

    public static Set<ValidationError> checkForValidationErrors(Animal animal) {
        Set<ValidationError> set = new HashSet<>();
        if (!checkAge(animal)) {
            set.add(new ValidationError(IncorrectField.AGE));
        }
        if (!checkHeight(animal)) {
            set.add(new ValidationError(IncorrectField.HEIGHT));
        }
        if (!checkWeight(animal)) {
            set.add(new ValidationError(IncorrectField.WEIGHT));
        }
        if (!checkName(animal)) {
            set.add(new ValidationError(IncorrectField.NAME));
        }
        return set;
    }

    public static String errorSetToString(Set<ValidationError> set) {
        StringBuilder result = new StringBuilder("This animal has the following incorrect fields: ");
        if (set.contains(new ValidationError(IncorrectField.AGE))) {
            result.append("age, ");
        }
        if (set.contains(new ValidationError(IncorrectField.NAME))) {
            result.append("name, ");
        }
        if (set.contains(new ValidationError(IncorrectField.HEIGHT))) {
            result.append("height, ");
        }
        if (set.contains(new ValidationError(IncorrectField.WEIGHT))) {
            result.append("weight, ");
        }
        result.delete(result.length() - 2, result.length());
        return result.toString();
    }

    @SuppressWarnings("MagicNumber")
    private static boolean checkAge(Animal animal) {
        return switch (animal.type()) {
            case BIRD, DOG, CAT -> 0 < animal.age() && animal.age() < 20;
            case FISH -> 0 < animal.age() && animal.age() < 10;
            case SPIDER -> 0 < animal.age() && animal.age() < 5;
        };
    }

    @SuppressWarnings("MagicNumber")
    private static boolean checkHeight(Animal animal) {
        return switch (animal.type()) {
            case DOG -> 0 < animal.height() && animal.height() < 100;
            case BIRD -> 0 < animal.height() && animal.height() < 70;
            case FISH -> 0 < animal.height() && animal.height() < 50;
            case CAT -> 0 < animal.height() && animal.height() < 40;
            case SPIDER -> 0 < animal.height() && animal.height() < 5;
        };
    }

    @SuppressWarnings("MagicNumber")
    private static boolean checkWeight(Animal animal) {
        return switch (animal.type()) {
            case DOG -> 0 < animal.weight() && animal.weight() < 80;
            case BIRD, CAT -> 0 < animal.weight() && animal.weight() < 10;
            case FISH -> 0 < animal.weight() && animal.weight() < 20;
            case SPIDER -> 0 < animal.weight() && animal.weight() < 3;
        };
    }

    private static boolean checkName(Animal animal) {
        return Pattern.matches("^[a-zA-Z0-9\\s]*$", animal.name());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ValidationError that = (ValidationError) o;
        return incorrectField == that.incorrectField;
    }

    @Override
    public int hashCode() {
        return Objects.hash(incorrectField);
    }
}
