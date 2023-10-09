package com.harera.leetcode.leetcode139

class Solution {

    private val dp = Array<Boolean?>(305) { null }

    fun wordBreak(raw: String, wordDict: List<String>): Boolean {
        return dfs(raw, 0, wordDict)
    }

    fun dfs(raw: String, idx: Int, wordDict: List<String>): Boolean {
        if (idx > raw.lastIndex)
            return true

        if (dp[idx] != null)
            return dp[idx]!!

        var result = false
        for (word in wordDict) {
            if (raw.startsWith(word, idx)) {
                result = result or dfs(raw, idx + word.length, wordDict)
            }
        }

        return result.also {
            dp[idx] = it
        }
    }
}


fun main() {
    // 8 test cases
    println(
        Solution().wordBreak(
            "leetcode224",
            listOf(
                "leet", "code"
            )
        )
    )
    println(
        Solution().wordBreak(
            "applepenapple",
            listOf(
                "apple", "pen"
            )
        )
    )
    println(
        Solution().wordBreak(
            "catsandog",
            listOf(
                "cats", "dog", "sand", "and", "cat"
            )
        )
    )
    println(
        Solution().wordBreak(
            "aaaaaaa",
            listOf(
                "aaaa", "aaa"
            )
        )
    )
    println(
        Solution().wordBreak(
            "cars",
            listOf(
                "car", "ca", "rs"
            )
        )
    )

    println(Solution().wordBreak("leetcode224", listOf("leet", "code")))
}