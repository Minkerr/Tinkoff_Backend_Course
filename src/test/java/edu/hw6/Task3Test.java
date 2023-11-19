package edu.hw6;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static edu.hw6.Task3.*;

public class Task3Test {
    @Test
    void magicNumber089_shouldFilterOnlyPNGFiles() {
        DirectoryStream.Filter<Path> filter1 = magicNumber089;
        List<String> exp = List.of("formula.png");
        Path dir = Path.of("src" + File.separator + "test" + File.separator + "java" +
            File.separator + "edu" + File.separator + "hw6" + File.separator + "Task3Files");

        List<String> act = new ArrayList<>();
        try (DirectoryStream<Path> entries = Files.newDirectoryStream(dir, filter1)) {
            entries.forEach(el -> act.add(String.valueOf(el.getFileName())));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        assertThat(act).isEqualTo(exp);
    }

    @Test
    void writable_shouldFilterOnlyWritableFiles() {
        DirectoryStream.Filter<Path> filter = writable;
        List<String> exp = List.of(
            "CopyNameTest — copy.txt",
            "CopyNameTest.txt",
            "dt.jpg",
            "formula.png",
            "lovecraft.jpg",
            "NameTest.txt",
            "Secret — copy(2).txt",
            "Secret — copy.txt",
            "Secret.txt",
            "Test_Project (2).pdf"
        );
        Path dir = Path.of("src" + File.separator + "test" + File.separator + "java" +
            File.separator + "edu" + File.separator + "hw6" + File.separator + "Task3Files");

        List<String> act = new ArrayList<>();
        try (DirectoryStream<Path> entries = Files.newDirectoryStream(dir, filter)) {
            entries.forEach(el -> act.add(String.valueOf(el.getFileName())));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        assertThat(act).isEqualTo(exp);
    }

    @Test
    void globMatchesTxtAndRegexContainsDigit_shouldFilterOnlyTxtFilesWithDigitInName() {
        DirectoryStream.Filter<Path> filter = globMatchesTxt.and(regexContainsDigit);
        List<String> exp = List.of("Secret — copy(2).txt");
        Path dir = Path.of("src" + File.separator + "test" + File.separator + "java" +
            File.separator + "edu" + File.separator + "hw6" + File.separator + "Task3Files");

        List<String> act = new ArrayList<>();
        try (DirectoryStream<Path> entries = Files.newDirectoryStream(dir, filter)) {
            entries.forEach(el -> act.add(String.valueOf(el.getFileName())));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        assertThat(act).isEqualTo(exp);
    }

    @Test
    void largerThan_shouldFilterOnlyHeavyFiles() {
        DirectoryStream.Filter<Path> filter = largerThan100000;
        List<String> exp = List.of("dt.jpg", "formula.png", "lovecraft.jpg");
        Path dir = Path.of("src" + File.separator + "test" + File.separator + "java" +
            File.separator + "edu" + File.separator + "hw6" + File.separator + "Task3Files");

        List<String> act = new ArrayList<>();
        try (DirectoryStream<Path> entries = Files.newDirectoryStream(dir, filter)) {
            entries.forEach(el -> act.add(String.valueOf(el.getFileName())));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        assertThat(act).isEqualTo(exp);
    }

}
