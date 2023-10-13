package edu.hw1;

final class Task5 {
    private Task5() {
    }

    private static boolean isPalindrome(int x) {
        char[] c = Integer.toString(x).toCharArray();
        int n = c.length;
        for (int i = 0; i < n / 2; i++) {
            if (c[i] != c[n - i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindromeDescendant(long x) {

        char[] c = Long.toString(x).toCharArray();
        int l = c.length;
        final int MAX_DIGIT = 9;
        final int SHIFT = 10;

        while (l > 1) {
            if (l % 2 == 1) {
                return false;
            }
            int desc = 0;
            for (int i = 0; i < l; i += 2) {
                int a = (int) (c[i] - '0' + c[i + 1] - '0');
                if (a > MAX_DIGIT) {
                    desc *= (SHIFT * SHIFT);
                } else {
                    desc *= SHIFT;
                }
                desc += a;
            }
            if (isPalindrome(desc)) {
                return true;
            }
            c = Long.toString(desc).toCharArray();
            l = c.length;
        }

        return false;
    }
}
