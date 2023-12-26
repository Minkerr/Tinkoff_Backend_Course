package edu.hw9;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {
    @Test
    void findDirectories_shouldFindDirectoriesWithMoreThan3Files() {
        //arrange
        List<String> exp = new ArrayList<>();
        exp.add("src" + File.separator + "main" + File.separator + "java" + File.separator + "edu" + File.separator
            + "hw9" + File.separator + "directory" + File.separator + "folder1" + File.separator + "innerFolder3");
        exp.add("src" + File.separator + "main" + File.separator + "java" + File.separator + "edu" + File.separator
            + "hw9" + File.separator + "directory" + File.separator + "folder2");
        exp.add("src" + File.separator + "main" + File.separator + "java" + File.separator + "edu" + File.separator
            + "hw9" + File.separator + "directory" + File.separator + "folder2" + File.separator + "innerFolder2");
        exp.add("src" + File.separator + "main" + File.separator + "java" + File.separator + "edu" + File.separator
            + "hw9" + File.separator + "directory" + File.separator + "folder4" + File.separator + "innerFolder1");
        exp.add("src" + File.separator + "main" + File.separator + "java" + File.separator + "edu" + File.separator
            + "hw9" + File.separator + "directory" + File.separator + "folder4" + File.separator + "innerFolder2");
        exp.add("src" + File.separator + "main" + File.separator + "java" + File.separator + "edu" + File.separator
            + "hw9" + File.separator + "directory" + File.separator + "folder4" + File.separator + "innerFolder6");
        Collections.sort(exp);
        //act
        DirectorySearcher searcher = new DirectorySearcher("src" + File.separator + "main" + File.separator
            + "java" + File.separator + "edu" + File.separator + "hw9" + File.separator + "directory");
        searcher.findDirectories(new File(searcher.getStrPath()), 3);
        List<String> act = searcher.getDirectoriesWithNFiles();
        Collections.sort(act);
        //assert
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void findFiles_shouldFindTXTFilesLargerThan500000b() {
        //expected
        List<String> exp = new ArrayList<>();
        exp.add("src" + File.separator + "main" + File.separator + "java" + File.separator + "edu" + File.separator
            + "hw9" + File.separator + "directory" + File.separator + "folder2" + File.separator + "text2.txt");
        exp.add("src" + File.separator + "main" + File.separator + "java" + File.separator + "edu" + File.separator
            + "hw9" + File.separator + "directory" + File.separator + "folder1" + File.separator + "innerFolder3"
            + File.separator + "text1.txt");
        exp.add("src" + File.separator + "main" + File.separator + "java" + File.separator + "edu" + File.separator
            + "hw9" + File.separator + "directory" + File.separator + "folder3" + File.separator + "innerFolder2"
            + File.separator + "text4.txt");
        Collections.sort(exp);
        //act
        DirectorySearcher searcher = new DirectorySearcher("src" + File.separator + "main" + File.separator
            + "java" + File.separator + "edu" + File.separator + "hw9" + File.separator + "directory");
        searcher.findFiles(new File(searcher.getStrPath()), 500000, "txt");
        List<String> act = searcher.getFilesWithCondition();
        Collections.sort(act);
        //assert
        assertThat(act).isEqualTo(exp);
    }
}
