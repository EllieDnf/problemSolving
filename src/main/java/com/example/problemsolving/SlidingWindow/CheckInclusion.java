package com.example.problemsolving.SlidingWindow;

import java.util.Arrays;
import java.util.HashMap;

public class CheckInclusion {
    public boolean checkInclusion(String s1, String s2) {

        char[] s1Arr = s1.toCharArray();
        Arrays.sort(s1Arr);
        String sortedS1 = new String(s1Arr);

        for (int i = 0; i <= s2.length()-s1.length(); i++) {

                char[] subStrArr = s2.substring(i, s1.length()+i).toCharArray();
                Arrays.sort(subStrArr);
                String sortedSubStr = new String(subStrArr);

                if (sortedSubStr.equals(sortedS1)) {
                    return true;
                }
            }
        return false;
    }
}
