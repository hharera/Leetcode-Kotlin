package com.harera.leetcode.leetcode1306

import java.util.LinkedList

class Solution {

    private val visited = Array<Boolean>(500055) { false }
    fun canReach(arr: IntArray, start: Int): Boolean {
        return solve(arr, start)
    }

    private fun solve(arr: IntArray, start: Int): Boolean {
        if (start < 0 || start > arr.lastIndex)
            return false
        if (arr[start] == 0)
            return true
        if (visited[start])
            return false

        visited[start] = true
        return (solve(arr, start + arr[start]) ||
                solve(arr, start - arr[start])).also {
            visited[start] = false
        }
    }
}


// counting the number of substrings containing all the digits

fun countSubstringsContainingAllDigits(s: String): Int {
    val answers = HashMap<Int, Int>()
    var shortest = Int.MAX_VALUE
    for(i in s.indices) {
        val set = HashSet<Char>()
        for(j in i until s.length) {
            set.add(s[j])
            if(set.size == 10 && j - i + 1 <= shortest) {
                shortest = j - i + 1
                answers[shortest] = (answers[shortest] ?: 0) + 1
            }
        }
    }
    return answers[shortest]!!
}

// Sequential Avoidance path finding

fun sequentialAvoidancePathFinding(): Int {
    val (n, m) = readln().split(' ').map { it.toInt() }
    val matrix = Array(n) { readln().split(' ').map { it.toInt() }.toIntArray() }

    val dx = intArrayOf(1, 0, -1, 0)
    val dy = intArrayOf(0, 1, 0, -1)

    val cost = Array(n) { IntArray(m) { Int.MAX_VALUE } }
    val queue = LinkedList<Pair<Int, Int>>()
    queue.add(Pair(0, 0))
    cost[0][0] = 0

    while (queue.isNotEmpty()) {
        val (r, c) = queue.removeFirst()

        for (i in 0 until 4) {
            val nextRow = r + dx[i]
            val nextCol = c + dy[i]
            if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= m) {
                continue
            }
            if (cost[nextRow][nextCol] <= cost[r][c] + 1) {
                continue
            }
            cost[nextRow][nextCol] = cost[r][c] + 1

            if (matrix[nextRow][nextCol] == matrix[r][c] || matrix[nextRow][nextCol] - matrix[r][c] == 1) {
                continue
            }
            queue.add(Pair(nextRow, nextCol))
        }
    }
    if(cost[n - 1][m - 1] == Int.MAX_VALUE) {
        return -1
    }
    return cost[n - 1][m - 1]
}

fun main() {
    println(countSubstringsContainingAllDigits("0123456789100"))
}