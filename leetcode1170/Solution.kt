package com.harera.leetcode.leetcode1170


class Solution {

    private val wordFrequencies = mutableListOf<Int>()

    fun numSmallerByFrequency(queries: Array<String>, words: Array<String>): IntArray {
        words.forEachIndexed { index, word ->
            val chars = word.groupBy {
                it
            }
            val char = chars.keys.sorted()[0]
            wordFrequencies.add(chars[char]!!.size)
        }
        wordFrequencies.sort()
        val ans = mutableListOf<Int>()
        queries.forEach { word ->
            val chars = word.groupBy {
                it
            }
            val frequency = chars[chars.keys.sorted()[0]]!!.size
            (words.size - binarySearch(frequency))
                .let { ans.add(it) }
        }
        return ans.toIntArray()
    }

    private fun binarySearch(frequency: Int): Int {
        var start = 0
        var end = wordFrequencies.lastIndex
        var mid: Int
        while (start < end) {
            mid = (start + end) / 2
            val midVal = wordFrequencies[mid]
            if (midVal <= frequency)
                start = mid + 1
            else
                end = mid
        }
        if (wordFrequencies[start] <= frequency)
            return wordFrequencies.size
        return (start + end) / 2
    }
}

fun main() {
//    println(
//        Solution()
//            .numSmallerByFrequency(arrayOf("cbd"), arrayOf("zaaaz")).toMutableList()
//    )
    println(
        Solution()
            .numSmallerByFrequency(
                arrayOf(
                    "aabbabbb",
                    "abbbabaa",
                    "aabbbabaa",
                    "aabba",
                    "abb",
                    "a",
                    "ba",
                    "aa",
                    "ba",
                    "baabbbaaaa",
                    "babaa",
                    "bbbbabaa"
                ),
                arrayOf(
                    "b",
                    "aaaba",
                    "aaaabba",
                    "aa",
                    "aabaabab",
                    "aabbaaabbb",
                    "ababb",
                    "bbb",
                    "aabbbabb",
                    "aab",
                    "bbaaababba",
                    "baaaaa"
                )
            ).toMutableList()
    )
}
