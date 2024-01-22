package com.harera.leetcode.leetcode407

import kotlin.math.min
import kotlin.text.Typography.greater

class Solution {
    fun trapRainWater(heightMap: Array<IntArray>): Int {
        val m = heightMap.size
        val n = heightMap[0].size
        if (m < 3 || n < 3)
            return 0

        val rows = heightMap.map { it.sortedDescending() }
        val cols = mutableListOf<IntArray>()
        for (idx in 0 until n) {
            val col = IntArray(m)
            for (row in 0 until m) {
                col[row] = heightMap[row][idx]
            }
            cols.add(col)
        }
        cols.forEach { it.sortDescending() }

        var answer = 0
        for (row in 1 until m) {
            for (col in 1 until n) {
                val cell = heightMap[row][col]
                val maxRow = greater(rows[row], cell)
                val maxCol = greater(cols[col].toList(), cell)
                if (maxRow <= cell || maxCol <= cell)
                    continue
                answer += min(maxRow, maxCol) - heightMap[row][col]
            }
        }
        return answer
    }

    private fun greater(ints: List<Int>, cell: Int): Int {
        var start = 0
        var end = ints.lastIndex
        var answer = cell
        while(start < end) {
            val mid = (start + end) / 2
            if (ints[mid] <= cell) {
                start = mid + 1
            } else {
                answer = min(answer, ints[mid])
                end = mid
            }
        }
        return answer
    }
}

fun main() {
    val solution = Solution()
    println(
        solution.trapRainWater(
            arrayOf(
                intArrayOf(1, 4, 3, 1, 3, 2),
                intArrayOf(3, 2, 1, 3, 2, 4),
                intArrayOf(2, 3, 3, 2, 3, 1)
            )
        )
    )
}