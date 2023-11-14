package edu.hw6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Task2 {
    public static void cloneFile(Path path) throws IOException {
        Path newPath = Path.of(path.getParent() + "\\" + generateCopyFilePathString(path));
        Files.copy(path, newPath);
    }

    public static String generateCopyFilePathString(Path path) {
        String name = String.valueOf(path.getFileName());
        String parent = String.valueOf(path.getParent());
        //StringBuilder pathWithoutTxt = new StringBuilder(parent + "\\");
        StringBuilder nameWithoutTxt = new StringBuilder();
        nameWithoutTxt.append(name, 0, name.length() - ".txt".length());
        Path pathCopy = Paths.get(parent + "\\" + nameWithoutTxt + " — copy.txt");
        if (Files.exists(pathCopy)) {
            int i = 2;
            while (Files.exists(pathCopy)) {
                pathCopy = Paths.get(parent + "\\" + nameWithoutTxt + " — copy(" + i + ").txt");
                i++;
            }
        }
        return pathCopy.getFileName().toString();
    }

    private Task2() {

    }
}
