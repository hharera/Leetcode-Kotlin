package com.harera.leetcode.leetcode172

class Solution {
    private val fractional = arrayOf(0, 1, 2, 6, 24)

    fun trailingZeroes(n: Int): Int {
        if (n < 5)
            return 0

        var lastTowDig = "1"
        var lastVal = fractional.last()
        for (num in 5 until  n) {
            var stringVal = (lastVal * num).toString();
            stringVal = stringVal.substring(stringVal.lastIndex - 1, stringVal.length)

        }
        return 0
    }
}

fun main() {
    println(
        Solution().trailingZeroes(3)
    )
}