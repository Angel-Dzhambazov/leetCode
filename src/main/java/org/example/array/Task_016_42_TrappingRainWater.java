package org.example.array;

import java.util.Random;

public class Task_016_42_TrappingRainWater {
    public static void main(String[] args) {
//        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

        int n = 100000;  // size of your large test case
        int[] height = new int[n];
        Random rand = new Random();

// fill with random values, e.g., 0–1000
        for (int i = 0; i < n; i++) {
            height[i] = rand.nextInt(1001);
        }
//        System.out.println(trap(height));
        System.out.println(calculateWaterOn(height));
    }

    private static int trap(int[] height) {
        int n = height.length;
        int totalWater = 0;

        for (int i = 0; i < n; i++) {
            int leftMax = 0;
            int rightMax = 0;

            // find the tallest bar to the left of i
            for (int j = 0; j <= i; j++) {
                leftMax = Math.max(leftMax, height[j]);
            }

            // find the tallest bar to the right of i
            for (int j = i; j < n; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }

            // water trapped at i
            totalWater += Math.min(leftMax, rightMax) - height[i];
        }

        return totalWater;
    }

    private static int calculateWaterOn(int[] height){
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int water = 0;

        while (left <= right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    water += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    water += rightMax - height[right];
                }
                right--;
            }
        }

        return water;
    }
}
