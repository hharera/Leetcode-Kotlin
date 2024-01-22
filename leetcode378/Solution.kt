package com.harera.leetcode.leetcode378

class Solution {
    fun kthSmallest(matrix: Array<IntArray>, k: Int): Int {
        val n = matrix.size
        if (n == 1)
            return matrix[0][0]

        val commutativeArray = Array(n * 2) { 0 }
        for (idx in 1 until n) {
            commutativeArray[idx] = idx
            commutativeArray[n * 2 - idx] = idx
        }
        commutativeArray[n] = n
        for (idx in 1..commutativeArray.lastIndex) {
            commutativeArray[idx] = commutativeArray[idx - 1] + commutativeArray[idx]
        }

        var diagonal: Int = 0
        for (idx in 1..commutativeArray.lastIndex) {
            if (commutativeArray[idx] >= k) {
                diagonal = idx
                break
            }
        }
        if (diagonal <= n) {
            var row = 0
            var col = diagonal - 1
            val list = mutableListOf<Int>()
            while (col >= 0 && row < n) {
                list.add(matrix[row][col])
                row++
                col--
            }
            list.sort()
            return list[k - commutativeArray[diagonal - 1] - 1]
        } else {
            var row = diagonal - n
            var col = n - 1
            val list = mutableListOf<Int>()
            while (row >= 0 && col >= 0 && row < n && col < n) {
                list.add(matrix[row][col])
                row++
                col--
            }
            list.sort()
            return list[k - commutativeArray[diagonal - 1] - 1]
        }
    }
}

fun main() {
    // 5 test cases
    val solution = Solution()
//    [[1,5,9],[10,11,13],[12,13,15]]
//    8
//    println(
//        solution.kthSmallest(
//            Array(3) { IntArray(3) { 0 } }.also {
//                it[0][0] = 1
//                it[0][1] = 5
//                it[0][2] = 9
//                it[1][0] = 10
//                it[1][1] = 11
//                it[1][2] = 13
//                it[2][0] = 12
//                it[2][1] = 13
//                it[2][2] = 15
//            }, 8
//        )
//    )

//    [[1,2],[1,3]]
//    1
    println(
        solution.kthSmallest(
            Array(2) { IntArray(2) { 0 } }.also {
                it[0][0] = 1
                it[0][1] = 2
                it[1][0] = 1
                it[1][1] = 3
            }, 1
        )
    )
}