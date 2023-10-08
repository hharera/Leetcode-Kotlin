package com.harera.leetcode.leetcode227

import kotlin.math.max
import kotlin.math.min

class Solution {

    fun calculate(string: String): Int {
        var s: String = string.replace(" ", "")

        var leftNum: String = ""
        var rightNum: String = ""

        var start: Int = 0
        var end: Int = 0

        var idx: Int = 0
        var op: Char? = null

        while (idx < s.length) {
            start = min(start, idx)
            end = max(end, idx)
            if (s.get(idx).isDigit()) {
                if (op == null) {
                    leftNum += s.get(idx)
                } else {
                    rightNum += s.get(idx)
                }
            } else if (s.get(idx) == '*' || s.get(idx) == '/') {
                if (op == null) {
                    op = s.get(idx)
                } else {
                    val result = calculate(op, leftNum, rightNum)
                    s = s.replaceRange(start, end, result.toString())
                    leftNum = result.toString()
                    op = null
                    rightNum = ""
                    idx = 0
                }
            } else {
                start = idx + 1
                leftNum = ""
                rightNum = ""
                op = null
            }
            idx++
        }

        if (op != null) {
            val result = calculate(op, leftNum, rightNum)
            s = s.replaceRange(start, end + 1, result.toString())
        }

        idx = 0
        start = 0
        end = 0
        leftNum = ""
        rightNum = ""
        op = null

        while (idx < s.length) {
            start = min(start, idx)
            end = max(end, idx)
            val char = s[idx]
            if (char.isDigit()) {
                if (op == null) {
                    leftNum += char
                } else {
                    rightNum += char
                }
            } else {
                if (op == null) {
                    op = char
                } else {
                    val result = calculate(op, leftNum, rightNum)
                    s = s.replaceRange(start, end, result.toString())
                    leftNum = result.toString()
                    op = null
                    rightNum = ""
                    idx = 0
                }
            }
            idx++
        }

        if (op != null) {
            val result = calculate(op, leftNum, rightNum)
            s = s.replaceRange(start, end, result.toString())
        }

        return s.toInt()
    }

    private fun calculate(operator: Char, leftNum: String, rightNum: String): Int {
        return when (operator) {
            '+' -> {
                leftNum.toInt() + rightNum.toInt()
            }

            '-' -> {
                leftNum.toInt() - rightNum.toInt()
            }

            '*' -> {
                leftNum.toInt() * rightNum.toInt()
            }

            '/' -> {
                leftNum.toInt() / rightNum.toInt()
            }

            else -> {
                0
            }
        }
    }
}

fun main() {
    val solution = Solution()
    solution.calculate(
        "3+2*2"
    ).let {
        println(it)
    }
}