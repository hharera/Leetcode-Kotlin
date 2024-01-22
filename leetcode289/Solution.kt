package com.harera.leetcode.leetcode289

class Solution {

    private val movements = arrayOf(
        intArrayOf(0, 1),
        intArrayOf(0, -1),
        intArrayOf(1, 0),
        intArrayOf(-1, 0),
        intArrayOf(1, 1),
        intArrayOf(1, -1),
        intArrayOf(-1, 1),
        intArrayOf(-1, -1),
    )

    fun gameOfLife(board: Array<IntArray>): Unit {
        val newBoard = Array<IntArray>(board.size) { IntArray(board[0].size) }
        for (row in board.indices) {
            for (col in board[row].indices) {
                newBoard[row][col] = getCellState(board, row, col)
            }
        }

        for (row in board.indices) {
            for (col in board[row].indices) {
                board[row][col] = newBoard[row][col]
            }
        }
    }

    private fun getCellState(board: Array<IntArray>, row: Int, col: Int): Int {
        var live = 0
        var dead = 0
        for (it in movements) {
            val newRow = row + it[0]
            val newCol = col + it[1]
            if (newRow < 0 || newRow > board.lastIndex || newCol < 0 || newCol > board[row].lastIndex)
                continue

            if (board[newRow][newCol] == 1)
                live++
            else
                dead++
        }

        if (board[row][col] == 1 && (live < 2 || live > 3))
            return 0
        else if (board[row][col] == 0 && live == 3)
            return 1

        return board[row][col]
    }
}