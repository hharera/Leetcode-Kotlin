package com.harera.leetcode

import kotlin.math.abs

class Leetcode178 {
    fun main() {
        validTree(
            5, arrayOf(
                arrayOf(0, 1).toIntArray(),
                arrayOf(0, 2).toIntArray(),
                arrayOf(0, 3).toIntArray(),
                arrayOf(1, 4).toIntArray(),
                arrayOf(2, 4).toIntArray(),
            )
        ).let {
            println(it)
        }
    }

    fun validTree(n: Int, edges: Array<IntArray>): Boolean {
        val adjList = Array(n) { ArrayList<Int>() }

        edges.forEach {
            adjList[it[0]].add(it[1])
            adjList[it[1]].add(it[0])
        }

        val height = Array(n) { -1 }

        for (i in 0 until n) {
            if (height[i] == -1) {
                if (dfs(i, i, adjList, height).not()) {
                    return false
                }
            }
        }

        return true
    }


    fun dfs(cur: Int, prev: Int, adjList: Array<ArrayList<Int>>, height: Array<Int>): Boolean {
        if (cur != prev && height[cur] != -1)
            return abs(height[cur] - height[prev]) <= 1


        height[cur] = height[prev] + 1
        adjList[cur].forEach {
            if (dfs(it, cur, adjList, height).not()) {
                return false
            }
        }
        return true
    }
}