package com.harera.leetcode.leetcode85

class Solution {
    fun maximalRectangle(_matrix: Array<CharArray>): Int {
        val matrix = Array(_matrix.size) {
            IntArray(_matrix[0].size)
        }

        val m = matrix.size
        val n = matrix[0].size
        for (i in 0 until m) {
            for (j in 0 until n) {
                matrix[i][j] = _matrix[i][j] - '0'

                if (matrix[i][j] == 0) continue
                if (i == 0 || j == 0) {
                    continue
                }
                matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1] + 1
            }
        }

        val rows = BooleanArray(m)
        val cols = BooleanArray(n)
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (matrix[i][j] == 0) {
                    rows[i] = true
                    cols[j] = true
                }
            }
        }

        var max = 0
        var endRow = 0
        var endCol = 0
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j]
                    endRow = i
                    endCol = j
                }
            }
        }
        var startRow = endRow
        var startCol = endCol
        while (startRow >= 0 && startCol >= 0) {
            if (!rows[startRow - 1]) {
                startRow--
            }
            if (!cols[startCol - 1]) {
                startCol--
            }
        }
        startRow++
        startCol++
        max = (endRow - startRow + 1) * (endCol - startCol + 1)
        return max
    }
}

fun main() {
    val solution = Solution()
    println(
        solution.maximalRectangle(
            arrayOf(
                charArrayOf('1', '0', '1', '0', '0'),
                charArrayOf('1', '0', '1', '1', '1'),
                charArrayOf('1', '1', '1', '1', '1'),
                charArrayOf('1', '0', '0', '1', '0')
            )
        )
    )
}