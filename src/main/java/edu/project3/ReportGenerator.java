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

    private static final String MARKDOWN_OUTPUT_PATH = "src\\main\\java\\edu\\project3\\output\\report.md";
    private static final String TABLE_LINE = "|:-:|-:|\n";
    private static final String END_OF_TABLE_ROW = "|\n";
    private static final String ADOC_OUTPUT_PATH = "src\\main\\java\\edu\\project3\\output\\report.adoc";
    private static final String END_OF_TABLE_ADOC = "|===\n";
    private static final String SEPARATOR_ADOC = "\n|";

    public static String generateAdocReportGeneral(String[] logs) {
        Path path = Path.of(ADOC_OUTPUT_PATH);
        StringBuilder table = new StringBuilder("""
                [cols="1,1"]
                |===
                |Metrics
                |Value

                """);
        table.append("|Response Quantity\n|").append(countLogs(logs)).append("\n\n");
        table.append("|Average Response Size\n|").append(averageResponseSize(logs)).append("\n");
        table.append(END_OF_TABLE_ADOC);

        try {
            Files.write(path, table.toString().getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return String.valueOf(table);
    }

    public static String generateAdocReportCodes(String[] logs) {
        Path path = Path.of(ADOC_OUTPUT_PATH);
        StringBuilder table = new StringBuilder("""
                [cols="1,1"]
                |===
                |Code
                |Quantity

                """);
        var resources = requestedCodes(logs);
        for (Integer log : resources.keySet()) {
            table.append("|").append(log).append(SEPARATOR_ADOC).append(resources.get(log)).append("\n").append("\n");
        }
        table.append(END_OF_TABLE_ADOC);
        try {
            Files.write(path, table.toString().getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return String.valueOf(table);
    }

    public static String generateAdocReportResources(String[] logs) {
        Path path = Path.of(ADOC_OUTPUT_PATH);
        StringBuilder table = new StringBuilder("""
                [cols="1,1"]
                |===
                |Resource
                |Quantity

                """);
        var resources = requestedResources(logs);
        for (String log : resources.keySet()) {
            table.append("|").append(log).append(SEPARATOR_ADOC).append(resources.get(log)).append("\n").append("\n");
        }
        table.append(END_OF_TABLE_ADOC);
        try {
            Files.write(path, table.toString().getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return String.valueOf(table);
    }

    public static String generateMarkdownReportGeneral(String[] logs) {
        Path path = Path.of(MARKDOWN_OUTPUT_PATH);
        StringBuilder table = new StringBuilder("|Metrics|Value|\n");
        table.append(TABLE_LINE);
        table.append("|Response Quantity|").append(countLogs(logs)).append(END_OF_TABLE_ROW);
        table.append("|Average Response Size|").append(averageResponseSize(logs)).append(END_OF_TABLE_ROW);

        try {
            Files.write(path, table.toString().getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return String.valueOf(table);
    }

    public static String generateMarkdownReportCodes(String[] logs) {
        Path path = Path.of(MARKDOWN_OUTPUT_PATH);
        StringBuilder table = new StringBuilder("|Code|Quantity|\n");
        table.append(TABLE_LINE);
        var resources = requestedCodes(logs);
        for (Integer log : resources.keySet()) {
            table.append("|").append(log).append("|").append(resources.get(log)).append(END_OF_TABLE_ROW);
        }
        try {
            Files.write(path, table.toString().getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return String.valueOf(table);
    }

    public static String generateMarkdownReportResources(String[] logs) {
        Path path = Path.of(MARKDOWN_OUTPUT_PATH);
        StringBuilder table = new StringBuilder("|Resource|Quantity|\n");
        table.append(TABLE_LINE);
        var resources = requestedResources(logs);
        for (String log : resources.keySet()) {
            table.append("|").append(log).append("|").append(resources.get(log)).append(END_OF_TABLE_ROW);
        }
        try {
            Files.write(path, table.toString().getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return String.valueOf(table);
    }

}

