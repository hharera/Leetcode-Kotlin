package com.harera.leetcode.leetcode498

class Solution {
    fun findDiagonalOrder(mat: Array<IntArray>): IntArray {
        val diagonal = mutableListOf<ArrayList<Int>>()
        for (diag in mat[0].indices) {
            var row = 0
            var col = diag
            val list = ArrayList<Int>()
            while (row < mat.size && col >= 0) {
                list.add(mat[row][col])
                row++
                col--
            }
            diagonal.add(list)
        }

        for (diag in 1 until mat.size) {
            var row = diag
            var col = mat[0].lastIndex
            val list = ArrayList<Int>()
            while (row < mat.size && col >= 0) {
                list.add(mat[row][col])
                row++
                col--
            }
            diagonal.add(list)
        }
        for (i in diagonal.indices) {
            if (i % 2 == 0)
                diagonal[i].reverse()
        }
        return diagonal.flatten().toIntArray()
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
    println(
        solution.findDiagonalOrder(
            arrayOf(
                intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10),
                intArrayOf(11, 12, 13, 14, 15, 16, 17, 18, 19, 20),
                intArrayOf(21, 22, 23, 24, 25, 26, 27, 28, 29, 30)
            )
        )
    )
}