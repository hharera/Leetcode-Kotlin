package com.harera.leetcode.leetcode171

class Solution {
    fun titleToNumber(columnTitle: String): Int {
        var result = 0
        columnTitle.reversed().forEachIndexed { index, c ->
            var curVal = Math.pow(26.toDouble(), index.toDouble()).toInt()
            curVal *= ((c - 'A') + 1)
            result += curVal
        }
        return result
    }
}

fun main() {
    println(
        Solution().titleToNumber("ZZZ")
    )
}