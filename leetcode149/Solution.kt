package com.harera.leetcode.leetcode149

import kotlin.math.max

class Solution {
    private fun clacSlope(x1: Int, y1: Int, x2: Int, y2: Int): Double {
        return if (x1 == x2) Double.POSITIVE_INFINITY
        else (y2 - y1).toDouble() / (x2 - x1).toDouble()
    }

    fun maxPoints(points: Array<IntArray>): Int {
        if (points.size <= 2) return points.size

        points.sortBy { "${it[0]}${it[1]}" }
        val slopes = mutableMapOf<Double, Set<Pair<Int, Int>>>()
        for (left in points.indices) {
            for (right in left + 1 until points.size) {
                val slope = clacSlope(points[left][0], points[left][1], points[right][0], points[right][1])
                slopes[slope] = slopes.getOrDefault(slope, setOf()).plus(Pair(points[left][0], points[left][1]))
                    .plus(Pair(points[right][0], points[right][1]))
            }
        }

        var max = 0
        slopes.keys.forEach { slope ->
            slope
            val points = slopes[slope]!!.sortedBy {
                "${it.first}${it.second}"
            }
            for (left in points.indices) {
                var count = 0
                for (right in left + 1 until points.size) {
                    val slope_ =
                        clacSlope(points[left].first, points[left].second, points[right].first, points[right].second)
                    if (slope_ == slope)
                        count++
                }
                max = max(max, count)
            }
        }

        return max + 1
    }
}

fun main() {
    // Input: points = [[0,0],[4,5],[7,8],[8,9],[5,6],[3,4],[1,1]]
    // Output: 5
    println(
        Solution().maxPoints(
            arrayOf(
                intArrayOf(0, 0),
                intArrayOf(4, 5),
                intArrayOf(7, 8),
                intArrayOf(8, 9),
                intArrayOf(5, 6),
                intArrayOf(3, 4),
                intArrayOf(1, 1)
            )
        )
    )
    // Input: points = [[3,3],[1,4],[1,1],[2,1],[2,2]]
    // Output: 4
    println(
        Solution().maxPoints(
            arrayOf(
                intArrayOf(3, 3),
                intArrayOf(1, 4),
                intArrayOf(1, 1),
                intArrayOf(2, 1),
                intArrayOf(2, 2)
            )
        )
    )
}