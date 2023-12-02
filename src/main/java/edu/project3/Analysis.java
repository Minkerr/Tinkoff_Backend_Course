package edu.project3;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Analysis {
    private Analysis() {
    }

    public static int countLogs(String[] logs) {
        return logs.length;
    }

    public static Map<String, Long> requestedResources(String[] logs) {
        return Arrays.stream(logs)
            .map(el -> {
                Pattern pattern = Pattern.compile("] \"(.*?)\"");
                Matcher matcher = pattern.matcher(el);
                if (matcher.find()) {
                    return matcher.group(1);
                }
                return "";
            })
            .collect(Collectors.groupingBy(s -> s, Collectors.counting()));
    }

    public static Map<String, Long> requestedResourcesByDate(String[] logs) {
        return Arrays.stream(logs)
            .map(el -> {
                Pattern pattern = Pattern.compile(".*\\[(.*)\\].*");
                Matcher matcher = pattern.matcher(el);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(
                    "dd/MMM/yyyy:HH:mm:ss Z",
                    Locale.ENGLISH
                );
                if (matcher.find()) {
                    OffsetDateTime date = OffsetDateTime.parse(matcher.group(1), formatter);
                    DateTimeFormatter outFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    return date.format(outFormatter);
                }
                return "";
            })
            .collect(Collectors.groupingBy(s -> s, Collectors.counting()));
    }

    public static Map<String, Long> requestedResourcesByIP(String[] logs) {
        return Arrays.stream(logs)
            .map(el -> {
                Pattern pattern = Pattern.compile("^(.*) - -.*");
                Matcher matcher = pattern.matcher(el);
                if (matcher.find()) {
                    return matcher.group(1);
                }
                return "";
            })
            .collect(Collectors.groupingBy(s -> s, Collectors.counting()));
    }

    @SuppressWarnings("MagicNumber")
    public static Map<Integer, Long> requestedCodes(String[] logs) {
        return Arrays.stream(logs)
            .map(el -> {
                Pattern pattern = Pattern.compile("] \"(.*?)\" (\\d+)");
                Matcher matcher = pattern.matcher(el);
                if (matcher.find()) {
                    return Integer.parseInt(matcher.group(2));
                }
                return 0;
            })
            .collect(Collectors.groupingBy(s -> s, Collectors.counting()));
    }

    public static int averageResponseSize(String[] logs) {
        return (int) Arrays.stream(logs)
            .mapToInt(String::length)
            .average()
            .getAsDouble();
    }

}
