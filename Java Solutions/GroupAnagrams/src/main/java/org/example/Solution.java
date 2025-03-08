package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] letters = str.toCharArray();
            java.util.Arrays.sort(letters);
            String key = Arrays.toString(letters);
            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                map.put(key, new ArrayList<>(List.of(str)));
            }
        }
        return map.values().stream().toList();
    }
}
