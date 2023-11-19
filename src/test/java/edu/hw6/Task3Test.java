package edu.hw6;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import edu.hw6.Task3.*;
import static edu.hw6.Task3.*;

public class Task3Test {
    @Test
    void magicNumber089_shouldFilterOnlyPNGFiles(){
        //DirectoryStream.Filter<Path> filter = regularFile.and(readable).and(regexContainsDigit);
        DirectoryStream.Filter<Path> filter1 = magicNumber089;
        List<String> exp = List.of("formula.png");
        Path dir = Path.of("src\\test\\java\\edu\\hw6\\Task3Files");

        List<String> act = new ArrayList<>();
        try (DirectoryStream<Path> entries = Files.newDirectoryStream(dir, filter1)) {
            entries.forEach(el -> act.add(String.valueOf(el.getFileName())));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        assertThat(act).isEqualTo(exp);
    }
}
