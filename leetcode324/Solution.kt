package com.harera.leetcode.leetcode324

class Solution {
    fun wiggleSort(nums: IntArray): Unit {
        nums.sort()
        val mid = nums.size / 2 - (if (nums.size % 2 == 0) 1 else 0)
        var i = mid
        var j = nums.lastIndex
        val answer = mutableListOf<Int>()
        while (i >= 0 && j > mid) {
            answer.add(nums[i])
            answer.add(nums[j])
            i--
            j--
        }
        if (nums.size % 2 != 0)
            answer.add(nums[0])

        nums.forEachIndexed { index, i ->
            nums[index] = answer[index]
        }
    }
}

fun main() {
    val solution = Solution()
    val nums = intArrayOf(1, 5, 1, 1, 6, 4)
    solution.wiggleSort(nums)
    println(nums.contentToString())

    val nums2 = intArrayOf(1, 1, 2, 1, 2, 2, 1)
    solution.wiggleSort(nums2)
    println(nums2.contentToString())
}