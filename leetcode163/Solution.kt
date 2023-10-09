package com.harera.leetcode.leetcode163


class Solution {
    /**
     * @param nums: a sorted integer array
     * @param lower: An integer
     * @param upper: An integer
     * @return: a list of its missing ranges
     */
    fun findMissingRanges(nums: IntArray, lower: Int, upper: Int): List<String> {
        val result = mutableListOf<String>()

        if (nums.isEmpty()) {
            getRange(lower, upper, result)
            if (lower == upper)
                result.add(lower.toString())
            return result
        }

        if (nums[0] > lower)
            result += "$lower->${nums[0]}"

        for (idx in 1..nums.lastIndex) {
            getRange(nums[idx - 1], nums[idx], result)
        }

        if (nums.last() < upper)
            result += "${nums.last() + 1}->$upper"

        return result
    }

    private fun getRange(left: Int, cur: Int, result: MutableList<String>) {
        if (cur - left == 2)
            result.add("${left + 1}")

        if (cur - left > 2)
            result.add("${left + 1}->${cur - 1}")
    }
}

fun main() {
    Solution().findMissingRanges(intArrayOf(0, 1, 2, 3, 7), 0, 7).also {
        println(it)
    }
}