package com.harera.leetcode.leetcode329

import kotlin.math.max

class Solution {

    private val dp = Array(201) { Array(201) { -1 } }

    private val directions = arrayOf(
        intArrayOf(0, 1),
        intArrayOf(0, -1),
        intArrayOf(1, 0),
        intArrayOf(-1, 0)
    )

    fun longestIncreasingPath(matrix: Array<IntArray>): Int {
        var max = Int.MIN_VALUE
        for (row in matrix.indices) {
            for (col in matrix[row].indices) {
                max = max(max, 1 + solve(matrix, row, col))
            }
        }
        return max
    }

    private fun solve(matrix: Array<IntArray>, row: Int, col: Int): Int {
        if (dp[row][col] != -1)
            return dp[row][col]

        var max = 0
        directions.forEach {
            val newRow = row + it[0]
            val newCol = col + it[1]
            if (newRow in matrix.indices && newCol in matrix[newRow].indices && matrix[newRow][newCol] > matrix[row][col]) {
                max = max(max, 1 + solve(matrix, newRow, newCol))
            }
        }
        return max.also {
            dp[row][col] = it
        }
    }
}
