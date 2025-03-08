package org.example;

import java.util.HashMap;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> reminder = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (reminder.containsKey(nums[i])) {
                return new int[]{reminder.get(nums[i]), i};
            }
            reminder.put(target - nums[i], i);
        }
        return null;
    }
}
