package edu.hw8.Task3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReference;

public class Task3 {
    private Task3() {
    }

    private static final int MAX_PASSWORD_LENGTH = 4;
    private static final int THREAD_NUMBER = 8;
    private static final String START_PASSWORD = "999";

    @SuppressWarnings("MagicNumber")
    private static String stringToMD5(String s) {
        try {
            try {
                java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
                byte[] array = md.digest(s.getBytes());
                StringBuffer sb = new StringBuffer();
                for (int i = 0; i < array.length; ++i) {
                    sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
                }
                return sb.toString();
            } catch (java.security.NoSuchAlgorithmException e) {
            }
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("MagicNumber")
    public static String nextPassword(String s) {
        char[] password = s.toCharArray();
        boolean flag = true;
        for (int j = password.length - 1; j >= 0; j--) {
            if (password[j] != '9') {
                flag = false;
                if (password[j] == 'z') {
                    password[j] = '0';
                } else {
                    password[j] = (char) (password[j] + 1);
                }
                break;
            } else {
                password[j] = 'a';
            }
        }
        if (flag) {
            char[] res = new char[password.length + 1];
            Arrays.fill(res, 'a');
            return String.valueOf(res);
        } else {
            return String.valueOf(password);
        }
    }

    public static Map<String, String> passwordEncoding(Map<String, String> passwordMap) {
        Map<String, String> result = new HashMap<>();
        String element = START_PASSWORD;

        while (element.length() <= MAX_PASSWORD_LENGTH) {
            element = nextPassword(element);
            String codedString = stringToMD5(element);
            if (passwordMap.containsKey(codedString)) {
                result.put(passwordMap.get(codedString), element);
            }
        }

        return result;
    }

    public static Map<String, String> passwordEncodingMultithread(Map<String, String> passwordMap) {
        Map<String, String> result = new HashMap<>();

        AtomicReference<String> element = new AtomicReference<>(START_PASSWORD);
        ExecutorService service = Executors.newFixedThreadPool(THREAD_NUMBER);

        while (element.get().length() <= MAX_PASSWORD_LENGTH) {
            service.execute(() -> {
                String newElement;
                element.set(nextPassword(element.get()));
                newElement = element.get();

                String codedString = stringToMD5(newElement);
                if (passwordMap.containsKey(codedString)) {
                    result.put(passwordMap.get(codedString), newElement);
                    passwordMap.remove(codedString);
                }
            });
        }
        service.shutdown();
        return result;
    }
}
