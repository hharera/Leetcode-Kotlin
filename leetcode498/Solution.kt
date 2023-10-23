package com.harera.leetcode.leetcode498

class Solution {
    fun findDiagonalOrder(mat: Array<IntArray>): IntArray {
        return solve(mat = mat, row = 0, col = 0, upperDir = true, result = mutableListOf<Int>()).toIntArray()
    }

    private fun solve(
        mat: Array<IntArray>,
        row: Int,
        col: Int,
        upperDir: Boolean,
        result: MutableList<Int>
    ): MutableList<Int> {
        result.add(mat[row][col])

        if (row == mat.lastIndex && col == mat[0].lastIndex)
            return result

        if (upperDir) {
            if (col + 1 > mat[0].lastIndex) {
                solve(mat, row + 1, col, false, result)
            } else if (row - 1 < 0) {
                solve(mat, row, col + 1, false, result)
            } else {
                solve(mat, row - 1, col + 1, true, result)
            }
        } else {
            if (col - 1 < 0) {
                solve(mat, row, col + 1, true, result)
            } else if (row + 1 > mat.lastIndex) {
                solve(mat, row - 1, col + 2, true, result)
            } else {
                solve(mat, row + 1, col - 1, false, result)
            }
        }

        return result
    }
}

fun main() {
    val solution = Solution()
    // [[1,2,3],[4,5,6],[7,8,9]]
    // [[1,2],[3,4]]
    // [[1,2,3,4,5,6,7,8,9,10],[11,12,13,14,15,16,17,18,19,20],[21,22,23,24,25,26,27,28,29,30]]
    // [[1,2,3],[4,5,6],[7,8,9],[10,11,12]]
    // [[2,5],[8,4],[0,-1]]
    // [[1,2,3,4,5,6]]
    // [[1],[2],[3],[4],[5],[6]]
    // [[1,2,3,4,5,6,7,8,9,10],[11,12,13,14,15,16,17,18,19,20]]

    println(
        solution.findDiagonalOrder(arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6), intArrayOf(7, 8, 9)))
            .toMutableList()
    )
    println(solution.findDiagonalOrder(arrayOf(intArrayOf(1, 2), intArrayOf(3, 4))).toMutableList())
    solution.findDiagonalOrder(
        arrayOf(
            intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10),
            intArrayOf(11, 12, 13, 14, 15, 16, 17, 18, 19, 20),
            intArrayOf(21, 22, 23, 24, 25, 26, 27, 28, 29, 30)
        )
    )
}