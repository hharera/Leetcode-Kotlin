package com.harera.leetcode.leetcode378

class Solution {
    fun kthSmallest(matrix: Array<IntArray>, k: Int): Int {
        var idx = 0
        var total = 0
        val n = matrix.size
        while (idx <= n) {
            total += (2 * (n - idx) - 1)
            if (k <= total) {
                break
            }
            idx++
        }
        val list = mutableListOf<Int>()
        for (i in idx until n) {
            for (j in idx until n) {
                list.add(matrix[i][j])
            }
        }
        list.sort()
        if (idx == 0)
            return list[k - 1]

        return list[total - (2 * (n - idx + 1)) - 1]
    }
}

fun main() {
    // 5 test cases
    val solution = Solution()
    // [[1,3,5],[6,7,12],[11,14,14]]
    // 6
    println(solution.kthSmallest(Array(3) { IntArray(3) { 0 } }.also {
        it[0][0] = 1
        it[0][1] = 3
        it[0][2] = 5
        it[1][0] = 6
        it[1][1] = 7
        it[1][2] = 12
        it[2][0] = 11
        it[2][1] = 14
        it[2][2] = 14
    }, 6
    )
    )


//    [[1,5,9],[10,11,13],[12,13,15]]
//    1
    println(solution.kthSmallest(Array(3) { IntArray(3) { 0 } }.also {
        it[0][0] = 1
        it[0][1] = 5
        it[0][2] = 9
        it[1][0] = 10
        it[1][1] = 11
        it[1][2] = 13
        it[2][0] = 12
        it[2][1] = 13
        it[2][2] = 15
    }, 1
    )
    )

//    [[1,2],[1,3]]
//    1
    println(solution.kthSmallest(Array(2) { IntArray(2) { 0 } }.also {
        it[0][0] = 1
        it[0][1] = 2
        it[1][0] = 1
        it[1][1] = 3
    }, 1
    )
    )

    //[[-5]]
    //1
    println(solution.kthSmallest(Array(1) { IntArray(1) { 0 } }.also {
        it[0][0] = -5
    }, 1
    )
    )

    //[[1,3,5],[6,7,12],[11,14,14]]
    //3
    println(solution.kthSmallest(Array(3) { IntArray(3) { 0 } }.also {
        it[0][0] = 1
        it[0][1] = 3
        it[0][2] = 5
        it[1][0] = 6
        it[1][1] = 7
        it[1][2] = 12
        it[2][0] = 11
        it[2][1] = 14
        it[2][2] = 14
    }, 3
    )
    )
}