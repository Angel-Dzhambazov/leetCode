package org.example.array;

public class Task009_55_JumpGame {
    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(solution(nums));
    }

    private static boolean solution(int[] nums) {
        int currentIndex = 0;
        int currentJump = 0;
        if (nums.length < 2) {
            return true;
        }
        while (true) {
            try {
                currentJump = nums[currentIndex];


                if (currentIndex + currentJump == nums.length - 1) {
                    return true;
                }
                if (currentJump == 0) {
                    return false;
                }
                currentIndex += currentJump;
            } catch (ArrayIndexOutOfBoundsException error) {
                return false;
            }
        }
    }


    //by ChatGPT
    private static boolean canJump(int[] nums) {
        int maxReach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) return false; // we can't even reach this point (whatever that means chatGPT)
            maxReach = Math.max(maxReach, i + nums[i]);
            if (maxReach >= nums.length - 1) return true; // can reach or go beyond last index
        }
        return true;
    }
}
