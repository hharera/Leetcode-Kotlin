package com.harera.leetcode.leetcode48



fun main() {
    Solution().rotate(
        arrayOf(
            arrayOf(
                1, 2, 3
            ).toIntArray(),
            arrayOf(
                4, 5, 6
            ).toIntArray(),
            arrayOf(
                7, 8, 9
            ).toIntArray(),
        )
    )
}

class Solution {
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