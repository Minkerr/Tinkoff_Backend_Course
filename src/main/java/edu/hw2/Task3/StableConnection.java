package edu.hw2.Task3;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StableConnection implements Connection, AutoCloseable {

    @Override
    public void execute(String command) {
        log.info("Stable connection execute " + command);
    }

    @Override
    public void close() throws Exception {
        log.info("Connection closed");
    }
}
