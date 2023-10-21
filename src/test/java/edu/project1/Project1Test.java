package edu.project1;

import org.junit.jupiter.api.Test;
import java.util.Scanner;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Project1Test {
    @Test
    void run_ShouldEndWithDefeatWhenQuantityOFMistakesReachesMax() {
        //arrange
        Scanner a = new Scanner("a\na\na\na\na\n");
        GameManager gameManager = new GameManager("test");
        //act
        GameResult gameResult = gameManager.run(a);
        //assert
        assertThat(gameResult instanceof GameResult.Defeat).isTrue();
    }

    @Test
    void run_ShouldEndWithWinWhenAllLettersAreGuested() {
        //arrange
        Scanner a = new Scanner("e\nt\ns");
        GameManager gameManager = new GameManager("test");
        //act
        GameResult gameResult = gameManager.run(a);
        //assert
        assertThat(gameResult instanceof GameResult.Win).isTrue();
    }

    @Test
    void tryGuess_ShouldIncreaseAttemptQuantityWhenFailedAttemptIsFailed() {
        //arrange
        GameManager gameManager = new GameManager("test");
        int expected = gameManager.getGame().getAttempts() + 1;
        //act
        gameManager.tryGuess("a");
        int act = gameManager.getGame().getAttempts();
        //assert
        assertThat(act).isEqualTo(expected);
    }

    @Test
    void tryGuess_shouldChangePlayerAnswerWhenAttemptIsGood() {
        //arrange
        GameManager gameManager = new GameManager("test");
        char[] expected = "*e**".toCharArray();
        //act
        gameManager.tryGuess("e");
        char[] act = gameManager.getGame().getPlayerAnswer();
        //assert
        assertThat(act).isEqualTo(expected);
    }

    @Test
    void tryGuess_shouldNotChangeGameStateWhenInputIsIncorrect() {
        //arrange
        GameManager gameManager = new GameManager("test");
        char[] expectedPlayerAnswer = gameManager.getGame().getPlayerAnswer();
        int expectedAttempts = gameManager.getGame().getAttempts();
        //act
        gameManager.tryGuess("1");
        char[] actPlayerAnswer = gameManager.getGame().getPlayerAnswer();
        int actAttempts = gameManager.getGame().getAttempts();
        //assert
        assertThat(actAttempts).isEqualTo(expectedAttempts);
        assertThat(actPlayerAnswer).isEqualTo(expectedPlayerAnswer);
    }

}
