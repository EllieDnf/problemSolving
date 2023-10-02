package com.example.problemsolving.twoPointers;

public class ValidPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("anna"));
    }

    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();

        StringBuilder cleanString = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                cleanString.append(c);
            }
        }

        s = cleanString.toString();
        cleanString = cleanString.reverse();
        String cleaned = cleanString.toString();
        return s.equals(cleaned);
    }
    public static boolean isPalindrome2(String s) {
        String a = s.toLowerCase().replaceAll("[^a-z0-9]","");
        int i=0;
        int j=a.length()-1;

        while(i<=j){
            if (a.charAt(i) != a.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
