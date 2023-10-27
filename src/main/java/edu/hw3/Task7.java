package edu.hw3;

import java.util.Comparator;

public class Task7 {
    private static final Comparator comparator = Comparator.nullsFirst(Comparator.naturalOrder());

    public static Comparator getComparator() {
        return comparator;
    }

}
