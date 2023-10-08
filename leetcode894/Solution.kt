package com.harera.leetcode.leetcode894


class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {

    fun allPossibleFBT(n: Int): List<TreeNode?> {
        return solve(TreeNode(0), n)
    }

    private fun solve(head: TreeNode, n: Int): List<TreeNode?> {
        if (n % 2 == 0) {
            return emptyList()
        }
        if (n == 3) {
            return listOf(TreeNode(0).apply {
                left = TreeNode(0)
                right = TreeNode(0)
            })
        }
        if (n == 1)
            return listOf(TreeNode(0))

        val result = mutableListOf<TreeNode>()

        solve(head, n - 2).forEach {
            val leftHead = TreeNode(0)
            leftHead.left = TreeNode(0)
            leftHead.right = it
            result.add(leftHead)

            val rightHead = TreeNode(0)
            rightHead.right = TreeNode(0)
            rightHead.left = it
            result.add(rightHead)
        }

        solve(head, (n - 1) / 2).forEach {
            val node = TreeNode(0)
            node.left = it
            node.right = it
            result.add(node)
        }

        solve(head, n - ((n - 1) / 2)).forEach {
            val node = TreeNode(0)
            node.left = it
            node.right = it
            result.add(node)
        }

        return result
    }
}

fun main() {
    val toString = Solution().allPossibleFBT(7)
    println(toString)
}