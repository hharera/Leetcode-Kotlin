package com.harera.leetcode.leetcode124_V2

import kotlin.math.max

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun maxPathSum(root: TreeNode?): Int {
        if (root == null)
            return 0

        return sum(root)
    }

    private fun sum(root: TreeNode?): Int {
        if (root == null)
            return Int.MIN_VALUE

        val left = sum(root.left)
        val right = sum(root.right)
        val cur = root.`val`

        var leftRight = Int.MIN_VALUE
        if (left < 0 || right < 0) {
            if (left > leftRight)
                leftRight = left
            if (right > leftRight)
                leftRight = right
        } else {
            leftRight = left + right
        }
        if (leftRight < 0)
            leftRight = 0

        var ans: Int
        if (cur <= 0) {
            ans = max(leftRight, cur)
        } else {
            ans = leftRight + cur
        }
        return ans
    }
}

fun main() {
    Solution().maxPathSum(
        TreeNode(-1).apply {
            left = TreeNode(-2)
            right = TreeNode(-3)
        }
    ).also {
        println(it)
    }
}