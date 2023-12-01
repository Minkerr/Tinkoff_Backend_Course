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
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import static edu.project3.Analysis.averageResponseSize;
import static edu.project3.Analysis.requestedCodes;
import static edu.project3.Analysis.requestedResources;
import static edu.project3.ReportGenerator.generateMarkdownReportGeneral;

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
                default -> trash = args[i + 1];
            }
        }

        String[] logs = parseURL(path);
        System.out.println(logs.length);
        System.out.println(path);
        System.out.println(logs[2]);
        System.out.println(logs[20]);
        System.out.println(logs[22]);
        System.out.println(averageResponseSize(logs));
        var res = requestedResources(logs);
        for (var el : res.keySet()) {
            System.out.println(el + " " + res.get(el));
        }
        var codes = requestedCodes(logs);
        for (var el : codes.keySet()) {
            System.out.println(el + " " + codes.get(el));
        }
        generateMarkdownReportGeneral(logs);
        //generateMarkdownReportResources(logs);
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
