package edu.hw3;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task3 {
    private Task3() {
    }

    public static <T> Map<T, Integer> freqDict(List<T> list) {
        Map<T, Integer> res = new HashMap<>();
        for (T o : list) {
            res.put(o, Collections.frequency(list, o));
        }
        return res;
    }
}
