package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task4Test {
    @Test
    void fixString_shouldFixStringWithNumber(){
        //arrange
        String exp = "214365";
        String stringWithNumber = "123456";
        //act
        String act = Task4.fixString(stringWithNumber);
        //assert
        assertEquals(exp, act);
    }

    @Test
    void fixString_shouldFixStringWithCharactersAndOddLength(){
        //arrange
        String exp = "abcde";
        String stringWithCharactersAndOddLength = "badce";
        //act
        String act = Task4.fixString(stringWithCharactersAndOddLength);
        //assert
        assertEquals(exp, act);
    }

    @Test
    void fixString_shouldFixStringWithSentence(){
        //arrange
        String exp = "This is a mixed up string.";
        String stringWithSentence = "hTsii  s aimex dpus rtni.g";
        //act
        String act = Task4.fixString(stringWithSentence);
        //assert
        assertEquals(exp, act);
    }
}
