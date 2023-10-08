package com.harera.leetcode.lintcode1160

import kotlin.math.abs

class Solution {
    private val dp = Array<MutableList<Int>?>(1005) { null }

    fun assignBikes(workers: Array<IntArray>, bikes: Array<IntArray>): IntArray {
        return solve(idx = 0, workers, bikes, BooleanArray(1005)).toIntArray()
    }

    private fun solve(
        idx: Int,
        workers: Array<IntArray>,
        bikes: Array<IntArray>,
        takenBikes: BooleanArray
    ): MutableList<Int> {
        if (idx > workers.lastIndex)
            return mutableListOf<Int>()

        if (dp[idx] != null)
            return dp[idx]!!

        var ans = 0
        var result = mutableListOf<Int>()
        for (bike in bikes.indices) {
            var cost = abs(bikes[bike][0] - workers[idx][0]) + abs(bikes[bike][1] - workers[idx][1])
            takenBikes[bike] = true
            val solution = solve(idx + 1, workers, bikes, takenBikes)
            takenBikes[bike] = false
            cost += calculateCost(solution, workers, idx, bikes)
            if (cost < ans)
                result = solution.apply {
                    add(0, bike)
                }
        }
        return result
    }

    private fun calculateCost(solution: List<Int>, workers: Array<IntArray>, start: Int, bikes: Array<IntArray>): Int {
        var result = 0
        for (idx in start + 1..workers.lastIndex) {
            val bike = bikes[solution[idx - start + 1]]
            result +=
                abs(bike[0] - workers[idx][0]) + abs(bike[1] - workers[idx][1])
        }
        return result
    }
}

fun main() {
    println(
        Solution().assignBikes(
            arrayOf(
                intArrayOf(0, 0),
                intArrayOf(1, 1),
                intArrayOf(2, 0)
            ),
            arrayOf(
                intArrayOf(1, 0),
                intArrayOf(2, 2),
                intArrayOf(2, 1)
            )
        ).toList()
    )
}