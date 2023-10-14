package edu.hw2.Task3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public interface Connection extends AutoCloseable {
    Logger LOGGER = LogManager.getLogger();
    void execute(String command);
}
