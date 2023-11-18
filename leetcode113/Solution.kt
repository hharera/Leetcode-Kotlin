package com.harera.leetcode.leetcode113

class Solution {
    fun pathSum(root: TreeNode?, targetSum: Int): List<List<Int>> {
        return solve(node = root, remaining = targetSum, result = listOf<Int>())
    }
    private fun solve(node: TreeNode?, remaining: Int, result: List<Int>): List<List<Int>> {
        if (node == null)
            return emptyList()

        if (node.`val` == remaining) {
            if (node.left == null && node.right == null)
                return listOf(result.plus(node.`val`))
        }

        return solve(node.left, remaining - node.`val`, result.plus(node.`val`)) +
                solve(node.right, remaining - node.`val`, result.plus(node.`val`))
    }

}

fun main() {
    val solution = Solution()
    // [1,-2,-3,1,3,-2,null,-1]
    solution.pathSum(
        TreeNode(1).also {
            it.left = TreeNode(-2).also {
                it.left = TreeNode(1).also {
                    it.left = TreeNode(-1)
                }
                it.right = TreeNode(3)
            }
            it.right = TreeNode(-3).also {
                it.left = TreeNode(-2)
            }
        }, -1
    ).also {
        println(it)
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}
