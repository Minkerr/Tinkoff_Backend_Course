package edu.hw2;

import edu.hw2.Task4.CallingInfo;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CallingInfoTest {
    @Test
    void callingInfo_shouldNameWhoHasCalledFunction() {
        String expectedClassName = "edu.hw2.CallingInfoTest";
        String expectedMethodName = "callingInfo_shouldNameWhoHasCalledFunction";
        //act
        String actClassName = CallingInfo.callingInfo().className();
        String actMethodName = CallingInfo.callingInfo().methodName();
        //assert
        assertThat(expectedClassName).isEqualTo(actClassName);
        assertThat(expectedMethodName).isEqualTo(actMethodName);
    }
}
