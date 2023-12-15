package com.harera.leetcode.leetcode269


class Solution {

    fun alienOrder(words: Array<String>): String {
        val chars = Array(26) { -1 }

        val lastIdx = words.maxOf {
            it.lastIndex
        }

        var order = 0
        for (charIdx in 0..lastIdx) {
            for (word in words) {
                if (charIdx > word.lastIndex)
                    continue
                if (chars[word[charIdx] - 'a'] == -1)
                    chars[word[charIdx] - 'a'] = order++
            }
        }

        val minIdx = words.minOf {
            it.lastIndex
        }
        for (charIdx in 0..minIdx) {
            for (wordIdx in 1..words.lastIndex) {
                val word = words[wordIdx]
                if (chars[word[charIdx] - 'a'] < chars[words[wordIdx - 1][charIdx] - 'a'])
                    return ""
            }
        }

        val length = chars.count {
            it != -1
        }
        val answer = CharArray(length)
        return chars.forEachIndexed { index, it ->
            if (it != -1)
                answer[it] = 'a' + index
        }.let {
            answer.joinToString("")
        }
    }
}


fun main() {
    val solution = Solution()
//    println(solution.alienOrder(arrayOf("zy", "zx")))
//    println(solution.alienOrder(arrayOf("abc", "ab")))
//    println(solution.alienOrder(arrayOf("abc", "bcd", "qwert", "ab")))
//    println(solution.alienOrder(arrayOf("z", "x")))
//    println(solution.alienOrder(arrayOf("z", "x", "z")))
    println(solution.alienOrder(arrayOf("wrt", "wrf", "er", "ett", "rftt")))
}