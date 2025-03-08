from typing import List


class Solution:
    def has_duplicates(self, nums: List[int]) -> bool:
        duplicates = set()
        for num in nums:
            if num in duplicates:
                return True
            duplicates.add(num)
        else:
            return False