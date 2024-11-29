fun main() {
    val board = arrayOf(
        intArrayOf(1, 2, 0, 0, 3, 0, 0, 0, 0),
        intArrayOf(4, 0, 0, 5, 0, 0, 0, 0, 0),
        intArrayOf(0, 9, 8, 0, 0, 0, 0, 0, 3),
        intArrayOf(5, 0, 0, 0, 6, 0, 0, 0, 4),
        intArrayOf(0, 0, 0, 8, 0, 3, 0, 0, 5),
        intArrayOf(7, 0, 0, 0, 2, 0, 0, 0, 6),
        intArrayOf(0, 0, 0, 0, 0, 0, 2, 0, 0),
        intArrayOf(0, 0, 0, 4, 1, 9, 0, 0, 8),
        intArrayOf(0, 0, 0, 0, 8, 0, 0, 7, 9)
    )
    val sudokuBoard = SudokuBoard(board)
    println("Board 1 is valid: ${sudokuBoard.validBoard()}")
    
    val board2 = arrayOf(
        intArrayOf(1, 2, 0, 0, 3, 0, 0, 0, 0),
        intArrayOf(4, 0, 0, 5, 0, 0, 0, 0, 0),
        intArrayOf(0, 9, 1, 0, 0, 0, 0, 0, 3),
        intArrayOf(5, 0, 0, 0, 6, 0, 0, 0, 4),
        intArrayOf(0, 0, 0, 8, 0, 3, 0, 0, 5),
        intArrayOf(7, 0, 0, 0, 2, 0, 0, 0, 6),
        intArrayOf(0, 0, 0, 0, 0, 0, 2, 0, 0),
        intArrayOf(0, 0, 0, 4, 1, 9, 0, 0, 8),
        intArrayOf(0, 0, 0, 0, 8, 0, 0, 7, 9)
    )
    val sudokuBoard2 = SudokuBoard(board2)
    
    println("Board 2 is valid: ${sudokuBoard2.validBoard()}")
}