package com.harera.leetcode.leetcode166

class Solution {

    fun fractionToDecimal(numerator: Int, denominator: Int): String {
        val divResult = (numerator.toFloat() / denominator.toFloat())
        val fractionStr = divResult.toString().split(".")[1]

        if (fractionStr.toInt() == 0)
            return divResult.toInt().toString()

        if (fractionStr.length == 1)
            return divResult.toString()

        for (length in 1 until fractionStr.length) {
            if (check(fractionStr, length)) {
                return divResult.toString().split(".")[0].plus(".").plus("(${fractionStr.substring(0, length)})")
            }
        }
        return divResult.toString()
    }

    private fun check(fullFraction: String, length: Int): Boolean {
        var remaining = fullFraction
        val str = fullFraction.substring(0, length)
        while (remaining.isNotBlank()) {
            if (!remaining.contains(str))
                return false
            remaining = remaining.removeRange(0, length)
        }
        return true
    }
}

fun main() {
    println(Solution().fractionToDecimal(1, 6))
}