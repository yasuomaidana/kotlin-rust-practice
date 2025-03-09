from typing import List


def two_sum(numbers: List[int], target: int) -> List[int]:
    reminders = {}
    for i, num in enumerate(numbers):
        reminder = target - num
        if reminder in reminders:
            return [reminders[reminder] + 1, i +1]
        reminders[num] = i