package org.example.array;

public class Task_021_151_ReverseWordsInString {
    public static void main(String[] args) {
        String input = "a good   example";
        System.out.println(reverseWords(input));
    }

    private static String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] array = s.split(" ");
        for (int i = array.length - 1; i >= 0; i--) {
            if (!array[i].trim().equals("")) {
                sb.append(array[i]).append(' ');
            }
        }
        return sb.toString().trim();
    }

    private static String alternative(String s) {
        StringBuilder sb = new StringBuilder();
        int startIndex = -1;
        int endIndex = -1;

        int i = s.length() - 1;

        while (i >= 0) {
//            char currentChar = s.charAt(i);
//            if (i == 0) {
//                String deug = "";
//            }

            // assign end index
            if (endIndex == -1) {
                if (s.charAt(i) == ' ') {
                    i--;
                } else if (s.charAt(i) != ' ') {
                    endIndex = i;
                    i--;
                }
            } else                // assign start index
                if (i > 0) {
                    if (s.charAt(i - 1) == ' ') {
                        startIndex = i;
                        i--;
                    } else if (s.charAt(i) != ' ') {
                        i--;
                    }
                } else {
                    startIndex = 0;
                    i--;
                }

            // append word to sb
            if (startIndex != -1) {
                sb.append(s, startIndex, endIndex + 1).append(' ');
                startIndex = -1;
                endIndex = -1;
            }
            if (endIndex == 0) {
                sb.append(s.charAt(0));
            }
        }


        return sb.toString().trim();
    }
}
