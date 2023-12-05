package edu.project3;

import java.io.File;
import org.junit.jupiter.api.Test;
import static edu.project3.Parser.parseFile;
import static edu.project3.ReportGenerator.generateAdocReportCodesAndWriteToOutputFile;
import static edu.project3.ReportGenerator.generateAdocReportGeneralAndWriteToOutputFile;
import static edu.project3.ReportGenerator.generateAdocReportResourcesAndWriteToOutputFile;
import static edu.project3.ReportGenerator.generateAdocReportResourcesByDateAndWriteToOutputFile;
import static edu.project3.ReportGenerator.generateAdocReportResourcesByIPAndWriteToOutputFile;
import static edu.project3.ReportGenerator.generateMarkdownReportCodesAndWriteToOutputFile;
import static edu.project3.ReportGenerator.generateMarkdownReportGeneralAndWriteToOutputFile;
import static edu.project3.ReportGenerator.generateMarkdownReportResourcesAndWriteToOutputFile;
import static edu.project3.ReportGenerator.generateMarkdownReportResourcesByDateAndWriteToOutputFile;
import static edu.project3.ReportGenerator.generateMarkdownReportResourcesByIPAndWriteToOutputFile;
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

        var act = generateMarkdownReportGeneralAndWriteToOutputFile(logs);
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

        var act = generateMarkdownReportCodesAndWriteToOutputFile(logs);
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

        var act = generateMarkdownReportResourcesAndWriteToOutputFile(logs);
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void generateMarkdownReportResourcesByDate_test() {
        String exp = """
            |Date|Quantity|
            |:-:|-:|
            |17/05/2015|3|
            """;

        String[] logs = parseFile("src" + File.separator + "main" + File.separator
            + "java" + File.separator + "edu" + File.separator + "project3" + File.separator + "input"
            + File.separator + "logs.txt");

        var act = generateMarkdownReportResourcesByDateAndWriteToOutputFile(logs);
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void generateMarkdownReportResourcesByIP_test() {
        String exp = """
            |IP|Quantity|
            |:-:|-:|
            |93.180.71.3|1|
            |217.168.17.5|2|
            """;

        String[] logs = parseFile("src" + File.separator + "main" + File.separator
            + "java" + File.separator + "edu" + File.separator + "project3" + File.separator + "input"
            + File.separator + "logs.txt");

        var act = generateMarkdownReportResourcesByIPAndWriteToOutputFile(logs);
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

        var act = generateAdocReportGeneralAndWriteToOutputFile(logs);
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

        var act = generateAdocReportCodesAndWriteToOutputFile(logs);
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

        var act = generateAdocReportResourcesAndWriteToOutputFile(logs);
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void generateAdocReportResourceByDate_test() {
        String exp = """
            [cols="1,1"]
            |===
            |Date
            |Quantity

            |17/05/2015
            |3

            |===
            """;

        String[] logs = parseFile("src" + File.separator + "main" + File.separator
            + "java" + File.separator + "edu" + File.separator + "project3" + File.separator + "input"
            + File.separator + "logs.txt");

        var act = generateAdocReportResourcesByDateAndWriteToOutputFile(logs);
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void generateAdocReportResourceByIP_test() {
        String exp = """
            [cols="1,1"]
            |===
            |IP
            |Quantity

            |93.180.71.3
            |1

            |217.168.17.5
            |2

            |===
            """;

        String[] logs = parseFile("src" + File.separator + "main" + File.separator
            + "java" + File.separator + "edu" + File.separator + "project3" + File.separator + "input"
            + File.separator + "logs.txt");

        var act = generateAdocReportResourcesByIPAndWriteToOutputFile(logs);
        assertThat(act).isEqualTo(exp);
    }
}
