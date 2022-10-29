package LeetCode304

fun main() {

}

class NumMatrix(matrix: Array<IntArray>) {
    lateinit var comulativeMatrix: Array<IntArray>

    init {
        comulativeMatrix = Array(matrix.size + 1, { IntArray(matrix[0].size + 1, { 0 }) })
        for (idx in 1..comulativeMatrix.lastIndex) {
            for (idx2 in 1..comulativeMatrix[0].lastIndex) {
                comulativeMatrix[idx][idx2] = comulativeMatrix[idx][idx2 - 1] + matrix[idx - 1][idx2 - 1]
            }
        }

        for (idx in 1..comulativeMatrix.lastIndex) {
            for (idx2 in 1..comulativeMatrix[0].lastIndex) {
                comulativeMatrix[idx][idx2] += comulativeMatrix[idx - 1][idx2]
            }
        }
    }

    fun sumRegion(row1: Int, col1: Int, row2: Int, col2: Int): Int {
        val upperRegion = Pair(row1, col2 + 1)
        val leftRegion = Pair(row2 + 1, col1)
        val diagonalRegion = Pair(row1, col1)

        println(comulativeMatrix[row2][col2])
        println(comulativeMatrix[upperRegion.first][upperRegion.second])
        println(comulativeMatrix[leftRegion.first][leftRegion.second])
        println(comulativeMatrix[diagonalRegion.first][diagonalRegion.second])

        var ans = 0
        ans += comulativeMatrix[row2 + 1][col2 + 1]
        if (upperRegion.first >= 0)
            ans -= comulativeMatrix[upperRegion.first][upperRegion.second]

        if (leftRegion.second >= 0)
            ans -= comulativeMatrix[leftRegion.first][leftRegion.second]

        if (diagonalRegion.second >= 0 && diagonalRegion.first >= 0)
            ans += comulativeMatrix[diagonalRegion.first][diagonalRegion.second]

        return ans
    }
}