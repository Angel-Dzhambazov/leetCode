package org.example.array;

public class Task006_189_RotateArray {
    public static void main(String[] args) {
//        int[] nums = {1, 2, 3, 4, 5, 6, 7};
//        int[] nums = {-1, -100, 3, 99};
        int[] nums = {-1};
        int k = 2;
//        rotate(nums, k);
        helpArray(nums, k);
    }


    private static void helpArray(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) return;

        k = k % nums.length;
        if (k == 0) return;
        int[] helpArray = new int[n];


        for (int i = 0; i < k; i++) {
            helpArray[i] = nums[n - k + i];
        }
        for (int i = k; i < n; i++) {
            helpArray[i] = nums[i - k];
        }

        System.arraycopy(helpArray, 0, nums, 0, n);


    }

    private static void rotate(int[] nums, int k) {

        // 2 cycles
        //

        int a = 0;

        for (int i = 0; i < k; i++) {
            a = nums[nums.length - 1];
            for (int j = nums.length - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = a;
        }


        for (int i : nums) {
            System.out.print(i + " ");
        }

        System.out.println();
    }

}

