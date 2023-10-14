package edu.hw2;

import edu.hw2.Task4.CallingInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

public class Task4Test {
    @Test
    void callingInfo_shouldNameWhoHasCalledFunction() {
        Logger logger = LogManager.getLogger();
        logger.info(CallingInfo.callingInfo());
    }
}
