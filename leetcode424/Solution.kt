package com.harera.leetcode.leetcode424


class Solution {
    fun characterReplacement(s: String, k: Int): Int {
        val freq = IntArray(26) { 0 }
        var longest = 1
        var end = 0
        for (start in 0..s.lastIndex) {
            freq[s[start] - 'A']++
            longest = maxOf(longest, freq[s[start] - 'A'])

            if (end - start + 1 - longest > k) {
                freq[s[end] - 'A']--
                end++
            }
        }
        return s.length - end
    }
}


fun main() {
    val solution = Solution()
    println(solution.characterReplacement("ABBB", 2))
}