package com.harera.leetcode.leetcode10

class Solution {

    fun isMatch(s: String, p: String): Boolean {
        return check(s, p)
    }

    private fun check(s: String, p: String): Boolean {
        val pE = p[0]
        val sE = s[0]
        if (p.length > 1 && p.get(1) == '*') {
            if (pE.isLetter() && pE != sE)
                return check(s, p.substring(2))
            else {
                return check(s.substring(1), p.substring(2)) ||
                        check(s.substring(1), p) ||
                        check(s, p.substring(2))
            }
        } else if (pE.isLetter() && pE != sE) {
            return false
        }

        return check(s.substring(1), p.substring(1))
    }
}

fun main() {
    val solution = Solution()
    println(solution.isMatch("a", "ab*"))
}
