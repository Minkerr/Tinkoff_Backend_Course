package edu.hw2.Task3;

public class FaultyConnection implements Connection {
    private final double probabilityOfFaultyConnection = 0.5;

    @Override
    public void execute(String command) {
        if (Math.random() > probabilityOfFaultyConnection) {
            throw new ConnectionException();
        }
    }

    @Override
    public void close() throws Exception {
        LOGGER.info("Connection closed");
    }
}
