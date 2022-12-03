package com.harera.leetcode.leetcode162


class Solution {
    fun findPeakElement(nums: IntArray): Int {
        var maxIdx = 0
        var max = Int.MIN_VALUE
        nums.forEachIndexed { index, i ->
            if (i > max) {
                max = i
                maxIdx = index
            }
        }
        return maxIdx
    }
}

fun main() {
    println(
        Solution().findPeakElement(intArrayOf(1, 2, 3, 1))
    )
}