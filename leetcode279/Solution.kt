package com.harera.leetcode.leetcode279

import kotlin.math.min


class Solution {

    private val memorized = Array(10001) {
            -1
    }

    fun numSquares(n: Int): Int {
        return solve(n)
    }

    private fun solve(remaining: Int): Int {
        if (remaining == 0)
            return 0
        if (remaining < 0)
            return Int.MAX_VALUE

        val sqrt = Math.sqrt(remaining.toDouble()).toInt()
        if (memorized[remaining] != -1)
            return memorized[remaining]

        var answer = Int.MAX_VALUE
        for (ele in sqrt downTo 1) {
            val square = ele * ele
            val solution = 1 + solve(remaining - square)
            answer = min(answer, solution)
        }

        return answer.also {
            memorized[remaining] = it
        }
    }
}


fun main() {
    val solution = Solution()
    println(solution.numSquares(48))
}