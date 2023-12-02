package edu.project3;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static edu.project3.ReportGenerator.generateMarkdownReportResources;

public class Parser {
    private static final int EXPECTATION_TIME = 20;

    @SuppressWarnings({"RegexpSinglelineJava", "MagicNumber", "UncommentedMain", "InnerAssignment"})
    public static void main(String[] args) {
        String path = args[4];
        String from = "";
        String to = "";
        String format = "";
        String trash = "";
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "--from" -> from = args[i + 1];
                case "--to" -> to = args[i + 1];
                case "--format" -> format = args[i + 1];
                default -> trash = args[i];
            }
        }

        String[] logs = parseFile("src\\main\\java\\edu\\project3\\input\\logs.txt");
        generateMarkdownReportResources(logs);
    }

    public static String[] parseFileWithData(String path, OffsetDateTime from, OffsetDateTime to) {
        String[] logs = parseFile(path);
        String[] filteredLogs = Arrays.stream(logs)
            .filter((s) -> {
                Pattern pattern = Pattern.compile(".*\\[(.*)\\].*");
                Matcher matcher = pattern.matcher(s);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(
                    "dd/MMM/yyyy:HH:mm:ss Z",
                    Locale.ENGLISH
                );
                matcher.find();
                OffsetDateTime date = OffsetDateTime.parse(matcher.group(1), formatter);
                return date.isAfter(from) && date.isBefore(to);
            })
            .toArray(String[]::new);
        return filteredLogs;
    }

    public static String[] parseFile(String path) {
        try (BufferedReader reader = Files.newBufferedReader(Path.of(path));) {
            List<String> res = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                res.add(line);
            }
            return res.toArray(new String[0]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static String[] parseURL(String url) {
        HttpClient client = HttpClient.newBuilder()
            .connectTimeout(Duration.ofSeconds(EXPECTATION_TIME))
            .build();

        HttpRequest request = null;
        try {
            request = HttpRequest.newBuilder()
                .uri(new URI(url))
                .GET()
                .timeout(Duration.of(EXPECTATION_TIME, ChronoUnit.SECONDS))
                .build();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException ignored) {

        }

        return response.body().split("\n");
    }

    private Parser() {
    }
}
