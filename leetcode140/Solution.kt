package com.harera.leetcode.leetcode140

class Solution {
    fun wordBreak(s: String, wordDict: List<String>): List<String> {
        return solve(wordDict, target = s)
    }

    private fun solve(wordDict: List<String>, source: String = "", target: String): List<String> {
        if (source.replace(" ", "") == target) {
            return listOf(source.trim())
        }

        if (source.replace(" ", "").length > target.length)
            return emptyList()

        if (source.isNotBlank()) {
            var idx = 0
            val _source = source.replace(" ", "")
            while (idx < _source.length && idx < target.length) {
                if (_source[idx] != target[idx]) {
                    return emptyList()
                }
                idx++
            }
        }

        val result = mutableListOf<String>()
        for (word in wordDict) {
            result += solve(wordDict, "$source $word", target)
        }
        return result
    }
}

fun main() {
    val solution = Solution()
//    println(solution.wordBreak("catsanddog", listOf("cat", "cats", "and", "sand", "dog")))
//    println(solution.wordBreak("pineapplepenapple", listOf("apple","pen","applepen","pine","pineapple")))
    println(solution.wordBreak("aaaaaaa", listOf("aaaa", "aa", "a")))
}