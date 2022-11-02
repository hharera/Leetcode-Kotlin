package LeetCode1329

import java.util.*

internal class Solution {
    fun diagonalSort(mat: Array<IntArray>): Array<IntArray> {
        for (i in mat.indices) {
            var ans: MutableList<point?> = arrayListOf()
            ans = collect(i, 0, mat.size, mat[i].size, ans, mat)
            Collections.sort(ans)
            for (an in ans) {
                mat[an!!.i][an.j] = an.`val`
            }
        }
        for (i in 1 until mat[0].size) {
            var ans: List<point?>
            ans = collect(0, i, mat.size, mat[0].size, arrayListOf(), mat)
            Collections.sort(ans)
            for (an in ans) {
                mat[an!!.i][an.j] = an.`val`
            }
        }
        return mat
    }

    fun collect(r: Int, c: Int, n: Int, m: Int, ans: MutableList<point?>, mat: Array<IntArray>): MutableList<point?> {
        if (r >= n || c >= m) {
            return ans
        }
        ans.add(point(r, c, mat[r][c]))
        return collect(r + 1, c + 1, n, m, ans, mat)
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            var mat = arrayOf(intArrayOf(3, 3, 1, 1), intArrayOf(2, 2, 1, 2), intArrayOf(1, 1, 1, 2))
            mat = Solution().diagonalSort(mat)
            for (i in mat.indices) {
                for (j in mat[0].indices) {
                    print(mat[i][j])
                }
                println("")
            }
        }
    }
}

internal class point(var i: Int, var j: Int, var `val`: Int) : Comparable<point?> {
    override fun compareTo(other: point?): Int {
        return `val` - other!!.`val`
    }
}