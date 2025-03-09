package org.example;

class Solution {
    
    public boolean isValidSudoku(char[][] board) {
        int[][] boxIndex = new int[9][9];
        for (int i = 0; i < 9; i++) {
            int[] row = new int[9];
            int[] column = new int[9];
            for (int j = 0; j < 9; j++) {
                char rowChar = board[i][j];
                char columnChar = board[j][i];
                if (rowChar != '.') {
                    int rowInt = Character.getNumericValue(rowChar) - 1;
                    if (row[rowInt] == 1) {
                        return false;
                    }
                    row[rowInt] = 1;
                    int box_i = (i / 3) * 3 + j / 3;
                    if (boxIndex[box_i][rowInt] == 1) {
                        return false;
                    }
                    boxIndex[box_i][rowInt] = 1;
                }
                if (columnChar != '.') {
                    int columnInt = Character.getNumericValue(columnChar) - 1;
                    if (column[columnInt] == 1) {
                        return false;
                    }
                    column[columnInt] = 1;
                }
            }
        }
        return true;
    }
}

