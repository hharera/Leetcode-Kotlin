package com.harera.leetcode.leetcode301

class Solution {

    fun removeInvalidParentheses(s: String): List<String> {
        return solve(s, idx = 0, open = 0, close = 0, openIdx = 0, closeIdx = 0).groupBy {
            it.length
        }.let {
            it[it.keys.max()] ?: emptyList()
        }
    }

    private fun solve(s: String, idx: Int, open: Int, close: Int, openIdx: Int, closeIdx: Int): Set<String> {
        if (idx > s.lastIndex) {
            if (open == close) {
                return setOf(s)
            }
            return emptySet()
        }

        var result = emptySet<String>()
        if (s[idx] == '(') {
            val leave = s.substring(0, idx) + s.substring(idx + 1, s.length)
            result = solve(leave, idx, open, close, openIdx, closeIdx) +
                    solve(s, idx + 1, open + 1, close, openIdx, closeIdx)
        } else if (s[idx] == ')') {
            if (open > close) {
                val leave = s.substring(0, idx) + s.substring(idx + 1, s.length)
                result = solve(leave, idx, open, close, openIdx, closeIdx) +
                        solve(s, idx + 1, open, close + 1, openIdx, closeIdx)
            } else {
                val leave = s.substring(0, idx) + s.substring(idx + 1, s.length)
                result = solve(leave, idx, open, close, openIdx, closeIdx)
            }
        } else {
            result = solve(s, idx + 1, open, close, openIdx, closeIdx)
        }
        return result
    }
}

fun main() {
    println(Solution().removeInvalidParentheses("()())()"))
}