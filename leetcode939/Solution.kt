package com.harera.leetcode.leetcode939

import kotlin.math.abs

class Solution {

    fun minAreaRect(points: Array<IntArray>): Int {
        val xs = HashMap<Int, MutableList<Int>>()
        val ys = HashMap<Int, MutableList<Int>>()

        for (point in points) {
            xs[point[0]] = xs.getOrDefault(point[0], mutableListOf()).apply { add(point[1]) }
            ys[point[1]] = ys.getOrDefault(point[1], mutableListOf()).apply { add(point[0]) }
        }
        xs.values.forEach { it.sort() }
        ys.values.forEach { it.sort() }

        var answer = Int.MAX_VALUE
        xs.keys.forEach {
            val x1 = it
            var y1 = xs[it]!![0]
            for (i in 1 until xs[it]!!.size) {
                val y2 = xs[it]!![i]
                if (y1 == y2) continue

                var i = 0
                var j = 0
                while (i < ys.get(y1)!!.size && j < ys.get(y2)!!.size) {
                    if (ys.get(y1)!![i] < ys.get(y2)!![j]) {
                        i++
                    } else if (ys.get(y1)!![i] > ys.get(y2)!![j]) {
                        j++
                    } else {
                        val x2 = ys.get(y1)!![i]
                        minOf(answer, abs(x2 - x1) * abs(y1 - y2)).let {
                            if (it != 0) answer = it
                        }
                        i++
                    }
                }
                y1 = y2
            }
        }

        return if (answer == Int.MAX_VALUE) 0 else answer
    }
}

fun main() {
    val solution = Solution()
    println(
        solution.minAreaRect(
            arrayOf(
                intArrayOf(1, 1),
                intArrayOf(1, 3),
                intArrayOf(3, 1),
                intArrayOf(3, 3),
                intArrayOf(2, 2)
            )
        )
    )
}
