package com.harera.leetcode.leetcode72

import kotlin.math.min

class Solution {

    private val visited = hashSetOf<String>()

    fun minDistance(word1: String, word2: String): Int {
        return solve(word1, word2, 0, 0)
    }

    private fun solve(word1: String, word2: String, idx: Int, steps: Int): Int {
        if (word1 == word2) {
            return steps
        }
        if (idx > word1.lastIndex)
            return Int.MAX_VALUE
        if (visited.contains(word1))
            return steps
        visited.add(word1)

        var result = Int.MAX_VALUE

        if (word1.length < word2.length)
            for (char in 0..26) {
                var solve = solve(
                    word1.substring(0, idx).plus('a' + char).plus(word1.substring(idx, word1.length)),
                    word2,
                    idx + 1,
                    steps + 1
                )
                result = min(result, solve)
                solve = solve(
                    word1.substring(0, idx + 1).plus('a' + char).plus(word1.substring(idx + 1, word1.length)),
                    word2,
                    idx + 1,
                    steps + 1
                )
                result = min(result, solve)
            }

        if (word1.length > word2.length) {
            val solve = solve(
                word1.substring(0, idx).plus(word1.substring(idx + 1, word1.length)),
                word2,
                idx,
                steps + 1
            )
            result = min(result, solve)
        }

        if (word1.length == word2.length) {
            for (char in 0..25) {
                val solve = solve(
                    word1.substring(0, idx).plus('a' + char).plus(word1.substring(idx + 1, word1.length)),
                    word2,
                    idx + 1,
                    steps + 1
                )
                result = min(result, solve)
            }
        }

        val solve = solve(
            word1,
            word2,
            idx + 1,
            steps
        )
        return min(result, solve)
    }
}

fun main() {
    val solution = Solution()
    println(solution.minDistance("sea", "eat"))
    println(solution.minDistance("leetcode", "etco"))
    println(solution.minDistance("dinitrophenylhydrazine", "acetylphenylhydrazine"))
}