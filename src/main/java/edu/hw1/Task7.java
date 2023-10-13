package edu.hw1;

final class Task7 {
    private Task7() {
    }

    public static int rotateLeft(int n, int shift) {
        char[] s = Integer.toBinaryString(n).toCharArray();
        String b = "";
        for (int i = 0; i < s.length; i++) {
            b += s[(i + shift) % s.length];
        }
        return Integer.parseInt(b, 2);
    }

    public static int rotateRight(int n, int shift) {
        return rotateLeft(n, Integer.toBinaryString(n).toCharArray().length - shift);
    }
}
