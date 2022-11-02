package com.harera.leetcode.leetcode58

class Solution {
    fun lengthOfLastWord(s: String): Int {
        var result = arrayListOf<String>()

        var curString = ""
        s.forEach {
            if (it != ' ') {
                curString = curString.plus(it)
            } else {
                if (curString.length > 0)
                    result.add(curString)
                curString = ""
            }
        }

        return result.last().length
    }
}

fun main() {
    println(Solution().lengthOfLastWord("dfd           fdf     fdf     "))
}