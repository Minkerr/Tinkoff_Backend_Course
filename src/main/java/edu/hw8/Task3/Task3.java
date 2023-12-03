package edu.hw8.Task3;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Task3 {
    private Task3() {
    }

    private static final int MAX_PASSWORD_LENGTH = 5;
    private static final int QUEUE_CAPACITY = 1000000;
    private static final char[] ALPHABET = "abcdefghijklmnopqrstuvwxyz0123456789".toCharArray();

    @SuppressWarnings("MagicNumber")
    public static String stringToMD5(String s) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(s.getBytes());
            StringBuffer hexString = new StringBuffer();

            for (int i = 0; i < messageDigest.length; i++) {
                String hex = Integer.toHexString(0xff & messageDigest[i]);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("MagicNumber")
    public static String nextPassword(String s) {
        char[] password = s.toCharArray();
        boolean flag = true;
        for (int j = password.length - 1; j >= 0; j--) {
            if (password[j] != '9') {
                for (int i = 0; i < ALPHABET.length; i++) {
                    if (password[j] == ALPHABET[i]) {
                        password[j] = ALPHABET[i + 1];
                        flag = false;
                        break;
                    }
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
//        BlockingDeque<String> queue = new LinkedBlockingDeque<>(100);
//        queue.add("");
        String element = "99";

        while (element.length() < MAX_PASSWORD_LENGTH) {
            element = nextPassword(element);
            int n = element.length();
            if (element.charAt(n - 1) == 'a' && element.charAt(n - 1 - 1) == 'a'
                && element.charAt(n - 1 - 1 - 1) == 'a') {
                //System.out.println(element);
            }
            //System.out.println(element);
            String codedString = stringToMD5(element);
            if (passwordMap.containsKey(codedString)) {
                result.put(passwordMap.get(codedString), element);
                //System.out.println(element);
            }
        }

        return result;
    }
}
