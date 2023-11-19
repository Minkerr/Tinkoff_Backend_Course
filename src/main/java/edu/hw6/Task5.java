package edu.hw6;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Task5 {
    class HackerNews {
        public static String news(long id) {
            String link = "https://hacker-news.firebaseio.com/v0/item/" + id + ".json";
            HttpClient client = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(20))
                .build();

            HttpRequest request = null;
            try {
                request = HttpRequest.newBuilder()
                    .uri(new URI(link))
                    .GET()
                    .timeout(Duration.of(10, ChronoUnit.SECONDS))
                    .build();
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            }

            HttpResponse<String> response = null;
            try {
                response = client.send(request, HttpResponse.BodyHandlers.ofString());
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
            Pattern pattern = Pattern.compile("\"title\":\"(.*?)\",");
            Matcher matcher = pattern.matcher(response.body());
            if (matcher.find()) {
                return matcher.group(1);
            }
            return null;

        }

        public static long[] hackerNewsTopStories() {
            HttpClient client = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(20))
                .build();

            HttpRequest request = null;
            try {
                request = HttpRequest.newBuilder()
                    .uri(new URI("https://hacker-news.firebaseio.com/v0/topstories.json"))
                    .GET()
                    .timeout(Duration.of(10, ChronoUnit.SECONDS))
                    .build();
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            }

            HttpResponse<String> response = null;
            try {
                response = client.send(request, HttpResponse.BodyHandlers.ofString());
            } catch (IOException | InterruptedException e) {
                return new long[0];
            }

            return convertToLongArray(response);
        }
    }

    private static long[] convertToLongArray(HttpResponse<String> response) {
        int respLength = response.body().length();
        long[] result =
            Stream.of(response.body()
                    .substring(1, respLength - 1)
                    .split(","))
                .mapToLong(Long::parseLong)
                .toArray();
        return result;
    }
}
