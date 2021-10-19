package LeetCode221

import kotlin.math.max

fun main() {
    println('2'.toInt())
}

class Solution {

    fun maximalSquare(matrix: Array<CharArray>): Int {
        val comulativeSum = Array(matrix.size + 1) {
            IntArray(matrix[0].size + 1, { 0 })
        }

        for (idx in 0..matrix.lastIndex) {
            for (idx2 in 0..matrix[0].lastIndex) {
                comulativeSum[idx + 1][idx2 + 1] = matrix[idx][idx2] - '0'
                println(comulativeSum[idx + 1][idx2 + 1])
            }
        }

        for (idx in 1..comulativeSum.lastIndex) {
            for (idx2 in 1..comulativeSum[0].lastIndex) {
                comulativeSum[idx][idx2] += comulativeSum[idx][idx2 - 1]
            }
        }

        for (idx in 1..comulativeSum.lastIndex) {
            for (idx2 in 1..comulativeSum[0].lastIndex) {
                comulativeSum[idx][idx2] += comulativeSum[idx - 1][idx2]
            }
        }

        var ans = 0
        for (idx in 1..comulativeSum.lastIndex) {
            for (idx2 in 1..comulativeSum[0].lastIndex) {
                for (i in 1..301) {
                    val ones = countOnes(comulativeSum, idx + i, idx2 + i, i)
                    if (ones == (i + 1) * (i + 1) && ones > ans)
                        ans = ones
                }
            }
        }
        return ans
    }

    fun countOnes(comulativeSum: Array<IntArray>, idx: Int, idx2: Int, square: Int): Int {
        if (idx > comulativeSum.lastIndex || idx2 > comulativeSum[0].lastIndex)
            return -1

        return comulativeSum[idx][idx2] - comulativeSum[idx][idx2 - square - 1] - comulativeSum[idx - square - 1][idx2] + comulativeSum[idx - square - 1][idx2 - square - 1]
    }
}
