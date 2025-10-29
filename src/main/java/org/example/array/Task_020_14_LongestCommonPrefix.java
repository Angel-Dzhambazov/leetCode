package org.example.array;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class Task_020_14_LongestCommonPrefix {
    public static void main(String[] args) {
        String[] input = {"cir", "car"};

        System.out.println(longestCommonPrefix(input));
    }

    private static String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();

        Arrays.sort(strs, Comparator.comparingInt(String::length));

        for (int i = 0; i < strs[0].length(); i++) {
            char candidate = strs[0].charAt(i);
            for (int j = 0; j < strs.length; j++) {

                char currentChar = strs[j].charAt(i);
                if (candidate != currentChar) {
                    return sb.toString();
                }

                if (j == strs.length - 1 && candidate == strs[j].charAt(i)) {
                    sb.append(candidate);
                }

            }

        }

        return sb.toString();

    }
}
