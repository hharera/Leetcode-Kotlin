package com.harera.leetcode.leetcode794

class Solution {
    fun validTicTacToe(board: Array<String>): Boolean {
        return play(
            cur = arrayOf("   ", "   ", "   ").map { it.toCharArray() },
            target = board.map { it.toCharArray() },
            player = 'X'
        )
    }

    private fun play(cur: List<CharArray>, target: List<CharArray>, player: Char = 'X'): Boolean {
        if (cur == target)
            return true

        if (isEnd(cur))
            return false

        for (row in 0..2) {
            for (col in 0..2) {
                val temp = cur[row][col]
                if (cur[row][col] == ' ') {
                    cur[row][col] = player
                    if (play(cur, target, player = 'O')) {
                        return true
                    }
                    cur[row][col] = temp
                }
            }
        }
        return false
    }

    fun isEnd(board: List<CharArray>): Boolean {
        if (board.any { it.all { it == 'X' } })
            return true
        if (board.any { it.all { it == 'O' } })
            return true
        if ((board[0][0] == 'X' || board[0][0] == 'O')
            && board[0][0] == board[1][1]
            && board[1][1] == board[2][2]
        ) {
            return true
        }
        if (board.all { !it.contains(' ') })
            return true
        return false
    }
}

fun main() {
    val solution = Solution()
    println(solution.validTicTacToe(arrayOf("O  ", "   ", "   ")))
    println(solution.validTicTacToe(arrayOf("XOX", " X ", "   ")))
    println(solution.validTicTacToe(arrayOf("XXX", "   ", "OOO")))
    println(solution.validTicTacToe(arrayOf("XOX", "O O", "XOX")))
    println(solution.validTicTacToe(arrayOf("XOX", "OXO", "XOX")))
    println(solution.validTicTacToe(arrayOf("XXX", "XOO", "OO ")))
    println(solution.validTicTacToe(arrayOf("XOX", "OXO", "XOX")))
    println(solution.validTicTacToe(arrayOf("XOX", "OXO", "XOX")))
    println(solution.validTicTacToe(arrayOf("XOX", "OXO", "XOX")))
    println(solution.validTicTacToe(arrayOf("XOX", "OXO", "XOX")))
    println(solution.validTicTacToe(arrayOf("XOX", "OXO", "XOX")))
}