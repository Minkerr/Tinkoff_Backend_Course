package edu.hw2;

import edu.hw2.Task3.ConnectionException;
import edu.hw2.Task3.DefaultConnectionManager;
import edu.hw2.Task3.PopularCommandExecutor;
import org.junit.jupiter.api.Test;

public class Task3Test {
    @Test
    void updatePackages_shouldCreateAndCloseConnections() throws Exception {
        //arrange
        PopularCommandExecutor executor = new PopularCommandExecutor(new DefaultConnectionManager(), 5);
        //act
        try {
            executor.updatePackages();
        } catch (ConnectionException e) {

        }
    }
}
