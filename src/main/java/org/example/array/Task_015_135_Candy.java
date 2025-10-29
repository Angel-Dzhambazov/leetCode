package org.example.array;

import java.util.Arrays;

public class Task_015_135_Candy {
    public static void main(String[] args) {
        int[] nums = {1, 0, 2};
        System.out.println(candy(nums));
    }

    private static int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1); // everyone gets 1 candy initially

        boolean changed = true;

        // keep adjusting until no changes
        while (changed) {
            changed = false;

            for (int i = 0; i < n; i++) {
                // check left neighbor
                if (i > 0 && ratings[i] > ratings[i - 1] && candies[i] <= candies[i - 1]) {
                    candies[i] = candies[i - 1] + 1;
                    changed = true;
                }

                // check right neighbor
                if (i < n - 1 && ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1]) {
                    candies[i] = candies[i + 1] + 1;
                    changed = true;
                }
            }
        }

        // calculate total
        int total = 0;
        for (int c : candies) total += c;
        return total;
    }
}
