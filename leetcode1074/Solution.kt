package com.harera.leetcode.leetcode1074

class Solution {

    private val visited = HashMap<IntArray, Int>()

    private val movements = arrayOf(
        intArrayOf(-1, 0, 0, 0),
        intArrayOf(0, 1, 0, 0),
        intArrayOf(0, 0, -1, 0),
        intArrayOf(0, 0, 0, 1),
        intArrayOf(1, 1, 0, 0),
        intArrayOf(-1, -1, 0, 0),
        intArrayOf(0, 0, -1, -1),
        intArrayOf(0, 0, 1, 1),
    )

    fun numSubmatrixSumTarget(matrix: Array<IntArray>, target: Int): Int {
        var ans = 0
        for (row in 0..matrix.lastIndex)
            for (col in 0..matrix[0].lastIndex)
                ans += solve(matrix, submatrix = intArrayOf(col, col, row, row), target = target)
        return ans
    }

    private fun solve(matrix: Array<IntArray>, submatrix: IntArray, target: Int): Int {
        if (submatrix[0] < 0
            || submatrix[1] > matrix[0].lastIndex
            || submatrix[2] < 0
            || submatrix[3] > matrix.lastIndex
        ) return 0

        if (visited.contains(submatrix))
            return visited.getOrElse(submatrix) { 1 }

        var result = 0

        val submatrixSum = calculate(matrix, submatrix)
        if (submatrixSum == target)
            result += 1

        for (movement in movements) {
            val nextMatrix = submatrix
            for (idx in 0..3) {
                nextMatrix[idx] += movement[idx]
            }

            if (nextMatrix == intArrayOf(0, 1, 0, 1)) {
                println("sdfsf")
            }

            result += solve(matrix, nextMatrix, target)
        }
        return result.also {
            visited[submatrix] = it
        }
    }

    private fun calculate(matrix: Array<IntArray>, submatrix: IntArray): Int {
        var result = 0
        for (col in submatrix[0]..submatrix[1]) {
            for (row in submatrix[2]..submatrix[3]) {
                result += matrix[row][col]
            }
        }
        return result
    }
}

fun main() {
    val solution = Solution()
    println(
        solution.numSubmatrixSumTarget(
            arrayOf(
                intArrayOf(-1, 1),
                intArrayOf(1, -1),
            ), 0
        )
    )
}
