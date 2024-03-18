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
            freq[it] = freq.getOrDefault(it, 0) + 1
        }

        val keys = freq.keys.sorted()
        for (start in 0..keys.size - k) {
            if (freq[keys[start]] == 0)
                continue

            for (end in start until start + k - 1) {
                if (keys[end + 1]!! - keys[end]!! != 1 || freq[keys[end + 1]]!! < freq[keys[end]]!!)
                    return false
            }
            val baseFreq = freq[keys[start]]
            for (end in start until start + k) {
                freq[keys[end]] = freq[keys[end]]!! - baseFreq!!
            }
        }
        return freq.values.all { it == 0 }
    }
}

fun main() {
    val solution = Solution()
    println(solution.isPossibleDivide(intArrayOf(16, 21, 26, 35), 4))
    println(solution.isPossibleDivide(intArrayOf(1, 2, 3, 3, 4, 4, 5, 6), 4))
    println(solution.isPossibleDivide(intArrayOf(3, 2, 1, 2, 3, 4, 3, 4, 5, 9, 10, 11), 3))
    println(solution.isPossibleDivide(intArrayOf(1, 2, 2, 3, 4, 4, 5, 6, 7, 7, 8, 9), 4))
}