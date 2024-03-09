package com.harera.leetcode.leetcode957

class Solution {
    fun prisonAfterNDays(_cells: IntArray, n: Int): IntArray {
        val map = HashMap<String, Int>()
        val days = HashMap<Int, IntArray>()

        var cells = _cells.copyOf()
        if (n > 1000000) {
            var day = 1
            cells = next(cells)
            while (map.contains(cells.contentToString()).not()) {
                days[day] = cells
                map[cells.contentToString()] = day
                day++
                cells = next(cells)
            }
            val remaining = n % (day - 1)
            for (i in 1 until remaining) {
                cells = next(cells)
            }
            return cells
        } else {
            for (i in 1..n) {
                cells = next(cells)
                days[i] = cells
            }
            return days[n]!!
        }
    }
}

private fun next(_next: IntArray): IntArray {
//    println(_next.contentToString())
    val next = _next.copyOf()
    for (idx in 1 until next.lastIndex) {
        next[idx] = if (_next[idx - 1] == _next[idx + 1]) 1 else 0
    }
    next[0] = 0
    next[next.lastIndex] = 0
    return next
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
// Day 9: [0, 0, 1, 0, 0, 0, 0, 0]
// Day 10: [0, 0, 1, 0, 0, 0, 0, 0]
// Day 11: [0, 0, 1, 0, 1, 1, 1, 0]
// Day 12: [0, 0, 1, 1, 0, 1, 0, 0]
// Day 13: [0, 0, 0, 0, 1, 1, 0, 0]
// Day 14: [0, 1, 1, 0, 0, 0, 0, 0]
// Day 15: [0, 0, 0, 0, 1, 1, 1, 0]


fun main() {
    val solution = Solution()
    println(solution.prisonAfterNDays(intArrayOf(0, 1, 0, 1, 1, 0, 0, 1), 7).contentToString())
    println(solution.prisonAfterNDays(intArrayOf(1, 0, 0, 1, 0, 0, 1, 0), 1000000000).contentToString())
//    println(solution.prisonAfterNDays(intArrayOf(1, 0, 0, 1, 0, 0, 0, 1), 826).contentToString())
//    println(solution.prisonAfterNDays(intArrayOf(1, 0, 0, 1, 0, 0, 1, 0), 1000000000).contentToString())
    println(solution.prisonAfterNDays(intArrayOf(1, 1, 0, 1, 1, 0, 0, 1), 300663720).contentToString())
}