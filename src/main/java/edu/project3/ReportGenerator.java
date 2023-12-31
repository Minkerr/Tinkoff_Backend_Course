package edu.project3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import static edu.project3.Analysis.averageResponseSize;
import static edu.project3.Analysis.countLogs;
import static edu.project3.Analysis.requestedCodes;
import static edu.project3.Analysis.requestedResources;
import static edu.project3.Analysis.requestedResourcesByDate;
import static edu.project3.Analysis.requestedResourcesByIP;

public class ReportGenerator {
    private ReportGenerator() {
    }

    private static final String MARKDOWN_OUTPUT_PATH = "src\\main\\java\\edu\\project3\\output\\report.md";
    private static final String TABLE_LINE = "|:-:|-:|\n";
    private static final String END_OF_TABLE_ROW = "|\n";
    private static final String ADOC_OUTPUT_PATH = "src\\main\\java\\edu\\project3\\output\\report.adoc";
    private static final String END_OF_TABLE_ADOC = "|===\n";
    private static final String SEPARATOR_ADOC = "\n|";

    public static String generateAdocReportGeneralAndWriteToOutputFile(String[] logs) {
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

    public static String generateAdocReportCodesAndWriteToOutputFile(String[] logs) {
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

    public static String generateAdocReportResourcesAndWriteToOutputFile(String[] logs) {
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

    public static String generateAdocReportResourcesByDateAndWriteToOutputFile(String[] logs) {
        Path path = Path.of(ADOC_OUTPUT_PATH);
        StringBuilder table = new StringBuilder("""
            [cols="1,1"]
            |===
            |Date
            |Quantity

            """);
        var resources = requestedResourcesByDate(logs);
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

    public static String generateAdocReportResourcesByIPAndWriteToOutputFile(String[] logs) {
        Path path = Path.of(ADOC_OUTPUT_PATH);
        StringBuilder table = new StringBuilder("""
            [cols="1,1"]
            |===
            |IP
            |Quantity

            """);
        var resources = requestedResourcesByIP(logs);
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

    public static String generateMarkdownReportGeneralAndWriteToOutputFile(String[] logs) {
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

    public static String generateMarkdownReportCodesAndWriteToOutputFile(String[] logs) {
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

    public static String generateMarkdownReportResourcesAndWriteToOutputFile(String[] logs) {
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

    public static String generateMarkdownReportResourcesByDateAndWriteToOutputFile(String[] logs) {
        Path path = Path.of(MARKDOWN_OUTPUT_PATH);
        StringBuilder table = new StringBuilder("|Date|Quantity|\n");
        table.append(TABLE_LINE);
        var resources = requestedResourcesByDate(logs);
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

    public static String generateMarkdownReportResourcesByIPAndWriteToOutputFile(String[] logs) {
        Path path = Path.of(MARKDOWN_OUTPUT_PATH);
        StringBuilder table = new StringBuilder("|IP|Quantity|\n");
        table.append(TABLE_LINE);
        var resources = requestedResourcesByIP(logs);
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

