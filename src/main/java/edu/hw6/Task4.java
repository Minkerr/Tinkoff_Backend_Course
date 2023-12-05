package edu.hw6;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.zip.Adler32;
import java.util.zip.CheckedOutputStream;

public class Task4 {
    private Task4() {
    }

    private static String text = "Programming is learned by writing programs. ― Brian Kernighan";

    public static void createFileWithStreamChain() {
        File file = new File("src\\test\\java\\edu\\hw6\\Task4File\\Task4Text.txt");
        try (
            OutputStream outputStream = new FileOutputStream(file);
            CheckedOutputStream checkedOutputStream = new CheckedOutputStream(outputStream, new Adler32());
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(checkedOutputStream);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(
                bufferedOutputStream,
                StandardCharsets.UTF_8
            );
            PrintWriter printWriter = new PrintWriter(outputStreamWriter)
        ) {
            printWriter.write(text);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
