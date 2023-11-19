package edu.hw6;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class Task3 {
    private Task3() {
    }

    public static AbstractFilter regularFile = Files::isRegularFile;
    public static AbstractFilter readable = Files::isReadable;
    public static AbstractFilter globMatchesTxt = (Path p) -> (p.getFileName().toString().matches(".txt$"));
    public static AbstractFilter regexContainsDigit =
        (Path p) -> (p.getFileName().toString().matches(".*[0-9].*"));
    @SuppressWarnings("MagicNumber")
    public static AbstractFilter largerThan100000 = (Path p) -> (Files.size(p) > 100000);

    @SuppressWarnings("MagicNumber")
    public static AbstractFilter magicNumber089 =
        (Path p) -> (Files.readAllBytes(p).length != 0 && Files.readAllBytes(p)[0] == (byte) 0x89);

    @FunctionalInterface
    public interface AbstractFilter extends DirectoryStream.Filter<Path> {
        @Override
        boolean accept(Path t) throws IOException;

        default boolean containsRegex(Path p, String s) {
            return false;
        }

        default AbstractFilter and(AbstractFilter other) {
            return (t) -> accept(t) && other.accept(t);
        }
    }

}
