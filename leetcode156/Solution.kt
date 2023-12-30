package com.harera.leetcode.leetcode156

import java.util.*

class Solution {
    fun upsideDownBinaryTree(root: TreeNode?): TreeNode? {
        if (root == null) return null
        if (root.left == null)
            return root
        val stack = Stack<TreeNode>()
        val result = LinkedList<Int>()
        stack.push(root)
        while (stack.isNotEmpty()) {
            val node = stack.pop()
            result.push(node.`val`)
            val right = node.right
            if (right != null) {
                result.push(right.`val`)
            } else {
                result.push(-1)
            }
            val left = node.left
            if (left != null) {
                stack.push(left)
            }
        }
        if (result.peek() == -1)
            result.pop()

        val root = TreeNode(result.pop())
        var node = root
        while (result.isNotEmpty()) {
            node.left = createNode(result.pop())
            if (result.isNotEmpty()) {
                node.right = createNode(result.pop())
                node = node.right!!
            }
        }
        return root
    }

    private fun createNode(node: Int): TreeNode? {
        if (node == -1)
            return null
        return TreeNode(node)
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}


fun main() {
    val solution = Solution()
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.left!!.left = TreeNode(4)
    root.left!!.right = TreeNode(5)
    val result = solution.upsideDownBinaryTree(root)
    println(result)
}