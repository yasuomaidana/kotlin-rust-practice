from collections import Counter


def is_anagram(s: str, t: str) -> bool:
    if len(s) != len(t):
        return False
    letters = Counter(s)
    letters.subtract(Counter(t))
    for c in t:
        if c not in letters:
            return False
        letters[c] -= 1
        if letters[c] == 0:
            letters.pop(c)
    return len(letters) == 0