from typing import List


def calculate_area(heights: List[int], left: int, right: int) -> int:
    return min(heights[left], heights[right]) * (right - left)


def max_area(heights: List[int]) -> int:
    left = 0
    right = len(heights) - 1
    max_area_ = calculate_area(heights, left, right)
    while left < right:
        if heights[left] > heights[right]:
            right -= 1
        else:
            left += 1
        max_area_ = max(max_area_, calculate_area(heights, left, right))
    return max_area_