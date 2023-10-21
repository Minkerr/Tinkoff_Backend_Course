package edu.project1;

sealed interface GuessResult {
    default String currentAnswer(char[] playerAnswer) {
        return "The word: " + String.valueOf(playerAnswer) + "\n";
    }

    String message();

    record SuccessfulGuess(Game game) implements GuessResult {
        @Override
        public String message() {
            return "Hit!\n" + currentAnswer(game.getPlayerAnswer());
        }
    }

    record FailedGuess(Game game) implements GuessResult {
        @Override
        public String message() {
            int attempts = game.getAttempts();
            int maxAttempts = game().getMaxAttempts();
            String messageText = String.format("Missed, mistake %s out of %s.\n", attempts, maxAttempts);
            return messageText + currentAnswer(game.getPlayerAnswer());
        }
    }

    record IncorrectGuess(Game game) implements GuessResult {
        @Override
        public String message() {
            return "Incorrect input. Please try again.\n" + currentAnswer(game.getPlayerAnswer());
        }
    }
}
