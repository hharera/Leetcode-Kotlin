package com.harera.leetcode.leetcode1110

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun delNodes(root: TreeNode?, to_delete: IntArray): List<TreeNode?> {
        return solve(root, to_delete.toSet())
    }

    private fun solve(root: TreeNode?, toSet: Set<Int>): List<TreeNode?> {
        if (root == null)
            return emptyList()

        val result = (solve(root.right, toSet) + solve(root.left, toSet)).plus(root).toMutableList()

        val left = root.left
        if (toSet.contains(left?.`val`))
            root.left = null
        else if (!toSet.contains(root.`val`))
            result -= root.left

        val right = root.right
        if (toSet.contains(right?.`val`))
            root.right = null
        else if (!toSet.contains(root.`val`))
            result -= root.right

        if (toSet.contains(root.`val`))
            result.remove(root)
        return result
    }
}

fun main() {

}