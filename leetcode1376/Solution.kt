package com.harera.leetcode.leetcode1376

import kotlin.math.max

class Solution {

    var result = 0
    fun numOfMinutes(n: Int, headID: Int, manager: IntArray, informTime: IntArray): Int {
        val graph = Array<MutableList<Int>>(n) { mutableListOf() }

        manager.forEachIndexed { subordination, manager ->
            if (manager != -1)
                graph[manager].add(subordination)
        }

        dfs(graph, headID, informTime, 0)
        return result
    }

    private fun dfs(graph: Array<MutableList<Int>>, cur: Int, informTime: IntArray, ans: Int) {
        result = max(result, ans)
        graph[cur].forEach {
            dfs(graph, it, informTime, ans + informTime[cur])
        }
    }
}


fun main() {
    val solution = Solution()
//15
//0
//[-1,0,0,1,1,2,2,3,3,4,4,5,5,6,6]
//[1,1,1,1,1,1,1,0,0,0,0,0,0,0,0]
    println(solution.numOfMinutes(15, 0, intArrayOf(-1, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6), intArrayOf(1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0)))
}