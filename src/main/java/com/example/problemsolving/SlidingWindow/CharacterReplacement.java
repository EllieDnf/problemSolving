package com.example.problemsolving.SlidingWindow;

import java.util.HashMap;
import java.util.HashSet;

public class CharacterReplacement {

    public int characterReplacement(String s, int k) {

        int ans = 0;
        int left=0;
        HashMap<Character, Integer> countLetters = new HashMap<>();
        int maxFreq = 0;

        for (int right = 0; right < s.length(); right ++) {
            countLetters.put(s.charAt(right), countLetters.getOrDefault(s.charAt(right), 0) + 1);
            maxFreq = Math.max(maxFreq, countLetters.get(s.charAt(right)));
            if ((right - left + 1) - maxFreq > k) {
                char ch = s.charAt(left);
                countLetters.put(ch, countLetters.get(ch)-1);
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
