package com.harera.leetcode.leetcode769

import kotlin.math.max
import kotlin.math.min

class Solution {
    fun maxChunksToSorted(arr: IntArray): Int {
        return solve(arr.toMutableList(), idx = 0)
    }

    private fun solve(arr: MutableList<Int>, idx: Int): Int {
        if (arr == arr.sorted()) {
            return 1
        }
        if (idx > arr.lastIndex)
            return Int.MAX_VALUE

        var result = 0
        for (size in 1..(arr.size - idx)) {
            val temp = arr.subList(0, arr.size)
            temp.subList(idx, idx + size).sorted().forEachIndexed { index, i ->
                temp[idx + index] = i
            }
            val solution = solve(temp, idx + size)
            if (solution != Int.MAX_VALUE)
                result = max(result, solution + 1)
        }
        return result
    }
}

fun main() {
    val solution = Solution()
    println(solution.maxChunksToSorted(intArrayOf(1, 0, 2, 3, 4)))
}