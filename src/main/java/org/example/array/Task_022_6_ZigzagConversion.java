package org.example.array;

public class Task_022_6_ZigzagConversion {
    public static void main(String[] args) {
        String s = "ABCD";
        int rows = 2;
        System.out.println(convert(s, rows));
    }

    private static String convert(String s, int numRows) {
        StringBuilder sb = new StringBuilder();

        int columns = s.length();


        // int columns = (x + rows - 1) / rows;
        char[][] output = new char[numRows][columns];
        int r = 0;
        int c = 0;
        boolean down = true;
        for (int i = 0; i < s.length(); i++) {
            if (down) {
                output[r][c] = s.charAt(i);
                r++;   // r = 0 , 1, 2, 3
                int toMoveUp = r % numRows;
                if (toMoveUp == 0) {
                    down = false;
                    c++;
                    r -= 2;
                    if (r < 0) {
                        r = 0;
                    }
                }
            } else {
                output[r][c] = s.charAt(i);
                r--;
                c++;
                if (r <= 0) {
                    down = true;
                    r = 0;
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
