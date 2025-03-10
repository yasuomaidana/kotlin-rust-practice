package org.example;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] height = {0, 2, 0, 3, 1, 0, 1, 3, 2, 1};
        TrappingRainWater trappingRainWater = new TrappingRainWater();
        System.out.println(trappingRainWater.trap(height));
    }

    public int trap(int[] height) {
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        leftMax[0] = height[0];
        rightMax[height.length - 1] = height[height.length - 1];
        int trappedWater = 0;
        for (int i = 0; i < height.length - 1; i++) {
            leftMax[i + 1] = Math.max(leftMax[i], height[i + 1]);
            rightMax[height.length - (i + 2)] = Math.max(
                    rightMax[height.length - (i + 1)],
                    height[height.length - (i + 2)]);
        }
        for (int i = 0; i < height.length; i++) {
            trappedWater += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return trappedWater;
    }
}
