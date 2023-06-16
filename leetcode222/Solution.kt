package com.harera.leetcode.leetcode22

import java.util.*


class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun countNodes(root: TreeNode?): Int {
        if (root == null)
            return 0

        return 1 + countNodes(root.left) + countNodes(root.right)
    }
}

fun main(args: Array<String>) {
    val solution = Solution()
    println(solution.generateParenthesis(5))
}