package com.harera.leetcode.leetcode417

class Solution {

    private val dp = Array<Array<Array<Boolean>>>(200) { Array(200) { Array(2) { false } } }
    private val visited = Array<Array<Boolean>>(200) { Array(200) { false } }
    private val moves = arrayOf(arrayOf(0, 1), arrayOf(0, -1), arrayOf(1, 0), arrayOf(-1, 0))

    fun pacificAtlantic(heights: Array<IntArray>): List<List<Int>> {
        dp[0][heights[0].lastIndex] = arrayOf(true, true)
        dp[heights.lastIndex][0] = arrayOf(true, true)

        val m = heights.size
        val n = heights.first().size
        for (idx in 1 until heights.lastIndex) {
            dp[idx][0][0] = true
            dp[idx][n - 1][1] = true
        }
        for (idx in 1 until n - 1) {
            dp[0][idx][0] = true
            dp[m - 1][idx][1] = true
        }
        dp[0][0][0] = true
        dp[m - 1][n - 1][1] = true

        val result = HashSet<List<Int>>()
        result.add(listOf(0, heights[0].lastIndex))
        result.add(listOf(heights.lastIndex, 0))
        for (row in heights.indices) {
            for (col in heights[0].indices) {
                val ans = check(heights, row, col, row, col)
                if (ans[0] && ans[1]) {
                    result.add(listOf(row, col))
                }
            }
        }
        return result.toList()
    }

    private fun check(heights: Array<IntArray>, row: Int, col: Int, oRow: Int, oCol: Int): BooleanArray {
        if (row < 0 || col < 0 || row > heights.lastIndex || col > heights[0].lastIndex) {
            return booleanArrayOf(false, false)
        }
        if (heights[oRow][oCol] < heights[row][col]) {
            return booleanArrayOf(false, false)
        }
        if (visited[row][col]) {
            return booleanArrayOf(false, false)
        }

        var pacific = dp[row][col][0]
        var atlantic = dp[row][col][1]

        if (pacific && atlantic) {
            return booleanArrayOf(true, true)
        }

        moves.forEach {
            val nRow = it[0] + row
            val nCol = it[1] + col

            visited[row][col] = true
            val nArray = check(heights, nRow, nCol, row, col)
            visited[row][col] = false
            pacific = pacific || nArray[0]
            atlantic = atlantic || nArray[1]
        }

        dp[row][col][0] = pacific
        dp[row][col][1] = atlantic
        return booleanArrayOf(pacific, atlantic)
    }
}

fun main() {
    val solution = Solution()
    // write 5 test cases with results
    println(
        solution.pacificAtlantic(
            arrayOf(
                intArrayOf(1, 2, 2, 3, 5),
                intArrayOf(3, 2, 3, 4, 4),
                intArrayOf(2, 4, 5, 3, 1),
                intArrayOf(6, 7, 1, 4, 5),
                intArrayOf(5, 1, 1, 2, 4)
            )
        )
    )
    println(solution.pacificAtlantic(arrayOf(intArrayOf(1, 2, 3), intArrayOf(8, 9, 4), intArrayOf(7, 6, 5))))
    println(
        solution.pacificAtlantic(
            arrayOf(
                intArrayOf(1, 2, 3, 4),
                intArrayOf(12, 13, 14, 5),
                intArrayOf(11, 16, 15, 6),
                intArrayOf(10, 9, 8, 7)
            )
        )
    )
    println(
        solution.pacificAtlantic(
            arrayOf(
                intArrayOf(1, 2, 3, 4),
                intArrayOf(12, 13, 14, 5),
                intArrayOf(11, 16, 15, 6),
                intArrayOf(10, 9, 8, 7),
                intArrayOf(10, 9, 8, 7)
            )
        )
    )
    println(
        solution.pacificAtlantic(
            arrayOf(
                intArrayOf(1, 2, 3, 4),
                intArrayOf(12, 13, 14, 5),
                intArrayOf(11, 16, 15, 6),
                intArrayOf(10, 9, 8, 7),
                intArrayOf(10, 9, 8, 7),
                intArrayOf(10, 9, 8, 7)
            )
        )
    )

}
