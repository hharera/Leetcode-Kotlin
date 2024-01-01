package com.harera.leetcode.leetcode849

class Solution {
    fun maxDistToClosest(seats: IntArray): Int {
        var start = 0
        var end = 0
        var max = 0
        for (idx in seats.indices) {
            if (seats[idx] == 1) {
                if (start == 0 || end > seats.lastIndex)
                    max = maxOf(max, end - start)
                else
                    max = maxOf(max, (end - start + 1) / 2)

                start = idx + 1
                end = idx + 1
            } else {
                end++
            }

            if (idx == seats.lastIndex)
                max = maxOf(max, end - start)
        }

        return max
    }
}

fun main() {
    println(Solution().maxDistToClosest(intArrayOf(1,0,0,1)))
}