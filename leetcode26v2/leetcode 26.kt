package com.harera.leetcode.leetcode26v2


class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        var duplicated = 0
        for (idx in 0 until nums.lastIndex) {
            if (nums[idx] == nums[idx + 1]){
                nums[idx] = Int.MIN_VALUE
                duplicated++
            }
        }
        var i = 0
        var j = 1
        while (i < nums.size && j < nums.size) {
            if (nums[i] == Int.MIN_VALUE) {
                if (nums[j] != Int.MIN_VALUE) {
                    nums[i] = nums[j]
                    nums[j] = Int.MIN_VALUE
                } else {
                    i--
                }
            }
            i++
            j++
        }
        return nums.size - duplicated
    }
}

fun main() {
    val solution = Solution()
    println(solution.removeDuplicates(intArrayOf(1,1,2)))
}

