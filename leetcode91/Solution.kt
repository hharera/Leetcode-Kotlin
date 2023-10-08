package com.harera.leetcode.leetcode91

class Solution {

    private val dp = Array<Int>(101) { -1 }

    fun numDecodings(s: String): Int {
        if (s.isEmpty())
            return 0
        if (s.length == 1)
            return if (s[0] == '0') 0 else 1
        return solve(0, s)
    }

    private fun solve(idx: Int, s: String): Int {
        if (idx == s.lastIndex)
            return 1

        if (dp[idx] != -1)
            return dp[idx]

        val next = if (s[idx + 1] == '0' || s[idx] != '0')
            solve(idx + 1, s)
        else 0
        val nextNext = if (idx + 1 < s.lastIndex && s.substring(idx..idx + 1).toInt() < 27)
            solve(idx + 2, s)
        else 0

        dp[idx] = next + nextNext
        return dp[idx]
    }
}

fun main() {
    val solution = Solution()
    println(solution.numDecodings("111"))
}