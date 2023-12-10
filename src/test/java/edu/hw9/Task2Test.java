package edu.hw9;

import org.junit.jupiter.api.Test;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {
    @Test
    void findDirectories_shouldCountFindDirectoriesWithMoreThan3Files(){
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
        DirectorySearcher searcher = new DirectorySearcher("src" + File.separator + "main"+ File.separator
            + "java" + File.separator + "edu" + File.separator + "hw9" + File.separator + "directory");
        searcher.findDirectories(new File(searcher.getStrPath()), 3);
        List<String> act = searcher.getDirectoriesWithNFiles();
        Collections.sort(act);
        //assert
        assertThat(act).isEqualTo(exp);
    }
}
