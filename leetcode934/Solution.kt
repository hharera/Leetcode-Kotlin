package com.harera.leetcode.leetcode934

class Solution {

    private var visited = Array(105) { BooleanArray(105) }
    private val moves = arrayOf(
        Pair(1, 0),
        Pair(-1, 0),
        Pair(0, 1),
        Pair(0, -1)
    )

    fun shortestBridge(grid: Array<IntArray>): Int {
        val _2row = grid.indexOfFirst {
            it.contains(1)
        }
        val _2col = grid[_2row].indexOfFirst {
            it == 1
        }
        markIsland(grid, _2row, _2col, 2)
        val _3row = grid.indexOfFirst {
            it.contains(1)
        }
        val _3col = grid[_3row].indexOfFirst {
            it == 1
        }
        markIsland(grid, _3row, _3col, 3)
        var distance = Int.MAX_VALUE
        for (row in grid.indices) {
            for (col in grid[0].indices) {
                if (grid[row][col] == 2) {
                    distance = minOf(distance, bfs(grid, row, col, 3))
                    visited = Array(105) { BooleanArray(105) }
                }
            }
        }
        return distance
    }

    private fun dfs(grid: Array<IntArray>, row: Int, col: Int, target: Int): Int {
        if (grid[row][col] == target) {
            return 0
        }

        var answer = Int.MAX_VALUE
        visited[row][col] = true
        for (move in moves) {
            val nextRow = row + move.first
            val nextCol = col + move.second
            if (nextRow < 0 || nextRow > grid.lastIndex || nextCol < 0 || nextCol > grid[0].lastIndex || visited[nextRow][nextCol]) {
                continue
            }
            if (grid[nextRow][nextCol] != target && grid[nextRow][nextCol] != 0) {
                continue
            }
            val result = dfs(grid, nextRow, nextCol, target)
            if (result != Int.MAX_VALUE) {
                answer = minOf(answer, result + if (grid[nextRow][nextCol] == 0) 1 else 0)
            }
        }
        visited[row][col] = false

        return answer
    }

    private fun bfs(grid: Array<IntArray>, row: Int, col: Int, target: Int): Int {
        if (grid[row][col] == target) {
            return 0
        }

        val queue = ArrayDeque<Pair<Pair<Int, Int>, Int>>()
        queue.add(Pair(Pair(row, col), 0))
        visited[row][col] = true
        while (queue.isNotEmpty()) {
            val (node, cost) = queue.removeFirst()
            val (r, c) = node
            for (move in moves) {
                val nextRow = r + move.first
                val nextCol = c + move.second
                if (nextRow < 0 || nextRow > grid.lastIndex || nextCol < 0 || nextCol > grid[0].lastIndex || visited[nextRow][nextCol]) {
                    continue
                }
                if (grid[nextRow][nextCol] == target) {
                    return cost
                }
                if (grid[nextRow][nextCol] != 0) {
                    continue
                }
                queue.add(Pair(Pair(nextRow, nextCol), cost + 1))
                visited[nextRow][nextCol] = true
            }
        }
        return Int.MAX_VALUE
    }

    private fun markIsland(grid: Array<IntArray>, row: Int, col: Int, color: Int) {
        if (row < 0 || row > grid.lastIndex
            || col < 0 || col > grid[0].lastIndex
            || grid[row][col] != 1
            || grid[row][col] == color
            || visited[row][col]
        ) {
            return
        }
        grid[row][col] = color
        markIsland(grid, row + 1, col, color)
        markIsland(grid, row - 1, col, color)
        markIsland(grid, row, col + 1, color)
        markIsland(grid, row, col - 1, color)
    }
}

fun main() {
    val solution = Solution()
//    println(
//        solution.shortestBridge(
//            arrayOf(
//                intArrayOf(0, 1),
//                intArrayOf(1, 0)
//            )
//        )
//    )

    println(
        solution.shortestBridge(
            arrayOf(
                intArrayOf(0, 1, 0),
                intArrayOf(0, 0, 0),
                intArrayOf(0, 0, 1)
            )
        )
    )

    println(
        solution.shortestBridge(
            arrayOf(
                intArrayOf(1, 1, 1, 1, 1),
                intArrayOf(1, 0, 0, 0, 1),
                intArrayOf(1, 0, 1, 0, 1),
                intArrayOf(1, 0, 0, 0, 1),
                intArrayOf(1, 1, 1, 1, 1)
            )
        )
    )

    println(
        solution.shortestBridge(
            arrayOf(
                intArrayOf(1, 1, 1, 1, 0, 0, 0),
                intArrayOf(0, 1, 0, 1, 0, 0, 0),
                intArrayOf(0, 0, 0, 0, 0, 0, 0),
                intArrayOf(1, 1, 1, 1, 0, 0, 0),
                intArrayOf(1, 1, 1, 0, 0, 0, 0),
                intArrayOf(0, 0, 0, 0, 0, 0, 0),
                intArrayOf(0, 0, 0, 0, 0, 0, 0)
            )
        )
    )
}