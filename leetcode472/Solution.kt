package com.harera.leetcode.leetcode472


class Solution {

    private lateinit var wordSet: Set<String>
    private var root = TrieNode()

    fun findAllConcatenatedWordsInADict(words: Array<String>): List<String> {
        wordSet = words.toSet()
        wordSet.forEach {
            buildTrie(it)
        }

        val result = mutableListOf<String>()
        words.forEach {
            if (it.length > 1 && countEnds(root, it, idx = 0) > 1) {
                result.add(it)
            }
        }
        return result
    }

    private fun buildTrie(word: String) {
        var _root = root
        word.forEachIndexed { index, char ->
            if (_root.chars[char - 'a'] == null) {
                _root.chars[char - 'a'] = TrieNode().also {
                    if (index == word.lastIndex)
                        it.end = true
                }
            }
            _root = _root.chars[char - 'a']!!
        }
    }

    private fun countEnds(trie: TrieNode, word: String, idx: Int = 0): Int {
        if (idx > word.lastIndex) {
            return 0
        }

        if (trie.chars[word[idx] - 'a'] == null)
            return 0

        var answer = 0
        if (trie.chars[word[idx] - 'a']!!.end)
            answer += 1

        return answer + countEnds(trie.chars[word[idx] - 'a']!!, word, idx + 1)
    }

    class TrieNode {
        var end = false
        val chars = Array<TrieNode?>(26) { null }
    }
}


fun main() {
    val solution = Solution()
    println(solution.findAllConcatenatedWordsInADict(arrayOf("cat", "cats", "dog", "catdog")))
}
