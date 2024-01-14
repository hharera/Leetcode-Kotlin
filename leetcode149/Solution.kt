package com.harera.leetcode.leetcode149

class Solution {
    private fun clacSlope(x1: Int, y1: Int, x2: Int, y2: Int): Double {
        return if (x1 == x2) Double.POSITIVE_INFINITY
        else (y2 - y1).toDouble() / (x2 - x1).toDouble()
    }

    fun maxPoints(points: Array<IntArray>): Int {
        if (points.size <= 2) return points.size

        points.sortBy { "${it[0]}${it[1]}" }
        val slopes = mutableMapOf<Double, Set<Pair<Int, Int>>>()
        for (left in points.indices) for (right in points.indices) {
            if (left == right) continue

            val slope = clacSlope(points[left][0], points[left][1], points[right][0], points[right][1])
            slopes[slope] = slopes.getOrDefault(slope, setOf()).plus(Pair(points[left][0], points[left][1]))
                .plus(Pair(points[right][0], points[right][1]))
        }

        slopes.keys.forEach {
            val points = slopes[it]!!.sortedBy {
                "${it.first}${it.second}"
            }
            var idx = 2
            var curSlope = clacSlope(points[idx].first, points[idx].second, points[idx - 1].first, points[idx - 1].second)
            while (idx < points.size) {
//                val slope = calculate
            }
        }

        return slopes.values.maxOf { it.size }
    }
}

fun main() {
//Input: points = [[2,3],[3,3],[-5,3]]
    println(
        Solution().maxPoints(
            arrayOf(
                intArrayOf(2, 3), intArrayOf(3, 3), intArrayOf(-5, 3)
            )
        )
    )
}