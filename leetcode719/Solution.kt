package com.harera.leetcode.leetcode719

import kotlin.math.abs

class Solution {
    fun smallestDistancePair(nums: IntArray, k: Int): Int {
        nums.sort()
        var order = 1
        var i = 0
        var j = 1
        var l = nums.lastIndex
        var m = nums.lastIndex - 1
        while (i < nums.size && j < nums.size && l > 0 && m > 0) {
            if (abs(nums[i] - nums[j]) <= abs(nums[l] - nums[m])) {
                if (k == order) {
                    return abs(nums[i] - nums[j])
                }
                order++
                if (j == nums.lastIndex) {
                    i++
                    j = i + 1
                } else {
                    j++
                }
            } else {
                if (k == order) {
                    return abs(nums[l] - nums[m])
                }
                order++
                if (m == nums.lastIndex) {
                    l++
                    m = l + 1
                } else {
                    m++
                }
            }

        }
        return nums[0]
    }
}

fun main() {
    val solution = Solution()
    solution.smallestDistancePair(intArrayOf(62,100,4), 2)
}

