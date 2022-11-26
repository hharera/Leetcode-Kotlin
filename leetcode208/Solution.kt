package com.harera.leetcode.leetcode208


class Trie() {

    private val wordSet = mutableSetOf<String>()

    fun insert(word: String) {
        wordSet.add(word)
    }

    fun search(word: String): Boolean {
        return wordSet.contains(word)
    }

    fun startsWith(prefix: String): Boolean {
        wordSet.forEach {
            if (it.startsWith(prefix))
                return true
        }
        return false
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