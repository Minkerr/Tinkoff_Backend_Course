package edu.hw2;

import edu.hw2.Task4.CallingInfo;
import org.junit.jupiter.api.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CallingInfoTest {
    @Test
    void callingInfo_shouldNameWhoHasCalledFunction() {
        Logger logger = LogManager.getLogger();
        logger.info(CallingInfo.callingInfo().toString());
    }
}
