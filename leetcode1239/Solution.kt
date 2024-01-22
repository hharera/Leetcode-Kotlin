package com.harera.leetcode.leetcode1239

import kotlin.math.max

class Solution {


    private val dp = Array(18) { HashMap<String, Int>() }
    fun maxLength(arr: List<String>): Int {
        val filtered = arr.filter {
            it.length == it.toSet().size
        }
        val strSets = filtered.map {
            it.toSet()
        }
        return solve(filtered, strSets, 0, "")
    }

    private fun solve(arr: List<String>, map: List<Set<Char>>, idx: Int, str: String): Int {
        if (idx > arr.lastIndex)
            return 0

        if (dp[idx].contains(str))
            return dp[idx][str]!!

        val leave = solve(arr, map, idx + 1, str)
        map[idx].forEach {
            if (str.contains(it)) {
                return leave.also {
                    dp[idx][str] = it
                }
            }
        }

        val pick = arr[idx].length + solve(arr, map, idx + 1, str + map[idx])
        return max(pick, leave).also {
            dp[idx][str] = it
        }
    }
}

fun main() {
    val solution = Solution()
    println(solution.maxLength(listOf("un", "iq", "ue")))
}