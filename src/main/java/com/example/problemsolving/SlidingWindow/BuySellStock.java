package com.example.problemsolving.SlidingWindow;

public class BuySellStock {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4,0,8}));
    }

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int left=0;
        int right=left+1;
        while(right<prices.length){
            if (prices[right]<prices[left]) left=right;
            else {
                maxProfit= Math.max(prices[right]-prices[left], maxProfit);
                right++;
            }
        }
        return maxProfit;
    }
}
