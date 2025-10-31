package org.example.array;

import java.util.ArrayList;
import java.util.List;

public class Task_024_68_TextJustification {
    public static void main(String[] args) {
        String[] words = new String[]{"What", "must", "be", "acknowledgment", "shall", "be"};
        int maxWidth = 16;

//        fullJustify(words, maxWidth).forEach(System.out::println);
//        System.out.println("============");

        System.out.println(String.join(" ,", fullJustify(words, maxWidth)));
    }

    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            int counter = 0;
            counter += words[i].length();
            int startIndex = i;
            while (counter <= maxWidth) {
                try {
                    counter += words[i + 1].length() + 1;
                    if (counter > maxWidth) {
                        if (startIndex == i) {
                            result.add(String.format("%-" + maxWidth + "s", words[i]));
                        } else {
                            StringBuilder sb = new StringBuilder();
                            for (int j = startIndex; j <= i; j++) {
                                sb.append(words[j]).append(' ');
                            }
                            result.add(textJustification(sb.toString().trim(), maxWidth));
                        }
                    } else {
                        i++;
                    }
                } catch (IndexOutOfBoundsException error) {
                    // we have found all words that can fit into the current result
                    if (startIndex == i) {
                        result.add(String.format("%-" + maxWidth + "s", words[i]));
                    } else {
                        StringBuilder sb = new StringBuilder();
                        for (int j = startIndex; j <= i; j++) {
                            sb.append(words[j]).append(' ');
                        }
                        result.add(textJustification(sb.toString().trim(), maxWidth));
                    }
                    counter += maxWidth;
                }
            }
        }
        String updated = lastLine(result.get(result.size() - 1), maxWidth);
        result.set((result.size() - 1), updated);


        return result;
    }

    public static String textJustification(String s, int maxWidth) {
        String[] tokens = s.trim().split("\\s+");
        if (tokens.length == 1) {
            return String.format("%-" + maxWidth + "s", tokens[0]);
        }

        int totalChars = 0;
        for (String token : tokens) {
            totalChars += token.length();
        }

        int totalSpaces = maxWidth - totalChars;
        int gaps = tokens.length - 1;
        int evenSpace = totalSpaces / gaps;
        int extra = totalSpaces % gaps;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tokens.length; i++) {
            sb.append(tokens[i]);
            if (i < gaps) {
                int spacesToAdd = evenSpace + (i < extra ? 1 : 0);
                sb.append(" ".repeat(spacesToAdd));
            }
        }
        return sb.toString();
    }

    public static String lastLine(String s, int maxWidth) {
        String current = s.trim();
        String[] tokens = s.trim().split("\\s+");
        if (tokens.length == 1) {
            return s;
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < tokens.length - 1; i++) {
                sb.append(tokens[i]).append(' ');
            }
            sb.append(tokens[tokens.length - 1]);

            sb.append(" ".repeat(Math.max(0, maxWidth - sb.length())));
            return sb.toString();
        }
    }
}
