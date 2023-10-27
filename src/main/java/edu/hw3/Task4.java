package edu.hw3;

public class Task4 {
    private Task4() {
    }

    private final static int DECIMAL_NUMBER_SYSTEM_BASE = 10;

    @SuppressWarnings("MagicNumber")
    private static String constructDigits(int digit, String digitOfOne, String digitOfFive, String digitOfTen) {
        String result = "";
        if (1 <= digit && digit <= 3) {
            for (int i = 0; i < digit; i++) {
                result += digitOfOne;
            }
        }
        if (digit == 4) {
            result = digitOfOne + digitOfFive;
        }
        if (digit == 9) {
            result = digitOfOne + digitOfTen;
        }
        if (5 <= digit && digit <= 8) {
            result += digitOfFive;
            for (int i = 0; i < digit - 5; i++) {
                result += digitOfOne;
            }
        }
        return result;
    }

    public static String convertToRoman(int n) { // I, V, X, L, C, D, M
        int units = n % DECIMAL_NUMBER_SYSTEM_BASE;
        int tens = n / DECIMAL_NUMBER_SYSTEM_BASE % DECIMAL_NUMBER_SYSTEM_BASE;
        int hundreds = n / (DECIMAL_NUMBER_SYSTEM_BASE * DECIMAL_NUMBER_SYSTEM_BASE) % DECIMAL_NUMBER_SYSTEM_BASE;
        int thousands = n / (DECIMAL_NUMBER_SYSTEM_BASE * DECIMAL_NUMBER_SYSTEM_BASE * DECIMAL_NUMBER_SYSTEM_BASE);

        return constructDigits(thousands, "M", "", "")
            + constructDigits(hundreds, "C", "D", "M")
            + constructDigits(tens, "X", "L", "C")
            + constructDigits(units, "I", "V", "X");
    }
}
