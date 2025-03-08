from collections import defaultdict
from typing import List


def group_anagrams(strs: List[str]) -> List[List[str]]:
    anagrams = defaultdict(list)
    for word in strs:
        key = tuple(sorted(word))
        anagrams[key].append(word)
    return list(anagrams.values())