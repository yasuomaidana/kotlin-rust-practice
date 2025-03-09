from typing import List


def longest_consecutive(nums: List[int]) -> int:
    unique_nums = set(nums)
    longest_sequence = 0
    for num in nums:
        if num in unique_nums and num - 1 not in unique_nums:
            current_num = num
            current_sequence = 1
            while current_num + 1 in unique_nums:
                current_num += 1
                current_sequence += 1
            longest_sequence = max(longest_sequence, current_sequence)
    return longest_sequence