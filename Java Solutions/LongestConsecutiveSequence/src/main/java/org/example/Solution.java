package org.example;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set =
                Arrays.stream(nums).boxed().collect(Collectors.toCollection(HashSet::new));

        int longestStreak = 0;

        for (int num : nums) {
            if (set.contains(num) && !set.contains(num - 1)) {
                int count = 0, currentNum = num;
                while (set.contains(currentNum)) {
                    set.remove(currentNum);
                    count++;
                    currentNum++;
                }
                longestStreak = Math.max(longestStreak, count);
            }
        }

        return 0;
    }
}

