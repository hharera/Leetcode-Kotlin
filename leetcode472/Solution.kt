package com.harera.leetcode.leetcode472

//
//class Solution {
//
//    private var visited = HashMap<String, Int>()
//    private lateinit var wordSet: Set<String>
//    private var root = TrieNode()
//
//    fun findAllConcatenatedWordsInADict(words: Array<String>): List<String> {
//        wordSet = words.toSet()
//        wordSet.forEach {
//            buildTrie(it)
//        }
//
//        val result = mutableListOf<String>()
//        words.forEach {
//            if (it.length > 1 && solve(it)) {
//                result.add(it)
//            }
//        }
//        return result
//    }
//
//    private fun buildTrie(word: String) {
//        var _root = root
//        word.forEachIndexed { index, char ->
//            _root.chars[char - 'a'] = _root.chars.getOrElse(char - 'a') {
//                TrieNode()
//            }.also {
//                it!!.end = false
//                if (index == word.lastIndex)
//                    it.end = true
//
//                _root = it
//            }
//        }
//    }
//
//    private fun solve(trie: TrieNode, combinedWord: String = "", wordsCount: Int = 0): Int {
//        if (trie.end) {
//            if (wordSet.contains(combinedWord) && wordsCount > 0)
//                return
//            if (combinedWord.isBlank() && wordsCount > 1)
//                return
//
//        }
//
//
//        if (visited.contains(createdWord))
//            return visited[createdWord]!!
//
//        solve()
//
//
//        if (words.containsAll(createdWord.toCharArray().map { it.toString() })) {
//            return true
//        }
//
//        for (left in createdWord.indices) {
//            for (right in left + 1..createdWord.lastIndex) {
//                if (left == 0 && right == createdWord.lastIndex)
//                    continue
//
//                if (words.contains(createdWord.substring(left, right + 1)))
//                    if (solve(createdWord.substring(right + 1, createdWord.length))) {
//                        return true
//                    }
//            }
//        }
//        return false
//    }
//}
//
//class TrieNode() {
//    var end = false
//    val chars = Array<TrieNode?>(26) { null }
//}
