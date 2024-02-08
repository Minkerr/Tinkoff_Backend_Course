package edu.hw5;

public class Task5 {
    public static boolean isLicensePlateValid(String plate) {
        return plate.matches("[ABEKMHOPCTYX]\\d{3}[ABEKMHOPCTYX]{2}\\d{3}");
    }

    private Task5() {
    }
}
