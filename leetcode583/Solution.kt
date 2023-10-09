package com.harera.leetcode.leetcode583

import kotlin.math.max

class Solution {
    fun minDistance(word1: String, word2: String): Int {
        val words = HashMap<String, Int>()

        for (left in 0..max(word1.lastIndex, word2.lastIndex)) {
            for (right in left + 1..max(word1.lastIndex, word2.lastIndex)) {
                if (right < word1.length) {
                    val substring = word1.substring(left, right + 1)
                    words[substring] = words.getOrDefault(substring, 0) + 1
                }
                if (right < word2.length) {
                    val substring = word2.substring(left, right + 1)
                    words[substring] = words.getOrDefault(substring, 0) + 1
                }
            }
        }

        words.keys.sortedByDescending {
            it.length
        }.forEach {
            if (words[it]!! > 1)
                return it.length
        }
        return 0
    }
}

fun main() {
    val solution = Solution()
    println(solution.minDistance("a", "b"))
}