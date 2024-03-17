package com.harera.leetcode.leetcode611

class Solution {
    fun triangleNumber(nums: IntArray): Int {
        nums.sort()
        var answer = 0
        for (i in nums.indices) {
            for (j in i + 1 until nums.size) {
                val mid = search(nums, 0, nums.size - 1, nums[i] + nums[j])
                answer += mid - 1
            }
        }
        return answer
    }

    private fun search(nums: IntArray, _start: Int, _end: Int, target: Int): Int {
        var start = _start
        var end = _end
        var mid = start + (end - start) / 2
        while (start < end) {
            if (nums[mid] < target) {
                start = mid
            } else {
                end = mid - 1
            }
            mid = start + (end - start) / 2
        }
        return mid
    }
}

fun main() {
    val solution = Solution()
    val nums = intArrayOf(2, 2, 3, 4)
    println(solution.triangleNumber(nums))
}