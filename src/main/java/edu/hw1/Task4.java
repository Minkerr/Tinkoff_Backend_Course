package edu.hw1;

final class Task4 {
    private Task4() {
    }

    public static String fixString(String s) {
        char[] c = s.toCharArray();
        String res = "";
        int n = s.length() - (s.length() % 2);
        for (int i = 0; i < n; i += 2) {
            res += c[i + 1];
            res += c[i];
        }
        if (s.length() % 2 == 1) {
            res += c[n];
        }
        return res;
    }
}
