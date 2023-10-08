package com.harera.leetcode.leetcode8


class Solution {
    fun myAtoi(s: String): Int {
        var answer = 0
        var holdNum = ""
        var holdSign = "+"
        var holdNegative = "0"

        for (idx in s.indices) {
            val it = s.get(idx)

            if (it.isLowerCase()) {
                break
            }

            if (it == ' ' || it == '.') {
                if (holdNum.isBlank()) {
                    holdSign = "+"
                } else {
                    if (holdNum.length > 10 || holdNum.toBigInteger() >= Int.MAX_VALUE.toBigInteger()) {
                        holdNum = Int.MAX_VALUE.toString()
                        holdNegative = "1"
                    }
                    answer = if (holdSign == "+")
                        answer + holdNum.toInt()
                    else
                        answer - holdNum.toInt() - holdNegative.toInt()
                    holdSign = "+"
                    holdNum = ""
                    holdNegative = "0"
                }
                continue
            }

            if (it.isDigit()) {
                holdNum = holdNum.plus(it)
                continue
            }

            holdSign = it.toString()

        }
        if (holdNum.isNotBlank()) {
            if (holdNum.length > 10 || holdNum.toBigInteger() >= Int.MAX_VALUE.toBigInteger()) {
                holdNum = Int.MAX_VALUE.toString()
                holdNegative = "1"
            }
            answer = if (holdSign == "+")
                answer + holdNum.toInt()
            else
                answer - holdNum.toInt() - holdNegative.toInt()
        }
        return answer
    }
}

fun main() {
    val solution = Solution()
    println(solution.myAtoi("-91283472332"))
}