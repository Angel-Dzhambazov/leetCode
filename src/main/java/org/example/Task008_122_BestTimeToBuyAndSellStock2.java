package org.example;

public class Task008_122_BestTimeToBuyAndSellStock2 {
    public static void main(String[] args) {
        int[] prices = {1,2,3,4,5};
        System.out.println(maxProfit(prices));
    }

    private static int maxProfit(int[] prices) {
        int candidate = 0;
        int minPrice = Integer.MAX_VALUE;

        for (int currentPrice : prices) {
            if (currentPrice < minPrice) {
                minPrice = currentPrice;
            }
            if (currentPrice - minPrice > 0) {
                candidate += currentPrice - minPrice;
                minPrice = currentPrice;
            }
        }
        return candidate;
    }
}
