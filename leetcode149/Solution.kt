package com.harera.leetcode.leetcode149

import kotlin.math.max


class Solution {
    fun maxPoints(points: Array<IntArray>): Int {
        var max = Int.MIN_VALUE
        for (left in 0 until points.lastIndex)
            for (right in left + 1..points.lastIndex) {
                val xDif = Math.abs(points[left][0] - points[right][0])
                val yDif = Math.abs(points[left][1] - points[right][1])
                if (xDif == 1 || yDif == 1) {
                    max = max(1, max)
                    continue
                }
                if (xDif == yDif) {
                    max = max(xDif + 1, max)
                    continue
                }
                Math.sqrt(
                    Math.pow(xDif.toDouble(), 2.0)
                            + Math.pow(yDif.toDouble(), 2.0)
                ).toInt().apply {
                    max = max(this, max)
                }
            }
        return max
    }
}

fun main() {
//Input: points = [[1,1],[2,2],[3,3]]
    println(
        Solution().maxPoints(
            arrayOf(
                intArrayOf(1, 1),
                intArrayOf(2, 2),
                intArrayOf(3, 3)
            )
        )
    )
}