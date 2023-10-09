package com.harera.leetcode.leetcode207_v2


class Solution {

    private var root = Array<Int>(2005) { -1 }

    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        root.forEachIndexed { index, i ->
            root[index] = index
        }

        prerequisites.forEach {
            if (!union(it[0], it[1]))
                return false
        }

        return true
    }

    private fun find(value: Int): Int {
        if (root[value] == value)
            return value
        return find(root[value]).also {
            root[value] = it
        }
    }

    private fun union(value1: Int, value2: Int): Boolean {
        val root1 = find(value1)
        val root2 = find(value2)
        if (root1 == root2)
            return false
        root[root2] = root1
        return true
    }
}

fun main() {
    val solution = Solution()
    //[[1,4],[2,4],[3,1],[3,2]]
    println(solution.canFinish(4, arrayOf(intArrayOf(1, 4), intArrayOf(2, 4), intArrayOf(3, 1), intArrayOf(3, 2))))
}