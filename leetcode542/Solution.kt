package com.harera.leetcode.leetcode542

import java.util.*
import kotlin.math.abs

class Solution {

    private val movements = arrayOf(
        arrayOf(1, 0),
        arrayOf(-1, 0),
        arrayOf(0, 1),
        arrayOf(0, -1),
    )

    fun updateMatrix(mat: Array<IntArray>): Array<IntArray> {
        val answer = mutableListOf<IntArray>()
        for (row in mat.indices) {
            val intArr = IntArray(mat[row].size)
            for (col in mat[row].indices) {
                intArr[col] = calculateDistance(row, col, mat)
            }
            answer.add(intArr)
        }
        return answer.toTypedArray()
    }

    private fun calculateDistance(row: Int, col: Int, mat: Array<IntArray>): Int {
        val queue = LinkedList<Pair<Int, Int>>()
        queue.add(Pair(row, col))

        val visited = HashSet<Pair<Int, Int>>()
        visited.add(Pair(row, col))

        while (queue.isNotEmpty()) {
            val cur = queue.poll()
            if (cur.first < 0 || cur.first > mat.lastIndex || cur.second < 0 || cur.second > mat[0].lastIndex)
                continue
            if (mat[cur.first][cur.second] == 0)
                return calculateDistance(row, col, cur)

            movements.forEach {
                val next = Pair(row + it[0], col + it[1])
                if (!visited.contains(next)) {
                    queue.add(next)
                    visited.add(next)
                }
            }
        }
        return 1
    }

    private fun calculateDistance(row: Int, col: Int, mat: Pair<Int, Int>): Int {
        return abs(row - mat.first) + abs(col - mat.second)
    }
}

fun main() {
    val solution = Solution()
    println(
        solution.updateMatrix(
            arrayOf(
                intArrayOf(0, 0, 0),
                intArrayOf(0, 1, 0),
                intArrayOf(1, 1, 1),
            )
        ).contentDeepToString()
    )
}