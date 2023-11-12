package edu.hw5;

public class Task6 {
    public static boolean isASubstring(String S, String T) {
        StringBuilder substringRegex = new StringBuilder(".*");
        for(int i = 0; i < T.length(); i++){
            substringRegex.append(S.charAt(i));
            substringRegex.append(".*");
        }
        return S.matches(String.valueOf(substringRegex));
    }
}
