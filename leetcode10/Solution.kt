package com.harera.leetcode.leetcode10

class Solution {

    fun isMatch(s: String, p: String): Boolean {
        return check(s, p, idx = 0)
    }

    private fun check(s: String, p: String, idx: Int): Boolean {
        if (idx > p.lastIndex) {
            var i = 0
            while (i < s.length && i < p.length) {
                if (s[i] != p[i] && p[i] != '.')
                    return false
                i++
            }
            return i == s.length
        }

        if (p == s) return true

        if (p.length - (p.count { it == '*' } * 2) > s.length)
            return false

        if (p[idx] == '*') {
            if (p[idx - 1] == s[idx - 1] || p[idx - 1] == '.') {
                return check(s, p, idx + 1) || check(s.substring(1), p, idx)
            } else {
                return check(s, p, idx + 1)
            }

        } else {
            return check(s, p, idx + 1)
        }
    }
}

fun main() {
    val solution = Solution()
    println(solution.isMatch("aab", "ab*ac*a"))
}
