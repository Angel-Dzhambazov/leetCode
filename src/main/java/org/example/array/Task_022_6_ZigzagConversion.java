package org.example.array;

public class Task_022_6_ZigzagConversion {
    public static void main(String[] args) {
        String s = "ABCDEFGHIJKLMNOPqRstuvwxyz";
        int rows = 5;
        System.out.println(convert(s, rows));
    }

    private static String convert(String s, int numRows) {
        if (numRows == 1) return s;
        StringBuilder sb = new StringBuilder();
        int columns = s.length();

        char[][] output = new char[numRows][columns];
        int r = 0;
        int c = 0;
        boolean down = true;

        for (int i = 0; i < s.length(); i++) {
            output[r][c] = s.charAt(i);

            if (down) {
                r++;
                if (r == numRows) {
                    down = false;
                    r = numRows - 2;
                    c++;
                }
            } else {
                r--;
                c++;
                if (r < 0) {
                    down = true;
                    r = 1;
                }
            }
        }
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < columns; j++) {
                if (output[i][j] != 0) {
                    sb.append(output[i][j]);
                }
            }
        }
        return sb.toString();
    }

    private static String convert2(String s, int rows) {
        StringBuilder sb = new StringBuilder();

        return sb.toString().trim();

    }
}
