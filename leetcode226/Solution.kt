package com.harera.leetcode.leetcode226

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun invertTree(root: TreeNode?): TreeNode? {
        invert(root)
        return root
    }

    fun invert(node : TreeNode?) {
        if(node == null) return

        val left = node.left
        val right = node.right
        node.left = right
        node.right = left
        invert(left)
        invert(right)
    }
}

fun main() {
    val solution = Solution()
    solution.invertTree(
        TreeNode(4).apply {
            left = TreeNode(2).apply {
                left = TreeNode(1)
                right = TreeNode(3)
            }
            right = TreeNode(7).apply {
                left = TreeNode(6)
                right = TreeNode(9)
            }
        }
    ).also {
        println(it)
    }
}