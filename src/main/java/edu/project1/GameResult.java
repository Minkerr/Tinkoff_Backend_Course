package edu.project1;

sealed interface GameResult {

    String message();

    record Defeat() implements GameResult {
        @Override
        public String message() {
            return "You lost.\n";
        }
    }

    record Win() implements GameResult {
        @Override
        public String message() {
            return "You won!\n";
        }
    }
}
