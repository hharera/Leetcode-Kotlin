package com.harera.leetcode.leetcode124

import kotlin.math.max

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {

    private var globalMax = Int.MIN_VALUE

    fun maxPathSum(root: TreeNode?): Int {
        if (root == null)
            return 0

        sum(root)

        return globalMax
    }

    private fun sum(root: TreeNode?): Int {
        if (root == null)
            return 0

        val left = max(0, sum(root.left))
        val right = max(0, sum(root.right))
        val cur = root.`val`

        val localSum = cur + left + right
        globalMax = max(localSum, globalMax)

        val maxLocalPath = cur + max(left, right)
        return maxLocalPath
    }
}

fun main() {
    val solution = Solution()
    // write 5 test cases with results
    println(solution.maxPathSum(TreeNode(1).apply {
        left = TreeNode(2)
        right = TreeNode(3)
    }))
    println(solution.maxPathSum(TreeNode(-10).apply {
        left = TreeNode(9)
        right = TreeNode(20).apply {
            left = TreeNode(15)
            right = TreeNode(7)
        }
    }))
    println(solution.maxPathSum(TreeNode(2).apply {
        left = TreeNode(-1)
    }))
    println(solution.maxPathSum(TreeNode(-3)))
    println(solution.maxPathSum(TreeNode(1).apply {
        left = TreeNode(-2)
        right = TreeNode(3)
    }))
}