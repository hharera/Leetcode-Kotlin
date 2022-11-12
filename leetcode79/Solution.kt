package com.harera.leetcode.leetcode79

class Solution {
    fun exist(board: Array<CharArray>, word: String): Boolean {
        if (board.isEmpty() || board[0].isEmpty()) return false
        if (word.isEmpty()) return true
        val booleanArray = Array(board.size) { BooleanArray(board[0].size) }
        for (i in board.indices) {
            for (j in board[0].indices) {
                if (board[i][j] == word[0]) {
                    if (dfs(i, j, 0, word, board, booleanArray)) return true
                }
            }
        }
        return false
    }

    fun dfs(
        row: Int,
        col: Int,
        idx: Int,
        word: String,
        board: Array<CharArray>,
        visited: Array<BooleanArray>
    ): Boolean {
        if (idx == word.length) return true
        if (row < 0 || row >= board.size || col < 0 || col >= board[0].size) return false
        if (visited[row][col]) return false

        visited[row][col] = true
        if (board[row][col] == word[idx]) {
            if (dfs(row + 1, col, idx + 1, word, board, visited)) return true
            if (dfs(row - 1, col, idx + 1, word, board, visited)) return true
            if (dfs(row, col + 1, idx + 1, word, board, visited)) return true
            if (dfs(row, col - 1, idx + 1, word, board, visited)) return true
        }
        visited[row][col] = false
        return false
    }
}

fun main() {

    val board = arrayOf(
        charArrayOf('A', 'B', 'C', 'E'),
        charArrayOf('S', 'F', 'C', 'S'),
        charArrayOf('A', 'D', 'E', 'E')
    )

    val word = "ABCB"

    val solution = Solution()
    println(solution.exist(board, word))
}