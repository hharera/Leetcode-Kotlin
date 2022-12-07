package com.harera.leetcode.leetcode150

import java.util.*

class Solution {
    fun evalRPN(tokens: Array<String>): Int {
        val numbers = Stack<Int>()
        tokens.forEach {
            if (it == "+" || it == "-" || it == "*" || it == "/") {
                val right = numbers.pop()
                val left = numbers.pop()
                numbers.add(calculate(left, right, it))
            } else {
                numbers.add(it.toInt())
            }
        }
        return numbers.pop()
    }

    private fun calculate(left: Int, right: Int, operand: String): Int {
        return when (operand) {
            "+" -> left + right
            "-" -> left - right
            "*" -> left * right
            "/" -> left / right
            else -> 0
        }
    }
}

fun main() {
    println(Solution().evalRPN(arrayOf("10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+")))
}