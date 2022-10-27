package com.harera.leetcode

class Solution {
    fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
        var localIntervals = intervals.toMutableList()
        var answer = 0

        localIntervals.sortWith(
                object : Comparator<IntArray> {
                    override fun compare(o1: IntArray, o2: IntArray): Int {
                        if (o1[0] != o2[0]) {
                            return o1[0] - o2[0]
                        }
                        return o1[1] - o2[1]
                    }
                }
        )

        var index = 0
        while (index < localIntervals.lastIndex) {
            val interval = localIntervals[index]
            val firstOfNextInterval = localIntervals[index + 1][0]
            if (firstOfNextInterval >= interval[0] && firstOfNextInterval < interval[1]) {
                if (localIntervals[index + 1][1] > interval[1]) {
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

fun main(args: Array<String>) {
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
//[[1,100],[11,22],[1,11],[2,12]]
    val case4 = arrayOf(
            arrayOf(1, 100).toIntArray(),
            arrayOf(11, 22).toIntArray(),
            arrayOf(1, 11).toIntArray(),
            arrayOf(2, 12).toIntArray(),
    )

    Solution().eraseOverlapIntervals(case4).let {
        println(it)
    }
}