package com.harera.leetcode.leetcode6

import kotlin.math.min

class Solution {
    fun convert(s: String, numRows: Int): String {
        if (numRows == 1)
            return s

        var char = 0
        val columns = mutableListOf<CharArray>()
        while (char < s.length) {
            if (columns.size % (numRows - 1) == 0) {
                columns.add(s.substring(char, min(s.length, char + numRows)).toCharArray())
                char += numRows
            } else {
                val chars = CharArray(numRows) { '$' }
                chars[numRows - columns.size % (numRows - 1) - 1] = s[char]
                columns.add(chars)
                char++
            }
        }
        var result = ""
        for (row in 0 until numRows) {
            columns.forEach {
                if (row < it.size && it[row] != '$')
                    result += it[row]
            }
        }
        return result
    }
}

fun main() {
    val solution = Solution()
    println(
        solution.convert(
            "Apalindromeisaword,phrase,number,orothersequenceofunitsthatcanbereadthesamewayineitherdirection,withgeneralallowancesforadjustmentstopunctuationandworddividers.",
            2
        )
    )
}