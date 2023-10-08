package com.harera.leetcode.leetcode1248

class Solution {

    fun numberOfSubarrays(nums: IntArray, k: Int): Int {
        val cumulative = IntArray(nums.size + 1)
        for (idx in 0..nums.lastIndex) {
            val it = nums[idx]
            if (isOdd(it))
                cumulative[idx + 1] = 1
            else
                cumulative[idx + 1] = 0
        }

        for (idx in 1..cumulative.lastIndex) {
            cumulative[idx] += cumulative[idx - 1]
        }

        val kOddFrequency = HashMap<Int, Int>()
        cumulative.forEach {
            kOddFrequency[it] = kOddFrequency.getOrDefault(it, 0) + 1
        }

        var ans = 0
        kOddFrequency.keys.forEach {
            if (it == k)
                ans += kOddFrequency[it]!!
            else if (kOddFrequency.containsKey(it - k))
                ans += kOddFrequency[it - k]!! * kOddFrequency[it]!!
        }

        return ans
    }

    fun isOdd(target: Int): Boolean {
        return target % 2 != 0
    }
}

fun main() {
    val solution = Solution()
//    [2,4,6]
    println(solution.numberOfSubarrays(intArrayOf(2, 4, 6), 1))
    println(solution.numberOfSubarrays(intArrayOf(1, 1, 2, 1, 1), 3))
    println(solution.numberOfSubarrays(intArrayOf(2, 2, 2, 1, 2, 2, 1, 2, 2, 2), 2))
    println(solution.numberOfSubarrays(intArrayOf(2044, 96397, 50143), 1))
}