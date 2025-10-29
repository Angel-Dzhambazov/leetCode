package org.example.array;

import java.util.HashSet;

public class Task003_26_RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2};

        removeDuplicates(nums);

        quickRemoveDuplicates(nums);

    }

    public static int quickRemoveDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int k = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[k - 1]) {
                nums[k++] = nums[i];
            }

        }
        return k;
    }

    public static int removeDuplicates(int[] nums) {

        int k = 0;

        HashSet<Integer> uniques = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (!uniques.contains(nums[i])) {
                nums[k] = nums[i];
                uniques.add(nums[k++]);
            }

        }
        System.out.println(k);
        for (int i : nums
        ) {
            System.out.print(i + " ");

        }

        return k;
    }
}
