package com.harera.leetcode.leetcode230


class TreeNode(var `val`: Int = 0) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {

    fun kthSmallest(root: TreeNode?, k: Int): Int {
        if (root == null)
            return 0

        return count(root, k, 0)
    }

    private fun search(root: TreeNode?, index: Int, target: Int): Int {
        if (index == target)
            return root!!.`val`

        if (target < index)
            return search(root?.left, index - 1, target)
        else
            return search(root?.right, index + 1, target)
    }

    private fun count(root: TreeNode?): Int {
        if (root == null)
            return 0

        return 1 + count(root.left) + count(root.right)
    }

    private fun count(root: TreeNode?, target: Int, rest: Int): Int {
        if (root == null)
            return 0

        val index = count(root.left) + 1 + rest
        if (index == target)
            return root.`val`

        if (target < index)
            return count(root.left, target, rest)
        else
            return count(root.right, target, index)
    }
}

fun main() {
    val solution = Solution()
    // [5,3,6,2,4,null,null,1], k = 3
    val root = TreeNode(5)
    root.left = TreeNode(3)
    root.right = TreeNode(6)
    root.left?.left = TreeNode(2)
    root.left?.right = TreeNode(4)
    root.left?.left?.left = TreeNode(1)
    println(solution.kthSmallest(root, 2))
}
