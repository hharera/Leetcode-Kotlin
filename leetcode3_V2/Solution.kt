package com.harera.leetcode.leetcode3_V2


class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        val charSet = s.toSet()
        var answer = 0
        var string = ""

        if (s.length <= 2)
            string = s

        if (s.length > 2) {
            string = s.substring(0, 2)
            for (idx in 2..s.lastIndex) {
                if (s[idx] != s[idx - 1] || s[idx - 1] != s[idx - 2]) {
                    string = string.plus(s[idx])
                }
            }
        }

        for (idx in 0..string.lastIndex) {
            val dfs = dfs(string, idx, emptySet(), charSet)
            answer = maxOf(dfs, answer)
            if (answer >= charSet.size) {
                return answer
            }
        }
        return answer
    }


    fun dfs(string: String, idx: Int, visited: Set<Char>, charSet: Set<Char>): Int {
        if (visited.size >= charSet.size)
            return visited.size

        if (idx == string.length)
            return visited.size

        if (visited.contains(string[idx]))
            return visited.size

        return dfs(string, idx + 1, visited.plus(string[idx]), charSet)
    }
}


fun main() {
    Solution().lengthOfLongestSubstring("abcabcbb")
        .let {
            println(it)
        }
}