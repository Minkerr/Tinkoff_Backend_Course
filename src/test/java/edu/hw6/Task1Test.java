package edu.hw6;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import edu.hw6.Task1.DiskMap;

public class Task1Test {
    @Test
    void generateCopyFilePathString_shouldGenerateNameWithNumberIfCopyAlreadyExist() throws IOException {
        //arrange
        String exp = "CopyNameTest — copy(2).txt";
        //act
        DiskMap disk = new DiskMap(Path.of("src\\main\\java\\edu\\hw6\\DiskMapStorage\\diskMapTest.txt"));
//        disk.put("key1", "value1");
//        disk.put("key2", "value2");
//        disk.put("key3", "value3");
//        System.out.println(disk.remove("key2"));

        //assert
        //assertThat(act).isEqualTo(exp);
    }
}
