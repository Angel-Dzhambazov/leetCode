package org.example.twoPointers;

public class Task_026_392_IsSubsequence {
    public static void main(String[] args) {
        String s = "aza";
        String t = "abzba";
        System.out.println(isSubsequence(s, t));
    }

    private static boolean isSubsequence(String s, String t) {

        int currentIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            int indexOfSinT = t.indexOf(s.charAt(i), currentIndex);
            if (indexOfSinT >= currentIndex) {
                currentIndex = indexOfSinT + 1;
            } else {
                return false;
            }
        }
        return true;
    }
}
