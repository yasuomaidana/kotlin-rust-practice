def length_of_longest_substring(s: str) -> int:
    if not s:
        return 0
    used_letters = {}
    left = 0
    length = 0
    
    for right, letter in enumerate(s):
        if letter in used_letters and used_letters[letter] >= left:
            left = used_letters[letter] + 1
            used_letters[letter] = right
        used_letters[letter] = right
        length = max(length, right - left)

    return length + 1
