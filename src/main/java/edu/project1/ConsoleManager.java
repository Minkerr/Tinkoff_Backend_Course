package edu.project1;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConsoleManager {
    private final static Logger LOGGER = LogManager.getLogger();
    private Game game;

    public ConsoleManager(Game game) {
        this.game = game;
    }

    public void showGameStartMessage() {
        String helloMessage = "The game has started!\n";
        String word = "The word: " + String.valueOf(game.getPlayerAnswer()) + "\n";
        LOGGER.info(helloMessage + word);
    }

    public void showGuessResult(GuessResult guessResult) {
        LOGGER.info(guessResult.message());
    }

    public void showGameResult(GameResult gameResult) {
        LOGGER.info(gameResult.message());
    }

    public String getPlayerInput(Scanner scanner) {
        LOGGER.info("Guess a letter:\n");
        String playerInput = scanner.nextLine();
        return playerInput;
    }
}
