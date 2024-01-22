package com.harera.leetcode.leetcode734

import java.util.*
import kotlin.math.max

class Solution {

    private val graph = Array(105) { ArrayList<Edge>() }
    private val time = Array(105) { Int.MAX_VALUE }

    fun networkDelayTime(times: Array<IntArray>, n: Int, k: Int): Int {
        times.forEach {
            graph[it[0]].add(Edge(it[1], it[2]))
        }

        time[k] = 0
        val priorityQueue = PriorityQueue<Int>()
        priorityQueue.add(k)
        while (priorityQueue.isNotEmpty()) {
            val node = priorityQueue.poll()
            graph[node].forEach {
                if (time[node] + it.weight < time[it.to]) {
                    time[it.to] = time[node] + it.weight
                    priorityQueue.add(it.to)
                }
            }
        }

        var result = Int.MIN_VALUE
        (1..n).forEach {
            result = max(time[it], result)
        }
        if(result == Int.MAX_VALUE)
            return -1
        return result
    }

    class Edge(val to: Int, val weight: Int)
}

fun main() {
    val solution = Solution()
    println(
        solution.networkDelayTime(
            arrayOf(
                intArrayOf(1,2,1),
            ), 2, 1
        )
    )
}