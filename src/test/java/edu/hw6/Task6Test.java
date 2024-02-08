package edu.hw6;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import static edu.hw6.Task6.findBusyPorts;
import static edu.hw6.Task6.findBusyPortsWithInfo;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task6Test {
    private static final Logger LOGGER = LogManager.getLogger();

    @Test
    void findBusyPorts_shouldReturnListOfBusyPorts() throws IOException {
        var ports = findBusyPorts();
        assertThat(ports.contains(135)).isTrue();
    }

    @Test
    void findBusyPortsWithInfo_shouldReturnTableOfBusyPorts() {
        var ports = findBusyPortsWithInfo();
        for (var port : ports) {
            LOGGER.info(port[0] + " - " + port[1] + " - " + port[2]);
        }
    }
}
