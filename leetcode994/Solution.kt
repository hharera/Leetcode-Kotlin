package com.harera.leetcode.leetcode994

class Solution {

    private val directions = arrayOf(
        intArrayOf(0, 1),
        intArrayOf(0, -1),
        intArrayOf(1, 0),
        intArrayOf(-1, 0)
    )

    fun orangesRotting(grid: Array<IntArray>): Int {
        val visited = Array(grid.size) { IntArray(grid[0].size) { -1 } }
        for (i in grid.indices) {
            for (j in grid[i].indices) {
                if (grid[i][j] == 2) {
                    solve(grid, visited, i, j)
                }
            }
        }
        if (grid.any { it.contains(1) })
            return -1
        return visited.map { it.max()!! }.max()!!
    }

    private fun solve(grid: Array<IntArray>, visited: Array<IntArray>, i: Int, j: Int, gen: Int = 0) {
        if (visited[i][j] != -1)
            return
        visited[i][j] = gen

        if (grid[i][j] == 1)
            grid[i][j] = 2

        for (it in directions) {
            val row = i + it[0]
            val col = j + it[1]
            if (row < 0 || row >= grid.size || col < 0 || col >= grid[row].size || grid[row][col] == 0)
                continue
            if (grid[row][col] == 2)
                continue
            solve(grid, visited, row, col, gen + 1)
        }
    }
}

fun main() {
    val solution = Solution()
    println(solution.orangesRotting(arrayOf(intArrayOf(2, 1, 1), intArrayOf(1, 1, 0), intArrayOf(0, 1, 1))))
    println(solution.orangesRotting(arrayOf(intArrayOf(2, 1, 1), intArrayOf(0, 1, 1), intArrayOf(1, 0, 1))))
    println(solution.orangesRotting(arrayOf(intArrayOf(1, 2))))
}