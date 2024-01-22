package com.harera.leetcode.leetcode809

class Solution {
    fun expressiveWords(s: String, words: Array<String>): Int {
        var answer = 0
        words.forEach {
            if (check(s, it, i = 0, j = 0))
                answer++
        }
        return answer
    }

    private fun check(left: String, right: String, i: Int, j: Int): Boolean {
        if (right.length > left.length)
            return false
        if (i > left.lastIndex && j > right.lastIndex)
            return true
        if (i > left.lastIndex)
            return false
        if (j > right.lastIndex)
            return false

        if (left[i] != right[j])
            return false

        countChars(i, j, left, right).also {
            if (it.first - i < it.second - j)
                return false
            if ((it.first - i) < 3 && it.first - i != it.second - j)
                return false
            return check(left, right, it.first, it.second)
        }
    }

    private fun countChars(i: Int, j: Int, left: String, right: String): Pair<Int, Int> {
        var leftCount = 0
        var rightCount = 0
        var leftChar = left[i]
        var rightChar = right[j]
        var i = i
        var j = j
        while (i <= left.lastIndex && left[i] == leftChar) {
            leftCount++
            i++
        }
        while (j <= right.lastIndex && right[j] == rightChar) {
            rightCount++
            j++
        }
        return Pair(i, j)
    }
}

fun main() {
    println(Solution().expressiveWords("heeellooo", arrayOf("hello", "hi", "helo")))
}