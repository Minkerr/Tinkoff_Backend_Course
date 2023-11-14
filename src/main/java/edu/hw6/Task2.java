package edu.hw6;

import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Task2 {
    public static void cloneFile(Path path) {
        try {
            Path correctPath = Path.of(generateCopyFilePathString(path));
            FileChannel inChannel = FileChannel.open(path);
            ByteBuffer buffer = ByteBuffer.allocate(256);
            StringBuilder content = new StringBuilder();

            int bytesRead = inChannel.read(buffer);
            while (bytesRead != -1) {
                buffer.flip();

                while (buffer.hasRemaining()) {
                    content.append((char) (buffer.get()));
                }

                buffer.clear();
                bytesRead = inChannel.read(buffer);
            }
            inChannel.close();

            byte[] bs = content.toString().getBytes();
            Files.write(correctPath, bs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String generateCopyFilePathString(Path path) {
        String name = String.valueOf(path.getFileName());
        String parent = String.valueOf(path.getParent());
        StringBuilder pathWithoutTxt = new StringBuilder(parent + "\\");
        pathWithoutTxt.append(name, 0, name.length() - 4);
        Path pathCopy = Paths.get(pathWithoutTxt + " — copy.txt");
        if (Files.exists(pathCopy)) {
            int i = 2;
            while (Files.exists(pathCopy)){
                pathCopy = Paths.get(pathWithoutTxt + " — copy("+ i +").txt");
                i++;
            }
        }
        return pathCopy.toString();
    }

    private Task2(){

    }
}
