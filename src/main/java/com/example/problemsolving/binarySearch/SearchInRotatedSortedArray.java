package com.example.problemsolving.binarySearch;

public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        System.out.println(search(new int[]{3, 1}, 3));
    }

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (right + left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }

    public static int search2(int[] nums, int target) {
        int targetIdx;
        int idxMin = findMinIdx(nums);
        if (target >= nums[0] && idxMin != 0) targetIdx = findTargetIdx(nums, 0, idxMin - 1, target);
        else targetIdx = findTargetIdx(nums, idxMin, nums.length - 1, target);
        return targetIdx;
    }

    public static int findTargetIdx(int[] nums, int startIdx, int endIdx, int target) {
        int left = startIdx;
        int right = endIdx;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == nums[mid]) return mid;
            if (target > nums[mid]) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    public static int findMinIdx(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right - 1) {
            int mid = (right + left) / 2;
            if (nums[right] > nums[mid]) right = mid;
            else left = mid;
        }

        if (nums[left] <= nums[right]) return left;
        else return right;
    }
}
