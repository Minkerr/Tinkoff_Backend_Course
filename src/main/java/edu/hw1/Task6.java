package edu.hw1;

import java.util.Arrays;

final class Task6 {
    private Task6() {
    }

    public static int countK(int x, int count) {
        final int KAPREKARS_CONSTANT = 6174;
        final int SHIFT = 10;
        final int THREE = 3;
        final int BAD_NUM = 1000;

        if (x == KAPREKARS_CONSTANT) {
            return count;
        }
        int[] a = new int[] {x / (SHIFT * SHIFT * SHIFT), x / (SHIFT * SHIFT) % SHIFT, x / SHIFT % SHIFT, x % SHIFT};
        if (a[0] == a[1] && a[1] == a[2] && a[2] == a[THREE] || x == BAD_NUM) {
            return -1;
        }
        Arrays.sort(a);
        int res =
            (a[THREE] - a[0]) * (SHIFT * SHIFT * SHIFT) + (a[2] - a[1]) * (SHIFT * SHIFT) + (a[1] - a[2]) * SHIFT + a[0]
                - a[THREE];
        return countK(res, count + 1);
    }
}
