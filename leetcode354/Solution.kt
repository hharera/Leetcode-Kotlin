package com.harera.leetcode.leetcode354

import java.util.*

class Solution {
    fun maxEnvelopes(envelopes: Array<IntArray>): Int {
        val widthSorted = envelopes.sortedWith { o1, o2 ->
            if (o1[0] == o2[0])
                o2[1] - o1[1]
            else
                o1[0] - o2[0]
        }
        val heightSorted = envelopes.sortedWith { o1, o2 ->
            if (o1[1] == o2[1])
                o2[0] - o1[0]
            else
                o1[1] - o2[1]
        }
        val stack = Stack<IntArray>()
        stack.add(widthSorted[0])
        val stack_ = Stack<IntArray>()
        stack_.add(heightSorted[0])
        return maxOf(solve(widthSorted, heightSorted, stack), solve(widthSorted, heightSorted, stack_))
    }

    private fun solve(widthSorted: List<IntArray>, heightSorted: List<IntArray>, stack: Stack<IntArray>): Int {
        var widthIdx = 0
        var heightIdx = 0
        while (widthIdx < widthSorted.size && heightIdx < heightSorted.size) {
            val last = stack.peek()

            val greaterWidth = widthSorted[widthIdx]
            if (greaterWidth[0] <= last[0] || greaterWidth[1] <= last[1]) {
                widthIdx++
                continue
            }
            val greaterHeight = heightSorted[heightIdx]
            if (greaterHeight[0] <= last[0] || greaterHeight[1] <= last[1]) {
                heightIdx++
                continue
            }

            if (greaterHeight[0] * greaterHeight[1] < greaterWidth[0] * greaterWidth[1]) {
                heightIdx++
                stack.add(greaterHeight);
            } else {
                widthIdx++
                stack.add(greaterWidth);
            }
        }

        while (heightIdx < heightSorted.size) {
            val last = stack.peek()

            val greaterHeight = heightSorted[heightIdx]
            if (greaterHeight[0] <= last[0] || greaterHeight[1] <= last[1]) {
                heightIdx++
                continue
            }
            stack.add(greaterHeight)
        }

        while (widthIdx < widthSorted.size) {
            val last = stack.peek()

            val greaterWidth = widthSorted[widthIdx]
            if (greaterWidth[0] <= last[0] || greaterWidth[1] <= last[1]) {
                widthIdx++
                continue
            }
            stack.add(greaterWidth)
        }
        return stack.size
    }
}

fun main() {
    //[[2,100],[3,200],[4,300],[5,500],[5,400],[5,250],[6,370],[6,360],[7,380]]
    val solution = Solution()
    println(
        solution.maxEnvelopes(
            arrayOf(
                intArrayOf(2, 100),
                intArrayOf(3, 200),
                intArrayOf(4, 300),
                intArrayOf(5, 500),
                intArrayOf(5, 400),
                intArrayOf(5, 250),
                intArrayOf(6, 370),
                intArrayOf(6, 360),
                intArrayOf(7, 380),
            )
        )
    )
}
