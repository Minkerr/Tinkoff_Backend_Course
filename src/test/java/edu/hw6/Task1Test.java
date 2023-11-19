package edu.hw6;

import edu.hw6.Task1.DiskMap;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {
    @Test
    void diskMapPut_shouldPutAndRemoveElements() throws IOException {
        //arrange
        List<String> exp = List.of("key1:value1", "key2:value2", "key3:value3");
        Path path = Path.of("src\\main\\java\\edu\\hw6\\DiskMapStorage\\diskMapTest.txt");
        //act
        DiskMap disk = new DiskMap(path);
        disk.clear();
        disk.put("key1", "value1");
        disk.put("key2", "value2");
        disk.put("key3", "value3");
        var act = Files.readAllLines(path);
        //assert
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void diskMapRemove_shouldPutAndRemoveElements() throws IOException {
        //arrange
        List<String> exp = List.of("key1:value1", "key3:value3");
        Path path = Path.of("src\\main\\java\\edu\\hw6\\DiskMapStorage\\diskMapTest.txt");
        //act
        DiskMap disk = new DiskMap(path);
        disk.clear();
        disk.put("key1", "value1");
        disk.put("key2", "value2");
        disk.put("key3", "value3");
        disk.remove("key2");
        var act = Files.readAllLines(path);
        //assert
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void diskMapSize_shouldCountElements(){
        //arrange
        int exp = 3;
        Path path = Path.of("src\\main\\java\\edu\\hw6\\DiskMapStorage\\diskMapTest.txt");
        //act
        DiskMap disk = new DiskMap(path);
        disk.clear();
        disk.put("key1", "value1");
        disk.put("key2", "value2");
        disk.put("key3", "value3");
        var act = disk.size();
        //assert
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void diskMapGet_shouldSearchValueByKey(){
        //arrange
        String exp = "value2";
        Path path = Path.of("src\\main\\java\\edu\\hw6\\DiskMapStorage\\diskMapTest.txt");
        //act
        DiskMap disk = new DiskMap(path);
        disk.clear();
        disk.put("key1", "value1");
        disk.put("key2", "value2");
        disk.put("key3", "value3");
        var act = disk.get("key2");
        //assert
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void diskMapValues_shouldReturnValuesSet(){
        //arrange
        Set<String> exp = Set.of("value1", "value2", "value3");
        Path path = Path.of("src\\main\\java\\edu\\hw6\\DiskMapStorage\\diskMapTest.txt");
        //act
        DiskMap disk = new DiskMap(path);
        disk.clear();
        disk.put("key1", "value1");
        disk.put("key2", "value2");
        disk.put("key3", "value3");
        var act = disk.values();
        //assert
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void diskMapKeySet_shouldReturnKeySet(){
        //arrange
        Set<String> exp = Set.of("key1", "key2", "key3");
        Path path = Path.of("src\\main\\java\\edu\\hw6\\DiskMapStorage\\diskMapTest.txt");
        //act
        DiskMap disk = new DiskMap(path);
        disk.clear();
        disk.put("key1", "value1");
        disk.put("key2", "value2");
        disk.put("key3", "value3");
        var act = disk.keySet();
        //assert
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void diskMapPutAll_shouldPutMapOfElements(){
        //arrange
        Set<String> exp = Set.of("value1", "value2", "value3");
        Path path = Path.of("src\\main\\java\\edu\\hw6\\DiskMapStorage\\diskMapTest.txt");
        //act
        DiskMap disk = new DiskMap(path);
        disk.clear();
        disk.putAll(Map.of("key1", "value1", "key2", "value2", "key3", "value3"));
        var act = disk.values();
        //assert
        assertThat(act).isEqualTo(exp);
    }

    @Test
    void diskContains_shouldCheckAvailability(){
        //arrange
        Path path = Path.of("src\\main\\java\\edu\\hw6\\DiskMapStorage\\diskMapTest.txt");
        DiskMap disk = new DiskMap(path);
        disk.clear();
        disk.put("key1", "value1");
        disk.put("key2", "value2");
        disk.put("key3", "value3");
        //assert
        assertThat(disk.containsKey("key1")).isTrue();
        assertThat(disk.containsValue("value3")).isTrue();
    }
}
