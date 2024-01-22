package com.harera.leetcode.leetcode91

class Solution {

    private val dp = Array<Int>(101) { -1 }

    fun numDecodings(s: String): Int {
        if (s.isEmpty())
            return 0
        return solve(0, s)
    }

    private fun solve(idx: Int, s: String): Int {
        if (idx > s.lastIndex)
            return 1
        if (s[idx] == '0')
            return 0
        if (idx == s.lastIndex)
            return 1

        if (dp[idx] != -1)
            return dp[idx]

        var answer = 0
        answer += solve(idx + 1, s)
        if (s.substring(idx, idx + 2).toInt() <= 26)
            answer += solve(idx + 2, s)
        return answer.also {
            dp[idx] = it
        }
    }
}

fun main() {
    val solution = Solution()
    println(solution.numDecodings("111111111111111111111111111111111111111111111"))
}