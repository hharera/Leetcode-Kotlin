package com.harera.leetcode.leetcode394

import java.util.*

class Solution {

    fun decodeString(s: String): String {
        val redundant = Stack<Int>()
        val strings = Stack<String>()

        s.forEach {
            if (it.isDigit()) {
                strings.push("")
                redundant.push(it - '0')
            } else if (it == ']') {
                val curRedundant = redundant.pop()
                var curStr = StringBuilder()
                while (strings.size > redundant.size) {
                    curStr.append(strings.pop())
                }
                curStr = curStr.reverse()
                var resultStr = curStr.toString()
                for (i in 1 until curRedundant)
                    resultStr += curStr
                strings.push(resultStr)
            } else if (it != '[') {
                strings.push(strings.pop() + it)
            }
        }
        return strings.toList().joinToString(separator = "")
    }
}

fun main() {
    val solution = Solution()
    println(solution.decodeString("3[a2[c]]"))
}