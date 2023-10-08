package com.harera.leetcode.leetcode162_V2


class Solution {
    fun findPeakElement(values: IntArray): Int {
        val nums = intArrayOf(Int.MIN_VALUE) + values + Int.MIN_VALUE
        var left = 1
        var right = nums.lastIndex - 1
        var mid = (left + right) / 2

        while (left < right) {
            mid = (left + right) / 2
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid
            }
            if (nums[mid + 1] > nums[mid]) {
                left = mid + 1
            } else if (nums[mid] < nums[mid - 1]) {
                right = mid - 1
            }
        }
        return mid
    }
}

fun main() {
    val solution = Solution()

    // 8 test cases
    println(solution.findPeakElement(intArrayOf(1, 2, 3, 1)))
    println(solution.findPeakElement(intArrayOf(1, 2, 1, 3, 5, 6, 4)))
    println(solution.findPeakElement(intArrayOf(1, 2, 3, 4, 5, 6, 7)))
    println(solution.findPeakElement(intArrayOf(7, 6, 5, 4, 3, 2, 1)))
    println(solution.findPeakElement(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9)))
    println(solution.findPeakElement(intArrayOf(9, 8, 7, 6, 5, 4, 3, 2, 1)))
    println(solution.findPeakElement(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)))
    println(solution.findPeakElement(intArrayOf(10, 9, 8, 7, 6, 5, 4, 3, 2, 1)))
}