package com.harera.leetcode.leetcode1057

import kotlin.math.abs
import kotlin.math.min


class Solution {

    private val dp = Array<Array<IntArray>>(1005) { Array(1005) { intArrayOf() } }

    fun assignBikes(workers: Array<IntArray>, bikes: Array<IntArray>): IntArray {
        return solve(workers, bikes, workerIdx = 0)
    }

    private fun solve(
        workers: Array<IntArray>,
        bikes: Array<IntArray>,
        workerIdx: Int,
        chosenBikes: IntArray = intArrayOf()
    ): IntArray {
        if (workerIdx > workers.lastIndex)
            return chosenBikes

        if (dp[workerIdx][chosenBikes.size].isNotEmpty())
            return dp[workerIdx][chosenBikes.contentHashCode()]

        var min = Int.MAX_VALUE
        var ans = intArrayOf()
        for (idx in bikes.indices) {
            val solution = solve(
                workers,
                bikes,
                workerIdx + 1,
                chosenBikes + idx
            )
            val calculate = calculate(workers, bikes, solution)
            if (calculate < min) {
                min = calculate
                ans = solution
            }
        }
        return ans.also {
            dp[workerIdx][chosenBikes.contentHashCode()] = it
        }
    }

    private fun calculate(workers: Array<IntArray>, bikes: Array<IntArray>, solution: IntArray): Int {
        var ans = 0
        for (idx in 0..min(workers.lastIndex, solution.lastIndex)) {
            ans += abs(workers[idx][0] - bikes[solution[idx]][0]) + abs(workers[idx][1] - bikes[solution[idx]][1])
        }
        return ans
    }
}

fun main() {
    println(
        Solution().assignBikes(
            arrayOf(intArrayOf(0, 0), intArrayOf(2, 1)),
            arrayOf(intArrayOf(1, 2), intArrayOf(3, 3))
        )
    )
}