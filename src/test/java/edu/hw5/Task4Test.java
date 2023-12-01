package edu.hw5;

import org.junit.jupiter.api.Test;
import static edu.hw5.Task4.isPasswordSafe;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task4Test {
    @Test
    void isPasswordSafe_shouldCheckDoesThePasswordContainsTildaSymbol(){
        assertThat(isPasswordSafe("pass~word")).isTrue();
    }

    @Test
    void isPasswordSafe_shouldCheckDoesThePasswordContainsExclamationPointSymbol(){
        assertThat(isPasswordSafe("pass!word")).isTrue();
    }

    @Test
    void isPasswordSafe_shouldCheckDoesThePasswordContainsAtSymbol(){
        assertThat(isPasswordSafe("pass@word")).isTrue();
    }

    @Test
    void isPasswordSafe_shouldCheckDoesThePasswordContainsHashSymbol(){
        assertThat(isPasswordSafe("pass@wo#rd")).isTrue();
    }

    @Test
    void isPasswordSafe_shouldCheckDoesThePasswordContainsDollarSymbolAndPercent(){
        assertThat(isPasswordSafe("pass$wo%rd")).isTrue();
    }

    @Test
    void isPasswordSafe_shouldCheckDoesThePasswordContainsAmpersandAndCircumflex(){
        assertThat(isPasswordSafe("pass^wo&rd")).isTrue();
    }

    @Test
    void isPasswordSafe_shouldCheckDoesThePasswordContainsStarAndStick(){
        assertThat(isPasswordSafe("pass*wo|rd")).isTrue();
    }

    @Test
    void isPasswordSafe_shouldFalseForPasswordWithoutSpecialSymbols(){
        assertThat(isPasswordSafe("password")).isFalse();
    }
}
