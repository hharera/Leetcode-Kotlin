package com.harera.leetcode.leetcode104



class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun maxDepth(root: TreeNode?): Int {
        if (root == null)
            return 0
        return dfs(root, 0)
    }

    fun dfs(node: TreeNode?, depth: Int): Int {
        if (node == null) {
            return depth
        }

        val left = dfs(node.right, depth + 1)
        val right = dfs(node.left, depth + 1)
        if (left > right)
            return left
        else
            return right
    }
}

fun main() {
    val solution = Solution()
    println(solution.maxDepth(
        TreeNode(3).apply {
            left = TreeNode(9)
            right = TreeNode(20).apply {
                left = TreeNode(15)
                right = TreeNode(7)
            }
        }
    ))
}