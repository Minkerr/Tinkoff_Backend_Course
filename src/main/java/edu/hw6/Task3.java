package edu.hw6;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;
import java.util.function.Predicate;

public class Task3 {

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
    @FunctionalInterface
    public interface NumberFilter<String> extends DirectoryStream.Filter<Path> {
        @Override
        boolean accept(Path t);
        default AbstractFilter and(AbstractFilter other) {
            return (t) -> accept(t) && other.accept(t);
        }
    }
    public static final AbstractFilter regularFile = Files::isRegularFile;
    public static final AbstractFilter readable = Files::isReadable;
    public static final AbstractFilter globMatchesTxt = (Path p) -> (p.getFileName().toString().matches(".txt$"));
    public static final AbstractFilter regexContainsDigit =
        (Path p) -> (p.getFileName().toString().matches(".*[0-9].*"));
    public static final AbstractFilter largerThan100000 = (Path p) -> (Files.size(p) > 100000);

    public static final AbstractFilter magicNumber =
        (Path p) -> (Files.readAllBytes(p).length != 0 && Files.readAllBytes(p)[0] == (byte)0x89);

//    DirectoryStream.Filter<Path> filter = regularFile
//        .and(readable)
//        .and(largerThan(100_000))
//        .and(magicNumber(0x89, 'P', 'N', 'G'))
//        .and(globMatches("*.png"))
//        .and(regexContains("[-]"));


}
