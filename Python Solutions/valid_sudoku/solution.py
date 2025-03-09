from typing import List

def checker(raw_number:str, reference:list[int]) -> bool:
    if raw_number == '.':
        return True
    number = int(raw_number) -1
    if reference[number] == 1:
        return False
    reference[number] = 1
    return True
    

def is_valid_sudoku(board: List[List[str]]) -> bool:
    box = [[0]*9 for _ in range(9)]
    for i in range(len(board)):
        row = [0]*9
        col = [0]*9
        for j in range(len(board)):
            if not checker(board[i][j], row):
                return False
            if not checker(board[j][i], col):
                return False
            box_i = 3*(i//3) + j//3
            if not checker(board[i][j], box[box_i]):
                return False
    else:
        return True
            
            
            