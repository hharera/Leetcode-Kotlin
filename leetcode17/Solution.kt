package com.harera.leetcode.leetcode17

class Solution {

    private val digitToCharList = arrayOf(
        arrayOf('a', 'b', 'c'),
        arrayOf('d', 'e', 'f'),
        arrayOf('g', 'h', 'i'),
        arrayOf('j', 'k', 'l'),
        arrayOf('m', 'n', 'o'),
        arrayOf('p', 'q', 'r', 's'),
        arrayOf('t', 'u', 'v'),
        arrayOf('w', 'x', 'y', 'z')
    )
    private val solutions = mutableListOf<String>()

    fun letterCombinations(digits: String): List<String> {
        if (digits.isBlank())
            return emptyList()

        findStrings(digits, 0, "")
        return solutions
    }

    fun findStrings(digits: String, idx: Int, str: String) {
        if (idx >= digits.length) {
            solutions.add(str)
            return
        }

        digitToCharList[digits[idx] - '2'].forEach {
            findStrings(digits, idx + 1, str + it)
        }
    }
}

fun main() {
    val solution = Solution()
    println(solution.letterCombinations("23"))
}