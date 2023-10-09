package com.harera.leetcode.leetcode199

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {

    fun rightSideView(root: TreeNode?): List<Int> {
        val result = arrayListOf<Int>()
        rightSideView(root, 0, result)
        return result
    }

    fun rightSideView(root: TreeNode?, depth: Int, result: ArrayList<Int>) {
        if (root == null) {
            return
        }

        if (depth == result.size) {
            result.add(root.`val`)
        }

        rightSideView(root.right, depth + 1, result)
        rightSideView(root.left, depth + 1, result)
    }
}

fun main() {
    println(Solution().rightSideView(
        TreeNode(1).apply {
            left = TreeNode(2).apply {
            }
        }
    ).toString())
}
