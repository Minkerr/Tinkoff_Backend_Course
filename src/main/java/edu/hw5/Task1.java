package edu.hw5;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

public final class Task1 {
    private Task1() {
    }

    @SuppressWarnings("MagicNumber")
    public static String averageSessionDuration(Set<String> sessions) {
        long sum = 0;
        for (var session : sessions) {
            long durationInMinutes = calculateDurationInMinutes(session).toMinutes();
            sum += durationInMinutes;
        }
        long averageTimeInMinutes = sum / sessions.size();
        LocalTime averageTime = LocalTime.of((int) (averageTimeInMinutes / 60), (int) (averageTimeInMinutes % 60));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return averageTime.format(formatter);
    }

    private static Duration calculateDurationInMinutes(String interval) {
        String[] startAndFinishTime = interval.split(" - ");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm");
        LocalDateTime start = LocalDateTime.parse(startAndFinishTime[0], formatter);
        LocalDateTime finish = LocalDateTime.parse(startAndFinishTime[1], formatter);
        return Duration.between(start, finish);
    }
}

