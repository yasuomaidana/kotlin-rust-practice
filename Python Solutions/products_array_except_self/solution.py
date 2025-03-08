from typing import List


def product_except_self(nums: List[int]) -> List[int]:
    result = [1] * len(nums)
    left_product = 1
    for i, num in enumerate(nums):
        result[i] *= left_product
        left_product *= num
    right_product = 1
    for i in range(len(nums)):
        result[~i] *= right_product
        right_product *= num[~i]
    return result