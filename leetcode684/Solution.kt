package com.harera.leetcode.leetcode684

class Solution {

    private val graph = Array<ArrayList<Int>>(1005) { ArrayList() }

    fun findRedundantConnection(edges: Array<IntArray>): IntArray {
        edges.forEach {
            graph[it[0]].add(it[1])
            graph[it[1]].add(it[0])
        }

        edges.reversed().forEach {
            graph[it[0]].remove(it[1])
            graph[it[1]].remove(it[0])
            val visited = BooleanArray(1005)
            if (solve(latest = null, current = it[0], visited).not() && visited.count { it } == edges.size) {
                return it
            }
            graph[it[0]].add(it[1])
            graph[it[1]].add(it[0])
        }
        throw Exception()
    }

    private fun solve(latest: Int?, current: Int, visited: BooleanArray): Boolean {
        visited[current] = true

        for (it in graph[current]) {
            if (latest == it)
                continue
            if (visited[it])
                return true
            solve(current, it, visited)
        }
        return false
    }
}

fun main() {
    val solution = Solution()
    println(
        solution.findRedundantConnection(
            arrayOf(
                intArrayOf(1, 2),
                intArrayOf(1, 3),
                intArrayOf(2, 3)
            )
        ).contentToString()
    )

//    [[1,2],[2,3],[3,4],[1,4],[1,5]]
    println(
        solution.findRedundantConnection(
            arrayOf(
                intArrayOf(1, 2),
                intArrayOf(2, 3),
                intArrayOf(3, 4),
                intArrayOf(1, 4),
                intArrayOf(1, 5)
            )
        ).contentToString()
    )
}