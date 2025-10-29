package org.example.array;

import javax.imageio.metadata.IIOMetadataFormatImpl;
import java.util.Map;

public class Task_017_13_RomanToInteger {

    /*
    Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000

There are six instances where subtraction is used:
exceptions: IV=4 IX=9 XL=40 XC=90 CD=400 CM=900
I can be placed before V (5) and X (10) to make 4 and 9.
X can be placed before L (50) and C (100) to make 40 and 90.
C can be placed before D (500) and M (1000) to make 400 and 900.
     */
    public static void main(String[] args) {
//        String s = "III";
        String s = "MCMXCIV";
        System.out.println(romanToInt(s));
    }

    private static int romanToInt(String s) {
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (s.charAt(i)) {
                case 'I' -> {
                    try {
                        char nextChar1 = s.charAt(i + 1);
                        char nextChar2 = s.charAt(i + 2);
                        if (nextChar1 == nextChar2 && nextChar2 == 'I') {
                            result += 3;
                            i += 2;
                            break;
                        }
                    } catch (IndexOutOfBoundsException ignored) {

                    }
                    try {
                        char nextChar1 = s.charAt(i + 1);
                        switch (nextChar1) {
                            case 'I' -> {
                                result += 2;
                                i++;
                            }
                            case 'V' -> {
                                result += 4;
                                i++;
                            }
                            case 'X' -> {
                                result += 9;
                                i++;
                            }
                        }
                    } catch (IndexOutOfBoundsException e) {
                        result += 1;
                    }
                }
                case 'V' -> result += 5;
                case 'X' -> {
                    try {
                        char nextChar = s.charAt(i + 1);
                        if (nextChar == 'L') {
                            result += 40;
                            i++;
                        } else if (nextChar == 'C') {
                            result += 90;
                            i++;
                        } else {
                            result += 10;
                        }

                    } catch (IndexOutOfBoundsException e) {
                        result += 10;
                    }
                }
                case 'L' -> result += 50;
                case 'C' -> {
                    try {
                        char nextChar = s.charAt(i + 1);
                        if (nextChar == 'D' ) {
                            result += 400;
                            i++;
                        } else if (nextChar == 'M' ) {
                            result += 900;
                            i++;
                        } else {
                            result += 100;
                        }

                    } catch (IndexOutOfBoundsException e) {
                        result += 100;
                    }
                }
                case 'D' -> result += 500;
                case 'M' -> result += 1000;
            }
        }
        return result;
    }

    private static int solutionWithMap(String romanNumber){
        Map<Character, Integer> values = Map.of(
                'I', 1,
                'V', 5,
                'X', 10,
                'L', 50,
                'C', 100,
                'D', 500,
                'M', 1000
        );

        int result = 0;
        for (int i = 0; i < romanNumber.length(); i++) {
            int incrementValue = values.get(romanNumber.charAt(i));
            if (i + 1 < romanNumber.length() && incrementValue < values.get(romanNumber.charAt(i + 1))) {
                result -= incrementValue;
            } else {
                result += incrementValue;
            }
        }
        return result;
    }
}
