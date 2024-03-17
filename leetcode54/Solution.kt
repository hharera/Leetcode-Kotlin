//package com.harera.leetcode.leetcode54
//
//import com.harera.leetcode.leetcode54_V2.Solution
//import java.nio.file.Files.move
//
//
//class Solution {
//
//    private val movements = arrayOf(
//        arrayOf(0, 1),
//        arrayOf(1, 0),
//        arrayOf(0, -1),
//        arrayOf(-1, 0)
//    )
//
//    private val visited = Array<BooleanArray>(105) { BooleanArray(105) }
//
//    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
//        move(row = 0, col = 0, matrix, move = 0)
//    }
//
//    fun move(row: Int, col: Int, matrix: Array<IntArray>, move: Int) {
//        if (row < 0 || row >= matrix.size || col < 0 || col >= matrix[0].size || visited[row][col]) {
//            return
//        }
//        visited[row][col] = true
//        println(matrix[row][col])
//        move(row + movements[move][0], col + movements[move][1], matrix, move)
//    }
//}
//
//fun main() {
//    val matrix = arrayOf(
//        intArrayOf(1, 2, 3),
//        intArrayOf(4, 5, 6),
//        intArrayOf(7, 8, 9)
//    )
//
//    val solution = Solution()
//    println(solution.spiralOrder(matrix))
//}