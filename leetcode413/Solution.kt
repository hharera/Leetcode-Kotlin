package com.harera.leetcode.leetcode413

class Solution {

    private val diffs = mutableListOf<Int>()

    fun numberOfArithmeticSlices(nums: IntArray): Int {
        if (nums.size < 3)
            return 0

        for (idx in 0 until nums.lastIndex) {
            diffs.add(nums[idx + 1] - nums[idx])
        }

        var ans = 0
        for (left in 0..diffs.lastIndex) {
            val curDiff = diffs[left]
            var diffCount = 1
            for (right in left + 1..diffs.lastIndex) {
                if (diffs[right] != curDiff) {
                    break
                }
                if (++diffCount > 1)
                    ans++
            }
        }
        return ans
    }
}

fun main() {
    println(Solution().numberOfArithmeticSlices(intArrayOf(1, 2, 3, 4)))
}