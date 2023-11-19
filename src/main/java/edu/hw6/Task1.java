package edu.hw6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Task1 {
    static class DiskMap implements Map<String, String> {
        private int size;
        private Path path;

        public DiskMap(Path path) {
            this.path = path;
            this.size = 0;
        }

        public static DiskMap createDiskMap(Path path) throws IOException {
            Files.createFile(path);
            return new DiskMap(path);
        }

        @Override
        public int size() {
            return size;
        }

        @Override
        public boolean isEmpty() {
            return size == 0;
        }

        @Override
        public boolean containsKey(Object key) {
            return keySet().contains(key);
        }

        @Override
        public boolean containsValue(Object value) {
            return values().contains(value);
        }

        @Override
        public String get(Object key) {
            try (BufferedReader br = new BufferedReader(new FileReader(path.toString()))) {
                String line;
                while ((line = br.readLine()) != null) {
                    var KeyAndValue = line.split(":", 2);
                    if (KeyAndValue[0].equals(key)) {
                        return KeyAndValue[1];
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return null;
        }

        @Nullable
        @Override
        public String put(String key, String value) {
            if (isKeyNameCorrect(key)) {
                try {
                    if (get(key) != null) {
                        remove(key);
                    }
                    Files.writeString(path, key + ":" + value + "\n", StandardOpenOption.APPEND);
                    size++;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                return value;
            } else {
                return null;
            }
        }

        @Override
        public String remove(Object key) {
            Map<String, String> map = new HashMap<>();
            String returnValue = get(key);
            if(returnValue == null) {
                return null;
            }
            try (BufferedReader br = new BufferedReader(new FileReader(path.toString()))) {
                String line;
                while ((line = br.readLine()) != null) {
                    var keyAndValue = line.split(":", 2);
                    if (!key.equals(keyAndValue[0])) {
                        map.put(keyAndValue[0], keyAndValue[1]);
                    }
                }
                clear();
                for (var k : map.keySet()) {
                    Files.writeString(path, k + ":" + map.get(k) + "\n", StandardOpenOption.APPEND);
                }
                size--;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return returnValue;
        }

        @Override
        public void putAll(@NotNull Map<? extends String, ? extends String> m) {
            for(var key : m.keySet()) {
                put(key, m.get(key));
            }
        }

        @Override
        public void clear() {
            BufferedWriter writer = null;
            size = 0;
            try {
                writer = Files.newBufferedWriter(path);
                writer.write("");
                writer.flush();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

        @NotNull
        @Override
        public Set<String> keySet() {
            Set<String> result = new HashSet<>();
            try (BufferedReader br = new BufferedReader(new FileReader(path.toString()))) {
                String line;
                while ((line = br.readLine()) != null) {
                    var KeyAndValue = line.split(":", 2);
                    result.add(KeyAndValue[0]);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return result;
        }

        @NotNull
        @Override
        public Collection<String> values() {
            Set<String> result = new HashSet<>();
            try (BufferedReader br = new BufferedReader(new FileReader(path.toString()))) {
                String line;
                while ((line = br.readLine()) != null) {
                    var KeyAndValue = line.split(":", 2);
                    result.add(KeyAndValue[1]);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return result;
        }

        @NotNull
        @Override
        public Set<Entry<String, String>> entrySet() {
            Set<Entry<String, String>> result = new HashSet<>();
            var keys = keySet();
            for (var key : keys) {
                result.add(Map.entry(key, get(key)));
            }
            return result;
        }

        private boolean isKeyNameCorrect(String s) {
            return s.matches("^[a-zA-Z0-9_.()'-]*$");
        }
    }

}
