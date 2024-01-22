package com.harera.leetcode.leetcode3_V3


class Solution {

    fun expressiveWords(target: String, words: Array<String>): Int {
        var answer = 0
        words.forEach { source ->
            if (isStretchy(source, 0, target))
                answer++
        }
        return answer
    }

    private fun isStretchy(source: String, idx: Int, target: String): Boolean {
        if (idx > source.lastIndex || source.length >= target.length)
            return source == target

        val next = source.substring(0, idx + 1) + source[idx] + source.substring(idx + 1, source.length)
        return isStretchy(next, idx + 1, target) || isStretchy(source, idx + 1, target)
    }
}


fun main() {
}