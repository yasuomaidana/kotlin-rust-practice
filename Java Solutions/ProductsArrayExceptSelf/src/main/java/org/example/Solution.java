package org.example;

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int result[] = new int[nums.length];
        int left_product = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = left_product;
            left_product *= nums[i];
        }
        int right_product = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= right_product;
            right_product *= nums[i];
        }
        return result;
    }
}
