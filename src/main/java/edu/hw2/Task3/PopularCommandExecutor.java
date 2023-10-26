package edu.hw2.Task3;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class PopularCommandExecutor {
    private final ConnectionManager manager;
    private final int maxAttempts;

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
            try (Connection connection = manager.getConnection();) {
                connection.execute(command);
            } catch (Exception e) {
                exception = e;
                log.error("Error. ConnectionException.");
            }
        }
        if (exception != null) {
            throw new ConnectionException(command, exception);
        }
    }
}
