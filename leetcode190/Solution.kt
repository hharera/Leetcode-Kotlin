package com.harera.leetcode.leetcode190

import java.lang.Integer.toUnsignedLong
import java.lang.Long.toBinaryString
import kotlin.math.pow

class Solution {

    fun reverseBits(n: Int): Int {
        val bits = toBinaryString(toUnsignedLong(n)).toCharArray()

        var answer = 0
        for (idx in 0..bits.lastIndex) {
            answer += (2.0.pow(idx) * (bits[idx].toInt())).toInt()
        }
        return answer
    }
}

fun main() {
    val solution = Solution()
    println(solution.reverseBits(7))
}
