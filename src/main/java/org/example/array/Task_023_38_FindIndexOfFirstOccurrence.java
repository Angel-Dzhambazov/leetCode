package org.example.array;

public class Task_023_38_FindIndexOfFirstOccurrence {
    public static void main(String[] args) {
        String haystack = "leetcode";
        String needle = "leeto";
        System.out.println(strStr(haystack, needle));

    }

    private static int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}
