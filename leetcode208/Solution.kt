package com.harera.leetcode.leetcode208


class TrieNode() {
    var end = false
    val chars = Array<TrieNode?>(26) { null }
}

class Trie() {

    val head = TrieNode()

    fun insert(word: String) {
        var _head = head
        for (idx in word.indices) {
            val c = word[idx]
            if (_head.chars[c - 'a'] == null) {
                _head.chars[c - 'a'] = TrieNode()
            }
            _head = _head.chars[c - 'a']!!
            if (idx == word.lastIndex)
                _head.end = true
        }
    }

    fun search(word: String): Boolean {
        var _head = head
        for (idx in word.indices) {
            val c = word[idx]
            if (_head.chars[c - 'a'] == null)
                return false
            _head = _head.chars[c - 'a']!!
            if (idx == word.lastIndex && _head.end)
                return true
        }
        return false
    }

    fun startsWith(prefix: String): Boolean {
        var _head = head
        for (c in prefix) {
            if (_head.chars[c - 'a'] == null)
                return false
            _head = _head.chars[c - 'a']!!
        }
        return true
    }
}


fun main() {
    Trie().apply {
        insert("apple")
        println(search("apple"))
        println(search("app"))
        println(startsWith("app"))
        insert("app")
        println(search("app"))
    }
}