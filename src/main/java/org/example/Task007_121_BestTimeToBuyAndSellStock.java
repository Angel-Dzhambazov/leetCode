package org.example;

public class Task007_121_BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[] prices = {1, 2};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int candidate = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = prices.length - 1; j > i; j--) {
                if ((prices[j] - prices[i]) > candidate) {
                    candidate = prices[j] - prices[i];
                }
            }
        }

        return candidate;
    }


    public static int quicker(int[] prices) {
        int minimumPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i : prices) {
            if (i < minimumPrice) {
                minimumPrice = i;
            } else if (i - minimumPrice > maxProfit) {
                maxProfit = i - minimumPrice;
            }
        }
        return maxProfit;
    }
}
