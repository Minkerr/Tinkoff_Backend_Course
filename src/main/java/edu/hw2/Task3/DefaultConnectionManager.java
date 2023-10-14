package edu.hw2.Task3;

public class DefaultConnectionManager implements ConnectionManager {
    private final double probabilityOfFaultyConnection = 0.5;

    @Override
    public Connection getConnection() {
        if (Math.random() > probabilityOfFaultyConnection) {
            return new StableConnection();
        } else {
            return new FaultyConnection();
        }
    }
}
