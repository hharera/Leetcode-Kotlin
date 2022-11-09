package com.harera.leetcode.leetcode73

import com.harera.leetcode.leetcode73_V2.Solution

class Solution {
    fun setZeroes(matrix: Array<IntArray>): Unit {
        val columns = mutableSetOf<Int>()
        val rows = mutableSetOf<Int>()
        matrix.forEachIndexed { rowIndex, row ->
            row.forEachIndexed { columnIndex, value ->
                if (value == 0) {
                    columns.add(columnIndex)
                    rows.add(rowIndex)
                }
            }
        }

        columns.forEach {
            matrix.forEach { row ->
                row[it] = 0
            }
        }

        rows.forEach {
            matrix[it].fill(0)
        }
    }
}

fun main() {
    val solution = Solution()
    val arrayOf = arrayOf(intArrayOf(1, 1, 1), intArrayOf(1, 0, 1), intArrayOf(1, 1, 1))
    solution.setZeroes(arrayOf)
    println(arrayOf.toMutableList())
}