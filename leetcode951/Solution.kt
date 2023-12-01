package com.harera.leetcode.leetcode951

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {

    fun flipEquiv(root1: TreeNode?, root2: TreeNode?): Boolean {
        return equals(root1, root2)
    }

    private fun equals(root1: TreeNode?, root2: TreeNode?): Boolean {
        if (root1 == null) {
            return root2 == null
        }
        if (root2 == null) {
            return false
        }

        if (root1.`val` != root2.`val`)
            return false

        return (equals(root1.left, root2.left) && equals(root1.right, root2.right) ||
                equals(root1.left, root2.right) && equals(root1.right, root2.left))
    }
}

fun main() {
    val solution = Solution()
    val root1 = TreeNode(1)
    root1.left = TreeNode(2)
    root1.right = TreeNode(3)
    root1.left!!.left = TreeNode(4)
    root1.left!!.right = TreeNode(5)
    root1.left!!.right!!.left = TreeNode(7)
    root1.left!!.right!!.right = TreeNode(8)
    root1.right!!.left = TreeNode(6)

    val root2 = TreeNode(1)
    root2.left = TreeNode(3)
    root2.right = TreeNode(2)
    root2.right!!.left = TreeNode(4)
    root2.right!!.right = TreeNode(5)
    root2.right!!.right!!.left = TreeNode(8)
    root2.right!!.right!!.right = TreeNode(7)
    root2.left!!.right = TreeNode(6)

    solution.flipEquiv(root1, root2).also {
        println(it)
    }
}
