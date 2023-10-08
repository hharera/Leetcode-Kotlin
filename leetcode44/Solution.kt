package com.harera.leetcode.leetcode44

class Solution {

    val dp = HashMap<String, Boolean>()

    fun isMatch(s: String, p: String): Boolean {
        return solve(s, p)
    }

    fun solve(s: String, p: String): Boolean {
        if (s.isEmpty() && (p.isEmpty() || (p.toSet().run { contains('*') && size == 1 }))) {
            return true
        }
        if (s.isEmpty()) {
            return false
        }
        if (p.isEmpty())
            return false

        if (dp.contains("$s,$p")) {
            return dp.get("$s,$p")!!
        }

        var result = false
        if (p[0].isLetter() && s[0] != p[0]) {
            return false
        }
        if (p[0] == '*' && s[0] != p[0]) {
            result = solve(s, p.drop(1)) ||
                    solve(s.drop(1), p)
        }

        result =  result || solve(s.drop(1), p.drop(1))
        dp["$s,$p"] = result
        return result
    }
}

fun main() {
    val solution = Solution()
    println(solution.isMatch("babaaababaabababbbbbbaabaabbabababbaababbaaabbbaaab", "***bba**a*bbba**aab**b"))
}
