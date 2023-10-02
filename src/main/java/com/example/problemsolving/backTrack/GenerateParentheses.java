package com.example.problemsolving.backTrack;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        System.out.println(backTrack(3));
    }

    public static List<String> backTrack(int n) {
        List<String> ans = new ArrayList<>();
        backTrack(ans,"", 0,0,n );
        return ans;
    }

    public static void backTrack(List<String> ans,String cur, int open, int close, int n){
        if ( open ==n && close==n ){
            ans.add(cur);
            return;
        }

        if (open<n){
            backTrack(ans,cur+'(',open+1,close,n);
        }
        if (close<open){
            backTrack(ans,cur+')',open,close+1,n);
        }
    }
}