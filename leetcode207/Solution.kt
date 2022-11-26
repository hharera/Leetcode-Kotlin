package com.harera.leetcode.leetcode207


class Solution {

    lateinit var graph: Array<ArrayList<Int>>
    lateinit var finished: Array<Boolean>

    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        graph = Array(numCourses) { arrayListOf<Int>() }
        finished = Array(numCourses) { false }

        prerequisites.forEach {
            graph[it.get(0)].add(it.get(1))
        }

        graph.forEachIndexed { index, ints ->
            finished[index] = graph[index].isEmpty()
        }

        for (course in 0 until numCourses)
            if (!search(course, emptyList()))
                return false

        return true
    }

    private fun search(course: Int, history: List<Int>): Boolean {
        if (finished[course])
            return true

        if (history.contains(course)) {
            return false
        }

        graph[course].forEach {
            if (!search(it, history.plus(course)))
                return false
        }

        return true.also {
            finished[course] = true
        }
    }
}

fun main() {
    println(
        Solution().canFinish(
            2,
            arrayOf(
                intArrayOf(1, 0)
            )
        )
    )
}