package com.harera.leetcode.leetcode189

class Solution {
    fun rotate(nums: IntArray, k_: Int): Unit {
        val k = k_ % nums.size
        if(k == 0)
            return

        val mid = nums.size / 2
        for (idx in nums.indices) {
            if (idx < mid) {
                val temp = nums[idx]
                nums[idx] = nums[(idx - k + nums.size) % nums.size]
                nums[(idx - k + nums.size) % nums.size] = temp
            } else if (idx < mid * 2) {
                val temp = nums[idx]
                val replaced = (idx - k + nums.size) % nums.size
                nums[idx] = nums[(replaced - k + nums.size) % nums.size]
                nums[(replaced - k + nums.size) % nums.size] = temp
//            } else {
//                println()
            }
        }
    }
}

// 0 - 3 + 7 = 4
// 1 - 3 + 7 = 5
// 2 - 3 + 7 = 6
// 3 - 3 + 7 = 0
// 4 - 3 + 7 = 1
// 5 - 3 + 7 = 2
// 6 - 3 + 7 = 3

fun main() {
    val solution = Solution()
    solution.rotate(intArrayOf(1, 2, 3), 2)
}