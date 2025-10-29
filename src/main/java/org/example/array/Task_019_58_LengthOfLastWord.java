package org.example.array;

public class Task_019_58_LengthOfLastWord {
    public static void main(String[] args) {
        String input = "  luffy is still joyboy  ";

        System.out.println(quickCount(input));
    }

    private static int lengthOfLastWord(String s) {
        String[] output = s.trim().split(" ");
        return output[output.length - 1].length();
    }

    private static int quickCount(String s) {
        int lastIndex = s.length() - 1;
        int result = 0;
        while (lastIndex >= 0 && s.charAt(lastIndex) == ' ') {
            lastIndex--;
        }

        while (lastIndex >= 0 && s.charAt(lastIndex) != ' ') {
            result++;
            lastIndex--;
        }

        return result;
    }
}
