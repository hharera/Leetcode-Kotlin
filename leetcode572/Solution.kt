package com.harera.leetcode.leetcode572

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {

    fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {
        return searchInTree(root, subRoot)
    }

    fun searchInSubTree(root: TreeNode?, subRoot: TreeNode?): Boolean {
        if (root == null && subRoot == null)
            return true

        if (root == null && subRoot != null)
            return false

        if (subRoot == null && root != null)
            return false

        if (root!!.`val` != subRoot!!.`val`)
            return false

        return true.and(
            searchInSubTree(root.right, subRoot.right)
        ).and(
            searchInSubTree(root.left, subRoot.left)
        )
    }

    fun searchInTree(root: TreeNode?, subRoot: TreeNode?): Boolean {
        if (root == null)
            return false

        return searchInSubTree(root, subRoot).or(
            searchInTree(root.left, subRoot)
        ).or(
            searchInTree(root.right, subRoot)
        )
    }
}

fun main() {
    val solution = Solution()
    solution.isSubtree(
        TreeNode(3).apply {
            left = TreeNode(4).apply {
                left = TreeNode(1)
                right = TreeNode(2)
            }
            right = TreeNode(5)
        },
        TreeNode(4).apply {
            left = TreeNode(1)
            right = TreeNode(2)
        }
    ).let {
        println(it)
    }
}
