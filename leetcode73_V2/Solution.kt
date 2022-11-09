package com.harera.leetcode.leetcode73_V2

class Solution {
    fun setZeroes(matrix: Array<IntArray>): Unit {
        val colsRows = StringBuilder()
        matrix.forEachIndexed { rowIndex, row ->
            row.forEachIndexed { columnIndex, value ->
                if (value == 0) {
                    colsRows.append(columnIndex)
                    colsRows.append(" ")
                    colsRows.append(rowIndex)
                    colsRows.append(" ")
                }
            }
        }

        colsRows.split(" ").forEachIndexed { index, string ->
            if (string != "") {
                if (index % 2 == 0) {
                    matrix.forEach { row ->
                        row[string.toInt()] = 0
                    }
                } else {
                    matrix[string.toInt()].fill(0)
                }
            }
        }
    }
}

fun main() {
    val solution = Solution()
//    val arrayOf = arrayOf(intArrayOf(1, 1, 1), intArrayOf(1, 0, 1), intArrayOf(1, 1, 1))
//    [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
    val arrayOf = arrayOf(intArrayOf(0, 1, 2, 0), intArrayOf(3, 4, 5, 2), intArrayOf(1, 3, 1, 5))
    solution.setZeroes(arrayOf)
    println(arrayOf.toMutableList())
}