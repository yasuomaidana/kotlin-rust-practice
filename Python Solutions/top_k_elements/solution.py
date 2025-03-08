from collections import Counter
from typing import List


def top_k_frequent(nums: List[int], k: int) -> List[int]:
    frequency = Counter(nums)
    most_commons = frequency.most_common(k)
    return [num for num, _ in most_commons]