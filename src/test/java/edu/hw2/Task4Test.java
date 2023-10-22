package edu.hw2;

import edu.hw2.Task4.CallingInfo;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task4Test {
    @Test
    void callingInfo_shouldNameWhoHasCalledFunction() {
        //arrange
        String expectedClassName = "com.intellij.rt.junit.JUnitStarter";
        String expectedMethodName = "main";
        //act
        String actClassName = CallingInfo.callingInfo().className();
        String actMethodName = CallingInfo.callingInfo().methodName();
        //assert
        assertThat(expectedClassName).isEqualTo(actClassName);
        assertThat(expectedMethodName).isEqualTo(actMethodName);
    }
}
