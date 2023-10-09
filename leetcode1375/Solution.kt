package com.harera.leetcode.leetcode1375

import java.util.*


class Solution {

    fun numTimesAllBlue(flips: IntArray): Int {
        var bits = BitSet(flips.size + 1)
        bits[0] = 1
        var expectedBits = BitSet(flips.size + 1)
        expectedBits[0] = 1

        var ans = 0
        flips.forEachIndexed { index, bitIdx ->
            bits.flip(bitIdx)
            expectedBits.flip(index + 1)
            if (bits.equals(expectedBits))
                ans++
        }
        return ans
    }
}


fun main() {
    val solution = Solution()
    println(solution.numTimesAllBlue(intArrayOf(2, 1, 3, 5, 4)))
    println(solution.numTimesAllBlue(intArrayOf(3, 2, 4, 1, 5)))
    println(solution.numTimesAllBlue(intArrayOf(4, 1, 2, 3)))
}