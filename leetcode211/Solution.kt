package com.harera.leetcode.leetcode211


class TrieNode() {
    var end = false
    val chars = Array<TrieNode?>(26) { null }
}

class WordDictionary() {

    private val head = TrieNode()

    fun addWord(word: String) {
        var _head = head
        for (idx in word.indices) {
            val c = word[idx]
            if (_head.chars[c - 'a'] == null)
                _head.chars[c - 'a'] = TrieNode()
            _head = _head.chars[c - 'a']!!

            if (idx == word.lastIndex)
                _head.end = true
        }
    }

    fun search(word: String): Boolean {
        return search(head, 0, word)
    }

    fun search(trie: TrieNode, idx: Int, word: String): Boolean {
        if (idx > word.lastIndex)
            return true

        if (idx == word.lastIndex)
            if (trie.chars[word[idx] - 'a'] != null)
                return trie.chars[word[idx] - 'a']!!.end

        if (word[idx] == '.') {
            trie.chars.filterNotNull().forEach {
                if (search(it, idx + 1, word))
                    return true
            }
        } else if (trie.chars[word[idx] - 'a'] != null) {
            return search(trie.chars[word[idx] - 'a']!!, idx + 1, word)
        }
        return false
    }
}

fun main() {
    val solution = WordDictionary()
    //[[],["a"],["a"],["."],["a"],["aa"],["a"],[".a"],["a."]]
    solution.addWord("a")
    println(solution.addWord("a"))
    println(solution.addWord("a"))
    println(solution.search("."))
    println(solution.search("a"))
    println(solution.search("aa"))
    println(solution.search("a"))
    println(solution.search(".a"))
    println(solution.search("a."))

    /**
     * ["WordDictionary","addWord","addWord","addWord","addWord","search","search","addWord","search","search","search","search","search","search"]
     * [[],["at"],["and"],["an"],["add"],["a"],[".at"],["bat"],[".at"],["an."],["a.d."],["b."],["a.d"],["."]]
     */
}