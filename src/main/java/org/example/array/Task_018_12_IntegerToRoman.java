package org.example.array;

public class Task_018_12_IntegerToRoman {

    public static void main(String[] args) {


        int input = 3749;
        System.out.println(intToRoman(input));
    }

    private static String intToRoman(int num) {
        final String[] thousandsArray = {"", "M", "MM", "MMM"};
        final String[] hundredsArray = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        final String[] tensArray = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        final String[] onesArray = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        StringBuilder sb = new StringBuilder();
        sb.append(thousandsArray[num / 1000]);
        sb.append(hundredsArray[(num % 1000) / 100]);
        sb.append(tensArray[(num % 100) / 10]);
        sb.append(onesArray[(num % 10)]);
        return sb.toString();
    }
}
