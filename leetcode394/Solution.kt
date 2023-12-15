package com.harera.leetcode.leetcode394

import java.util.*

class Solution {

    fun decodeString(s: String): String {

        var idx = 0
        var result = ""
        while (idx < s.length) {
            val char = s[idx]
            if (char.isDigit()) {
                result += extract(s, idx)
                idx += getLength(s, idx + 1) - 1
            } else {
                result += char
                idx++
            }
        }
        return result
    }

    private fun extract(s: String, _idx: Int): String {
        val redundant = s[_idx] - '0'
        var string = ""

        var result = ""
        var idx = _idx + 1
        val stack = Stack<Char>()
        stack.push(s[idx++])
        while (stack.isNotEmpty()) {
            val char = s[idx]
            if (char.isDigit()) {
                string += extract(s, idx)
                val length = getLength(s, idx + 1)
                idx += length
            } else if (char == ']') {
                stack.pop()
            } else if (char.isLetter()) {
                string += char
            }
            idx++
        }
        for (red in 1..redundant) {
            result = string + result
        }
        return result
    }

    private fun getLength(s: String, i: Int): Int {
        var length = 1
        var idx = i
        val stack = Stack<Char>()
        stack.push(s[idx++])
        while (stack.isNotEmpty()) {
            if (s[idx++] == ']')
                stack.pop()
            length++
        }
        return length
    }
}

fun main() {
    val solution = Solution()
    println(solution.decodeString("2[abc]3[cd]ef"
    ))
}