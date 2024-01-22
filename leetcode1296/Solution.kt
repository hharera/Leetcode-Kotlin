package com.harera.leetcode.leetcode1296

class Solution {
    fun isPossibleDivide(nums: IntArray, k: Int): Boolean {
        if (nums.size % k != 0)
            return false

        if (k == 1)
            return true

        if (k == nums.size)
            return nums.sorted().let {
                for (i in 0 until it.lastIndex) {
                    if (it[i + 1] - it[i] != 1)
                        return false
                }
                return true
            }

        val freq = hashMapOf<Int, Int>()
        nums.forEach {
            freq[freq.getOrDefault(it, 0) + 1]
        }

        val keys = freq.keys.sorted()
        for (start in 0..keys.lastIndex - k) {
            for (end in start until start + k) {
                if (freq[keys[end + 1]]!! - freq[keys[end]]!! != 1)
                    return false
            }
            for (end in start..start + k) {
                freq[keys[end]] = freq[keys[end]]!! - freq[keys[start]]!!
            }

            if (freq[keys[start]] != 0)
                return false
        }
        return true
    }
}

fun main() {
    val solution = Solution()
    println(solution.isPossibleDivide(intArrayOf(16, 21, 26, 35), 4))
}