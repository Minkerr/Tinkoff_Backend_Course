package edu.hw2.Task3;

public class StableConnection implements Connection, AutoCloseable {
    @Override
    public void execute(String command) {

    }

    @Override
    public void close() throws Exception {
        LOGGER.info("Connection closed");
    }
}
