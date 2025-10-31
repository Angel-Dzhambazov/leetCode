package org.example.twoPointers;

import java.util.Arrays;

public class Task_027_167_TwoSum2 {
    public static void main(String[] args) {
        int[] numbers = new int[]{-1, 0};
        int target = -1;
        System.out.println(Arrays.toString(twoSum(numbers, target)));
    }

    private static int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {

                    return new int[]{i + 1, j + 1};
                }
            }
        }
        return new int[]{1, 2, 3, 4, 5};
    }


    private static int[] twoSum2(int[] numbers, int target) {
        int firstIndex = 0;
        int lastIndex = numbers.length - 1;
        while (firstIndex < lastIndex) {
            int sum = numbers[firstIndex] + numbers[lastIndex];
            if (sum == target) {
                return new int[]{firstIndex + 1, lastIndex + 1}; // 1-indexed
            } else if (sum < target) {
                firstIndex++;
            } else {
                lastIndex--;
            }
        }
        return new int[]{1, 2, 3, 4, 5};
    }
}
