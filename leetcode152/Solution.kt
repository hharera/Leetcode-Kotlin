package com.harera.leetcode.leetcode152

import kotlin.math.max

class Solution {

    fun maxProduct(nums: IntArray): Int {
        var max = Int.MIN_VALUE

        for (left in nums.indices) {
            var product = nums[left]
            max = max(max, product)
            for (right in left + 1..nums.lastIndex) {
                product *= nums[right]
                max = max(max, product)
            }
        }
        return max
    }
}

fun main() {
    println(Solution().maxProduct(intArrayOf(-2, 0, -1)))
}