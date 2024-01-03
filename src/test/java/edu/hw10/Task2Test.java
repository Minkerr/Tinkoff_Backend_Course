package edu.hw10;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {
    @Test
    void fib_shouldCalculateFibonacciNumber(){
        //arrange
        FibCalc c = new FibonacciCalculator();
        var exp = 8L;
        //act
        var act = c.fib(6);
        //assert
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void CacheProxy_shouldWriteToFileResultOfInterfaceFunction() throws IOException {
        //arrange
        CacheProxy cacheProxy = new CacheProxy();
        FibCalc c = new FibonacciCalculator();
        FibCalc pr = cacheProxy.create(c, c.getClass());
        Path cachePath = Path.of("src" + File.separator + "main" + File.separator + "java" + File.separator
                + "edu" + File.separator + "hw10" + File.separator + "cache" + File.separator + "cache.txt");
        String exp = "8";
        //act
        pr.fib(6);
        byte[] bytes = Files.readAllBytes(cachePath);
        String act = new String(bytes, StandardCharsets.UTF_8);;
        //assert
        assertThat(act).isEqualTo(exp);
    }
}
