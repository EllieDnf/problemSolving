package com.example.problemsolving.arrays;

import java.util.*;

public class test {
    List<String> list;

    public static void main(String[] args) {
        test t = new test();
        // system.out.println(t.searchRotaedArray(new int[]{5,6,1,2,3,4},6));
        System.out.println(lengthOfLongestSubstring("pwwkew"));

    }
    public static int lengthOfLongestSubstring(String s) {

        Set<Character> set = new HashSet<>();
        int left = 0;
        int right = 0;
        int max = 0;

        while (right < s.length()) {
            char ch = s.charAt(right);
            if (!set.contains(ch)) {
                set.add(ch);
                max = Math.max(max, right - left + 1);
                right++;
            } else {
                set.remove(s.charAt(left));
                left++;
            }
        }
        return max;
//        Queue<Character> chars = new LinkedList<>();
//        int idx = 0;
//        int max = 0;
//        while (idx < s.length()) {
//            char ch = s.charAt(idx);
//            if (!chars.contains(ch)) {
//                chars.add(ch);
//                max = Math.max(max, chars.size());
//                idx++;
//            } else {
//                while (chars.remove() != ch) {
//                }
//            }
//            System.out.println(chars);
//        }
//        return max;
    }

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int left=0;
        int right=left+1;
        while(right<prices.length){
            if (prices[right]<prices[left]) left=right;
            else {
                maxProfit= Math.max(prices[right]-prices[left], maxProfit);
            }
            right++;

        }
        return maxProfit;
    }
    public int searchRotaedArray(int[] nums, int target) {


        int left = 0;
        int right = nums.length - 1;

        while (left < right ) {
            int mid = (right + left) / 2;
            if (nums[mid] > nums[right]) left = mid+1;
            else right = mid;
        }

        if(target<=nums[nums.length-1]){
            return search(nums,left,nums.length-1,target);
        }
        else {
            return search(nums,0,left-1,target);
        }
    }
    public int search(int[] nums, int l,int r, int target) {
        int left =l;
        int right = r;

        while (left<=right){
            int mid=(left+right)/2;
            if (nums[mid]==target) return mid;
            else if (nums[mid]<target) left =mid+1;
            else right=mid-1;
        }
        return -1;
    }
    public int findMin(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right ) {
                int mid = (right + left) / 2;
                if (nums[mid] > nums[right]) left = mid+1;
                else right = mid;

        }
        return nums[left];
    }


    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int left= 1;
        int right = piles[piles.length-1];

        while (left<right){

            int mid=(left+right)/2;

            int hours=0;

            for (int x:piles){
                hours = hours + (int) Math.ceil((double)x/mid);
            }
            if (hours<=h) {
                right =mid;
            }
            else if (hours>h) {
                left =mid+1;
            }
        }
        return left;
    }



    public boolean searchMatrix(int[][] matrix, int target) {
        int left= 0;
        int right= matrix.length-1;
        for (int i=0;i<matrix.length;i++){
            int mid= (left+right)/2;
            if (matrix[i][0]<=target && target <= matrix[i][matrix[i].length-1]) {
                int leftArray=0;
                int rightArray=matrix[i].length-1;
                for (int j=0;j<matrix[i].length;j++){
                    int midArray= (leftArray+rightArray)/2;
                    if (matrix[i][j]==target) return true;
                    else if(matrix[i][midArray]<target) left=midArray+1;
                    else right = midArray-1;
                }
            }
            else if (matrix[i][0]<target) left= mid+1;
            else right = mid-1;
        }
        return false;

    }


    public int carFleet(int target, int[] position, int[] speed) {

        HashMap <Integer, Integer> carSet = new HashMap<>();
        for (int i=0; i<position.length;i++){
            carSet.put(position[i],speed[i]);
        }

        Arrays.sort(position);
        System.out.println(Arrays.toString(position));

        Stack <Integer> cars = new Stack<>();
        cars.push(position[position.length-1]);

        for(int i=position.length-1 ; i>0; i--){
            int positionA=cars.peek() ;
            int positionB= position[i-1];
            int timeA = (target-positionA)/carSet.get(positionA);
            int timeB= (target-positionB)/carSet.get(positionB);
            if(timeA<timeB) {
                cars.push(positionB);
            }
        }
        return cars.size();
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int ans[] = new int[temperatures.length];

        Stack<Integer> temps = new Stack<>();
        temps.push(temperatures[0]);

        for (int i=1; i<temperatures.length;i++ ){
            if (temperatures[i]<=temps.peek()) {
                temps.push(temperatures[i]);
            }

            else{
                while (temps.peek()<temperatures[i]){
                    int j= idxFinder(temps.peek(), temperatures);
                    ans[j] = i-j;
                    temps.pop();
                }
            }
        }
        return ans;
    }

    public static int idxFinder(int x, int[] a){
        int r= -1;
        for (int i=0; i<a.length;i++){
            if (x==a[i]) r=i;
        }
        return r;
    }

    public boolean isValid(String s) {
        Stack<Character> charS= new Stack<>();
        int idx=0;
        while(idx<s.length()){
            if (charS.isEmpty()) charS.push(s.charAt(idx));
            else if (s.charAt(idx) ==')' && charS.peek()=='(' ) charS.pop();
            else if (s.charAt(idx) ==']' && charS.peek()=='[' ) charS.pop();
            else if (s.charAt(idx) =='}' && charS.peek()=='{' ) charS.pop();
            else charS.push(s.charAt(idx));
            idx++;
        }
        return charS.empty();
    }

            public List<String> generateParenthesis(int n) {
                list = new ArrayList<>();
                insert(new StringBuilder(), 0, 0, n);
                return list;
            }

            private void insert(StringBuilder sbr, int open, int close, int n) {
                if (sbr.length() == 2 * n) {
                    list.add(sbr.toString());
                    return;
                }
                if (open < n) {
                    sbr.append("(");
                    insert(sbr, open + 1, close, n);
                    sbr.deleteCharAt(sbr.length() - 1);
                } if (close < open) {
                    sbr.append(")");
                    insert(sbr, open, close + 1, n);
                    sbr.deleteCharAt(sbr.length() - 1);
                }

    }

        public int evalRPN(String[] tokens) {
            Stack<Integer> nums = new Stack<>();
            for (String s: tokens) {
                if (!s.equals("+") && !s.equals("-") && !s.equals("*") && !s.equals("/")) nums.add(Integer.parseInt(s));
                else {
                    int first = nums.pop();
                    int sec = nums.pop();
                    if (s.equals("+")) nums.push(first+sec);
                    if (s.equals("-")) nums.push(sec-first);
                    if (s.equals("*")) nums.push(first*sec);
                    if (s.equals("/")) nums.push(sec/first);
                }
            }
            return nums.pop();
        }


    public int maxArea(int[] heights) {
        int maxArea=0;
        int  i=0;
        int j=heights.length-1;
        while (i<j){
            int width = j-i;
            int high = Math.min(heights[i],heights[j]);
            int area = width*high;
            maxArea = Math.max(maxArea,area);
            if (heights[i]>heights[j]) j--;
            else i++;
        }
        return maxArea;
    }
    public List<List<Integer>> threeSum(int[] nums) {
       // Arrays.sort(nums);
        HashSet <List<Integer>> ans= new HashSet<>();
        //List <List<Integer>> ans = new ArrayList<>();
        for (int i=0 ; i<nums.length-2 ; i++){
            for (int j=i+1 ; j<nums.length-1 ; j++){
                for (int z=j+1 ; z<nums.length ; z++){
                    if(nums[i]+nums[j]+nums[z]==0) {
                        int[] s = new int[]{nums[i], nums[j], nums[z]};
                        Arrays.sort(s);
                        List<Integer> sum = Arrays.asList(s[0],s[1],s[2]);
                        ans.add(sum);
                    }
                }
            }
        }
        return new ArrayList<>(ans);
    }
    public int[] twoSum(int[] numbers, int target) {
        int idx1=0;
        int idx2=1;
        while(idx1<numbers.length-1){
            idx2= idx1+1;
            while(idx2<numbers.length){
                if(numbers[idx1]+numbers[idx2]==target) return new int[]{idx1,idx2};
                idx2++;
            }
            idx1++;
        }

        return new int[]{idx1,idx2};
    }


    public boolean isValidSudoku(char[][] board) {

        for(int i=0; i<9;i++){
            HashSet<Character> columns = new HashSet<>();
            for(int j=0;j<9;j++){
                if (board[i][j]!='.' && !columns.add(board[i][j])) return false;
            }
        }

        for(int i=0; i<9;i++){
            HashSet<Character> rows = new HashSet<>();
            for(int j=0;j<9;j++){
                if (board[j][i]!='.' && !rows.add(board[j][i])) return false;
            }
        }

        int x = 0;
        while (x < 9) {
            int y = 0;
            while (y < 9) {
                Set<Character> subBox = new HashSet<>();
                for (int i = x; i < 3 + x; i++) {
                    for (int j = y; j < 3 + y; j++) {
                        if (board[i][j] != '.' && !subBox.add(board[i][j])) return false;
                    }
                }
                y += 3;
            }
            x += 3;
        }
        return true;
    }



    public boolean isPalindrome(String s) {
        int b=0;
        String result= s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
        result = result.replaceAll(" ","");
        int l=result.length()-1;

        while (b<l){
            if(result.charAt(b)!= result.charAt(l)) return false;
            else {
                b++;
                l--;
            }
        }
        return true;
    }
    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> ans = new ArrayList<>();
        HashMap<Integer, String> strings = new HashMap<>();
        for (int i=0; i<strs.length;i++){
            strings.put(i, strs[i]);
        }
        int l=0;
        while(l<strs.length){
             List<String> subList = new ArrayList<>();
             subList.add(strings.get(l));
             for(int j=l+1 ; j<strs.length;j++) {
                 if (isAnagram(strings.get(l),strings.get(j))){
                     subList.add(strings.get(j));
                     strings.remove(j);
                 }
             }
             ans.add(subList);
             strings.remove(l);
             while (l<strs.length & !strings.containsKey(l+1)) l++;
        }
        return ans;
    }

        public int[] twoSuma(int[] nums, int target) {
        int j=0;
        int[]a= new int[2];

        while(j<nums.length){
            for(int i=0; i<j;i++) {
                if (nums[i] + nums[j] == target) return new int[]{i, j};
            }
            j++;
        }

        return a;
    }
    public boolean isAnagram(String a, String b){
        if (a.length()!= b.length()) return false;

        char[] A = a.toCharArray();
        char [] B = b.toCharArray();
        Arrays.sort(A);
        Arrays.sort(B);

        for (int i=0; i<A.length;i++){
            if(A[i]!= B[i]) return false;
        }
        return true;
    }


    public  boolean containDuplicate (int[] arr){
        Set<Integer> Arr = new HashSet<>();
        for (int i: arr){
            if (!Arr.add(i)){
                return true;
            }
        }
        return false;
    }
}
