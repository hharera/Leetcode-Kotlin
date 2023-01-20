package com.harera.leetcode.leetcode20

import java.util.*


class Solution {
    fun isValid(s: String): Boolean {
        val stack = Stack<Char>()
        s.forEach {
            if (it == '(' || it == '[' || it == '{') {
                stack.add(it)
            } else {
                if (it == ']')
                    if (stack.isEmpty() || stack.pop() != '[')
                        return false
                if (it == ')')
                    if (stack.isEmpty() || stack.pop() != '(')
                        return false
                if (it == '}')
                    if (stack.isEmpty() || stack.pop() != '{')
                        return false
            }
        }
        return stack.isEmpty()
    }
}

fun main(args: Array<String>) {
    val solution = Solution()
    println(solution.isValid("(())"))
}