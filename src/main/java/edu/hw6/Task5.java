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
    private Task5() {
    }

    class HackerNews {
        private HackerNews() {
        }

        private static final int EXPECTATION_TIME = 10;

        public static String news(long id) {
            String link = "https://hacker-news.firebaseio.com/v0/item/" + id + ".json";
            HttpResponse<String> response = getResponse(link);
            Pattern pattern = Pattern.compile("\"title\":\"(.*?)\",");
            Matcher matcher = pattern.matcher(response.body());
            if (matcher.find()) {
                return matcher.group(1);
            }
            return null;

        }

        public static long[] hackerNewsTopStories() {
            String link = "https://hacker-news.firebaseio.com/v0/topstories.json";
            HttpResponse response = getResponse(link);
            return convertToLongArray(response);
        }

        private static HttpResponse getResponse(String link) {
            HttpClient client = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(EXPECTATION_TIME))
                .build();
            HttpRequest request = null;
            try {
                request = HttpRequest.newBuilder()
                    .uri(new URI(link))
                    .GET()
                    .timeout(Duration.of(EXPECTATION_TIME, ChronoUnit.SECONDS))
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
            return response;
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
}
