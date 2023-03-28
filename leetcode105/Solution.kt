package com.harera.leetcode.leetcode105


class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {

    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        return solve(preorder, 0, preorder.lastIndex, inorder, 0, inorder.lastIndex)
    }

    private fun solve(
        preorder: IntArray,
        preStart: Int,
        preEnd: Int,
        inorder: IntArray,
        inStart: Int,
        inEnd: Int,
    ): TreeNode? {
        if (preStart > preEnd || inStart > inEnd)
            return null

        val value = preorder[preStart]
        val node = TreeNode(value)

        val inIdx = inorder.indexOf(value)
        val leftCount = inIdx - inStart

        node.left = solve(preorder, preStart + 1, preStart + leftCount, inorder, inStart, inIdx - 1)
        node.right = solve(preorder, preStart + 1 + leftCount, preEnd, inorder, inIdx + 1, inEnd)

        return node
    }
}

fun main() {
    val solution = Solution()
    val tree = solution.buildTree(intArrayOf(3, 9, 20, 15, 7), intArrayOf(9, 3, 15, 20, 7))
    println(tree)
}