package com.harera.leetcode.leetcode435

import java.util.*

class Solution {
    fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
        val localIntervals = intervals.sortedBy {
            it[1]
        }.toMutableList()

        val stack = Stack<IntArray>()
        stack.push(localIntervals[0])
        var index = 1
        var answer = 0
        while (index < localIntervals.size) {
            val pStart = stack.peek()[0]
            val pEnd = stack.peek()[1]
            val cStart = localIntervals[index][0]
            val cEnd = localIntervals[index][1]

            if (cStart >= pEnd) {
                stack.push(localIntervals[index])
            } else {
                answer++
            }
            index++
        }
        return answer
    }
}
fun main() {
    val case1 = arrayOf(
        arrayOf(1, 2).toIntArray(),
        arrayOf(2, 3).toIntArray(),
        arrayOf(3, 4).toIntArray(),
        arrayOf(1, 3).toIntArray(),
    )

    val case2 = arrayOf(
        arrayOf(1, 2).toIntArray(),
        arrayOf(1, 2).toIntArray(),
        arrayOf(1, 2).toIntArray(),
    )

    val case3 = arrayOf(
        arrayOf(1, 2).toIntArray(),
        arrayOf(2, 3).toIntArray(),
    )
    val case4 = arrayOf(
        arrayOf(1, 100).toIntArray(),
        arrayOf(11, 22).toIntArray(),
        arrayOf(1, 11).toIntArray(),
        arrayOf(2, 12).toIntArray(),
    )

    Solution().eraseOverlapIntervals(case4).let {
        println(it)
    }

    Solution().eraseOverlapIntervals(case1).let {
        println(it)
    }

    Solution().eraseOverlapIntervals(case2).let {
        println(it)
    }

    Solution().eraseOverlapIntervals(case3).let {
        println(it)
    }
}