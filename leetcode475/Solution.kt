package com.harera.leetcode.leetcode475

import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

class Solution {
    fun findRadius(houses: IntArray, heaters: IntArray): Int {
        val sorted = heaters.sorted()
        var answer = 0
        houses.forEach {
            answer = max(answer, getMinDiff(it, sorted))
        }
        return answer
    }

    private fun getMinDiff(house: Int, heaters: List<Int>): Int {
        var start = 0
        var end = heaters.lastIndex
        var answer = Int.MAX_VALUE
        while (start < end) {
            val mid = (start + end) / 2
            if (heaters[mid] == house)
                return 0
            if (heaters[mid] < house) {
                start = mid + 1
                answer = min(answer, abs(house - heaters[mid]))
            } else {
                end = mid - 1
            }
        }
        answer = min(answer, abs(house - heaters[start]))


        start = 0
        end = heaters.lastIndex
        while (start < end) {
            val mid = (start + end) / 2
            if (heaters[mid] == house)
                return 0
            if (heaters[mid] > house) {
                end = mid - 1
                answer = min(answer, abs(house - heaters[mid]))
            } else {
                start = mid + 1
            }
        }
        return min(answer, abs(heaters[start] - house))
    }
}

fun main() {
    println(Solution().findRadius(intArrayOf(1,2,3,4), intArrayOf(1,4)))
}
