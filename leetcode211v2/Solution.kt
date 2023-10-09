package com.harera.leetcode.leetcode211v2


class TrieNode() {
    var end = false
    val chars = Array<TrieNode?>(26) { null }
}

class WordDictionary() {

    private val head = HashSet<String>()

    fun addWord(word: String) {
        head.add(word)
    }

    fun search(word: String): Boolean {
        return search(word, 0)
    }

    fun search(word: String, idx: Int): Boolean {
        if (head.contains(word))
            return true
        if (idx > word.lastIndex)
            return false

        if (word[idx] == '.') {
            for (c in 'a'..'z') {
                if (search(
                        word.substring(0, idx) + c +
                                word.substring(idx + 1, word.length), idx + 1
                    )
                )
                    return true
            }
        } else if (search(word, idx + 1)) {
            return true
        }
        return false
    }
}

fun main() {
    val solution = WordDictionary()
    //["WordDictionary","addWord","addWord","addWord","addWord","search","search","addWord","search","search","search","search","search","search"]
    //[[],["at"],["and"],["an"],["add"],["a"],[".at"],["bat"],[".at"],["an."],["a.d."],["b."],["a.d"],["."]]
    solution.addWord("at")
    solution.addWord("and")
    solution.addWord("an")
    solution.addWord("add")
    solution.addWord("a")
    println(solution.search(".at"))
    solution.addWord("bat")
    println(solution.search(".at"))
    println(solution.search("an."))
    println(solution.search("a.d."))
    println(solution.search("b."))
    println(solution.search("a.d"))
}