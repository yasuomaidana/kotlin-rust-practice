package org.example;

import java.util.HashMap;

public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> frequency = new HashMap<>();

        for (int num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }

        return frequency.entrySet()
                .stream()
                .sorted((entry1,
                         entry2) -> entry2.getValue() - entry1.getValue())
                .limit(k)
                .map(entry -> entry.getKey())
                .mapToInt(i -> i)
                .toArray();
    }
}
