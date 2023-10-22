package edu.hw2;

import edu.hw2.Task3.ConnectionException;
import edu.hw2.Task3.DefaultConnectionManager;
import edu.hw2.Task3.FaultyConnectionManager;
import edu.hw2.Task3.PopularCommandExecutor;
import edu.hw2.Task3.StableConnection;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
        // test
    }

    @Test
    void faultyConnection_shouldDropExceptionSometimes() {
        //arrange
        PopularCommandExecutor executor = new PopularCommandExecutor(new FaultyConnectionManager(), 10);
        //act
        Throwable exception = assertThrows(ConnectionException.class, executor::updatePackages);
        // assert
        assertThat(exception.getMessage()).isEqualTo("apt update && apt upgrade -y");
    }

    @Test
    void stableConnection_shouldNeverDropException() throws Exception {
        //arrange
        StableConnection stableConnection = new StableConnection();
        //act
        // assert
        assertDoesNotThrow(() -> stableConnection.execute("test"));
    }

}
