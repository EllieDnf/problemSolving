package com.example.problemsolving.binarySearch;

public class KokoEatingBananas {
    public static void main(String[] args) {
        System.out.println(minEatingSpeed(new int[]{805306368, 805306368, 805306368}, 1000000000));
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int max = piles[0];

        for (int x : piles) {
            if (x > max) max = x;
        }

        int left = 1;
        int right = max;

        while (left <= right) {
            int k = (left + right) / 2;
            int neededHours = neededHours(piles, k);
            if (neededHours <= h) {
                right = k - 1;
            } else left = k + 1;
        }

        return left;
    }

    public static int neededHours(int[] piles, int k) {
        int hours = 0;
        for (int x : piles) {
            hours = hours + (int) Math.ceil((double) x / (double) k);
        }
        return hours;
    }
}
