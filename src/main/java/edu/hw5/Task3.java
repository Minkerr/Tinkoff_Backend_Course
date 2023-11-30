package edu.hw5;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

public class Task3 {
    public static Optional<LocalDate> parseDate(String dateString) {
        boolean isFormWithHyphen = dateString.matches("([0-9]{4})-([0-9]{1,2})-([0-9]{1,2})");
        boolean isFormWithSlash = dateString.matches(
            "([0-9]{1,2})/([0-9]{1,2})/([0-9]{2})|([0-9]{1,2})/([0-9]{1,2})/([0-9]{4})");
        boolean isFormAgo = dateString.matches("\\d+ day(s?) ago");
        boolean isYesterday = dateString.equals("yesterday");
        boolean isToday = dateString.equals("today");
        boolean isTomorrow = dateString.equals("tomorrow");

        Optional<LocalDate> result = Optional.empty();
        if (isFormWithSlash || isFormWithHyphen) {
            DateTimeFormatter formatter = determineExplicitFormFormatter(dateString);
            result = Optional.of(LocalDate.parse(dateString, formatter));
        } else if (isFormAgo) {
            int days = Integer.parseInt(dateString.split(" ")[0]);
            result = Optional.of(LocalDate.now().minusDays(days));
        } else if (isYesterday) {
            result = Optional.of(LocalDate.now().minusDays(1));
        } else if (isToday) {
            result = Optional.of(LocalDate.now());
        } else if (isTomorrow) {
            result = Optional.of(LocalDate.now().plusDays(1));
        }
        return result;
    }

    private static DateTimeFormatter determineExplicitFormFormatter(String dateString) {
        String form1 = "yyyy-MM-dd";
        String form2 = "yyyy-M-dd";
        String form3 = "yyyy-MM-d";
        String form4 = "yyyy-M-d";
        String form5 = "dd/MM/yy";
        String form6 = "dd/M/yy";
        String form7 = "d/MM/yy";
        String form8 = "d/M/yy";
        String form9 = "dd/MM/yyyy";
        String form10 = "dd/M/yyyy";
        String form11 = "d/MM/yyyy";
        String form12 = "d/M/yyyy";

        List<String[]> isItThisForm = List.of(
            new String[] {form1, "([0-9]{4})-([0-9]{2})-([0-9]{2})"},
            new String[] {form2, "([0-9]{4})-([0-9])-([0-9]{2})"},
            new String[] {form3, "([0-9]{4})-([0-9]{2})-([0-9])"},
            new String[] {form4, "([0-9]{4})-([0-9])-([0-9])"},
            new String[] {form5, "([0-9]{2})/([0-9]{2})/([0-9]{2})"},
            new String[] {form6, "([0-9]{2})/([0-9])/([0-9]{2})"},
            new String[] {form7, "([0-9])/([0-9]{2})/([0-9]{2})"},
            new String[] {form8, "([0-9])/([0-9])/([0-9]{2})"},
            new String[] {form9, "([0-9]{2})/([0-9]{2})/([0-9]{4})"},
            new String[] {form10, "([0-9]{2})/([0-9])/([0-9]{4})"},
            new String[] {form11, "([0-9])/([0-9]{2})/([0-9]{4})"},
            new String[] {form12, "([0-9])/([0-9])/([0-9]{4})"}
        );

        for (var pair : isItThisForm) {
            if (dateString.matches(pair[1])) {
                return DateTimeFormatter.ofPattern(pair[0]);
            }
        }
        return null;
    }

    private Task3() {
    }
}
