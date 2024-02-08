package edu.hw6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.jupiter.api.Test;
import static edu.hw6.Task4.createFileWithStreamChain;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task4Test {
    @Test
    void createFileWithStreamChain_shouldCreateFileWithTextInAComplexWay() throws IOException {
        //arrange
        String exp = "Programming is learned by writing programs. ― Brian Kernighan";
        //act
        createFileWithStreamChain();
        Path path = Paths.get("src\\test\\java\\edu\\hw6\\Task4File\\Task4Text.txt");
        String act = Files.readAllLines(path).get(0);
        //assert
        assertThat(act).isEqualTo(exp);
    }
}
