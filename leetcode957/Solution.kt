package com.harera.leetcode.leetcode957

class Solution {
    fun prisonAfterNDays(_cells: IntArray, _n: Int): IntArray {
        val map = HashMap<Int, String>()

        var n = 0
        var cells = _cells
        while (n < 15) {
            cells = next(cells)
            map[n + 1] = cells.joinToString(",")
            n++
        }
        if (_n > 14) {
            n = _n % 14
            if (n == 0) n = 14
        } else {
            n = _n
        }
        return map[n]!!.split(",").map { it.toInt() }.toIntArray()
    }

    fun actualPrisonAfterNDays(_cells: IntArray, n: Int): IntArray {
        var cells = _cells
        for (idx in 0 until n) {
            cells = next(cells)
        }
        println(cells.joinToString(","))
        return cells
    }

    private fun next(next: IntArray): IntArray {
        val _next = next.copyOf()
        for (idx in 1 until _next.lastIndex) {
            _next[idx] = if (next[idx - 1] == next[idx + 1]) 1 else 0
        }
        _next[0] = 0
        _next[_next.lastIndex] = 0
        return _next
    }
}

// Day 0: [0, 1, 0, 1, 1, 0, 0, 1]
// Day 1: [0, 1, 1, 0, 0, 0, 0, 0]
// Day 2: [0, 0, 0, 0, 1, 1, 1, 0]
// Day 3: [0, 1, 1, 0, 0, 1, 0, 0]
// Day 4: [0, 0, 0, 0, 0, 1, 0, 0]
// Day 5: [0, 1, 1, 1, 0, 1, 0, 0]
// Day 6: [0, 0, 1, 1, 0, 0, 0, 0]
// Day 7: [0, 0, 0, 0, 0, 1, 1, 0]
// Day 8: [0, 1, 1, 1, 0, 0, 0, 0]
// Day 9: [0, 0, 1, 0, 1, 1, 0, 0]
// Day 10: [0, 0, 1, 1, 0, 1, 0, 0]
// Day 11: [0, 0, 0, 0, 1, 1, 1, 0]
// Day 12: [0, 1, 1, 0, 0, 0, 0, 0]
// Day 13: [0, 0, 0, 0, 1, 1, 0, 0]
// Day 14: [0, 1, 1, 1, 0, 1, 0, 0]

fun main() {
    val solution = Solution()
    if (solution.actualPrisonAfterNDays(
            intArrayOf(1, 0, 0, 1, 0, 0, 1, 0), 9999999
        ).contentEquals(
            solution.prisonAfterNDays(
                intArrayOf(1, 0, 0, 1, 0, 0, 1, 0), 9999999
            )
        )
    ) {
        println("true")
    } else {
        println("false")
    }
//    println(solution.prisonAfterNDays(intArrayOf(1, 0, 0, 1, 0, 0, 1, 0), 1000000000).contentToString())
//    println(solution.prisonAfterNDays(intArrayOf(1, 0, 0, 1, 0, 0, 0, 1), 826).contentToString())
//    println(solution.prisonAfterNDays(intArrayOf(1, 0, 0, 1, 0, 0, 1, 0), 1000000000).contentToString())
//    println(solution.prisonAfterNDays(intArrayOf(1, 1, 0, 1, 1, 0, 0, 1), 300663720).contentToString())
}
