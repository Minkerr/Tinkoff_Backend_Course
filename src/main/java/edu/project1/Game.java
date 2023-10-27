package edu.project1;

import java.util.Arrays;

public class Game {
    private final String answer;
    private char[] playerAnswer;
    private int attempts;
    private final int maxAttempts = 5;

    public Game() {
        attempts = 0;
        answer = Dictionary.getRandomWord();
        playerAnswer = generateStartPlayerAnswer(answer);
    }

    public Game(String answer) {
        attempts = 0;
        this.answer = answer;
        playerAnswer = generateStartPlayerAnswer(answer);
    }

    private char[] generateStartPlayerAnswer(String answer) {
        int lengthOfAnswer = answer.length();
        char[] startPlayerAnswer = new char[lengthOfAnswer];
        Arrays.fill(startPlayerAnswer, '*');
        return startPlayerAnswer;
    }

    public void rewritePlayerAnswer(char letter) {
        char[] newPlayerAnswer = Arrays.copyOf(playerAnswer, playerAnswer.length);
        for (int i = 0; i < playerAnswer.length; i++) {
            if (letter == answer.charAt(i)) {
                newPlayerAnswer[i] = letter;
            }
        }
        this.playerAnswer = newPlayerAnswer;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    public int getAttempts() {
        return attempts;
    }

    public char[] getPlayerAnswer() {
        return playerAnswer;
    }

    public int getMaxAttempts() {
        return maxAttempts;
    }

    public String getAnswer() {
        return answer;
    }

}
