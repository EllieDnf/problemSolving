package com.example.problemsolving;

public class MaxProfit {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4} ));
    }
    public static int maxProfit(int[] prices) {
        int profit=0;
        for (int i=0;i<prices.length-1;i++){
            for (int j=i+1;j<prices.length;j++){
                if (prices[j]>prices[i]) {
                    profit+=prices[j]-prices[i];
                    break;
                }
                i=j;
            }
        }
        return profit;
    }
}
