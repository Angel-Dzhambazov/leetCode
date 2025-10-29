package org.example.array;

public class Task004_80_RemoveDuplicatesFromSortedArray2 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        removeDuplicates(nums);
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int k = 2;

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[k - 2] || nums[i] != nums[k - 1]) {
                nums[k++] = nums[i];
            }

        }
        return k;
    }
}
