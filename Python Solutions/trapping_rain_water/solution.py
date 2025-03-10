from typing import List


def trap(height: List[int]) -> int:
    trapped_watter = 0
    left_heights = [0] * len(height)
    right_heights = [0] * len(height)
    
    left_heights[0] = height[0]
    right_heights[-1] = height[-1]
    
    for i in range(1, len(height)):
        left_heights[i] = max(left_heights[i - 1], height[i])
        right_heights[~i] = max(right_heights[~(i - 1)], height[~i])
    for i, height in enumerate(height):
        trapped_watter += min(left_heights[i], right_heights[i]) - height
    
    return trapped_watter