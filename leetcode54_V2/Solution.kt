package com.harera.leetcode.leetcode54_V2


class Solution {
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        val set = mutableSetOf<Int>()
        var rowFlag = true
        var topRow = true
        var rightCol = true

        var row = 0
        var col = 0
        val m = matrix.size
        val n = matrix[0].size


        while (row < m && col < n) {
            if (rowFlag) {
                if (topRow) {
                    set.addAll(matrix[row].toList())
                } else {
                    set.addAll(matrix[m - 1 - row].reversed())
                    row++
                }
                topRow = !topRow
                rowFlag = false
            } else {
                val colList = mutableListOf<Int>()
                if (rightCol) {
                    for (row in 0..matrix.lastIndex) {
                        colList.add(matrix[row][n - 1 - col])
                    }
                    set.addAll(colList)
                } else {
                    val colList = mutableListOf<Int>()
                    for (row in 0..matrix.lastIndex) {
                        colList.add(matrix[row][col])
                    }
                    set.addAll(colList.reversed())
                    col++
                }
                rightCol = !rightCol
                rowFlag = true
            }
        }
        return set.toList()
    }
}

fun main() {
//    [[23,18,20,26,25],[24,22,3,4,4],[15,22,2,24,29],[18,15,23,28,28]]
    val matrix = arrayOf(
        intArrayOf(23, 18, 20, 26, 25),
        intArrayOf(24, 22, 3, 4, 4),
        intArrayOf(15, 22, 2, 24, 29),
        intArrayOf(18, 15, 23, 28, 28)
    )

    val solution = Solution()
    println(solution.spiralOrder(matrix))
}