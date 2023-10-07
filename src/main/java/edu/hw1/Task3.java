package edu.hw1;

final class Task3 {
    private Task3() {
    }

    public static boolean isNestable(int[] a, int[] b) {
        int mx1 = a[0];
        int mn1 = a[0];
        int mx2 = b[0];
        int mn2 = b[0];
        for (int i = 1; i < a.length; i++) {
            mx1 = Math.max(mx1, a[i]);
            mn1 = Math.min(mn1, a[i]);
        }
        for (int i = 1; i < b.length; i++) {
            mx2 = Math.max(mx2, b[i]);
            mn2 = Math.min(mn2, b[i]);
        }
        return (mx1 < mx2 && mn1 > mn2);
    }
}
