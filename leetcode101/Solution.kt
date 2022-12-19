package com.harera.leetcode.leetcode101


class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {

    fun isSymmetric(root: TreeNode?): Boolean {
        if (root == null)
            return true

       return search(root.left, root.right)
    }

    private fun search(left: TreeNode?, right: TreeNode?): Boolean {
        if (left == null && right == null)
            return true
        var leftVal: Int? = null
        if (left != null) {
            leftVal = left.`val`
        }
        var rightVal: Int? = null
        if (right != null) {
            rightVal = right.`val`
        }
        return (leftVal == rightVal) && search(left?.right, right?.left) &&
                search(left?.left, right?.right)
    }
}

fun main() {
    val solution = Solution()
    println(
        solution.isSymmetric(
            TreeNode(1).apply {
                left = TreeNode(2).apply {
                    left = TreeNode(3)
                    right = TreeNode(4)
                }
                right = TreeNode(2).apply {
                    left = TreeNode(4)
                    right = TreeNode(3)
                }
            }
        )
    )
}