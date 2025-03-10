package org.example;

public class ContainerWithMostWater {

    int calculate_area(int[] heights, int left, int right) {
        return Integer.min(heights[left], heights[right]) * (right - left);
    }

    public static void main(String[] args) {
        int[] height = {1, 7, 2, 5, 12, 3, 500, 500, 7, 8, 4, 7, 3, 6};
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        System.out.println(containerWithMostWater.maxArea(height));
    }

    public int maxArea(int[] heights) {
        int left = 0, right = heights.length - 1;
        int max_area = calculate_area(heights, left, right);
        while (left < right) {
            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
            max_area = Integer.max(max_area, calculate_area(heights, left, right));
        }
        return max_area;
    }
}
