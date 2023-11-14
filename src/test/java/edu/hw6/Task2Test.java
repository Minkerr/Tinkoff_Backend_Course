package edu.hw6;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.Test;
import static edu.hw6.Task2.cloneFile;
import static edu.hw6.Task2.generateCopyFilePathString;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {
    @Test
    void generateCopyFilePathString_shouldGenerateNameWithNumberIfCopyAlreadyExist (){
        //arrange
        String exp = "src\\main\\java\\edu\\hw6\\Task2Files\\CopyNameTest — copy(2).txt";
        //act
        String act = generateCopyFilePathString(Path.of("src\\main\\java\\edu\\hw6\\Task2Files\\CopyNameTest.txt"));
        //assert
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void generateCopyFilePathString_shouldGenerateNameWithCopy (){
        //arrange
        String exp = "src\\main\\java\\edu\\hw6\\Task2Files\\NameTest — copy.txt";
        //act
        String act = generateCopyFilePathString(Path.of("src\\main\\java\\edu\\hw6\\Task2Files\\NameTest.txt"));
        //assert
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void cloneFile_shouldCreateCopyWithSpecialName(){
        //arrange
        Path path = Path.of("src\\main\\java\\edu\\hw6\\Task2Files\\Secret.txt");
        String copyName = generateCopyFilePathString(path);
        Path copyPath = Path.of(copyName);
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
