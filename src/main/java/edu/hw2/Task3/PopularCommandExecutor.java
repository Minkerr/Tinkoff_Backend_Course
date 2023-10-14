package edu.hw2.Task3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class PopularCommandExecutor {
    private final ConnectionManager manager;
    private final int maxAttempts;
    Logger logger = LogManager.getLogger();

    public PopularCommandExecutor() {
        maxAttempts = 1;
        manager = new DefaultConnectionManager();
    }

    public PopularCommandExecutor(ConnectionManager manager, int maxAttempts) {
        this.manager = manager;
        this.maxAttempts = maxAttempts;
    }

    public void updatePackages() throws Exception {
        tryExecute("apt update && apt upgrade -y");
    }

    void tryExecute(String command) throws Exception {
        Exception exception = null;
        for (int i = 0; i < maxAttempts; i++) {
            Connection connection = manager.getConnection();
            try {
                connection.execute(command);
            } catch (Exception e) {
                exception = e;
                logger.info("Error");
            } finally {
                connection.close();
            }
        }
        if (exception != null) {
            throw new ConnectionException(command, exception);
        }
    }
}
