package com.harera.leetcode.leetcode397

import kotlin.math.min


class Solution {

    private val visited = HashMap<Int, Int>()
    fun integerReplacement(n: Int): Int {
        return solve(n)
    }

    private fun solve(n: Int): Int {
        if (n >= Int.MAX_VALUE)
            return 32;
            if (n == 1)
                return 0
        if (n < 3)
            return 1

        if (visited.contains(n))
            return visited[n]!!

        val answer = if (n % 2 == 0)
            1 + solve(n / 2)
        else {
            1 + min(solve(n - 1), solve(n + 1))
        }
        return answer.also {
            visited[n] = it
        }
    }
}

fun main() {
    val solution = Solution()
    println(solution.integerReplacement(2147483647))
}