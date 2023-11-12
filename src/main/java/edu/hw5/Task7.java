package edu.hw5;

public class Task7 {
    public static boolean isBitStringHasThirdSymbolZero(String string) {
        return string.matches("[01]{2}0[01]*");
    }

    public static boolean isBitStringHasEqualFirstAndLastSymbol(String string) {
        return string.matches("(^1[01]*1$)|(^0[01]*0$)|[01]");
    }

    public static boolean isBitStringLengthGreaterThanOneAndLessThanThree(String string) {
        return string.matches("[01]{1,3}");
    }

    private Task7() {
    }
}
