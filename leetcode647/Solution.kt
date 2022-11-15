package com.harera.leetcode.leetcode647

class Solution {
    fun countSubstrings(s: String): Int {
        if (s.length == 1)
            return 1

        val pairs = mutableListOf<Pair<Int, Int>>()

        for (left in 0..s.lastIndex) {
            for (right in left..s.lastIndex) {
                if (s[right] == s[left]) {
                    pairs.add(Pair(left, right))
                }
            }
        }

        pairs.sortBy { (it.second - it.first) + 1 }

        val comparator =
            Comparator<Pair<Int, Int>> { p0, p1 -> (p1!!.second - p1.first) + 1 - ((p0!!.second - p0.first) + 1) }
        pairs.sortWith(comparator)


        var count = 0
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
                count++
            }
        }
        return count
    }
}

fun main() {
    val solution = Solution()
    println(solution.countSubstrings("aaa"))
}