package com.harera.leetcode.leetcode127

class Solution {

    private val visited = HashMap<String, Int>()
    fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {
        if (!wordList.contains(endWord))
            return 0

        solve(beginWord, endWord, wordList, mutableSetOf(beginWord)).also {
            if (it == Int.MAX_VALUE)
                return 0
            return it
        }
    }

    private fun solve(
        beginWord: String,
        endWord: String,
        wordList: List<String>,
        selectedWords: Set<String>
    ): Int {
        if (beginWord == endWord)
            return selectedWords.size

//        if (visited.contains(beginWord))
//            return visited[beginWord]!!

        val nextWords = hashSetOf<String>()
        wordList.forEach { word ->
            if (!selectedWords.contains(word)) {
                var idx = 0
                beginWord.count { char ->
                    char != word[idx++]
                }.also {
                    if (it == 1)
                        nextWords.add(word)
                }
            }
        }

        val answer = mutableListOf<Int>()
        nextWords.forEach {
            answer.add(solve(it, endWord, wordList, selectedWords.plus(it)))
        }

        return (answer.minOrNull() ?: Int.MAX_VALUE).also {
            visited[beginWord] = it
        }
    }
}


fun main() {
    val solution = Solution()
    println(
        solution.ladderLength(
            "hot",
            "dog",
            listOf("hot","dog","cog","pot","dot")
        )
    )
}