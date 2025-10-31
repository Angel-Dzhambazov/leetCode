package org.example.twoPointers;

public class Task_025_125_ValidPalindrome {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(charO1solution(s));
    }

    public static boolean isPalindrome(String s) {
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (alphabet.indexOf(s.charAt(i)) >= 0) {
                sb.append(s.charAt(i));

            }
        }
        return sb.toString().equalsIgnoreCase(sb.reverse().toString());
    }

    public static boolean charO1solution(String s) {
        int leftIndex = 0, rightIndex = s.length() - 1;
        while (leftIndex < rightIndex) {
            char l = s.charAt(leftIndex);
            char r = s.charAt(rightIndex);
            if (!Character.isLetterOrDigit(l)) {
                leftIndex++;
                continue;
            }
            if (!Character.isLetterOrDigit(r)) {
                rightIndex--;
                continue;
            }
            if (Character.toLowerCase(l) != Character.toLowerCase(r)) {
                return false;
            }
            leftIndex++;
            rightIndex--;
        }
        return true;
    }
}
