package com.harera.leetcode.leetcode752

import kotlin.math.abs
import kotlin.math.min

class Solution {

    private val dp = Array(10) { Array(10) { Array(10) { Array(10) { -1 } } } }

    fun openLock(deadends: Array<String>, target: String): Int {
        return solve(deadends.toSet(), start = "0000", target, visited = HashSet<String>())
    }

    private fun solve(deadends: Set<String>, start: String, target: String, visited: HashSet<String>): Int {
        if (target == start) {
            println(start)
            return 0
        }
        if (deadends.contains(start)) return -1

        if (visited.contains(start)) return -1
        visited.add(start)

        var min = Int.MAX_VALUE
        for (idx in 0..3) {
            val plus = (start[idx] - '0' + 1) % 10
            val minus = (start[idx] - '0' + 9) % 10
            if (start[idx] - '0' < target[idx] - '0') {
                val plusSol =
                    solve(deadends, start.substring(0, idx) + plus + start.substring(idx + 1, 4), target, visited)
                if (plusSol != -1) min = min(min, 1 + plusSol)
            }

            if (start[idx] - '0' > target[idx] - '0') {
                val minusSol =
                    solve(deadends, start.substring(0, idx) + minus + start.substring(idx + 1, 4), target, visited)
                if (minusSol != -1) min = min(min, 1 + minusSol)
            }
        }
        return if (min == Int.MAX_VALUE) -1 else min
    }
}

fun main() {
    println(Solution().openLock(arrayOf("0201", "0101", "0102", "1212", "2002"), "0202"))
//    println(Solution().openLock(arrayOf("8888"), "0009"))
//    println(Solution().openLock(arrayOf("8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"), "8888"))
}