package com.harera.leetcode.leetcode738

import kotlin.math.max

class Solution {

    private val dp = Array(10) { Array(10) { Array(10) { Array(10) { -1 } } } }

    fun monotoneIncreasingDigits(n: Int): Int {
        if (n < 10)
            return n

        return (1..n.toString().length).maxOf {
            solve(n, it, 1, "")
        }
    }

    private fun isMonotoneIncreasing(result: String): Boolean {
        for (i in 0 until result.lastIndex) {
            if (result[i] > result[i + 1])
                return false
        }
        return true
    }

    private fun solve(n: Int, length: Int, idx: Int, result: String): Int {
        if (idx > length) {
            if (isMonotoneIncreasing(result) && result.toLong() <= n)
                return result.toInt()
            return 0
        }

        if (!isMonotoneIncreasing(result) || (result.isNotBlank() && result.toLong() > n))
            return 0

        var max = 0
        for (i in 1..9) {
            max = max(max, solve(n, length, idx + 1, result + i))
        }
        return max
    }
}

fun main() {
//    println(Solution().monotoneIncreasingDigits(332))
    println(Solution().monotoneIncreasingDigits(1000000000))
}