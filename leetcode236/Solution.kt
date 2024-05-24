package com.harera.leetcode.leetcode236

import java.util.*

class Solution {

    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if (p == null || q == null || root == null)
            return null

        val ppath = getPath(root, p.`val`, Stack())
        val qpath = getPath(root, q.`val`, Stack())
        while (ppath.isNotEmpty() && qpath.isNotEmpty()) {
            if (ppath.peek().`val` == qpath.peek().`val`) {
                return ppath.pop()
            } else if (ppath.size > qpath.size) {
                ppath.pop()
            } else {
                qpath.pop()
            }
        }
        return root
    }

    private fun getPath(root: TreeNode, search: Int, path: Stack<TreeNode>): Stack<TreeNode> {
        path.add(root)

        if (search == root.`val`)
            return path

        if (root.left != null) {
            val left = getPath(root.left!!, search, path)
            if (left.peek().`val` != search) {
                left.pop()
            }
        }

        if (root.right != null) {
            val right = getPath(root.right!!, search, path)
            if (right.peek().`val` != search) {
                right.pop()
            }
        }
        return path
    }
}

class TreeNode(var `val`: Int = 0) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun main() {
    // [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
    val solution = Solution()
    solution.lowestCommonAncestor(
        TreeNode(3).apply {
            left = TreeNode(5).apply {
                left = TreeNode(6)
                right = TreeNode(2).apply {
                    left = TreeNode(7)
                    right = TreeNode(4)
                }
            }
            right = TreeNode(1).apply {
                left = TreeNode(0)
                right = TreeNode(8)
            }
        },
        TreeNode(5),
        TreeNode(4)
    ).let {
        println(it)
    }
}
