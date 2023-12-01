package com.harera.leetcode.leetcode1296

class Solution {

    private val map = HashMap<Int, Int>()

    fun isPossibleDivide(nums: IntArray, k: Int): Boolean {
        if ((nums.sum() / k) % k != 0) {
            return false
        }

        nums.forEach {
            map[it] = map.getOrDefault(it, 0) + 1
        }

        val eachSize = nums.sum() / k
        for (idx in 1..k) {
            createSubArray(keys = nums, remaining = eachSize, array = listOf())
        }
    }

    private fun createSubArray(
        idx: Int = 0,
        keys: IntArray,
        remaining: Int,
        array: List<Int>
    ): List<Int>? {
        if (idx > keys.lastIndex)
            return null
        if (remaining < 0)
            return null
        if (remaining == 0)
            return array

        createSubArray(idx + 1, keys, remaining - keys[idx], array.plus(keys[idx]))
    }
}

fun main() {
    val solution = Solution()
    solution.isPossibleDivide(intArrayOf(1, 2, 3, 3, 4, 4, 5, 6), 4).also {
        println(it)
    }
}