package edu.project3;

import org.junit.jupiter.api.Test;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import static edu.project3.Analysis.averageResponseSize;
import static edu.project3.Analysis.countLogs;
import static edu.project3.Parser.parseFile;
import static edu.project3.ReportGenerator.generateMarkdownReportCodes;
import static edu.project3.ReportGenerator.generateMarkdownReportGeneral;
import static edu.project3.ReportGenerator.generateMarkdownReportResources;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ReportGeneratorTest {
    @Test
    void generateMarkdownReportGeneral_test() {
        String exp = "|Metrics|Value|\n"
            + "|:-:|-:|\n"
            + "|Response Quantity|3|\n"
            + "|Average Response Size|130|\n";
        String[] logs = parseFile("src" + File.separator + "main" + File.separator
            + "java" + File.separator + "edu" + File.separator + "project3" + File.separator + "input"
            + File.separator + "logs.txt");

        var act = generateMarkdownReportGeneral(logs);
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void generateMarkdownReportResources_test() {
        String exp = "|Resource|Quantity|\n"
            + "|:-:|-:|\n"
            + "|GET /downloads/product_1 HTTP/1.1|1|\n"
            + "|GET /downloads/product_2 HTTP/1.1|2|\n";

        String[] logs = parseFile("src" + File.separator + "main" + File.separator
            + "java" + File.separator + "edu" + File.separator + "project3" + File.separator + "input"
            + File.separator + "logs.txt");

        var act = generateMarkdownReportResources(logs);
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void generateMarkdownReportCodes_test() {
        String exp = "|Code|Quantity|\n"
            + "|:-:|-:|\n"
            + "|304|1|\n"
            + "|404|1|\n"
            + "|200|1|\n";

        String[] logs = parseFile("src" + File.separator + "main" + File.separator
            + "java" + File.separator + "edu" + File.separator + "project3" + File.separator + "input"
            + File.separator + "logs.txt");

        var act = generateMarkdownReportCodes(logs);
        assertThat(act).isEqualTo(exp);
    }
}
