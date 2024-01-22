package com.harera.leetcode.leetcode935

class Solution {

    private val matrix = arrayOf(
        arrayOf(2, 2, 2),
        arrayOf(3, 0, 3),
        arrayOf(2, 2, 2),
        arrayOf(-1, 2, -1)
    )
    private val movements = arrayOf(
        arrayOf(-2, -1),
        arrayOf(-2, 1),
        arrayOf(-1, -2),
        arrayOf(-1, 2),
        arrayOf(1, -2),
        arrayOf(1, 2),
        arrayOf(2, -1),
        arrayOf(2, 1),
    )
    val visited = Array(4) { Array(3) { Array(5001) { -1 } } }

    fun knightDialer(n: Int): Int {
        var answer = 0
        for (row in 0..4) {
            for (col in 0..3) {
                answer += solve(n - 1, row, col) % 1000000007
                answer %= 1000000007
            }
        }
        return answer % 1000000007
    }

    private fun solve(remaining: Int, row: Int, col: Int): Int {
        if (row < 0 || col < 0 || row > 3 || col > 2 || matrix[row][col] == -1)
            return 0

        if (0 == remaining)
            return 1

        if (visited[row][col][remaining] != -1)
            return visited[row][col][remaining]

        var result = 0
        for (movement in movements) {
            val nextRow = row + movement[0]
            val nextCol = col + movement[1]
            result += (solve(remaining - 1, nextRow, nextCol) % 1000000007)
            result %= 1000000007
        }
        return (result % 1000000007).also {
            visited[row][col][remaining] = it
        }
    }
}

fun main() {
    val solution = Solution()
    println(solution.knightDialer(3131))
}