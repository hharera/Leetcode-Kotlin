package com.harera.leetcode.leetcode191


class Solution {

    fun hammingWeight(n: Long): Int {
        val bits = toBinary(n, 32).toCharArray()

        return bits.count {
            it == '1'
        }
    }

    private fun toBinary(value : Long, len: Long): String {
        return String.format("%" + len + "s", value.toString(2)).replace(" ".toRegex(), "0")
    }
}

fun main() {
    val solution = Solution()
    println(solution.hammingWeight(2))
}
