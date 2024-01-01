package com.harera.leetcode.leetcode1306

class Solution {

    private val visited = Array<Boolean>(500055) { false }
    fun canReach(arr: IntArray, start: Int): Boolean {
        return solve(arr, start)
    }

    private fun solve(arr: IntArray, start: Int): Boolean {
        if (start < 0 || start > arr.lastIndex)
            return false
        if (arr[start] == 0)
            return true
        if (visited[start])
            return false

        visited[start] = true
        return (solve(arr, start + arr[start]) ||
                solve(arr, start - arr[start])).also {
            visited[start] = false
        }
    }
}

fun main() {
    val solution = Solution()
    println(solution.canReach(intArrayOf(4, 2, 3, 0, 3, 1, 2), 5))
    println(solution.canReach(intArrayOf(4, 2, 3, 0, 3, 1, 2), 0))
    println(solution.canReach(intArrayOf(3, 0, 2, 1, 2), 2))
    println(solution.canReach(intArrayOf(0, 1), 2))
    println(solution.canReach(intArrayOf(2, 3, 1, 1, 4), 0))
}