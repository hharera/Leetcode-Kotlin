package com.harera.leetcode.leetcode986

import kotlin.math.max
import kotlin.math.min

class Solution {
    fun intervalIntersection(firstList: Array<IntArray>, secondList: Array<IntArray>): Array<IntArray> {
        val result = mutableListOf<IntArray>()
        for (i in firstList.indices) {
            for (j in secondList.indices) {
                if (firstList[i][0] > secondList[j][1] || secondList[j][0] > firstList[i][1]) {
                    continue
                }

                result.add(intArrayOf(max(firstList[i][0], secondList[j][0]), min(firstList[i][1], secondList[j][1])))
            }
        }
        return result.toTypedArray()
    }
}

fun main() {
    val solution = Solution()
    println(
        solution.intervalIntersection(
            arrayOf(
                intArrayOf(0, 2),
                intArrayOf(5, 10),
                intArrayOf(13, 23),
                intArrayOf(24, 25)
            ),
            arrayOf(
                intArrayOf(1, 5),
                intArrayOf(8, 12),
                intArrayOf(15, 24),
                intArrayOf(25, 26)
            )
        ).forEach {
            println(it.contentToString())
        }
    )
}