package edu.hw3;

import org.junit.jupiter.api.Test;
import static edu.hw3.Task4.convertToRoman;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task4Test {
    @Test
    void convertToRoman_shouldConvertTwo(){
        //arrange
        String exp = "II";
        // act
        String act = convertToRoman(2);
        // assert
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void convertToRoman_shouldConvertFour(){
        //arrange
        String exp = "IV";
        // act
        String act = convertToRoman(4);
        // assert
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void convertToRoman_shouldConvertNine(){
        //arrange
        String exp = "IX";
        // act
        String act = convertToRoman(9);
        // assert
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void convertToRoman_shouldConvertTwelve(){
        //arrange
        String exp = "XII";
        // act
        String act = convertToRoman(12);
        // assert
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void convertToRoman_shouldConvertSixteen(){
        //arrange
        String exp = "XVI";
        // act
        String act = convertToRoman(16);
        // assert
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void convertToRoman_shouldConvertThirtyEight(){
        //arrange
        String exp = "XXXVIII";
        // act
        String act = convertToRoman(38);
        // assert
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void convertToRoman_shouldConvert142(){
        //arrange
        String exp = "CXLII";
        // act
        String act = convertToRoman(142);
        // assert
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void convertToRoman_shouldConvert895(){
        //arrange
        String exp = "DCCCXCV";
        // act
        String act = convertToRoman(895);
        // assert
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void convertToRoman_shouldConvert1752(){
        //arrange
        String exp = "MDCCLII";
        // act
        String act = convertToRoman(1752);
        // assert
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void convertToRoman_shouldConvert3999(){
        //arrange
        String exp = "MMMCMXCIX";
        // act
        String act = convertToRoman(3999);
        // assert
        assertThat(act).isEqualTo(exp);
    }
}
