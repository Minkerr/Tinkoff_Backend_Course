package edu.project1;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GameManager {
    private Game game;
    private final static Logger LOGGER = LogManager.getLogger();

    public GameManager(String word) {
        this.game = new Game(word);
    }

    public GameManager() {
        this.game = new Game();
    }

    public Game getGame() {
        return game;
    }

    public GameResult run(Scanner scanner) {
        showGameStartMessage();
        boolean gameIsWon = false;

        while (game.getAttempts() != game.getMaxAttempts()) { // game ends when attempts reaches max quantity
            String playerInput = getPlayerInput(scanner);
            showGuessResult(playerInput);

            if (game.getAnswer().equals(String.valueOf(game.getPlayerAnswer()))) {
                gameIsWon = true;
                break; // game ends with a victory when a player guesses the word
            }
        }

        GameResult gameResult = determineGameResult(gameIsWon);
        showGameResult(gameResult);
        return gameResult;
    }

    private void showGameStartMessage() {
        String helloMessage = "The game has started!\n";
        String word = "The word: " + String.valueOf(game.getPlayerAnswer()) + "\n";
        LOGGER.info(helloMessage + word);
    }

    private void showGuessResult(String playerInput) {
        GuessResult guessResult = tryGuess(playerInput);
        LOGGER.info(guessResult.message());
    }

    private void showGameResult(GameResult gameResult) {
        LOGGER.info(gameResult.message());
    }

    private GameResult determineGameResult(boolean gameIsWon) {
        GameResult gameResult;
        if (gameIsWon) {
            gameResult = new GameResult.Win();
        } else {
            gameResult = new GameResult.Defeat();
        }
        return gameResult;
    }

    public String getPlayerInput(Scanner scanner) {
        LOGGER.info("Guess a letter:\n");
        String playerInput = scanner.nextLine();
        return playerInput;
    }

    public GuessResult tryGuess(String input) {
        boolean isInputCorrect = (input.length() == 1 && input.charAt(0) >= 'a' && input.charAt(0) <= 'z');
        /* input should be one English alphabet letter */
        if (isInputCorrect) {
            return tryCorrectGuess(input);
        } else {
            return new GuessResult.IncorrectGuess(game);
        }
    }

    private GuessResult tryCorrectGuess(String input) {
        if (game.getAnswer().contains(input)) {
            char letter = input.charAt(0);
            game.rewritePlayerAnswer(letter);
            return new GuessResult.SuccessfulGuess(game);
        } else {
            game.setAttempts(game.getAttempts() + 1);
            return new GuessResult.FailedGuess(game);
        }
    }

}
