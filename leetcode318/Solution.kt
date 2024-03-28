package com.harera.leetcode.leetcode318

import kotlin.math.max

class Solution {
    fun maxProduct(words: Array<String>): Int {
        val wordCharsSet = words.map {
            it.toSet()
        }

        if (wordCharsSet.size == 1) {
            return 0
        }

        var maxProduct = 0
        for (idx in 0..wordCharsSet.lastIndex) {
            val word = wordCharsSet[idx]
            for (other in idx + 1..wordCharsSet.lastIndex) {
                val otherWord = wordCharsSet[other]
                if (word.any { otherWord.contains(it) })
                    continue
                maxProduct = max(maxProduct, words[idx].length * words[other].length)
            }
        }
        return maxProduct
    }
}

fun main() {
    println(
        Solution().maxProduct(
            arrayOf(
                "abaacwa", "baz", "foo", "bar", "xtxxfn", "abcdef"
            )
        )
    )
}