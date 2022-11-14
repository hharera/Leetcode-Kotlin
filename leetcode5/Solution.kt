package com.harera.leetcode.leetcode5

import java.util.Comparator

class Solution {
    fun longestPalindrome(s: String): String {
        if (s.length == 1)
            return s

        val pairs = mutableListOf<Pair<Int, Int>>()

        for (left in 0..s.lastIndex) {
            for (right in left..s.lastIndex) {
                if (s[right] == s[left]) {
                    pairs.add(Pair(left, right))
                }
            }
        }

        pairs.sortBy { (it.second - it.first) + 1 }

        val comparator = Comparator<Pair<Int, Int>> { p0, p1 -> (p1!!.second - p1.first) + 1 - ((p0!!.second - p0.first) + 1) }
        pairs.sortWith(comparator)

        pairs.forEach {
            var left = it.first
            var right = it.second

            while (left <= right) {
                if (s[left] != s[right])
                    break
                left++
                right--
            }

            if (left > right) {
                return s.substring(it.first, it.second + 1)
            }
        }
        return s[0].toString()
    }
}

fun main() {
    val solution = Solution()
    println(solution.longestPalindrome("cbbd"))
}