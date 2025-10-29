package org.example.array;

import java.util.Arrays;

public class Task001_MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        mergeBasic(nums1, m, nums2, n);

        mergeHelpArray(nums1, m, nums2, n);
        //quickest in place merge
        mergeInPlace(nums1, m, nums2, n);


    }

    public static void mergeInPlace(int[] nums1, int m, int[] nums2, int n) {


    }


    public static void mergeHelpArray(int[] nums1, int m, int[] nums2, int n) {
        int[] mergedArray = new int[m + n];


        // go 1 by 1 through both arrays and add into the mergedArray
        int nums1Index = 0;
        int nums2Index = 0;
        int mergedArrayIndex = 0;

        // we check if integer in the current index in first array is smaller than the current index of the second array
        while (nums1Index < m && nums2Index < n) {
            //if it is smaller than we copy it to the merged array, move the first array index +1 and move the merged aray index +1
            if (nums1[nums1Index] < nums2[nums2Index]) {
                mergedArray[mergedArrayIndex++] = nums1[nums1Index++];
            } else {
                mergedArray[mergedArrayIndex++] = nums2[nums2Index++];
            }
            // at some point nums1Index will be equal to the length of the array and the same for num2Index...
        }

        while (nums1Index < m) mergedArray[mergedArrayIndex++] = nums1[nums1Index++];
        while (nums2Index < n) mergedArray[mergedArrayIndex++] = nums2[nums2Index++];

        nums1 = mergedArray;
        printArray(nums1);

    }

    public static void mergeBasic(int[] nums1, int m, int[] nums2, int n) {

        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
        printArray(nums1);
    }

    public static void printArray(int[] array) {
        for (int number : array
        ) {
            System.out.print(number + " ");
        }
    }
}
