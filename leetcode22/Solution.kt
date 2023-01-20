package com.harera.leetcode.leetcode22

import java.util.*


class Solution {

    private val solution = mutableListOf<String>()

    fun generateParenthesis(n: Int): List<String> {
        recursive(1, n * 2, "")
        return solution
    }

    private fun recursive(idx: Int, size: Int, str: String) {
        if (idx > size) {
            if (isValid(str))
                solution.add(str)
            return
        }

        recursive(idx + 1, size, str.plus("("))
        recursive(idx + 1, size, str.plus(")"))
    }

    private fun isValid(s: String): Boolean {
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
    println(solution.generateParenthesis(5))
}