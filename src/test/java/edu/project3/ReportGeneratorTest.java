package edu.project3;

import java.io.File;
import org.junit.jupiter.api.Test;
import static edu.project3.Parser.parseFile;
import static edu.project3.ReportGenerator.generateAdocReportCodes;
import static edu.project3.ReportGenerator.generateAdocReportGeneral;
import static edu.project3.ReportGenerator.generateAdocReportResources;
import static edu.project3.ReportGenerator.generateMarkdownReportCodes;
import static edu.project3.ReportGenerator.generateMarkdownReportGeneral;
import static edu.project3.ReportGenerator.generateMarkdownReportResources;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ReportGeneratorTest {
    @Test
    void generateMarkdownReportGeneral_test() {
        String exp = """
                |Metrics|Value|
                |:-:|-:|
                |Response Quantity|3|
                |Average Response Size|130|
                """;
        String[] logs = parseFile("src" + File.separator + "main" + File.separator
            + "java" + File.separator + "edu" + File.separator + "project3" + File.separator + "input"
            + File.separator + "logs.txt");

        var act = generateMarkdownReportGeneral(logs);
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void generateMarkdownReportResources_test() {
        String exp = """
                |Resource|Quantity|
                |:-:|-:|
                |GET /downloads/product_1 HTTP/1.1|1|
                |GET /downloads/product_2 HTTP/1.1|2|
                """;

        String[] logs = parseFile("src" + File.separator + "main" + File.separator
            + "java" + File.separator + "edu" + File.separator + "project3" + File.separator + "input"
            + File.separator + "logs.txt");

        var act = generateMarkdownReportResources(logs);
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void generateMarkdownReportCodes_test() {
        String exp = """
                |Code|Quantity|
                |:-:|-:|
                |304|1|
                |404|1|
                |200|1|
                """;

        String[] logs = parseFile("src" + File.separator + "main" + File.separator
            + "java" + File.separator + "edu" + File.separator + "project3" + File.separator + "input"
            + File.separator + "logs.txt");

        var act = generateMarkdownReportCodes(logs);
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void generateAdocReportGeneral_test() {
        String exp = """
            [cols="1,1"]
            |===
            |Metrics
            |Value

            |Response Quantity
            |3

            |Average Response Size
            |130
            |===
            """;

        String[] logs = parseFile("src" + File.separator + "main" + File.separator
            + "java" + File.separator + "edu" + File.separator + "project3" + File.separator + "input"
            + File.separator + "logs.txt");

        var act = generateAdocReportGeneral(logs);
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void generateAdocReportCodes_test() {
        String exp = """
            [cols="1,1"]
            |===
            |Code
            |Quantity

            |304
            |1

            |404
            |1

            |200
            |1

            |===
            """;

        String[] logs = parseFile("src" + File.separator + "main" + File.separator
            + "java" + File.separator + "edu" + File.separator + "project3" + File.separator + "input"
            + File.separator + "logs.txt");

        var act = generateAdocReportCodes(logs);
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void generateAdocReportResource_test() {
        String exp = """
            [cols="1,1"]
            |===
            |Resource
            |Quantity

            |GET /downloads/product_1 HTTP/1.1
            |1

            |GET /downloads/product_2 HTTP/1.1
            |2

            |===
            """;

        String[] logs = parseFile("src" + File.separator + "main" + File.separator
            + "java" + File.separator + "edu" + File.separator + "project3" + File.separator + "input"
            + File.separator + "logs.txt");

        var act = generateAdocReportResources(logs);
        assertThat(act).isEqualTo(exp);
    }
}
