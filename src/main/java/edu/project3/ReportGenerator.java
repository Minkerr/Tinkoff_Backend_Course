package edu.project3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import static edu.project3.Analysis.*;


public class ReportGenerator {
    public static String generateMarkdownReportGeneral (String [] logs) {
        Path path = Path.of("src\\main\\java\\edu\\project3\\output\\report.md");
        StringBuilder table = new StringBuilder("|      Metrics      |     Value    |\n");
        table.append("|:------------:|----------:|\n");
        table.append("|Response Quantity|").append(countLogs(logs)).append("|\n");
        table.append("|Average Response Size|").append(averageResponseSize(logs)).append("|\n");

        try {
            Files.write(path, table.toString().getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return String.valueOf(table);
    }
}
