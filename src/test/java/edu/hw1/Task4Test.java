package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task4Test {
    @Test
    void test1(){
        String exp = "214365";
        String res = Task4.fixString("123456");
        assertEquals(exp, res);
    }

    @Test
    void test2(){
        String exp = "abcde";
        String res = Task4.fixString("badce");
        assertEquals(exp, res);
    }

    @Test
    void test3(){
        String exp = "This is a mixed up string.";
        String res = Task4.fixString("hTsii  s aimex dpus rtni.g");
        assertEquals(exp, res);
    }
}
