package edu.hw5;

public class Task6 {
    public static boolean isASubstring(String s, String t) {
        StringBuilder substringRegex = new StringBuilder(".*");
        for (int i = 0; i < t.length(); i++) {
            substringRegex.append(s.charAt(i));
            substringRegex.append(".*");
        }
        return s.matches(String.valueOf(substringRegex));
    }

    private Task6() {
    }
}
