package org.example;

import java.util.HashMap;

public class LongestSubstringWithoutRepeating {
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()){
            return 0;
        }
        int max_length = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int left = 0, right = 0; right < s.length(); right++) {
            char letter = s.charAt(right);
            if (map.containsKey(letter) && map.get(letter) >= left) {
                left = map.get(letter) + 1;
                map.put(letter, right);
            }
            map.put(letter, right);
            max_length = Integer.max(max_length, right - left);
        }
        return max_length + 1;
    }
}
