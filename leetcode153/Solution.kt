package com.harera.leetcode.leetcode153


class Solution {
    fun findMin(nums: IntArray): Int {
        var left = 0
        val right = nums.lastIndex
        while (left < right) {
            if (nums[left] > nums[right]) {
                left++
                continue
            }
            return nums[left]
        }
        return nums[left]
    }
}

fun main() {
    val solution = Solution()
    println(solution.findMin(intArrayOf(4, 5, 6, 7, 0, 1, 2)))
}