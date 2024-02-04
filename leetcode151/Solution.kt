package com.harera.leetcode.leetcode151

import java.lang.String.join

class Solution {
    fun reverseWords(s: String): String {
        val words = mutableListOf<String>()
        var idx = 0
        while (idx < s.length) {
            var str = ""
            while (idx < s.length && s[idx] != ' ') {
                str += s[idx]
                idx++
            }
            if (str.isNotEmpty())
                words.add(str)
            idx++
        }
        return join(" ", words.reversed())
    }
}

fun main() {
    println(Solution().reverseWords("the sky is blue"))
    println(Solution().reverseWords("  hello world  "))
    println(Solution().reverseWords("a good   example"))
    println(Solution().reverseWords("  Bob    Loves  Alice   "))
    println(Solution().reverseWords("Alice does not even like bob"))
}