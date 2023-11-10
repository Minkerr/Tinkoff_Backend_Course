package edu.hw3;

public class Task1 {
    private Task1() {
    }

    public static String atbash(String s) {
        char[] c = s.toCharArray();
        int len = c.length;
        for (int i = 0; i < len; i++) {

            if ('a' <= c[i] && c[i] <= 'z') {
                c[i] = (char) ('z' - (c[i] - 'a'));
            } else if ('A' <= c[i] && c[i] <= 'Z') {
                c[i] = (char) ('Z' - (c[i] - 'A'));
            }
        }

        return new String(c);
    }
}
