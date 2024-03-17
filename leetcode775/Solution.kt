package com.harera.leetcode.leetcode775

class Solution {
    fun isIdealPermutation(nums: IntArray): Boolean {
        if (nums.size == 1)
            return true
        val indexes = IntArray(nums.size)
        nums.forEachIndexed { index, i ->
            indexes[i] = index
        }

        val sorted = nums.sorted()
        val sortedIndexes = IntArray(nums.size)
        sorted.forEachIndexed { index, i ->
            sortedIndexes[i] = index
        }

        if (nums.toList() == sorted.toList())
            return true

        var gCount = 0
        for (index in 1..nums.lastIndex) {
            val idx = indexes[nums[index]]
            val sidx = sortedIndexes[nums[index]]
            if (sorted.lastIndex - sidx <= idx) {
                gCount++
            }
        }

        var lCount = 0
        for (idx in 1..nums.lastIndex) {
            if (nums[idx] < nums[idx - 1])
                lCount++
        }
        return lCount == gCount
    }
}

fun main() {
    val solution = Solution()
    val nums = intArrayOf(1, 0)
    println(solution.isIdealPermutation(nums))
}