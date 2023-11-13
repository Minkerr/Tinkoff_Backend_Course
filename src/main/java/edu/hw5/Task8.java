package edu.hw5;

public class Task8 {
    public static boolean isOddLength(String string) {
        return string.matches("^[01]([01]{2})*$");
    }

    public static boolean isOddLengthIfBeginsWithZeroOrEvenLengthIfBeginWithOne(String string) {
        return string.matches("^0([01]{2})*$|^1[01]([01]{2})*$");
    }

    public static boolean checkZeroQuantityMultipleOfThree(String string) {
        return string.matches("^(1*01*01*01*)*|1*$");
    }

    public static boolean isString11or111(String string) {
        return string.matches("[01]|[10]0|0[10]|[10]{2}0|0[10]{2}|[01]0[01]|[01]{4,}");
    }

    public static boolean isEveryOddCharacterEqualsOne(String string) {
        return string.matches("^(1[01])*1?$");
    }

    public static boolean checkUnitsLessThanOrEqualToOneAndZerosMoreThanOrEqualToTwo(String string) {
        return string.matches("^0+1?0+|100+|00+1$");
    }

    public static boolean areThereNoNeighboringOne(String string) {
        return string.matches("^0*(10+)*1?$");
    }

    private Task8() {

    }
}
