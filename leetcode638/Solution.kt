package com.harera.leetcode.leetcode638

import kotlin.math.min

class Solution {
    fun shoppingOffers(price: List<Int>, special: List<List<Int>>, needs: List<Int>): Int {
        return solve(price, needs, idx = 0, special)
    }

    private fun solve(price: List<Int>, needs: List<Int>, idx: Int, special: List<List<Int>>): Int {
        if (idx > special.lastIndex) {
            if (needs.any { it < 0 })
                return Int.MAX_VALUE
            return needs.mapIndexed { index, need ->
                price[index] * need
            }.sum()
        }

        val leave = solve(price, needs, idx + 1, special)

        val multiple = needs.mapIndexed { index, need ->
            if (special[idx][index] == 0)
                return@mapIndexed Int.MAX_VALUE
            need / special[idx][index]
        }.min()

        if (multiple == 0) {
            val sum = needs.mapIndexed { index, need ->
                price[index] * need
            }.sum()
            return min(sum, leave)
        }

        var answer = leave
        for (multi in 1..multiple) {
            val remaining = needs.mapIndexed { index, need ->
                need - (multi * special[idx][index])
            }

            val pick = solve(price, remaining, idx + 1, special)
            if (pick == Int.MAX_VALUE)
                continue

            answer = min(answer, multi * special[idx].last() + pick)
        }
        return answer
    }
}

fun main() {
    val solution = Solution()
//    println(solution.shoppingOffers(listOf(2, 5), listOf(listOf(3, 0, 5), listOf(1, 2, 10)), listOf(3, 2)))

//    [1,1,1]
//    [[1,1,0,0],[2,2,1,9]]
//    [1,1,0]
    println(solution.shoppingOffers(listOf(1, 1, 1), listOf(listOf(1, 1, 0, 0), listOf(2, 2, 1, 9)), listOf(1, 1, 0)))
}