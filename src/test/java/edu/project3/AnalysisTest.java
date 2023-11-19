package edu.project3;

import org.junit.jupiter.api.Test;
import static edu.project3.Analysis.averageResponseSize;
import static edu.project3.Analysis.countLogs;
import static edu.project3.Parser.parseFile;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AnalysisTest {
    @Test
    void countLogs_test() {
        int exp = 3;
        String [] logs = parseFile("src\\main\\java\\edu\\project3\\input\\logs.txt");
        var act = countLogs(logs);
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void averageResponseSize_test() {
        int exp = 130;
        String [] logs = parseFile("src\\main\\java\\edu\\project3\\input\\logs.txt");
        var act = averageResponseSize(logs);
        assertThat(act).isEqualTo(exp);
    }
}
