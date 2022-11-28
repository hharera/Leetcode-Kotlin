package com.harera.leetcode.leetcode210

import java.util.*


class Solution {

    private lateinit var graph: Array<ArrayList<Int>>
    private lateinit var finished: Array<Boolean>

    private val taken = HashSet<Int>()

    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        graph = Array(numCourses) { arrayListOf<Int>() }
        finished = Array(numCourses) { false }

        prerequisites.forEach {
            graph[it.get(0)].add(it.get(1))
        }

        val orderSet = HashSet<Int>()
        val orderList = mutableListOf<Int>()

        for (course in 0 until numCourses) {
            val search = search(course, emptySet()) ?: return intArrayOf()
            search.forEach {
                if (orderSet.contains(it).not()) {
                    orderSet.add(it)
                    orderList.add(it)
                }
            }
        }
        return orderList.toIntArray()
    }

    private fun search(course: Int, history: Set<Int>): List<Int>? {
        if (finished[course])
            return arrayListOf()

        if (history.contains(course)) {
            return null
        }

        val answer = mutableListOf<Int>()
        for (idx in graph[course].indices) {
            val it = graph[course][idx]

            val search = search(it, history.plus(course)) ?: return null
            search.forEach {
                if (taken.contains(it).not()) {
                    answer.add(it)
                }
            }
        }
        answer.add(course)
        finished[course] = true
        return answer
    }
}

fun main() {
    //7
    //[[1,0],[0,3],[0,2],[3,2],[2,5],[4,5],[5,6],[2,4]]
    println(
        Arrays.toString(
            Solution().findOrder(
                7,
                arrayOf(
                    intArrayOf(1, 0),
                    intArrayOf(0, 3),
                    intArrayOf(0, 2),
                    intArrayOf(3, 2),
                    intArrayOf(2, 5),
                    intArrayOf(4, 5),
                    intArrayOf(5, 6),
                    intArrayOf(2, 4)
                )
            )
        )
    )
}