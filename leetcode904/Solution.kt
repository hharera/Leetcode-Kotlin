package com.harera.leetcode.leetcode904

import kotlin.math.max

class Solution {

    private val memorized = mutableMapOf<String, Int>()
    fun totalFruit(fruits: IntArray): Int {
        return solve(fruits, 0, mutableListOf<Int>(), 0)
    }

    private fun solve(fruits: IntArray, idx: Int, carried: List<Int>, result: Int): Int {
        if (idx > fruits.lastIndex)
            return result

        if (memorized.contains("$idx,$carried"))
            return memorized["$idx,$carried"]!!

        if (carried.contains(fruits[idx]))
            return solve(fruits, idx + 1, carried, result + 1).also {
                memorized["$idx,$carried"] = it
            }

        if (carried.size > 1)
            return max(
                result,
                solve(fruits, idx + 1, mutableListOf(fruits[idx]), 1)
            ).also {
                memorized["$idx,$carried"] = it
            }

        if (carried.isEmpty())
            return max(
                solve(fruits, idx + 1, carried.plus(fruits[idx]), 1),
                solve(fruits, idx + 1, carried, 0)
            ).also {
                memorized["$idx,$carried"] = it
            }

        return solve(fruits, idx + 1, carried.plus(fruits[idx]), result + 1).also {
            memorized["$idx,$carried"] = it
        }
    }
}

fun main() {
    val solution = Solution()
    solution.totalFruit(intArrayOf(1, 2, 3, 2, 2)).also {
        println(it)
    }
}
