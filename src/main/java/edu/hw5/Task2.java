package edu.hw5;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.util.ArrayList;
import java.util.List;

public class Task2 {
    private Task2() {
    }

    @SuppressWarnings("MagicNumber")
    public static List<LocalDate> findAllThirteenFridaysInTheYear(int year) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        List<LocalDate> list = new ArrayList<>();
        for (int month = 1; month <= 12; month++) {
            LocalDate date = LocalDate.of(year, month, 13);
            if (date.getDayOfWeek() == DayOfWeek.FRIDAY) {
                list.add(date);
            }
        }
        return list;
    }

    public static LocalDate findNextThirteenFriday(LocalDate date) {
        TemporalAdjuster adjuster = new NextThirteenFridayAdjuster();
        LocalDate nextThirteenFriday = (LocalDate) adjuster.adjustInto(date);
        return nextThirteenFriday;
    }

    private final static class NextThirteenFridayAdjuster implements TemporalAdjuster {
        @Override
        public Temporal adjustInto(Temporal temporal) {
            int year = temporal.get(ChronoField.YEAR);
            LocalDate result = null;
            boolean flag = true;
            while (flag) {
                var list = findAllThirteenFridaysInTheYear(year);
                for (LocalDate thirteenFriday : list) {
                    if (thirteenFriday.isAfter((LocalDate) temporal)) {
                        result = thirteenFriday;
                        flag = false;
                        break;
                    }
                }
                year++;
            }
            return result;
        }
    }

}
