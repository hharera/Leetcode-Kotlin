package com.harera.leetcode.leetcode1143

import kotlin.math.max

class Solution {

    private val dp = Array<Array<Int>>(1005) { Array<Int>(1005) { -1 } }

    fun longestCommonSubsequence(text1: String, text2: String): Int {
        return solve(0, 0, text1, text2)
    }

    private fun solve(idx1: Int, idx2: Int, text1: String, text2: String): Int {
        if (idx1 > text1.lastIndex || idx2 > text2.lastIndex) {
            return 0
        }

        if (dp[idx1][idx2] != -1)
            return dp[idx1][idx2]

        if (text1[idx1] == text2[idx2])
            return 1 + solve(idx1 + 1, idx2 + 1, text1, text2)

        return max(
            solve(idx1, idx2 + 1, text1, text2),
            solve(idx1 + 1, idx2, text1, text2)
        ).also {
            dp[idx1][idx2] = it
        }
    }
}

fun main() {
    val solution = Solution()
    println(solution.longestCommonSubsequence("accccccdeeeeb", "adb"))
}