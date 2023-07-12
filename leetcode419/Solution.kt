package com.harera.leetcode.leetcode419

class Solution {

    private val visited = Array<Array<Boolean>>(205) { Array(205) { false } }
    fun countBattleships(board: Array<CharArray>): Int {
        var answer = 0
        for (row in board.indices) {
            for (col in board[row].indices) {
                if (board[row][col] == 'X' && !visited[row][col]) {
                    dfs(board, row, col)
                    answer++
                }
            }
        }
        return answer
    }

    private fun dfs(board: Array<CharArray>, row: Int, col: Int) {
        if (row < 0 || col < 0 || row > board.lastIndex || col > board[0].lastIndex) {
            return
        }
        if (visited[row][col])
            return
        if (board[row][col] != 'X')
            return

        visited[row][col] = true

        dfs(board, row + 1, col)
        dfs(board, row - 1, col)
        dfs(board, row, col + 1)
        dfs(board, row, col - 1)
    }
}

