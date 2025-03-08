from typing import List


def encode(strs: List[str]) -> str:
    return "".join(f"{len(s)}:{s}" for s in strs )

def decode(s: str) -> List[str]:
    word_length = -1
    length_start = 0
    words = []
    i = 0
    while i < len(s):
        if word_length <= 0 and s[i] == ":":            
            word_length = int(s[length_start:i])
            length_start = i + 1
            if word_length == 0:
                words.append("")
                word_length = -1
        elif word_length > 0:
            i = length_start + word_length
            words.append(s[length_start:i])
            length_start = i
            word_length = 0
        i+=1
    return words

if __name__ == "__main__":
    encoded = encode(["neet","code","love","you"])
    print(encoded)
    print(decode(encoded))