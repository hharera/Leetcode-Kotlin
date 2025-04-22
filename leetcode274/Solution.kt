package com.harera.leetcode.leetcode274

import java.lang.Integer.min

class Solution {
    fun hIndex(citations: IntArray): Int {
        citations.sortDescending()
        for (h in min(1000, citations.size) downTo 1) {
            if (search(citations, h)) {
                return h
            }
        }
        return 0
    }

    private fun search(citations: IntArray, h: Int): Boolean {
        return citations[h - 1] >= h
    }
}

fun main() {
    val solution = Solution()
    // [1,7,9,4]
    println(solution.hIndex(intArrayOf(1,7,9,4)))
}