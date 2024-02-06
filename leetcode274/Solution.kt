package com.harera.leetcode.leetcode274

class Solution {
    fun hIndex(citations: IntArray): Int {
        citations.sortDescending()
        for (h in 1000 downTo  1) {
            if(search(citations, h) >= h) {
                return h
            }
        }
        return 0
    }

    private fun search(citations: IntArray, h: Int): Int {
        var start = 0
        var end = citations.lastIndex
        while (start <= end) {
            val mid = (start + end) / 2
            if (citations[mid] >= h) {
                start = mid + 1
            } else {
                end = mid - 1
            }
        }
        return start
    }
}

fun main() {
    val solution = Solution()
    // [1,7,9,4]
    println(solution.hIndex(intArrayOf(1,7,9,4)))
}