package com.harera.leetcode.leetcode279_v2

import kotlin.math.min


class Solution {

    private val memorized = Array(10001) { -1 }

    private val squares = Array(101) { 0 }

    fun numSquares(n: Int): Int {
        for (idx in squares.indices) {
            squares[idx] = idx * idx
        }

        for (idx in 1 until n) solve(idx)

        return solve(n)
    }

    private fun solve(remaining: Int): Int {
        if (remaining == 0) return 0

        if (memorized[remaining] != -1) return memorized[remaining]

        var answer = Int.MAX_VALUE
        for (square in squares) {
            if(square == 0) continue
            if (square > remaining) break

            answer = min(answer, 1 + solve(remaining - square))
        }

        return answer.also {
            memorized[remaining] = it
        }
    }
}


fun main() {
    val solution = Solution()
    println(solution.numSquares(10000))
}