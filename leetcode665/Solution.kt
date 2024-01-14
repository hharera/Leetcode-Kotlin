package com.harera.leetcode.leetcode665

class Solution {


    fun checkPossibility(nums: IntArray): Boolean {
        var chance = true
        var max = Int.MIN_VALUE
        for (idx in 0 until nums.lastIndex) {
            max = maxOf(max, nums[idx])
            if (nums[idx] > nums[idx + 1]) {
                if (!chance)
                    return false
                chance = false
                if (idx > 0 && max > nums[idx + 1])
                    nums[idx + 1] = max
            }
        }
        return true
    }
}

fun main() {

}