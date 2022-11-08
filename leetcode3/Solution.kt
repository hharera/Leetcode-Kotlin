package com.harera.leetcode.leetcode3


class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        var longest = 0
        var count = 0
        var c = 0
        val set: MutableMap<Char?, Int?> = HashMap()
        for (i in 0 until s.length) {
            val cur = s[i]
            if (set.containsKey(cur)) {
                c = Integer.max(c, set[cur]!!)
                longest = Integer.max(longest, count)
                count = i - c
                set[cur] = i
            } else {
                set[cur] = i
                count++
            }
        }
        return Integer.max(longest, count)
    }
}


fun main() {
    Solution().lengthOfLongestSubstring("abcabcbb").let {
        println(it)
    }
}