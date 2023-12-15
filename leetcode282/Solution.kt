package com.harera.leetcode.leetcode282

import java.util.*

class Solution {
    fun addOperators(num: String, target: Int): List<String> {
        return solve(idx = 1, num, target)
    }

    private fun solve(idx: Int = 1, num: String, target: Int): List<String> {
        if (idx > num.lastIndex) {
            if (evaluate(num) == target) return listOf(num)
            return emptyList()
        }

        var result = listOf<String>()
        result += solve(idx + 2, num.substring(0, idx) + "*" + num.substring(idx, num.length), target)
        result += solve(idx + 2, num.substring(0, idx) + "+" + num.substring(idx, num.length), target)
        result += solve(idx + 2, num.substring(0, idx) + "-" + num.substring(idx, num.length), target)
        return result
    }

    private fun evaluate(expression: String): Int {
        val numbers = Stack<Int>()
        val ops = Stack<Char>()
        var value = ""
        for (c in expression) {
            if (c.isDigit()) {
                value += (c - '0')
            } else {
                numbers.push(value.toInt())
                value = ""
                if (ops.isNotEmpty()) {
                    val op = ops.pop()
                    val op1 = numbers.pop()
                    val op2 = numbers.pop()
                    when (op) {
                        '+' -> numbers.push(op1 + op2)
                        '-' -> numbers.push(op1 - op2)
                        '*' -> numbers.push(op1 * op2)
                        '/' -> numbers.push(op1 / op2)
                    }
                }
                ops.push(c)
            }
        }
        val op = ops.pop()
        val op1 = value.toInt()
        val op2 = numbers.pop()
        when (op) {
            '+' -> numbers.push(op1 + op2)
            '-' -> numbers.push(op1 - op2)
            '*' -> numbers.push(op1 * op2)
            '/' -> numbers.push(op1 / op2)
        }
        return numbers.pop()
    }
}

fun main() {
    val solution = Solution()
    println(solution.addOperators("123", 6))

}