package org.example;

import java.util.Arrays;

public class Task_013_238_ProductOfArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(productExceptSelfOn(nums)));
    }

    private static int[] productExceptSelf(int[] nums) {
        int[] candidate = new int[nums.length];
        int currentDigit = 1;
        for (int i = 0; i < candidate.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    currentDigit *= nums[j];
                }
            }
            candidate[i] = currentDigit;
            currentDigit = 1;
        }
        return candidate;
    }

    private static int[] productExceptSelfOn(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        // Step 1: prefix products
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        // Step 2: suffix products
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] = result[i] * right;
            right *= nums[i];
        }

        return result;
    }
}
