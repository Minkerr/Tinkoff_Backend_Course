package edu.hw3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Task2 {
    private Task2() {
    }

    public static List<String> clusterize(String input) {
        char[] c = input.toCharArray();
        Stack<Character> stack = new Stack<>();
        List<String> res = new ArrayList<>();
        int lastIndexOfCluster = 0;

        for (int i = 0; i < c.length; i++) {
            if (c[i] == '(') {
                stack.push(c[i]);
            } else {
                stack.pop();
                if (stack.empty()) {
                    char[] cluster = Arrays.copyOfRange(c, lastIndexOfCluster, i + 1);
                    res.add(new String(cluster));
                    lastIndexOfCluster = i + 1;
                }
            }
        }

        return res;
    }
}
