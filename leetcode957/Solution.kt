package com.harera.leetcode.leetcode957

class Solution {
    fun prisonAfterNDays(cells: IntArray, n: Int): IntArray {
        val map = HashMap<String, Int>()
        val days = HashMap<Int, IntArray>()
        next(cells)
        var _cells = cells.copyOf()
        next(cells)
        while (map.contains(_cells.contentToString()).not()) {
            days[map.size] = cells
            map[cells.contentToString()] = map.size
            next(cells)
        }
        val day = n % (map.size - 1)
        return days[day]!!
    }
}

private fun next(next: IntArray) {
//    println(next.contentToString())
    for (idx in 1 until next.lastIndex) {
        next[idx] = if (next[idx - 1] == next[idx + 1]) 1 else 0
    }
    next[0] = 0
    next[next.lastIndex] = 0
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
//    println(solution.prisonAfterNDays(intArrayOf(0, 1, 0, 1, 1, 0, 0, 1), 7).contentToString())
    println(solution.prisonAfterNDays(intArrayOf(1, 0, 0, 1, 0, 0, 1, 0), 1000000000).contentToString())
    println(solution.prisonAfterNDays(intArrayOf(1, 0, 0, 1, 0, 0, 0, 1), 826).contentToString())
    println(solution.prisonAfterNDays(intArrayOf(1, 0, 0, 1, 0, 0, 1, 0), 1000000000).contentToString())
}