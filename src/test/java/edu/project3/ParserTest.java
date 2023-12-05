package edu.project3;

import java.io.File;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import org.junit.jupiter.api.Test;
import static edu.project3.Parser.parseFile;
import static edu.project3.Parser.parseFileFromDate;
import static edu.project3.Parser.parseFileToDate;
import static edu.project3.Parser.parseFileWithDate;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ParserTest {
    @Test
    void parseFile_test() {
        String[] exp = {
            "217.168.17.5 - - [17/May/2015:08:05:09 +0000] \"GET /downloads/product_2 HTTP/1.1\" 200" +
                " 490 \"-\" \"Debian APT-HTTP/1.3 (0.8.10.3)\"",
            "93.180.71.3 - - [17/May/2015:08:05:57 +0000] \"GET /downloads/product_1 HTTP/1.1\" 304" +
                " 0 \"-\" \"Debian APT-HTTP/1.3 (0.8.16~exp12ubuntu10.21)\"",
            "217.168.17.5 - - [17/May/2015:08:05:02 +0000] \"GET /downloads/product_2 HTTP/1.1\" 404" +
                " 337 \"-\" \"Debian APT-HTTP/1.3 (0.8.10.3)\""
        };

        var act = parseFile("src" + File.separator + "main" + File.separator
            + "java" + File.separator + "edu" + File.separator + "project3" + File.separator + "input"
            + File.separator + "logs.txt");

        assertThat(act).isEqualTo(exp);
    }

    @Test
    void parseFileWithDate_test() {
        String[] exp = {
            "93.180.71.3 - - [17/May/2015:08:05:57 +0000] \"GET /downloads/product_1 HTTP/1.1\" 304" +
                " 0 \"-\" \"Debian APT-HTTP/1.3 (0.8.16~exp12ubuntu10.21)\"",
            "217.168.17.5 - - [17/May/2015:08:05:02 +0000] \"GET /downloads/product_2 HTTP/1.1\" 404" +
                " 337 \"-\" \"Debian APT-HTTP/1.3 (0.8.10.3)\"",
            "217.168.17.5 - - [17/May/2015:08:05:42 +0000] \"GET /downloads/product_1 HTTP/1.1\" 404" +
                " 332 \"-\" \"Debian APT-HTTP/1.3 (0.8.10.3)\""
        };

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MMM/yyyy:HH:mm:ss Z", Locale.ENGLISH);
        OffsetDateTime from = OffsetDateTime.parse("17/May/2015:08:05:01 +0000", formatter);
        OffsetDateTime to = OffsetDateTime.parse("17/May/2015:08:05:59 +0000", formatter);
        var act = parseFileWithDate("src" + File.separator + "main" + File.separator
            + "java" + File.separator + "edu" + File.separator + "project3" + File.separator + "input"
            + File.separator + "logs2015May17.txt", from, to);

        assertThat(act).isEqualTo(exp);
    }

    @Test
    void parseFileFromDate_test() {
        String[] exp = {
            "93.180.71.3 - - [17/May/2015:08:05:57 +0000] \"GET /downloads/product_1 HTTP/1.1\" 304" +
                " 0 \"-\" \"Debian APT-HTTP/1.3 (0.8.16~exp12ubuntu10.21)\"",
            "217.168.17.5 - - [17/May/2015:08:05:02 +0000] \"GET /downloads/product_2 HTTP/1.1\" 404" +
                " 337 \"-\" \"Debian APT-HTTP/1.3 (0.8.10.3)\"",
            "217.168.17.5 - - [17/May/2015:08:05:42 +0000] \"GET /downloads/product_1 HTTP/1.1\" 404" +
                " 332 \"-\" \"Debian APT-HTTP/1.3 (0.8.10.3)\"",
            "80.91.33.133 - - [18/May/2015:08:05:01 +0000] \"GET /downloads/product_1 HTTP/1.1\" 304" +
                " 0 \"-\" \"Debian APT-HTTP/1.3 (0.8.16~exp12ubuntu10.17)\"",
            "93.180.71.3 - - [19/May/2015:08:05:27 +0000] \"GET /downloads/product_1 HTTP/1.1\" 304" +
                " 0 \"-\" \"Debian APT-HTTP/1.3 (0.8.16~exp12ubuntu10.21)\""
        };

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MMM/yyyy:HH:mm:ss Z", Locale.ENGLISH);
        OffsetDateTime from = OffsetDateTime.parse("17/May/2015:08:05:01 +0000", formatter);
        var act = parseFileFromDate("src" + File.separator + "main" + File.separator
            + "java" + File.separator + "edu" + File.separator + "project3" + File.separator + "input"
            + File.separator + "logs2015May17.txt", from);

        assertThat(act).isEqualTo(exp);
    }

    @Test
    void parseFileToDate_test() {
        String[] exp = {
            "93.180.71.3 - - [15/May/2015:08:05:32 +0000] \"GET /downloads/product_1 HTTP/1.1\" 304 " +
                "0 \"-\" \"Debian APT-HTTP/1.3 (0.8.16~exp12ubuntu10.21)\"",
            "93.180.71.3 - - [15/May/2015:08:05:23 +0000] \"GET /downloads/product_1 HTTP/1.1\" 304 " +
                "0 \"-\" \"Debian APT-HTTP/1.3 (0.8.16~exp12ubuntu10.21)\""
        };

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MMM/yyyy:HH:mm:ss Z", Locale.ENGLISH);
        OffsetDateTime to = OffsetDateTime.parse("15/May/2015:08:05:59 +0000", formatter);
        var act = parseFileToDate("src" + File.separator + "main" + File.separator
            + "java" + File.separator + "edu" + File.separator + "project3" + File.separator + "input"
            + File.separator + "logs2015May17.txt", to);

        assertThat(act).isEqualTo(exp);
    }
}
