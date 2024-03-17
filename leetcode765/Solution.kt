package com.harera.leetcode.leetcode765

class Solution {
    fun minSwapsCouples(row: IntArray): Int {
        val n = row.size
        var swaps = 0
        var i = 0
        while (i < n) {
            val couple = if (row[i] % 2 == 0) row[i] + 1 else row[i] - 1
            if (row[i + 1] != couple) {
                swaps++
                for (j in i + 1 until n) {
                    if (row[j] == couple) {
                        row[j] = row[i + 1]
                        row[i + 1] = couple
                        break
                    }
                }
            }
            i += 2
        }
        return swaps
    }
}

fun main() {
    val solution = Solution()
    println(
        solution.minSwapsCouples(
            intArrayOf(0, 2, 1, 3)
        )
    )
}