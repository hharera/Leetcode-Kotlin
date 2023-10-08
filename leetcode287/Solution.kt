package com.harera.leetcode.leetcode287

class Solution {

    fun findDuplicate(nums: IntArray): Int {
        var slow = 0
        var fast = 0

        while(true) {
            slow = nums[slow]
            fast = nums[nums[fast]]
            if (fast == slow) break
        }

        var _slow = 0
        while(slow != _slow) {
            slow = nums[slow]
            _slow = nums[_slow]
        }

        return slow
    }
}

fun main() {
    val solution = Solution()
    println(solution.findDuplicate(intArrayOf(1, 3, 4, 2, 2)))
}
