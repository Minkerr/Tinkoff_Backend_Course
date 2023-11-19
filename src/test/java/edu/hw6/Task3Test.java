package edu.hw6;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import edu.hw6.Task3.*;
import static edu.hw6.Task3.*;

public class Task3Test {
    @Test
    void filter(){
        DirectoryStream.Filter<Path> filter = regularFile.and(readable).and(regexContainsDigit);
        DirectoryStream.Filter<Path> filter1 = magicNumber;

        Path dir = Path.of("src\\main\\java\\edu\\hw6\\Task2Files");
        try (DirectoryStream<Path> entries = Files.newDirectoryStream(dir, filter1)) {
            entries.forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //assertThat().isTrue;
    }
}
