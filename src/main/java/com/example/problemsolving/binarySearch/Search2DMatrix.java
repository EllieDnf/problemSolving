package com.example.problemsolving.binarySearch;

public class Search2DMatrix {
    public static void main(String[] args) {
        System.out.println(searchMatrix(new int[][]{{1,3,5,7}, {10,11,16,20},{23,30,34,60}}, 60));
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        int l=0;
        int h= matrix.length-1;
        int row=-1;
        if (target<matrix[0][0] || target >matrix[h][matrix[h].length-1]) return false;

        while(l<=h){
            int mid = (l+h)/2;
            if (target>=matrix[mid][0] && target<=matrix[mid][matrix[mid].length-1]) {
                row = mid;
                break;
            }
            else if (target<matrix[mid][0]) h=mid-1;
            else l=mid+1;
        }

        if (row==-1) return false;

        int left=0;
        int right =matrix[row].length-1;

        while(left<=right){
            int mid=(left+right)/2;
            if(matrix[row][mid]==target) return true;
            else if(matrix[row][mid]>target) right=mid-1;
            else left=mid+1;
        }
        return false;
    }
}
