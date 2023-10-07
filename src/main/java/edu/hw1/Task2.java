package edu.hw1;

final class Task2 {
    private Task2() {
    }

    public static int countDigits(long num) {
        int count = 1;
        long n = num;
        final int SHIFT = 10;
        while ((n /= SHIFT) != 0) {
            count++;
        }
        return count;
    }
}
