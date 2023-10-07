package edu.hw1;

final class Task1 {
    private Task1() {
    }

    public static int minutesToSeconds(String s) {
        char[] c = s.toCharArray();
        int n = s.length();
        final int SECONDS_IN_MINUTE = 60;
        final int SHIFT = 10;

        int seconds = ((int) (c[n - 2] - '0')) * SHIFT + ((int) (c[n - 1] - '0'));
        if (seconds >= SECONDS_IN_MINUTE) {
            return -1;
        }
        int minutes = 0;
        for (int i = 0; c[i] != ':'; i++) {
            minutes *= SHIFT;
            minutes += ((int) (c[i] - '0'));
        }
        return minutes * SECONDS_IN_MINUTE + seconds;
    }
}
