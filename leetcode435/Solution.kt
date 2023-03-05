package com.harera.leetcode.leetcode435


class Solution {
    fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
        val localIntervals = intervals.sortedBy {
            it[0]
        }.toMutableList()

        var index = 0
        var answer = 0
        while (index < localIntervals.lastIndex) {
            val i1 = localIntervals[index][0]
            val i2 = localIntervals[index][1]
            val j1 = localIntervals[index + 1][0]
            val j2 = localIntervals[index + 1][1]

            if (j1 in i1 until i2) {
                if (j2 > i2) {
                    localIntervals.removeAt(index + 1)
                } else {
                    localIntervals.removeAt(index)
                }
                index--
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