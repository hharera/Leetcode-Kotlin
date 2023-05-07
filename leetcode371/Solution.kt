package com.harera.leetcode.leetcode371


class Solution {
    fun getSum(a: Int, b: Int): Int {
        var a = a
        var b = b
        while (b != 0) {
            val sum = a.xor(b)
            val carry = a.and(b).shl(1)
            a = sum
            b = carry
        }
        return a
    }
}

fun main() {
    val solution = Solution()
    println(solution.getSum(11, 3))
}
