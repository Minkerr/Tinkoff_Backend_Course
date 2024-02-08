package edu.hw5;

public class Task4 {
    public static boolean isPasswordSafe(String password) {
        return password.matches(".*[~!@#$%^&*|].*");
    }

    private Task4() {

    }
}
