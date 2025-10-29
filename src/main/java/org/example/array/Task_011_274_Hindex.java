package org.example.array;

import java.util.Arrays;

public class Task_011_274_Hindex {
    public static void main(String[] args) {
        int[] citations = {3,0,6,1,5};
        System.out.println(hIndex(citations));
    }
    public static int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;

        for (int i = 0; i < n; i++) {
            int h = n - i; // number of papers with citations >= citations[i]
            if (citations[i] >= h) {
                return h;
            }
        }

        return 0;
    }
}
