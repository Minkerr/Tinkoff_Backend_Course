package edu.hw6;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.Test;
import static edu.hw6.Task2.cloneFile;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {
/*
    @Test
    void generateCopyFilePathString_shouldGenerateNameWithNumberIfCopyAlreadyExist() {
        //arrange
        String exp = "CopyNameTest — copy(2).txt";
        Path path = Path.of("src/test/java/edu/hw6/Task2Files/CopyNameTest.txt");
        //act
        String act = generateCopyFilePathString(path);
        //assert
        assertThat(act).isEqualTo(exp);
    }
    */
/*
    @Test
    void generateCopyFilePathString_shouldGenerateNameWithCopy() {
        //arrange
        String exp = "NameTest — copy.txt";
        //act
        String act = generateCopyFilePathString(
            Path.of("src\\main\\java\\edu\\hw6\\Task2Files\\NameTest.txt"));
        //assert
        assertThat(act).isEqualTo(exp);
    }


 */

    @Test
    void cloneFile_shouldCreateCopyWithSpecialName() throws IOException {
        //arrange
        Path path = Path.of("src" + File.separator + "main" + File.separator + "java" + File.separator +
            "edu" + File.separator + "hw6" + File.separator + "Task2Files" + File.separator + "Secret.txt");
        Path copyPath = Path.of("src" + File.separator + "main" + File.separator + "java" + File.separator +
            "edu" + File.separator + "hw6" + File.separator + "Task2Files" + File.separator +
            "Secret — copy(3).txt");
        //act
        cloneFile(path);
        boolean fileIsExist = Files.exists(copyPath);
        //assert
        assertThat(fileIsExist).isTrue();
        //delete
        try {
            Files.delete(copyPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
