package edu.hw3;

import org.junit.jupiter.api.Test;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task7Test {
    @Test
    void treeMap_shouldWorkWithNullKeys() {
        //arrange
        Map<String, String> map = new TreeMap<>(Task7.getComparator());
        //act
        map.put("test", "someValue");
        map.put(null, "someValue");
        map.put("java", "someValue");
        //assert
        assertThat(map.containsKey(null)).isTrue();
    }
}
