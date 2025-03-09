from typing import List


def three_sum(nums: List[int]) -> List[List[int]]:
    triplets = set()
    nums.sort()
    for i, num in enumerate(nums):
        if i > len(nums) - 2:
            break
        target = -num
        left, right = i + 1, len(nums) - 1
        while left < right:
            sum_ = nums[left] + nums[right]
            if sum_ == target:
                triplets.add((num, nums[left], nums[right]))
                left += 1
                right -= 1
            elif sum_ < target:
                left += 1
            else:
                right -= 1
    return [list(item) for item in triplets]


if __name__ == "__main__":
    to_check = [-1, 0, 1, 2, -1, -4]
    print(three_sum(to_check))
