package edu.hw6;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Task2 {
    public static void cloneFile(Path path) throws IOException {
        String name = String.valueOf(path.getFileName());
        String parent = String.valueOf(path.getParent());
        StringBuilder nameWithoutTxt = new StringBuilder();
        nameWithoutTxt.append(name, 0, name.length() - ".txt".length());
        Path pathCopy = Paths.get(parent + File.separator + nameWithoutTxt + " — copy.txt");
        if (Files.exists(pathCopy)) {
            int i = 2;
            while (Files.exists(pathCopy)) {
                pathCopy = Paths.get(parent + File.separator + nameWithoutTxt + " — copy(" + i + ").txt");
                i++;
            }
        }

        Files.copy(path, pathCopy);
    }

    private Task2() {
    }
}
