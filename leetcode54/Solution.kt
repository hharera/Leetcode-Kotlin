package com.harera.leetcode.leetcode54

import com.harera.leetcode.leetcode54_V2.Solution


class Solution {
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        val set = mutableSetOf<Int>()
        var rowFlag = true
        var rowIncreaseBy = 1
        var colIncreaseBy = -1
        val rowList = mutableListOf<Int>()
        val colList = mutableListOf<Int>()
        val m = matrix.size
        val n = matrix[0].size
        for (row in 0..(m - 1) / 2) {
            rowList.add(row)
            colList.add(m - 1 - row)
        }
        for (col in 0..(n - 1) / 2) {
            colList.add(n - 1 - col)
            rowList.add(col)
        }
        var rowIdx = 0
        var colIdx = 0

        while (rowIdx < rowList.size && colIdx < colList.size) {
            val row = rowList[rowIdx]
            val col = colList[colIdx]
            if (rowFlag) {
                for (i in col..colList[colIdx + 1]) {
                    if (!set.contains(matrix[row][i])) {
                        return set.toList()
                    }
                }
                rowIdx += rowIncreaseBy
                rowIncreaseBy *= -1
            } else {
                for (i in row..rowList[rowIdx + 1]) {
                    if (!set.contains(matrix[i][col])) {
                        set.add(matrix[i][col])
                    }
                }
                colIdx += colIncreaseBy
                colIncreaseBy *= -1
            }
            rowFlag = !rowFlag
        }

        while (rowIdx < rowList.size) {
            val row = rowList[rowIdx]
            for (i in colList[colIdx]..colList[colIdx + 1]) {
                if (!set.contains(matrix[row][i])) {
                    set.add(matrix[row][i])
                }
            }
            rowIdx += rowIncreaseBy
        }

        while (colIdx < colList.size) {
            val col = colList[colIdx]
            for (i in rowList[rowIdx]..rowList[rowIdx + 1]) {
                if (!set.contains(matrix[i][col])) {
                    set.add(matrix[i][col])
                }
            }
            colIdx += colIncreaseBy
        }

        return set.toList()
    }
}

fun main() {
    val matrix = arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(4, 5, 6),
        intArrayOf(7, 8, 9)
    )

    val solution = Solution()
    println(solution.spiralOrder(matrix))
}