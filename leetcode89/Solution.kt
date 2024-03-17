package com.harera.leetcode.leetcode89

import java.lang.Math.pow

class Solution {

    private val memo = mutableMapOf<String, List<String>>()
    fun grayCode(n: Int): List<Int> {
        val cur = "0".repeat(n)
        val solve = solve(cur, n, visited = setOf(cur))
        return solve.map { it.toInt(2) }
    }

    private fun solve(repeat: String, n: Int, visited: Set<String>): List<String> {
        if (visited.size == pow(2.toDouble(), n.toDouble()).toInt())
            return visited.toList()

        println(repeat)
        if (memo.containsKey(repeat))
            return memo[repeat]!!

        var asnwer = emptyList<String>()
        for (idx in 0..repeat.lastIndex) {
            var newStr: String
            if (repeat[idx] == '0') {
                newStr = repeat.substring(0, idx) + '1' + repeat.substring(idx + 1, repeat.length)
            } else {
                newStr = repeat.substring(0, idx) + '0' + repeat.substring(idx + 1, repeat.length)
            }
            if (visited.contains(newStr))
                continue
            val answer = solve(newStr, n, visited + newStr)
            if (answer.isNotEmpty())
                break
        }

        return asnwer.also {
            memo[repeat] = it
        }
    }
}

fun main() {
    val solution = Solution()
    val n = 15
    println(solution.grayCode(n))
}