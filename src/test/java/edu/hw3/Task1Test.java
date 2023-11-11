package edu.hw3;

import org.junit.jupiter.api.Test;
import static edu.hw3.Task1.atbash;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {

    @Test
    void atbash_shouldConvertHelloWorld() {
        // arrange
        String exp = "Svool dliow!";
        // act
        String act = atbash("Hello world!");
        // assert
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void atbash_shouldConvertLongString() {
        // arrange
        String exp = "Any fool can write code that a computer can understand." +
            " Good programmers write code that humans can understand. ― Martin Fowler";
        // act
        String act = atbash("Zmb ullo xzm dirgv xlwv gszg z xlnkfgvi xzm fmwvihgzmw." +
            " Tllw kiltiznnvih dirgv xlwv gszg sfnzmh xzm fmwvihgzmw. ― Nzigrm Uldovi");
        // assert
        assertThat(act).isEqualTo(exp);
    }
}
