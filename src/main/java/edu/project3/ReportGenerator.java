package edu.project3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import static edu.project3.Analysis.averageResponseSize;
import static edu.project3.Analysis.countLogs;
import static edu.project3.Analysis.requestedCodes;
import static edu.project3.Analysis.requestedResources;

public class ReportGenerator {
    private ReportGenerator() {
    }

    public static String generateMarkdownReportGeneral(String[] logs) {
        Path path = Path.of("src\\main\\java\\edu\\project3\\output\\report.md");
        StringBuilder table = new StringBuilder("|Metrics|Value|\n");
        table.append("|:-:|-:|\n");
        table.append("|Response Quantity|").append(countLogs(logs)).append("|\n");
        table.append("|Average Response Size|").append(averageResponseSize(logs)).append("|\n");

        try {
            Files.write(path, table.toString().getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return String.valueOf(table);
    }

    public static String generateMarkdownReportCodes(String[] logs) {
        Path path = Path.of("src\\main\\java\\edu\\project3\\output\\report.md");
        StringBuilder table = new StringBuilder("|Code|Quantity|\n");
        table.append("|:-:|-:|\n");
        var resources = requestedCodes(logs);
        for (var log : resources.keySet()) {
            table.append("|").append(log).append("|").append(resources.get(log)).append("|\n");
        }
        try {
            Files.write(path, table.toString().getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return String.valueOf(table);
    }

    public static String generateMarkdownReportResources(String[] logs) {
        Path path = Path.of("src\\main\\java\\edu\\project3\\output\\report.md");
        StringBuilder table = new StringBuilder("|Resource|Quantity|\n");
        table.append("|:-:|-:|\n");
        var resources = requestedResources(logs);
        for (var log : resources.keySet()) {
            table.append("|").append(log).append("|").append(resources.get(log)).append("|\n");
        }
        try {
            Files.write(path, table.toString().getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return String.valueOf(table);
    }

}
