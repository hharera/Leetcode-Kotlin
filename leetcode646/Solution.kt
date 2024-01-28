package com.harera.leetcode.leetcode646

class Solution {
    fun findLongestChain(pairs: Array<IntArray>): Int {
        pairs.sortWith { o1, o2 ->
            if (o1[0] == o2[0])
                o1[1] - o2[1]
            else
                o1[0] - o2[0]
        }
        var answer = 0
        for (i in 0..pairs.lastIndex) {
            val pairs_ = mutableListOf(pairs[i])
            for (j in i + 1 .. pairs.lastIndex) {
                val last = pairs_.last()
                val pair = pairs[j]
                if (pair[0] > last[1]) {
                    pairs_.add(pair)
                }
            }
            answer = maxOf(answer, pairs_.size)
        }
        return answer
    }
}

fun main() {
    val solution = Solution()
//    println(solution.findLongestChain(arrayOf(intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(3, 4))))

    //[[7,9],[4,5],[7,9],[-7,-1],[0,10],[3,10],[3,6],[2,3]]
    // output: 4
    println(solution.findLongestChain(arrayOf(intArrayOf(7, 9), intArrayOf(4, 5), intArrayOf(7, 9), intArrayOf(-7, -1), intArrayOf(0, 10), intArrayOf(3, 10), intArrayOf(3, 6), intArrayOf(2, 3))))
}