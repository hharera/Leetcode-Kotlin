package com.harera.leetcode.leetcode224

import java.util.Stack

class Solution {
    fun calculate(s: String): Int {
        val expression = infixToPostfix(s.replace(" ", ""))
        return evaluate(expression)
    }

    private fun evaluate(expression: String): Int {
        val stack = Stack<Int>()
        for (c in expression) {
            if (c.isDigit()) {
                stack.push(c - '0')
            } else {
                val op2 = stack.pop()
                val op1 = stack.pop()
                when (c) {
                    '+' -> stack.push(op1 + op2)
                    '-' -> stack.push(op1 - op2)
                    '*' -> stack.push(op1 * op2)
                    '/' -> stack.push(op1 / op2)
                }
            }
        }
        return stack.pop()
    }

    private fun infixToPostfix(expression: String): String {
        val stack = Stack<Char>()
        var result = ""

        for (c in expression) {
            when {
                c.isLetterOrDigit() -> result += c
                c == '(' -> stack.push(c)
                c == ')' -> {
                    while (stack.isNotEmpty() && stack.peek() != '(') {
                        result += stack.pop()
                    }
                    stack.pop()
                }

                else -> {
                    while (!stack.isEmpty() && priority(c) <= priority(stack.peek())) {
                        result += stack.pop()
                    }
                    stack.push(c)
                }
            }
        }

        while (!stack.isEmpty()) {
            if (stack.peek() == '(') {
                return "Invalid expression"
            }
            result += stack.pop()
        }

        return result
    }

    private fun priority(operator: Char): Int {
        return when (operator) {
            '+', '-' -> 1
            '*', '/' -> 2
            '^' -> 3
            else -> -1
        }
    }
}

fun main() {
    println(Solution().calculate("(1+(4+5+2)-3)+(6*8)"))
}