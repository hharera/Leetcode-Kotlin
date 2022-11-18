package com.harera.leetcode.leetcode424


class Solution {
    fun characterReplacement(s: String, k: Int): Int {
        var globalLongest = 0
        var globalChar = s[0]
        var longest = 1
        var char = s[0]
        for (idx in 1..s.lastIndex) {
            if (char == s.get(idx)) {
                longest++
            } else {
                if (longest > globalLongest) {
                    globalLongest = longest
                    globalChar = char
                }
                char = s[idx]
                longest = 1
            }
        }
        if (longest > globalLongest) {
            globalLongest = longest
            globalChar = char
        }
        var subString = ""
        for (idx in 1..globalLongest) {
            subString = subString.plus(globalChar)
        }
        val sourceIdxOfSubString = s.indexOf(subString)
        val destinationIdxOfSubString = sourceIdxOfSubString + globalLongest - 1

        var counter = k
        for (idx in sourceIdxOfSubString - 1 downTo 0) {
            if (s[idx] == globalChar) {
                globalLongest++
            } else {
                if (counter <= 0) {
                    break
                }
                globalLongest++
                counter--
            }
        }
        for (idx in destinationIdxOfSubString + 1..s.lastIndex) {
            if (s[idx] == globalChar) {
                globalLongest++
            } else {
                if (counter <= 0) {
                    break
                }
                globalLongest++
                counter--
            }
        }

        return globalLongest
    }
}


fun main() {
    val solution = Solution()
    println(solution.characterReplacement("ABBB", 2))
}