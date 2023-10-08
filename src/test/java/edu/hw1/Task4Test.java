package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task4Test {
    @Test
    void fixString_shouldFixStringWithNumber(){
        String exp = "214365";
        String res = Task4.fixString("123456");
        assertEquals(exp, res);
    }

    @Test
    void fixString_shouldFixStringWithCharactersAndOddLength(){
        String exp = "abcde";
        String res = Task4.fixString("badce");
        assertEquals(exp, res);
    }

    @Test
    void fixString_shouldFixStringWithSentence(){
        String exp = "This is a mixed up string.";
        String res = Task4.fixString("hTsii  s aimex dpus rtni.g");
        assertEquals(exp, res);
    }
}
