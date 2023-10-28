package edu.hw2.Task3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FaultyConnection implements Connection {
    private static final Logger LOGGER = LogManager.getLogger();
    private final double probabilityOfFaultyConnection = 0.5;

    @Override
    public void execute(String command) {
        if (Math.random() > probabilityOfFaultyConnection) {
            throw new ConnectionException();
        } else {
            LOGGER.info("Faulty connection execute " + command);
        }
    }

    @Override
    public void close() throws Exception {
        LOGGER.info("Connection closed");
    }
}
