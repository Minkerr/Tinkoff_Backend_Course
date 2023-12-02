package edu.project3;

import org.junit.jupiter.api.Test;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import static edu.project3.Analysis.averageResponseSize;
import static edu.project3.Analysis.countLogs;
import static edu.project3.Analysis.requestedCodes;
import static edu.project3.Analysis.requestedResources;
import static edu.project3.Analysis.requestedResourcesByDate;
import static edu.project3.Analysis.requestedResourcesByIP;
import static edu.project3.Parser.parseFile;
import static edu.project3.ReportGenerator.generateMarkdownReportCodes;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AnalysisTest {
    @Test
    void countLogs_test() {
        int exp = 3;
        String[] logs = parseFile("src" + File.separator + "main" + File.separator
            + "java" + File.separator + "edu" + File.separator + "project3" + File.separator + "input"
            + File.separator + "logs.txt");
        var act = countLogs(logs);
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void averageResponseSize_test() {
        int exp = 130;
        String[] logs = parseFile("src" + File.separator + "main" + File.separator
            + "java" + File.separator + "edu" + File.separator + "project3" + File.separator + "input"
            + File.separator + "logs.txt");
        var act = averageResponseSize(logs);
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void requestedCodes_test() {
        Map<Integer, Long> exp = new HashMap<>();
        exp.put(200, 1L);
        exp.put(304, 1L);
        exp.put(404, 1L);
        String[] logs = parseFile("src" + File.separator + "main" + File.separator
            + "java" + File.separator + "edu" + File.separator + "project3" + File.separator + "input"
            + File.separator + "logs.txt");
        var act = requestedCodes(logs);
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void requestedResources_test() {
        Map<String, Long> exp = new HashMap<>();
        exp.put("GET /downloads/product_1 HTTP/1.1", 1L);
        exp.put("GET /downloads/product_2 HTTP/1.1", 2L);
        String[] logs = parseFile("src" + File.separator + "main" + File.separator
            + "java" + File.separator + "edu" + File.separator + "project3" + File.separator + "input"
            + File.separator + "logs.txt");
        var act = requestedResources(logs);
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void requestedResourcesByDate_test() {
        Map<String, Long> exp = new HashMap<>();
        exp.put("15/05/2015", 2L);
        exp.put("16/05/2015", 3L);
        exp.put("17/05/2015", 3L);
        exp.put("18/05/2015", 1L);
        exp.put("19/05/2015", 1L);
        String[] logs = parseFile("src" + File.separator + "main" + File.separator
            + "java" + File.separator + "edu" + File.separator + "project3" + File.separator + "input"
            + File.separator + "logs2015May17.txt");
        var act = requestedResourcesByDate(logs);
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void requestedResourcesByIP_test() {
        Map<String, Long> exp = new HashMap<>();
        exp.put("93.180.71.3", 4L);
        exp.put("80.91.33.133", 2L);
        exp.put("217.168.17.5", 4L);
        String[] logs = parseFile("src" + File.separator + "main" + File.separator
            + "java" + File.separator + "edu" + File.separator + "project3" + File.separator + "input"
            + File.separator + "logs2015May17.txt");
        var act = requestedResourcesByIP(logs);
        assertThat(act).isEqualTo(exp);
    }
}
