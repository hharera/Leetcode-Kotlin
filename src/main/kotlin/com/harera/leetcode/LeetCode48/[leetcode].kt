package LeetCode48

internal class Solution {
    fun rotate(matrix: Array<IntArray>) {
        val ans = Array(matrix.size) { IntArray(matrix[0].size) }
        for (i in matrix.indices) {
            for (j in matrix[0].indices) {
                ans[j][matrix[0].size - 1 - i] = matrix[i][j]
            }
        }
        for (i in matrix.indices) {
            for (j in matrix[0].indices) {
                matrix[i][j] = ans[i][j]
            }
        }
    }
}