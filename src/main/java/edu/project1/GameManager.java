package edu.project1;

import java.util.Scanner;

public class GameManager {
    private Game game;
    private ConsoleManager consoleManager;

    public GameManager(String word) {
        this.game = new Game(word);
        this.consoleManager = new ConsoleManager(game);
    }

    public GameManager() {
        this.game = new Game();
        this.consoleManager = new ConsoleManager(game);
    }

    public Game getGame() {
        return game;
    }

    public GameResult run(Scanner scanner) {
        consoleManager.showGameStartMessage();
        boolean gameIsWon = false;

        while (game.getAttempts() != game.getMaxAttempts()) { // game ends when attempts reaches max quantity
            String playerInput = consoleManager.getPlayerInput(scanner);
            GuessResult guessResult = tryGuess(playerInput);
            consoleManager.showGuessResult(guessResult);

            if (game.getAnswer().equals(String.valueOf(game.getPlayerAnswer()))) {
                gameIsWon = true;
                break; // game ends with a victory when a player guesses the word
            }
        }

        GameResult gameResult = determineGameResult(gameIsWon);
        consoleManager.showGameResult(gameResult);
        return gameResult;
    }

    private GameResult determineGameResult(boolean gameIsWon) {
        return gameIsWon ? new GameResult.Win() : new GameResult.Defeat();
    }

    public GuessResult tryGuess(String input) {
        boolean isInputCorrect = checkInputCorrectness(input);

        if (!isInputCorrect) {
            return new GuessResult.IncorrectGuess(game);
        } else if (lookForLetterInAnswer(input)) {
            char letter = input.charAt(0);
            game.rewritePlayerAnswer(letter);
            return new GuessResult.SuccessfulGuess(game);
        } else {
            game.setAttempts(game.getAttempts() + 1);
            return new GuessResult.FailedGuess(game);
        }
    }

    private boolean checkInputCorrectness(String input) { // input should be one English alphabet letter
        return (input.length() == 1 && input.charAt(0) >= 'a' && input.charAt(0) <= 'z');
    }

    private boolean lookForLetterInAnswer(String input) {
        return game.getAnswer().contains(input);
    }

}
