package org.example;

import java.util.HashMap;

public class TwoIntegerSum2 {
    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        TwoIntegerSum2 twoIntegerSum2 = new TwoIntegerSum2();
        twoIntegerSum2.twoSum(numbers, target);

    }

    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int complement = target - numbers[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement) + 1, i + 1};
            }
            map.put(numbers[i], i);
        }
        return null;
    }
}
