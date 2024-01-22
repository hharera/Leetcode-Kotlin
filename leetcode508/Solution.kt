package com.harera.leetcode.leetcode508

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun findFrequentTreeSum(root: TreeNode?): IntArray {
        return solve(root).groupBy { it.sum }.keys.toIntArray()
    }

    private fun solve(root: TreeNode?): List<Sum> {
        if (root == null)
            return emptyList()

        val result = mutableListOf<Sum>(Sum(root.`val`, false))
        val left = solve(root.left)
        val right = solve(root.right)
        val connectedLeft = left.filter { it.away.not() }
        val connectedRight = right.filter { it.away.not() }

        val next = connectedLeft + connectedRight
        next.filter { it.away.not() }.map {
            Sum(it.sum + root.`val`, false)
        }.also {
            result.addAll(it)
        }
        connectedLeft.forEach {
            connectedRight.forEach { right ->
                result.add(Sum(it.sum + right.sum + root.`val`, false))
                right.away = true
            }
            it.away = true
        }

        return result
    }

    class Sum(val sum: Int, var away: Boolean)
}

fun main() {
    val solution = Solution()
    val root = TreeNode(5)
    root.left = TreeNode(2)
    root.right = TreeNode(-3)
    println(solution.findFrequentTreeSum(root).toList())
}