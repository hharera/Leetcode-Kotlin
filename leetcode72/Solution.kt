package com.harera.leetcode.leetcode72

import kotlin.math.min

class Solution {

    private val visited = HashMap<String, Int>()

    fun minDistance(word1: String, word2: String): Int {
        return solve(idx1 = 0, idx2 = 0, word1, word2)
    }

    private fun solve(idx1: Int, idx2: Int, word1: String, word2: String, ops: Int = 0): Int {
        if (word1 == word2)
            return ops
        if (idx1 > word1.lastIndex) return Int.MAX_VALUE
        if (idx2 > word2.lastIndex) return Int.MAX_VALUE

        if (visited.contains(word1)) return visited.getOrDefault(word1, 0)
        var result = Int.MAX_VALUE

        if (word1[idx1] == word2[idx2])
            result = min(result, solve(idx1 + 1, idx2 + 1, word1, word2, ops))

        var newWord1 = word1.substring(0, idx1).plus(word2[idx2]).plus(word1.substring(idx1 + 1, word1.length))
        result = min(result, solve(idx1 + 1, idx2 + 1, newWord1, word2, ops + 1))

        newWord1 = word1.substring(0, idx1).plus(word2[idx2]).plus(word1.substring(idx1, word1.length))
        result = min(result, solve(idx1 + 1, idx2, newWord1, word2, ops + 1))

        newWord1 = word1.substring(0, idx1).plus(word1.substring(idx1 + 1, word1.length))
        result = min(result, solve(idx1 + 1, idx2, newWord1, word2, ops + 1))

        return result.also {
            visited[word1] = it
        }
    }
}

fun main() {
    val solution = Solution()
    solution.minDistance("horse", "ros").also {
        println(it)
    }
}