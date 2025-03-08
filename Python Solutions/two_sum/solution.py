from typing import List


def two_sum(self, nums: List[int], target: int) -> List[int]:
    reminders = {}
    for i, num in enumerate(nums):
        if num in reminders:
            return [reminders[num], i]
        reminders[target - num] = i