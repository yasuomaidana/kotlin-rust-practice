from typing import List


def has_duplicates(nums: List[int]) -> bool:
    duplicates = set()
    for num in nums:
        if num in duplicates:
            return True
        duplicates.add(num)
    else:
        return False