from typing import List

def max_profit(prices: List[int]) -> int:
    max_profit_ = 0
    left = 0
    right = left+1
    while right < len(prices):
        profit = prices[right] - prices[left]
        if max_profit_ < profit:
            max_profit_ = profit
        if prices[left] > prices[right]:
            left += 1
            if left == right:
                right += 1
            continue
        right += 1
    return max_profit_

if __name__ == "__main__":
    prices = [2, 1, 4]
    print(max_profit(prices))