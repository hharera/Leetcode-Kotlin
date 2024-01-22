package com.harera.leetcode.leetcode676

class MagicDictionary() {

    private val dictionary = HashSet<String>()

    fun buildDict(dictionary: Array<String>) {
        dictionary.forEach {
            this.dictionary.add(it)
        }
    }

    fun search(searchWord: String): Boolean {
        for (charIdx in 0..searchWord.lastIndex) {
            for (replacement in 0..25) {
                if (searchWord[charIdx] == 'a' + replacement)
                    continue

                buildString {
                    append(searchWord.substring(0, charIdx))
                    append('a' + replacement)
                    append(searchWord.substring(charIdx + 1))
                }.also {
                    if (dictionary.contains(it))
                        return true
                }
            }
        }
        return false
    }
}

fun main() {
    val solution = MagicDictionary()
//    ["MagicDictionary", "buildDict", "search", "search", "search", "search"]
//[[], [["hello","hallo","leetcode"]], ["hello"], ["hhllo"], ["hell"], ["leetcoded"]]
    solution.buildDict(arrayOf("hello", "hallo", "leetcode"))
    println(solution.search("hello"))
    println(solution.search("hhllo"))
    println(solution.search("hell"))
    println(solution.search("leetcoded"))
}
