package com.harera.leetcode.leetcode785

import java.util.*


class Solution {

    private lateinit var graphColor: Array<Boolean?>
    fun isBipartite(graph: Array<IntArray>): Boolean {
        val queue: Queue<Int> = LinkedList()
        graphColor = Array<Boolean?>(graph.size) { null }
//        queue.add(0)
//        graphColor[0] = true
        for (idx in graph.indices) {
            if (graphColor[idx] == null) {
                queue.add(idx)
                graphColor[idx] = true
            }
            while (queue.isNotEmpty()) {
                val cur = queue.poll()
                val nextColor = graphColor[cur]!!.not()

                graph[cur].forEach {
                    if (graphColor[it] == null) {
                        queue.add(it)
                        graphColor[it] = nextColor
                    } else if (graphColor[it] != nextColor) {
                        return false
                    }
                }
            }
        }
        return true
    }
}

fun main() {
    val solution = Solution()
    println(solution.isBipartite(arrayOf(intArrayOf(1, 3), intArrayOf(0, 2), intArrayOf(1, 3), intArrayOf(0, 2))))

    //Input: graph = [[1,2,3],[0,2],[0,1,3],[0,2]]
    //Output: false
    println(solution.isBipartite(arrayOf(intArrayOf(1, 2, 3), intArrayOf(0, 2), intArrayOf(0, 1, 3), intArrayOf(0, 2))))
}
