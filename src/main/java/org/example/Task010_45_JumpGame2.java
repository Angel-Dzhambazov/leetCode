package org.example;

public class Task010_45_JumpGame2 {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(jump(nums));
    }

    public static int jump(int[] nums) {
        int n = nums.length;
        if (n < 2) return 0;

        int jumps = 0;
        int farthest = 0;
        int currentEnd = 0;

        // iterate up to n - 2 inclusive (i < n - 1)
        for (int i = 0; i < n - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);

            // when we reach the end of the current range, we need one more jump
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;
                // optional early exit: if currentEnd already reaches the last index
                if (currentEnd >= n - 1) break;
            }
        }

        return jumps;
    }
}
