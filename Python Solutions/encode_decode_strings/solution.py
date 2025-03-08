from typing import List


def encode(strs: List[str]) -> str:
    return "".join(f"{len(s)}:{s}" for s in strs )

def decode(s: str) -> List[str]:
    word_length = -1
    length_start = 0
    words = []
    for i in range(len(s)):
        if word_length <= 0 and s[i] == ":":            
            word_length = int(s[length_start:i])
            length_start = i + 1
        elif word_length == 0:
            words.append(s[length_start:i])
            length_start = i
        elif word_length > 0:
            word_length -= 1
    return words

if __name__ == "__main__":
    encoded = encode(["neet","code","love","you"])
    print(encoded)
    print(decode(encoded))