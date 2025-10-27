package org.example;

import java.util.HashMap;
import java.util.Map;

public class Task005_169_MajorityElement {
    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 1, 2};
        tryIt(nums);
    }

    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();

        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
            if (counts.get(num) > nums.length / 2) {
                return num;
            }
        }

        return -1;
    }

    public static int boyer_moor_voting_algorithm(int[] nums) {
        int candidate = 0;
        int count = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        System.out.println(candidate);
        return candidate;
    }

    public static int tryIt(int[] nums) {
        int candidate = 0;
        int count = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += candidate == num ? 1 : -1;

            if (count > nums.length / 2) {

                return candidate;
            }
        }


        return candidate;
    }
}
