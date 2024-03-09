package com.harera.leetcode.leetcode10

class Solution {

    fun isMatch(s: String, p: String): Boolean {
        return check(s, p, idx = 0)
    }

    private fun check(s: String, p: String, idx: Int): Boolean {
        if (idx > p.lastIndex || idx > s.lastIndex) {
            if (p == s) return true
            if (p.all { it == '.' } && p.length == s.length) return true
            return false
        }

        if (p[idx].isLowerCase()) {
            return check(s, p, idx + 1)
        } else if (p[idx] == '*') {
            var _p = p.substring(0, idx + 1).dropLast(2) + p.substring(idx + 1, p.length)
            val ignore = check(s, _p, idx - 1)
            _p = p.substring(0, idx) + p[idx - 1] + p.substring(idx + 1, p.length)
            val match = check(s, _p, idx + 1)
            _p = p.substring(0, idx) + p[idx - 1] + '*' + p.substring(idx + 1, p.length)
            return ignore || match || check(s, _p, idx + 1)
        } else {
            var _p = p.substring(0, idx) + s[idx] + p.substring(idx + 1, p.length)
            return check(s, _p, idx + 1) || check(s, p, idx + 1)
        }
    }
}

fun main() {
    val solution = Solution()
    println(solution.isMatch("aab", "c*a*b"))
}
