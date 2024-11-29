class SudokuBoard(board: Array<IntArray>) {
    private val board: Array<IntArray> = Array(9) { IntArray(9) }

    init {
        board.forEachIndexed { i, row ->
            row.forEachIndexed { j, value -> this.board[i][j] = value }
        }
    }
    
//    fun printBoard() {
//        board.forEach { row ->
//            row.forEach { print("$it ") }
//            println()
//        }
//    }
    
    private fun generateValidationSets(): Array<MutableSet<Int>> {
        val sets = Array(9) { mutableSetOf<Int>() }
        for (i in 0..8) {
            for (j in 1..9) {
                sets[i].add(j)
            }
        }
        return sets
    }
    fun validBoard(): Boolean {
        val colSets = generateValidationSets()
        val rowSets = generateValidationSets()
        val boxSets = generateValidationSets()
        for (i in 0..8) {
            for (j in 0..8) {
                val value = board[i][j]
                if (value == 0) continue
                if (!colSets[j].remove(value) || 
                    !rowSets[i].remove(value) || 
                    !boxSets[(i / 3) * 3 + j / 3].remove(value)) {
                    return false
                }
            }
        }
        return true
    }


}