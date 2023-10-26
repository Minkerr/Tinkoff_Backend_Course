package edu.hw2.Task3;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FaultyConnection implements Connection {
    private final double probabilityOfFaultyConnection = 0.5;

    @Override
    public void execute(String command) {
        if (Math.random() > probabilityOfFaultyConnection) {
            throw new ConnectionException();
        } else {
            log.info("Faulty connection execute " + command);
        }
    }

    @Override
    public void close() throws Exception {
        log.info("Connection closed");
    }
}
