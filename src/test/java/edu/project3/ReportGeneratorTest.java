package edu.project3;

import org.junit.jupiter.api.Test;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import static edu.project3.Analysis.averageResponseSize;
import static edu.project3.Analysis.countLogs;
import static edu.project3.Parser.parseFile;
import static edu.project3.ReportGenerator.generateMarkdownReportGeneral;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ReportGeneratorTest {
    @Test
    void generateMarkdownReportGeneral_test() {
        String exp = "|Metrics|Value|\n"
            + "|:-:|-:|\n"
            + "|Response Quantity|3|\n"
            + "|Average Response Size|130|\n";
        String [] logs = parseFile("src\\main\\java\\edu\\project3\\input\\logs.txt");

        var act = generateMarkdownReportGeneral(logs);
        assertThat(act).isEqualTo(exp);
    }
}
