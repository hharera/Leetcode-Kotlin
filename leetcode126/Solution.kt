package com.harera.leetcode.leetcode126

class Solution {

    private val visited = HashMap<String, List<List<String>>>()
    fun findLadders(beginWord: String, endWord: String, wordList: List<String>): List<List<String>> {
        if(!wordList.contains(endWord))
            return emptyList()

        return solve(beginWord, endWord, wordList, mutableSetOf(beginWord))
    }

    private fun solve(beginWord: String, endWord: String, wordList: List<String>, selectedWords: MutableSet<String>): List<List<String>> {
        if (beginWord == endWord)
            return listOf(selectedWords.toList())

        if (visited.contains(beginWord))
            return visited[beginWord]!!

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

        var answer = emptyList<List<String>>()
        nextWords.forEach {
            selectedWords.add(it)
            answer += solve(it, endWord, wordList, selectedWords)
            selectedWords.remove(it)
        }

        if (answer.isEmpty())
            return emptyList()

        val shortsLength = answer.minBy { it.size }.size
        return answer.filter {
            it.size <= shortsLength
        }.also {
            visited[beginWord] = it
        }
    }
}

fun main() {
    val solution = Solution()
    println(
        solution.findLadders(
            "qa",
            "sq",
            listOf("si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye")
        )
    )
}