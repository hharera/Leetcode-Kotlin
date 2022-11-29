package com.harera.leetcode.leetcode200

class Solution {

    private lateinit var visited: Array<IntArray>

    fun numIslands(grid: Array<CharArray>): Int {
        visited = Array(grid.size) {
            Array(
                grid[0].size
            ) { -1 }.toIntArray()
        }

        var answer = 0
        for (row in grid.indices) {
            for (col in grid[0].indices) {
                if (grid[row][col] == '1')
                    if (search(grid, row, col, answer)) {
                        answer++
                    }
            }
        }
        return answer
    }

    private fun search(
        grid: Array<CharArray>,
        row: Int,
        col: Int,
        islandIdx: Int
    ): Boolean {
        if (row < 0 || col < 0 || row > visited.lastIndex ||
            col > visited[0].lastIndex
        ) {
            return true
        }

        if (visited[row][col] != -1 && visited[row][col] != islandIdx)
            return false

        if (visited[row][col] != -1 && visited[row][col] == islandIdx)
            return true

        if (grid[row][col] == '0')
            return true

        visited[row][col] = islandIdx

        return search(grid, row - 1, col, islandIdx) &&
                search(grid, row + 1, col, islandIdx) &&
                search(grid, row, col - 1, islandIdx) &&
                search(grid, row, col + 1, islandIdx)
    }
}

fun main() {
//    [["1","1","0","0","0"],["1","1","0","0","0"],["0","0","1","0","0"],["0","0","0","1","1"]]
    println(
        Solution().numIslands(
            arrayOf(
                charArrayOf('1', '1', '0', '0', '0'),
                charArrayOf('1', '1', '0', '0', '0'),
                charArrayOf('0', '0', '1', '0', '0'),
                charArrayOf('0', '0', '0', '1', '1')
            )
        )
    )
}