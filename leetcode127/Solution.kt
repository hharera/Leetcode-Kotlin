package com.harera.leetcode.leetcode127

class Solution {

    private val visited = HashMap<String, Int>()
    fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {
        if (!wordList.contains(endWord))
            return 0
        val solution = solve(beginWord, endWord, wordList.toSet(), setOf(beginWord))

        if (solution == Int.MAX_VALUE)
            return 0
        return solution
    }

    private fun solve(
        beginWord: String,
        endWord: String,
        wordList: Set<String>,
        selectedWords: Set<String>
    ): Int {
        if (beginWord == endWord)
            return selectedWords.size

        var result = Int.MAX_VALUE
        for (idx in beginWord.indices) {
            for (c in 'a'..'z') {
                val newWord = beginWord.substring(0, idx) + c + beginWord.substring(idx + 1)
                if (newWord != beginWord &&
                    wordList.contains(newWord) &&
                    !selectedWords.contains(newWord)
                ) {
                    val solve = solve(newWord, endWord, wordList, selectedWords.plus(newWord))
                    result = minOf(result, solve)
                }
            }
        }
        return result
    }
}


fun main() {
    val solution = Solution()
    println(
        solution.ladderLength(
            "hit",
            "cog",
            listOf("hot", "dot", "dog", "lot", "log", "cog")
        )
    )
    println(
        solution.ladderLength(
            "hot",
            "dog",
            listOf("hot", "dog", "cog", "pot", "dot")
        )
    )
}