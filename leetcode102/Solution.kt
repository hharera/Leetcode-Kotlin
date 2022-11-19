package com.harera.leetcode.leetcode102

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}


class Solution {

    private val levels = mutableListOf<MutableList<Int>>()

    fun levelOrder(root: TreeNode?): List<List<Int>> {
        levels.add(ArrayList())
        traverse(root, 1)
        return levels.drop(1)
    }

    private fun traverse(root: TreeNode?, level: Int) {
        if (root == null)
            return

        if (levels.lastIndex < level) {
            levels.add(arrayListOf(root.`val`))
        } else {
            levels[level].add(root.`val`)
        }
        traverse(root.left, level + 1)
        traverse(root.right, level + 1)
    }
}

fun main() {
    val solution = Solution()
    println(
        solution.levelOrder(
            TreeNode(1).apply {
                left = TreeNode(2)
                right = TreeNode(2)
            },
        )
    )
}