package LeetCode1252

internal class Solution {
    fun oddCells(n: Int, m: Int, indices: Array<IntArray>): Int {
        val rows = IntArray(n)
        val cols = IntArray(m)
        val grid = Array(n) { IntArray(m) }
        for (i in indices.indices) {
            rows[indices[i][0]]++
            cols[indices[i][1]]++
        }
        for (i in rows.indices) {
            for (j in 0 until m) {
                grid[i][j] += rows[i]
            }
        }
        for (i in 0 until m) {
            for (j in 0 until n) {
                grid[j][i] += cols[i]
            }
        }
        var ans = 0
        for (i in 0 until n) {
            for (j in 0 until m) {
                if (grid[i][j] % 2 != 0) {
                    ans++
                }
            }
        }
        return ans
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val grid = arrayOf(intArrayOf(0, 1), intArrayOf(1, 1))
            println(Solution().oddCells(2, 3, grid))
        }
    }
}