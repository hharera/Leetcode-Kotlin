package com.harera.leetcode.leetcode261

class Solution {

    private lateinit var root: Array<Int>

    fun validTree(n: Int, edges: Array<IntArray>): Boolean {
        root = Array(n) { it }

        if (edges.size != n - 1) {
            return false
        }

        edges.forEach {
            if (union(it.first(), it.last()).not()) {
                return false
            }
        }
        return true
    }

    private fun find(node: Int): Int {
        if (root[node] == node) {
            return node
        }
        root[node] = find(root[node])
        return root[node]
    }

    private fun union(left: Int, right: Int): Boolean {
        val rightParent: Int = find(right)
        val leftParent: Int = find(left)
        if (rightParent != leftParent) {
            root[rightParent] = leftParent
            return true
        }
        return false
    }
}

fun main() {
    val solution = Solution()
    // write 5 test cases with results
    println(solution.validTree(5, arrayOf(intArrayOf(0, 1), intArrayOf(0, 2), intArrayOf(0, 3), intArrayOf(1, 4))))
    println(solution.validTree(5, arrayOf(intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(1, 3), intArrayOf(1, 4))))
    println(solution.validTree(5, arrayOf(intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(3, 4))))
    println(solution.validTree(5, arrayOf(intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(1, 3))))
    println(solution.validTree(5, arrayOf(intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(1, 3), intArrayOf(1, 4))))

    // result: true, false, false, false, true
}