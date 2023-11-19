package edu.project3;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import static edu.project3.Analysis.averageResponseSize;
import static edu.project3.Analysis.requestedCodes;
import static edu.project3.Analysis.requestedResources;

public class Parser {
    private static final int EXPECTATION_TIME = 20;

    @SuppressWarnings("MagicNumber")
    public static void main(String[] args) {
        String path = args[4];
        String from = "";
        String to = "";
        String format = "";
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "--from" -> from = args[i + 1];
                case "--to" -> to = args[i + 1];
                case "--format" -> format = args[i + 1];
            }
        }

        String [] logs = parseURL(path);
        System.out.println(logs.length);
        System.out.println(path);
        System.out.println(logs[2]);
        System.out.println(logs[20]);
        System.out.println(logs[22]);
        System.out.println(averageResponseSize(logs));
        var res = requestedResources(logs);
        for (var el :
            res.keySet()) {
            System.out.println(el + " " + res.get(el));
        }
        var codes = requestedCodes(logs);
        for (var el :
            codes.keySet()) {
            System.out.println(el + " " + codes.get(el));
        }
    }

    public static String [] parseURL(String URL) {
        HttpClient client = HttpClient.newBuilder()
            .connectTimeout(Duration.ofSeconds(EXPECTATION_TIME))
            .build();

        HttpRequest request = null;
        try {
            request = HttpRequest.newBuilder()
                .uri(new URI(URL))
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
}
