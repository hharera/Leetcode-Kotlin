package com.harera.leetcode.leetcode730

class Solution {

    private lateinit var dp: Array<Array<Array<Int>>>

    fun countPalindromicSubsequences(s: String): Int {
        dp = Array(s.length) { Array(s.length) { Array(4) { -1 } } }
        var answer = 0
        for (alpha in 0..3)
            answer = (answer + solve(original = s, start = 0, end = s.lastIndex, alpha = 0)) % 1000000007
        return answer
    }

    private fun solve(original: String, start: Int, end: Int, alpha: Int): Int {
        if (start > end)
            return 0
        if (start == end) {
            if (original[start] == 'a' + alpha)
                return 1
            return 0
        }

        if (dp[start][end][alpha] != -1)
            return dp[start][end][alpha]

        var answer = 0
        if (original[start] == original[end] && original[start] == 'a' + alpha) {
            answer += 2
            for (alpha in 0..3)
                answer = (answer + solve(original, start + 1, end - 1, alpha)) % 1000000007
        } else {
            answer = (answer + solve(original, start + 1, end, alpha)) % 1000000007
            answer = (answer + solve(original, start, end - 1, alpha)) % 1000000007
            answer = (answer - solve(original, start + 1, end - 1, alpha)) % 1000000007
        }

        return answer.also {
            dp[start][end][alpha] = it
        }
    }
}

fun main() {
    val solution = Solution()
    println(solution.countPalindromicSubsequences("abcdabcdabcdabcdabcdabcdabcdabcddcbadcbadcbadcbadcbadcbadcbadcba"))
}
