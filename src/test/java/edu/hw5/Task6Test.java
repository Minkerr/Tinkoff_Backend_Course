package edu.hw5;

import org.junit.jupiter.api.Test;
import static edu.hw5.Task6.isASubstring;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task6Test {
    @Test
    void isASubstring_shouldFindAAAinABCABCDA() {
        assertThat(isASubstring("ABCABCA", "AAA")).isTrue();
    }

    @Test
    void isASubstring_shouldFindAAAinBCABCABCDABC() {
        assertThat(isASubstring("BCABCABCABC", "AAA")).isTrue();
    }

    @Test
    void isASubstring_shouldFindAinBCABCABCDABC() {
        assertThat(isASubstring("BCABCABCABC", "A")).isTrue();
    }

    @Test
    void isASubstring_shouldFindEmptyStringInBCABCABCDABC() {
        assertThat(isASubstring("BCABCABCABC", "")).isTrue();
    }

    @Test
    void isASubstring_shouldNotFindABCinXACBY() {
        assertThat(isASubstring("XACBY", "ABC")).isTrue();
    }

    @Test
    void isASubstring_shouldNotFindABDinXACBY() {
        assertThat(isASubstring("XACBY", "ABD")).isTrue();
    }

}
