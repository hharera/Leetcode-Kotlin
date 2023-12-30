package com.harera.leetcode.leetcode1038

class TreeNode(var `val`: Int = 0) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun bstToGst(root: TreeNode): TreeNode? {
        return solve(root)
    }

    private fun solve(root: TreeNode, sum: Int = 0): TreeNode? {
        if (root.right != null) {
            val right = solve(root.right!!)!!.`val`
            root.`val` += right
        }
        if (root.left != null) {
            root.left!!.`val` += root.`val`
            solve(root.left!!, root.`val`)
        }
        return root
    }
}