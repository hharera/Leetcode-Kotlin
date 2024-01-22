package com.harera.leetcode.leetcode1249

import java.util.*

class Solution {
    fun minRemoveToMakeValid(s: String): String {
        val sb = StringBuilder()
        val parentheses = Stack<Int>()
        for (char in s) {
            if (char == ')')
                if (parentheses.isEmpty())
                    continue
                else {
                    sb[parentheses.pop()] = '('
                    sb.append(')')
                }
            else if (char == '(') {
                sb.append('#')
                parentheses.push(sb.length - 1)
            } else
                sb.append(char)
        }
        return sb.toString().replace("#", "")
    }
}

fun main() {

}