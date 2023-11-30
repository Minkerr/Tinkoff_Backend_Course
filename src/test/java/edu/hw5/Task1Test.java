package edu.hw5;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import static edu.hw5.Task1.averageSessionDuration;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {
    @Test
    void averageSessionTime_shouldCalculateAverageSessionTimeForTwoSessions() {
        //arrange
        List<String> sessions = new ArrayList<>();
        sessions.add("2022-03-12, 20:20 - 2022-03-12, 23:50");
        sessions.add("2022-04-01, 21:30 - 2022-04-02, 01:20");
        String exp = "03:40";
        //act
        String act = averageSessionDuration(sessions);
        //assert
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void averageSessionTime_shouldCalculateAverageSessionTimeForThreeSessions() {
        //arrange
        List<String> sessions = new ArrayList<>();
        sessions.add("2022-03-12, 00:00 - 2022-03-13, 00:00");
        sessions.add("2022-04-01, 21:30 - 2022-04-02, 21:30");
        sessions.add("2022-05-01, 20:37 - 2022-05-02, 08:37");
        String exp = "20:00";
        //act
        String act = averageSessionDuration(sessions);
        //assert
        assertThat(act).isEqualTo(exp);
    }
}
