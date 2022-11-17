package com.harera.leetcode.leetcode100


class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        return dfs(p, q)
    }

    private fun dfs(p: TreeNode?, q: TreeNode?): Boolean {
        if (p == null && q == null) {
            return true
        }

        if (p == null && q != null) {
            return false
        }
        if (p != null && q == null) {
            return false
        }

        if (p != null && q != null) {
            if (p.`val` != q.`val`)
                return false
        }

        return (dfs(p?.right, q?.right)).and(dfs(p?.left, q?.left))
    }
}

fun main() {
    val solution = Solution()
    println(solution.isSameTree(
        TreeNode(1).apply {
            left = TreeNode(2)
            right = TreeNode(2)
        },
        TreeNode(1).apply {
            left = TreeNode(2)
            right = TreeNode(3)
        }
    ))
}