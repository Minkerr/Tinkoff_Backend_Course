package edu.hw5;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
        DateTimeFormatter formatter = null;
        if (isFormWithSlash || isFormWithHyphen) {
            formatter = determineExplicitFormFormatter(dateString);
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

        if (formatter != null) {
            result = Optional.of(LocalDate.parse(dateString, formatter));
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

        boolean isForm1 = dateString.matches("([0-9]{4})-([0-9]{2})-([0-9]{2})");
        boolean isForm2 = dateString.matches("([0-9]{4})-([0-9])-([0-9]{2})");
        boolean isForm3 = dateString.matches("([0-9]{4})-([0-9]{2})-([0-9])");
        boolean isForm4 = dateString.matches("([0-9]{4})-([0-9])-([0-9])");
        boolean isForm5 = dateString.matches("([0-9]{2})/([0-9]{2})/([0-9]{2})");
        boolean isForm6 = dateString.matches("([0-9]{2})/([0-9])/([0-9]{2})");
        boolean isForm7 = dateString.matches("([0-9])/([0-9]{2})/([0-9]{2})");
        boolean isForm8 = dateString.matches("([0-9])/([0-9])/([0-9]{2})");
        boolean isForm9 = dateString.matches("([0-9]{2})/([0-9]{2})/([0-9]{4})");
        boolean isForm10 = dateString.matches("([0-9]{2})/([0-9])/([0-9]{4})");
        boolean isForm11 = dateString.matches("([0-9])/([0-9]{2})/([0-9]{4})");
        boolean isForm12 = dateString.matches("([0-9])/([0-9])/([0-9]{4})");

        DateTimeFormatter formatter = null;
        if (isForm1) {
            formatter = DateTimeFormatter.ofPattern(form1);
        } else if (isForm2) {
            formatter = DateTimeFormatter.ofPattern(form2);
        } else if (isForm3) {
            formatter = DateTimeFormatter.ofPattern(form3);
        } else if (isForm4) {
            formatter = DateTimeFormatter.ofPattern(form4);
        } else if (isForm5) {
            formatter = DateTimeFormatter.ofPattern(form5);
        } else if (isForm6) {
            formatter = DateTimeFormatter.ofPattern(form6);
        } else if (isForm7) {
            formatter = DateTimeFormatter.ofPattern(form7);
        } else if (isForm8) {
            formatter = DateTimeFormatter.ofPattern(form8);
        } else if (isForm9) {
            formatter = DateTimeFormatter.ofPattern(form9);
        } else if (isForm10) {
            formatter = DateTimeFormatter.ofPattern(form10);
        } else if (isForm11) {
            formatter = DateTimeFormatter.ofPattern(form11);
        } else if (isForm12) {
            formatter = DateTimeFormatter.ofPattern(form12);
        }
        return formatter;
    }

    private Task3() {
    }
}
