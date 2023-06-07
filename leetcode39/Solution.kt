package com.harera.leetcode.leetcode39

import java.util.*


class Solution {

    private val dp = Array<List<List<Int>>?>(41) { null }

    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        return solve(candidates, remaining = target, solution = mutableListOf<Int>()).map {
            it.sorted()
        }.toSet().toList()
    }

    private fun solve(candidates: IntArray, remaining: Int, solution: List<Int>): List<List<Int>> {
        if (remaining == 0)
            return Collections.singletonList(solution)

        if (dp[remaining] != null) {
            return dp[remaining]!!
        }

        val solutions: MutableList<List<Int>> = mutableListOf()
        for (num in candidates) {
            if (num <= remaining) {
                solutions += solve(candidates, remaining - num, solution + num)
            }
        }
        return solutions
    }
}

fun main() {
    val solution = Solution()
    println(solution.combinationSum(intArrayOf(2, 3, 6, 7), 7))
}